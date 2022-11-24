package enums;

public class dishMain {

	public static void main(String[] args) {
		Dish dish = Dish.CHICKEN;
		
		boolean calorieState = dish.calorieState();
		
		System.out.println("Is this dish high in calories? "+calorieState);
	}

}
