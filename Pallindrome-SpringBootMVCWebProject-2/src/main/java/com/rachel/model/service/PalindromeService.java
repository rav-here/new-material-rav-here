package com.rachel.model.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
	
	public boolean getPalindrome(int number) {
		int reverse = 0;
		while (number !=0) {
			int remainder = number % 10;
			reverse = reverse * 10;
			reverse = reverse * remainder;
			number = number / 10;
		}
		
		if (number == reverse) {
			return true;
		}
		else {
			return false;
		}
	}

}
