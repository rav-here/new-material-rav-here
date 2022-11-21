package presentation;

import java.util.Collection;
import java.util.Scanner;


import entity.Book;
import service.BookService;
import service.BookServiceImpl;

public class BookPresentationImpl implements BookPresentation {

	// presentation will pass request to service layer for all business logic actions
	private BookService bookService = new BookServiceImpl();

	
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Book Management System");
		System.out.println("1. List All Books");
		System.out.println("2. Search Book By ID");
		System.out.println("3. Add New Book");
		System.out.println("4. Change No of Pages");
		System.out.println("5. View Book Blurb");
		System.out.println("6. Exit");
		System.out.println("============================");
		
	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		
		switch (choice) {
		
		case 1: 
			Collection<Book> books= bookService.getAllBooks();
			for(Book book : books) {
				System.out.println(book);
			}
			break;
		
		case 2: 
			System.out.println("Enter Employee ID : ");
			int id=scanner.nextInt();
			Book book= bookService.searchBookById(id);
			if(book != null)
				System.out.println(book);
			else
				System.out.println("Book with id "+id+" does not exist");
			break;
		
		case 3:
            Book newBook=new Book();

            System.out.println("Enter Book id : ");
            newBook.setBookId(scanner.nextInt());
            System.out.println("Enter Book Name : ");
            newBook.setBookName(scanner.next());
            System.out.println("Enter Author Name : ");
            newBook.setAuthorName(scanner.next());
            System.out.println("Enter the number of pages : ");
            newBook.setNoOfPages(scanner.nextInt());

            if(bookService.addBook(newBook))
            System.out.println("Book Record Added");
            else
            System.out.println("Book with id "+newBook.getBookId()+" already exist, so cannot add it as a new book!");

            break;		
        
		case 4: 
			System.out.println("Enter Book ID : ");
			int bookId=scanner.nextInt();
			System.out.println("Enter new No of Pages : ");
			int pages=scanner.nextInt();
			if(bookService.newPages(bookId, pages))
				System.out.println("Book with Id "+bookId+" new page number is "+pages);
			else
				System.out.println("Book with ID "+bookId+" does not exist");
			break;
            
		case 5: 
			System.out.println("Enter Book ID : ");
			int bookid = scanner.nextInt();
			String blurb = bookService.generateBlurb(bookid);
			if (blurb != null) {
				System.out.println(blurb);
			}
			else {
				System.out.println("Book with id "+bookid+" does not exist, thus has no blurb");
			}
			break;
		
		case 6:
			System.out.println("Thanks for using Book Management System");
			// void method for exiting program, it terminates the currently running JVM and exits the program
			// the parameter integer 0 - means normal exit, any non-zero integer is considered an abnormal exit
			// this method stops any subsequent lines from running
			// it is used when we want to exit the program from somewhere other than the main class of the program
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}
		
	}

}
