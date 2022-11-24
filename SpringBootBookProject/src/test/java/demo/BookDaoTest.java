package demo;


import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import entity.Book;
import persistence.BookDaoImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookDaoTest {

	@Autowired //- used to tell spring which candidate it should use
	BookDaoImpl bookDaoImpl;
	
	// auto-wired does the before each and after each
//	@BeforeEach
//	void setUp() throws Exception {
//		bookDaoImpl = new BookDaoImpl();
//		
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		bookDaoImpl = null;
//	}

	// consider what each method you're testing returns 
	// if it returns a collection/array etc then check that it is not empty 
	// if it returns a numerical data type, check it equals what you would assume
	// if it returns an object check it equals what you assume
	//note: here insert returns a book object but in JDBC it returns an integer so the test would differ slightly 
	
	
	@Order(1)
	@Test
	void testGetAllRecords() {
		assertTrue(bookDaoImpl.getAllRecords().size() > 0); // if argument is true then test is passed
	}
	
	@Order(2)
	@Test
	void testInsertRecord() {
		assertEquals(1, bookDaoImpl.insertRecord(new Book(107, "Blah", "Rachel", 350))); // if two arguments are equals then test is passed
	}
	
	@Order(3)
	@Test
	void testSearchRecord() {
		assertEquals(101, bookDaoImpl.searchRecord(101).getBookId()); 
	}
	
	@Order(4)
	@Test
	void testDeleteRecord() {
		assertEquals(1,bookDaoImpl.deleteRecord(107));
	}

	
	// whenever the code is doing the wrong thing, at least ONE of the unit tests should fail
	// its worth while having multiple scenarios to avoid false passes (add method giving 2*2 = 4)
	// you should never combine scenarios in one test
	// you're scenarios should cover 100% of the class functionality
	// edge cases are import too (testing boundary values are assigned correctly)
	
	
	

}
