package com.zoe.customer.persistence;

import com.zoe.customer.entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository <Customer, Integer> {

    public List<Customer> searchCustomerByCustomerId (int customerId);

}
