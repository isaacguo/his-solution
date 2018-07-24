package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.jms.finance.ChargeItemOperationMessage;
import com.isaac.pethospital.common.enums.ChargeEventEnum;
import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.repositories.ChargeRepository;
import org.springframework.stereotype.Service;

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
        ChargeEntity chargeEntity = request.toCharge(priceService);
        chargeEntity = jpaRepository.save(chargeEntity);

        ChargeItemOperationMessage message = new ChargeItemOperationMessage();
        message.setChargeEventEnum(ChargeEventEnum.CREATED);
        message.setTreatmentCaseUuid(chargeEntity.getTreatmentCaseUuid());
        chargeEntity.getChargeItems().forEach(r -> {
            message.addReportUuid(r.getUuid());
        });
        this.jmsSender.sendEvent(this.jmsProperties.getFinanceChargeItemOperationQueue(), message);
        return chargeEntity;
    }

    @Override
    public ChargeEntity update(ChargeOperationRequest request) {
        return null;
    }


}
