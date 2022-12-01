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

	//JPQL
	@Modifying
	@Transactional
	@Query("update AccountsTable set balance=balance+:amo where accountId=:id")
	int updateBalance(@Param("id") int id,@Param("amo") double amount);
}
