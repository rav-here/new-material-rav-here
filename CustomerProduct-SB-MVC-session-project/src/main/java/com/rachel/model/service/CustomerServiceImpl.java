package com.rachel.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachel.entity.Customer;
import com.rachel.entity.CustomerReceipt;
import com.rachel.entity.Product;
import com.rachel.model.persistence.CustomerDao;
import com.rachel.model.persistence.ProductDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Customer loginCheck(int customerId, String password) {
		// find customer object 
		Customer customer = customerDao.findByCustomerIdAndPassword(customerId, password);
		if (customer != null) {
			return customer;
		}
		return null;
	}
	
	@Override
	public CustomerReceipt customerBuysProduct(int customerId, int productId, int quantity) {
		
		// find customer and product objects using their respective IDs
		Customer customer = customerDao.findById(customerId).orElse(null);
		Product product = productDao.findById(productId).orElse(null);
		
		// if both the product and customer objects exist and the stock can handle the purchase
		if (product !=null && customer !=null && quantity < (product.getStock())) {
			// convert data type of quantity for finding total cost, store as new variable 
			double doubleQ = (double) quantity;
			// find the total cost of the quantity of products wanted
			double cost = doubleQ * (product.getCostPerUnit());
			// set new products value for customer buying products
			int prods = customer.getProducts();
			prods = prods + quantity;
			// use DAO JPQL methods to update balance+products of customer and stock of product
			int updateCB = customerDao.updateBalanceAndProducts(cost, prods, customerId);
			int updatePS = productDao.updateProductStock(quantity, productId);
			
			// if the cost is not too expensive for the customer, and the update methods return a positive value (meaning they worked)
			if (cost < (customer.getBalance()) && updateCB !=0 && updatePS !=0) {
				return new CustomerReceipt(customer, product, quantity, cost);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		
	}

	

}
