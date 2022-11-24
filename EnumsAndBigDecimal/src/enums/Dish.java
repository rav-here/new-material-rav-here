package enums;

public enum Dish {
	
	CHICKEN(660, false, 25.45) {
//		@Override
//		public boolean calorieState(int calories) {
//			if (calories > 600) {
//				return true;
//				}
//				else {
//					return false;
//				}
//		}
	},
	
	
	FISH(560, false, 30.50) {
//		@Override
//		public boolean calorieState(int calories) {
//			if (calories > 600) {
//				return true;
//				}
//				else {
//					return false;
//				}
//		}
	}, 
	
	
	PASTA(780, true, 28.75) {
//		@Override
//		public boolean calorieState(int calories) {
//			if (calories > 600) {
//				return true;
//				}
//				else {
//					return false;
//				}
//		}
	}, 
	
	
	PIZZA(900, true, 29.00) {
//		@Override
//		public boolean calorieState(int calories) {
//			if (calories > 600) {
//				return true;
//				}
//				else {
//					return false;
//				}
//		}
	};
	
	
	private int calories;
	private boolean veggie;
	private double price;
	
	private Dish(int calories, boolean veggie, double price) {
		this.calories = calories;
		this.veggie = veggie;
		this.price = price;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public boolean getVeggie() {
		return veggie;
	}
	
	public double getPrice() {
		return price;
	}
	
	// unique method (different for each constant)
	// could make an abstract method and implement in each constant 
	//public abstract boolean calorieState(int calories);
	
	// common method (same for each constant)
	// rather than making the method abstract and implementing it in each constant 
	// we could do one method that applies to each constant 
	public boolean calorieState() {
		if (this.calories > 600) {
			return true;
		}
		else {
			return false;
		}
	}
}
