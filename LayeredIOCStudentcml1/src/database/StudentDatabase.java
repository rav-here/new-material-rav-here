package database;

import java.util.LinkedHashMap;
import java.util.Map;
import entity.Student;

public class StudentDatabase {

	static private Map<Integer, Student> studentList=new LinkedHashMap<Integer, Student>();
	
	
	static {
		studentList.put(101, new Student(101, "Rachel", 75));
		studentList.put(102, new Student(102, "Zoe", 85));
		studentList.put(103, new Student(103, "Roxana", 80));

		
	}

	public static Map<Integer, Student> getStudentList() {
		return studentList;
	}
}