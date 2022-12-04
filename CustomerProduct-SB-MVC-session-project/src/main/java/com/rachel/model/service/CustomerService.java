package com.rachel.model.service;

import com.rachel.entity.CustomerReceipt;
import com.rachel.entity.Product;

import java.util.Collection;

import com.rachel.entity.Customer;

public interface CustomerService {
	
	Collection<Product> showAllProducts();
	
	Customer loginCheck(int customerId, String password);

	CustomerReceipt customerBuysProduct(int customerId, int productId, int quantity);
	
	
}
