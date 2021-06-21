package models;

import java.time.LocalDate;

public class TransactionHeader {

	private int transactionID, voucherID, employeeID, totalPrice;
	private LocalDate purchaseDate;
	
	public TransactionHeader() {
		// TODO Auto-generated constructor stub
	}

	public TransactionHeader(int transactionID, int voucherID, int employeeID, int totalPrice, LocalDate purchaseDate) {
		super();
		this.transactionID = transactionID;
		this.voucherID = voucherID;
		this.employeeID = employeeID;
		this.totalPrice = totalPrice;
		this.purchaseDate = purchaseDate;
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

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
