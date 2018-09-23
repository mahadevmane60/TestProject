<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Forgot Password </title>
<script>
${msg}
</script>
</head>
<jsp:include page="header2.jsp"/>
<body style="color: #FF0000; margin-top: 85px;">
<div class="container" >
<form action="ForgotPassword">
 Enter Your Email: <br>
 <input type="text" name="email">  <br><br>
 <input type="submit" value="GET PASSWORD"> <br>
  You will get a mail with your password. Please check the password in mail & re-login.
</form>
</div>
</body>

<jsp:include page="footer.jsp" />
</html>