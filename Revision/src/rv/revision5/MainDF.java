package rv.revision5;

// this exercise was for understanding interfaces and how they are extended by each other and implemented by classes
public class MainDF {
	
	public static void main(String[] args) {
		
		// instantiating object from each shape class and running their methods
		Circle circle = new Circle();
		circle.drawingColour("Red");
		circle.fillingColour("Blue");
		circle.thickness(10);
		circle.size("Big");
		
		Square square = new Square();
		square.drawingColour("White");
		square.fillingColour("Pink");
		square.thickness(5);
		square.size("small");
		
		Line line = new Line();
		line.drawingColour("Green");
		line.thickness(20);
		
		Triangle tri = new Triangle();
		tri.drawingColour("yellow"); // this will print with line in message since it is inherited from line class
		tri.fillingColour("orange");
		tri.thickness(2); // this will print with line message since it is inherited from line class
		tri.size("tiny");
	}

}
