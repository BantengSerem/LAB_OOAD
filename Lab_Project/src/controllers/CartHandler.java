package controllers;

import java.util.Vector;

import models.Product;

public class CartHandler {

	public CartHandler() {
		// TODO Auto-generated constructor stub
	}
	public static Vector<Product> addCart(int id, int stock, Vector<Product> carts) {
		
		boolean b=false;
		int loc = 0;
		int price = 0;
		
		// to check if the input id is exist or not using query
		if(ProductHandler.getProduct(id)==false) {
			System.out.println("no data product");
			return carts;
		}
		
		price = Product.getPriceById(id);
		
		// check if the product is on the list
		for (int i=0; i<carts.size();i++) {
			if(carts.get(i).getProductID()==id) {
				b=true;
				loc=i;
				break;
			}
		}
		
		// found on the list
		if (b) {
			int st = stock;
			st += carts.get(loc).getStock();
			carts.get(loc).setStock(st);
			carts.get(loc).setPrice(price*st);
		}else { // new data
			carts.add(new Product(id, stock, price*stock));
		}
		return carts;
	}
	
	public static Vector<Product> updateCart(int id, int stock, Vector<Product> carts){
		boolean b=false;
		int loc = 0;
		int price = 0;
		
		price = Product.getPriceById(id);
		
		for (int i=0; i<carts.size();i++) {
			if(carts.get(i).getProductID()==id) {
				b=true;
				loc=i;
				System.out.println("there you go");
				break;
			}
		}
		
		if (b) {
			carts.get(loc).setStock(stock);
			carts.get(loc).setPrice(price*stock);
		}
		return carts;
	}
	
	public static Vector<Product> deleteCart(int id, Vector<Product> carts){
		boolean b=false;
		int loc = 0;
		int price = 0;
		
		price = Product.getPriceById(id);
		
		for (int i=0; i<carts.size();i++) {
			if(carts.get(i).getProductID()==id) {
				b=true;
				loc=i;
				System.out.println("there you go");
				break;
			}
		}
		carts.remove(loc);
		
		return carts;
	}
}
