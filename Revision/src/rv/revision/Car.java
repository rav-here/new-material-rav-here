package rv.revision;

/**
*
* @author rachelvickerman
*/
public class Car extends Vehicle {
   
	// new variable
   private String driveType; 
   
   // constructor
   public Car(String colour, int wheels, String model, String driveType) {
       super(colour, wheels, model);
       this.driveType = driveType;
       
   }
   
   // get drive type - make readable
   public String getDriveType() {
	   return driveType;
   }
   // set drive type - make modifiable 
   public void setDriveType(String driveType) {
	   this.driveType = driveType;
   }
   // method for displaying drive type that uses display vehicle method from parent class
   public void displayCarDriveType() {
	   System.out.print("Car that drives "+ driveType + " which is a ");
	   displayVehicle();
	   
   }
   

   
}