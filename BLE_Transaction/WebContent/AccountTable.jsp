<!DOCTYPE html>
<%@page language="java" import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
<link href="css/TransactionTable.css" rel="stylesheet" type="text/css" />
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
				<li><a href="Login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-xs-10 col-md-offset-1">
				<div class="BOX">
					<div align="center">
						<a href="Deposit.jsp" class="btn btn-primary">Deposit</a>
						<table class="table table-bordered">
							<caption>AccountTable</caption>
							<tbody>
								<tr>
									<th><b>User_ID</b></th>
									<th><b>Amount</b></th>
									<th><b>Deposit_time</b></th>
								</tr>
								<%Iterator<String> itr;%>
								<%
									@SuppressWarnings("unchecked")
									List<String> data =(List<String>)request.getAttribute("data");
									for (itr = data.iterator(); itr.hasNext();) {
								%>
								<tr>
									<td><%=itr.next()%></td>
									<td><%=itr.next()%></td>
									<td><%=itr.next()%></td>															
								</tr>
								<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>