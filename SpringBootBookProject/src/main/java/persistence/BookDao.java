package persistence;

import java.util.Collection;
import entity.Book;

public interface BookDao {
	
	Collection<Book> getAllRecords();
	Book searchRecord(int id);
	int insertRecord(Book book);
	int deleteRecord(int id);
	int updatePages(int id, int increment);

}
