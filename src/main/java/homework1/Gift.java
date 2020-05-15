package homework1;

public interface Gift {
	void addCandy(Candies candy);
	void removeCandy(int candyIndex);
	void removeCandy(String candyName);
	void printWeight();
	void printCost();
	void printAllCandies();
	void reduceWeight(double weight);
	void reduceCost(double cost);
}
