package rv.revision2;

public class Enterpreneur extends Person {
	
	private String natureOfBusiness;
	private double turnOver;

	public Enterpreneur(int id, String name, int age, String natureOdBusiness, double turnOver) {
		super(id, name, age);
		this.natureOfBusiness = natureOdBusiness;
		this.turnOver = turnOver;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("Nature of Bussiness : "+natureOfBusiness);
		System.out.println("TurnOver : "+turnOver);
	}

}
