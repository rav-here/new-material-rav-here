package persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import entity.Book;

@Component("dao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<Book> getAllRecords() {

		String query = "SELECT * FROM BOOKS";
		List<Book> bookList = jdbcTemplate.query(query, new BookRowMapper());
		return bookList;
	}
	
	@Override
	public Book searchRecord(int id) {
		Book book = null; 
		try { 
			String query = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
			book = jdbcTemplate.queryForObject(query, new BookRowMapper(), id);
		}
		catch (EmptyResultDataAccessException ex) {
			return null;
		}
		return book;
	}

	@Override
	public int insertRecord(Book book) {
		try {
			String query = "INSERT INTO BOOKS VALUE(?,?,?,?)";
			int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getAuthorName(), book.getNoOfPages());
			return rows;
		}
		catch (DuplicateKeyException ex) {
			return 0;
		}
		
	}	

	@Override
	public int deleteRecord(int id) {
			String query = "DELETE FROM BOOKS WHERE BOOK_ID=?";
			int rows = jdbcTemplate.update(query, id);
			return rows;
	}

	
	@Override
	public int updatePages(int id, int Pages) {
		
		String query = "UPDATE BOOKS SET NO_OF_PAGES=NO_OF_PAGES+? WHERE BOOK_ID=?";
		int rows = jdbcTemplate.update(query, Pages, id);
		return rows;
	}

	
}
