package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.common.enums.OperationEnum;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.jms.JmsProperties;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final ReportTemplateRepository reportTemplateRepository;
    private final HanyuPinyinConverter converter;
    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;
    private final AuthorizationService authorizationService;

    public ReportTemplateServiceImpl(ReportTemplateRepository reportTemplateRepository, HanyuPinyinConverter converter, JmsSender jmsSender, JmsProperties jmsProperties, AuthorizationService authorizationService) {
        this.reportTemplateRepository = reportTemplateRepository;
        this.converter = converter;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
        this.authorizationService = authorizationService;
    }

    @Override
    public ReportTemplateEntity createReportTemplate(ReportTemplateOperationRequest request) {
        ReportTemplateEntity reportTemplateEntity = request.toReport(this.converter);

        ReportTemplateEntity rte = this.reportTemplateRepository.findByReportNameEquals(reportTemplateEntity.getReportName());
        if (rte != null)
            throw new RuntimeException("The Report with the same name has existed");

        reportTemplateEntity.setUuid(UUID.randomUUID().toString());
        rte = reportTemplateRepository.save(reportTemplateEntity);
        onChargeItemCreated(rte);
        return rte;
    }

    private void onChargeItemCreated(ReportTemplateEntity reportTemplateEntity) {
        ChargeItemOperationMesassge chargeItemOperationMesassge = new ChargeItemOperationMesassge();
        chargeItemOperationMesassge.setOperationEnum(OperationEnum.CREATE);
        chargeItemOperationMesassge.setUuid(reportTemplateEntity.getUuid());
        chargeItemOperationMesassge.setSource(this.authorizationService.getDomainName());

        jmsSender.sendEvent(this.jmsProperties.getFinanceChargeItemOperationQueue(), chargeItemOperationMesassge);
    }

    @Override
    public ReportTemplateEntity updateReportTemplate(ReportTemplateOperationRequest request) {
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("Id is null");
        ReportTemplateEntity reportTemplateEntity = reportTemplateRepository.findOne(id);
        if (reportTemplateEntity == null)
            throw new RuntimeException("Cannot find ReportTemplate");
        reportTemplateRepository.delete(reportTemplateEntity);

        return this.createReportTemplate(request);

    }

    @Override
    public List<ReportTemplateEntity> findTemplateByNameContains(String name) {
        return this.reportTemplateRepository.findByReportNameHanYuPinYinContains(name);
    }

    @Override
    public List<ReportTemplateEntity> findAll() {
        return this.reportTemplateRepository.findAll();
    }

    @Override
    public ReportTemplateEntity findById(Long rid) {
        return this.reportTemplateRepository.findOne(rid);
    }

    @Override
    public boolean deleteById(Long rid) {
        this.reportTemplateRepository.delete(rid);
        return true;
    }

}
