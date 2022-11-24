package com.sujata.persistence;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.Collection;
//import java.util.Date;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//import com.sujata.database.EmployeeDataBase;
import com.sujata.entity.Employee;

@Component("dao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Collection<Employee> getAllRecords() {
		
		// this is a query command in mySQL so DQL
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//
//		Collection<Employee> employeeList = new ArrayList<Employee>();
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//
//			preparedStatement = connection.prepareStatement("SELECT * FROM EMP");
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				int id = resultSet.getInt("EMPLOYEEID");
//				String name = resultSet.getString("EMPLOYEENAME");
//				String desig = resultSet.getString("DESIGNATION");
//				String deptt = resultSet.getString("DEPARTMENT");
//				double sal = resultSet.getDouble("SALARY");
//				LocalDate doj = resultSet.getDate("DOJ").toLocalDate();
//
//				employeeList.add(new Employee(id, name, desig, deptt, sal, doj));
//			}
//
//		} 
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		finally {
//			try {
//				//4.Close
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return employeeList;
		return null;
	}	


	@Override
	public Employee searchRecord(int id) {
		
//		// another query command DQL
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//
//		Employee employee = null;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//
//			preparedStatement = connection.prepareStatement("SELECT * FROM EMP WHERE EMPLOYEEID=?");
//
//			preparedStatement.setInt(1, id);
//            // result set is pointing above first row
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			if (resultSet.next()) {
//				int eid = resultSet.getInt("EMPLOYEEID");
//				String name = resultSet.getString("EMPLOYEENAME");
//				String desig = resultSet.getString("DESIGNATION");
//				String deptt = resultSet.getString("DEPARTMENT");
//				double sal = resultSet.getDouble("SALARY");
//				LocalDate doj = resultSet.getDate("DOJ").toLocalDate();
//
//				employee = new Employee(eid, name, desig, deptt, sal, doj);
//			}
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////				4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return employee;
		return null;
	
	}

	@Override
	public int insertRecord(Employee employee) { // now returns integer because .executeUpdate() returns 1 if successful
		
//		// DML command 
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//		int rows = 0; 
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//			preparedStatement = connection.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?,?,?)");
//
//			preparedStatement.setInt(1, employee.getEmpId());
//			preparedStatement.setString(2, employee.getEmpName());
//			preparedStatement.setString(3, employee.getEmpDesignation());
//			preparedStatement.setString(4, employee.getEmpDepartment());
//			preparedStatement.setDouble(5, employee.getEmpSalary());
//			preparedStatement.setObject(6, employee.getDateOfJoining());
//		
//
//			rows = preparedStatement.executeUpdate();
//
//			return rows;
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////						4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rows;
		
		String query = "INSERT INTO EMP VALUES(?,?,?,?,?,?)";
		int rows = jdbcTemplate.update(query, employee.getEmpId(), employee.getEmpName(), employee.getEmpDesignation(), 
				employee.getEmpDepartment(), employee.getEmpSalary(), employee.getDateOfJoining());
		
		return rows;
		
	} 


	@Override
	public int deleteRecord(int id) { // now returns integer because .executeUpdate() returns 1 if successful
		
		// DML command
		
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//		int rows=0;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//
//			preparedStatement = connection.prepareStatement("DELETE FROM EMP WHERE EMPLOYEEID=?");
//
//			preparedStatement.setInt(1, id);
//
//			rows = preparedStatement.executeUpdate();
//
//			return rows;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////				4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rows;
		
		String query = "DELETE FROM EMP WHERE EMPLOYEEID=?";
		int rows = jdbcTemplate.update(query, id);
		
		return rows;
		
		
	}


	@Override
	public int updateSalary(int id, double increment) {
		
//		Connection connection = null;
//		PreparedStatement preparedStatement;
//		int rows=0;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments", "root", "Archie.092008");
//
//			preparedStatement = connection.prepareStatement("UPDATE EMP SET SALARY=SALARY+? WHERE EMPLOYEEID=?");
//
//			preparedStatement.setDouble(1, increment);
//			preparedStatement.setInt(2, id);
//
//			rows = preparedStatement.executeUpdate();
//
//			return rows;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
////				4.Close
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rows;
		
		String query = "UPDATE EMP SET SALARY=SALARY+? WHEREEMPLOYEEID=?";
		int rows = jdbcTemplate.update(query, increment, id);
		
		return rows;
	}

}
