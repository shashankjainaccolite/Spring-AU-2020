package assignment;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Market {
	
	public static Map<String, Integer> marketInventory = new ConcurrentHashMap<>();
	public static List<String> fruitsType = Arrays.asList("apple", "orange", "grape", "watermelon");
	public static int MAX_QUANTITY = 3;
	
	static long start = System.nanoTime();
	
	public static void main(String[] args) {
		
		marketInventory.put("apple", 0);
		marketInventory.put("orange", 0);
		marketInventory.put("grape", 0);
		marketInventory.put("watermelon", 0);
		
		for(int i = 1 ; i < 10 ; i++) {
			new Thread(new Farmer(), "Farmer_" + i).start();
			new Thread(new Consumer(), "Consumer_" + i).start();
		}
	}

}
