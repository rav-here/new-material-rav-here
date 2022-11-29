package com.rachel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.model.service.WelcomeService;

//@Controller is used to mark any class as controller
@Controller
public class WelcomeController {

		@Autowired
		private WelcomeService welcomeService;
		
		//Mapping Handler
		@RequestMapping("/first")
		//all controller methods must be public
		public ModelAndView myFirstController() {
			ModelAndView modelAndView=new ModelAndView();
			String greetMessage=welcomeService.welcome();
			//Setting data for viewing on view
			modelAndView.addObject("message", greetMessage);
			
			//Setting view name with is supposed to display output to the client
			modelAndView.setViewName("Greet");
			return modelAndView;
		}
		
		//Mapping Handler
		@RequestMapping("/second")
		//all controller methods must be public
		public ModelAndView mySecondController() {
			ModelAndView modelAndView=new ModelAndView();
			String greetMessage=welcomeService.morning();
			//Setting data for viewing on view
			modelAndView.addObject("message", greetMessage);
			
			//Setting view name with is supposed to display output to the client
			modelAndView.setViewName("Greet");
			return modelAndView;
		}
		
		//Mapping Handler
		@RequestMapping("/third")
		//all controller methods must be public
		public ModelAndView myThirdController() {
			ModelAndView modelAndView=new ModelAndView();
			String greetMessage=welcomeService.evening();
			//Setting data for viewing on view
			modelAndView.addObject("message", greetMessage);
			
			//Setting view name with is supposed to display output to the client
			modelAndView.setViewName("Greet");
			return modelAndView;
		}
		

}
