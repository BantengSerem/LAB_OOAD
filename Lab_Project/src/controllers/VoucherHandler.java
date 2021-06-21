package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connect.Connect;
import models.Product;
import models.Voucher;

public class VoucherHandler {

	public VoucherHandler() {
		// TODO Auto-generated constructor stub
	}

	public static Vector<Voucher> getAllVouchers() {
		// TODO Auto-generated method stub
		Connect conn = new Connect();
		
		Vector<Voucher> voucher = new Vector<>();
		
		String query = "SELECT * FROM Voucher";
		
		Voucher user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Voucher(rs.getInt("VoucherID"), rs.getInt("VoucherDiscount"), rs.getString("VoucherStatus"));
				voucher.add(user);
			}
			return voucher;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean addVoucher(int discount, String status) {
			
		Voucher vou = new Voucher();
			
		boolean isAdded = vou.generateVoucher(discount, status);
			
		if(isAdded) {
			System.out.println("added");
			return true;
		}else {
			System.out.println("not added");
			return false;
		}
	}
	
	
	public static boolean deleteVoucher(int voucherID) {
		Voucher vou = new Voucher();
		
		boolean isDeleted = vou.deleteVoucher(voucherID);
		
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