package com.rachel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.model.service.palindromeService;

@Controller
public class palindromeController {
	
	@Autowired 
	private palindromeService palindromeService;
	
	@RequestMapping("/")
	public ModelAndView mainPageController() {
		return new ModelAndView("index");
	}

	@RequestMapping("/calculate")
	public ModelAndView isItPalindromeController(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		int num = Integer.parseInt(request.getParameter("number"));
		boolean rev = palindromeService.getPalindrome(num);
		modelAndView.addObject("pal", rev);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
}
