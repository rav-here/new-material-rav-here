package EmployeeTreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeTreeSetMain {

	public static void main(String args[]) {
		/*
		 * TreeSet : unique sorted collection of values, which is auto-growable and auto-shrinkable 
		 */
		Set<Employee> myCollection=new TreeSet<Employee>();
		
		System.out.println("Size : "+myCollection.size());
		myCollection.add(new Employee(1, "Rachel", 2, "developer", 23000));
		myCollection.add(new Employee(2, "Max", 2, "engineer", 30000));
		myCollection.add(new Employee(3, "Ann", 15, "manager", 40000));
		myCollection.add(new Employee(4, "Greg", 1, "junior developer", 20000));
		myCollection.add(new Employee(5, "Mary", 3, "developer", 25000));
		
		System.out.println("Size : "+myCollection.size());
		System.out.println(myCollection);
		
		myCollection.add(new Employee(1, "Rachel", 2, "developer", 23000));
		myCollection.add(new Employee(6, "Ricky", 2, "senior developer", 26000));
		
		System.out.println("Size : "+myCollection.size());
		System.out.println(myCollection);
		
		
		System.out.println("Traversal using for each loop");
		for(Employee element:myCollection) {
			System.out.println(element);
		}

		System.out.println("Traversal using Iterator");
		Iterator<Employee> iterator=myCollection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		

	}
}
