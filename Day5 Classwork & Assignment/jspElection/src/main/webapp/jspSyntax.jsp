<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP Syntax Demo</h1>
	<!-- html comment -->
	<%-- jsp comment --%>
	<% 
		Date now = new Date();
		out.println("time: "+ now);
		%>
	
</body>
</html>