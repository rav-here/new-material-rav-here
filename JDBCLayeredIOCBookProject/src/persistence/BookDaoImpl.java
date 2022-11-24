package persistence;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
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
		// DQL
//		Connection connection = null; 
//		PreparedStatement preparedStatement; 
//		
//		Collection<Book> bookList = new ArrayList<Book>();
//		
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments","root","Archie.092008");
//			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			while (resultSet.next()) {
//				int id = resultSet.getInt("BOOK_ID");
//				String bookName = resultSet.getString("BOOK_NAME");
//				String authorName = resultSet.getString("AUTHOR_NAME");
//				int noOfPages = resultSet.getInt("NO_OF_PAGES");
//				
//				bookList.add(new Book(id, bookName, authorName, noOfPages));
//				
//			}
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch (SQLException s) {
//			s.printStackTrace();
//		}
//		finally {
//			try {
//				// 4.Close
//				connection.close();
//			}
//			catch (SQLException s) {
//				s.printStackTrace();
//			}
//		}
//		
//		return bookList;
		
		String query = "SELECT * FROM BOOKS";
		List<Book> bookList = jdbcTemplate.query(query, new BookRowMapper());
		return bookList;
	}

	@Override
	public Book searchRecord(int id) {
		// DQL
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//		Book book = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//			
//			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOK_ID=?");
//			
//			preparedStatement.setInt(1, id);
//			// result set is pointing above first row
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			if (resultSet.next()) {
//				int bookId = resultSet.getInt("BOOK_ID");
//				String bookName = resultSet.getString("BOOK_NAME");
//				String authorName = resultSet.getString("AUTHOR_NAME");
//				int noOfPages = resultSet.getInt("NO_OF_PAGES");
//				book = new Book(bookId, bookName, authorName, noOfPages);
//			}
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////				4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return book;
		
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
		// DML
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//		int rows = 0; 
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?)");
//
//			preparedStatement.setInt(1, book.getBookId());
//			preparedStatement.setString(2, book.getBookName());
//			preparedStatement.setString(3, book.getAuthorName());
//			preparedStatement.setInt(4, book.getNoOfPages());
//		
//
//			rows = preparedStatement.executeUpdate();
//
//			return rows;
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////				4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rows;
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
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//		int rows=0;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//
//			preparedStatement = connection.prepareStatement("UPDATE BOOKS SET NO_OF_PAGES=? WHERE BOOK_ID=?");
//
//			preparedStatement.setInt(1, Pages);
//			preparedStatement.setInt(2, id);
//
//			rows = preparedStatement.executeUpdate();
//
//			return rows;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////				4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rows;
		
		String query = "UPDATE BOOKS SET NO_OF_PAGES=NO_OF_PAGES+? WHERE BOOK_ID=?";
		int rows = jdbcTemplate.update(query, Pages, id);
		return rows;
	}
}









