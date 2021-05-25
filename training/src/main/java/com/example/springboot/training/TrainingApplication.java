package com.example.springboot.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class TrainingApplication {

	private static final Logger LOGGER = LogManager.getLogger(TrainingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
		LOGGER.info("@@@@@@@@@@Application Started");
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}