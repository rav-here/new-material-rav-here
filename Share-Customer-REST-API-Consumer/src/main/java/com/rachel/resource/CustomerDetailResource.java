package com.rachel.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rachel.entity.CustomerDetailList;
import com.rachel.service.CustomerDetailService;

@RestController
public class CustomerDetailResource {
	
	@Autowired
	private CustomerDetailService customerDetailService;
	
	@GetMapping(path = "/share/customers/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDetailList getCustomerDetailByCustomerIdResource(@PathVariable("cid") int customerId) {
		return new CustomerDetailList(customerDetailService.getCustomerDetailByCustomerId(customerId));
	}

}
