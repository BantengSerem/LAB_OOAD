package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connect.Connect;
import models.Product;
import models.TransactionHeader;
import models.Voucher;

public class TransactionHandler {

	public TransactionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public static int insertTransaction(int voucherID, int employeeID, int total) {
		Voucher vou = new Voucher();
		
		int transId = 0;
		
		boolean vouStatus = vou.checkStatus(voucherID);
		
		if (vouStatus) { // voucher active
			vou.updateStatus(voucherID);
			
			transId = TransactionHeader.insertTransaction(voucherID, employeeID, total);
			
		}
		return transId;
	}
	
	public static void updateProduct(Vector<Product> product) {
		Product pro = new Product();
		
		for(Product p : product) {
			int stock = pro.getStock() - p.getStock();
			pro.updateProduct(p.getProductID(), stock);
		}
	}
	
	public static void insertDetailTransaction(Vector<Product> product, int id) {
		TransactionHeader th = new TransactionHeader();
		
//		boolean i=false;
		
		for(Product p : product) {
//			int stock = pro.getStock() - p.getStock();
//			pro.updateProduct(p.getProductID(), stock);
			boolean i = th.insertDetailTransaction(p.getProductID(), id, p.getStock());
			if (i) {
				System.out.println("good");
			}
			else {
				System.out.println("badd");
				break;
			}
		}
	}
	
	public static Vector<TransactionHeader> getAllTransaction(){
        Connect conn = new Connect();

        Vector<TransactionHeader> transaction = new Vector<>();

        String query = "SELECT * FROM transaction";

        TransactionHeader user=null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new TransactionHeader(rs.getInt("TransactionID"),
                		rs.getInt("VoucherID"), rs.getInt("TotalPrice"),
                		rs.getDate("PurchaseDate"));
                transaction.add(user);
            }
            return transaction;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
	public static Vector<TransactionHeader> getAllDetail(int id){
        Connect conn = new Connect();

        Vector<TransactionHeader> transaction = new Vector<>();

        String query = "SELECT * FROM transactiondetail WHERE TransactionID=?";

        TransactionHeader user=null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new TransactionHeader(rs.getInt("TransactionID"),
                		rs.getInt("ProductID"), rs.getInt("Quantity"));
                transaction.add(user);
            }
            return transaction;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
