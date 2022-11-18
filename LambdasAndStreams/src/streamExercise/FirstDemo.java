package streamExercise;

import java.util.Arrays;
import java.util.List;

public class FirstDemo {
	
	public static void main(String[] args) {
		
		// asList is a method of the arrays class (shortcut for making an array without using array.add)
		// could make array list then add to it separately instead
		List<Integer> list = Arrays.asList(10,21,32,47,59);
		List<Integer> list2 = Arrays.asList(-1,-20,-8,8,90,-65,0);
		
		System.out.println("Total No Of Element in list 1 :"+list.stream().count());
		System.out.println("Total No Of Element in lis 2 :"+list2.stream().count());
		
		// anonymous inner class way
//		long totalNoOfEvenElement=list.stream().filter(new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				
//				return t%2==0;
//			}
//		}).count();
		
		// lambda way (return type of .count() method is long)
		long totalNoOfEvenElement=list.stream().filter((t)-> t%2==0).count();
		System.out.println("Total No Of even Element in list 1: "+totalNoOfEvenElement);

		long totalNegativeElement = list2.stream().filter((t) -> t<0).count();
		System.out.println("Total Nop of negative Element in list 2: "+totalNegativeElement);
	}


}
