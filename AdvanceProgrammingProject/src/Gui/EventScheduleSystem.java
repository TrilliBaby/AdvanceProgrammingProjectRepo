package Gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EventScheduleSystem {
    
	 private JFrame frame;
	    private JPanel panel;
	    private JTextField eventNameField, dateField, timeField, addressField, durationField, statusField;
	    private JTextArea outputArea;

	    public EventScheduleSystem() {
	        frame = new JFrame("Event Scheduling System");
	        panel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        panel.setBackground(new Color(240, 248, 255));

	        initializeComponents(gbc);

	        frame.add(panel);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	    }

	    private void initializeComponents(GridBagConstraints gbc) {
	        gbc.gridx = 0; gbc.gridy = 0;
	        panel.add(new JLabel("Event Name:"), gbc);
	        eventNameField = new JTextField(20);
	        gbc.gridx = 1;
	        panel.add(eventNameField, gbc);

	        gbc.gridx = 0; gbc.gridy = 1;
	        panel.add(new JLabel("Date (YYYY-MM-DD):"), gbc);
	        dateField = new JTextField(20);
	        gbc.gridx = 1;
	        panel.add(dateField, gbc);

	        gbc.gridx = 0; gbc.gridy = 2;
	        panel.add(new JLabel("Time (HH:MM:SS):"), gbc);
	        timeField = new JTextField(20);
	        gbc.gridx = 1;
	        panel.add(timeField, gbc);

	        gbc.gridx = 0; gbc.gridy = 3;
	        panel.add(new JLabel("Address:"), gbc);
	        addressField = new JTextField(20);
	        gbc.gridx = 1;
	        panel.add(addressField, gbc);

	        gbc.gridx = 0; gbc.gridy = 4;
	        panel.add(new JLabel("Duration (in hours):"), gbc);
	        durationField = new JTextField(20);
	        gbc.gridx = 1;
	        panel.add(durationField, gbc);

	        gbc.gridx = 0; gbc.gridy = 5;
	        panel.add(new JLabel("Status:"), gbc);
	        statusField = new JTextField(20);
	        gbc.gridx = 1;
	        panel.add(statusField, gbc);

	        outputArea = new JTextArea(10, 30);
	        outputArea.setEditable(false);
	        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
	        panel.add(new JScrollPane(outputArea), gbc);
	        gbc.gridwidth = 1;

	        JButton submitButton = new JButton("Schedule Event");
	        submitButton.addActionListener(new SubmitButtonListener());
	        gbc.gridx = 0; gbc.gridy = 7;
	        panel.add(submitButton, gbc);

	        JButton clearButton = new JButton("Clear");
	        clearButton.addActionListener(e -> {
	            eventNameField.setText("");
	            dateField.setText("");
	            timeField.setText("");
	            addressField.setText("");
	            durationField.setText("");
	            statusField.setText("");
	            outputArea.setText("");
	        });
	        gbc.gridx = 1;
	        panel.add(clearButton, gbc);
	    }

	    private class SubmitButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String eventName = eventNameField.getText().trim();
	            String date = dateField.getText().trim();
	            String time = timeField.getText().trim();
	            String address = addressField.getText().trim();
	            String duration = durationField.getText().trim();
	            String status = statusField.getText().trim();

	            if (eventName.isEmpty() || date.isEmpty() || time.isEmpty() ||
	                address.isEmpty() || duration.isEmpty() || status.isEmpty()) {
	                outputArea.setText("⚠️ Please fill in all fields.");
	                return;
	            }

	            // Simulate saving event
	            StringBuilder summary = new StringBuilder();
	            summary.append("✅ Event Scheduled Successfully!\n\n")
	                   .append("Event Name: ").append(eventName).append("\n")
	                   .append("Date: ").append(date).append("\n")
	                   .append("Time: ").append(time).append("\n")
	                   .append("Address: ").append(address).append("\n")
	                   .append("Duration: ").append(duration).append(" hours\n")
	                   .append("Status: ").append(status);

	            outputArea.setText(summary.toString());
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(EventScheduleSystem::new);
	    }

    
}
