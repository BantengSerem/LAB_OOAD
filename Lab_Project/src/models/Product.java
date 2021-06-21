package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import connect.Connect;

public class Product {

	private int productID, price, stock;
	private String productName, description;
	private static Connect conn = new Connect();
	
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

	public static boolean insertProduct(String proName,String description,int price,int stock) {
		
		String query = "INSERT INTO Product"
				+ "() VALUES (NULL,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setString(1, proName);
			ps.setString(2, description);
			ps.setInt(3, price);
			ps.setInt(4, stock);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateProduct(int id, String proName,String description,int price,int stock) {
		String query = "UPDATE Product SET ProductName=?, ProductDescription=?, ProductPrice=?, ProductStock=? WHERE ProductID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setString(1, proName);
			ps.setString(2, description);
			ps.setInt(3, price);
			ps.setInt(4, stock);
			ps.setInt(5, id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteProduct(int productID) {
		String query = "DELETE FROM Product WHERE ProductID=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setInt(1, productID);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
