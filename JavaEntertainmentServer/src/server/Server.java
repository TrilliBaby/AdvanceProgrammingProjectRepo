package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    private ServerSocket serverSocket;
    Socket clientSocket;
    private static Connection mycon;
    private static final String DB_URL = "jdbc:mysql://localhost:3307/javaentertainment";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "usbw";

    public Server() {
        try {
            serverSocket = new ServerSocket(8888);
            establishDatabaseConnection();
            waitForRequests();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void establishDatabaseConnection() {
        if (mycon == null) {
            try {
                mycon = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Database connection established.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getDatabaseConnection() {
        return mycon;
    }

    private void waitForRequests() {
        System.out.println("Server is running and waiting for clients...");
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                new ClientHandler(clientSocket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
         
            
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}










/*package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

import javax.swing.JOptionPane;

import domain.Customer;
import domain.Equipment;
import domain.Rent;

public class Server extends Thread {
	
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	
	private static String url = "jdbc:mysql://localhost:3307/javaentertainment";
	private static Connection mycon = null;
	private PreparedStatement stat;
	private ResultSet results;
	
	
	private Server() {
		try {
			serverSocket = new ServerSocket(8888,1);
			waitForRequest();
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
		String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?)";
		//java.sql.Date date = java.sql.Date.valueOf(cus.getdOB());

		try {
			
			try {
				stat = mycon.prepareStatement(sql);
				stat.setString(2, cus.getName());
				stat.setInt(4, cus.getAge());
				stat.setDate(3, java.sql.Date.valueOf(cus.getdOB()));
				stat.setString(5, cus.getAddress());
				stat.setString(6, cus.getEmail());
				stat.setString(1, cus.getCusID());
				stat.setString(7, cus.getPhoneNumber());
				stat.setString(8, String.valueOf(cus.getGender()));
				
			}catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid");
				
			}
			
			
			
			int rowsAdded = stat.executeUpdate();
		
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
	
	private void search() {
		
	}
	
	private void waitForRequest() {
		getDatabaseConnection();
		String action;
		Customer cus = new Customer();
		Equipment equip = new Equipment();
		Rent rent = new Rent();
		
		try {
			while(true) {
				connectionSocket = serverSocket.accept();
				configureStreams();
				try {
					action = (String) is.readObject();
					
					switch(action){
					case "add customer":
						cus = (Customer) is.readObject();
						addCustomerToDb(cus);
						break;
					case "add equipment":
						equip = (Equipment) is.readObject();
						addEquipmentToDb(equip);
						break;
					case "add rent":
						rent = (Rent) is.readObject();
						addRentsToDb(rent);
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
		new Server();
		

	}

}*/
