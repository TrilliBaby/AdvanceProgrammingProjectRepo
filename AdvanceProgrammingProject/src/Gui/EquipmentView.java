package Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EquipmentView extends JInternalFrame{
	private JLabel equipIDLabel;
	private JLabel nameLabel;
	private JLabel typeLabel;
	private JLabel costLabel;
	private GridBagConstraints gbc;
	private JPanel panel;
	private JTextField equipIDText;
	private JTextField nameText;
	private JTextField costText;
	private JComboBox<String> typeComboBox;
	private JButton addBtn;
	
	String[] types = new String[] {"Electronic", "Music", "Lighting", "Sound"}; 
	
	public void initialize() {
		equipIDLabel = new JLabel("Equipment ID: ");
		nameLabel = new JLabel("Equipment Name: ");
		typeLabel = new JLabel("Equipment Type: ");
		costLabel = new JLabel("Renting Cost: ");
		
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		equipIDText = new JTextField(15);
		nameText = new JTextField(15);
		costText = new JTextField(15);
		addBtn = new JButton("Add Customer");
		
		typeComboBox = new JComboBox<String>(types);
	
		
	}
	
	public void addElementsToPanel() {
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5,5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(equipIDLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(nameText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(nameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(equipIDText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(typeLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(costLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(costText, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(typeComboBox, gbc);

		
		gbc.gridx = 1;
		gbc.gridy = 4;
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
	
	public EquipmentView()
	{
		super("Add Equipment", true, true, true, true);
		initialize();
		addElementsToPanel();
		addPanelToFrame();
		setProperties();
	}

}
