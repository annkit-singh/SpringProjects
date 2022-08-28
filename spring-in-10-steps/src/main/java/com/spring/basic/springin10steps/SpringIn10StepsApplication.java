package com.spring.basic.springin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringIn10StepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIn10StepsApplication.class, args);
	}

}
