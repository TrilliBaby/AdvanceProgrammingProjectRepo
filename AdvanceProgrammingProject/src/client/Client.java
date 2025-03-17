package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private String action;
	private Socket connectionSocket;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	
	public Client() {
		try {
			connectionSocket = new Socket("127.0.0.1", 8888);
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

}
