package rv.revision2;

public class Person {
	
	// variables 
	private int personId;
	private String personName;
	private int personAge;
	
	// constructor
	public Person(int personId, String personName, int personAge) {
		this.personAge = personAge;
		this.personId = personId;
		this.personName = personName;
	}
	
	// getters and setters - makes variables readable and modifiable 
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	
	public void display() {
		System.out.println("Person Id : "+personId);
		System.out.println("Name : "+personName);
		System.out.println("Age : "+personAge);
	}

}
