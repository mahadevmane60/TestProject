<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Login </title>
<link rel="stylesheet" href="css/login.css">
 <script type="text/javascript" src="js/login.js" >
 </script>
  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
  <script> 
	  ${msg}	 
  </script>
</head>
<body>
<jsp:include page="header2.jsp" />
<div style="    float: left;
    width: 100%;
    margin-top: 79PX;
    background-color: #130505d4;
    height: ca;
    height: calc(100vh - 79px);
    ">


  <div class="login-card" style="width:450px;padding-top:15px;">
  
    <h1 style="    font-weight: 100;
    text-align: center;
    font-size: 2.3em;
    padding-top: 0px;
    margin-top: 0px;
    margin-bottom: 0px;color: #FFF;">Log-in</h1><br>
   
  <form onsubmit="return validateform()" name="loginform" action="Login" method="post">
  
    <input type="text" name="username" placeholder="Username" class="input-type" required style="color: #fff !importat;">
    <input type="password" name="userpass" placeholder="Password" class="input-type" required style="color: #fff !importat;">
    <input type="submit" name="login" class="login login-submit" value="login" class="submit" style="color: #fff !importat;">
  </form>

  <div class="login-help">
    <a href="Register" style="float: left;
    font-size: 16px;color: #fff !important;">Register</a>  <a href="forgotpassword.jsp" style="float: right;
    font-size: 16px;color: #fff !important;">Forgot Password ?</a>
  </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

</div>


</body>
</html>