package com.java.besant.javatr;

import java.io.IOException;
import java.util.List;

import com.java.besant.javatr.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveStudentServlet
 */
public class RetriveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 RetrieveStudentsFromDB sdetails = new RetrieveStudentsFromDB();
	 List<Student> studentDetails = sdetails.getStudentDetails();
	 request.setAttribute("students", studentDetails);
	  request.getAttribute(getServletName());
	 
	 RequestDispatcher rd = request.getRequestDispatcher("/viewStudentDetails");
	 rd.forward(request, response);
	 
	}

}
