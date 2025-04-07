/*
Group Members: Brianna Mowatt, Oconnor Burton, Chadrick Atkinson, Gabrielle Flash & Robert Dowe
Date: April 6, 2025
Project: Java Entertainment
*/

package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import domain.Customer;
import domain.Employee;
import domain.Equipment;
import domain.Event;
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
    
    private Boolean searchCustomer(String custID) {
    	String sql = "SELECT * from CUSTOMER WHERE custID = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, custID);
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
        String sql = "INSERT INTO CUSTOMER (cusID, name, dOB, age, address, email, phoneNumber, gender) VALUES(?,?,?,?,?,?,?,?)";
        try {
            stat = mycon.prepareStatement(sql);
            stat.setString(1, cus.getCusID());
            stat.setString(2, cus.getName());
            stat.setDate(3, new java.sql.Date(cus.getdOB().getTime()));
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
    
    private void addEmployeeToDb(Employee emp) {
        String sql = "INSERT INTO CUSTOMER (userName, password, trn, name, dOB, age, address, email) VALUES(?,?,?,?,?,?,?,?)";
        try {
            stat = mycon.prepareStatement(sql);
            stat.setString(1, emp.getUserName());
            stat.setString(2, emp.getPassword());
            stat.setString(3, emp.getTrn());
            stat.setString(4, emp.getName());
            //stat.setString(5, emp.getAddress());
            stat.setInt(6, emp.getAge());
            stat.setString(7, emp.getAddress());
            stat.setString(8, emp.getEmail());

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
    
    

    private void addEquipmentToDb(Equipment equip) {
        String sql = "INSERT INTO EQUIPMENT(equipId, name, type, cost) VALUES(?,?,?,?)";
        try {
            stat = mycon.prepareStatement(sql);
            stat.setString(1, equip.getEquipId()); 
            stat.setString(2, equip.getName());     
            stat.setString(3, equip.getType());       
            stat.setDouble(4, equip.getCost());    
            
            int rowsAdded = stat.executeUpdate();
            if (rowsAdded > 0) {
                System.out.println("Equipment added successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Boolean searchEquipment(String equipId) {
    	String sql = "SELECT * from EQUIPMENT WHERE equipId = ?";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, equipId);
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

    private void addRentsToDb(Rent rent) {
        String sql = "INSERT INTO RENTS (customerId, equipmentId, amount, rent_date, amount_paid, duration) VALUES (?, ?, ?, ?, ?, ?)";
        String sql2 = "SELECT * FROM EQUIPMENT WHERE equipId = ?";
        Date date = new Date();
        LocalTime localTime = LocalTime.now();
        
        try {
        	PreparedStatement pstat = mycon.prepareStatement(sql2);
        	pstat.setString(1, rent.getEquipmentId());
        	ResultSet rs = pstat.executeQuery();
        	
        	double cost = 0;
        	
        	if(rs.next()) {
        		cost = rs.getDouble(4);
        	}
        	
        	
        	
        	double totalAmount = cost * rent.getDuration();
        	
            stat = mycon.prepareStatement(sql);
  
            stat.setString(1, rent.getCustomerId());
            stat.setString(2, rent.getEquipmentId());
            stat.setDouble(3, totalAmount);
            stat.setDate(4, new java.sql.Date(date.getTime())); 
            //stat.setDouble(6, cost);
            stat.setDouble(5, rent.getAmountPaid());
            stat.setInt(6, rent.getDuration()); 
       
            
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
    
    private ArrayList<Rent> invoiceForCustomers(String cusId) {
    	String sql = "SELECT * FROM RENTS WHERE customerId = ?";
    	ArrayList<Rent> list = new ArrayList<>();
    	
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, cusId);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				Rent rent = new Rent();
				String equip = rs.getString(2);
				double amount = rs.getDouble(3);
				
				rent = new Rent(equip,amount);
				
				list.add(rent);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    private void addEventToDb(Event obj) {
    	String sql = "INSERT INTO event VALUES(?,?,?,?,?,?,?)";
    	try {
			stat = mycon.prepareStatement(sql);
			stat.setString(1, obj.getEID());
			stat.setString(2, obj.getName());
			stat.setString(3, obj.getAddress());
			stat.setInt(4, obj.getDuration());
			stat.setDate(5, new java.sql.Date(obj.getEventDate().getTime()));
			stat.setTime(6, java.sql.Time.valueOf(obj.getEventTime()));
			stat.setString(7, obj.getStatus());
			
			int rowsAdded = stat.executeUpdate();
            if (rowsAdded > 0) {
                System.out.println("Event added successfully.");
                try {
					os.writeObject("Event added successfully.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            }
			
			
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
                case "add event":
                	Event event = (Event) is.readObject();
                	addEventToDb(event);
                	break;
                case "generate invoice":
                	String cusId = (String) is.readObject();
                	os.writeObject(invoiceForCustomers(cusId));
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
