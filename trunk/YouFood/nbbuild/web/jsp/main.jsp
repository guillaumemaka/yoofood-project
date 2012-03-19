<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><decorator:title default="YouFood" /></title>

<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath}/assets/css/jquery-ui-1.8.16.custom.css" />
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath}/assets/css/bootstrap.css" />
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath}/assets/css/bootstrap-responsive.css" />
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

<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/bootstrap-transition.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/bootstrap-modal.js"></script>
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/bootstrap-twipsy.js"></script>

<decorator:head />
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="${ pageContext.request.contextPath}/home">YouFood</a>
				<ul class="nav">
					<c:if test="${ sessionScope.loggedIn == true }">
						<li><a href="${ pageContext.request.contextPath}/user"> <i
								class="icon-user icon-white"></i> User Management
						</a></li>
						<li><a href="${ pageContext.request.contextPath}/menu">Menu
								Management</a></li>
						<li><a href="${ pageContext.request.contextPath}/stats">Marketing</a></li>
						<li><a href="${ pageContext.request.contextPath}/logout">
								<i class="icon-lock icon-white"></i> Logout
						</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<c:if test="${ requestScope.error != null }">
			<div class="alert alert-error">
				<a class="close" href="#">x</a>
				<p>${ requestScope.error }</p>
			</div>
		</c:if>
		<c:if test="${ requestScope.success != null }">
			<div class="alert alert-success">
				<a class="close" href="#">x</a>
				<p>${ requestScope.success }</p>
			</div>
		</c:if>

		<decorator:body />


		<div class="row span12">
			<hr />
			<footer>
				<em> YouFood &copy;2011 - Limited </em>
			</footer>
		</div>

	</div>
</body>
</html>