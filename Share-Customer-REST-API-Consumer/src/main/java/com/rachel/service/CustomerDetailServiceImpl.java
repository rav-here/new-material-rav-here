package com.rachel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rachel.entity.Customer;
import com.rachel.entity.Share;
import com.rachel.entity.CustomerDetail;
import com.rachel.entity.CustomerList;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {

	// RestTemplate object is used to call REST API
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<CustomerDetail> getCustomerDetailByCustomerId(int customerId) {
		
		// declare empty list
		List<CustomerDetail> customerDetailList = new ArrayList<CustomerDetail>();
		
		// calling the Customer Rest API producer (or service) - using restTemplate object
		// and storing a list of the customers in a CustomerList object
		CustomerList customerList = restTemplate.getForObject("http://localhost:8082/customers/"+ customerId, CustomerList.class);
		
		// iterate over the Customer objects in customerList 
		for (Customer customer : customerList.getCustomers()) {
			
			// from every customer object (c), picking the share ID and calling the Share Rest API producer (or service)
			Share share = restTemplate.getForObject("http://localhost:8081/shares/" + customer.getShareId(), Share.class);
			
			// then create a CustomerDetail object using Customer and Share objects 
			CustomerDetail customerDetail = new CustomerDetail(customer.getCustomerId(), share.getShareName(), customer.getQuantity(), share.getMarketPrice(), (customer.getQuantity() * share.getMarketPrice()), customer.getShareType());
			
			// add the CustomerDetail object to the customerDetailList
			customerDetailList.add(customerDetail);
		}
		
		// return the CustomerDetailList
		return customerDetailList;
	}

}
