<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forward</title>
</head>
<body>
	<jsp:forward page="/forwarded.jsp" />
	<%--
	RequestDispatcher rd = application.getRequestDispatcher("/forwarded.jsp");
	rd.forward(request, response);
	--%>
</body>
</html>