package rv.revision5;

// triangle class extends line class (so gets thickness and drawing colour methods) 
// triangle also implements the fillable interface, which extends the drawable interface (so the fillable methods and drawable methods must be implemented)
// since class Line already implements the drawable methods, only the fillable ones need implemented in this class
public class Triangle extends Line implements Fillable {

	@Override
	public void fillingColour(String colour) {
		System.out.println("You can fill a circle with the colour "+ colour);
		
	}

	@Override
	public void size(String size) {
		System.out.println("You can draw a circle of size " + size);
		
	}

}
