package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AdminView extends JFrame implements ActionListener {

	JPanel centerPnl;
	JLabel productLbl, voucherLbl, titleLbl;
	JButton productBtn, voucherBtn;
	
	public AdminView() {
		// TODO Auto-generated constructor stub
		initComponents();
		initFrame();
	}
	
	private void initComponents() {	
		centerPnl = new JPanel(new GridLayout(2, 1));
		centerPnl.setBorder(new EmptyBorder(0, 50, 0, 50));
		
		// Buttons
		productBtn = new JButton("Product");
		voucherBtn = new JButton("Voucher");
		
		centerPnl.add(productBtn);
		centerPnl.add(voucherBtn);
		productBtn.addActionListener(this);
		voucherBtn.addActionListener(this);
	}
	
	private void initFrame() {
		// Frame
		setLayout(new BorderLayout());
		
		// Add to Frame
		add(centerPnl, BorderLayout.CENTER);
		
		// Set Frame
		setTitle("Admin View");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
			if(arg0.getSource() == productBtn) {	
				new ProductView();
			}else if(arg0.getSource() == voucherBtn) {
				new VoucherView();
			}
	}	
}