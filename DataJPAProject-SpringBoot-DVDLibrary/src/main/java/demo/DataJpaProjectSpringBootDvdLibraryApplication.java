package demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import presentation.DvDPresentation;


@SpringBootApplication(scanBasePackages = {"persistence","presentation", "service"})
@EntityScan(basePackages = "entity")
@EnableJpaRepositories(basePackages = "persistence")
public class DataJpaProjectSpringBootDvdLibraryApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = SpringApplication.run(DataJpaProjectSpringBootDvdLibraryApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		DvDPresentation presentation = (DvDPresentation)springContainer.getBean("presentation");
		
		while (true) {
			presentation.showMenu();
			System.out.println("Enter choice : ");
			int choice = scanner.nextInt();
			presentation.performMenu(choice);
			
		}
		
	}

}
