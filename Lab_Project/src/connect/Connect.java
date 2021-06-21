package connect;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

	private final String PORT = "3306";
	private final String DBNAME = "lab_project";
	private final String URL = String.format("jdbc:mysql://localhost:%s/%s", PORT, DBNAME);
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	
	private Connection conn;
	private Statement st;
	
	public Connect() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			st = conn.createStatement();
			
			System.out.println("connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("not connected");
			e.printStackTrace();
		}
;	}
	
	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void executeUpdate (String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PreparedStatement prepareStatement(String query) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
}
