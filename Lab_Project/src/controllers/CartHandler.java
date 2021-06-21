package controllers;

import java.util.Vector;

import models.Product;

public class CartHandler {

	public CartHandler() {
		// TODO Auto-generated constructor stub
	}
	
	static Vector<Product> carts = new Vector<>();
	
	public static Vector<Product> getAllCart(){
		return carts;
	}
	
	public static void addCart() {
		carts.add()
	}

}
