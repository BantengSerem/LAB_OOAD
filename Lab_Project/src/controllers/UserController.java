package controllers;

import models.Employee;
import views.AdminView;
import views.BaristaView;
import views.HrdView;
import views.LoginView;
import views.ManagerView; 

public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean userLogin(String username, String password) {
		if(username.trim().isEmpty() || password.trim().isEmpty()) {
			return false;
		}
		Employee user  = Employee.getEmployee(username, password);
		
		if(user == null) {
			return false;
		} else {
			if(user.getPositionID() == 5) { // barista
				new BaristaView();
			}else if (user.getPositionID() == 6){ // product admin
				new AdminView();
			}else if (user.getPositionID() == 7) { // manager
				new ManagerView();
			}else if (user.getPositionID() == 8) { // HRD
				new HrdView();
			}
		}
		return true;
	}
	
	public static void showLoginView() {
		new LoginView();
	}
}
