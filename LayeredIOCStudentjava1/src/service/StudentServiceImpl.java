package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.Student;
import persistence.StudentDao;

public class StudentServiceImpl implements StudentService {

	// Service requests persistence layer for all data needs
	private StudentDao studentDao;
	// constructor
	public StudentServiceImpl(StudentDao studentDao) {
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


	@Override
	public List<Student> generateStudentsByGrade(int Max, int Min) {
	    Collection<Student> students = studentDao.getAllRecords();
		List<Student> sameGradeStudents = new ArrayList();
		for (Student s : students) {
			if (s.getGrade() <= Max && Min <= s.getGrade()) {
				sameGradeStudents.add(s);
			}
			
		}
		
		return sameGradeStudents;
	}


	

}

