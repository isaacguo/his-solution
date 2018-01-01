package com.isaac.hisgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableZuulProxy
public class HisGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisGatewayApplication.class, args);
	}
}
