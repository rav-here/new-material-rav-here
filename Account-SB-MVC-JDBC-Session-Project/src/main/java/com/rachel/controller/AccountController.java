package com.rachel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.entity.Account;
import com.rachel.model.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
//	
//	@RequestMapping("/")
//	public ModelAndView loginPageController() {
//		return new ModelAndView("LoginPage");
//		
//	}
//	
//	@RequestMapping("/login")
//	public ModelAndView loginController() {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		if 
//	}
	
	@RequestMapping("/")
	public ModelAndView menuPageController() {
		return new ModelAndView("Index");
	}
	
	// ===========Search account by Id controllers===============
	@RequestMapping("/searchAccountByIDInputPage") 
	public ModelAndView searchAcountByIdPageController() {
		return new ModelAndView("InputForSearchAccount");
	}
	
	@RequestMapping("/searchAccountById") 
	public ModelAndView searchAccountByIdController(@RequestParam("accountId") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Account account = accountService.searchById(id);
		
		if (account != null) {
			modelAndView.addObject("account", account);
			modelAndView.setViewName("ShowAccount");
		}
		else {
			modelAndView.addObject("message", "Account with ID "+id+" does not exist");
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
	}
	
	// ============Send Money by Id controllers================
	@RequestMapping("/sendMoneyInputPage") 
	public ModelAndView sendMoneyInputPageController() {
		return new ModelAndView("InputForSendMoney");
	}
	@RequestMapping("/sendMoneyById") 
	public ModelAndView sendMoneyController(@RequestParam("accountId") int senderId, @RequestParam("accountId") int recipId, @RequestParam("amount") double amount) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		boolean moneySent = accountService.sendMoneyById(senderId, recipId, amount);
		
		if (moneySent) {
			message = "Money sent to Account with ID "+recipId+" from Account with "+senderId;
		}
		else {
			message = "Money could not be sent, Account with ID "+recipId+" does not exist";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
