package com.isaac.pethospital.procurement;

import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;
import com.isaac.pethospital.common.entities.TopicOperationEntity;
import com.isaac.pethospital.common.repositories.AuthorizationRepository;
import com.isaac.pethospital.common.repositories.AuthorizationTopicRepository;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.procurement.constants.ConfigurationConstants;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.isaac.pethospital"})
@EntityScan(basePackages = {"com.isaac.pethospital"})
@EnableJpaRepositories(basePackages = {"com.isaac.pethospital"})
@EnableJms
public class HisProcurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisProcurementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProcurementStatusRepository procurementStatusRepository,
                                        ProcurementConfigurationRepository procurementConfigurationRepository,
                                        ProcurementApprovalStageRepository procurementApprovalStageRepository,
                                        VendorProductRepository vendorProductRepository,
                                        VendorRepository vendorRepository,
                                        VendorProductCategoryRepository vendorProductCategoryRepository,
                                        AuthorizationTopicRepository authorizationTopicRepository,
                                        AuthorizationRepository authorizationRepository
    ) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                initProcurementStatus();
                initConfiguration();
                initApproval();
                initVendor();
                initAuthorization();


            }

            private void initAuthorization() {
                AuthorizationTopicEntity topic1 = new AuthorizationTopicEntity();
                topic1.setName("库存");
                topic1.addAvailableTopicOperationByName("增加");
                topic1.addAvailableTopicOperationByName("删除");
                topic1.addAvailableTopicOperationByName("修改");
                topic1.addAvailableTopicOperationByName("查看");
                authorizationTopicRepository.save(topic1);

                AuthorizationTopicEntity topic2 = new AuthorizationTopicEntity();
                topic2.setName("库存价格");
                topic2.addAvailableTopicOperationByName("增加");
                topic2.addAvailableTopicOperationByName("删除");
                topic2.addAvailableTopicOperationByName("修改");
                topic2.addAvailableTopicOperationByName("查看");
                authorizationTopicRepository.save(topic2);

                AuthorizationEntity authorization = new AuthorizationEntity();

                AuthorizationAssignmentEntity aae = new AuthorizationAssignmentEntity();
                aae.setTopic(topic1);
                aae.addAllowedOperation(topic1.getAvailableTopicOperationList().get(0));
                aae.addAllowedOperation(topic1.getAvailableTopicOperationList().get(1));

                AuthorizationAssignmentEntity aae2 = new AuthorizationAssignmentEntity();
                aae2.setTopic(topic2);
                aae2.addAllowedOperation(topic2.getAvailableTopicOperationList().get(2));
                aae2.addAllowedOperation(topic2.getAvailableTopicOperationList().get(3));

                authorization.setUsername("guojing");
                authorization.addAuthorizationAssignment(aae);
                authorization.addAuthorizationAssignment(aae2);

                authorizationRepository.save(authorization);
            }

            private void initVendor() {
                VendorProductEntity vpe1 = new VendorProductEntity();
                vpe1.setOrderNumber("RF VT Set (Basic)");
                vpe1.setProductEnglishName("VETTEST, N.AMERICA,RECERTIFIED");
                vpe1.setProductChineseName("兽医专用生化分析仪(简配)");
                vpe1.setPackageSpecification("套");
                vpe1.setPackageUnit("套");
                vpe1.setPricePerUnit(19900.00);
                vpe1.setCurrency("RMB");
                vpe1.setProductSet(true);

                VendorProductEntity vpe2 = new VendorProductEntity();
                vpe2.setOrderNumber("RF-20380-01");
                vpe2.setProductEnglishName("VETTEST, N.AMERICA,RECERTIFIED");
                vpe2.setProductChineseName("生化分析仪主机（展示机）");
                vpe2.setPackageSpecification("台");
                vpe2.setPackageUnit("1");

                VendorProductEntity vpe3 = new VendorProductEntity();
                vpe3.setOrderNumber("98-19792-00");
                vpe3.setProductEnglishName("VETTEST SOFTWARE UPGRADE PACKET-INVENTOR");
                vpe3.setProductChineseName("VETTEST软件升级包");
                vpe3.setPackageSpecification("个");
                vpe3.setPackageUnit("1");


                vpe1.addChild(vpe2);
                vpe1.addChild(vpe3);


                //VendorProductEntity vpex = vendorProductRepository.save(vpe1);


                VendorEntity ve = new VendorEntity();
                ve.setName("IDEXX");
                vendorRepository.save(ve);


                VendorProductCategoryEntity vendorProductCategoryEntity1 = new VendorProductCategoryEntity();
                vendorProductCategoryEntity1.setName("VetLab 实验室检验仪器");
                vendorProductCategoryEntity1.setVendor(ve);
                //vendorProductCategoryEntity1.addProduct(vpe1);
                vendorProductCategoryRepository.save(vendorProductCategoryEntity1);


                vpe1.setCategory(vendorProductCategoryEntity1);
                vendorProductRepository.save(vpe1);
            }

            private void initApproval() {
                ProcurementApprovalStageEntity procurementApprovalStageEntity1 = new ProcurementApprovalStageEntity();
                procurementApprovalStageEntity1.setStage("申请人");

                ProcurementApprovalStageEntity procurementApprovalStageEntity2 = new ProcurementApprovalStageEntity();
                procurementApprovalStageEntity2.setStage("部门经理");

                ProcurementApprovalStageEntity procurementApprovalStageEntity3 = new ProcurementApprovalStageEntity();
                procurementApprovalStageEntity3.setStage("总经理");

                procurementApprovalStageEntity1.setNextStage(procurementApprovalStageEntity2);
                procurementApprovalStageEntity2.setNextStage(procurementApprovalStageEntity3);

                procurementApprovalStageRepository.save(procurementApprovalStageEntity1);
            }

            private void initConfiguration() {
                ProcurementConfigurationEntity pce1 = new ProcurementConfigurationEntity();
                pce1.setKey(ConfigurationConstants.OrderNumber);
                pce1.setValue("1");
                ProcurementConfigurationEntity pce2 = new ProcurementConfigurationEntity();
                pce2.setKey(ConfigurationConstants.OrderNumberLength);
                pce2.setValue("8");

                procurementConfigurationRepository.save(pce1);
                procurementConfigurationRepository.save(pce2);
            }

            private void initProcurementStatus() {
                ProcurementStatusEntity status1 = new ProcurementStatusEntity();
                status1.setStatus("申请已提交");
                ProcurementStatusEntity status2 = new ProcurementStatusEntity();
                status2.setStatus("申请批复中");
                status2.setLastStatusResult(true);
                ProcurementStatusEntity status3 = new ProcurementStatusEntity();
                status3.setStatus("申请已通过");
                status3.setLastStatusResult(true);
                ProcurementStatusEntity status4 = new ProcurementStatusEntity();
                status4.setStatus("申请已退回");
                status4.setLastStatusResult(false);
                ProcurementStatusEntity status5 = new ProcurementStatusEntity();
                status5.setStatus("采购进行中");
                status5.setLastStatusResult(true);
                ProcurementStatusEntity status6 = new ProcurementStatusEntity();
                status6.setStatus("采购逾期");
                status6.setLastStatusResult(false);
                ProcurementStatusEntity status7 = new ProcurementStatusEntity();
                status7.setStatus("采购已到货");
                status7.setLastStatusResult(true);
                ProcurementStatusEntity status8 = new ProcurementStatusEntity();
                status8.setStatus("采购已退货");
                status8.setLastStatusResult(false);
                ProcurementStatusEntity status9 = new ProcurementStatusEntity();
                status9.setStatus("采购已入库");
                status9.setLastStatusResult(true);

                status1.addNext(status2);

                status2.addNext(status3);
                status2.addNext(status4);

                status3.addNext(status5);
                status3.addNext(status6);

                status5.addNext(status7);
                status5.addNext(status8);

                status7.addNext(status9);


                procurementStatusRepository.save(status1);
            }
        };
    }
}
