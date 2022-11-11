package presentation;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Student;
import service.StudentService;

@Component("studentPresentation")
public class StudentPresentationImpl implements StudentPresentation {

	// presentation will pass request to service layer for all business logic actions
	private StudentService studentService;
	// setter 
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Student Management System");
		System.out.println("1. List All Students");
		System.out.println("2. Search Student by Roll No.");
		System.out.println("3. Add New Student");
		System.out.println("4. Generate Students by Grade Bracket");
		System.out.println("5. Exit");
		System.out.println("============================");
		
	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);
		
		switch (choice) {
		case 1: 
			Collection<Student> students= studentService.getAllRecords();
			for(Student theStudent : students) {
				System.out.println(theStudent);
			}
			break;
			
		case 2:
			System.out.println("Enter Student Roll No : ");
			int roll = scanner.nextInt();
			Student stud = studentService.searchStudent(roll);
			if (stud != null) {
				System.out.println(stud);
			}
			else {
				System.out.println("No Student with Roll No "+roll+" exists.");
			}
			break;
			
		case 3:
			Student newStudent = new Student();

            System.out.println("Enter Student Roll No : ");
            newStudent.setRollNo(scanner.nextInt());
            System.out.println("Enter Student Name : ");
            newStudent.setName(scanner.next());
            System.out.println("Enter the Student's Grade : ");
            newStudent.setGrade(scanner.nextInt());

            if(studentService.addStudent(newStudent))
            System.out.println("Student Record Added");
            else
            System.out.println("Student with Roll No "+newStudent.getRollNo()+" already exist, so cannot add it as a new student!");

            break;	
			
		case 4:
			System.out.println("Enter Maximum Grade : ");
			int max = scanner.nextInt();
			System.out.println("Enter Minimum Grade : ");
			int min = scanner.nextInt();
			List<Student> theList = studentService.generateStudentsByGrade(max, min);
			if (theList.size() != 0) {
				System.out.println(theList);
			}
			else {
				System.out.println("No student fall in the grade bracket with max= "+max+" and min= "+min);
			}
			break;
			
		case 5:
			System.out.println("Thanks for using Book Management System");
			// void method for exiting program, it terminates the currently running JVM and exits the program
			// the parameter integer 0 - means normal exit, any non-zero integer is considered an abnormal exit
			// this method stops any subsequent lines from running
			// it is used when we want to exit the program from somewhere other than the main class of the program
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}
		
	}
}
