package Numbers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashAndEqualsNumberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//hashMap
		Set<HashAndEqualsNumber> numbCollection = new HashSet<HashAndEqualsNumber>();
		
		//user prompts
		System.out.println("entering 10 numbers");
		
		for(int i=0; i<10; i++) {
			System.out.println("Please enter " + (i+1) + " number : ");
			numbCollection.add(new HashAndEqualsNumber(i, sc.nextInt()));		
		}
		
		//now displaying the hashSet via iterator 
		Iterator<HashAndEqualsNumber> iterator = numbCollection.iterator();
		
		//no duplicates displayed 
		System.out.println("collection of numbers with no duplicates:");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		int numbSize = numbCollection.size();
		
		//CAN USE getNumber() TO CHECK IF the number is in the hashList 
		//GETNUMB IS FROM LOMBOK
		//can get to 10 elements by using size()
		System.out.println("There are " + numbSize +
				" numbers in the collection, add " + (10-numbSize) + 
				" more unique numbers:");
		
		int i=10;
		while(numbCollection.size() < 10) {
			numbSize = numbCollection.size();
			System.out.println("Please enter " + (numbSize+1) +
					" number: "); 
			numbCollection.add(new HashAndEqualsNumber(i+1, sc.nextInt()));
			i++;
		}
		
		System.out.println("The collection of 10 numbers: ");
		//displaying all 10 numbers
		for(HashAndEqualsNumber numbs:numbCollection) {
			System.out.println(numbs);
		}
	}
		
}
