package Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RentsView extends JInternalFrame{
	private JPanel panel;
	private JLabel equipIDLabel;
	private JLabel cusIDLabel;
	private JLabel day;
	private JLabel month;
	private JLabel year;
	
	private JTextField equipIDText;
	private JTextField cusIDText;
	private JTextField dayTxt;
	private JTextField monthTxt;
	private JTextField yearTxt;
	
	private JButton submitBtn;
	
	private GridBagConstraints gbc;
	
	public void initializeComponents() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		equipIDLabel = new JLabel("Enter ID of Equipment being rented: ");
		cusIDLabel = new JLabel("Enter ID of Customer renting equipment: ");
		day = new JLabel("Day Rented: ");
		month = new JLabel("Month Rented: ");
		year = new JLabel("Year Rented: ");
		
		equipIDText = new JTextField(15);
		cusIDText = new JTextField(15);
		dayTxt = new JTextField(15);
		monthTxt = new JTextField(15);
		yearTxt = new JTextField(15);	
		
		submitBtn = new JButton("Submit");
		
	}
	
	public void addComponentsToPanel() {
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(cusIDLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(cusIDText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(equipIDLabel,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(equipIDText,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(day, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(dayTxt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(month,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(monthTxt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(year, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(yearTxt, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(submitBtn, gbc);
	}
	
	public void addPanelToFrame() {
		this.add(panel);
		
	}
	
	public void setProperties() {
		this.setLayout(new GridBagLayout());
		this.setSize(600,600);
		this.setVisible(true);
		
	}
	
	public RentsView() {
		super("Renting Equipment", true, true, true, true);
		initializeComponents();
		addComponentsToPanel();
		addPanelToFrame();
		setProperties();
		
	}

}
