package CarAnonymousClass;

public class Driver {

	protected String name;
	protected Car car;
	
	public Driver(String name) {
		super();
		this.name = name;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void drive() {
		System.out.print(name+" is driving "+car.getColor()+" color "+car.getModel()+" ");
		car.engine();
	}
}