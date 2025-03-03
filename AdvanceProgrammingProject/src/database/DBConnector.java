package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	static String url = "jdbc:mysql://localhost:3307/javaEntertainment";
	private static Connection myConn = null;
	
	public Connection getConnection(){
		if(myConn == null) {
			try {
				myConn = DriverManager.getConnection(url, "root", "usbw");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return myConn;
		
	}

}
