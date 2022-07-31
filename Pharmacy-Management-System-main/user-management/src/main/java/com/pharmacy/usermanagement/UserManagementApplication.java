package com.pharmacy.usermanagement;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserManagementApplication {

	MySQL8Dialect dialect;

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
