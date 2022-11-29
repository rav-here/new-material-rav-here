package com.rachel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rachel")
public class SpringBootMvcWebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcWebProjectApplication.class, args);
	}

}
