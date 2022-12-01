package com.rachel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rachel.entity.Employee;
import com.rachel.entity.EmployeePayslip;
import com.rachel.model.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public ModelAndView menuPageController() {
		return new ModelAndView("index");
	}
	
	//=============Controller for List all functionality==================
	@RequestMapping("/showAll")
	public ModelAndView getAllEmployeesController() {
		ModelAndView modelAndView=new ModelAndView();
		Collection<Employee> empList=employeeService.getAllEmployees();
		
		modelAndView.addObject("employees", empList);
		modelAndView.setViewName("ShowAllEmployees");
		return modelAndView;
	}
	
	//==============Controllers for Add functionality===============
	@RequestMapping("/addEmpPage")
	public ModelAndView addEmployeePageController() {
		return new ModelAndView("InputForAdd");
	}
	@RequestMapping("/addEmployee") 
	public ModelAndView addEmployeeController(HttpServletRequest request) {
		
		ModelAndView modelAndView=new ModelAndView();
		int eId = Integer.parseInt(request.getParameter("empId"));
		String name = request.getParameter("name");
		String des = request.getParameter("designation");
		String dep = request.getParameter("department");
		double sal = Double.parseDouble(request.getParameter("salary"));
		LocalDate doj = LocalDate.parse(request.getParameter("doj"));
		
		Employee emp = new Employee(eId, name, des, dep, sal, doj);
		String message = null;
		Employee employee = employeeService.searchEmployeeById(eId);
		
		if (employeeService.addEmployee(emp)) {
			message="Employee with ID "+ eId+ " added";
		}
		else {
			message="Employee with ID "+ eId +" already exists";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
		
	}
	
	// ==============Controllers for Delete functionality=========================
	
	@RequestMapping("/deleteEmpPage")
	public ModelAndView deletePageController() {
		return new ModelAndView("InputIdForDelete");
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployeeController(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		int eId = Integer.parseInt(request.getParameter("empId"));
		String message = null;
		
		if(employeeService.deleteEmployee(eId)) {
			message="Employee Deleted with ID "+ eId;
		}
		else {
			message="Employee with ID "+ eId +" does not exist";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	// =============Controllers for increment salary functionality==================
	
	@RequestMapping("/incrementSalaryPage")
	public ModelAndView incrementSalaryPageController() {
		return new ModelAndView("InputIdForIncrement");
	}
	@RequestMapping("/incrementSalary")
	public ModelAndView incrementSalaryController(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		int eId = Integer.parseInt(request.getParameter("empId"));
		double inc = Double.parseDouble(request.getParameter("increment"));
		String message = null;
		
		if (employeeService.incrementSalary(eId, inc)) {
			message = "Employee Salary incremented for employee "+eId;
		}
		else {
			message = "Employee with ID"+ eId +" does not exist";
		}
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
	
	// ==============Controllers for Search by Id functionality================
	
	@RequestMapping("/searchEmpByIdPage")
	public ModelAndView searchByIdInputPageController() {
		return new ModelAndView("InputIdForSearch");
	}
	@RequestMapping("/searchEmployeeById")
	public ModelAndView searchByIdController(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		int eId = Integer.parseInt(request.getParameter("empId"));
		
		Employee employee = employeeService.searchEmployeeById(eId);
		
		if (employee != null) {
			modelAndView.addObject("employee", employee);
			modelAndView.setViewName("ShowEmployee");
		}
		else {
			modelAndView.addObject("message", "Employee with ID "+eId+" does not exist");
			modelAndView.setViewName("Output");
			
		}
		return modelAndView;
		
	}
	
	//=============Controllers for Search By Department Name==================
	@RequestMapping("/searchEmpByDepartmentInputPage")
	public ModelAndView searchByDepartmentInputPageController() {
		return new ModelAndView("InputDepartmentForSearch");
	}
	
	@RequestMapping("/searchEmployeeByDepartment")
	public ModelAndView searchByDepartmentController(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		String deptt = request.getParameter("department");
		List<Employee> empList=employeeService.employeeByDepartment(deptt);
		
		if(empList.size()>0) {
			modelAndView.addObject("employees", empList);
			modelAndView.setViewName("ShowAllEmployees");
		}else {
			modelAndView.setViewName("Output");
			modelAndView.addObject("message", "No Employee works in department "+deptt);
		}
		
		return modelAndView;
	}
	
	// =============Controllers for Generate pay slip=================
	@RequestMapping("/generatePayslipPage")
	public ModelAndView geeratePayslipInputPageController() {
		return new ModelAndView("InputIdForPayslip");
	}
	@RequestMapping("/generatePayslipById")
	public ModelAndView generatePaslipController(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		int eId = Integer.parseInt(request.getParameter("empId"));
		//Employee employee = employeeService.searchEmployeeById(eId);
		EmployeePayslip empPS = employeeService.generatePaySlip(eId);
		
		if (empPS != null) {
			modelAndView.addObject("payslip", empPS);
			modelAndView.setViewName("ShowPayslip");
		}
		else {
			modelAndView.addObject("message", "Employee with ID "+eId+" does not exist");
			modelAndView.setViewName("Output");
			
		}
		return modelAndView;
		
	}
		
}
