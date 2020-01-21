package shoppingApp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Integer> pId;
	List<String> name;
	List<Integer> quantity;
	List<Integer> amount;

	ShoppingCart(List<Product> list) {

		pId = new ArrayList<>(list.size());
		name = new ArrayList<>(list.size());
		quantity = new ArrayList<>(list.size());
		amount = new ArrayList<>(list.size());

		for (int i = 0; i < list.size(); i++) {
			pId.add(list.get(i).getId());
			name.add(list.get(i).getName());
			quantity.add(0);
			amount.add(list.get(i).getAmount());
		}
	}

	public void display() {
		
		boolean flag = true;
		for (int i = 0; i < quantity.size(); i++) {
			if (quantity.get(i) != 0) {
				System.out.println("Product ID : " + pId.get(i) + " Name : " + name.get(i) + " Quantity = "
						+ quantity.get(i) + " Amount " + amount.get(i));
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("Your cart is empty");
		}
	}
	
	public void addToCart(int pId, String name, int quantity, int amount) {
		if(this.quantity.get(pId - 1) == 0) {
			this.pId.add(pId - 1, pId);
			this.name.add(pId - 1, name);
			this.quantity.add(pId - 1, quantity);
			this.amount.add(pId - 1, (quantity) * amount);
		} else {
			int totalQuantity = this.quantity.get(pId - 1) + quantity;
			System.out.println("totalQuantity " +totalQuantity);
			this.quantity.set(pId - 1, totalQuantity);
			System.out.println("amount : " + (totalQuantity * amount));
			this.amount.set(pId - 1, totalQuantity * amount);
		}
	}
	
	public void removeFromCart(int pId) {
		boolean flag = false;
		for(int i = 0 ; i < quantity.size() ; i++) {
			if(quantity.get(i) != 0) {
				flag = true;
				break;
			}
		}
		if(flag) {
			if(quantity.get(pId - 1) == 0) {
				System.out.println("You don't have item with that Product ID");
			} else {
				quantity.set(pId - 1, 0);
			}
		} else {
			System.out.println("The cart is empty");
		}
	}
	
	public void placeOrder() {
		boolean flag = false;
		int totalCost = 0;
		for(int i = 0 ; i < quantity.size() ; i++) {
			if(quantity.get(i) != 0) {
				flag = true;
				totalCost += amount.get(i);
			}
		}
		if(flag) {
			System.out.println("Thanks for your order\nYou have to pay : " +totalCost);
			System.out.println("Thank you for providing us the opportunity to serve you");
			System.exit(1);
		} else {
			System.out.println("You don't have anything in your cart. Please add something to cart. We are looking forward for your order");
		}		
	}
	
	public void cancelOrder() {
		boolean flag = false;
		for(int i = 0 ; i < quantity.size() ; i++) {
			if(quantity.get(i) != 0) {
				flag = true;
				quantity.set(i, 0);
			}
		}
		if(flag) {
			System.out.println("Your order has been cancelled and cart has been emptied");
		} else {
			System.out.println("Your cart is already empty");
		}
	}

}
