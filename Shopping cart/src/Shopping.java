import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Shopping {
	static TreeMap<String, Integer> treemap = new TreeMap<String, Integer>();// to sort the items of a list

	public static void main(String[] args) {
		String item;
		Integer quantity;
		Scanner scan = new Scanner(System.in);
		treemap.put("milk", 50);
		treemap.put("eggs", 175);
		treemap.put("oil", 100);
		treemap.put("shampoo", 452);
		treemap.put("lays", 75);
		treemap.put("cakes", 175);
		treemap.put("choclates", 175);
		System.out.println(treemap);
		Set<String> itemsSet = treemap.keySet();
		LinkedHashMap<String, Integer> items;

		String userInput;
		System.out.println("Do you want anything");
		while (scan.next().equalsIgnoreCase("yes")) {
			Menu customer = new Menu();
			items = new LinkedHashMap<String, Integer>();//stores the items selected by the customer along with its quantity
			do {
				System.out.println("what item do you want");

				item = scan.next();
				try {
					item = customer.requiredItem(itemsSet, item);

					System.out.println("specify the quantity");
					quantity = scan.nextInt();

					int available = treemap.get(item);
					int remained = customer.availableItems(available, quantity);

					items.put(item, quantity);

					treemap.put(item, remained);
				} catch (Exception e) {
					System.out.println("sorry enter valid input");
				}
				System.out.println("do you want any other item(yes/no)");
				userInput = scan.next();
			} while (userInput.equalsIgnoreCase("yes"));
			if (userInput.equalsIgnoreCase("no")) {
				Set<Map.Entry<String, Integer>> set = items.entrySet();
				TreeMap<String, Set<Map.Entry<String, Integer>>> map = new TreeMap<String, Set<Map.Entry<String, Integer>>>();
				System.out.println("enter your name");
				map.put(scan.next(), set);
				System.out.println(map);

			}

			System.out.println("Is there any other user(yes/no)");

		}

		System.out.println(treemap);

		scan.close();
	}

}
