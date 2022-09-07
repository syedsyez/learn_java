package com.java.besant.javatr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent {
	
	public void insertRecordToDB(int studentId,String 
			userName,int age,String phoneNumber,String city) {
		MySQLDBConnection mysqlDB = new MySQLDBConnection();
		String sql = "insert into "
				+ "students(studentId,student_name, age,phone_number,city) "
				+ "values(?,?,?,?,?)";
		Connection connection = mysqlDB.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,studentId);
			pstmt.setString(2,userName);
			pstmt.setInt(3, age);
			pstmt.setString(4, phoneNumber);
			pstmt.setString(5, city);
			boolean execute = pstmt.execute();
			if(execute) {
				System.out.println("Record inserted succesfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}



