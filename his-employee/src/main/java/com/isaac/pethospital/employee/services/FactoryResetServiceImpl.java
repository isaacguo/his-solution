package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.employee.entities.CompanyEntity;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;
    private final CompanyRepository companyRepository;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService, CompanyRepository companyRepository) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.companyRepository = companyRepository;
    }

    @Transactional
    @Override
    public void reset() {

        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();
        authorizationService.setDomainName("Employee");
        authorizationTopicService.addAuthorizationTopicAndOperations("Management", "Admin");

        companyRepository.deleteAll();


    }

    @Override
    public void insertData() {

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName("Pet Hospital1");
        companyEntity.setCompanyLocation("Beijing ChaoYang");

        DepartmentEntity departmentEntity0 = new DepartmentEntity();
        departmentEntity0.setName("总经理");
        EmployeeEntity ee = departmentEntity0.addEmployeeByName("yuelingshan", "岳灵珊", "总经理", null);
        departmentEntity0.setManager(ee);
        EmployeeEntity boss = ee;

        DepartmentEntity departmentEntity01 = new DepartmentEntity();
        departmentEntity01.setName("诊疗室");

        ee = departmentEntity01.addEmployeeByName("linghuchong", "令狐冲", "部门经理", boss);
        departmentEntity01.setManager(ee);
        departmentEntity01.addEmployeeByName("yilin", "仪琳", "主治医师", ee);
        departmentEntity01.addEmployeeByName("huangrong", "黄蓉", "主治医师", ee);


        DepartmentEntity departmentEntity1 = new DepartmentEntity();
        departmentEntity1.setName("化验1室");

        ee = departmentEntity1.addEmployeeByName("linzhennan", "林震南", "部门经理", boss);
        departmentEntity1.setManager(ee);
        departmentEntity1.addEmployeeByName("yucanghai", "余沧海", "操作员", ee);
        departmentEntity1.addEmployeeByName("qufeiyan", "曲非烟", "操作员", ee);


        DepartmentEntity departmentEntity2 = new DepartmentEntity();
        departmentEntity2.setName("药房");
        ee = departmentEntity2.addEmployeeByName("shangguanyun", "上官云", "部门经理", boss);
        departmentEntity2.setManager(ee);
        departmentEntity2.addEmployeeByName("xiangwentian", "向问天", "操作员", ee);


        DepartmentEntity departmentEntity3 = new DepartmentEntity();
        departmentEntity3.setName("财务室");

        ee = departmentEntity3.addEmployeeByName("xiaolongnv", "小龙女", "部门经理", boss);
        departmentEntity3.setManager(ee);
        departmentEntity3.addEmployeeByName("luwushang", "陆无双", "会计", ee);
        departmentEntity3.addEmployeeByName("gongsunzhi", "公孙止", "出纳", ee);


        DepartmentEntity departmentEntity4 = new DepartmentEntity();
        departmentEntity4.setName("办公室");

        ee = departmentEntity4.addEmployeeByName("guojing", "郭靖", "部门经理", boss);
        departmentEntity4.setManager(ee);

        DepartmentEntity departmentEntity5 = new DepartmentEntity();
        departmentEntity5.setName("库房");

        ee = departmentEntity5.addEmployeeByName("zhaomin", "赵敏", "库房经理", boss);
        departmentEntity5.setManager(ee);
        departmentEntity5.addEmployeeByName("zhouzhiruo", "周芷若", "操作员", ee);


        departmentEntity0.addChild(departmentEntity1);
        departmentEntity0.addChild(departmentEntity01);
        departmentEntity0.addChild(departmentEntity2);
        departmentEntity0.addChild(departmentEntity3);
        departmentEntity0.addChild(departmentEntity4);
        departmentEntity0.addChild(departmentEntity5);


        companyEntity.addDepartment(departmentEntity0);

        CompanyEntity savedCe1 = companyRepository.save(companyEntity);

    }
}
