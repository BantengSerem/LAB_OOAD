package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.CartHandler;
import controllers.EmployeeHandler;
import controllers.TransactionHandler;
import models.Employee;
import models.Product;


public class BaristaView extends JFrame implements ActionListener{
	
	JLabel titleLbl, totalPriceLbl, dateLbl, voucherLbl;
	JTextField totalPriceField, dateField, voucherField;
	JButton addCartBtn, checkOutBtn, refreshBtn, voucherBtn;
	
	JTable table;
	DefaultTableModel dtm;
	JScrollPane sp;
	
	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JScrollPane scrollpane;
	

	Vector<Product> product = new Vector<>();
	
	CartView cv;
	
	int totalPrice = 0;
	
	Vector<Object> rowData;
	EmployeeHandler empH = new EmployeeHandler();
	
	CartHandler cartH = new CartHandler();
	
	private void refreshTable() {
		
//		product = cv.getCartList();
		
		System.out.println("refreshed");
		
		Object[] column = {"ID", "Price", "Quantity"};

		dtm = new DefaultTableModel(column, 0);

//		product = CartHandler.getAllCart();
//		product = cv.getCartList();
		int total = 0;
		
		for (Product pro : product) {
			rowData = new Vector<>();
			rowData.add(pro.getProductID());
			rowData.add(pro.getPrice());
			rowData.add(pro.getStock());
			
			dtm.addRow(rowData);
			
			total +=pro.getPrice();
//			totalPrice += pro.getStock()*pro.getPrice();
		}
		table.setModel(dtm);
		
		totalPrice = total;
		
//		System.out.println(totalPrice);
	}

	public BaristaView() {
		// TODO Auto-generated constructor stub
		northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		northPanel.setSize(600, 100);
		
		southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		
		centerPanel = new JPanel(new GridLayout(2, 2));
		centerPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		centerPanel.setSize(600, 300);
		
		addCartBtn = new JButton("Add Cart");
		checkOutBtn = new JButton("Check Out");
		refreshBtn = new JButton("Refresh");
//		voucherBtn = new JButton("Voucher")

		addCartBtn.addActionListener(this);
		checkOutBtn.addActionListener(this);
		refreshBtn.addActionListener(this);
		
		southPanel.add(addCartBtn);
		southPanel.add(checkOutBtn);
		southPanel.add(refreshBtn);
		
		totalPriceLbl = new JLabel("total price");
		totalPriceField = new JTextField(totalPrice);
//		totalPriceField.setText(totalPrice);
		System.out.println(totalPrice);
		System.out.println("adffaa");
		totalPriceField.setEditable(false);
//		dateLbl = new JLabel("date");
//		dateField = new JTextField();
		voucherLbl = new JLabel("voucher");
		voucherField = new JTextField();
		
		centerPanel.add(totalPriceLbl);
		centerPanel.add(totalPriceField);
		
//		centerPanel.add(dateLbl);
//		centerPanel.add(dateField);
		
		centerPanel.add(voucherLbl);
		centerPanel.add(voucherField);

		table = new JTable(dtm);
		refreshTable();

		scrollpane = new JScrollPane(table);

		//add scrollpane to northpanel
		northPanel.add(scrollpane);

		//add panel to internal frame
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		setTitle("View Menu");
//		setClosable(true);
		setSize(new Dimension(600,600));
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated metWhod stub
		
		
		if(arg0.getSource() == addCartBtn) {
			cv = new CartView(this.product);
//			System.out.println("one");
//			product = cv.getCartList();
//			System.out.println(product);
			
			refreshTable();
			
		}else if(arg0.getSource() == checkOutBtn) {
			int voucher = 0;
			if (!voucherField.getText().isEmpty()) {
				voucher = Integer.parseInt(voucherField.getText());
			}
			int total = 0;
			for(Product p : product) {
				total += p.getPrice();
			}
			
			// insert transaction and return the ID
			TransactionHandler th = new TransactionHandler();
			int transID = th.insertTransaction(voucher, 2, total);
			
			// update the product quantity
			th.updateProduct(product);
			
			//insert transaction detail
			th.insertDetailTransaction(product, transID);
			totalPrice = total;
			
			refreshTable();
			
		}else if(arg0.getSource() == refreshBtn) {
			product = cv.getCartList();
			refreshTable();
		}
	}	
}
