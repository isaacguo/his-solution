package com.isaac.pethospital.treatment;

import com.isaac.pethospital.treatment.entities.*;
import com.isaac.pethospital.treatment.repositories.*;
import com.isaac.pethospital.treatment.services.DepartmentSerivce;
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
    CommandLineRunner commandLineRunner(PetTypeRepository petTypeRepository,
                                        PetOwnerRepository petOwnerRepository,
                                        DoctorRepository doctorRepository,
                                        DepartmentRepository departmentRepository,
                                        DepartmentSerivce departmentSerivce) {

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

                PetOwnerEntity petOwnerEntity=new PetOwnerEntity();
                petOwnerEntity.setName("黄老邪");
                PetEntity petEntity1 = new PetEntity();
                petEntity1.setName("笨笨");
                petEntity1.setPetType(p3);
                petEntity1.setPetOwner(petOwnerEntity);
                petOwnerEntity.addPet(petEntity1);
                petOwnerRepository.save(petOwnerEntity);



                DoctorEntity doctor1=new DoctorEntity();
                doctor1.setName("黄蓉");
                doctor1.setSelfIntroduction("擅长：猫，狗外科常见病，手术。");
                doctor1.setJobTitle("主任医师");
                doctor1.setRating(4);

                DepartmentEntity departmentEntity=new DepartmentEntity();
                departmentEntity.setName("全科");
                departmentEntity.addDoctor(doctor1);
                departmentEntity.setDescription("这是科室的简要介绍");
                departmentEntity.setExposeToPublic(true);

                departmentSerivce.createDepartment(departmentEntity);
            }
        };
    }
}
