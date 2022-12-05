package com.rachel.resource;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	// method: GET, POST, PUT, DELETE - request http methods! 
	// produces: produces the object in the requested media type, specifies which media type(s) of representations a resource can give to the client
	// consumes: consume the object with the requested media type, specifies which media type(s) of representations a resource can accept from the client

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
	@RequestMapping(path = "/employees/{eid}/{inc}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
	public String incrementEmployeeSalaryResource(@PathVariable("eid") int id, @PathVariable("inc") double inc) {
		if (employeeService.incrementSalary(id, inc)) {
			return "Salary Incremented";
		}
		else {
			return "Salary NOT Incremented";
		}
		
	}
	// ============ resource for adding employee ==================
	// path/URL is same as get method above but this is a post method so naming match doesn't matter
	@RequestMapping(path = "/employees", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addEmployeeResource(@RequestBody Employee employee) {
		 if (employeeService.addEmployee(employee)) {
			 return "Record Added";
		 }
		 else {
			 return "Record NOT Added";
		 }
		 
	}
	// ============ resource for delete employee by id ==================
	@RequestMapping(path = "/employees/{eid}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteEmployeeByIdResource(@PathVariable("eid") int id) {
		if (employeeService.deleteEmployee(id)) {
			return "Record Deleted";
		}
		else {
			return "Record NOT Deleted";
		}
	}

}
