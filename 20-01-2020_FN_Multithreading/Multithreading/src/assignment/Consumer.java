package assignment;

import java.util.Random;

public class Consumer implements Runnable {

	@Override
	public void run() {
		Random r = new Random();
		int randomFruitBuy = r.nextInt(Market.fruitsType.size());
		
		int quantityOfFruitsRequired = r.nextInt(10) + 1;
		
		while(true) {
			synchronized(Market.marketInventory) {
				if(Market.marketInventory.get(Market.fruitsType.get(randomFruitBuy)) > 0) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					quantityOfFruitsRequired--;
					Market.marketInventory.put(Market.fruitsType.get(randomFruitBuy), Market.marketInventory.get(Market.fruitsType.get(randomFruitBuy)) - 1);
					System.out.println(Thread.currentThread().getName() + " has bought " + Market.fruitsType.get(randomFruitBuy));
					if(quantityOfFruitsRequired == 0) {
						System.out.println(Thread.currentThread().getName() + " requirements are fulfilled and is going back.");
						return;
					}
				} else {
					try {
						Market.marketInventory.wait();
					} catch(InterruptedException e) {
						System.out.println(e);
					}
					System.out.println(Thread.currentThread().getName() + " is waiting as the stock of " +Market.fruitsType.get(randomFruitBuy) + " is empty.");
				}
			}
		}				
	}
}
