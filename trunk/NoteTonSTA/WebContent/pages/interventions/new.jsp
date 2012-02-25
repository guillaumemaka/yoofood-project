<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Edit Intervention</title>
<script type="text/javascript" src="${ requestScope[ 'javax.servlet.forward.context_path' ]}/assets/js/intervention_form_validation.js"></script>
<script type="text/javascript">
	$(function(){
		$("textarea").empty();
	});
</script>
</head>
<body>
	<h1>New Intervention</h1>
	<form id="new_intervention" class="clearfix" action="${ requestScope['javax.servlet.forward.context_path'] }/interventions/update" method="post">
		<input type="hidden" name="action" value="new"/>
		<div class="clearfix">
			<label for="subject">Subject:</label>
			<div class="input">
				<input type="text" name="subject" value="" />
			</div>
		</div>
		<div class="clearfix">
			<label for="campus_id">Campus:</label>
			<div class="input">
				<select name="campus_id">
					<option value="">-- SELECT A CAMPUS --</option>
					<c:forEach items="${ requestScope.campus }" var="c">			
						<option value="${ c.id }">${ c.name }</option>						
					</c:forEach>
				</select>
			</div> 
		</div>
		<div class="clearfix">
			<label for="from">From:</label>
			<div class="input">
				<input id="from" type="text" name="from" value="" />
			</div> 
		</div>
		<div class="clearfix">
			<label for="to">To:</label>
			<div class="input">
				<input id="to" type="text" name="to" value="" />
			</div> 
		</div>
		<div class="clearfix">
			<label for="description">Description:</label>
			<div class="input">
              <textarea id="description" class="xxlarge"  name="description" rows="7">
              </textarea>
				<span class="help-block">
					Write a description about the intervention
				</span>
            </div> 
		</div>
		<div class="actions">
            <input type="submit" class="btn primary" value="Create intervention">&nbsp;<a href="${ requestScope['javax.servlet.forward.context_path'] }/interventions/mine" class="btn">Cancel</a>
        </div>
	</form>
</body>
</html>