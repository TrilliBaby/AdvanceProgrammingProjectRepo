/*
Group Members: Brianna Mowatt, Oconnor Burton, Chadrick Atkinson, Gabrielle Flash & Robert Dowe
Date: April 6, 2025
Project: Java Entertainment
*/

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
	private JLabel durationLabel;
	
	private JTextField equipIDText;
	private JTextField cusIDText;
	private JTextField durationText;
	
	private JButton submitBtn;
	
	private GridBagConstraints gbc;
	
	public void initializeComponents() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		equipIDLabel = new JLabel("Enter ID of Equipment being rented: ");
		cusIDLabel = new JLabel("Enter ID of Customer renting equipment: ");
		durationLabel = new JLabel("Enter the number of days that the equipment will be rented for");
		
		
		equipIDText = new JTextField(15);
		cusIDText = new JTextField(15);
		durationText = new JTextField(15);	
		
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
		panel.add(durationLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(durationText,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(submitBtn, gbc);
	}
	
	public JTextField getEquipIDText() {
		return equipIDText;
	}

	public void setEquipIDText(JTextField equipIDText) {
		this.equipIDText = equipIDText;
	}

	public JTextField getCusIDText() {
		return cusIDText;
	}

	public void setCusIDText(JTextField cusIDText) {
		this.cusIDText = cusIDText;
	}

	public JTextField getDurationText() {
		return durationText;
	}

	public void setDurationText(JTextField durationText) {
		this.durationText = durationText;
	}

	public JButton getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(JButton submitBtn) {
		this.submitBtn = submitBtn;
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
