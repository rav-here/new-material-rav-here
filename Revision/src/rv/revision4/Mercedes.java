package rv.revision4;

public class Mercedes extends Car {

	public Mercedes(String model, String color) {
		super(model, color);
		
	}
	
	@Override 
	public void engine() {
		System.out.println("Mercedes engine goes woooooooooo...");
	}
}