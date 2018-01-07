package com.isaac.pethospital.medicine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HisMedicineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisMedicineApplication.class, args);
	}

}
