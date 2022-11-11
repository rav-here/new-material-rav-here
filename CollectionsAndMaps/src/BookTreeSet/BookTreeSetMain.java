package BookTreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//this main class uses Book class which implements the comparable interface
//the comparator allows us to override the compareTo method 
//this changes the internal workings of the add method when building a tree set in main


public class BookTreeSetMain {

	public static void main(String args[]) {
		/*
		 * TreeSet : unique sorted collection of values, which is auto-growable and auto-shrinkable 
		 */
		Set<Book> myCollection=new TreeSet<Book>();
		
		System.out.println("Size : "+myCollection.size());
		myCollection.add(new Book(101, "Book 1", "Author A", 450, 1200));
		myCollection.add(new Book(102, "Book 2", "Author B", 950, 1000));
		myCollection.add(new Book(103, "Book 3", "Author A", 870, 2100));
		myCollection.add(new Book(104, "Book 4", "Author C", 350, 800));
		myCollection.add(new Book(105, "Book 5", "Author M", 1450, 3200));
		
		System.out.println("Size : "+myCollection.size());
		System.out.println(myCollection);
		
		myCollection.add(new Book(101, "Book 1", "Author A", 450, 1200));
		myCollection.add(new Book(102, "Book 6", "Author X", 4150, 1900));
		
		System.out.println("Size : "+myCollection.size());
		System.out.println(myCollection);
		
		
		System.out.println("Traversal using for each loop");
		for(Book element:myCollection) {
			System.out.println(element);
		}

		System.out.println("Traversal using Iterator");
		Iterator<Book> iterator=myCollection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		

	}
}