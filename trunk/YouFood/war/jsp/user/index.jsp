<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>YouFood - User Management</title>
<!-- import stylesheet, scripts, meta information you need -->
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/assets/js/bootstrap-dropdown.js"></script>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#id</th>
				<th>username</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${ requestScope.users.size() > 0 }">
					<c:forEach items="${ requestScope.users }" var="user">
						<tr>
							<td>${ user.id }</td>
							<td>${ user.username }</td>
							<td>${ user.fullname }</td>
							<td>
								<div class="btn-group">
									<a class="btn btn-primary" href="#"><i
										class="icon-user icon-white"></i> User</a> <a
										class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
										href="#"><span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a
											href="${ pageContext.request.contextPath}/user/edit?id=${ requestScope.user.id }"><i
												class="icon-pencil"></i> Edit</a></li>
										<li><a
											href="${ pageContext.request.contextPath}/user/delete?id=${ requestScope.user.id }"><i
												class="icon-trash"></i> Delete</a></li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">No user to display</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<div class="pagination">
		<ul>
			<c:forEach var="i" begin="1"
				end="${ requestScope.paginator.getNbPage() }" step="1"
				varStatus="status">
				<c:if test="${ requestScope.paginator.getPreviousPage() != null }">
					<li><a
						href="${ pageContext.request.contextPath}/user?page=${requestScope.paginator.getPreviousPage()}">Prev</a></li>
				</c:if>
				<c:choose>
					<c:when test="${ requestScope.paginator.getCurrentPage() == i }">
						<li class="active"><a href="#">${ i }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">${ i }</a></li>
					</c:otherwise>
				</c:choose>

				<c:if test="${ requestScope.paginator.getNextPage() != null }">
					<li><a
						href="${ pageContext.request.contextPath}/user?page=${requestScope.paginator.getNextPage()}">Next</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</body>
</html>