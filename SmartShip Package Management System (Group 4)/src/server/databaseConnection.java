package server;

import java.sql.*;

import javax.swing.JOptionPane;

public class databaseConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/SmartShip";
		Connection mainConn = null;
		
		//getting connection
		try {

			mainConn = DriverManager.getConnection(url,"root", "usbw");
			if(mainConn != null) {//if connection was made to the usdweb server

		JOptionPane.showMessageDialog(null,"Connected to local server", "JDBC Connection status", JOptionPane.INFORMATION_MESSAGE);

			}


		}catch (Exception e) {

		e.printStackTrace();

		}

	}

}
