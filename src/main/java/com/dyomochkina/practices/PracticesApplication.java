package com.dyomochkina.practices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PracticesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticesApplication.class, args);
	}

}