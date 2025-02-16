package Gui;

import javax.swing.JFrame;

public class CustomerView {
	
	private JFrame frame;
	
	public CustomerView()
	{
		frame = new JFrame("Home Page");
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) 
	{
		new CustomerView();
	} 
}
