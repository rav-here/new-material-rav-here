package service;

import java.util.Collection;
import entity.Student;

public interface StudentService {
	
	Collection<Student> getAllRecords();
	
	Student searchStudent(int rollNo);
	
	boolean addStudent(Student student);

}