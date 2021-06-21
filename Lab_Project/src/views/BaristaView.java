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
import models.Employee;
import models.Product;

public class BaristaView extends JFrame implements ActionListener{
	
	JLabel titleLbl, totalPriceLbl, dateLbl;
	JTextField totalPriceField, dateField;
	JButton addCartBtn, checkOutBtn;
	
	JTable table;
	DefaultTableModel dtm;
	JScrollPane sp;
	
	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JScrollPane scrollpane;

	Vector<Product> product;
	
	Vector<Object> rowData;
	EmployeeHandler empH = new EmployeeHandler();
	
	CartHandler cartH = new CartHandler();
	
	private void refreshTable() {
		
		System.out.println("refreshed");
		
		Object[] column = {"ID", "Name", "Price", "Description"};

		dtm = new DefaultTableModel(column, 0);

		product = CartHandler.getAllCart();
		
		for (Product pro : product) {
			rowData = new Vector<>();
			rowData.add(pro.getProductID());
			rowData.add(pro.getProductName());
			rowData.add(pro.getPrice());
			rowData.add(pro.getDescription());
			
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
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

		addCartBtn.addActionListener(this);
		checkOutBtn.addActionListener(this);
		
		southPanel.add(addCartBtn);
		southPanel.add(checkOutBtn);
		
		totalPriceLbl = new JLabel("total price");
		totalPriceField = new JTextField();
		dateLbl = new JLabel("date");
		dateField = new JTextField();
		
		centerPanel.add(totalPriceLbl);
		centerPanel.add(totalPriceField);
		
		centerPanel.add(dateLbl);
		centerPanel.add(dateField);

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
		// TODO Auto-generated method stub
		if(arg0.getSource() == addCartBtn) {
			new CartView();
		}else if(arg0.getSource() == checkOutBtn) {
			
		}
	}	
}
