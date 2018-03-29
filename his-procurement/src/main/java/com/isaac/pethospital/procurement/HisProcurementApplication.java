package com.isaac.pethospital.procurement;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.isaac.pethospital"})
@EntityScan(basePackages = {"com.isaac.pethospital"})
@EnableJpaRepositories(basePackages = {"com.isaac.pethospital"})
public class HisProcurementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisProcurementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProcurementStatusRepository procurementStatusRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                ProcurementStatusEntity status0 = new ProcurementStatusEntity();
                status0.setStatus("申请已创建");
                ProcurementStatusEntity status1 = new ProcurementStatusEntity();
                status1.setStatus("申请已提交");
                ProcurementStatusEntity status2 = new ProcurementStatusEntity();
                status2.setStatus("申请已批复");
                ProcurementStatusEntity status3 = new ProcurementStatusEntity();
                status3.setStatus("申请已拒绝");
                ProcurementStatusEntity status4 = new ProcurementStatusEntity();
                status4.setStatus("合同已订立");
                ProcurementStatusEntity status5 = new ProcurementStatusEntity();
                status5.setStatus("合同已逾期");
                ProcurementStatusEntity status6 = new ProcurementStatusEntity();
                status6.setStatus("货物已收到");
                ProcurementStatusEntity status7 = new ProcurementStatusEntity();
                status7.setStatus("货物已退货");
                ProcurementStatusEntity status8 = new ProcurementStatusEntity();
                status8.setStatus("货物已入库");

                status0.addNext(status1);

                status1.addNext(status2);
                status1.addNext(status3);

                status2.addNext(status4);
                status2.addNext(status5);

                status4.addNext(status6);
                status4.addNext(status7);

                status6.addNext(status8);


                procurementStatusRepository.save(status0);
            }
        };
    }
}
