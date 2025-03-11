package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServerConnector {
    
    private String url;
    private static Connection connect;
    
    
    //Default constructor respective attributes:
    public ServerConnector() {
        this.url = "jdbc:mysql://localhost:3307/javaEntertainment";
    }
    
    //
    public Connection getDmsConnection() {
        try {
            connect = DriverManager.getConnection(url, "root", "");
            JOptionPane.showMessageDialog(null, "Connected to Server", "Connection Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace(); // Corrected exception handling
            JOptionPane.showMessageDialog(null, "Connection Failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return connect; // Return connection
    }

    public static Connection getConnection() {
        return connect;
    }
}
