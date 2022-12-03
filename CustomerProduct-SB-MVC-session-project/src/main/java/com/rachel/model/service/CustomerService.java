package com.rachel.model.service;

import com.rachel.entity.CustomerReceipt;
import com.rachel.entity.Customer;

public interface CustomerService {
	
	Customer loginCheck(int customerId, String password);

	CustomerReceipt customerBuysProduct(int customerId, int productId, int quantity);
}
