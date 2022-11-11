package Numbers;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MainNumbers {
	
	public static void main(String[] args) {
		// scanner
		Scanner scan = new Scanner(System.in);
		// declare set 
		Set<Number> numbers = new LinkedHashSet<Number>();
		// print prompt
		System.out.println("Let's create a collection of 10 numbers!");
		
		// loop over 10 indexes of set called i
		for (int i=0; i<10;) { // take out the i++ to stop automatic iteration increase 
			
			// prompt for number
			System.out.println("Please enter a number");
			// store input for number
			int num = scan.nextInt();
			// create number object with index i 
			Number number = new Number(num, i);
			
			// checking for duplicate numbers
			int yes = 0;
			// for all the numbers in the collection
			for (Number n: numbers) {
				// if the new number is already in the collection
				if (n.getNumber() == num) { 
					// print message
					System.out.println("That number is already in the set!");  
					// add one to yes
					yes += 1; 
				}
			} 
			// if yes is zero - meaning no the new number is not used already 
			if (yes == 0) {
				// add it to the collections
				numbers.add(number);
				i += 1; // if the number is new add one to i (move iteration)
			}
			// otherwise i will remain the same and you will need to add another number

		}
		
		// display linked set of numbers and indexes 
		for (Number n: numbers) {
			System.out.println(n);
		}
	}
	

}
