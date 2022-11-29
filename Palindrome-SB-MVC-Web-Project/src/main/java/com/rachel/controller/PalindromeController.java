package com.rachel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.model.PalindromeService;

// controller used to mark any class as controller 
@Controller
public class PalindromeController {
	
	// controller communicates with the service to get data etc
	@Autowired 
	private PalindromeService palindromeService;
	
	// Make Mapping Handler 
	@RequestMapping("/")
	public ModelAndView mainPageController() {
		
		// specify the name of the view that is to be used to display the mainPage of the webApp
		return new ModelAndView("index");
	}

	// Make Mapping Handler - will tell Dispatch Servlet what controller to use based on reference used in URL
	@RequestMapping("/calculate")  // ref = /calculate
	public ModelAndView isItPalindromeController(HttpServletRequest request) {
		
		// ModelAndView is what the controller returns to the Dispatch Servlet 
		// it contains the data collected and specifies which view it should be displayed using
		ModelAndView modelAndView = new ModelAndView();
		// parse web input into integer data type
		int num = Integer.parseInt(request.getParameter("number"));
		// store the returned value of the getPalindrome method from the service layer
		boolean rev = palindromeService.getPalindrome(num);
		// assign the data (returned value) to the reference "pal" for html file use
		modelAndView.addObject("pal", rev);
		// specify the name of the view that is to display the data on the webApp
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
}
