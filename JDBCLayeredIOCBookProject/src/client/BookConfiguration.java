package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan(basePackages = {"persistence", "presentation", "service"})
public class BookConfiguration {
	
	// setter inject driver manager data source object
	@Bean(name="mySqlDataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driver.setUrl("jdbc:mysql://127.0.0.1:3306/Departments");
		driver.setUsername("root");
		driver.setPassword("Archie.092008");
		return driver;
	}
	
	// setter inject Jdbc template to help us query+manage mySQL database
	@Bean
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}