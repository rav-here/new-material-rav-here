package com.rachel.model.persistence;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rachel.entity.Employee;

/*
 * DAO : Data Access Object : Design Pattern to design persistence layer
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findByEmpDepartment(String department);

	//JPQL
	@Query("from Employee where empDesignation=:des")
	List<Employee> searchEmployeeByDesignation(@Param("des") String designation);

	
	//JPQL
	@Modifying
	@Transactional
	@Query("delete from Employee where empName=:na")
	int deleteByName(@Param("na") String name);

	
	//JPQL
	@Modifying
	@Transactional
	@Query("update Employee set empSalary=empSalary+:inc where empId=:id")
	int updateSalary(@Param("id") int id,@Param("inc") double increment);
}