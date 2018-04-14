package com.isaac.pethospital.employee;

import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;
import com.isaac.pethospital.common.repositories.AuthorizationRepository;
import com.isaac.pethospital.common.repositories.AuthorizationTopicRepository;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.*;
import com.isaac.pethospital.employee.enums.EmploymentStatusEnum;
import com.isaac.pethospital.employee.enums.MaritalStatusEnum;
import com.isaac.pethospital.employee.enums.SexualEnum;
import com.isaac.pethospital.employee.repositories.CompanyRepository;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import com.isaac.pethospital.employee.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.crypto.ExemptionMechanismException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.isaac.pethospital"})
@EntityScan(basePackages = {"com.isaac.pethospital"})
@EnableJpaRepositories(basePackages = {"com.isaac.pethospital"})
public class HisEmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisEmployeeManagementApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository companyRepository,
                                        DepartmentRepository departmentRepository,
                                        EmployeeRepository employeeRepository,
                                        EmployeeService employeeService,
                                        AuthorizationTopicRepository authorizationTopicRepository,
                                        AuthorizationRepository authorizationRepository) {

        return new CommandLineRunner() {

            /*
            岳灵珊	总经理	总经理


            令狐冲	诊疗室	部门经理
            仪琳	诊疗室	主治医师
            黄蓉	诊疗室	主任医师

            林震南	化验1室	部门经理
            余沧海	化验1室	操作员
            曲非烟	化验1室	操作员


            上官云	药房	部门经理
            向问天	药房	操作员

            郭靖    办公室 	操作员

            小龙女	财务室	财务经理
            陆无双	财务室	会计
            公孙止	财务室	出纳


            赵敏	库房	库房经理
            周芷若	库房	操作员

             */

            @Override
            public void run(String... strings) throws Exception {
                CompanyEntity companyEntity = new CompanyEntity();
                companyEntity.setCompanyName("Pet Hospital1");
                companyEntity.setCompanyLocation("Beijing ChaoYang");

                DepartmentEntity departmentEntity0 = new DepartmentEntity();
                departmentEntity0.setName("总经理");
                EmployeeEntity ee = departmentEntity0.addEmployeeByName("yuelingshan", "岳灵珊", "总经理", null);
                EmployeeEntity boss = ee;

                DepartmentEntity departmentEntity01 = new DepartmentEntity();
                departmentEntity01.setName("诊疗室");

                ee = departmentEntity01.addEmployeeByName("linghuchong", "令狐冲", "部门经理", boss);
                departmentEntity01.addEmployeeByName("yilin", "仪琳", "主治医师", ee);
                departmentEntity01.addEmployeeByName("huangrong", "黄蓉", "主治医师", ee);


                DepartmentEntity departmentEntity1 = new DepartmentEntity();
                departmentEntity1.setName("化验1室");

                ee = departmentEntity1.addEmployeeByName("linzhennan", "林震南", "部门经理", boss);
                departmentEntity1.addEmployeeByName("yucanghai", "余沧海", "操作员", ee);
                departmentEntity1.addEmployeeByName("qufeiyan", "曲非烟", "操作员", ee);


                DepartmentEntity departmentEntity2 = new DepartmentEntity();
                departmentEntity2.setName("药房");
                ee = departmentEntity2.addEmployeeByName("shangguanyun", "上官云", "部门经理", boss);
                departmentEntity2.addEmployeeByName("xiangwentian", "向问天", "操作员", ee);


                DepartmentEntity departmentEntity3 = new DepartmentEntity();
                departmentEntity3.setName("财务室");

                ee = departmentEntity3.addEmployeeByName("xiaolongnv", "小龙女", "部门经理", boss);
                departmentEntity3.addEmployeeByName("luwushang", "陆无双", "会计", ee);
                departmentEntity3.addEmployeeByName("gongsunzhi", "公孙止", "出纳", ee);


                DepartmentEntity departmentEntity4 = new DepartmentEntity();
                departmentEntity4.setName("办公室");

                ee = departmentEntity4.addEmployeeByName("guojing", "郭靖", "部门经理", boss);

                DepartmentEntity departmentEntity5 = new DepartmentEntity();
                departmentEntity5.setName("库房");

                ee = departmentEntity3.addEmployeeByName("zhaomin", "赵敏", "库房经理", boss);
                departmentEntity3.addEmployeeByName("zhouzhiruo", "周芷若", "操作员", ee);


                departmentEntity0.addChild(departmentEntity1);
                departmentEntity0.addChild(departmentEntity01);
                departmentEntity0.addChild(departmentEntity2);
                departmentEntity0.addChild(departmentEntity3);
                departmentEntity0.addChild(departmentEntity4);
                departmentEntity0.addChild(departmentEntity5);


                companyEntity.addDepartment(departmentEntity0);

                CompanyEntity savedCe1 = companyRepository.save(companyEntity);


                /*
                employeeService.createEmployee(generateEmployee1(departmentEntity01));
                employeeService.createEmployee(generateEmployee2());
                employeeService.createEmployee(generateEmployee3());
                employeeService.createEmployee(generateEmployee4());
                */

                initAuthorization();


            }

            private void initAuthorization() {
                AuthorizationTopicEntity topic1 = new AuthorizationTopicEntity();
                topic1.setName("工资");
                topic1.addAvailableTopicOperationByName("增加");
                topic1.addAvailableTopicOperationByName("删除");
                topic1.addAvailableTopicOperationByName("修改");
                topic1.addAvailableTopicOperationByName("查看");
                authorizationTopicRepository.save(topic1);

                AuthorizationTopicEntity topic2 = new AuthorizationTopicEntity();
                topic2.setName("职位");
                topic2.addAvailableTopicOperationByName("增加");
                topic2.addAvailableTopicOperationByName("删除");
                topic2.addAvailableTopicOperationByName("修改");
                topic2.addAvailableTopicOperationByName("查看");
                authorizationTopicRepository.save(topic2);

                /*
                AuthorizationEntity authorization = new AuthorizationEntity();

                AuthorizationAssignmentEntity aae = new AuthorizationAssignmentEntity();
                aae.setTopic(topic1);
                aae.addAllowedOperation(topic1.getAvailableTopicOperationList().get(0));
                aae.addAllowedOperation(topic1.getAvailableTopicOperationList().get(1));

                AuthorizationAssignmentEntity aae2 = new AuthorizationAssignmentEntity();
                aae2.setTopic(topic2);
                aae2.addAllowedOperation(topic2.getAvailableTopicOperationList().get(2));
                aae2.addAllowedOperation(topic2.getAvailableTopicOperationList().get(3));
                */

                authorizationTopicRepository.save(topic1);
                authorizationTopicRepository.save(topic2);
            }


            private EmployeeOperationRequest generateEmployee1(DepartmentEntity departmentEntity) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse("1900-04-01", formatter);
                LocalDate joinedDate = LocalDate.parse("2015-10-01", formatter);
                ContactAddressEntity cae = new ContactAddressEntity();
                cae.setAddress("昆仑山大酒店18层");
                cae.setCity("北京");
                cae.setCountry("大梁");
                cae.setDistrict("崆峒路");
                cae.setHomePhone("023-1494452");
                cae.setMobilePhone("1231231234");
                cae.setPersonalEmail("huchong_ling@136.com");
                cae.setWorkPhone("123566332");
                cae.setPost("911000");

                LeaveInfoEntity leaveInfo = new LeaveInfoEntity();
                leaveInfo.setAnuualLeave(80L);
                leaveInfo.setSickLeave(32L);

                EmployeeOperationRequest ee = new EmployeeOperationRequest();
                ee.setGivenName("狐冲");
                ee.setSurname("令");
                ee.setDepartment(departmentEntity);
                ee.setFullName(ee.getSurname() + ee.getGivenName());
                ee.setContactAddress(cae);
                ee.setWorkPhoneNumber("010-3391232");
                ee.setLoginAccount("linghuchong");
                ee.setDateOfBirth(dateOfBirth);
                ee.setEmail("huchong_ling@pethos.com");
                ee.setEmployeeNumber("000003");
                ee.setGender(SexualEnum.MALE);
                ee.setEthnic("汉族");
                ee.setNationality("中国");
                ee.setJobTitle("主治医师");
                ee.setEmploymentStatus(EmploymentStatusEnum.FULL_TIME);
                ee.setMaritalStatus(MaritalStatusEnum.SINGLE);
                ee.setJoinedDate(joinedDate);
                ee.setLeaveInfo(leaveInfo);

                return ee;
            }

            private EmployeeOperationRequest generateEmployee2() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse("1984-02-28", formatter);
                LocalDate joinedDate = LocalDate.parse("2012-04-17", formatter);
                ContactAddressEntity cae = new ContactAddressEntity();
                cae.setAddress("昆仑山大酒店17层");
                cae.setCity("北京");
                cae.setCountry("大梁");
                cae.setDistrict("崆峒路");
                cae.setHomePhone("023-14942123");
                cae.setMobilePhone("1341231675");
                cae.setPersonalEmail("lingshan_yue@136.com");
                cae.setWorkPhone("123577432");
                cae.setPost("611000");

                LeaveInfoEntity leaveInfo = new LeaveInfoEntity();
                leaveInfo.setAnuualLeave(80L);
                leaveInfo.setSickLeave(32L);

                EmployeeOperationRequest ee = new EmployeeOperationRequest();
                ee.setGivenName("灵珊");
                ee.setSurname("岳");
                ee.setFullName(ee.getSurname() + ee.getGivenName());
                ee.setContactAddress(cae);
                ee.setWorkPhoneNumber("010-3391233");
                ee.setLoginAccount("yuelingshan");
                ee.setDateOfBirth(dateOfBirth);
                ee.setEmail("lingshan_yue@pethos.com");
                ee.setEmployeeNumber("000004");
                ee.setGender(SexualEnum.FEMALE);
                ee.setEthnic("汉族");
                ee.setNationality("中国");
                ee.setJobTitle("会计");
                ee.setEmploymentStatus(EmploymentStatusEnum.FULL_TIME);
                ee.setMaritalStatus(MaritalStatusEnum.MARRIED);
                ee.setJoinedDate(joinedDate);
                ee.setLeaveInfo(leaveInfo);
                return ee;
            }

            private EmployeeOperationRequest generateEmployee3() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse("1984-02-28", formatter);
                LocalDate joinedDate = LocalDate.parse("2012-04-17", formatter);

                EmployeeOperationRequest ee = new EmployeeOperationRequest();
                ee.setGivenName("之桃");
                ee.setSurname("赵");
                ee.setFullName(ee.getSurname() + ee.getGivenName());
                ee.setDateOfBirth(dateOfBirth);
                ee.setEmail("zhidong_zhao@pethos.com");
                ee.setEmployeeNumber("000005");
                ee.setGender(SexualEnum.MALE);
                ee.setEthnic("壮族");
                ee.setNationality("中国");
                ee.setJobTitle("实习工程师");
                ee.setEmploymentStatus(EmploymentStatusEnum.INTERN);
                ee.setMaritalStatus(MaritalStatusEnum.SINGLE);
                ee.setJoinedDate(joinedDate);
                return ee;
            }

            private EmployeeOperationRequest generateEmployee4() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse("1984-02-28", formatter);
                LocalDate joinedDate = LocalDate.parse("2012-04-17", formatter);
                ContactAddressEntity cae = new ContactAddressEntity();
                cae.setAddress("昆仑山大酒店17层");
                cae.setCity("北京");
                cae.setCountry("大梁");
                cae.setDistrict("崆峒路");
                cae.setHomePhone("023-14942123");
                cae.setMobilePhone("1341231675");
                cae.setPersonalEmail("jing_guo@136.com");
                cae.setWorkPhone("123577432");
                cae.setPost("611000");

                LeaveInfoEntity leaveInfo = new LeaveInfoEntity();
                leaveInfo.setAnuualLeave(80L);
                leaveInfo.setSickLeave(32L);
                EmployeeOperationRequest ee = new EmployeeOperationRequest();
                ee.setGivenName("靖");
                ee.setSurname("郭");
                ee.setFullName(ee.getSurname() + ee.getGivenName());
                ee.setContactAddress(cae);
                ee.setWorkPhoneNumber("010-3391233");
                ee.setLoginAccount("guojing");
                ee.setDateOfBirth(dateOfBirth);
                ee.setEmail("jing_guo@pethos.com");
                ee.setEmployeeNumber("000004");
                ee.setGender(SexualEnum.MALE);
                ee.setEthnic("汉族");
                ee.setNationality("中国");
                ee.setJobTitle("办公室");
                ee.setEmploymentStatus(EmploymentStatusEnum.FULL_TIME);
                ee.setMaritalStatus(MaritalStatusEnum.MARRIED);
                ee.setJoinedDate(joinedDate);
                ee.setLeaveInfo(leaveInfo);
                return ee;
            }
        };
    }
}