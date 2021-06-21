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

import controllers.ProductHandler;
import models.Product;

public class ProductView extends JFrame implements ActionListener {

	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JTable table;
	JScrollPane scrollpane;
	DefaultTableModel dtm;
	JLabel idLabel, nameLabel, descriptionLabel, priceLabel, stockLabel;
	JTextField idField, nameField, descriptionField, priceField, stockField;
	JButton insertButton, updateButton, deleteButton;

	Vector<Object> rowData;
	ProductHandler proH = new ProductHandler();
	
private void refreshTable() {
		
		System.out.println("refreshed");
		
		Object[] column = {"ID", "Name", "Description", "Price", "Stock"};

		dtm = new DefaultTableModel(column, 0);

		Vector<Product> product = ProductHandler.getAllProducts();
		
		for (Product pro : product) {
			rowData = new Vector<>();
			rowData.add(pro.getProductID());
			rowData.add(pro.getProductName());
			rowData.add(pro.getDescription());
			rowData.add(pro.getPrice());
			rowData.add(pro.getStock());
			
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	}
	
public ProductView() {
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
	nameLabel = new JLabel("Name");
	descriptionLabel = new JLabel("Description");
	priceLabel = new JLabel("Price");
	stockLabel = new JLabel("Stock");
	
	idField = new JTextField();
	nameField = new JTextField();
	descriptionField = new JTextField();
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

	centerPanel.add(descriptionLabel);
	centerPanel.add(descriptionField);
	
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
			descriptionField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
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

	setTitle("View Product");
//	setClosable(true);
	setSize(new Dimension(600,600));
	setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == insertButton) {
			int price = Integer.parseInt(priceField.getText());
			int stock = Integer.parseInt(stockField.getText());
			String proName = nameField.getText();
			String description = descriptionField.getText();
			
			proH.addProduct(proName, description, price, stock);

			refreshTable();
			
		}else if (arg0.getSource() == updateButton) {
			int id = Integer.parseInt(idField.getText());
			int price = Integer.parseInt(priceField.getText());
			int stock = Integer.parseInt(stockField.getText());
			String proName = nameField.getText();
			String description = descriptionField.getText();
			
			proH.updateProduct(id, proName, description, price, stock);
			
			refreshTable();
			
		}else if(arg0.getSource() == deleteButton) {
			int id = Integer.parseInt(idField.getText());
			
			proH.deleteProduct(id);
			refreshTable();
		}
	}
}