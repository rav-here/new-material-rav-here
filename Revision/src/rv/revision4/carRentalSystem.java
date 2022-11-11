package rv.revision4;

public class carRentalSystem {
	
	// this shows the open/closed principle and liskov substitution principle
		// that is a class should be open for extension but closed for modification (can't change parent class functionality but can add to it)
		// and that the child class should be substitutable for its parent class (car-parent, mercedes-child)
		public static void main(String[] args) {
			Audi audi=new Audi("A8", "Red");
			BMW bmw=new BMW("Q5", "Silver");
			Mercedes merc=new Mercedes("A class", "White"); 
			
			Driver rachel=new Driver("Rachel");
			Driver max=new Driver("Max");
			
			rachel.setCar(merc);
			rachel.drive();

		}

}
