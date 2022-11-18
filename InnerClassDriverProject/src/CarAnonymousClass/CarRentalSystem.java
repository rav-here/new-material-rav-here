package CarAnonymousClass;

public class CarRentalSystem {

	public static void main(String[] args) {
		
		Car audi = new Car("A1","Red") {
			@Override
			public void engine() {
				System.out.println("brrrm I'm an audi");
			}
			
		};
		
		audi.engine();
		

		Car honda = new Car("Jazz", "Blue") {
			@Override 
			public void engine() {
				System.out.println("rrrrrrr I'm a honda");
			}
		};
		
		honda.engine();
		
		Car bmw = new Car("X5", "Silver") {
			@Override 
			public void engine() {
				System.out.println("gggrrrrrhh I'm a bmw");
			}
		};
		
		//bmw.engine();
		
		Driver R = new Driver("Rachel") {
			@Override 
			public void drive() {
				System.out.print(name+" is driving ");
				car.engine();
			}
		};
		
		R.setCar(bmw);
		R.drive();
	}

}

