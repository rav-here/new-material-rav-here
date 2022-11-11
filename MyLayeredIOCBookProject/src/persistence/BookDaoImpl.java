package persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;

import database.BookDatabase;
import entity.Book;

@Component("dao")
public class BookDaoImpl implements BookDao {

	@Override
	public Collection<Book> getAllRecords() {
		return BookDatabase.getBookList().values();
	}

	@Override
	public Book searchRecord(int id) {
		return BookDatabase.getBookList().get(id);
	}

	@Override
	public Book insertRecord(Book book) {
		return BookDatabase.getBookList().put(book.getBookId(), book);
	}

}
