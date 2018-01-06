package com.isaac.pethospital.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HisConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisConfigServerApplication.class, args);
	}
}
