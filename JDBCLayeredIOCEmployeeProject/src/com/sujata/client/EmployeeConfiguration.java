package com.sujata.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import com.sujata.persistence.EmployeeDao;
//import com.sujata.persistence.EmployeeDaoImpl;
//import com.sujata.presentation.EmployeePresentationImpl;
//import com.sujata.service.EmployeeServiceImpl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


// this class allows us to use spring in order to achieve dependency injection or inversion of control
// the service layer incorporates the dao implementation (persistence layer)
// the presentation layer incorporates the service implementation (the service layer) which incorporates the persistence layer

// driver manager data source is responsible for connection so the following class also allows us to set up the driver and connection for the JDBC via mySQL

@ComponentScan(basePackages = "com.sujata")
public class EmployeeConfiguration {


	@Bean(name="mySqlDataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driver.setUrl("jdbc:mysql://127.0.0.1:3306/Departments");
		driver.setUsername("root");
		driver.setPassword("Archie.092008");
		return driver;
	}
	
	@Bean
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
}