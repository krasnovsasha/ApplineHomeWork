public class Chocolate extends Candies {
	private Type chocolateType;

	public Chocolate(String name, int weight, double cost,Type type) {
		super(name, weight, cost);
		this.chocolateType = type;
	}
	public enum Type {
		MILK("milk"),DARK("dark"),WHITE("white");
		private String name;

		Type(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + chocolateType + " chocolate";
	}
}
