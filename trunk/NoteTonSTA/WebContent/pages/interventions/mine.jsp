<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Note ton STA | My Interventions</title>
<script type="text/javascript"
	src="${ requestScope[ 'javax.servlet.forward.context_path' ]}/assets/js/delete.js"></script>
</head>
<body>

	<div id="dialog-confirm" title="Delete intervention?">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"></span>These intervention
			will be permanently deleted and cannot be recovered. Are you sure?
		</p>
	</div>

	<h1 class="small">Your interventions</h1>
	<table class="zebra-striped">
		<thead>
			<tr>
				<th>Subject</th>
				<th>Begin</th>
				<th>End</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${ requestScope.intervention.size() == 0 }">
				<tr>
					<td>
						<em><strong>No intervention found</strong></em>
					</td>
				</tr>
			</c:if>
			<c:forEach items="${requestScope.interventions }" var="intervention">
				<tr>
					<td><a
						href="${requestScope['javax.servlet.forward.context_path'] }/interventions/show/${intervention.id }">
							${intervention.subject } </a></td>
					<td>${intervention.startDate }</td>
					<td>${intervention.endDate }</td>
					<td>${intervention.getStatus() }</td>
					<td><a id="delete" class="btn"
						href="${requestScope['javax.servlet.forward.context_path'] }/interventions/delete/${intervention.id}">Delete</a>
						<a id="edit" class="btn"
						href="${requestScope['javax.servlet.forward.context_path'] }/interventions/edit/${intervention.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${ sessionScope.loggedIn == true }">
		<div class="clearfix">
			<a class="btn"
				href="${ requestScope['javax.servlet.forward.context_path'] }/interventions/new">Add
				intervention</a>
		</div>
	</c:if>
</body>
</html>