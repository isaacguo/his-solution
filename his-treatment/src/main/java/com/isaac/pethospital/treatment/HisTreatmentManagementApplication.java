package com.isaac.pethospital.treatment;

import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.repositories.DepartmentRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import com.isaac.pethospital.treatment.repositories.PetTypeRepository;
import com.isaac.pethospital.treatment.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.isaac.pethospital"})
@EntityScan(basePackages = {"com.isaac.pethospital"})
@EnableJpaRepositories(basePackages = {"com.isaac.pethospital"})
public class HisTreatmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisTreatmentManagementApplication.class, args);
    }

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(PetTypeRepository petTypeRepository,
                                        PetOwnerRepository petOwnerRepository
                                        ) {

        return new CommandLineRunner() {

            private boolean shouldCreateDatabase() {

                List<String> profiles = Arrays.asList(environment.getActiveProfiles());
                if (profiles.size() == 0 || profiles.contains("dev") || profiles.contains("default") || profiles.contains("staging"))
                    return true;
                else {
                    return environment.getProperty("createDatabase", Boolean.class, false);
                }
            }
            @Override
            public void run(String... strings) throws Exception {

                if (!shouldCreateDatabase()) return;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


                PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
                petOwnerEntity.setName("1黄老邪");
                petOwnerEntity.setDateOfBirth(LocalDate.parse(LocalDateTime.now().format(formatter), formatter));
                PetEntity petEntity1 = new PetEntity();
                petEntity1.setName("笨笨");
                petEntity1.setPetOwner(petOwnerEntity);
                petOwnerEntity.addPet(petEntity1);
                petOwnerRepository.save(petOwnerEntity);



            }
        };
    }

}
