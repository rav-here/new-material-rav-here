package com.zoe.customer.service;


import java.util.List;

import com.zoe.customer.entity.Customer;

public interface CustomerService {

    List<Customer> searchCustomerByCustomerId (int customerId);
}
