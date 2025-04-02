package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import domain.Customer;
import javaEntertainment.Equipment;
import javaEntertainment.Rent;

public class Client {
	private String action;
	private Socket connectionSocket;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Boolean passw, user;
	
	public Client() {
		try {
			connectionSocket = new Socket("127.0.0.1", 8888);
			configureStreams();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void configureStreams() {
		try {
			os = new ObjectOutputStream(connectionSocket.getOutputStream());
			is = new ObjectInputStream(connectionSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeStreams() {
		try {
			os.close();
			is.close();
			connectionSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendAction(String action) {
		this.action = action;
		
		try {
			os.writeObject(action);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendCustomer(Customer cus) {
		try {
			os.writeObject(cus);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendEquipment(Equipment equip) {
		try {
			os.writeObject(equip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendRents(Rent rent) {
		try {
			os.writeObject(rent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendPassword(String passw) {
		try {
			os.writeObject(passw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendUserName(String user) {
		try {
			os.writeObject(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recieveResponse() {
		switch(action) {
		case "add customer":
			JOptionPane.showMessageDialog(null, "Customer Added to DB");
			break;
		case "add equipment":
			break;
		case "add rent":
			break;
		case "search UserName":
			try {
				user = (Boolean) is.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "search password":
			try {
				passw = (Boolean) is.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		
		
	}

	public Boolean getPassw() {
		return passw;
	}

	public void setPassw(Boolean passw) {
		this.passw = passw;
	}

	public Boolean getUser() {
		return user;
	}

	public void setUser(Boolean user) {
		this.user = user;
	}

}
