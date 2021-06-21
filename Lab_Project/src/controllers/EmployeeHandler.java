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
		
		Employee users = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				String cuisine = rs.getString("cuisine");
				
				users = new Employee(rs.getInt("EmployeeID"), rs.getInt("PositionID"), rs.getInt("EmployeeSalary"), rs.getString("EmployeeName"), rs.getString("EmployeeStatus"), rs.getString("EmployeeUsername"),rs.getString("EmployeePassword"));
				employee.add(users);
			}
			return employee;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
