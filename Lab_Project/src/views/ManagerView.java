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
import javax.swing.border.EmptyBorder;

public class ManagerView extends JFrame implements ActionListener{

	JPanel centerPnl;
	JLabel transactionLbl, employeeLbl, titleLbl;
	JButton transactionBtn, employeeBtn;
	
	public ManagerView() {
		// TODO Auto-generated constructor stub
		initComponents();
		initFrame();
	}
	
	private void initComponents() {	
		centerPnl = new JPanel(new GridLayout(2, 1));
		centerPnl.setBorder(new EmptyBorder(0, 50, 0, 50));
		
		// Buttons
		transactionBtn = new JButton("Transation");
		employeeBtn = new JButton("Employee");
		
		centerPnl.add(transactionBtn);
		centerPnl.add(employeeBtn);
		transactionBtn.addActionListener(this);
		employeeBtn.addActionListener(this);
	}
	
	private void initFrame() {
		// Frame
		setLayout(new BorderLayout());
		
		// Add to Frame
		add(centerPnl, BorderLayout.CENTER);
		
		// Set Frame
		setTitle("Product Management Form");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == transactionBtn) {
			
			System.out.println("enter transaction");
		}else if(arg0.getSource() == employeeBtn) {
			new FireEmployeeView();
		}
	}

}
