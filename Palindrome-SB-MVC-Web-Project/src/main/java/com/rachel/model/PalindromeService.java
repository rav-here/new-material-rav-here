package com.rachel.model;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
	
	// method for finding out whether a number's reverse equals itself
	public boolean getPalindrome(int number) { // returns boolean T or F
		
		// initialise reverse and num variables
		int reverse = 0;
		int num = number;
		
		// while the number is non-zero
		while (num !=0) {
			
			// get the remainder after the number is divided by 10 (modulus of 10)
			// i.e what's after the decimal 1234 % 10 = 4
			int remainder = num % 10;
			// times the reverse number by 10 and reset its value to this
			reverse = reverse * 10;
			// add the remainder to the reverse
			reverse = reverse + remainder;
			// divide current num by 10 (removes the numbers last digit essentially)
			num = num / 10;
		}
		
		// if the number is a palindrome return true 
		if (number == reverse) {
			return true;
		}
		// if the number is not a palindrome return false
		else {
			return false;
		}
	}

}

