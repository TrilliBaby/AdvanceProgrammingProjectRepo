package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Insets;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import javax.swing.JPasswordField;

public class LoginView extends JInternalFrame{

	//private JFrame frame;
	private JTextField usernameTxtField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;



	/**
	 * Create the application.
	 * 
	 * add login to desktopPane as the starting screen that wont dispose until the 
	 * password is correct
	 */
	public LoginView() {
		super("Login", true);
		initializeComponents();
		addComponentsToPanel();
		addComponentsToWindow();
		setWindowProperties();
		
	}
	
	
	public JTextField getUsernameTxtField() {
		return usernameTxtField;
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeComponents() {
		//this = new JFrame();
		//this.getContentPane().setBackground(new Color(221, 221, 255));
		//this.getContentPane().setForeground(new Color(128, 128, 128));
		//this.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		//JDesktopPane desktopPane = new JDesktopPane();
		//frame.getContentPane().add(desktopPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(221, 221, 255));
		panel.setBounds(279, 53, 319, 456);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(597, 53, 319, 456);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(99, 46, 119, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		usernameTxtField = new JTextField();
		usernameTxtField.setBounds(51, 134, 225, 34);
		usernameTxtField.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBounds(95, 294, 144, 40);
		
		
		lblNewLabel_1 = new JLabel("EMAIL");
		lblNewLabel_1.setBounds(51, 121, 45, 13);
		
		
		lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(51, 197, 88, 13);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(51, 211, 225, 34);
		
	}
	
	public void addComponentsToPanel() {
		panel_1.add(lblNewLabel);
		panel_1.add(usernameTxtField);
		panel_1.add(btnNewButton);
		panel_1.add(lblNewLabel_1);
		panel_1.add(lblNewLabel_2);
		panel_1.add(passwordField);
		
	}
	
	public void addComponentsToWindow() {
		this.add(panel);
		this.add(panel_1);
		
	}
	
	public void setWindowProperties() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(1000, 600);
		this.setVisible(true);
		this.setBackground(new Color(164, 180, 227));
	}
	
	

}
