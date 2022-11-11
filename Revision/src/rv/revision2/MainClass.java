package rv.revision2;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// build list
		// declare reference variable for list
		ListOfPerson personList;
		// instantiate scanner
		Scanner userInput = new Scanner(System.in);
		// print prompt for list size
		System.out.println("Please end the number of persons in the list: ");
		// gather user input for size 
		int size = userInput.nextInt();
		// create list object using it
		personList = new ListOfPerson(size);
		
		// build persons and add them to personList
		// for every index of the persons list
		for (int i=0; i < size; i++) {
			// ask for Id and collect user input
			System.out.println("Enter person Id:");
			int Id = userInput.nextInt();			
			// ask for Name and collect user input
			System.out.println("Enter person name:");
			String Name = userInput.next();
			// ask for Age and collect user input
			System.out.println("Enter person age:");
			int Age = userInput.nextInt();
			// create person object using user inputs
			Person p = new Person(Id, Name, Age);
			// add this person object in index i of person list
			personList.inputPerson(p, i);
			
			
		}
		
		// display list of persons
		personList.displayPersons();


				

	}

}
