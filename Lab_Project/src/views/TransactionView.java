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

import controllers.TransactionHandler;
import models.TransactionHeader;

public class TransactionView extends JFrame implements ActionListener {
 
	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JTable table;
	JScrollPane scrollpane;
	DefaultTableModel dtm;
	JLabel transactionidLabel, purchasedateLabel, voucheridLabel, totalpriceLabel;
	JTextField  transactionidField, purchasedateField, voucheridField, totalpriceField;
	JButton insertButton, updateButton, deleteButton, viewBtn;
 
	Vector<Object> rowData;
	TransactionHandler trsH = new TransactionHandler();
 
	private void refreshTable() {
  
		System.out.println("refreshed");
  
		Object[] column = {"TransactionID", "PurchaseDate", "VoucherID", "TotalPrice", "ListTransactionItem"};

		dtm = new DefaultTableModel(column, 0);

		Vector<TransactionHeader> transaction = TransactionHandler.getAllTransaction();
  
		for (TransactionHeader trs : transaction) {
			rowData = new Vector<>();
			rowData.add(trs.getTransactionID());
			rowData.add(trs.getPurchaseDate());
			rowData.add(trs.getVoucherID());
			rowData.add(trs.getTotalPrice());
   
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	}
 
	public TransactionView() {
		northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		northPanel.setSize(600, 100);
  
		centerPanel = new JPanel(new GridLayout(6, 2));
		centerPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		centerPanel.setSize(600, 300);
		
		southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(0, 50, 0, 50));

		transactionidLabel = new JLabel("ID");
		purchasedateLabel = new JLabel("position");
		voucheridLabel = new JLabel("Name");
		totalpriceLabel = new JLabel("Salary");

  
 
		transactionidField = new JTextField();
		purchasedateField = new JTextField();
		voucheridField = new JTextField();
		totalpriceField = new JTextField();

		transactionidField.setEditable(false);

		centerPanel.add(transactionidLabel);
		centerPanel.add(transactionidField);

		centerPanel.add(purchasedateLabel);
		centerPanel.add(purchasedateField);

		centerPanel.add(voucheridLabel);
		centerPanel.add(voucheridField);
  
		centerPanel.add(totalpriceLabel);
		centerPanel.add(totalpriceField);
		
		viewBtn = new JButton("view details");
		viewBtn.addActionListener(this);
		
		southPanel.add(viewBtn);

		table = new JTable(dtm);
		refreshTable();

		//saat pake mouseadapter, tahan ctrl, lalu pilih yg pilihan pertama
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Table clicked");

				transactionidField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				purchasedateField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				voucheridField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				totalpriceField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());   
//    	usernameField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
//    	passwordField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
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
//  setClosable(true);
		setSize(new Dimension(600,600));
		setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
		if(e.getSource() == viewBtn) {
			int id = Integer.parseInt(transactionidField.getText());
			
			new DetailTransactionView(id);
		}
	}
 }

