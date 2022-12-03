package com.rachel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.entity.Customer;
import com.rachel.entity.CustomerReceipt;
import com.rachel.model.service.CustomerService;

@Controller
public class CustomerController {
	
	// need a controller for each page and functionality of Web-Application
	
	@Autowired
	private CustomerService customerService;
	
	// ==================Controllers for Login ========================
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("Login");
	}
	@RequestMapping("/login")
	public ModelAndView loginController(@RequestParam("customerId") int id, @RequestParam("password") String password,  HttpSession session) {
		
		// instantiate empty/blank MAV object 
		ModelAndView modelAndView = new ModelAndView();
		
		// run login-check method of service 
		Customer customer = customerService.loginCheck(id, password);
		
		// if the customer login check is passed
		if (customer != null) {
			// add the customer object to MAV
			modelAndView.addObject("customer", customer);
			// set attribute in session
			session.setAttribute("customer", customer);
			// show the Main Menu view on the web app
			modelAndView.setViewName("MainMenu");
		}
		// if login check is failed
		else { 
			// display message on selected view
			modelAndView.addObject("message", "Unable to Login, Customer Details Incorrect.");
			// reset customer object for another login try
			modelAndView.addObject("customer", new Customer());
			// show the Login page on the web app
			modelAndView.setViewName("Login");
		}
		
		return modelAndView;
	}
	
	// ==================Controllers for Main Menu ========================
	@RequestMapping("/menu")
	public ModelAndView mainMenuPageController() {
		return new ModelAndView("MainMenu");
	}
	
	// ==================Controllers for Customer Buying Product ========================
	@RequestMapping("/buyProductByIdInputPage")
	public ModelAndView buyProductByIdInputPageController() {
		return new ModelAndView("InputForBuyProduct");
	}
	@RequestMapping("/buyProductById")
	public ModelAndView buyProductByIdController(HttpServletRequest request, HttpSession session) {
		
		// instantiate empty/blank MAV object 
		ModelAndView modelAndView = new ModelAndView();
		// get client input for product and quantity of product being bought
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		// get customer Id of the currently logged in customer
		Customer customerObj = (Customer) session.getAttribute("customer");
		int customerId = customerObj.getCustomerId();
		// get the receipt object of the customer product purchase
		CustomerReceipt receipt = customerService.customerBuysProduct(customerId, productId, quantity);
		
		// if the receipt object is not null
		if (receipt != null) {
			// add the receipt object and success message to the modelAndView object
			modelAndView.addObject("receipt", receipt);
			// show the customer receipt page on web app
			modelAndView.setViewName("ShowCustomerReceipt");
		}
		// if the receipt object is null
		else {
			// display failure message
			modelAndView.addObject("message", "Failed to purchase product! Either your balance is too low or the product does not exist!");
			// show output page to web app
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
		
		
	}
	
}
