package Gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage {
	
private JFrame frame;
private JButton button;
private JButton loginButton;
private JButton signUpButton;

private JLabel loginLabel;
private JLabel passwordLabel;
private JTextField emailText;
private JTextField passwordText;
private JMenuBar menuBar;
private JMenuItem loginMenuItem;
private JPanel panel;
	
	public LoginPage()
	{
		frame = new JFrame("Login");
		frame.setSize(800,800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBackground(Color.darkGray);
		
		loginLabel = new JLabel("Login");
		loginLabel.setBounds(750, 200, 100, 30);
		loginLabel.setFont(null);
		frame.add(loginLabel);
		
		
		emailText = new JTextField("Email");
		emailText.setBounds(690, 500, 200, 30);
		frame.add(emailText);
		
		
		passwordText = new JTextField("Password");
		passwordText.setBounds(690, 550, 200, 30);
		frame.add(passwordText);
		
		
		button = new JButton("Login");
		button.setBounds(690, 600, 230, 30);
		button.setBackground(Color.red);
		
		signUpButton = new JButton("Sign Up");
		button.setBounds(850, 100, 230, 30);
		button.setBackground(Color.red);
		
		loginButton = new JButton("Login");
		button.setBounds(850, 120, 230, 30);
		button.setBackground(Color.red);
		//button.setBorder(new RoundedBorder(10));
	
		frame.add(button);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 1000);
		panel.setBorder(BorderFactory. createLineBorder(Color. black));
		panel.add(emailText);
		panel.add(passwordText);
		panel.add(button);
		
		
		frame.add(panel);
		
		loginMenuItem = new JMenuItem("Login");
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 40);
		menuBar.add(loginMenuItem);
		frame.add(menuBar);
		
	}
	
	public static void main(String[] args) 
	{
		new LoginPage();
	}
}
