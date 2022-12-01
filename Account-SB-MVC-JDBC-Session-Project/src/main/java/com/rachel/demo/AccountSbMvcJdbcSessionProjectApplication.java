package com.rachel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.rachel")
@EntityScan(basePackages = "com.rachel.entity")
@EnableJpaRepositories(basePackages = "com.rachel.model.persistence")
public class AccountSbMvcJdbcSessionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountSbMvcJdbcSessionProjectApplication.class, args);
	}

}
