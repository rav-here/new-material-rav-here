package rv.revision;

public class Main {
	
	public static void main (String[] args) {
		// vehicle task for inheritance
		// instantiate objects for car and vehicle 
	    Car myCar = new Car("Red", 4, "Mini", "Manual");
	    Vehicle myVehicle = new Vehicle("Red", 4,  "Mini");
	    
	    // display info about vehicle and car
	    myVehicle.displayVehicle();
	    myCar.displayCarDriveType();
	    

	}
   
}
