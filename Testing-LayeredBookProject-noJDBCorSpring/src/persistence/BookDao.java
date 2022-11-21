package persistence;

import java.util.Collection;
import entity.Book;

public interface BookDao {
	
	Collection<Book> getAllRecords();
	Book searchRecord(int id);
	Book insertRecord(Book book);

}
