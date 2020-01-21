package shoppingApp;

public class Product {
	
	private int id;
	private String name;
	private int qty_available;
	private int amount;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQty_available() {
		return qty_available;
	}
	
	public void setQty_available(int qty_available) {
		this.qty_available = qty_available;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "ID = " + id + ", Name = " + name + ", Available Quantity = " + qty_available + ", Amount=" + amount;
	}
	
	public Product(int id, String name, int qty_available, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.qty_available = qty_available;
		this.amount = amount;
	}
	

}
