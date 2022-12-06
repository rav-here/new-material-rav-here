package com.zoe.customer.service;

import com.zoe.customer.entity.Customer;
import com.zoe.customer.persistence.CustomerDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> searchCustomerByCustomerId(int customerId) {
        return customerDao.searchCustomerByCustomerId(customerId);
    }
}
