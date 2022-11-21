package streamExercise;

import java.util.Arrays;
import java.util.List;

public class FirstDemo {
	
	public static void main(String[] args) {
		
		// asList is a method of the arrays class (shortcut for making an array without using array.add)
		// could make array list then add to it separately instead
		List<Integer> list = Arrays.asList(10,21,32,47,59);
		List<Integer> list2 = Arrays.asList(-1,-20,-8,8,90,-65,0);
		
		System.out.println("Total No of Element in list 1 :"+list.stream().count());
		System.out.println("Total No of Element in lis 2 :"+list2.stream().count());
		
		// anonymous inner class way
//		long totalNoOfEvenElement=list.stream().filter(new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				
//				return t%2==0;
//			}
//		}).count();
		
		
		// lambda way (return type of .count() method is long)
		// using filter to filter to find even numbers in the list
		// then using count to count how many numbers in the list satisfy the filter
		long totalNoOfEvenElement=list.stream().filter((t)-> t%2==0).count();
		System.out.println("Total No of even Element in list 1: "+totalNoOfEvenElement);

		long totalNegativeElement = list2.stream().filter((t) -> t<0).count();
		System.out.println("Total No of negative Element in list 2: "+totalNegativeElement);
		
		// using filter to find negative numbers in list, 
		// using map to convert the type of the elements in the list, 
		// using for each to print out each element of the list that satisfies the filter
		list2.stream().filter((element) -> element<0).map((element) -> element*(-1)).forEach(element -> System.out.println(element));
		// print full list with all negative numbers multiplied by -1 - using if statement in map
		list2.stream().map(t -> { 
			if(t < 0) {
				t= t * (-1); 
				}
			return t;
			}).forEach(t -> System.out.println(t));
	
	}


}
