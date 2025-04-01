package Gui;

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
    private List<String> scheduledEvents = new ArrayList<>(); // Stores events temporarily

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
        frame.setLocationRelativeTo(null); // Centers the window
    }

    private void initializeComponents(GridBagConstraints gbc) {
        // Equipment Name Input
        gbc.gridx = 0; 
        gbc.gridy = 1;
        panel.add(new JLabel("Equipment:"), gbc);

        equipmentNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(equipmentNameField, gbc);

        // Event Name Input
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Event:"), gbc);

        eventNameField = new JTextField(20);
        eventNameField.setToolTipText("Enter the name of the event");
        gbc.gridx = 1;
        panel.add(eventNameField, gbc);

        // Quantity Input
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Quantity:"), gbc);

        quantityField = new JTextField(20);
        quantityField.setToolTipText("Enter the quantity of equipment");
        gbc.gridx = 1;
        panel.add(quantityField, gbc);

        // Status Label
        statusLabel = new JLabel("Fill out the details and submit.");
        statusLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(statusLabel, gbc);

        // Output Area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(255, 255, 255));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(outputArea), gbc);
        gbc.gridwidth = 1;

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setToolTipText("Submit the event details");
        submitButton.addActionListener(new SubmitButtonListener());
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(submitButton, gbc);

        // Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setToolTipText("Clear all input fields");
        clearButton.addActionListener(new ClearButtonListener());
        gbc.gridx = 1;
        panel.add(clearButton, gbc);
    }

    // Action Listener for Submit Button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String equipmentName = equipmentNameField.getText().trim();
            String eventName = eventNameField.getText().trim();
            String quantity = quantityField.getText().trim();

            // Input validation
            if (equipmentName.isEmpty() || eventName.isEmpty() || quantity.isEmpty()) {
                statusLabel.setText("All fields are required!");
                statusLabel.setForeground(Color.RED);
                return;
            }

            try {
                int qty = Integer.parseInt(quantity);
                if (qty <= 0) throw new NumberFormatException();

                // Check if event already exists (Basic double-booking prevention)
                String eventDetails = eventName + " - " + equipmentName + " (" + qty + ")";
                if (scheduledEvents.contains(eventDetails)) {
                    statusLabel.setText("This event is already scheduled!");
                    statusLabel.setForeground(Color.RED);
                    return;
                }

                scheduledEvents.add(eventDetails); // Store the event
                outputArea.append(eventDetails + "\n");
                statusLabel.setText("Event Scheduled Successfully!");
                statusLabel.setForeground(Color.GREEN);

                // Clear fields after successful submission
                equipmentNameField.setText("");
                eventNameField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                statusLabel.setText("Quantity must be a valid number!");
                statusLabel.setForeground(Color.RED);
            }
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
            outputArea.setText("");

            // Update the status label
            statusLabel.setText("Input fields cleared.");
            statusLabel.setForeground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventScheduleSystem::new);
    }
}
