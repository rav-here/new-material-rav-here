package streamExercise;

import java.util.ArrayList;
import java.util.List;

public class SecondDemo {
	
	public static void main(String[] args) {
		List<Book> bookList = new ArrayList();

		bookList.add(new Book(1, "Book 1", "Author A", 1200, 5000));
		bookList.add(new Book(2, "Book 2", "Author M", 2100, 2000));
		bookList.add(new Book(3, "Book 3", "Author A", 3000, 6000));
		bookList.add(new Book(4, "Book 4", "Author D", 800, 2800));
		bookList.add(new Book(5, "Book 5", "Author M", 7200, 1100));
		bookList.add(new Book(6, "Book 6", "Author A", 8200, 4300));
		bookList.add(new Book(7, "Book 7", "Author A", 7900, 5600));
		
		
		
		// one price condition for applying discount
//		bookookList.stream().filter(book->book.getPrice()>5000).map(book->new BookDiscount(book, book.getPrice()*.10)).forEach(bookWithDiscount->System.out.println(bookWithDiscount));
		// two price conditions for applying discount

		bookList.stream().map(book -> {
			BookDiscount bd=null;
			if(book.getPrice() < 5000) {
				bd= new BookDiscount(book, book.getPrice()*0.05); 
			}
			else if(book.getPrice() > 5000) {
				bd = new BookDiscount(book, book.getPrice()*0.1);
			}
		return bd;
		}).forEach(book->System.out.println(book));
	
	// another way of doing the above
		bookList.stream().map(book -> {
			if(book.getPrice() < 5000) {
				return new BookDiscount(book, book.getPrice()*0.05); 
			}
			else {
				return new BookDiscount(book, book.getPrice()*0.1);
			}
		}).forEach(book->System.out.println(book));
	}

}
