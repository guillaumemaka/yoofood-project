<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><decorator:title default="Home" /></title>
			   
	<link type="text/css" rel="stylesheet" href="/NoteTonSTA/assets/css/bootstrap.css" />
	
	<!-- 
	<link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css">
	  -->
	<style type="text/css">
	body {
		padding-top: 60px;
	}
	</style>
	<script src="/NoteTonSTA/assets/js/bootstrap-twispy.js"></script>
	<script src="/NoteTonSTA/assets/js/bootstrap-popover.js"></script>
</head>
<body>
	<div class="topbar">
		<div class="fill">
			<div class="container">
				<a class="brand" href="/NoteTonSTA">Note Ton STA</a>
				<ul class="nav">					
					<li><a href="/NoteTonSTA/register">Register</a></li>
					<li>
						<%
							if ((Boolean)request.getSession().getAttribute("loggedIn") == null) {
						%> <a href="/NoteTonSTA/login">Login</a> 
						<%
 							} else {
 								%> <a href="/NoteTonSTA/logout">Logout</a> <%
 							}
 							%>
					</li>
				</ul>
			</div>
		</div>
	</div>	