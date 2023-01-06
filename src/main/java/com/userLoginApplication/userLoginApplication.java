package com.userLoginApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class userLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(userLoginApplication.class, args);
	}
}
