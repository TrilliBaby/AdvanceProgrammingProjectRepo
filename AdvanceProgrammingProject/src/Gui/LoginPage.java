package Gui;

import javax.swing.JFrame;

public class LoginPage {
	
private JFrame frame;
	
	public LoginPage()
	{
		frame = new JFrame("Login");
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new LoginPage();
	}
}
