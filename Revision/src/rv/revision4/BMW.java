package rv.revision4;

public class BMW extends Car {

	public BMW(String model, String color) {
		super(model, color);
	}
	
	@Override
	public void engine() {
		System.out.println("BMW Engine goes BOOOOM.....");
	}

}