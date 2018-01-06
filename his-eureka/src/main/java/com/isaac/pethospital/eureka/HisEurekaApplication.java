package com.isaac.pethospital.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HisEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisEurekaApplication.class, args);
	}
}
