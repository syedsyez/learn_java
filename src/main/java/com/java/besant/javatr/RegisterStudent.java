package com.java.besant.javatr;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterStudent
 */
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		int sId = Integer.parseInt(studentId);
		String studentName = request.getParameter("studentName");
		String age = request.getParameter("age");
		int sAge = Integer.parseInt(age);
		String phoneNumber = request.getParameter("phoneNumber");
		String city = request.getParameter("city");
		AddStudent addstudent = new AddStudent();
		addstudent.insertRecordToDB(sId, studentName, sAge, phoneNumber, city);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Thanks for registering</h1>");
	}
	
	

}
