package com.rachel.model.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	
	@Override
	public String welcome() {
		return "Welcome to the world of Spring Web MVC";
	}

	@Override
	public String morning() {
		return "Morning all!";
	}

	@Override
	public String evening() {
		return "Evening all!";
	}

}
