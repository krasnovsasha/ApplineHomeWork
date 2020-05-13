public class MainClass {
	public static void main(String[] args) {
		Gift gift = new Box();
		gift.addCandy(new Cake("CheeseCake", 200, 350, 550));
		gift.addCandy(new BubbleGum("Wrigley Spearmint", 20, 35, 10));
		gift.addCandy(new BubbleGum("Wrigley Doublemint", 20, 30, 10));
		gift.addCandy(new Chocolate("Ritter Sport", 100, 85, "black"));
		gift.addCandy(new Chocolate("Alpen Gold", 100, 65, "milk"));
		gift.printAllCandies();
		gift.removeCandy("Wrigley Doublemint");
		gift.printAllCandies();
		gift.printWeight();
		gift.printCost();
		gift.reduceCost(450);
		gift.printAllCandies();
		gift.printWeight();
		gift.printCost();
	}
}
