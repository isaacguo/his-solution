package com.isaac.pethospital.treatment;

import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetTypeEntity;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.PetTypeRepository;
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
public class HisTreatmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisTreatmentManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PetTypeRepository petTypeRepository, PetRepository petRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... strings) throws Exception {
                PetTypeEntity p1 = new PetTypeEntity();
                p1.setRoot(true);
                p1.setName("狗");

                PetTypeEntity p2 = new PetTypeEntity();
                p2.setRoot(false);
                p2.setName("博美");

                PetTypeEntity p3 = new PetTypeEntity();
                p3.setRoot(false);
                p3.setName("柯基");

                PetTypeEntity p4 = new PetTypeEntity();
                p4.setRoot(false);
                p4.setName("泰迪");
                p1.addChild(p2);
                p1.addChild(p3);
                p1.addChild(p4);

                petTypeRepository.save(p1);

                PetEntity petEntity1 = new PetEntity();
                petEntity1.setPetName("笨笨");
                petEntity1.setPetType(p3);
                petEntity1.setOwnerName("黄老邪");
                petRepository.save(petEntity1);
            }
        };
    }
}
