package eventSchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventScheduleSystem {
    private JFrame frame;
    private JPanel panel;
    private JTextField equipmentNameField, eventNameField, quantityField;
    private JTextArea outputArea;
    private JLabel statusLabel;

    public EventScheduleSystem() {
        
    	// Initialize the main frame
        frame = new JFrame("Event Scheduling System");
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Set default constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        
        // Color theme
        panel.setBackground(new Color(240, 248, 255)); // Light blue background

        // Create and add components to the panel
        initializeComponents(gbc);

        // Set up the frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Centers the window
    }

    private void initializeComponents(GridBagConstraints gbc) {
        	
    	// Equipment Name Input
        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        panel.add(new JLabel("Equipment:"), gbc);

        equipmentNameField = new JTextField(20);
        gbc.gridx = 1; // Column 1
        panel.add(equipmentNameField, gbc);

        // Event Name Input
        gbc.gridx = 0; // Column 0
        gbc.gridy = 2; // Row 2
        panel.add(new JLabel("Event:"), gbc);

        eventNameField = new JTextField(20);
        eventNameField.setToolTipText("Enter the name of the event");
        gbc.gridx = 1; // Column 1
        panel.add(eventNameField, gbc);

        // Quantity Input
        gbc.gridx = 0; // Column 0
        gbc.gridy = 3; // Row 3
        panel.add(new JLabel("Quantity:"), gbc);

        quantityField = new JTextField(20);
        quantityField.setToolTipText("Enter the quantity of equipments");
        gbc.gridx = 1; // Column 1
        panel.add(quantityField, gbc);

        // Output Area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(255, 255, 255)); //White Background
        gbc.gridx = 0; // Column 0
        gbc.gridy = 4; // Row 4
        gbc.gridwidth = 2; // Span two columns
        panel.add(new JScrollPane(outputArea), gbc);
        gbc.gridwidth = 1; // Reset to default
        
        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setToolTipText("Submit the event details");
        submitButton.addActionListener(new SubmitButtonListener());
        gbc.gridx = 0; // Column 0
        gbc.gridy = 5; // Row 5
        gbc.gridwidth = 1; // Span one column
        panel.add(submitButton, gbc);
        
        // Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setIcon(new ImageIcon("clear_icon.png")); // Add an icon
        clearButton.setToolTipText("Clear all input fields");
        clearButton.addActionListener(new ClearButtonListener());
        gbc.gridx = 1; // Column 1
        panel.add(clearButton, gbc);
        
        
        
    }

    // Action Listener for Submit Button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve input data
            String equipmentName = equipmentNameField.getText();
            String eventName = eventNameField.getText();
            String quantity = quantityField.getText();

            // Here you would typically call a method to save this data to the database
            outputArea.append("Equipment: " + equipmentName + " \nEvent: " + eventName + " \nQuantity: " + quantity + "\n");

            // Clear input fields after submission
            equipmentNameField.setText("");
            eventNameField.setText("");
            quantityField.setText("");
        }
    }
    
    // Action Listener for Clear Button
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all input fields
            equipmentNameField.setText("");
            eventNameField.setText("");
            quantityField.setText("");

            // Clear the output area
            outputArea.setText("");

            // Update the status label
            statusLabel.setText("Input fields cleared.");
        }
    }
    
    public static void main(String[] args) {
    	//This launches the Event Schedule System
        SwingUtilities.invokeLater(EventScheduleSystem::new); //Ensures safe GUI creation and manipulation
    }

}
