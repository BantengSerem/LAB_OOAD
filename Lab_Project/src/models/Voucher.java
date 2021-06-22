package models;

import connect.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Voucher {

	private int voucherID, discount;
	private String status;
	private static Connect conn = new Connect();
	
	public Voucher() {
		// TODO Auto-generated constructor stub
	}

	public Voucher(int voucherID, int discount, String status) {
		super();
		this.voucherID = voucherID;
		this.discount = discount;
		this.status = status;
	}

	public int getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static boolean generateVoucher(int discount, String status) {
		
		String query = "INSERT INTO Voucher"
				+ "() VALUES (NULL,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setInt(1, discount);
			ps.setString(2, status);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteVoucher(int voucherID) {
		String query = "DELETE FROM Voucher WHERE VoucherID=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setInt(1, voucherID);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean checkStatus(int id) {
		String query = "SELECT * FROM Voucher WHERE VoucherID=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
		    } 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean updateStatus(int id) {
		String query = "UPDATE Voucher SET VoucherStatus='Used' WHERE VoucherID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			ps.setInt(1, id);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}