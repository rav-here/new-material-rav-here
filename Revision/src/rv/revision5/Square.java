package rv.revision5;
// class square implements the interface fillable which extends interface drawable
public class Square implements Fillable {
    
	// overriding each method from the interfaces that are implemented
	@Override
	public void fillingColour(String colour) {
		System.out.println("You can fill a square with colour "+colour);
		
	}

	@Override
	public void drawingColour(String colour) {
		System.out.println("You can draw a square with colour "+colour);
		
	}

	@Override
	public void thickness(int thickness) {
		System.out.println("You can draw a square with the thickness " + thickness);
		
	}

	@Override
	public void size(String size) {
		System.out.println("You can draw a square of size " + size);
		
	}

}
