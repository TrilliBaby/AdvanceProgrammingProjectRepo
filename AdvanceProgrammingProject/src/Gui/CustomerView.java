/*
Group Members: Brianna Mowatt, Oconnor Burton, Chadrick Atkinson, Gabrielle Flash & Robert Dowe
Date: April 6, 2025
Project: Java Entertainment
*/

package Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import client.Client;
import domain.Customer;
import domain.Person;

/*
Customer view is a GUI form that allows users to input and submit information
*/

//add parent attributes to gui
public class CustomerView extends JInternalFrame{

	//Labels for form fields
	private JLabel cusIDLabel;
	private JLabel phoneLabel;
	private JLabel genderLabel;
	private JLabel nameLabel;
	private JLabel ageLabel;
	private JLabel dobLabel;
	private JLabel addressLabel;
	private JLabel emailLabel;

	//Gender radio buttons
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup btngrp;

	//Layout and container
	private GridBagConstraints gbc;
	private JPanel panel;

	//Input fields
	private JTextField cusIDText;
	private JTextField phoneText;
	private JTextField nameText;
	private JTextField ageText;
	private JFormattedTextField dob;
	private JTextField addressText;
	private JTextField emailText;

	//Date formatting
	private DateFormat dateFormat;
	private JDateChooser dateChooser;

	//Button to add a customer
	private JButton addBtn;

	//Initializes all UI components, input fields and layouts.
	
	public void initialize() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cusIDLabel = new JLabel("Customer ID: ");
		phoneLabel = new JLabel("Phone Number: ");
		genderLabel = new JLabel("Gender: ");
		nameLabel = new JLabel("Name: ");
		dobLabel = new JLabel("Date of Birth: ");
		ageLabel = new JLabel("Age: ");
		addressLabel = new JLabel("Address: ");
		emailLabel = new JLabel("Email: ");
		male = new JRadioButton("M");
		female = new JRadioButton("F");
		
		btngrp = new ButtonGroup();
		btngrp.add(male);
		btngrp.add(female);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		cusIDText = new JTextField(15);
		phoneText = new JTextField(15);
		nameText= new JTextField(15);
		dob = new JFormattedTextField(dateFormat);
		dob.setText("yyyy - mm - dd");
		dob.setColumns(15);
		
		ageText = new JTextField(15);
		addressText = new JTextField(15);
		emailText = new JTextField(15);
		
		addBtn = new JButton("Add Customer");
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		
	}

	//Adds the form elements to the panel using GridBagLayout for positioning
	public void addElementsToPanel() {
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5,5);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(nameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(nameText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(dobLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(dob, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(ageLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(ageText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(genderLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(addressLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(addressText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(emailLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(emailText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(cusIDLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(cusIDText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(phoneLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(phoneText, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		panel.add(male, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(female, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(addBtn, gbc);
	}

	//Adds the panel (which contains all form components) to the internal frame	
	public void addPanelToFrame() {
		this.add(panel);
	}

	//Sets layout and other display properties of the internal frame.	
	public void setProperties() {
		this.setLayout(new GridBagLayout());
		this.setSize(600,400);
		this.setVisible(true);
	}
	
	//Getters and Setters
	public JTextField getCusIDText() {
		return cusIDText;
	}

	public void setCusIDText(JTextField cusIDText) {
		this.cusIDText = cusIDText;
	}

	public JTextField getPhoneText() {
		return phoneText;
	}

	public void setPhoneText(JTextField phoneText) {
		this.phoneText = phoneText;
	}

	public JTextField getNameText() {
		return nameText;
	}

	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}

	public JTextField getAgeText() {
		return ageText;
	}

	public JTextField getDob() {
		return dob;
	}

	public void setDob(JFormattedTextField dob) {
		this.dob = dob;
	}

	public void setAgeText(JTextField ageText) {
		this.ageText = ageText;
	}

	public JTextField getAddressText() {
		return addressText;
	}

	public void setAddressText(JTextField addressText) {
		this.addressText = addressText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}

	public JRadioButton getMale() {
		return male;
	}

	public void setMale(JRadioButton male) {
		this.male = male;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	//Constructor that sets up the UI by calling the initialization methods.
	public CustomerView()
	{
		super("Add Customer", true, true, true, true);
		initialize();
		addElementsToPanel();
		addPanelToFrame();
		setProperties();
		//registerListeners();
		
	}
	

	
}
