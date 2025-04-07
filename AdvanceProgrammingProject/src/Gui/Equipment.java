/*
Group Members: Brianna Mowatt, Oconnor Burton, Chadrick Atkinson, Gabrielle Flash & Robert Dowe
Date: April 6, 2025
Project: Java Entertainment
*/

package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import javax.swing.JScrollPane;

public class Equipment extends JInternalFrame{

	private static final long serialVersionUID = 1L;


	/**
	 * Create the frame.
	 */
	public Equipment() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 955);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 95, 1236, 733);
		desktopPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBounds(42, 264, 45, 13);
		panel_2_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Add to Cart");
		btnNewButton_1_1.setBounds(234, 260, 85, 21);
		panel_2_1.add(btnNewButton_1_1);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBackground(new Color(221, 221, 255));
		panel_3_1_1_1.setBounds(31, 35, 288, 185);
		panel_2_1.add(panel_3_1_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBounds(42, 264, 45, 13);
		panel_2_1_1.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add to Cart");
		btnNewButton_1_1_1.setBounds(234, 260, 85, 21);
		panel_2_1_1.add(btnNewButton_1_1_1);
		
		JPanel panel_3_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1.setBackground(new Color(221, 221, 255));
		panel_3_1_1_1_1.setBounds(31, 35, 288, 185);
		panel_2_1_1.add(panel_3_1_1_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(42, 264, 45, 13);
		panel_2_2.add(lblNewLabel_1_2);
		
		JButton btnNewButton_1_2 = new JButton("Add to Cart");
		btnNewButton_1_2.setBounds(234, 260, 85, 21);
		panel_2_2.add(btnNewButton_1_2);
		
		JPanel panel_3_1_1_2 = new JPanel();
		panel_3_1_1_2.setBackground(new Color(221, 221, 255));
		panel_3_1_1_2.setBounds(31, 35, 288, 185);
		panel_2_2.add(panel_3_1_1_2);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("New label");
		lblNewLabel_1_1_2.setBounds(42, 264, 45, 13);
		panel_2_1_2.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton_1_1_2 = new JButton("Add to Cart");
		btnNewButton_1_1_2.setBounds(234, 260, 85, 21);
		panel_2_1_2.add(btnNewButton_1_1_2);
		
		JPanel panel_3_1_1_1_2 = new JPanel();
		panel_3_1_1_1_2.setBackground(new Color(221, 221, 255));
		panel_3_1_1_1_2.setBounds(31, 35, 288, 185);
		panel_2_1_2.add(panel_3_1_1_1_2);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1.setBounds(42, 264, 45, 13);
		panel_2_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Add to Cart");
		btnNewButton_1_1_1_1.setBounds(234, 260, 85, 21);
		panel_2_1_1_1.add(btnNewButton_1_1_1_1);
		
		JPanel panel_3_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1.setBackground(new Color(221, 221, 255));
		panel_3_1_1_1_1_1.setBounds(31, 35, 288, 185);
		panel_2_1_1_1.add(panel_3_1_1_1_1_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2_1_2, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)))
					.addGap(36))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2_1_2, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(42, 264, 45, 13);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Add to Cart");
		btnNewButton_1.setBounds(234, 260, 85, 21);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(221, 221, 255));
		panel_3_1_1.setBounds(31, 35, 288, 185);
		panel_2.add(panel_3_1_1);
		panel_1.setLayout(gl_panel_1);
	}
}
