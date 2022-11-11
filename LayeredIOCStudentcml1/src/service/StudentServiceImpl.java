package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import entity.Student;
import persistence.StudentDao;

public class StudentServiceImpl implements StudentService {

	// Service requests persistence layer for all data needs
	private StudentDao studentDao;
	// constructor
	public StudentServiceImpl(@Autowired StudentDao studentDao) {
	this.studentDao  = studentDao;
		}
		
	
	@Override
	public Collection<Student> getAllRecords() {
		return studentDao.getAllRecords();
	}

	@Override
	public Student searchStudent(int rollNo) {
		return studentDao.searchRecord(rollNo);
	}
	
	@Override
	public boolean addStudent(Student student) {
		Student newStudent = studentDao.searchRecord(student.getRollNo());
		if (newStudent != null) {
			return false;
			
		}
		studentDao.insertRecord(student);
		return true;
	}


	

}
