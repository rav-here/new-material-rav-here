package rv.revision5;
// circle class implements interface fillable which extends interface drawable
public class Circle implements Fillable{

	@Override
	public void fillingColour(String colour) {
		System.out.println("You can fill a circle with the colour "+ colour);
		
	}

	@Override
	public void drawingColour(String colour) {
		System.out.println("You can draw a circle with the colour " + colour);
		
	}

	@Override
	public void thickness(int thickness) {
		System.out.println("You can draw a circle with the thickness " + thickness);
		
	}

	@Override
	public void size(String size) {
		System.out.println("You can draw a circle of size " + size);
		
	}

}
