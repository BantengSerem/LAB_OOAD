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

import controllers.EmployeeHandler;
import models.Employee;

public class BaristaView extends JFrame implements ActionListener{
	
//	JPanel northPnl, centerPnl, southPnl, inputPnl;
	JLabel titleLbl, totalPriceLbl, dateLbl;
	JTextField totalPriceField, dateField;
	JButton addCartBtn, checkOutBtn;
	
	JTable table;
	DefaultTableModel dtm;
	JScrollPane sp;
	
	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JScrollPane scrollpane;
//	JLabel idLabel, nameLabel, positionLabel, salaryLabel, passwordLabel, usernameLabel;
//	JTextField idField, nameField, positionField, salaryField, passwordField, usernameField;
//	JButton insertButton, updateButton, deleteButton;
	
	JComboBox positionComboBox;
	
	Vector<Integer> position = new Vector<>();

	Vector<Object> rowData;
	EmployeeHandler empH = new EmployeeHandler();
	
	private void refreshTable() {
		
		System.out.println("refreshed");
		
		Object[] column = {"ID", "Name", "Position", "Salary"};

		dtm = new DefaultTableModel(column, 0);

		Vector<Product> product = EmployeeHandler.getAllEmployees();
		
		for (Employee emp : employee) {
			rowData = new Vector<>();
			rowData.add(emp.getEmployeeID());
			rowData.add(emp.getName());
			rowData.add(emp.getPositionID());
			rowData.add(emp.getSalary());
			
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
		
		centerPanel = new JPanel(new GridLayout(6, 2));
		centerPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		centerPanel.setSize(600, 300);
		
//		inputPanel = new JPanel(new GridLayout(4, 2, 0, 30));
//		inputPanel.setBorder(new EmptyBorder(50, 0, 50, 0));

//		idLabel = new JLabel("ID");
//		positionLabel = new JLabel("position");
//		nameLabel = new JLabel("Name");
//		salaryLabel = new JLabel("Salary");
//		usernameLabel = new JLabel("Username");
//		passwordLabel = new JLabel("password");
//		
//		position.add(5);
//		position.add(6);
//		position.add(7);
//		position.add(8);
//		positionComboBox = new JComboBox(position);
//		
//		idField = new JTextField();
//		positionField = new JTextField();
//		nameField = new JTextField();
//		salaryField = new JTextField();
//		usernameField = new JTextField();
//		passwordField = new JTextField();
//		idField.setEditable(false);
		
		
//		insertButton = new JButton("Insert");
//		updateButton = new JButton("Update");
		addCartBtn = new JButton("Add Cart");
		checkOutBtn = new JButton("Check Out");

//		insertButton.addActionListener(this);
//		updateButton.addActionListener(this);
		addCartBtn.addActionListener(this);
		checkOutBtn.addActionListener(this);

		southPanel.add(addCartBtn);
		southPanel.add(checkOutBtn);

		table = new JTable(dtm);
		refreshTable();

		//saat pake mouseadapter, tahan ctrl, lalu pilih yg pilihan pertama
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Table clicked");

				idField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				nameField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				positionField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				salaryField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());			
//				usernameField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
//				passwordField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
