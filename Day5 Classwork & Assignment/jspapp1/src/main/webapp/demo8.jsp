<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header Footer</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td style="text-align: center">
				<jsp:include page="header.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="400px">
			Main content
			</td>
		</tr>
		<tr>
			<td style="text-align: center">
				<jsp:include page="footer.jsp"/>
			</td>
		</tr>
	</table>
</body>
</html>