package com.pos.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LoginApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoginApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		logger.info("Application startedddddddd");
	}

}
