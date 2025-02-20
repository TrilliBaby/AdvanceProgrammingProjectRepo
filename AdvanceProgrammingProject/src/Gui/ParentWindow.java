package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ParentWindow extends JFrame{
	private JMenuBar menubar;
	private JMenu login;
	private JMenuItem loginItem;
	private JDesktopPane desktop;
	
	public void InitializeComponents() {
		menubar = new JMenuBar();
		login = new JMenu("Login");
		loginItem = new JMenuItem("new Login");
		desktop = new JDesktopPane();
	}
	
	public void addMenuItemToMenu() {
		login.add(loginItem);
	}
	
	public void addMenuToMenuBar() {
		menubar.add(login);
	}
	
	public void addComponentsToWindow() {
		this.add(desktop);
	}
	
	public void setProperties() {
		this.setJMenuBar(menubar);
		this.setSize(1020, 700);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void registerListeners() {
		loginItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(new LoginView());
			}
			
		});
	}
	
	public ParentWindow() {
		InitializeComponents();
		addMenuItemToMenu();
		addMenuToMenuBar();
		addComponentsToWindow();
		setProperties();
		registerListeners();
	}
	

	public static void main(String[] args) {
		
		new ParentWindow();
	}

}
