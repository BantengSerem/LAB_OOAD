package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connect.Connect;
//import models.Employee;
import models.Product;

public class ProductHandler {

	public ProductHandler() {
		// TODO Auto-generated constructor stub
	}

	public static Vector<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Connect conn = new Connect();
		
		Vector<Product> product = new Vector<>();
		
		String query = "SELECT * FROM Product";
		
		Product user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Product(rs.getInt("ProductID"), rs.getInt("ProductPrice"), rs.getInt("ProductStock"), rs.getString("ProductName"), rs.getString("ProductDescription"));
				product.add(user);
			}
			return product;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean addProduct(String proName,String description,int price,int stock) {
			
		Product pro = new Product();
			
		boolean isAdded = pro.insertProduct(proName, description, price, stock);
			
		if(isAdded) {
			System.out.println("added");
			return true;
		}else {
			System.out.println("not added");
			return false;
		}
	}
	
	public static boolean updateProduct(int id, String proName, String description, int price, int stock) {
		
		Product pro = new Product();
		
		boolean isUpdated = pro.updateProduct(id, proName, description, price, stock);
		
		if(isUpdated) {
			System.out.println("updated");
			return true;
		}else {
			System.out.println("not updated");
			return false;
		}
	}
	
	public static boolean deleteProduct(int productID) {
		Product pro = new Product();
		
		boolean isDeleted = pro.deleteProduct(productID);
		
		if (isDeleted == true) {
			System.out.println("delete success");
			return true;
		}
		else {
			System.out.println("delete failed");
			return false;
		}
	}
}