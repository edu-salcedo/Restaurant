package com.pollo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PolloYaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolloYaApplication.class, args);
	}

}
