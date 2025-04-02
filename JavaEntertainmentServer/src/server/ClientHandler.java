package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Customer;
import domain.Equipment;
import domain.Rent;

public class ClientHandler extends Thread {

    private Socket connectionSocket;
    private ObjectOutputStream os;
    private ObjectInputStream is;
    private Connection mycon;
    private PreparedStatement stat;
    private ResultSet results;

    public ClientHandler(Socket socket) {
        this.connectionSocket = socket;
        this.mycon = Server.getDatabaseConnection(); // Get connection from Server class
    }

    private void configureStreams() {
        try {
            os = new ObjectOutputStream(connectionSocket.getOutputStream());
            is = new ObjectInputStream(connectionSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            if (is != null) is.close();
            if (os != null) os.close();
            if (connectionSocket != null) connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Boolean searchUserName(String user) {
    	String sql = "SELECT * from EMPLOYEE WHERE UserName = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, user);
			results = stat.executeQuery();
			
			if(results.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
    	
    }
    
    private Boolean searchPassword(String password) {
    	String sql = "SELECT * from EMPLOYEE WHERE Password = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, password);
			results = stat.executeQuery();
			
			if(results.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
    	
    }

    private void addCustomerToDb(Customer cus) {
        String sql = "INSERT INTO CUSTOMER (custID, name, dOB, age, address, email, phoneNumber, gender) VALUES(?,?,?,?,?,?,?,?)";
        try {
            stat = mycon.prepareStatement(sql);
            stat.setString(1, cus.getCusID());
            stat.setString(2, cus.getName());
            stat.setDate(3, java.sql.Date.valueOf(cus.getdOB()));
            stat.setInt(4, cus.getAge());
            stat.setString(5, cus.getAddress());
            stat.setString(6, cus.getEmail());
            stat.setString(7, cus.getPhoneNumber());
            stat.setString(8, String.valueOf(cus.getGender()));

            int rowsAdded = stat.executeUpdate();
            if (rowsAdded > 0) {
                System.out.println("Customer added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void readAllCustomers() {
    	ArrayList<Customer> cusArr = new ArrayList<>();
    	//Customer cusObj = new Customer();
    	String sql = "Select * FROM Customer";
    	
    	try {
			stat = mycon.prepareStatement(sql);
			results = stat.executeQuery();
			
			while(results.next()) {
				String id = results.getString(1);
				String name = results.getString(2);
				String dob = String.valueOf(results.getDate(3));
				int age = results.getInt(4);
				String addi = results.getString(5);
				String email = results.getString(6);
				String phone = results.getString(7);
				String gender = results.getString(8);
				
				cusArr.add(new Customer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private void updateCustomerName(String cusId, String name) {
    	String sql = "UPDATE Customer SET name = ? WHERE cusID = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, name);
			stat.setString(2, cusId);
			
			stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private void deleteCustomer(String cusId) {
    	String sql = "DELETE FROM Customer WHERE cusID = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, cusId);
			int deletedRows = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    private void addEquipmentToDb(Equipment equip) {
        String sql = "INSERT INTO EQUIPMENT(equipId, name, type, status, cost, amount) VALUES(?,?,?,?,?,?)";
        try {
            stat = mycon.prepareStatement(sql);
            stat.setString(1, equip.getEquipId()); 
            stat.setString(2, equip.getName());     
            stat.setString(3, equip.getType());    
            stat.setString(4, equip.getStatus());   
            stat.setDouble(5, equip.getAmount());  
            stat.setDouble(6, equip.getCost());    
            
            int rowsAdded = stat.executeUpdate();
            if (rowsAdded > 0) {
                System.out.println("Equipment added successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void deleteEquipment(String equipId) {
    	String sql = "DELETE FROM Equipment WHERE equipID = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, equipId);
			int deletedRows = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


    private void addRentsToDb(Rent rent) {
        String sql = "INSERT INTO RENTS (customerId, equipmentId, amount_owed, rent_date, rent_time, cost, amount_paid, duration, status, " +
                     "date_day, date_month, date_year, time_hours, time_minutes, time_seconds, " +
                     "duration_hours, duration_minutes, duration_seconds) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            stat = mycon.prepareStatement(sql);
  
            stat.setString(1, rent.getCustomerId());
            stat.setString(2, rent.getEquipmentId());
            stat.setDouble(3, rent.getAmountOwed());
            stat.setString(4, rent.getDate().toString()); 
            stat.setString(5, rent.getTime().toString()); 
            stat.setDouble(6, rent.getCost());
            stat.setDouble(7, rent.getAmountPaid());
            stat.setString(8, rent.getDuration().toString()); 
            stat.setString(9, rent.getStatus());
            
            // Decompose date components
            stat.setInt(10, rent.getDate().getDay());
            stat.setInt(11, rent.getDate().getMonth());
            stat.setInt(12, rent.getDate().getYear());
            
            // Decompose time components
            stat.setInt(13, rent.getTime().getHours());
            stat.setInt(14, rent.getTime().getMinutes());
            stat.setInt(15, rent.getTime().getSeconds());
            
            // Decompose duration components
            stat.setInt(16, rent.getDuration().getHours());
            stat.setInt(17, rent.getDuration().getMinutes());
            stat.setInt(18, rent.getDuration().getSeconds());
            
            int rowsAdded = stat.executeUpdate();
            if (rowsAdded > 0) {
                System.out.println("Rent added successfully.");
                os.writeObject("Rent added successfully."); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                os.writeObject("Error adding rent: " + e.getMessage()); 
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void deleteRents(String rentId) {
    	String sql = "DELETE FROM Rents WHERE rentID = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, rentId);
			int deletedRows = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }



    @Override
    public void run() {
        configureStreams();
        try {
            String action = (String) is.readObject();

            switch (action) {
                case "add customer":
                    Customer cus = (Customer) is.readObject();
                    addCustomerToDb(cus);
                    break;
                case "add equipment":
                    Equipment equip = (Equipment) is.readObject();
                    addEquipmentToDb(equip);
                    break;
                case "add rent":
                    Rent rent = (Rent) is.readObject();
                    addRentsToDb(rent);
                    break;
                case "search password":
                	String password = (String) is.readObject();
                	os.writeObject(searchPassword(password));
                	break;
                case "search UserName":
                	String user = (String) is.readObject();
                	os.writeObject(searchUserName(user));
                	break;
                default:
                    System.out.println("Unknown action: " + action);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }
}
