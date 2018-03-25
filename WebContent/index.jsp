<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- adaptation -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- css resources addr added here -->
	<link rel="stylesheet" href="css/bootstrap.css" type="text/css" >
	<!-- js resources addr added here -->
	<script type="text/javascript" src="js/jquery.js"></script>
	
	<title>User Login Page</title>
	<!-- Click 'reset' to clear the contents of 'username' and 'pwd'-->
	<script>
		$(document).ready(function(){
			$("#reset").click(function(){
				$("#username").val("");
				$("#pwd").val("");
			});
		});
	</script>
</head>
<body>
	<div class="row text-center" style="padding-top:30px; padding-bottom:30px; background-color: #CCC; margin-top:200px;">
		<form action="LoginServlet" method="post">
			<div class="col-md-6 col-md-offset-3">
				<div>
					<label>username:</label> 
					<input type="text" id="username" name="username" />
				</div>
				<div>
					<label class="img-circle">password:</label> 
					
					<input class="input" id="pwd" name="pwd" type="password" />
				</div>
				<div style="margin:10px 0px;">
					<input class="btn btn-primary" type="submit" value="Login" /> 
					<input class="btn btn-group" id="reset" type="button" value="Reset" />
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="js/jquery.js"></script>
</body>
</html>