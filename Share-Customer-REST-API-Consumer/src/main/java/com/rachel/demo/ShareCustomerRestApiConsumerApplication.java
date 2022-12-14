package com.rachel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.rachel")
public class ShareCustomerRestApiConsumerApplication {

	@Bean 
	public RestTemplate gettemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ShareCustomerRestApiConsumerApplication.class, args);
	}

}
