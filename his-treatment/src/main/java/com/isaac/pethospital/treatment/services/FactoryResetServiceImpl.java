package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.treatment.entities.*;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import com.isaac.pethospital.treatment.repositories.PetTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;

    PetTypeRepository petTypeRepository;
    PetOwnerRepository petOwnerRepository;
    EmployeeRepository employeeRepository;
    DepartmentService departmentService;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
    }

    @Transactional
    @Override
    public void reset() {
        this.cleanDb();
        this.init();
    }

    @Override
    public void insertData() {

    }

    @Transactional
    void cleanDb() {
        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("Treatment");
        authorizationTopicService.addAuthorizationTopicAndOperations("前台服务", "操作");
        authorizationTopicService.addAuthorizationTopicAndOperations("我的诊室", "操作");
    }

    void d(){


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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

        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setName("黄老邪");
        petOwnerEntity.setDateOfBirth(LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter));
        PetEntity petEntity1 = new PetEntity();
        petEntity1.setName("笨笨");
        petEntity1.setPetType(p3);
        petEntity1.setPetOwner(petOwnerEntity);
        petOwnerEntity.addPet(petEntity1);
        petOwnerRepository.save(petOwnerEntity);


        //doctor1.setJobTitle("主任医师");
        //doctor1.setRating(4);

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName("全科");
        //departmentEntity.addDoctor(doctor1);
        departmentEntity.setDescription("这是科室的简要介绍");
        departmentEntity.setExposeToPublic(true);

        DepartmentEntity createdDepartment=departmentService.createDepartment(departmentEntity);

        EmployeeEntity doctor1 = new EmployeeEntity();
        doctor1.setName("黄蓉");
        doctor1.setLoginAccount("doctor1");
        doctor1.setSelfIntroduction("擅长：猫，狗外科常见病，手术。");
        doctor1.setDepartment(createdDepartment);

        employeeRepository.save(doctor1);

    }

}
