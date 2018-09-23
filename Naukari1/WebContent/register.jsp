<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="css/register.css">
<script type="text/javascript" src="js/register.js"></script>
<style type="text/css">
.registerationpage {
	float: left;
	width: 100%;
	margin-top: 47px;
	background: #230e0e;
	height: 100vh;
}
input[type=text], input[type=password], input[type=date]{
margin:0px !important;
}

.registersub {
	    margin-left: 25%;
    float: left;
    width: 50%;
    background: #d8d5d526;
    /* height: 500px; */
    padding: 10px;
    padding-bottom: 34px;
    border-bottom-left-radius: 7px;
    border-bottom-right-radius: 7px;
}

.userLabel {
	color: #fff;
	font-size: 16px;
	margin-bottom: 10px;
}

.userinfoData {
	float: left;
	width: 50%;
}

.userLabelTextox input::placeholder, .userLabelTextox select::placeholder
	{
	color: #fff;
}

.userLabelTextox input {
	width: 91%;
	height: 36px;
	border-radius: 5px;
	border: none;
	background-color: #523b3b3b;
	border: solid 1px #fff;
	color: #fff;
	padding-left: 10px;
}

.userLabelTextox select {
	width: 91%;
	height: 40px;
	border-radius: 5px;
	border: none;
	background-color: #523b3b3b;
	border: solid 1px #fff;
	color: #fff;
	padding-left: 10px;
	color: #fff;
	padding: 0px;
	line-height: 0;
	height: 36px;
}

.setMargin {
	margin-top: 15px;
}
</style>
<script>
	$
	{
		msg
	}
</script>
</head>
<jsp:include page="header2.jsp" />
<body style="color: #000000; margin-top: 65px">

	<div class="registerationpage">
		<div class="registersub">
			<div
				style="font-size: 24px; text-align: center; padding: 15px; color: #fff; font-weight: bold;">
				Sign Up</div>
			<form name="signupform" id="signupform" action="Register"
				onsubmit="return validateUserForm()" method="post"
				style="padding: 20px;padding-top: 0px;">
				<div class="userinfoData">
					<div class="userLabel">Name:</div>
					<div class="userLabelTextox">
						<input type="text" name="username" placeholder=" user name"
							required />
					</div>
				</div>
				<div class="userinfoData">
					<div class="userLabel">Email:</div>
					<div class="userLabelTextox">
						<input type="text" placeholder=" user email" name="email" required />
					</div>
				</div>

				<div class="userinfoData setMargin">
					<div class="userLabel">Password:</div>
					<div class="userLabelTextox">
						<input type="password" placeholder=" password" name="userpass" required />
					</div>
				</div>

				<div class="userinfoData setMargin">
					<div class="userLabel">Confirm password</div>
					<div class="userLabelTextox">
						<input type="password" placeholder=" retype password" name="confirmpass" required />
					</div>
				</div>

				<div class="userinfoData setMargin">
					<div class="userLabel">Date of Birth</div>
					<div class="userLabelTextox">
						<input type="date" placeholder=" date of birth" name="dob"
							required />
					</div>
				</div>
				<div class="userinfoData setMargin">
					<div class="userLabel">Phone Number</div>
					<div class="userLabelTextox">
						<input type="number" placeholder="phone number" name="phno"
							required />
					</div>
				</div>

				<div class="userinfoData setMargin">
					<div class="userLabel">Address:</div>
					<div class="userLabelTextox">
						<input type="text" placeholder=" Address" name="address" />
					</div>
				</div>
				
				<div class="userinfoData setMargin">
					<div class="userLabel">State</div>
					<div class="userLabelTextox">
						<select name="state" id="locationstate" required>
							<option value="" selected>Select State</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Kerala">Kerala</option>
							<option value="Goa">Goa</option>
						</select>
					</div>
				</div>
				
				<div class="userinfoData setMargin">
					<div class="userLabel">City</div>
					<div class="userLabelTextox">
						<select name="city" id="location" required> 
							<option value="">Select City</option>
							<option  value="Pune">Pune</option>
							<option  value="Chennai">Chennai</option>
							<option value="Bhubaneshwar">Bhubaneshwar</option>
							<option value="Kochi">Kochi</option>
							<option value="Bangalore">Bangalore</option>
						</select>
					</div>
				</div>

				<button type="submit" value="Register"
					style="height: 39px; width: 29%;
	/* margin-left: 25%; */ MARGIN-TOP: 20PX; COLOR: #FFF; BACKGROUND: #3F51B5;
	/* BORDER: SOLID 1PX #FFF; */ border-radius: 5px; padding-top: 7px; float: right; margin-right: 27px;    margin-top: 40px;"
					id="submitData">Register</button>
			</form>
		</div>

	</div>
    <br><br><br>


	<br>
	<br>
	<br>
	<%-- <jsp:include page="footer.jsp" /> --%>
</body>
</html>
