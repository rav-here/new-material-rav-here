package persistence;

import java.util.Collection;

import database.StudentDatabase;
import entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Collection<Student> getAllRecords() {
		return StudentDatabase.getStudentList().values();
	}

	@Override
	public Student searchRecord(int rollNo) {
		return StudentDatabase.getStudentList().get(rollNo);
	}
	
	@Override
	public Student insertRecord(Student student) {
		return StudentDatabase.getStudentList().put(student.getRollNo(), student);
	}

	

}
