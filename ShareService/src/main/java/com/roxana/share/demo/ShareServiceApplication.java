package com.roxana.share.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.roxana.share")
@EntityScan(basePackages = "com.roxana.share.entity")
@EnableJpaRepositories(basePackages = "com.roxana.share.persistence")
public class ShareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareServiceApplication.class, args);
	}

}
