package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

import connect.Connect;

public class TransactionHeader {

	private int transactionID, voucherID, employeeID, totalPrice, qty, productID;
	private Date purchaseDate;
	private static Connect conn = new Connect();
	
	public TransactionHeader() {
		// TODO Auto-generated constructor stub
	}

	public TransactionHeader(int transactionID, int voucherID, int totalPrice, Date date) {
		super();
		this.transactionID = transactionID;
		this.voucherID = voucherID;
//		this.employeeID = employeeID;
		this.totalPrice = totalPrice;
		this.purchaseDate = date;
	}
	
	public TransactionHeader(int transactionID, int productID, int qty) {
		super();
		this.transactionID = transactionID;
		this.productID = productID;
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public static int insertTransaction(int voucherID, int employeeID, int total) {
		String query = "INSERT INTO Product"
				+ "() VALUES (NULL,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		int id=0;
		
		try {
			ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			ps.setInt(2, voucherID);
			ps.setInt(3, total);
			ps.setInt(4, employeeID);
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				id=rs.getInt(1);
			}
			
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static boolean insertDetailTransaction(int productID, int id, int qty) {
		// TODO Auto-generated method stub	
		String query = "INSERT INTO TransactionDetail "
				+ "(TransactionID, ProductID, Quantity) "
				+ "VALUES (?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, productID);
			ps.setInt(3, qty);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
