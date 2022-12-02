package com.rachel.controller;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.entity.Account;
import com.rachel.model.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("LoginPage");
		
	}
	
	@RequestMapping("/login")
	public ModelAndView loginController(@ModelAttribute("account") Account account, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (accountService.loginCheck(account.getAccountId(), account.getPassword())) {
			modelAndView.addObject("account", account);  //request scope
			session.setAttribute("account", account);  //data is set on session scope i.e data available in multiple request and response cycles
			modelAndView.setViewName("index");
		}
		else {
			modelAndView.addObject("message", "Invalid Account Credentials, Please try again");
			modelAndView.addObject("account", new Account());
			modelAndView.setViewName("LoginPage");
		}
		return modelAndView;
	}
	
	@RequestMapping("/menu")
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
	public ModelAndView sendMoneyController(HttpSession session, @RequestParam("accountId") int recipId, @RequestParam("amount") double amount) {
		
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		
		Account sender = (Account) session.getAttribute("account");
		int senderId = sender.getAccountId();
		
		boolean moneySent = accountService.sendMoneyById(senderId, recipId, amount);
		
		if (moneySent) {
			message = "Money sent to Account with ID "+recipId+" from Account with ID "+senderId;
		}
		else {
			message = "Money could not be sent, Account with ID "+recipId+" does not exist";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
		
	}
//	@RequestMapping("/sendMoneyById") 
//	public ModelAndView sendMoneyController(HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
//		String message = null;
//		int senderId = Integer.parseInt(request.getParameter("accountId"));
//		int recipId = Integer.parseInt(request.getParameter("accountId"));
//		double amount = Double.parseDouble(request.getParameter("amount"));
//		boolean moneySent = accountService.sendMoneyById(senderId, recipId, amount);
//		
//		if (moneySent) {
//			message = "Money sent to Account with ID "+recipId+" from Account with ID "+senderId;
//		}
//		else {
//			message = "Money could not be sent, Account with ID "+recipId+" does not exist";
//		}
//		
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("Output");
//		return modelAndView;
//		
//	}
	
	
	

}
