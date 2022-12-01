package com.rachel.model.service;

import com.rachel.entity.Account;

public interface AccountService {
	
	boolean loginCheck(int accountId, String password);
	Account searchById(int id);
	boolean sendMoneyById(int senderId, int recipId, double amount);
	

}
