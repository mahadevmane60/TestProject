<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/contactus.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">	
</script>
<script type="text/javascript" src="js/contactus.js"></script>
<style type="text/css">
input[type=text], input[type=number], select, textarea{
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
    color: black;
}
</style>
</head>

<body >
<div>
<jsp:include page="header2.jsp" />
</div>
	
	
	<div style="background: #544949;
    margin-top: 72px;">
	<div class="container" style="width: 50%;
    background: #80797987">
		<form action="ContactUs" method="get">
<h3 style="    margin-top: 44px;
    color: #fff;">Contact Us:</h3>
			<label for="fname">Your Name:</label> <input type="text" id="fname"
				name="name" placeholder="Your name.." required> <label
				for="phone number">Your Phone Number:</label> <input type="number"
				maxlength="12"
				style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; margin-top: 6px; margin-bottom: 16px; resize: vertical;"
				id="phnumber1" name="phnumber" placeholder="xxxxxxxxxx" required>

			<br> <label for="city">City:</label> 
			<select id="city"
				name="city" style="    color: black;">
				<option value="Select" disabled>Select</option>
				<option value="Sangli">Sangli</option>
				<option value="Solapur">Solapur</option>
				<option value="Pune">Pune</option>
				<option value="Kolhapur">Kolhapur</option>
				<option value="Satara">Satara</option>
			</select> <label for="subject">Subject:</label>
			<textarea id="subject" name="subject" placeholder="Write something.."
				style="height: 200px"></textarea>

			<input type="submit" id="submit" value="Submit"
				onclick="return validation()" style="background-color:#03A9F4;margin-top: 17px;">
		</form>
	</div>
	</div>
	<div>
	<%-- <jsp:include page="footer.jsp" /> --%>
	<div>
</body>
</html>