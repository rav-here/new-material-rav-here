package client;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import persistence.BookDaoImpl;
//import presentation.BookPresentationImpl;
//import service.BookServiceImpl;


@ComponentScan(basePackages = {"persistence", "presentation", "service"})
//@Configuration
public class BookConfiguration {

//	@Bean(name="dao")
//	public BookDaoImpl getPersistence() {
//		return new BookDaoImpl();
//	}
//	
//	@Bean(name="service")
//	public BookServiceImpl getBookService() {
//		//Constructor Injection
//		return new BookServiceImpl(getPersistence());
//	}
//	
//	@Bean(name="bookPresentation")
//	public BookPresentationImpl getBookPresentation() {
//		//Setter Injection
//		BookPresentationImpl presentation = new BookPresentationImpl();
//		presentation.setBookService(getBookService());
//		return presentation;
//	}
}