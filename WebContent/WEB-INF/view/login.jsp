<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--Required Meta-tags-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="icon" href="../images/logoW.png" sizes="32x32"
	type="image/png">
<title>Fozti Auto-Parts Login</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/salesStyles.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
	
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
	
</head>
<body class="login-body">
	<div class="container-fluid">
		<div class="row justify-content-center ">
			<div class="col-md-4 col-md-offset-4">
				<!-- Login form creation starts-->
				<form class="form-container"
					action="<%=request.getContextPath()%>/login" method="post"
					id="#loginForm">
					<div class="form-header">
						<img src="<%=request.getContextPath()%>/images/logoR.png"
							style="width: 50%" alt="logo">
						<div>&nbsp;</div>
						<div class="font-weight-bold" style="color: #B0B3B8;">
							<h4>Hello! let's get started</h4>
							<p>Sign in to continue.</p>
						</div>
					</div>
					<div>&nbsp;</div>
					<div class="form-group">
						<label for="InputEmail1">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							aria-describeby="emailHelp" placeholder="Email">
						<p id="alert-u" style="color: red"></p>


					</div>
					<div class="form-group">
						<label for="InputPassword1">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" placeholder="Password">
						<p id="alert-p" style="color: red"></p>
					</div>
					<div>&nbsp;</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-block">SIGN
							IN</button>
					</div>
					<div>&nbsp;</div>
					<div class="form-footer">
						<p>
							Don't have an account? <a href="#">SIGN UP</a>
						</p>
				</form>
				<!-- Login form creation ends -->
			</div>
		</div>
	</div>

	<script src="../js/jquery-1.12.4.js"></script>
	<script src="../js/loginValidation.js"></script>
</body>
</html>