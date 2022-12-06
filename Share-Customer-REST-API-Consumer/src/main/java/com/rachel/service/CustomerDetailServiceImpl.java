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
		CustomerList customerList = restTemplate.getForObject("Url"+ customerId, CustomerList.class);
		
		// iterate over the Customer objects in customerList 
		for (Customer cust : customerList.getCustomers()) {
			
			// from every customer object (c), picking the share ID and calling the Share Rest API producer (or service)
			Share share = restTemplate.getForObject("Url" + cust.getShareId(), Share.class);
			
			// then create a CustomerDetail object using Customer and Share objects 
			CustomerDetail customerDetail = new CustomerDetail(cust.getCustomerId(), share.getShareName(), cust.getQuantity(), share.getMarketPrice(), (cust.getQuantity() * share.getMarketPrice()), cust.getShareType());
			
			// add the CustomerDetail object to the customerDetailList
			customerDetailList.add(customerDetail);
		}
		
		// return the CustomerDetailList
		return customerDetailList;
	}

}
