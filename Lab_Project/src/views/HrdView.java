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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.EmployeeHandler;
import models.Employee;

public class HrdView extends JFrame implements ActionListener {
	
	JPanel northPanel, southPanel, centerPanel;
	JTable table;
	JScrollPane scrollpane;
	DefaultTableModel dtm;
	JLabel idLabel, nameLabel, typeLabel, cuisineLabel;
	JTextField idField, nameField, typeField, cuisineField;
	JButton insertButton, updateButton, deleteButton;

	Vector<Object> rowData;
	
	public HrdView() {
		// TODO Auto-generated constructor stub
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel(new GridLayout(4,2));


		idLabel = new JLabel("ID");
		nameLabel = new JLabel("Name");
		typeLabel = new JLabel("Type");
		cuisineLabel = new JLabel("Cuisine");

		idField = new JTextField();
		nameField = new JTextField();
		typeField = new JTextField();
		cuisineField = new JTextField();

		insertButton = new JButton("Insert");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");

		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);

		centerPanel.add(idLabel);
		centerPanel.add(idField);

		centerPanel.add(nameLabel);
		centerPanel.add(nameField);

		centerPanel.add(typeLabel);
		centerPanel.add(typeField);

		centerPanel.add(cuisineLabel);
		centerPanel.add(cuisineField);

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
				typeField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				cuisineField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());			
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
		setSize(new Dimension(600,700));
		setVisible(true);
	}
	
	private void refreshTable() {
		Object[] column = {"ID", "Name", "Type", "Cuisine"};

		dtm = new DefaultTableModel(column, 0);
		//		con.rs = con.execQuery("SELECT * FROM MENU");

		Vector<Employee> employee = EmployeeHandler.getAllEmployees();
		
		for (Employee emp : employee) {
			rowData = new Vector<>();
			rowData.add(emp.getEmployeeID());
			rowData.add(emp.getName());
//			rowData.add(emp.getType());
//			rowData.add(emp.getCuisine());
			
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == insertButton) {
//			String name = nameField.getText();
//			String type = typeField.getText();
//			String cuisine = cuisineField.getText();
//
//			
//			boolean isInserted = MenuController.insertMenu(name, type, cuisine);
//			if(isInserted) {
//				refreshTable();
//				nameField.setText("");
//				typeField.setText("");
//				cuisineField.setText("");
//				
//				JOptionPane.showMessageDialog(null, "Insert Success");
//			}else {
//				String errorMessage = MenuController.errorMessage;
//				JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
//			}
//			
//
//		}
//		else if(e.getSource() == updateButton) {
//			String id = idField.getText();
//
//			String name = nameField.getText();
//			String type = typeField.getText();
//			String cuisine = cuisineField.getText();
//
//			
//			if (MenuController.updateMenu(id, name, type, cuisine)) {
//				refreshTable();
//
//				idField.setText("");
//				nameField.setText("");
//				typeField.setText("");
//				cuisineField.setText("");
//				
//				JOptionPane.showMessageDialog(null, "update success!");
//			} else {
//				String errorMessage = MenuController.errorMessage;
//				JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
//			}
//			
//		}
//		else if(e.getSource() == deleteButton) {
//			
//			String id = idField.getText();
//			
//			int option = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?");
//			
//			if (option != JOptionPane.YES_OPTION) {
//				return;
//			}
//			
//			if(MenuController.deleteMenu(id)) {
//				refreshTable();
//				idField.setText("");
//				nameField.setText("");
//				typeField.setText("");
//				cuisineField.setText("");
//				
//				JOptionPane.showMessageDialog(null, "Delete Success!");
//			}else {
//				String errorMessage = MenuController.errorMessage;
//				JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
//			
//			}
//
//		}
	}
}
