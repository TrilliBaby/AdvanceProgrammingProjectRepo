package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Equipment extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipment frame = new Equipment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Equipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 955);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(97, 93, 1114, 723);
		desktopPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 70, 1086, 354);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 245, 45, 13);
		panel_2_2.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.setBounds(211, 241, 85, 21);
		panel_2_2.add(btnNewButton);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 245, 45, 13);
		panel_2_2_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Add to Cart");
		btnNewButton_2.setBounds(211, 241, 85, 21);
		panel_2_2_1.add(btnNewButton_2);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBackground(new Color(221, 221, 255));
		panel_3_1_2.setBounds(26, 25, 270, 175);
		panel_2_2_1.add(panel_3_1_2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2_2_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2_2_1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
								.addComponent(panel_2_2, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
							.addGap(49))))
		);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(221, 221, 255));
		panel_3_1.setBounds(26, 25, 270, 175);
		panel_2_2.add(panel_3_1);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 245, 45, 13);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Add to Cart");
		btnNewButton_1.setBounds(211, 241, 85, 21);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(121, 202, 45, 13);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(221, 221, 255));
		panel_3_1_1.setBounds(50, 24, 270, 175);
		panel_2.add(panel_3_1_1);
		panel_1.setLayout(gl_panel_1);
	}

}
