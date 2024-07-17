package com.airlinemanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton submit, reset, close;
	JTextField enterusername;
	JPasswordField enterpassword;
    
	public Login() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel username=new JLabel("UserName");
		username.setBounds(20,20,100,20);
		add(username);
		
		enterusername=new JTextField();
		enterusername.setBounds(130,20,200,20);
		add(enterusername);
		
		JLabel password=new JLabel("Password");
		password.setBounds(20,60,100,20);
		add(password);
		
		enterpassword=new JPasswordField();
		enterpassword.setBounds(130,60,200,20);
		add(enterpassword);
		
		reset=new JButton("Reset");
		reset.setBounds(40,120,120,20);
		reset.addActionListener(this);
		add(reset);
		
		submit=new JButton("Submit");
		submit.setBounds(190,120,120,20);
		submit.addActionListener(this);
		add(submit);
		
		close=new JButton("Close");
		close.setBounds(120,160,120,20);
		close.addActionListener(this);
		add(close);
		
		setSize(400,250);
		setLocation(600,250);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String username = enterusername.getText();
            String password = enterpassword.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                	new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
		}else if(ae.getSource()==close) {
			setVisible(false);
		}else if(ae.getSource()==reset) {
			enterusername.setText("");
			enterpassword.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
		
	}
}
