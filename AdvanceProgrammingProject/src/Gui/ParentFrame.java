package Gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class ParentFrame extends JFrame{
	private JMenuBar menubar;
	private JMenu user;
	private JMenuItem loginItem;
	private JMenuItem registerItem;
	
	private LoginView loginViewObj;
	private CustomerView cusViewObj;
	
	private JDesktopPane desktop;
	private JMenuItem customer;
	private JMenuItem event;
	private JMenuItem equipment;
	private JMenu generate;
	
	public void InitializeComponents() {
		menubar = new JMenuBar();
		user = new JMenu("New");
		loginItem = new JMenuItem("Login");
		registerItem = new JMenuItem("SignUp");
		loginViewObj = new LoginView();
		cusViewObj = new CustomerView();
		desktop = new JDesktopPane();
		customer = new JMenuItem("Customer");
		event = new JMenuItem("Event");
		equipment = new JMenuItem("Equipment");
		generate = new JMenu("Create");
		
	}
	
	public void addMenuItemToMenu() {
		user.add(loginItem);
		user.add(registerItem);
		user.add(customer);
		user.add(equipment);
		user.add(event);
	}
	
	public void addMenuToMenuBar() {
		menubar.add(user);
		menubar.add(generate);
	}
	
	public void addComponentsToWindow() {
		//desktop.add(new Equipment());
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
				//desktop.removeAll();
				desktop.add(loginViewObj);
			}
			
		});
		
		registerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(new RegistrationView());
			}
			
		});
		
		customer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(cusViewObj);
			}
			
		});
		
		equipment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(new EquipmentView());
			}
			
		});
		
		loginViewObj.getBtnNewButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//desktop.remove(loginViewObj);
				desktop.add(new Equipment());
			}
			
		});
		
	}
	
	public ParentFrame() {
		InitializeComponents();
		addMenuItemToMenu();
		addMenuToMenuBar();
		addComponentsToWindow();
		setProperties();
		registerListeners();
	}
	

	public static void main(String[] args) {
		
		new ParentFrame();
	}

}
