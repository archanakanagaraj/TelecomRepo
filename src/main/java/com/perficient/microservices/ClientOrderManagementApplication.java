package com.perficient.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient // Make myself discovered by the Eureka Server/Discovery Server
@EnableFeignClients // Enable Feign framework to handle proxies to various microservice
@EnableCircuitBreaker // Enable Hystrix Fra
public class ClientOrderManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientOrderManagementApplication.class, args);
	}
}
