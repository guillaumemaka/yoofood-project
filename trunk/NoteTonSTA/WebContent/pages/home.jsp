<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<title>Note Ton STA | Home</title>

<script type="text/javascript">

	$(function(){
		$("#campus_select").change(function(){
			window.location.href = "${ requestScope['javax.servlet.forward.context_path'] }/interventions/list/campus/" + $(this).val();			
		});
	});

</script>

</head>
<body>
		<h1>Welcome to Note Ton STA</h1>
	
		<p class="clearfix">
			This website propose you to evalutate intervention of SUPINFO
			Speakers.<br /> You can also see statistics by speakers or campus
		</p>		
		<p class="clearfix">	
			<form class="clearfix">
				<div class="clearfix">
					<label class="span4" for='campus'>Please select your campus: </label>
					<div class="input">
						<select id="campus_select" class="large" name="campus">
							<option>-- CAMPUS --</option>
							<c:forEach items="${ requestScope.campus }" var="camp">
								<option value="${ camp.id }">${ camp.name }</option>
							</c:forEach>
						</select>
					</div>		
				</div>	
			</form>	
		</p>
	
		<p class="clearfix">
			If you are speaker and have already an account, please <a href="${ requestScope['javax.servlet.forward.context_path'] }/login">authenticate
			you</a> to manage your interventions.<br /> If you doesn't have en
			account, please <a href="${ requestScope['javax.servlet.forward.context_path'] }/speakers/register">register you </a> !
		</p>
</body>