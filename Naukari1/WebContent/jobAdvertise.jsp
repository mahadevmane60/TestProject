<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="data.*,model.*,java.util.*"%>
<!DOCTYPE html>

<html html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-MR" xml:lang="en-MR">
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/animate.css" />
<link href="css/style.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="en-MR" />
<title>Job Advertise</title>
</head>
<jsp:include page="header2.jsp" />
<body style="vertical-align: middle;" background="images/back.png">

	<h1>${msg}</h1>
	<%
		List<Advertise> adds = (List<Advertise>) request.getAttribute("adds");
	%>

	<div class="container" style="background-color: #fff;">
		<h2>Jobs:</h2>
		<p>Click on add title for more details</p>


		<%
			for (Advertise ad : adds) {
		%>

		<div class="addDataParent"
			style="border-bottom: solid 2px #FF9800; padding-bottom: 15px; padding-top: 15px;">
			<div class="addTitle"
				style="font-size: 24px; font-weight: bold; padding-bottom: 5px;">
				<a href="AddDetail?addid=<%=ad.getAddId()%>"> <%=ad.getTitle()%>
				</a>
			</div>
			<div class="addInfo"
				style="color: #9c8e8e; font-size: 15px; font-weight: bold;">

				About:
				<%=ad.getAbout()%>
			</div>

		</div>
		<%
			}
		%>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
