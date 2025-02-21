package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class ParentWindow extends JFrame{
	private JMenuBar menubar;
	private JMenu user;
	private JMenuItem loginItem;
	private JMenuItem registerItem;
	private LoginView loginViewObj;
	private JDesktopPane desktop;
	
	public void InitializeComponents() {
		menubar = new JMenuBar();
		user = new JMenu("Login");
		loginItem = new JMenuItem("Login");
		registerItem = new JMenuItem("SignUp");
		loginViewObj = new LoginView();
		desktop = new JDesktopPane();
	}
	
	public void addMenuItemToMenu() {
		user.add(loginItem);
		user.add(registerItem);
	}
	
	public void addMenuToMenuBar() {
		menubar.add(user);
	}
	
	public void addComponentsToWindow() {
		desktop.add(new Equipment());
		this.add(desktop);
	}
	
	public void setProperties() {
		this.setJMenuBar(menubar);
		this.setSize(1020, 700);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void registerListeners() {
		loginItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.removeAll();
				desktop.add(loginViewObj);
			}
			
		});
		
		registerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(new RegistrationView());
			}
			
		});
		
		loginViewObj.getBtnNewButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.remove(loginViewObj);
				desktop.add(new Equipment());
			}
			
		});
		
	}
	
	public ParentWindow() {
		InitializeComponents();
		addMenuItemToMenu();
		addMenuToMenuBar();
		addComponentsToWindow();
		setProperties();
		registerListeners();
	}
	

	public static void main(String[] args) {
		
		new ParentWindow();
	}

}
