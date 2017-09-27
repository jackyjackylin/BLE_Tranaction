<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/Login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-offset-3">
				<div class="BOX">
					<form action="login.do" method="post" class="window">
						<p>
							<label for="exampleInputEmail1"><b>E-mail</b></label> <input
								type="text" name="user" class="form-control" placeholder="Email">
						</p>
						<p>
							<label for="exampleInputPassword1"><b>Password</b></label> <input
								type="Password" name="password" class="form-control"
								placeholder="Password">
						</p>
						<p align="center">
							<button type="submit" class="btn btn-success btn-block">Login</button>
							<a href="Register.jsp" class="btn btn-primary btn-block">Register</a>
						</p>
					</form>
				</div>
				<div align="center" >
					<img src="images/bee.png" width="400px">
				</div>							
			</div>
		</div>
	</div>
</body>
</html>