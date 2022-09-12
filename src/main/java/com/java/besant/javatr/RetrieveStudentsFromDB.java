package com.java.besant.javatr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.besant.javatr.dto.Student;

public class RetrieveStudentsFromDB {
	
	public List<Student> getStudentDetails(){
		String query="select * from students";
		List<Student> studentList = new ArrayList<>();
		MySQLDBConnection mysqlDB = new MySQLDBConnection();
		Connection connection = mysqlDB.getConnection();
		 PreparedStatement prepareStatement = null;
		
		try {
		 prepareStatement = connection.prepareStatement(query);
	    ResultSet result = prepareStatement.executeQuery();
		if(result != null) {
			while(result.next()) {
				Student s = new Student();
				int id = result.getInt("studentId");
				s.setStudentId(id);
				String name = result.getString("student_name");
				s.setStudentName(name);;
				int age = result.getInt("age");
				s.setAge(age);
				String phone_number = result.getString("phone_number");
				s.setPhoneNumber(phone_number);
				String city = result.getString("city");
				s.setCity(city);
				System.out.println("Student Id "+id +"  Student Name "+name 
						+"age "+age+"  phone number "+phone_number
						+" city "+city
						);
				studentList.add(s);
				
			}
		}
		prepareStatement.close();
		
	} catch (SQLException e) {
		System.out.println("Exception in making connection to db");
		e.printStackTrace();
	}finally {
		if(connection != null) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("exception in closing connection");
		}
		}
	}
		return studentList;
 }
	
	
}


