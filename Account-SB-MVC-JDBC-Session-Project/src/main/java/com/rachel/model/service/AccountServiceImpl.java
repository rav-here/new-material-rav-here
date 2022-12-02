package com.rachel.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachel.entity.Account;
import com.rachel.model.persistence.AccountDao;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account loginCheck(int accountId, String password) {
		
		Account accObj = accountDao.findByAccountIdAndPassword(accountId, password);
		if (accObj != null) {
			return accObj;
		}
		else {
			return null;
		}
			
	}
	
	@Override
	public Account searchById(int id) {
		return accountDao.findById(id).orElse(null);
	}
	
	@Override
	public boolean sendMoneyById(int senderId, int recipId, double amount) {
		
		// use searchById method to get our account objects for sender and recip
//		Account senderObj = searchById(senderId);
//		Account recipObj = searchById(recipId);
		
		
		// if the account object of the recip exists
		//if (recipObj != null) {
		
		int senderBalance = accountDao.updateBalance(senderId, -amount);
		int recipBalance = accountDao.updateBalance(recipId, amount);
		if (senderBalance !=0 && recipBalance !=0) {	
			
			
//			// get balance value
//			double recipBalance = recipObj.getBalance();
//			// add to recip balance value
//			recipBalance += amount;
//			// reset recip balance value
//			recipObj.setBalance(recipBalance);
//			
//			// get balance value
//			double senderBalance = senderObj.getBalance();
//			// take away from sender balance value
//			senderBalance -= amount;
//			// reset sender balance value
//			senderObj.setBalance(senderBalance);
//			
			return true;
		}
		// if the account object of the recip does not exist
		else {
			return false;
		}
		
		
	}

	

}
