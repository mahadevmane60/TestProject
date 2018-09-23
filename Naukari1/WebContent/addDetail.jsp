<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="data.*,model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Details</title>
<style type="text/css">
.container {
	background-color: #fff;
	padding-top: 10px;
	padding-bottom: 10px;
}

.jobDetailsPage {
	float: left;
	width: 100%;
}

.jobLabelInfo {
	font-size: 17px;
	font-weight: bold;
}

.joBDetailsDataDiv {
	float: left;
	width: 100%;
	margin-bottom: 5px;
	margin-top: 5px;
}

.JobLabeltextInfo {
	float: left;
	width: 100%;
	font-size: 15px;
	color: #b39090;
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
<body style="color: #000000; margin-top: 65px; vertical-align: middle;"
	background="images/back.png">
	<%
		Advertise add = (Advertise) request.getAttribute("add");
	%>
	<div id="home">

		<div class="container"
			style="background-color: #fff; padding-top: 10px; padding-bottom: 10px;    padding-bottom: 30px;    margin-bottom: 20px;    padding-top: 40px;">
			<h2>Job Details:</h2>
			<div class="jobDetailsPage">
				<div class="joBDetailsDataDiv">
					<!-- <div class="jobLabelInfo">Title</div> -->
					<div class=jobLabelInfo><%=add.getTitle()%></div>
				</div>
				<div class="joBDetailsDataDiv">
					<%-- <div class="jobLbeldata">About the Job</div>
						<div class="JobLabeltextInfo"><%=add.getAbout()%></div> --%>
					<div class="jobLbeldata">About the Job</div>
					<div class="JobLabeltextInfo">
						<%=add.getAbout()%>
					</div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="halfContent">
						<div class="jobLbeldata">Total Posts:</div>
						<div class="JobLabeltextInfo"><%=add.getPosts()%></div>
					</div>

					<div class="halfContent">
						<div class="jobLbeldata">Pay Scale:</div>
						<div class="JobLabeltextInfo"><%=add.getPayscale()%></div>
					</div>

				</div>
				<div class="joBDetailsDataDiv">
					<div class="halfContent">
						<div class="jobLbeldata">Qualification</div>
						<div class="JobLabeltextInfo"><%=add.getQualification()%></div>
					</div>
					<div class="halfContent">
						<div class="jobLbeldata">Age Limit</div>
						<div class="JobLabeltextInfo"><%=add.getAgelimit()%></div>
					</div>
				</div>

				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">How To Apply:</div>
					<div class="JobLabeltextInfo"><%=add.getApply()%></div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Start Date</div>
					<div class="JobLabeltextInfo"><%=add.getStartDate()%></div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Link for the Job</div>
					<div class="JobLabeltextInfo">
						<a href="<%=add.getAboutlink()%>"><%=add.getAboutlink()%> </a>
					</div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Location</div>
					<div class="JobLabeltextInfo"><%=add.getLocation()%></div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Application Fees Structure</div>
					<div class="JobLabeltextInfo"><%=add.getApplicationfees()%></div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Go To Authorised Website:</div>
					<div class="JobLabeltextInfo">
						<a href=" <%=add.getAuthorisedwebsite()%>"><%=add.getAuthorisedwebsite()%></a>
					</div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Job Selection process</div>
					<div class="JobLabeltextInfo"><%=add.getSelectionproccess()%></div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">PDF Link</div>
					<div class="JobLabeltextInfo">
						<a href="<%=add.getPdflink()%>"><%=add.getPdflink()%> </a>
					</div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">Go on Youtube link:</div>
					<div class="JobLabeltextInfo">
						<a href="<%=add.getYoutubelink()%>"> <%=add.getYoutubelink()%> </a>
					</div>
				</div>
				<div class="joBDetailsDataDiv">
					<div class="jobLbeldata">View Strcture</div>
					<div class="JobLabeltextInfo">
						<img src="addimages/<%=add.getImage()%>"
							style="height: 334px; width: 475px">
					</div>
				</div>

			</div>

		</div>
	</div>

</body>
<jsp:include page="footer.jsp" />
</html>