<!DOCTYPE html>
<%@page language="java" import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String id=(String)request.getAttribute("id"); %>
<% String username=(String)request.getAttribute("username"); %>
<% String useremail=(String)request.getAttribute("useremail"); %>
<% String identity=(String)request.getAttribute("identity"); %>
<% String usercardnum=(String)request.getAttribute("usercardnum"); %>
<% String createtime=(String)request.getAttribute("createtime"); %>
<% String accountamount=(String)request.getAttribute("accountamount"); %>
<html>
<head>
<meta charset="UTF-8">
<title>PersonalProfile</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
<link href="css/PersonalProfile.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">BLETranaction</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="PersonalProfile">Personal Profile</a></li>
				<li><a href="TransactionTable">TransactionTable</a></li>
				<li><a href="AccountTable">AccountTable</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Login.jsp"><span
				class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-xs-8 col-md-offset-2">
				<div class="BOX">
					<div align="center">			
						<table class="table table-condensed">
							<caption>PersonalProfile</caption>
							<tbody>
								<tr>
									<td>Id</td>
									<td><%=id%></td>
								</tr>
								<tr>
									<td>Name</td>
									<td><%=username%></td>
								</tr>
								<tr>
									<td>E-mail</td>
									<td><%=useremail%></td>
								</tr>
								<tr>
									<td>Identity</td>
									<td><%=identity%></td>
								</tr>
								<tr>
									<td>Identity Card Number</td>
									<td><%=usercardnum%></td>
								</tr>
								<tr>
									<td>Account_Amount</td>
									<td><%=accountamount%></td>
								</tr>
								<tr>
									<td>CreateTime</td>
									<td><%=createtime%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>