package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BaristaView extends JFrame implements ActionListener{
	
	JPanel northPnl, centerPnl, southPnl, inputPnl;
	JLabel titleLbl, nameLbl, priceLbl, descriptionLbl, idLbl;
	JTextField priceTxt, nameTxt, descriptionTxt, idTxt;
	JButton insertBtn, updateBtn, deleteBtn, logoutBtn;
	
	JTable table;
	DefaultTableModel dtm;
	JScrollPane sp;
	

	public BaristaView() {
		// TODO Auto-generated constructor stub
		initComponents();
		initFrame();
	}
	
	private void initComponents() {
		// Panels
		northPnl = new JPanel();
		northPnl.setBorder(new EmptyBorder(20, 0, 0, 0));
		
//		inputPnl = new JPanel(new GridLayout(4, 2, 0, 30));
//		inputPnl.setBorder(new EmptyBorder(50, 0, 50, 0));
		
		centerPnl = new JPanel(new GridLayout(2, 1));
		centerPnl.setBorder(new EmptyBorder(0, 50, 0, 50));
		
		southPnl = new JPanel(new GridLayout(1, 4, 10, 0));
		southPnl.setBorder(new EmptyBorder(10, 50, 20, 50));
		
		// Labels
		titleLbl = new JLabel("Product management");
		titleLbl.setFont(new Font("Arial", Font.BOLD, 32));
//		
//		idLbl = new JLabel("ID");
//		idLbl.setFont(new Font("Arial", Font.PLAIN, 20));
//		
//		nameLbl = new JLabel("Name");
//		nameLbl.setFont(new Font("Arial", Font.PLAIN, 20));
//		
//		priceLbl = new JLabel("Price");
//		priceLbl.setFont(new Font("Arial", Font.PLAIN, 20));
//		
//		descriptionLbl = new JLabel("Description");
//		descriptionLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// Text Fields
//		idTxt = new JTextField();
//		idTxt.setFont(new Font("Arial", Font.PLAIN, 18));
//		
//		nameTxt = new JTextField();
//		nameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
//		
//		priceTxt = new JTextField();
//		priceTxt.setFont(new Font("Arial", Font.PLAIN, 18));
//		
//		descriptionTxt = new JTextField();
//		descriptionTxt.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// Buttons
		insertBtn = new JButton("INSERT");
		updateBtn = new JButton("UPDATE");
		deleteBtn = new JButton("DELETE");
		logoutBtn = new JButton("LOGOUT");
		
		// Table
		table = new JTable();
		loadTable();
		
		// Scroll Pane
		sp = new JScrollPane(table);
		
		// North Panel
		northPnl.add(titleLbl);
		
		// Input Panel
//		inputPnl.add(idLbl);
//		inputPnl.add(idTxt);
//		inputPnl.add(nameLbl);
//		inputPnl.add(nameTxt);
//		inputPnl.add(priceLbl);
//		inputPnl.add(priceTxt);
//		inputPnl.add(descriptionLbl);
//		inputPnl.add(descriptionTxt);
		
		// Center Panel
		centerPnl.add(sp);
//		centerPnl.add(inputPnl);
		
		// South Panel
		southPnl.add(insertBtn);
		southPnl.add(updateBtn);
		southPnl.add(deleteBtn);
		southPnl.add(logoutBtn);
	}
	
	private void initFrame() {
		// Frame
		setLayout(new BorderLayout());
		
		// Add to Frame
		add(northPnl, BorderLayout.NORTH);
		add(centerPnl, BorderLayout.CENTER);
		add(southPnl, BorderLayout.SOUTH);
		
		// Set Frame
		setTitle("Product Management Form");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void initListeners() {
		insertBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
	}
	
	private void loadTable() {		
		String[] tableHeader = {"ID", "Name", "Price"};
		
		dtm = new DefaultTableModel(tableHeader, 0);
		
		table.setModel(dtm);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == insertBtn) {
			
		}else if(arg0.getSource() == updateBtn) {
			
		}else if(arg0.getSource() == deleteBtn) {
			
		}else if(arg0.getSource() == logoutBtn) {
			
		}
	}
}
