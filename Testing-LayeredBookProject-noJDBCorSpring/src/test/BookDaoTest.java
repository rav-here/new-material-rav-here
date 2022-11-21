package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Book;
import persistence.BookDaoImpl;

class BookDaoTest {

	BookDaoImpl bookDaoImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl = new BookDaoImpl();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl = null;
	}

	// consider what each method you're testing returns 
	// if it returns a collection/array etc then check that it is not empty 
	// if it returns a numerical data type, check it equals what you would assume
	// if it returns an object check it equals what you assume
	//note: here insert returns a book object but in JDBC it returns an integer so the test would differ slightly 
	@Test
	void testGetAllRecords() {
		assertTrue(bookDaoImpl.getAllRecords().size() > 0);
	}
	
	@Test
	void testInsertRecord() {
		assertEquals(new Book(101, "Blah", "Rachel", 350), bookDaoImpl.insertRecord(new Book(101, "Blah", "Rachel", 350)));
	}
	
	@Test
	void testSearchRecord() {
		assertEquals(101, bookDaoImpl.searchRecord(101).getBookId());
	}
	

	
	
	

}
