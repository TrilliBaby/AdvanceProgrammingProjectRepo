/*
Group Members: Brianna Mowatt, Oconnor Burton, Chadrick Atkinson, Gabrielle Flash & Robert Dowe
Date: April 6, 2025
Project: Java Entertainment
*/

package Gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import client.Client;
import domain.Customer;
import domain.Equipment;
import domain.Person;
import domain.Rent;
import domain.Event;

public class DashboardView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private CardLayout cardLayout;
	private JPanel mainPanel;
	

/*
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DashboardView frame = new DashboardView();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}*/

	public DashboardView() {
		setVisible(true);
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1177, 800); // Adjusted height for better fit

		// Setup menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(128, 128, 255));
		menuBar.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		setJMenuBar(menuBar);

		JMenuItem menuHome = new JMenuItem("Home");
		JMenuItem menuCustomer = new JMenuItem("Customer Management");
		JMenuItem menuEquipment = new JMenuItem("Manage Equipment");
		JMenuItem menuEvent = new JMenuItem("Event Registry");
		JMenuItem menuSchedule = new JMenuItem("Schedule System");
		JMenuItem menuReport = new JMenuItem("Generate Report");
		

		menuBar.add(menuHome);
		menuBar.add(menuCustomer);
		menuBar.add(menuEquipment);
		menuBar.add(menuEvent);
		menuBar.add(menuReport);
		menuBar.add(menuSchedule);

		// CardLayout setup
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		mainPanel.setBackground(new Color(240, 240, 240));
		getContentPane().add(mainPanel, BorderLayout.CENTER);

		// Panels for each section
		JPanel homePanel = homePanelLayout("Welcome to Home Panel", Color.LIGHT_GRAY);
		homePanel.setLayout(null);
		
		JPanel customerPanel = customerPanelLayout();
		JPanel equipmentPanel = equipmentPanelLayout();
		JPanel eventPanel = eventPanelLayout();
		JPanel reportPanel = reportPanelLayout();
		JPanel schedulePanel = schedulePanelLayout();

		// Add panels to main container
		mainPanel.add(homePanel, "home");
		mainPanel.add(customerPanel, "customer");
		mainPanel.add(equipmentPanel, "equipment");
		mainPanel.add(eventPanel, "event");
		mainPanel.add(reportPanel, "report");
		mainPanel.add(schedulePanel, "schedule");

		// Menu item actions
		menuHome.addActionListener(e -> cardLayout.show(mainPanel, "home"));
		
		menuCustomer.addActionListener(e -> cardLayout.show(mainPanel, "customer"));
		menuEquipment.addActionListener(e -> cardLayout.show(mainPanel, "equipment"));
		menuEvent.addActionListener(e -> cardLayout.show(mainPanel, "event"));
		menuReport.addActionListener(e -> cardLayout.show(mainPanel, "report"));
		menuSchedule.addActionListener(e -> cardLayout.show(mainPanel, "schedule"));

		// Show home panel initially
		cardLayout.show(mainPanel, "home");
	}

	// Utility method to create simple panels with color and label
	private JPanel homePanelLayout(String labelText, Color bgColor) {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);

		JLabel label = new JLabel(labelText, SwingConstants.CENTER);
		label.setBounds(0, 0, 0, 0);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		mainUtilityPanel.add(label);
		
		JPanel display1Panel = new JPanel();
		display1Panel.setBackground(new Color(128, 128, 255));
		display1Panel.setBounds(40, 229, 222, 167);
		mainUtilityPanel.add(display1Panel);
		display1Panel.setLayout(null);
		
		JPanel welcomeBackPanel = new JPanel();
		welcomeBackPanel.setBackground(new Color(244, 244, 255));
		welcomeBackPanel.setBounds(40, 38, 740, 155);
		mainUtilityPanel.add(welcomeBackPanel);
		welcomeBackPanel.setLayout(null);
		
		JButton welcomeButton = new JButton("New button");
		welcomeButton.setBounds(27, 110, 85, 21);
		welcomeBackPanel.add(welcomeButton);
		
		JLabel welcomeLabel = new JLabel("WELCOME BACK");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		welcomeLabel.setBounds(27, 20, 387, 51);
		welcomeBackPanel.add(welcomeLabel);
		
		JLabel welcomeTextLabel = new JLabel("WELCOME BACK");
		welcomeTextLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		welcomeTextLabel.setBounds(27, 67, 387, 51);
		welcomeBackPanel.add(welcomeTextLabel);
		
		JScrollPane recentEquipmentSchedulePanel = new JScrollPane();
		recentEquipmentSchedulePanel.setBounds(40, 459, 740, 228);
		mainUtilityPanel.add(recentEquipmentSchedulePanel);
		
		JPanel utilityPanel = new JPanel();
		utilityPanel.setBackground(new Color(244, 244, 255));
		utilityPanel.setBounds(816, 0, 347, 735);
		mainUtilityPanel.add(utilityPanel);
		utilityPanel.setLayout(null);
		JCalendar calendar = new JCalendar();
		calendar.setWeekdayForeground(new Color(255, 255, 255));
		calendar.setDecorationBackgroundColor(new Color(151, 151, 255));
		calendar.setBounds(26, 30, 304, 246);
		utilityPanel.add(calendar);
		
		JPanel display2Panel = new JPanel();
		display2Panel.setBackground(new Color(128, 128, 255));
		display2Panel.setBounds(301, 229, 222, 167);
		mainUtilityPanel.add(display2Panel);
		display2Panel.setLayout(null);
		
		JPanel display3Panel = new JPanel();
		display3Panel.setBackground(new Color(128, 128, 255));
		display3Panel.setBounds(558, 229, 222, 167);
		mainUtilityPanel.add(display3Panel);
		display3Panel.setLayout(null);
		
		JLabel lblRecentEquipmentSchedule = new JLabel("Recent Equipment Schedule ");
		lblRecentEquipmentSchedule.setBounds(40, 419, 254, 30);
		mainUtilityPanel.add(lblRecentEquipmentSchedule);

		return mainUtilityPanel;
	}
	
	private JPanel customerPanelLayout() {
		
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);

		
		JPanel display1Panel = new JPanel();
		display1Panel.setBackground(new Color(128, 128, 255));
		display1Panel.setBounds(600, 128, 400, 400);
		display1Panel.setLayout(null);
		mainUtilityPanel.add(display1Panel);
		
		JLabel customerRegistryLabel = new JLabel("Customer Registry");
		customerRegistryLabel.setBounds(250, 100, 300, 50);
		mainUtilityPanel.add(customerRegistryLabel);

		
		JLabel cusIdLabel = new JLabel("Customer ID:" );
		JTextField cusIdTxt = new JTextField("Customer ID");
		cusIdTxt.setBounds(250, 150, 300, 30);
		mainUtilityPanel.add(cusIdTxt);
		
		JLabel nameLabel = new JLabel("Enter Name:");
		JTextField nameTxt = new JTextField("Name");
		nameTxt.setBounds(250, 200, 300, 30);
		mainUtilityPanel.add(nameTxt);
		
		JLabel maleLabel = new JLabel("Male:");
		maleLabel.setBounds(0, 200, 100, 50);
		mainUtilityPanel.add(maleLabel);

		JRadioButton male =  new JRadioButton();
		male.setBounds(300, 250, 50, 30);
		mainUtilityPanel.add(male);
		
		JLabel femaleLabel = new JLabel("Female:");
		maleLabel.setBounds(10, 200, 100, 50);
		mainUtilityPanel.add(femaleLabel);

		JRadioButton female = new JRadioButton();
		female.setBounds(450, 250, 50, 30);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(female);
		btnGroup.add(male);
		
		mainUtilityPanel.add(female);
		
		
        JDateChooser calendar =  new JDateChooser();
        calendar.setBounds(250, 300, 300, 30);
        mainUtilityPanel.add(calendar);
        
		JTextField phoneNumberTxt = new JTextField("Phone Number");
		phoneNumberTxt.setBounds(250, 350, 300, 30);
		mainUtilityPanel.add(phoneNumberTxt);
		
		JTextField addressTxt = new JTextField("Address");
		addressTxt.setBounds(250, 400, 300, 30);
		mainUtilityPanel.add(addressTxt);
		
		JTextField emailTxt = new JTextField("Email");
		emailTxt.setBounds(250, 450, 300, 30);
		mainUtilityPanel.add(emailTxt);
		
		
		
        /*"\n  Age = " + age +
        "\n  Date of Birth = " + dOB +
        "\n  Phone Number = " + phoneNumber +
        "\n  Email = " + email +
        "\n  Address = " + address;
*/
		
		JButton submit = new JButton("ADD CUSTOMER");
		submit.setBounds(250, 500, 300, 30);
		submit.setBackground(new Color(128, 128, 255));
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char gen;
				
				if(male.isSelected()) {
						gen = 'M';
				}
				else {
					gen = 'F';
				}
				
				Date date = new Date();
				int year = date.getYear();
				int age = year - calendar.getDate().getYear();
				
				Customer cus = new Customer(new Person(nameTxt.getText(),age, calendar.getDate(), addressTxt.getText(), emailTxt.getText()), cusIdTxt.getText(), phoneNumberTxt.getText(), gen);
				Client cliObj = new Client();
				cliObj.sendAction("add customer");
				cliObj.sendCustomer(cus);
				cliObj.recieveResponse();
				
			}
			
		});
		
		mainUtilityPanel.add(submit);
		
		
		return mainUtilityPanel;
	}
	
	private JPanel equipmentPanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);

		
		JPanel display1Panel = new JPanel();
		display1Panel.setBackground(new Color(128, 128, 255));
		display1Panel.setBounds(600, 128, 400, 400);
		display1Panel.setLayout(null);
		mainUtilityPanel.add(display1Panel);
		
		JLabel equipmentRegistryLabel = new JLabel("Equipment Registry");
		equipmentRegistryLabel.setBounds(250, 200, 300, 50);
		mainUtilityPanel.add(equipmentRegistryLabel);

		
		JTextField equipmentIdTxt = new JTextField("Equipment ID");
		equipmentIdTxt.setBounds(250, 250, 300, 30);
		mainUtilityPanel.add(equipmentIdTxt);
		
		JTextField equipmentNameTxt = new JTextField("Equipment Name");
		equipmentNameTxt.setBounds(250, 300, 300, 30);
		mainUtilityPanel.add(equipmentNameTxt);
		
		String type[] = {"electronic", "non-electronic"};
		JComboBox<String> combobox= new JComboBox<String>(type);
		combobox.setBounds(250, 350, 300, 30);
		mainUtilityPanel.add(combobox);
		
		JTextField equipmentPriceTxt = new JTextField("Equipment Price");
		equipmentPriceTxt.setBounds(250, 400, 300, 30);
		mainUtilityPanel.add(equipmentPriceTxt);
		
	
		JButton submit = new JButton("ADD EQUIPMENT");
		submit.setBounds(250, 450, 300, 30);
		submit.setBackground(new Color(128, 128, 255));
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String type = combobox.getSelectedItem().toString();
				Equipment equip = new Equipment(equipmentIdTxt.getText(), equipmentNameTxt.getText(),type ,Float.parseFloat(equipmentPriceTxt.getText()));
				Client cliObj = new Client();
				cliObj.sendAction("add equipment");
				cliObj.sendEquipment(equip);
				
			}
			
		});
		
		mainUtilityPanel.add(submit);
		
		return mainUtilityPanel;
		
	}
	
	
	private JPanel eventPanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);

		
		JPanel display1Panel = new JPanel();
		display1Panel.setBackground(new Color(128, 128, 255));
		display1Panel.setBounds(600, 128, 400, 400);
		display1Panel.setLayout(null);
		mainUtilityPanel.add(display1Panel);
		
		JLabel eventRegistryLabel = new JLabel("Event Registry");
		eventRegistryLabel.setBounds(250, 100, 300, 50);
		mainUtilityPanel.add(eventRegistryLabel);

		
		JTextField eventIdTxt = new JTextField("Event ID");
		eventIdTxt.setBounds(250, 150, 300, 30);
		mainUtilityPanel.add(eventIdTxt);
		
		//JLabel eventNameLabel = new JLabel("First Name:");
		JTextField eventNameTxt = new JTextField("Name of Event");
		eventNameTxt.setBounds(250, 200, 300, 30);
		mainUtilityPanel.add(eventNameTxt);
		
		//JLabel lastNameLabel = new JLabel("Last Name:");
		JTextField addressTxt = new JTextField("Address");
		addressTxt.setBounds(250, 250, 300, 30);
		mainUtilityPanel.add(addressTxt);
		
		//JLabel genderLabel = new JLabel("Last Name:");
		JTextField durationTxt = new JTextField("Duration");
		durationTxt.setBounds(250, 300, 300, 30);
		mainUtilityPanel.add(durationTxt);
		
        JDateChooser eventDate =  new JDateChooser(null, "Date of Event");
        eventDate.setBounds(250, 350, 300, 30);
        mainUtilityPanel.add(eventDate);
        
		JTextField eventTime = new JTextField("Time Of Event");
		eventTime.setBounds(250, 400, 300, 30);
		mainUtilityPanel.add(eventTime);
		
		String status[] = {"--Status--","Active","Pending"};
		JComboBox<String> statusCombo = new JComboBox<String>(status);
		statusCombo.setSelectedIndex(0);
		statusCombo.setBounds(250, 450, 300, 30);
		mainUtilityPanel.add(statusCombo);
		
		JButton submit = new JButton("ADD EVENT");
		submit.setBounds(250, 500, 300, 30);
		submit.setBackground(new Color(128, 128, 255));
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String status = statusCombo.getSelectedItem().toString();
				Event event = new Event(eventIdTxt.getText(), eventNameTxt.getText(), addressTxt.getText(),Integer.parseInt(durationTxt.getText()), eventDate.getDate(), eventTime.getText(), status);
				Client cliObj = new Client();
				cliObj.sendAction("add event");
				cliObj.sendEvent(event);
				
			}
			
		});
		
		mainUtilityPanel.add(submit);
		
		
		return mainUtilityPanel;
	}
	private JPanel reportPanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);
		
		JPanel display1Panel = new JPanel();
		display1Panel.setBackground(new Color(128, 128, 255));
		display1Panel.setBounds(500, 100, 500, 500);
		display1Panel.setLayout(null);
		mainUtilityPanel.add(display1Panel);
		
		JLabel reportLbl= new JLabel("Generate Report");
		reportLbl.setBounds(100, 100, 100, 30);
		
mainUtilityPanel.add(reportLbl);
		
		JTextField customerId = new JTextField("Enter Customer ID");
		customerId.setBounds(100,150,200,30);
		mainUtilityPanel.add(customerId);
		
		JButton generate = new JButton("GENERATE REPORT");
		generate.setBounds(100, 250, 200, 30);
		
		
		mainUtilityPanel.add(generate);
		generate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Client cliObj = new Client();
				cliObj.sendAction("generate invoice");
				cliObj.sendCustId(customerId.getText());
				
			}});
		
		
		
		return mainUtilityPanel;


		
	}
	
	private JPanel schedulePanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);
		
		JPanel display1Panel = new JPanel();
		display1Panel.setBackground(new Color(128, 128, 255));
		display1Panel.setBounds(600, 128, 400, 400);
		display1Panel.setLayout(null);
		mainUtilityPanel.add(display1Panel);
		
		JButton update =new JButton("UPDATE");
		update.setBounds(20, 350, 150, 30);
		update.setBackground(Color.WHITE);
		display1Panel.add(update);
		
		JButton delete =new JButton("DELETE");
		delete.setBounds(230, 350, 150, 30);
		delete.setBackground(Color.WHITE);
		display1Panel.add(delete);
		
		JLabel scheduleSystemLabel = new JLabel("Schedule System");
		scheduleSystemLabel.setBounds(250, 100, 300, 50);
		mainUtilityPanel.add(scheduleSystemLabel);
		
		//JLabel equipmentIdLabel = new JLabel("Equipment Id");
		JTextField customerIdTxt = new JTextField("Customer Id");
		customerIdTxt.setBounds(250, 150, 300, 30);
		mainUtilityPanel.add(customerIdTxt);
		
		//JLabel lastNameLabel = new JLabel("Last Name:");
		JTextField equipmentIdTxt = new JTextField("Equipment Id");

		equipmentIdTxt.setBounds(250, 200, 300, 30);
		mainUtilityPanel.add(equipmentIdTxt);
		
		JTextField amountTxt = new JTextField("Amount");
		amountTxt.setBounds(250, 250, 300, 30);
		mainUtilityPanel.add(amountTxt);
		
        
		JTextField amountPaidTxt = new JTextField("Amount Paid");
		amountPaidTxt.setBounds(250, 350, 300, 30);
		mainUtilityPanel.add(amountPaidTxt);
		
		JTextField durationTxt = new JTextField("Duration");
		durationTxt.setBounds(250, 400, 300, 30);

mainUtilityPanel.add(durationTxt);
		
		
		JButton submit = new JButton("ADD TO SCHEDULE");
		submit.setBounds(250, 450, 300, 30);
		submit.setBackground(new Color(128, 128, 255));
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Rent rent = new Rent(customerIdTxt.getText(), equipmentIdTxt.getText(), Double.parseDouble(amountTxt.getText()), Double.parseDouble(amountPaidTxt.getText()), Integer.parseInt(durationTxt.getText()));
				Client cliObj = new Client();
				cliObj.sendAction("add rent");
				cliObj.sendRent(rent);				
			}
			
		});
		
		mainUtilityPanel.add(submit);
return mainUtilityPanel;
		
	}

	
}
