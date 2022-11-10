package database;

import java.util.LinkedHashMap;
import java.util.Map;

import entity.Book;

public class BookDatabase {
	
static private Map<Integer, Book> bookList=new LinkedHashMap<Integer, Book>();
	
	
	static {
		bookList.put(101, new Book(101, "Blah", "Rachel", 350));
		bookList.put(102, new Book(102, "Meh", "Zoe", 450));
		bookList.put(103, new Book(103, "ehh", "Roxana", 500));
		bookList.put(104, new Book(104, "me", "Ricky", 1500));
		bookList.put(105, new Book(105, "you", "Zayn", 900));
	}

	public static Map<Integer, Book> getBookList() {
		return bookList;
	}

}

