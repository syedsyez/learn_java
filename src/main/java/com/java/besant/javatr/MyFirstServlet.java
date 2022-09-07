package com.java.besant.javatr;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyFirstServlet
 */

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This line will not get printed on browser");
		response.setContentType("text/html");
		String user = request.getParameter("userName");
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();
		ServletContext sc = request.getServletContext();
		if(user!=null) {
			session.setAttribute("userName", user);
			sc.setAttribute("userName", user);
		}
		writer.print("<br>username sent in the request Param"+user);
		String userFromSession;
		//if(session.getAttribute("userName")=!=null) {
		//	 userFromSession = (String)session.getAttribute("userName");
		//}else {
	//		userFromSession = null;
	//	}
		 userFromSession = session.
				getAttribute("userName")!=null?
						(String)session.getAttribute("userName"):null;
		System.out.println("user from session "+userFromSession);
		writer.print("<br>user from session "+userFromSession);
		writer.print("<br>user from context "+
				sc.getAttribute("userName"));
		
		
	}
	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { PrintWriter out =
	 * response.getWriter(); String user = request.getParameter("userName"); String
	 * password = request.getParameter("password"); out.println(" UserName :"+user
	 * +" password:"+password);
	 * 
	 * 
	 * }
	 */
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("******Servlet is getting initialize****");
		super.init(config);
	}
}
