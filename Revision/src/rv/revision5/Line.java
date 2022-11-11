package rv.revision5;
// class line implements interface fillable

// line could be extended for square and circle, to improve reusability!
public class Line implements Drawable {

	@Override
	public void drawingColour(String colour) {
		System.out.println("You can draw a line with the colour " + colour);
		
	}

	@Override
	public void thickness(int thickness) {
		System.out.println("You can draw a line of thickness " + thickness);
		
	}

}
