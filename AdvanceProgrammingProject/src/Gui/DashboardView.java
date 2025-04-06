package Gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class DashboardView extends JFrame {

	private static final long serialVersionUID = 1L;

	private CardLayout cardLayout;
	private JPanel mainPanel;


	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DashboardView frame = new DashboardView();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

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
		JMenuItem menuReport = new JMenuItem("Generate Report");
		

		menuBar.add(menuHome);
		menuBar.add(menuCustomer);
		menuBar.add(menuEquipment);
		menuBar.add(menuEvent);
		menuBar.add(menuReport);

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

		// Add panels to main container
		mainPanel.add(homePanel, "home");
		mainPanel.add(customerPanel, "customer");
		mainPanel.add(equipmentPanel, "equipment");
		mainPanel.add(eventPanel, "event");
		mainPanel.add(reportPanel, "report");

		// Menu item actions
		menuHome.addActionListener(e -> cardLayout.show(mainPanel, "home"));
		
		menuCustomer.addActionListener(e -> cardLayout.show(mainPanel, "customer"));
		menuEquipment.addActionListener(e -> cardLayout.show(mainPanel, "equipment"));
		menuEvent.addActionListener(e -> cardLayout.show(mainPanel, "event"));
		menuReport.addActionListener(e -> cardLayout.show(mainPanel, "report"));

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

		
		JLabel firstNameLabel = new JLabel("First Name:");
		JTextField firstNameTxt = new JTextField("First Name");
		firstNameTxt.setBounds(250, 150, 300, 30);
		mainUtilityPanel.add(firstNameTxt);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		JTextField lastNameTxt = new JTextField("Last Name");
		lastNameTxt.setBounds(250, 200, 300, 30);
		mainUtilityPanel.add(lastNameTxt);
		
		JLabel genderLabel = new JLabel("Last Name:");
		JTextField genderTxt = new JTextField("Gender");
		genderTxt.setBounds(250, 250, 300, 30);
		mainUtilityPanel.add(genderTxt);
		
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
		
		mainUtilityPanel.add(submit);
		
		
		return mainUtilityPanel;
	}
	
	private JPanel equipmentPanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);

		JButton button = new JButton();
		
		
		
		return mainUtilityPanel;
		
	}
	private JPanel eventPanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);
		
		
		return mainUtilityPanel;
		
	}
	private JPanel reportPanelLayout() {
		JPanel mainUtilityPanel = new JPanel();
		mainUtilityPanel.setBackground(new Color(255, 255, 255));
		mainUtilityPanel.setLayout(null);
		
		return mainUtilityPanel;
		
	}
	
}

