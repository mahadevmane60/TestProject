<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*, model.User" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
	<%
		List<User> users = (List<User>) request.getAttribute("users");
	%>
	<a href=""> add new job </a>

	<table>
		<tr>
			<th>Email</th>
			<th>Name</th>
			<th>Password</th>
			<th>DOB</th>
			<th>Ph. Number</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Status</th>
		</tr>
		<%
			for (User user : users) {
		%>
		<tr>

			<td><%=user.getEmail()%></td>
			<td><%=user.getName() %></td>
			<td><%=user.getPass() %></td>
			<td><%=user.getDob() %></td>
			<td><%=user.getPhno() %></td>
			<td><%=user.getAddress() %></td>
			<td><%=user.getCity() %></td>
			<td><%=user.getState() %></td>
			<td><%=user.getStatus() %></td>

		</tr>
		<%
			}
		%>
	</table>

</body>
</html>