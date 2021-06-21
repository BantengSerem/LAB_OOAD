package models;

public class Product {

	private int productID, price, stock;
	private String productName, description;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productID, int price, int stock, String productName, String description) {
		super();
		this.productID = productID;
		this.price = price;
		this.stock = stock;
		this.productName = productName;
		this.description = description;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
