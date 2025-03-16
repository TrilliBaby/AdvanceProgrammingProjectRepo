package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	
	private static String url = "jbdc:mysql://localhost:3307/";
	private static Connection mycon = null;
	private PreparedStatement stat;
	private ResultSet results;
	
	private Server() {
		try {
			serverSocket = new ServerSocket(8888,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void configureStreams() {
		try {
			os = new ObjectOutputStream(connectionSocket.getOutputStream());
			is = new ObjectInputStream(connectionSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void closeConnections() {
		try {
			is.close();
			os.close();
			connectionSocket.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getDatabaseConnection() {
		if(mycon == null) {
			try {
				mycon = DriverManager.getConnection(url, "root", "usbw");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void addCustomerToDb() {
		
	}
	
	private void waitforRequest() {
		getDatabaseConnection();
		String action;
		
		try {
			while(true) {
				connectionSocket = serverSocket.accept();
				configureStreams();
				try {
					action = (String) is.readObject();
					
					switch(action){
					case "":
						break;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				closeConnections();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		

	}

}
