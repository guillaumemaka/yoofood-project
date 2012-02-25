<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
	
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><decorator:title default="Home" /></title>

<link type="text/css" rel="stylesheet" href="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/css/jquery-ui-1.8.16.custom.css" />
<link type="text/css" rel="stylesheet" href="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/css/bootstrap.css" />
<!-- 
	<link rel="stylesheet" href="http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css">
	  -->
<style type="text/css">
body {
	padding-top: 60px;
}

.row {
	margin-bottom: 30px;
}

.center {
	text-align: center;
}

.right {
	text-align: right;
}
</style>

<script type="text/javascript" src="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/js/bootstrap-modal.js"></script>
<script type="text/javascript" src="${ requestScope[ 'javax.servlet.include.context_path' ]}/assets/js/bootstrap-twipsy.js"></script>

<decorator:head/>
</head>
<body>
	<div class="topbar">
		<div class="fill">
			<div class="container">
				<a class="brand" href="${ requestScope[ 'javax.servlet.include.context_path' ]}/home">Note Ton STA</a>
				<ul class="nav">					
						<c:if test="${ sessionScope.loggedIn == false || sessionScope.loggedIn == null }">
							<li><a href="${ requestScope[ 'javax.servlet.include.context_path' ]}/speakers/register">Register</a></li>
							<li><a href="${ requestScope[ 'javax.servlet.include.context_path' ]}/login">Login</a></li>							
						</c:if> 
						<c:if test="${ sessionScope.loggedIn == true }">
							<li><a href="${ requestScope[ 'javax.servlet.include.context_path' ]}/interventions/mine">My Interventions</a></li>
							<li><a href="${ requestScope[ 'javax.servlet.include.context_path' ]}/interventions/new">New Intervention</a></li>			
							<li>																
								<a href="${ requestScope[ 'javax.servlet.include.context_path' ]}/logout">Logout</a>
							</li>														
						</c:if>
				</ul>				
			</div>
		</div>
	</div>

	<div class="container">
		<c:if test="${ requestScope.error != null }">
			<div class="alert-message error">
  				<a class="close" href="#">x</a>
  				<p>${ requestScope.error }</p>
			</div>
		</c:if>
		<c:if test="${ requestScope.success != null }">
			<div class="alert-message success">
  				<a class="close" href="#">x</a>
  				<p>${ requestScope.success }</p>
			</div>
		</c:if>
			
		<decorator:body />
		<div class="row">
			<footer class="span16 center"><em> Supinfo &copy;2011 - Limited </em></footer>
		</div>
	</div>
</body>
</html>