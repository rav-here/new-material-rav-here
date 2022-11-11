package rv.revision2;

public class ListOfPerson {
	
	// variables 
	private Person[] personList; 
	private int totalNoPersons;
	
	// constructor 
	public ListOfPerson(int totalNoPersons) {
		this.totalNoPersons = totalNoPersons;
		personList = new Person[totalNoPersons]; // makes array size = total no. person objects
		
	}
	// input method for adding person to list
	public void inputPerson(Person person, int index) {
		personList[index] = person;
	}
	
	// display method for displaying full persons list
	public void displayPersons() {
		for (int i = 0; i < totalNoPersons; i++) { 
			System.out.println(personList[i].getPersonId() +" "+ personList[i].getPersonName() +" "+ personList[i].getPersonAge());
		}	
	}
	
	

}
