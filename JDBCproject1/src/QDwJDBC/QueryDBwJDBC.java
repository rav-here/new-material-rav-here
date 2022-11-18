package QDwJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// this is for a DQL (data query language) command
public class QueryDBwJDBC {
	
	public static void main(String args[]) {
		
		// instantiate connection object for connecting to mySQL database
		Connection connection = null;
		// instantiate preparedStatement object for enacting mySQL command
		PreparedStatement preparedStatement;
		
		// try block 
		try {
			// 1.Connect
			// 1.1 Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 1.2 Connect to Database
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments","root","Archie.092008");
			
			// 2 Query 
			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEES");
			
			// when dealing with query commands DQL : executeQuery() which will return ResultSet
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// 3. Process result
			while(resultSet.next()) {
				// read data type of each column from employees table in Departments database 
				// String argument must equal the column/field name in mySQL
				int id = resultSet.getInt("EMPLOYEEID");
				String firstName = resultSet.getString("FIRST_NAME");
				String lastName = resultSet.getString("LAST_NAME");
				String email = resultSet.getString("EMAIL");
				String phone = resultSet.getString("PHONE_NUMBER");
				Date date = resultSet.getDate("HIRE_DATE");
				String jobId = resultSet.getString("JOBID");
				double sal = resultSet.getDouble("SALARY");
				double com = resultSet.getDouble("COMMISION_PCT");
				int manID = resultSet.getInt("MANAGERID");
				int deptID = resultSet.getInt("DEPARTMENTID");
				
				// display result
				System.out.println(id + " "+ firstName +" "+ lastName +" "+ email +" "+ phone +" "+ date +" "+ jobId +" "+ sal +" "+ com +" "+ manID +" "+ deptID);
			}
	
		} 
		// catch exceptions
		catch(ClassNotFoundException e) {
			// display complete stack for exceptions
			e.printStackTrace();
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		// finally block implies close step will always run
		finally { 
			try {
				// 4.Close 
				connection.close();
			} 
			catch(SQLException s) {
				s.printStackTrace();
			}
		}
	}

}
