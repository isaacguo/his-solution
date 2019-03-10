package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateInfoEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateItemEntity;
import com.isaac.pethospital.medicaltest.enums.ReportSectionEnum;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateCategoryRepository;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;
    private final ReportTemplateRepository reportTemplateRepository;
    private final HanyuPinyinConverter converter;
    private final ReportTemplateCategoryRepository reportTemplateCategoryRepository;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService, ReportTemplateRepository reportTemplateRepository, HanyuPinyinConverter converter, ReportTemplateCategoryRepository reportTemplateCategoryRepository) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.reportTemplateRepository = reportTemplateRepository;
        this.converter = converter;
        this.reportTemplateCategoryRepository = reportTemplateCategoryRepository;
    }

    @Transactional
    @Override
    public void reset() {
        this.cleanDb();
        this.init();
    }

    @Override
    public void insertData() {

        /*
        ReportTemplateCategoryEntity category=new ReportTemplateCategoryEntity();
        category.setName("常规检查");


        ReportTemplateEntity reportTemplateEntity = new ReportTemplateEntity();
        reportTemplateEntity.setUuid(UUID.randomUUID().toString());
        reportTemplateEntity.setReportName("血常规");
        reportTemplateEntity.setReportNameHanYuPinYin(converter.toHanyuPinyin(reportTemplateEntity.getReportName()));

        addReportItem("红细胞计数(RBC)", "10^12/L", "4.0", "5.5", reportTemplateEntity);
        addReportItem("红细胞压积(HCT)", "%", "40", "50", reportTemplateEntity);
        addReportItem("平均红细胞体积(MCV)", "fL", "80", "100", reportTemplateEntity);
        addReportItem("红细胞分布宽度", "%", "10", "16", reportTemplateEntity);
        addReportItem("血红蛋白浓度(HGB)", "g/L", "120", "160", reportTemplateEntity);

        addReportInfoItem("宠物名字", reportTemplateEntity);
        addReportInfoItem("主人姓名", reportTemplateEntity);
        addReportInfoItem("宠物年龄", reportTemplateEntity);
        addReportInfoItem("宠物性别", reportTemplateEntity);
        addReportInfoItem("申请科室", reportTemplateEntity);
        addReportInfoItem("送检医师", reportTemplateEntity);
        addReportInfoItem("临床诊断", reportTemplateEntity);

        category.addReportTemplate(reportTemplateEntity);


        this.reportTemplateCategoryRepository.save(category);

         */

    }

    private void addReportInfoItem(String key, ReportTemplateEntity reportTemplateEntity) {
        ReportTemplateInfoEntity reportTemplateInfoEntity = new ReportTemplateInfoEntity();
        reportTemplateInfoEntity.setReportSection(ReportSectionEnum.HEADER);
        reportTemplateInfoEntity.setReportKey(key);
        reportTemplateEntity.addReportTemplateInfo(reportTemplateInfoEntity);
    }

    private void addReportItem(String name, String unit, String lowerLimit, String upperLimit, ReportTemplateEntity reportTemplateEntity) {

        ReportTemplateItemEntity reportTemplateItemEntity1 = new ReportTemplateItemEntity();
        reportTemplateItemEntity1.setItemName(name);
        reportTemplateItemEntity1.setItemUnit(unit);
        reportTemplateItemEntity1.setReferenceHighLimitValue(upperLimit);
        reportTemplateItemEntity1.setReferenceLowLimitValue(lowerLimit);


        reportTemplateEntity.addReportTemplateItem(reportTemplateItemEntity1);
    }

    @Transactional
    void cleanDb() {

        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();

        this.reportTemplateRepository.deleteAll();
        this.reportTemplateCategoryRepository.deleteAll();
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("MedicalTest");
        authorizationTopicService.addAuthorizationTopicAndOperations("化验管理", "操作");
        authorizationTopicService.addAuthorizationTopicAndOperations("化验设置", "操作");

    }


}
