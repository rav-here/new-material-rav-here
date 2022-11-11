package BookTreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


// this main class uses myBook class 
// the comparator allows us to build classes (AuthorNmaeSort, NoOfPagesSort) which implement the comparator interface to override the compare method 
// then we can choose what one to implement in the internal workings of the add method when building a tree set

public class myBooktreeSetMain {

	public static void main(String args[]) {
		/*
		 * TreeSet : unique sorted collection of values, which is auto-growable and auto-shrinkable 
		 */
//		Set<MyBook> myCollection=new TreeSet<MyBook>(new AuthorNameSort());
		Set<myBook> myCollection=new TreeSet<myBook>(new NoOfPagesSort());
		System.out.println("Size : "+myCollection.size());
		myCollection.add(new myBook(101, "Book 1", "Author A", 450, 1200));
		myCollection.add(new myBook(102, "Book 2", "Author B", 950, 1000));
		myCollection.add(new myBook(103, "Book 3", "Author Z", 870, 2100));
		myCollection.add(new myBook(104, "Book 4", "Author C", 350, 800));
		myCollection.add(new myBook(105, "Book 5", "Author M", 1450, 3200));
		
		System.out.println("Size : "+myCollection.size());
		System.out.println(myCollection);
		
		myCollection.add(new myBook(101, "Book 1", "Author A", 450, 1200));
		myCollection.add(new myBook(102, "Book 6", "Author X", 4150, 1900));
		
		System.out.println("Size : "+myCollection.size());
		System.out.println(myCollection);
		
		
		System.out.println("Traversal using for each loop");
		for(myBook element:myCollection) {
			System.out.println(element);
		}

		System.out.println("Traversal using Iterator");
		Iterator<myBook> iterator=myCollection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		

	}
}