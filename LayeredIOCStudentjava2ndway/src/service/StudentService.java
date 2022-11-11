package service;

import java.util.Collection;
import java.util.List;

import entity.Student;

public interface StudentService {
	
	Collection<Student> getAllRecords();
	
	Student searchStudent(int rollNo);
	
	boolean addStudent(Student student);
	
	List<Student> generateStudentsByGrade(int Max, int Min);

}
