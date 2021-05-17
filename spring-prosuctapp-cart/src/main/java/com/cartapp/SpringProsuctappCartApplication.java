package com.cartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SpringProsuctappCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProsuctappCartApplication.class, args);

	}

//when one ms connect to another ms it always go and check in service registry..if u r having more than one instance of same
	// service running then the service registry is responsible for identifying the
	// appropriate port number and connect to service
	@Bean

	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
