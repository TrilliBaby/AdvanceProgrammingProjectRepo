package Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


//add parent attributes to gui
public class CustomerView extends JInternalFrame{
	private JLabel cusIDLabel;
	private JLabel phoneLabel;
	private JLabel genderLabel;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup btngrp;
	private GridBagConstraints gbc;
	private JPanel panel;
	private JTextField cusIDText;
	private JTextField phoneText;
	private JButton addBtn;
	
	public void initialize() {
		cusIDLabel = new JLabel("Customer ID: ");
		phoneLabel = new JLabel("Phone Number: ");
		genderLabel = new JLabel("Gender: ");
		
		male = new JRadioButton("M");
		female = new JRadioButton("F");
		
		btngrp = new ButtonGroup();
		btngrp.add(male);
		btngrp.add(female);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		cusIDText = new JTextField(15);
		phoneText = new JTextField(15);
		addBtn = new JButton("Add Customer");
	
		
	}
	
	public void addElementsToPanel() {
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5,5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(cusIDLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(phoneText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(phoneLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(cusIDText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(genderLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(male, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(female, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(addBtn, gbc);
	}
	
	public void addPanelToFrame() {
		this.add(panel);
	}
	
	public void setProperties() {
		this.setLayout(new GridBagLayout());
		this.setSize(600,400);
		this.setVisible(true);
	}
	
	public CustomerView()
	{
		super("Add Customer", true, true, true, true);
		initialize();
		addElementsToPanel();
		addPanelToFrame();
		setProperties();
		
	}
	

	
}
