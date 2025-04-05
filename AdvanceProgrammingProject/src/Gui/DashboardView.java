package Gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 800); // Adjusted height for better fit

		// Setup menu bar
		JMenuBar menuBar = new JMenuBar();
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
		getContentPane().add(mainPanel, BorderLayout.CENTER);

		// Panels for each section
		JPanel homePanel = createPanel("Welcome to Home Panel", Color.LIGHT_GRAY);
		
		JPanel customerPanel = createPanel("Manage Customers Here", Color.PINK);
		JPanel equipmentPanel = createPanel("Equipment Management", Color.CYAN);
		JPanel eventPanel = createPanel("Event Registry Panel", Color.ORANGE);
		JPanel reportPanel = createPanel("Generate Reports", Color.GREEN);

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
	private JPanel createPanel(String labelText, Color bgColor) {
		JPanel panel = new JPanel();
		panel.setBackground(bgColor);
		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel(labelText, SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(label, BorderLayout.CENTER);

		return panel;
	}
}

