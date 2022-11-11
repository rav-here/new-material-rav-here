package persistence;

import java.util.Collection;
import java.util.List;

import entity.Student;


public interface StudentDao {
	
	Collection<Student> getAllRecords();
	Student searchRecord(int rollNO);
	Student insertRecord(Student student);
}
