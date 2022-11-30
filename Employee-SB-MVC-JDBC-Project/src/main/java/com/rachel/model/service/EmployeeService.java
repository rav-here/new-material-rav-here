package com.rachel.model.service;

import java.util.Collection;
import java.util.List;

import com.rachel.entity.Employee;
import com.rachel.entity.EmployeePayslip;

public interface EmployeeService {

	Collection<Employee> getAllEmployees();
	
	Employee searchEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean deleteEmployee(int id);
	
	boolean incrementSalary(int id,double increment);
	
	EmployeePayslip generatePaySlip(int employeeId);
	
	List<Employee> employeeByDepartment(String department);
}
