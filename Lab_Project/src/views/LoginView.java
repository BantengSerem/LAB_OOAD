package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.UserController;

public class LoginView extends JFrame implements ActionListener{

	JPanel northPnl, centerPnl, southPnl;
	JLabel titleLbl, usernameLbl, passwordLbl;
	JTextField usernameTxt;
	JPasswordField passwordTxt;
	JButton loginBtn, registerBtn;
	
	public LoginView() {
		initComponents();
		initListeners();
		initFrame();
	}
	
	private void initComponents() {
		// Panels
		northPnl = new JPanel();
		northPnl.setBorder(new EmptyBorder(20, 0, 0, 0));
		
		centerPnl = new JPanel(new GridLayout(2, 2, 20, 10));
		centerPnl.setBorder(new EmptyBorder(50, 50, 50, 50));
		
		southPnl = new JPanel(new GridLayout(1, 2, 40, 0));
		southPnl.setBorder(new EmptyBorder(10, 50, 10, 50));
		
		// Labels
		titleLbl = new JLabel("LOGIN");
		titleLbl.setFont(new Font("Arial", Font.BOLD, 32));
		
		usernameLbl = new JLabel("Username");
		usernameLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		
		passwordLbl = new JLabel("Password");
		passwordLbl.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// Text Field
		usernameTxt = new JTextField();
		usernameTxt.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// Password Field
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("Arial", Font.PLAIN, 20));
		
		// Buttons
		loginBtn = new JButton("LOGIN");
//		registerBtn = new JButton("REGISTER");
		
		// North Panel
		northPnl.add(titleLbl);
		
		// Center Panel
		centerPnl.add(usernameLbl);
		centerPnl.add(usernameTxt);
		centerPnl.add(passwordLbl);
		centerPnl.add(passwordTxt);
		
		// South Panel
		southPnl.add(loginBtn);
//		southPnl.add(registerBtn);
	}
	
	private void initListeners() {
		loginBtn.addActionListener(this);
//		registerBtn.addActionListener(this);
	}
	
	private void initFrame() {
		// Frame
		setLayout(new BorderLayout());
		
		// Add to Frame
		add(northPnl, BorderLayout.NORTH);
		add(centerPnl, BorderLayout.CENTER);
		add(southPnl, BorderLayout.SOUTH);
		
		// Set Frame
		setTitle("Login");
		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String username = usernameTxt.getText();
		String password = passwordTxt.getText();
		
		if(arg0.getSource() == loginBtn) {
			boolean isLoggedIn =  UserController.userLogin(username, password);
			
			if(isLoggedIn) {
				JOptionPane.showMessageDialog(null, "logged in");
			} else {
				JOptionPane.showMessageDialog(null, "wrong credentials");
			}
		} 
	}
}
