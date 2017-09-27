<!DOCTYPE html>
<% String user=(String)request.getSession().getAttribute("user"); %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
	<link href="css/Home.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">				
				<a class="navbar-brand" href="Home.jsp">BLETranaction</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="PersonalProfile">PersonalProfile</a></li>
				<li><a href="TransactionTable">TransactionTable</a></li>
				<li><a href="AccountTable">AccountTable</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-offset-3">
				<div class="BOX">
					<h1>Hello~<%=user%></h1>
					<div align="center">
						<img src="images/bee.png" width="400px">
					</div>	
				</div>
			</div>
		</div>
</div>
</body>
</html>