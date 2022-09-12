<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.java.besant.javatr.dto.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
 Student Enrolled for this courses.
 <% List<Student> studentList = (List<Student>)request.getAttribute("students"); 
   
 %>
 No of Students<%=studentList.size()%>
</body>
</html>