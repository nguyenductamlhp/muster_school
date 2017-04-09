package com.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginOptionPane extends JOptionPane{
	
	int option = 0;
	JTextField username = new JTextField();
	JTextField password = new JPasswordField();
	
	public LoginOptionPane() {
		
		Object[] message = {
		    "Username:", username,
		    "Password:", password
		};

		option = JOptionPane.showConfirmDialog(null, message, "Đăng nhập", JOptionPane.OK_CANCEL_OPTION);
		
	}
	
	public boolean isSuccess() {
		boolean isSuccess = false;
		if (option == JOptionPane.OK_OPTION) {
		    if (username.getText().equals("h") && password.getText().equals("h")) {
		        System.out.println("Login successful");
		        isSuccess = true;
		    } else {
		        System.out.println("login failed");
		    }
		} else {
		    System.out.println("Login canceled");
		}
		return isSuccess;
	}
}
