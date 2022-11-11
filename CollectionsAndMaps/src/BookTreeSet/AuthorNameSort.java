package BookTreeSet;

import java.util.Comparator;

public class AuthorNameSort implements Comparator<myBook> {

	@Override
	public int compare(myBook book1, myBook book2) {
		
		return book1.getAuthorName().compareTo(book2.getAuthorName());
	}

}