package com.sujata.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sujata.presentation.EmployeePresentation;

public class EmployeeClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//remove for Dependency injection //EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		// spring container helps us achieve dependency injection (in configuration class we use constructor inject and setter injection)
		AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		
		EmployeePresentation employeePresentation = (EmployeePresentation)springContainer.getBean("empPresentation");
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
		}

	}

}
