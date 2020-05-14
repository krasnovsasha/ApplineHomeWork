import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Box implements Gift {
	private List<Candies> candies;
	private ArrayList<Double> list;

	public Box() {
		candies = new ArrayList<>();
	}

	@Override
	public void addCandy(Candies candy) {
		candies.add(candy);
	}

	@Override
	public void removeCandy(int candyIndex) {
		candies.remove(candyIndex);
	}

	@Override
	public void removeCandy(String candyName) {
		Iterator<Candies> iterator = candies.iterator();
		while (iterator.hasNext()) {
			Candies candy = iterator.next();
			if (candy.name.equals(candyName)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void printWeight() {
		double weight = 0;
		for (Candies c : candies) {
			weight += c.weight;
		}
		System.out.println("Total weight: " + weight + " gr");
	}

	@Override
	public void printCost() {
		double cost = 0;
		for (Candies c : candies) {
			cost += c.cost;
		}
		System.out.println("Total cost: " + cost + " rub");
	}

	@Override
	public void printAllCandies() {
		if (candies.size() == 0) {
			System.out.println("Gift box is empty");
		} else {
			System.out.println("******************\n" + "Here are all candies in gift box:");
			for (Candies c : candies) {
				System.out.println(c);
			}
			System.out.println("******************");
		}
	}

	@Override
	public void reduceWeight(double weight) {
		while (true) {
			int total = 0;
			for (Candies c : candies) {
				total += c.weight;
			}
			if (total > weight) {
				removeMinWeightItem();
			} else break;
		}
	}

	@Override
	public void reduceCost(double cost) {
		while (true) {
			int total = 0;
			for (Candies c : candies) {
				total += c.cost;
			}
			if (total > cost) {
				removeMinCostItem();
			} else break;
		}
	}

	private void removeMinWeightItem() {
		list = new ArrayList<>();
		double minWeightItem;
		for (Candies c : candies) {
			list.add(c.weight);
		}
		minWeightItem = Collections.min(list);
		Iterator<Candies> iterator = candies.iterator();
		while (iterator.hasNext()) {
			Candies candy = iterator.next();
			if (candy.weight == minWeightItem) {
				iterator.remove();
				break;
			}
		}
	}

	private void removeMinCostItem() {
		list = new ArrayList<>();
		double minCostItem;
		for (Candies c : candies) {
			list.add(c.cost);
		}
		minCostItem = Collections.min(list);
		Iterator<Candies> iterator = candies.iterator();
		while (iterator.hasNext()) {
			Candies candy = iterator.next();
			if (candy.cost == minCostItem) {
				iterator.remove();
				break;
			}
		}
	}
}
