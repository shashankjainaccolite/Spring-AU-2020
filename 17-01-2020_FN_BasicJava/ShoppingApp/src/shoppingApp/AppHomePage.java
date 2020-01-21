package shoppingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AppHomePage {

	public static List<Product> productList = new ArrayList<>(6);
	static int choice;

	public static void main(String[] args) {

		Product p1 = new Product(1, "Rotating Chair", 10, 1999);
		Product p2 = new Product(2, "Table", 20, 3999);
		Product p3 = new Product(3, "Sofa", 3, 9999);
		Product p4 = new Product(4, "Pillow", 50, 499);
		Product p5 = new Product(5, "Dining Table", 5, 5499);
		Product p6 = new Product(6, "White Board", 30, 299);

		Scanner scan = new Scanner(System.in);

		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
		productList.add(p5);
		productList.add(p6);
		
		ShoppingCart s = new ShoppingCart(productList);
		
		Random rand = new Random();
		
		int orderId = rand.nextInt(30);
		
		
		System.out.println("Welcome to the store");
		System.out.println("Please enter your name : ");
		String userName = scan.next();
		
		System.out.println("Hello " +userName);

		do {
			System.out.println(
					"\nWhat would you like to do\n1) Add items to your cart\n2) View your cart\n3) Remove items from your cart\n4) Place the order\n5) Cancel the order\n6) I'm done for today.");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter id of the product you would like to buy from the following list :");
				for(Product p : productList) {
					System.out.println(p);
				}
				
				int id = scan.nextInt();
				if(id > 0 && id < 7) {
					System.out.println("Enter the quantity you would like to buy");
					int quantity = scan.nextInt();
					if (productList.get(id - 1).getQty_available() >= quantity) {
						productList.get(id - 1).setQty_available(productList.get(id - 1).getQty_available() - quantity);
						s.addToCart(id, productList.get(id - 1).getName(), quantity, productList.get(id - 1).getAmount());
					} else {
						System.out.println("Sorry that much quantity is not available");
					}
				} else {
					System.out.println("Product with this id does not exist");
				}
				break;
				
			case 2:
				s.display();
				break;
				
			case 3:
				System.out.println("Enter id of the product you would like to remove from the following list :");
				for(Product p : productList) {
					System.out.println(p);
				}
				int pId = scan.nextInt();
				if(pId > 0 && pId < 7) {
					s.removeFromCart(pId);
				} else {
					System.out.println("This id is not valid");
				}
				
				break;
				
			case 4:
				System.out.println("Hey " +userName + "\nYour order with ID : " +orderId + " contains the following");
				s.display();
				s.placeOrder();
				break;
				
			case 5:
				s.cancelOrder();
				break;
				
			case 6:
				System.out.println("Thank you for providing us the opportunity to serve you");
				break;
				
			default:
				System.out.println("Please enter a valid option");
				break;
			}
			
			System.out.println();

		} while (choice != 6);
		
		scan.close();
	}

}
