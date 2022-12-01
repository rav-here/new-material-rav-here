package com.rachel.model.service;

import com.rachel.entity.Account;

public interface AccountService {
	
	Account searchById(int id);
	boolean sendMoneyById(int senderId, int recipId, double amount);
	

}
