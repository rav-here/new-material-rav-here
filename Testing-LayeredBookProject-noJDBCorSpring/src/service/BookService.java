package service;

import java.util.Collection;

import entity.Book;

public interface BookService {

	Collection<Book> getAllBooks();

	Book searchBookById(int id);

	boolean addBook(Book book);
	
	boolean newPages(int id,int Pages);
	
	String generateBlurb(int bookid); 
}
