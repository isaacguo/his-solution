package com.isaac.pethospital.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HisEmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisEmployeeManagementApplication.class, args);
	}
}
