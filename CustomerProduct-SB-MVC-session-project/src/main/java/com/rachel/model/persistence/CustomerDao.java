package com.rachel.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rachel.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	public Customer findByCustomerIdAndPassword(int customerId,String password);
	
	// make JPQL query method for updating customer balance 
	@Modifying
	@Transactional
	@Query("update Customer set balance=balance-:cost, products=products+:quantity where customerId=:id")
	int updateBalanceAndProducts(@Param("cost") double cost, @Param("quantity") int quantity, @Param("id") int id);

}
