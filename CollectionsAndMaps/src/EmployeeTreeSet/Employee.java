package EmployeeTreeSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee implements Comparable<Employee> {
	
	private int Id;
	private String name;
	private int experience;
	private String designation;
	private int salary;
	
	@Override
	public int compareTo(Employee emp) {
		if (experience > emp.experience) { // if the experience of emp1 is greater than that of emp2 
			return 1;
		}
		else if (experience < emp.experience) { // if the experience of emp1 is less than that of emp2
			return -1;
		}
		else if (this.equals(emp)) { // if the employee objects are equal
			return 0;
		}
		return 1;
	}
	
	

}
