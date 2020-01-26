package assignment;

import java.util.Random;

public class Farmer implements Runnable {

	public void run() {

		Random r = new Random();
		int randomFruitGenerator = r.nextInt(Market.fruitsType.size());
		
		int quantityOfFruitsToBeSold = r.nextInt(10) + 1;

		while (true) {
			synchronized (Market.marketInventory) {
				if (Market.marketInventory.get(Market.fruitsType.get(randomFruitGenerator)) < Market.MAX_QUANTITY) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Market.marketInventory.put(Market.fruitsType.get(randomFruitGenerator), Market.marketInventory.get(Market.fruitsType.get(randomFruitGenerator)) + 1);
					System.out.println(Market.fruitsType.get(randomFruitGenerator) + " added by " + Thread.currentThread().getName());
					quantityOfFruitsToBeSold--;
					Market.marketInventory.notifyAll();
					if(quantityOfFruitsToBeSold == 0) {
						System.out.println(Thread.currentThread().getName() + " has sold all the stock of his fruits.");
						return;
					}
				} else {
					try {
						Market.marketInventory.wait();
					} catch(InterruptedException e) {
						System.out.println(e);
					}
					System.out.println(Thread.currentThread().getName() + " is waiting as the stock of " +Market.fruitsType.get(randomFruitGenerator) + " is full");
				}
			}

		}
	}
}
