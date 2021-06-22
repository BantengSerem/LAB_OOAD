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

import controllers.VoucherHandler;
import models.Voucher;

public class VoucherView extends JFrame implements ActionListener {

	JPanel northPanel, southPanel, centerPanel, inputPanel;
	JTable table;
	JScrollPane scrollpane;
	DefaultTableModel dtm;
	JLabel idLabel, discountLabel, statusLabel;
	JTextField idField, discountField, statusField;
	JButton insertButton, deleteButton;

	Vector<Object> rowData;
	VoucherHandler vouH = new VoucherHandler();
	
private void refreshTable() {
		
		System.out.println("refreshed");
		
		Object[] column = {"ID", "Discount", "Status"};

		dtm = new DefaultTableModel(column, 0);

		Vector<Voucher> voucher = VoucherHandler.getAllVouchers();
		
		for (Voucher vou : voucher) {
			rowData = new Vector<>();
			rowData.add(vou.getVoucherID());
			rowData.add(vou.getDiscount());
			rowData.add(vou.getStatus());
			
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
	}
	
public VoucherView() {
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
	discountLabel = new JLabel("Discount");
	statusLabel = new JLabel("Status");
	
	idField = new JTextField();
	discountField = new JTextField();
	statusField = new JTextField();
	idField.setEditable(false);
	
	
	insertButton = new JButton("Generate");
	deleteButton = new JButton("Bye-Bye");

	insertButton.addActionListener(this);
	deleteButton.addActionListener(this);

	centerPanel.add(idLabel);
	centerPanel.add(idField);

	centerPanel.add(discountLabel);
	centerPanel.add(discountField);

	centerPanel.add(statusLabel);
	centerPanel.add(statusField);
	
	southPanel.add(insertButton);
	southPanel.add(deleteButton);

	table = new JTable(dtm);
	refreshTable();

	//saat pake mouseadapter, tahan ctrl, lalu pilih yg pilihan pertama
	table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			System.out.println("Table clicked");

			idField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			discountField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			statusField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	 	}
	});

	scrollpane = new JScrollPane(table);

	//add scrollpane to northpanel
	northPanel.add(scrollpane);

	//add panel to internal frame
	add(northPanel, BorderLayout.NORTH);
	add(southPanel, BorderLayout.SOUTH);
	add(centerPanel, BorderLayout.CENTER);

	setTitle("View Voucher");
//	setClosable(true);
	setSize(new Dimension(600,600));
	setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == insertButton) {
			int discount = Integer.parseInt(discountField.getText());
			String status = statusField.getText();
			
			vouH.addVoucher(discount, status);

			refreshTable();
			
		}else if(arg0.getSource() == deleteButton) {
			int id = Integer.parseInt(idField.getText());
			
			vouH.deleteVoucher(id);
			refreshTable();
		}
	}
}