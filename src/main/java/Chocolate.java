public class Chocolate extends Candies {
	private String chocolateType;

	public Chocolate(String name, int weight, double cost, String chocolateType) {
		super(name, weight, cost);
		this.chocolateType = chocolateType;
	}

	@Override
	public String toString() {
		return super.toString() + " " + chocolateType + " chocolate";
	}
}
