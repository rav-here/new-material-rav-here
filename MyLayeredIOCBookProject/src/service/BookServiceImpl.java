package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Book;
import persistence.BookDao;

@Component("servie")
public class BookServiceImpl implements BookService {

	// Service requests persistence layer for all data needs
	private BookDao bookDao;
	// constructor
	public BookServiceImpl(@Autowired BookDao bookDao) {
		this.bookDao  = bookDao;
	}
	
	
	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllRecords();
	}

	@Override
	public Book searchBookById(int id) {
		return bookDao.searchRecord(id);
	}


	@Override
    public boolean addBook(Book book) {
        Book newBook = bookDao.searchRecord(book.getBookId());
        if(newBook!=null) {
            return false;
        }
        bookDao.insertRecord(book);
        return true;
    }


	@Override
	public boolean newPages(int id, int Pages) {
		Book book = bookDao.searchRecord(id);
		if(book == null) {
			return false;
		}
		book.setNoOfPages(Pages);
		bookDao.insertRecord(book);
		return true;
	}


	@Override
	public String generateBlurb(int bookid) {
		Book book = bookDao.searchRecord(bookid);
		if (book != null) {
			String line1 = "This book is all about the planet of "+book.getBookName() +" it follows the protagonist "+book.getAuthorName()+" while they explore the "+ book.getNoOfPages()+" species of this planet.";
			
			return line1;
		}
		return null;
	}

}
