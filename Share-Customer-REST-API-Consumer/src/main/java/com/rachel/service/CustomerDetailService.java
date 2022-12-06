package com.rachel.service;

import java.util.List;

import com.rachel.entity.CustomerDetail;

public interface CustomerDetailService {
	
	List<CustomerDetail> getCustomerDetailByCustomerId(int customerId);

}
