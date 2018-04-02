package com.isaac.pethospital.procurement;

import com.isaac.pethospital.procurement.constants.ConfigurationConstants;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import com.isaac.pethospital.procurement.entities.ProcurementConfigurationEntity;
import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalStageRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementConfigurationRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.isaac.pethospital"})
@EntityScan(basePackages = {"com.isaac.pethospital"})
@EnableJpaRepositories(basePackages = {"com.isaac.pethospital"})
public class HisProcurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisProcurementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProcurementStatusRepository procurementStatusRepository,
                                        ProcurementConfigurationRepository procurementConfigurationRepository,
                                        ProcurementApprovalStageRepository procurementApprovalStageRepository
                                        ) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                initProcurementStatus();
                initConfiguration();
                initApproval();
            }

            private void initApproval() {
                ProcurementApprovalStageEntity procurementApprovalStageEntity1 =new ProcurementApprovalStageEntity();
                procurementApprovalStageEntity1.setStage("申请人");

                ProcurementApprovalStageEntity procurementApprovalStageEntity2 =new ProcurementApprovalStageEntity();
                procurementApprovalStageEntity2.setStage("部门经理");

                ProcurementApprovalStageEntity procurementApprovalStageEntity3 =new ProcurementApprovalStageEntity();
                procurementApprovalStageEntity3.setStage("总经理");

                procurementApprovalStageEntity1.setNextStage(procurementApprovalStageEntity2);
                procurementApprovalStageEntity2.setNextStage(procurementApprovalStageEntity3);

                procurementApprovalStageRepository.save(procurementApprovalStageEntity1);
            }

            private void initConfiguration() {
                ProcurementConfigurationEntity pce1=new ProcurementConfigurationEntity();
                pce1.setKey(ConfigurationConstants.OrderNumber);
                pce1.setValue("1");
                ProcurementConfigurationEntity pce2=new ProcurementConfigurationEntity();
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
                status5.setStatus("采购中");
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
