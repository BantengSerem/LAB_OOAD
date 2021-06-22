package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connect.Connect;
import models.Employee;

public class EmployeeHandler {

	public EmployeeHandler() {
		// TODO Auto-generated constructor stub
	}

	public static Vector<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Connect conn = new Connect();
		
		Vector<Employee> employee = new Vector<>();
		
		String query = "SELECT * FROM Employee";
		
		Employee user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Employee(rs.getInt("EmployeeID"), rs.getInt("PositionID"), rs.getInt("EmployeeSalary"), rs.getString("EmployeeName"), rs.getString("EmployeeStatus"), rs.getString("EmployeeUsername"),rs.getString("EmployeePassword"));
				employee.add(user);
			}
			return employee;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean addEmployee(int positionID, int salary, String name, String username, String password) {
		
		Employee emp = new Employee();
		
		boolean isAdded = emp.insertEmployee(positionID, salary, name, username, password);
		
		if(isAdded) {
			System.out.println("added");
			return true;
		}else {
			System.out.println("not added");
			return false;
		}
	}
	
	public static boolean updateEmployee(int id, int positionID, int salary, String name) {
		
		Employee emp = new Employee();
		
		boolean isUpdated = emp.updateEmployee(id, positionID, salary, name);
		
		if(isUpdated) {
			System.out.println("updated");
			return true;
		}else {
			System.out.println("not updated");
			return false;
		}
	}
	
	public static boolean fireEmployee(int employeeID) {
		
		Employee emp = new Employee();
		
		boolean isDeleted = emp.deleteEmployee(employeeID);
		
		if (isDeleted == true) {
			System.out.println("delete success");
			return true;
		}
		else {
			System.out.println("delete failed");
			return false;
		}
	}
	
	public static boolean deleteEmployee(int employeeID) {
		Employee emp = new Employee();
		
		boolean isFired = emp.fireEmployee(employeeID);
		
		if (isFired == true) {
			System.out.println("fire success");
			return true;
		}
		else {
			System.out.println("fire failed");
			return false;
		}
	}

}
