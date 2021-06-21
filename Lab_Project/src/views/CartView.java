package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import models.Product;

public class CartView extends JFrame implements ActionListener{
	
//	JLabel titleLbl, totalPriceLbl, dateLbl;
//	JTextField totalPriceField, dateField;
//	JButton addCartBtn, checkOutBtn;
	
	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JTable table;
	JScrollPane scrollpane;
	DefaultTableModel dtm;
	JLabel idLabel, nameLabel, descLabel, priceLabel, stockLabel;
	JTextField idField, nameField, descField, priceField, stockField;
	JButton insertButton, updateButton, deleteButton;

	Vector<Product> product;
	
	Vector<Object> rowData;
	EmployeeHandler empH = new EmployeeHandler();
	
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

	public CartView() {
		// TODO Auto-generated constructor stub
		northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		northPanel.setSize(600, 100);
		
		southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		
		centerPanel = new JPanel(new GridLayout(6, 2));
		centerPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		centerPanel.setSize(600, 300);

		idLabel = new JLabel("ID");
		descLabel = new JLabel("Description");
		nameLabel = new JLabel("Name");
		priceLabel = new JLabel("Price");
		stockLabel = new JLabel("stock");
		
		idField = new JTextField();
		descField = new JTextField();
		nameField = new JTextField();
		priceField = new JTextField();
		stockField = new JTextField();
		idField.setEditable(false);
		
		
		insertButton = new JButton("Insert");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Bye-Bye");

		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);

		centerPanel.add(idLabel);
		centerPanel.add(idField);

		centerPanel.add(nameLabel);
		centerPanel.add(nameField);
		
		centerPanel.add(priceLabel);
		centerPanel.add(priceField);
		
		centerPanel.add(stockLabel);
		centerPanel.add(stockField);
		
		southPanel.add(insertButton);
		southPanel.add(updateButton);
		southPanel.add(deleteButton);

		table = new JTable(dtm);
		refreshTable();

		//saat pake mouseadapter, tahan ctrl, lalu pilih yg pilihan pertama
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Table clicked");

				idField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				nameField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				descField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				priceField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());			
			}
		});

		scrollpane = new JScrollPane(table);

		//add scrollpane to northpanel
		northPanel.add(scrollpane);

		//add panel to internal frame
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);

		setTitle("View Menu");
//		setClosable(true);
		setSize(new Dimension(600,600));
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == insertButton) {
			int id = Integer.parseInt(idField.getText());
			int price = Integer.parseInt(priceField.getText());
			int stock = Integer.parseInt(stockField.getText());
			String proName = nameField.getText();
			String description = descField.getText();
			
			
			
		}else if(e.getSource() == deleteButton) {
			
		}else if(e.getSource() == updateButton) {
			
		}
	}

}
