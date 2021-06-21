package controllers;

import models.Employee;
import views.BaristaView;
import views.LoginView; 

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
//				ItemController.showAdminItemView();
			}else if (user.getPositionID() == 6){ // product admin
//				ItemController.showUserItemView();
			}else if (user.getPositionID() == 7) { // manager
				
			}else if (user.getPositionID() == 8) { // HRD
				
			}
		}
		return true;
	}
	
	public static void showLoginView() {
		new LoginView();
	}
}
