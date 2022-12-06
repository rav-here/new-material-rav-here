package com.zoe.customer.resource;

import com.zoe.customer.entity.Customer;
import com.zoe.customer.entity.CustomerList;
import com.zoe.customer.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerResource {

    @Autowired
    private CustomerService customerService;


    @GetMapping(path = "/customers/{cId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerList searchCustomerByCustomerId (@PathVariable("cId") int customerId) {
        return new CustomerList(customerService.searchCustomerByCustomerId(customerId));
    }
}
