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

import domain.Customer;
import domain.Equipment;
import domain.Rent;

public class Server {
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	
	private static String url = "jbdc:mysql://localhost:3307/javaentertainment";
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
	
	private void addCustomerToDb(Customer cus) {
		String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			stat = mycon.prepareStatement(sql);
			stat.setString(2, cus.getName());
			stat.setInt(4, cus.getAge());
			//stat.setDate(3, );
			stat.setString(5, cus.getAddress());
			stat.setString(6, cus.getEmail());
			stat.setString(1, cus.getCusID());
			stat.setString(7, cus.getPhoneNumber());
			stat.setLong(8, cus.getGender());
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private void addEquipmentToDb(Equipment equip) {
		String sql = "INSERT INTO EQUIPMENT VALUES(?,?,?,?,?,?)";
		try {
			stat = mycon.prepareStatement(sql);
			stat.setString(2, equip.getName());
			stat.setString(3, equip.getType());
			stat.setDouble(5, equip.getAmount());
			//stat.setDate(4, equip.getStatus());
			stat.setDouble(6, equip.getCost());
			stat.setString(1, equip.getEquipId());
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private void addRentsToDb(Rent rent) {
		
	}
	
	private void waitforRequest() {
		getDatabaseConnection();
		String action;
		Customer cus = new Customer();
		
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
