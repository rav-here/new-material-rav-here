package com.rachel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rachel")
public class SpringBootMvcWebProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcWebProject2Application.class, args);
	}

}
