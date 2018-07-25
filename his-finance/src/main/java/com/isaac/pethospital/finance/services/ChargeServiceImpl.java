package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.finance.ReportOperationMessage;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.entities.ChargeItemEntity;
import com.isaac.pethospital.finance.entities.PriceEntity;
import com.isaac.pethospital.common.enums.ChargeStatusEnum;
import com.isaac.pethospital.finance.repositories.ChargeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class ChargeServiceImpl extends AbstractCrudService<ChargeEntity, ChargeOperationRequest> implements ChargeService<ChargeEntity, ChargeOperationRequest> {

    private final PriceService priceService;
    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public ChargeServiceImpl(PriceService priceService, ChargeRepository chargeRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        super(chargeRepository);
        this.priceService = priceService;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
    }

    @Override
    public ChargeEntity create(ChargeOperationRequest request) {
        return null;
    }

    @Override
    public ChargeEntity update(ChargeOperationRequest request) {
        return null;
    }


    @Override
    public ChargeReportOperationReplyMessage onGenerateChargeOrderReceived(ChargeReportOperationMessage message) {

        //receive the message
        //generate charge order

        ChargeEntity chargeEntity = new ChargeEntity();
        chargeEntity.setTreatmentCaseUuid(message.getTreatmentCaseUuid());
        chargeEntity.setCreatedDate(LocalDateTime.now());
        chargeEntity.setPetUuid(message.getPetUuid());
        chargeEntity.setPetOwnerUuid(message.getPetOwnerUuid());
        chargeEntity.setStatus(ChargeStatusEnum.UNPAID);
        BigDecimal totalAmount = new BigDecimal(0);

        for (int i = 0; i < message.getReportOperationMessages().size(); i++) {
            ReportOperationMessage rom = message.getReportOperationMessages().get(i);
            ChargeItemEntity cie = new ChargeItemEntity();
            PriceEntity pe = priceService.findByUuid(rom.getReportTemplateUuid());
            if (pe == null)
                throw new RuntimeException("Cannot find price");
            cie.setPrice(pe);
            cie.setAmount(pe.getMemberPrice());
            totalAmount = totalAmount.add(pe.getMemberPrice());
            cie.setChargeItemUuid(rom.getReportUuid());
            chargeEntity.addChargeItem(cie);
        }

        chargeEntity.setTotalAmount(totalAmount);
        ChargeEntity chargeEntity1 = jpaRepository.save(chargeEntity);

        //send event out
        ChargeReportOperationReplyMessage replyMessage = new ChargeReportOperationReplyMessage();
        replyMessage.setStatus(ChargeStatusEnum.UNPAID);
        replyMessage.setPetOwnerUuid(chargeEntity1.getPetOwnerUuid());
        replyMessage.setPetUuid(chargeEntity1.getPetUuid());
        replyMessage.setTreatmentCaseUuid(chargeEntity1.getTreatmentCaseUuid());
        replyMessage.setReportUuidList(chargeEntity1.getChargeItems().stream().map(i -> i.getChargeItemUuid()).collect(Collectors.toList()));
        return replyMessage;
        //jmsSender.sendEvent(this.jmsProperties.getFinanceChargeItemOperationReplyTopic(), replyMessage);


    }
}
