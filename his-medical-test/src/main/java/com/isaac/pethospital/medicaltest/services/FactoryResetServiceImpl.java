package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateItemEntity;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;
    private final ReportTemplateRepository reportTemplateRepository;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService, ReportTemplateRepository reportTemplateRepository) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.reportTemplateRepository = reportTemplateRepository;
    }

    @Transactional
    @Override
    public void reset() {
        this.cleanDb();
        this.init();
    }

    @Override
    public void insertData() {

        ReportTemplateEntity reportTemplateEntity = new ReportTemplateEntity();
        reportTemplateEntity.setReportName("血常规");

        addReportItem("红细胞计数(RBC)", "10^12/L", "4.0", "5.5", reportTemplateEntity);
        addReportItem("红细胞压积(HCT)", "%", "40", "50", reportTemplateEntity);
        addReportItem("平均红细胞体积(MCV)", "fL", "80", "100", reportTemplateEntity);
        addReportItem("红细胞分布宽度", "%", "10", "16", reportTemplateEntity);
        addReportItem("血红蛋白浓度(HGB)", "g/L", "120", "160", reportTemplateEntity);

        this.reportTemplateRepository.save(reportTemplateEntity);

    }

    private void addReportItem(String name, String unit, String lowerLimit, String upperLimit, ReportTemplateEntity reportTemplateEntity) {

        ReportTemplateItemEntity reportTemplateItemEntity1 = new ReportTemplateItemEntity();
        reportTemplateItemEntity1.setItemName(name);
        reportTemplateItemEntity1.setItemUnit(unit);
        reportTemplateItemEntity1.setReferenceHighLimitValue(lowerLimit);
        reportTemplateItemEntity1.setReferenceLowLimitValue(upperLimit);

        reportTemplateEntity.addReportTemplateItem(reportTemplateItemEntity1);
    }

    @Transactional
    void cleanDb() {

        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();

        this.reportTemplateRepository.deleteAll();
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("MedicalTest");
        authorizationTopicService.addAuthorizationTopicAndOperations("化验设置", "操作");

    }


}
