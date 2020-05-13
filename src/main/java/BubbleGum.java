public class BubbleGum extends Candies {
	private int countInPackage;

	public BubbleGum(String name, int weight, double cost, int countInPackage) {
		super(name, weight, cost);
		this.countInPackage = countInPackage;
	}

	@Override
	public String toString() {
		return super.toString() + " " + countInPackage + " chewing plates";
	}
}
