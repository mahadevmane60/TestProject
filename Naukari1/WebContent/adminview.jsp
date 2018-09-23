<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*, model.User" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
function update(email1){
	$.post( "useraccess", { 
		
		email: email1,
		
	})
	  .done(function( data ) {
	    alert( data );
	  });
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
	<%
		List<User> users = (List<User>) request.getAttribute("users");
	%>
	<br>
	<a href="submitadd.jsp"> add new job </a>
     <br><br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Email</th>
				<th scope="col">Name</th>
				<th scope="col">Password</th>
				<th scope="col">DOB</th>
				<th scope="col">Ph. Number</th>
				<th scope="col">Address</th>
				<th scope="col">City</th>
				<th scope="col">State</th>
				
				<th scope="col">Status</th>
			
			</tr>
		</thead>
		<tbody>
			<%
			    String status = "Inactive";
				if (users != null)
					for (User user : users) {
						status = "Inactive";
						if(user.getStatus().trim().equals("1")){
							status = "Active";
						}
			%>
			<tr>

				<td><%=user.getEmail()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getPass()%></td>
				<td><%=user.getDob()%></td>
				<td><%=user.getPhno()%></td>
				<td><%=user.getAddress()%></td>
				<td><%=user.getCity()%></td>
				<td><%=user.getState()%></td>
				<td>
				  <%=status%>
				  <input type="button" value="Change" onClick="update('<%=user.getEmail().trim()%>')">
				</td>

			</tr>
		</tbody>
		<%
			}
			else {
				out.println("No users data found.");
			}
		%>
	</table>

</body>
</html>