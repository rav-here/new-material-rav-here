package client;

import org.springframework.context.annotation.Bean;

import persistence.StudentDaoImpl;
import presentation.StudentPresentationImpl;
import service.StudentServiceImpl;


public class StudentConfiguration {
	@Bean(name="dao")
	public StudentDaoImpl getPersistence() {
		return new StudentDaoImpl();
	}
	
	@Bean(name="service")
	public StudentServiceImpl getStudentService() {
		//Constructor Injection
		return new StudentServiceImpl(getPersistence());
	}
	
	@Bean(name="studentPresentation")
	public StudentPresentationImpl getStudentPresentation() {
		//Setter Injection
		StudentPresentationImpl presentation = new StudentPresentationImpl();
		presentation.setStudentService(getStudentService());
		return presentation;
	}
}
	