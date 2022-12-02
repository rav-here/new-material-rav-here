package com.rachel.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rachel.entity.Employee;
import com.rachel.entity.EmployeePayslip;
import com.rachel.model.persistence.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		Employee emp=employeeDao.findById(employee.getEmpId()).orElse(null);
		if(emp != null) {
			return false;
		}
		else {
			employeeDao.save(employee);
			return true;
		}
		
	}

	@Override
	public boolean deleteEmployee(int id) {
		if(searchEmployeeById(id) != null) {
			employeeDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
		if(employeeDao.updateSalary(id, increment) != 0) {
			return true;
		}

		return false;
	}

	/*
	 * Business Rule
	 * AllowancesA : 18% of salary
	 * AllowanceB : 12% of salary
	 * Dedeuction : 8% of salary
	 */
	@Override
	public EmployeePayslip generatePaySlip(int employeeId) {
		Employee employee=searchEmployeeById(employeeId);
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePayslip employeePaySlip=new EmployeePayslip(employee, allowanceA, allowanceB, deduction,totalSalary);
			return employeePaySlip;
		}
		return null;
		
	}

	@Override
	public List<Employee> employeeByDepartment(String department) {
//		Collection<Employee> emps = getAllEmployees();
//		List<Employee> empList = new ArrayList(); 
//		for (Employee e: emps) {
//			if (e.getEmpDepartment().equals(department)) {
//				empList.add(e);
//			}
//		}
//		if (empList.size() != 0) {
//			return empList;
//		}
//		return null;
		return employeeDao.findByEmpDepartment(department);
	}

}

