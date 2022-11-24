package demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import entity.Book;

import org.mockito.MockitoAnnotations;

import persistence.BookDao;
import service.BookServiceImpl;


@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

	// declare fields/variables of the test class
	@InjectMocks
	private BookServiceImpl bookServiceImpl;
	@Mock
	private BookDao bookDao;
	private AutoCloseable autoCloseable;
	
	@BeforeEach
	void setUp() throws Exception {
		
		// tells mockito to scan the test class for all the fields/variables annotated with @Mock
		// and initialise these as mocks
		autoCloseable = MockitoAnnotations.openMocks(this);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	// testing the service implementation methods that have business logic
	@Test
	void testAddBook() {
		// specify behaviour of mock serviceImpl method
		// if DAO search record method returns book object (not null), assert that the Service add book method returns False
		when(bookDao.searchRecord(101)).thenReturn(new Book(101, "Blah", "Rachel", 350));
		// test the method
		assertFalse(bookServiceImpl.addBook(new Book(101, "Blah", "Rachel", 350)));
	}

	@Test
	void testAddBook2() {
		// specify behaviour of mock serviceImpl method
		// if DAO search record method returns null, 
		when(bookDao.searchRecord(101)).thenReturn(null);
		// assert that the Service add book method returns True
		// test the method
		assertTrue(bookServiceImpl.addBook(new Book(101, "Blah", "Rachel", 300)));
	}
	
	@Test
	void testNewPages() {
		// specify behaviour of mock serviceImpl method
		// if DAO search record method returns book object (not null)
		when(bookDao.searchRecord(101)).thenReturn(new Book(101, "Blah", "Rachel", 300));
		// assert that the Service new Pages method returns True
		// test the method
		assertTrue(bookServiceImpl.newPages(101, 50));
	
	}
	
	@Test
	void testNewPages2() {
		// specify behaviour of mock serviceImpl method
		// if DAO search record method returns null
		when(bookDao.searchRecord(101)).thenReturn(null);
		// assert that the Service new pages method returns False
		// test the method
		assertFalse(bookServiceImpl.newPages(101, 50));
	
	}

	@Test
	void testGenerateBlurb() {
		// specify behaviour of mock serviceImpl method
		// if DAO search record method returns book object (not null)
		when(bookDao.searchRecord(101)).thenReturn(new Book(101, "Blah", "Rachel", 350));
		// assert that the Service generate blurb method returns not null
		// test the method
		assertNotNull(bookServiceImpl.generateBlurb(101));
	}

	@Test
	void testGenerateBlurb2() {
		// specify behaviour of mock serviceImpl method
				// if DAO search record method returns null
		when(bookDao.searchRecord(101)).thenReturn(null);
		// assert that the Service generate blurb method returns null
		// test the method
		assertNull(bookServiceImpl.generateBlurb(101));
	}
	
}










