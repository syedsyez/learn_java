package com.java.besant.javatr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLDBConnection {
	
	public Connection getConnection() {
		Connection con =null;
		String url="jdbc:mysql://localhost:3306/besantdb";
		String userName="root";
		String password="testuser123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
		
		
	}
	

