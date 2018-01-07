package com.isaac.pethospital.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@ComponentScan("com.isaac.pethospital")
public class HisGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisGatewayApplication.class, args);
	}
}
