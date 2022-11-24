package demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import presentation.BookPresentation;

@SpringBootApplication(scanBasePackages = {"persistence", "presentation", "service"})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = SpringApplication.run(SpringBootDemoApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		
		BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bookPresentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice = scanner.nextInt();
			bookPresentation.performMenu(choice);
		}
	}

}
