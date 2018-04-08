package com.isaac.pethospital.employee;

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
    CommandLineRunner commandLineRunner(CompanyRepository companyRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, EmployeeService employeeService) {

        return new CommandLineRunner() {

            @Override
            public void run(String... strings) throws Exception {
                CompanyEntity companyEntity = new CompanyEntity();
                companyEntity.setCompanyName("Pet Hospital1");
                companyEntity.setCompanyLocation("Beijing ChaoYang");

                DepartmentEntity departmentEntity1 = new DepartmentEntity();
                departmentEntity1.setName("DE1");
                companyEntity.addDepartment(departmentEntity1);

                CompanyEntity savedCe1 = companyRepository.save(companyEntity);
                DepartmentEntity savedDe1 = departmentRepository.findAll().get(0);

                employeeService.createEmployee(generateEmployee1());
                employeeService.createEmployee(generateEmployee2());
                employeeService.createEmployee(generateEmployee3());
                employeeService.createEmployee(generateEmployee4());
                /*
                employeeRepository.save(generateEmployee1());
                employeeRepository.save(generateEmployee2());
                employeeRepository.save(generateEmployee3());
                */

            }


            private EmployeeOperationRequest generateEmployee1() {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate dateOfBirth = LocalDate.parse("1900-04-01 00:00:00", formatter);
                LocalDate joinedDate = LocalDate.parse("2015-10-01 00:00:00", formatter);
                ContactAddressEntity cae=new ContactAddressEntity();
                cae.setAddress("昆仑山大酒店18层");
                cae.setCity("北京");
                cae.setCountry("大梁");
                cae.setDistrict("崆峒路");
                cae.setHomePhone("023-1494452");
                cae.setMobilePhone("1231231234");
                cae.setPersonalEmail("huchong_ling@136.com");
                cae.setWorkPhone("123566332");
                cae.setPost("911000");

                LeaveInfoEntity leaveInfo=new LeaveInfoEntity();
                leaveInfo.setAnuualLeave(80L);
                leaveInfo.setSickLeave(32L);

                EmployeeOperationRequest ee=new EmployeeOperationRequest();
                ee.setGivenName("狐冲");
                ee.setSurname("令");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate dateOfBirth = LocalDate.parse("1984-02-28 00:00:00", formatter);
                LocalDate joinedDate = LocalDate.parse("2012-04-17 00:00:00", formatter);
                ContactAddressEntity cae=new ContactAddressEntity();
                cae.setAddress("昆仑山大酒店17层");
                cae.setCity("北京");
                cae.setCountry("大梁");
                cae.setDistrict("崆峒路");
                cae.setHomePhone("023-14942123");
                cae.setMobilePhone("1341231675");
                cae.setPersonalEmail("lingshan_yue@136.com");
                cae.setWorkPhone("123577432");
                cae.setPost("611000");

                LeaveInfoEntity leaveInfo=new LeaveInfoEntity();
                leaveInfo.setAnuualLeave(80L);
                leaveInfo.setSickLeave(32L);

                EmployeeOperationRequest ee=new EmployeeOperationRequest();
                ee.setGivenName("灵珊");
                ee.setSurname("岳");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate dateOfBirth = LocalDate.parse("1984-02-28 00:00:00", formatter);
                LocalDate joinedDate = LocalDate.parse("2012-04-17 00:00:00", formatter);

                EmployeeOperationRequest ee=new EmployeeOperationRequest();
                ee.setGivenName("之桃");
                ee.setSurname("赵");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate dateOfBirth = LocalDate.parse("1984-02-28 00:00:00", formatter);
                LocalDate joinedDate = LocalDate.parse("2012-04-17 00:00:00", formatter);
                ContactAddressEntity cae=new ContactAddressEntity();
                cae.setAddress("昆仑山大酒店17层");
                cae.setCity("北京");
                cae.setCountry("大梁");
                cae.setDistrict("崆峒路");
                cae.setHomePhone("023-14942123");
                cae.setMobilePhone("1341231675");
                cae.setPersonalEmail("jing_guo@136.com");
                cae.setWorkPhone("123577432");
                cae.setPost("611000");

                LeaveInfoEntity leaveInfo=new LeaveInfoEntity();
                leaveInfo.setAnuualLeave(80L);
                leaveInfo.setSickLeave(32L);
                EmployeeOperationRequest ee=new EmployeeOperationRequest();
                ee.setGivenName("靖");
                ee.setSurname("郭");
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