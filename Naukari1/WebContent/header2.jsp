<div >
<head> 
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/font-awesome.css">
	<link rel="stylesheet" href="css/animate.css">
	<link href="css/style.css" rel="stylesheet" />	
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  

  
  
</head>
	<header>
	
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="navigation">
				<div class="container">					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<div class="navbar-brand">
						 <a href="index.jsp"> 
						 <img border="0" alt="online-seva" src="images/online-seva.png" width="100" height="75" style="margin-left: -35px;
    height: 150px;
    margin-top: -50px;">
							 </a>
						</div>
					</div>
					
					<div class="navbar-collapse collapse">							
						<div class="menu">
							<ul class="nav nav-tabs" role="tablist">
							   
								<li role="presentation"><a href="index.jsp#home" class="active">Home</a></li>
								<li role="presentation"><a href="index.jsp#about">About Us</a></li>
								<li role="presentation"><a href="index.jsp#services">Services</a></li>																
								<li role="presentation"><a href="contactus.jsp">Contact</a></li>	
								<%
								 Object obj=session.getAttribute("user");
								 if(obj==null){
									 %>
									 <li role="presentation"><a href="login.jsp">Login</a></li>
								 <%
								 } 
								 else{
								 %>
								 	 
									 <li role="presentation"><a href="logout.jsp">Log Out</a></li>
								 <%
								 }
								%>	
												
							   
							</ul>
						</div>
					</div>						
				</div>
			</div>	
		</nav>			
	</header>
	</div>
	