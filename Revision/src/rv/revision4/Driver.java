package rv.revision4;

import rv.revision4.*;

public class Driver {
	
	private String name;
	private Car car;
	
	public Driver(String name) {
		//super();
		this.name = name;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void drive() {
		System.out.print(name+" is driving a "+car.getColor()+ " " +car.getModel()+" ");
		car.engine();
	}

}
