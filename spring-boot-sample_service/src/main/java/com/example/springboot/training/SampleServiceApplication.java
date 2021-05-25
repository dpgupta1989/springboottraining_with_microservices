package com.example.springboot.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class SampleServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(SampleServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SampleServiceApplication.class, args);
		LOGGER.info("@@@@@@@@@@Application Started");
	}
}