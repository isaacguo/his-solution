package com.isaac.pethospital.employee;

import com.isaac.pethospital.employee.entities.CompanyEntity;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.CompanyRepository;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;

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
    CommandLineRunner commandLineRunner(CompanyRepository companyRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {

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

                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setDepartment(savedDe1);
                employeeEntity.setSurname("Guo");
                employeeEntity.setGivenName("Isaac");
                employeeRepository.save(employeeEntity);

            }
        };
    }
}