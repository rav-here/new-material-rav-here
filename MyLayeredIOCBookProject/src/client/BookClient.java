package client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import presentation.BookPresentation;

public class BookClient {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(BookConfiguration.class);
		//ApplicationContext springContainer=new ClassPathXmlApplicationContext("BookConfiguration.xml");
		
		
		BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bookPresentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter choice : ");
			int choice = scanner.nextInt();
			bookPresentation.performMenu(choice);
		}
	}

}
