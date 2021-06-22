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

public class DetailTransactionView extends JFrame implements ActionListener {

	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JTable table;
	JScrollPane scrollpane;
	DefaultTableModel dtm;
//	JLabel transactionidLabel, purchasedateLabel, voucheridLabel, totalpriceLabel;
//	JTextField  transactionidField, purchasedateField, voucheridField, totalpriceField;
//	JButton insertButton, updateButton, deleteButton, viewBtn;
	Vector<Object> rowData;
	
	private void refreshTable(int id) {
		  
		System.out.println("refreshed");
  
		Object[] column = {"TransactionID", "ProductID", "Qty"};

		dtm = new DefaultTableModel(column, 0);

		Vector<TransactionHeader> transaction = TransactionHandler.getAllDetail(id);
  
		for (TransactionHeader trs : transaction) {
			rowData = new Vector<>();
			rowData.add(trs.getTransactionID());
			rowData.add(trs.getProductID());
			rowData.add(trs.getQty());
   
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	}
	
	public DetailTransactionView(int id) {
		// TODO Auto-generated constructor stub
		northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		northPanel.setSize(600, 100);
  
		centerPanel = new JPanel(new GridLayout(6, 2));
		centerPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		centerPanel.setSize(600, 300);
		
		southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(0, 50, 0, 50));

		table = new JTable(dtm);
		refreshTable(id);

		//saat pake mouseadapter, tahan ctrl, lalu pilih yg pilihan pertama
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
		
	}

}
