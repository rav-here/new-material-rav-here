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
public class myBook {
	
	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfPages;
	private int price;

}
