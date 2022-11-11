package BookTreeSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book implements Comparable<Book> {

	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfPages;
	private int price;
	/*
	 * TreeSet will be using compareTo to arrange objects in ascending order and will store unique
	 * if object1 (this) is greater return :1
	 * if object2(argument) is greater return : -1
	 * if both objects are equal : 0
	 */
	@Override
	public int compareTo(Book book2) {
		// if book1 price is greater than book 2 price
		if(price>book2.price)
			return 1; // store object left subtree
		// opposite
		else if(price<book2.price)
			return -1; // store object in right subtree
		// equal books
		else if(this.equals(book2))
			return 0; // objects are duplicate so don't store in the set
		// by convention: if price is the same but not the same book object as a whole, store object in left subtree
		return 1; 
	}
	// the above method is used internally in the add method for the tree set class
}	// it orders the objects in ascending order, you would switch operators if you wanted descending order
