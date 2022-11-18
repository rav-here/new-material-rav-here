package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import entity.Book;

@Component("dao")
public class BookDaoImpl implements BookDao {

	@Override
	public Collection<Book> getAllRecords() {
		// DQL
		Connection connection = null; 
		PreparedStatement preparedStatement; 
		
		Collection<Book> bookList = new ArrayList<Book>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments","root","Archie.092008");
			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("BOOK_ID");
				String bookName = resultSet.getString("BOOK_NAME");
				String authorName = resultSet.getString("AUTHOR_NAME");
				int noOfPages = resultSet.getInt("NO_OF_PAGES");
				
				bookList.add(new Book(id, bookName, authorName, noOfPages));
				
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		finally {
			try {
				// 4.Close
				connection.close();
			}
			catch (SQLException s) {
				s.printStackTrace();
			}
		}
		
		return bookList;
	}

	@Override
	public Book searchRecord(int id) {
		// DQL
		Connection connection = null;
		PreparedStatement preparedStatement;
		Book book = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
			
			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOK_ID=?");
			
			preparedStatement.setInt(1, id);
			// result set is pointing above first row
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int bookId = resultSet.getInt("BOOK_ID");
				String bookName = resultSet.getString("BOOK_NAME");
				String authorName = resultSet.getString("AUTHOR_NAME");
				int noOfPages = resultSet.getInt("NO_OF_PAGES");
				book = new Book(bookId, bookName, authorName, noOfPages);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}

	@Override
	public int insertRecord(Book book) {
		// DML
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows = 0; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?)");

			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNoOfPages());
		

			rows = preparedStatement.executeUpdate();

			return rows;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int updatePages(int id, int Pages) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");

			preparedStatement = connection.prepareStatement("UPDATE BOOKS SET NO_OF_PAGES=? WHERE BOOK_ID=?");

			preparedStatement.setInt(1, Pages);
			preparedStatement.setInt(2, id);

			rows = preparedStatement.executeUpdate();

			return rows;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
}









