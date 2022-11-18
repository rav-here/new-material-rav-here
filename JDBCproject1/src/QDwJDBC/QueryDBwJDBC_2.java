package QDwJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//this is for a DML (data management language) command
public class QueryDBwJDBC_2 {
	
	public static void main(String args[]) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		Scanner scanner = new Scanner(System.in);
		
		try {
			// 1.Connect 
			// 1.1 Register Driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 1.2 Connect to Database 
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Departments","root","Archie.092008");
			
			// 2.Query 
			preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println("Enter employee ID : ");
			preparedStatement.setInt(1,  scanner.nextInt());
			
			System.out.println("Enter employee first name : ");
			preparedStatement.setString(2,  scanner.next());
			
			System.out.println("Enter employee last name : ");
			preparedStatement.setString(3,  scanner.next());
			
			System.out.println("Enter employee email : ");
			preparedStatement.setString(4,  scanner.next());
			
			System.out.println("Enter employee phone number : ");
			preparedStatement.setString(5,  scanner.next());
			
			// NEED TO FIX THIS
			System.out.println("Enter employee hire date : ");
			preparedStatement.setDate(6,  Date.valueOf(scanner.next()));
			
			System.out.println("Enter employee job ID : ");
			preparedStatement.setString(7,  scanner.next());
			
			System.out.println("Enter employee salary : ");
			preparedStatement.setDouble(8,  scanner.nextDouble());
			
			System.out.println("Enter employee commision : ");
			preparedStatement.setDouble(9,  scanner.nextDouble());
			
			System.out.println("Enter employee manager ID : ");
			preparedStatement.setInt(10,  scanner.nextInt());
			
			System.out.println("Enter employee department ID : ");
			preparedStatement.setInt(11,  scanner.nextInt());
			
			// DML : executeUpdate() which will return integer (=count of no. rows manipulated by the query) 
			int rows = preparedStatement.executeUpdate();
			
			// 3.Process the result
			if (rows > 0) {
				System.out.println("Employee added");
			}
			else {
				System.out.println("Employee not added");			}
		}
		catch(ClassNotFoundException e) {
			// displaying the complete stack for exceptions
			e.printStackTrace();
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
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
