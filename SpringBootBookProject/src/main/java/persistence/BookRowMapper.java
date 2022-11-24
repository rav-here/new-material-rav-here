package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Book;

public class BookRowMapper implements RowMapper<Book> {
	
	@Override 
	public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int bookId = resultSet.getInt("BOOK_ID");
		String bookName = resultSet.getString("BOOK_NAME");
		String authorName = resultSet.getString("AUTHOR_NAME");
		int noOfPages = resultSet.getInt("NO_OF_PAGES");
		Book book = new Book(bookId, bookName, authorName, noOfPages);

		return book;
	}
	

}
