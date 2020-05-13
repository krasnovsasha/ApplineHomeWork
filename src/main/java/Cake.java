public class Cake extends Candies {
	private int calories;

	public Cake(String name, int weight, double cost, int calories) {
		super(name, weight, cost);
		this.calories = calories;
	}

	@Override
	public String toString() {
		return super.toString() + " " + calories + " calories";
	}
}
