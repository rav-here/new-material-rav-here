package com.sujata.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sujata.entity.Employee;
import com.sujata.entity.EmployeePaySlip;
import com.sujata.persistence.EmployeeDao;
import com.sujata.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	//Service will request persistence layer for all data needs
	// remove for dependency injection //private EmployeeDao employeeDao=new EmployeeDaoImpl();
	private EmployeeDao employeeDao;
	//constructor  
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.searchRecord(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		Employee emp=employeeDao.searchRecord(employee.getEmpId());
		if(emp!=null) {
			return false;
		}
		employeeDao.insertRecord(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		int employee=employeeDao.deleteRecord(id);
		if(employee!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
		Employee employee=employeeDao.searchRecord(id);
		if(employee==null) {
			return false;
		}
		employee.setEmpSalary(employee.getEmpSalary()+increment);
		employeeDao.insertRecord(employee);
		return true;
	}

	/*
	 * Business Rule
	 * AllowancesA : 18% of salary
	 * AllowanceB : 12% of salary
	 * Dedeuction : 8% of salary
	 */
	@Override
	public EmployeePaySlip generatePaySlip(int employeeId) {
		Employee employee=employeeDao.searchRecord(employeeId);
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePaySlip employeePaySlip=new EmployeePaySlip(employee, allowanceA, allowanceB, deduction,totalSalary);
			return employeePaySlip;
		}
		return null;
		
	}

	@Override
	public List<Employee> employeeByDepartment(String department) {
		Collection<Employee> emps = employeeDao.getAllRecords();
		List<Employee> empList = new ArrayList(); 
		for (Employee e: emps) {
			if (e.getEmpDepartment().equals(department)) {
				empList.add(e);
			}
		}
		if (empList.size() != 0) {
			return empList;
		}
		return null;
	}

}
