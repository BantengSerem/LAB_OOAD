package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class Employee {

	private int employeeID, positionID, salary;
	private String name, status, username, password;
	private static Connect conn = new Connect();

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeID, int positionID, int salary, String name, String status, String username,
			String password) {
		super();
		this.employeeID = employeeID;
		this.positionID = positionID;
		this.salary = salary;
		this.name = name;
		this.status = status;
		this.username = username;
		this.password = password;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Employee getEmployee(String username, String password) {
		String query = "SELECT * FROM Employee WHERE EmployeeUsername=? AND EmployeePassword=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		Employee user = null;
		
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Employee(rs.getInt("EmployeeID"), rs.getInt("PositionID"), rs.getInt("EmployeeSalary"), rs.getString("EmployeeName"), rs.getString("EmployeeStatus"), rs.getString("EmployeeUsername"),rs.getString("EmployeePassword"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
