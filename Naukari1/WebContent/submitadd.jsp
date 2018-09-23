<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/submitadd.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Submit Advertise</title>
</head>
<body class="layout">

	<div class="container">
		<form action="SubmitAdd" method="post" enctype="multipart/form-data">
			<table class="table table-bordered" class="form-control">
				<tr>
					<td>Advertise Title:</td>
					<td><input type="text" class="form-control" required
						name="title" autocomplete="on" maxlength="199"></td>
				</tr>
				<tr>
					<td>About:</td>
					<td>
					<textarea rows="3" cols="50" name="about" class="form-control rounded-0" maxlength="199" value="">
					</textarea>
				    </td>
				</tr>
				<tr>
					<td>Total Posts:</td>
					<td>
					<textarea rows="3" cols="50" name="posts" class="form-control input-lg" maxlength="199" value="">
					</textarea>
					
					</td>
				</tr>
				<tr>
					<td>Pay Scale:</td>
					<td>
					<textarea rows="3" cols="50" name="payscale" class="form-control input-lg" maxlength="199" value="">
					</textarea>				
					</td>
				</tr>
				<tr>
					<td>Education Qualification:</td>
					<td>
					<textarea rows="3" cols="50" name="qualification" class="form-control input-lg" maxlength="199" value="">
					</textarea>
					
				   </td>
				</tr>
				<tr>
					<td>Age Limits:</td>
					<td>
					<textarea rows="3" cols="50" name="agelimit" class="form-control input-lg" maxlength="199" value="">
					</textarea>
					
					</td>
				</tr>
				<tr>
					<td>How To Apply:</td>
					
					<td>
				   <textarea rows="3" cols="50" name="apply" class="form-control input-lg" maxlength="199" value="">
					</textarea>					
					</td>
				</tr>
				<tr>
					<td>Note:</td>
					<td>
					<textarea rows="3" cols="50" name="note" class="form-control input-lg" maxlength="199" value="">
					</textarea>					
					</td>
				</tr>
				<tr>
					<td>Starting date:</td>
					<td>
					
					<input type="date" class="form-control" name="startdate"
						required></td>
				</tr>
				<tr>
					<td>Last Date:</td>
					<td><input type="date" class="form-control" name="enddate">
					</td>
				</tr>
				<tr>
					<td>About Link:</td>
					<td><input type="text" class="form-control" name="aboutlink" maxlength="199" >
					</td>
				</tr>
				<tr>
					<td>Location:</td>
					<td><input type="text" class="form-control" name="location" maxlength="199">
					</td>
				</tr>
				<tr>
					<td>Application Fees:</td>
					<td>
					<textarea rows="3" cols="50" name="applicationfees" class="form-control input-lg" maxlength="199">
					</textarea>					
					</td>
				</tr>
				<tr>
					<td>Authorised Website:</td>
					<td><input type="text" class="form-control"
						name="authorisedwebsite" maxlength="199" >
						</td>
				</tr>
				<tr>
					<td>Selection Process:</td>
					<td>
					<textarea rows="3" cols="50" name="selectionproccess" class="form-control input-lg" maxlength="199">
					</textarea>
					</td>
				</tr>
				<tr>
					<td>PDF Link:</td>
					<td><input type="text" class="form-control" name="pdflink" maxlength="199">
					</td>
				</tr>
				<tr>
					<td>YouTube Link:</td>
					<td><input type="text" class="form-control" name="youtubelink" maxlength="199">
					</td>
				</tr>
				<tr>
					<td>Table Image:</td>
					<td><input type="file" class="form-control" name="image"
						accept="image/*"></td>
				</tr>
				<tr>

					<td colspan="2"><input type="Submit" class="btn btn-lg"
						value="SUBMIT" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
