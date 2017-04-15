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
	
	
	public JTextField getUsername() {
		return username;
	}


	public void setUsername(JTextField username) {
		this.username = username;
	}


	public JTextField getPassword() {
		return password;
	}


	public void setPassword(JTextField password) {
		this.password = password;
	}

}
