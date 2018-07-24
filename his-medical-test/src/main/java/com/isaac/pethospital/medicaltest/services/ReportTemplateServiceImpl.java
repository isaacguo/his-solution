package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.jms.finance.PriceItemOperationMessage;
import com.isaac.pethospital.common.enums.OperationEnum;
import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final ReportTemplateRepository reportTemplateRepository;
    private final ReportTemplateCategoryService reportTemplateCategoryService;
    private final HanyuPinyinConverter converter;
    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;
    private final AuthorizationService authorizationService;

    public ReportTemplateServiceImpl(ReportTemplateRepository reportTemplateRepository, ReportTemplateCategoryService reportTemplateCategoryService, HanyuPinyinConverter converter, JmsSender jmsSender, JmsProperties jmsProperties, AuthorizationService authorizationService) {
        this.reportTemplateRepository = reportTemplateRepository;
        this.reportTemplateCategoryService = reportTemplateCategoryService;
        this.converter = converter;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
        this.authorizationService = authorizationService;
    }

    @Override
    public ReportTemplateEntity createReportTemplate(ReportTemplateOperationRequest request) {
        ReportTemplateEntity reportTemplateEntity = request.toReport(this.converter);

        ReportTemplateCategoryEntity category = this.reportTemplateCategoryService.findOne(request.getCategoryId());
        if (category == null)
            throw new RuntimeException("Category is null");

        ReportTemplateEntity rte = this.reportTemplateRepository.findByReportNameEquals(reportTemplateEntity.getReportName());
        if (rte != null)
            throw new RuntimeException("The Report with the same name has existed");

        reportTemplateEntity.setUuid(UUID.randomUUID().toString());
        reportTemplateEntity.setCategory(category);
        rte = reportTemplateRepository.save(reportTemplateEntity);
        onPriceItemCreated(rte);
        return rte;
    }

    private void onPriceItemCreated(ReportTemplateEntity reportTemplateEntity) {

        PriceItemOperationMessage priceItemOperationMessage = new PriceItemOperationMessage();
        priceItemOperationMessage.setOperationEnum(OperationEnum.CREATE);
        priceItemOperationMessage.setUuid(reportTemplateEntity.getUuid());
        priceItemOperationMessage.setSource(this.authorizationService.getDomainName());

        jmsSender.sendEvent(this.jmsProperties.getFinancePriceItemOperationQueue(), priceItemOperationMessage);
    }

    @Override
    public ReportTemplateEntity updateReportTemplate(ReportTemplateOperationRequest request) {
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("Id is null");
        ReportTemplateEntity reportTemplateEntity = reportTemplateRepository.findOne(id);
        if (reportTemplateEntity == null)
            throw new RuntimeException("Cannot find ReportTemplate");


        String uuid = reportTemplateEntity.getUuid();
        ReportTemplateCategoryEntity category = reportTemplateEntity.getCategory();
        ReportTemplateEntity newReportTemplateEntity = request.toReport(this.converter);

        newReportTemplateEntity.setUuid(uuid);
        newReportTemplateEntity.setCategory(category);


        reportTemplateRepository.delete(reportTemplateEntity);
        return reportTemplateRepository.save(newReportTemplateEntity);


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
