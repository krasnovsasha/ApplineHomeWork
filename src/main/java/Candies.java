public abstract class Candies {
	protected String name;
	protected double weight;
	protected double cost;

	public Candies(String name, double weight, double cost) {
		this.name = name;
		this.weight = weight;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return name + " " + weight + " gr " + cost + " rub";
	}
}
