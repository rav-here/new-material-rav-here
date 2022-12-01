package com.rachel.model.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rachel.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{

	public Account findByAccountIdAndPassword(int accountId,String password);
	
	//JPQL
	@Modifying
	@Transactional
	@Query("update Account set balance=balance+:amount where accountId=:id") //have to use the class name NOT the table name
	int updateBalance(@Param("id") int id,@Param("amount") double amount);
}
