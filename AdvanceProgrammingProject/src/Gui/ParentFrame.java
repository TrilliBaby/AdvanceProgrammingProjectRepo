package Gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import client.Client;
import domain.Customer;
import domain.Person;
import domain.Rent;
import domain.Equipment;

public class ParentFrame extends JFrame{
	private JMenuBar menubar;
	private JMenu user;
	private JMenuItem loginItem;
	private JMenuItem registerItem;
	private JMenuItem rentsItem;
	
	private LoginView loginViewObj;
	private CustomerView cusViewObj;
	private RentsView rentsViewObj;
	private EquipmentView equipViewObj;
	
	private JDesktopPane desktop;
	private JMenuItem customer;
	private JMenuItem event;
	private JMenuItem equipment;
	
	private JMenu generate;
	private JMenuItem invoiceItem;
	private JMenuItem reportItem;
	
	private int loginVal = 0;
	
	
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
		invoiceItem = new JMenuItem("Invoice");
		reportItem = new JMenuItem("Report");
		rentsItem = new JMenuItem("Renting");
		rentsViewObj = new RentsView();
		equipViewObj = new EquipmentView();
		
		
	}
	
	public void addMenuItemToMenu() {
		user.add(loginItem);
		user.add(registerItem);
		user.add(customer);
		user.add(equipment);
		user.add(event);
		user.add(rentsItem);
		
		generate.add(invoiceItem);
		generate.add(reportItem);
		//use joptionpanes
	}
	
	public void addMenuToMenuBar() {
		menubar.add(user);
		menubar.add(generate);
	}
	
	public void addComponentsToWindow() {
		//desktop.add(new Equipment());
		desktop.add(loginViewObj);
		this.add(desktop);
	}
	
	public void setProperties() {
		this.setJMenuBar(menubar);
		this.setSize(1200, 800);
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
				if(loginVal == 1) {
					desktop.add(cusViewObj);

				}
			}
			
		});
		
		equipment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(equipViewObj);//change to obj
			}
			
		});
		
		rentsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(rentsViewObj);
			}
			
		});
		
		loginViewObj.getBtnNewButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//
				Client cliObj = new Client();
				Boolean user = false;
				Boolean passw = false;
				
				cliObj.sendAction("search UserName");
				cliObj.sendUserName(loginViewObj.getUsernameTxtField().getText());
				cliObj.recieveResponse();
				user = cliObj.getUser();
				
				
				cliObj = new Client();
				cliObj.sendAction("search password");
				cliObj.sendPassword(loginViewObj.getPasswordField().getText());
				cliObj.recieveResponse();
				passw = cliObj.getPassw();
				
				if(user && passw == true) {
					loginVal = 1;
					desktop.removeAll();
					desktop.add(new DashboardView());
				}else {
					JOptionPane.showMessageDialog(loginViewObj, "Incorrect user name or password", "password authentication", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			
		});
		
		cusViewObj.getAddBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char gen;
					
				if(cusViewObj.getMale().isSelected()) {
						gen = 'M';
				}
				else {
					gen = 'F';
				}
				Customer cus = new Customer(new Person(cusViewObj.getNameText().getText(), Integer.parseInt(cusViewObj.getAgeText().getText()), cusViewObj.getDob().getText(), cusViewObj.getAddressText().getText(),cusViewObj.getEmailText().getText()), cusViewObj.getCusIDText().getText(), cusViewObj.getPhoneText().getText(), gen);
				Client cliObj = new Client();
				cliObj.sendAction("add customer");
				cliObj.sendCustomer(cus);
				cliObj.recieveResponse();
					
			}
				
		});
		
		equipViewObj.getAddBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String type = equipViewObj.getTypeComboBox().getSelectedItem().toString();
				Equipment equip = new Equipment(equipViewObj.getEquipIDText().getText(), equipViewObj.getNameText().getText(),type ,Float.parseFloat(equipViewObj.getCostText().getText()));
				Client cliObj = new Client();
				cliObj.sendAction("add equipment");
				cliObj.sendEquipment(equip);
				
			}
			
		});
		
		rentsViewObj.getSubmitBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Rent rent = new Rent(rentsViewObj.getCusIDText().getText(), rentsViewObj.getEquipIDText().getText(), Integer.parseInt(rentsViewObj.getDurationText().getText()));
				Client cliObj = new Client();
				cliObj.sendAction("add rent");
				cliObj.sendRent(rent);
				
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
