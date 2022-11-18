package com.sujata.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sujata.persistence.EmployeeDaoImpl;
import com.sujata.presentation.EmployeePresentationImpl;
import com.sujata.service.EmployeeServiceImpl;

// this class allows us to use spring in order to achieve dependency injection or inversion of control
// the service layer incorporates the dao implementation (persistence layer)
// the presentation layer incorporates the service implementation (the service layer) which incorporates the persistence layer


@Configuration
public class EmployeeConfiguration {

	@Bean(name="dao")
	public EmployeeDaoImpl getPersistence() {
		return new EmployeeDaoImpl();
	}
	
	@Bean(name="service")
	public EmployeeServiceImpl getEmployeeService() {
		//Constructor Injection
		return new EmployeeServiceImpl(getPersistence());
	}
	
	@Bean(name="empPresentation")
	public EmployeePresentationImpl getEmployeePresentation() {
		//Setter Injection
		EmployeePresentationImpl presentation=new EmployeePresentationImpl();
		presentation.setEmployeeService(getEmployeeService());
		return presentation;
	}
}