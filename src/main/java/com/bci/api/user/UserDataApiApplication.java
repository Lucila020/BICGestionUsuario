package com.bci.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bci.api.user")
public class UserDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDataApiApplication.class, args);
	}

}
