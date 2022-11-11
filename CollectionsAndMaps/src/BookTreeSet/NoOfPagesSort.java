package BookTreeSet;

import java.util.Comparator;

public class NoOfPagesSort implements Comparator<myBook> {

	@Override
	public int compare(myBook book1, myBook book2) {
		
		if(book1.getNoOfPages()>book2.getNoOfPages())
			return 1;
		else if(book1.getNoOfPages()<book2.getNoOfPages())
			return -1;
		else if(book1.equals(book2))
			return 0;
			
		return 1;
	}

}
