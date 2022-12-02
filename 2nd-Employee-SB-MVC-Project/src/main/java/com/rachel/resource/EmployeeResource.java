package com.rachel.resource;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rachel.entity.Employee;
import com.rachel.entity.EmployeePayslip;
import com.rachel.model.service.EmployeeService;

@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	
	// ============ resource for list all employees ==================
	@RequestMapping(path = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Employee> getAllEmployeesResource() {
		return employeeService.getAllEmployees();
	}
	// ============ resource for search employee by id ==================
	@RequestMapping(path = "/employees/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee searchEmployeeByIdResource(@PathVariable("eid") int id) {
		return employeeService.searchEmployeeById(id);
	}
	// ============ resource for generate employee pay-slip ==================
	@RequestMapping(path = "/employees/payslip/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeePayslip generateEmployeePayslipResource(@PathVariable("eid") int id) {
		return employeeService.generatePaySlip(id);
	}
	// ============ resource for search employee by department ==================
	@RequestMapping(path = "/employees/dep/{department}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> searchEmployeeByDepartmentResource(@PathVariable("department") String department) {
		return employeeService.employeeByDepartment(department);
	}
	// ============ resource for increment employee salary ==================
	@RequestMapping(path = "/employees/increment/{eid}/{inc}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean incrementEmployeeSalaryResource(@PathVariable("eid") int id, @PathVariable("inc") double inc) {
		return employeeService.incrementSalary(id, inc);
	}
//	// ============ resource for increment employee salary ==================
//	@RequestMapping(path = "/employees/add/{eid}/{name}/{designation}/{department}/{salary}/{doj}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public boolean incrementEmployeeSalaryResource(@PathVariable("eid") int id, @PathVariable("name") String name, @PathVariable("designation") String desig, @PathVariable("department") String dept, @PathVariable("salary") double sal, @PathVariable("doj") LocalDate doj) {
//		return employeeService.addEmployee(new Employee(id,name,desig,dept,sal,doj));
//	}
//	// ============ resource for delete employee by id ==================
//	@RequestMapping(path = "/employees/increment/{eid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public boolean deleteEmployeeByIdResource(@PathVariable("eid") int id) {
//		return employeeService.deleteEmployee(id);
//	}

}
