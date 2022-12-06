package com.rachel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.entity.CustomerDetail;
import com.rachel.service.CustomerDetailService;

@Controller
public class CustomerDetailController {
	
	@Autowired
	CustomerDetailService customerDetailService;
	
	@RequestMapping("/")
	public ModelAndView getCustomerInputPage() {
		return new ModelAndView("InputCustomerId");
	}
	
	@RequestMapping("/checkCustomer") 
	public ModelAndView checkCustomerController(@RequestParam("customerId") int customerId) {
		// create empty MAV object
		ModelAndView modelAndView = new ModelAndView();
		// get CustomerDetail object list via service layer object
		List<CustomerDetail> customerDetails = customerDetailService.getCustomerDetailByCustomerId(customerId);
		System.out.println(customerDetails);
		// add the list to the MAV object
		modelAndView.addObject("customerDetails", customerDetails);
		// add the customerId field to MAV object
		modelAndView.addObject("customerId", customerId);
		// set the view that will display info on the web app
		modelAndView.setViewName("ShowDetails");
		// return MAV object
		return modelAndView;
	}

}
