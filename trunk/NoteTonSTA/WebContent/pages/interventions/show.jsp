<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Note Ton STA | ${ requestScope.intervention.subject }</title>

<script type="text/javascript"
	src="${ requestScope[ 'javax.servlet.forward.context_path' ]}/assets/js/delete.js"></script>
<script type="text/javascript"
	src="${ requestScope[ 'javax.servlet.forward.context_path' ]}/assets/js/evaluate.js"></script>
<script type="text/javascript">
	$(function() {
		$("a[rel=twipsy]").twipsy({
			live : true
		})
	})
</script>
</head>
<body>
	<div id="dialog-confirm" title="Delete intervention?">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"></span>These intervention
			will be permanently deleted and cannot be recovered. Are you sure?
		</p>
	</div>
	
	<div class="row">
		<div class="span4">
			<a href="${requestScope.back_url }">Back</a>
		</div>
		<div class="right span8 offset4">
			<c:if
				test="${ sessionScope.loggedIn == true and requestScope.intervention.speaker.id == sessionScope.user_id }">
				<a id="edit" class="btn"
					href="${requestScope['javax.servlet.forward.context_path'] }/interventions/edit/${requestScope.intervention.id}">Edit</a>
				<a id="delete" class="btn"
					href="${requestScope['javax.servlet.forward.context_path'] }/interventions/delete/${requestScope.intervention.id}">Delete</a>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class="center span16">
			<strong>${ requestScope.intervention.subject }</strong>
		</div>
	</div>
	<div class="row">
		<div class="center span-one-third">
			<strong>Campus: </strong>${ requestScope.intervention.campus.name }
		</div>
		<div class="center span-one-third">
			<strong>From <a href="#" data-placement="below" rel='twipsy' title='Date format: (MM/DD/YYYY)'>(?)</a>: </strong>${
			requestScope.intervention.startDate }
		</div>
		<div class="center span-one-third">
			<strong>To <a href="#" data-placement="below" rel='twipsy' title='Date format: (MM/DD/YYYY)'>(?)</a>: </strong>${
			requestScope.intervention.endDate }
		</div>
	</div>
	<div class="row">
		<div class="span16">${ requestScope.intervention.description }</div>
	</div>
	<div class="row">
		<div class="span16">Presented by ${
			requestScope.intervention.speaker.firstname } ${
			requestScope.intervention.speaker.lastname }</div>
	</div>
	<div class="row">
		<div class="span-16">
			<ul>
				<li><strong>Number of mark: </strong>${requestScope.intervention.marks.size()
					}</li>
				<li><strong>Speaker mark: </strong>${requestScope.marks_avg[0]
					} / 5</li>
				<li><strong>Slides mark: </strong>${requestScope.marks_avg[1] }
					/ 5</li>
				<li><strong>Global event mark: </strong>${requestScope.marks_avg[2]}
					/ 5</li>
			</ul>
		</div>
	</div>
	<c:choose>
		<c:when test="${requestScope.intervention.marks.size() gt 0}">
			<div class="row">
				<div class="center clearfix span16">
					<img
						src="${requestScope['javax.servlet.forward.context_path'] }/charts?id=${requestScope.intervention.id}" />
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="center clearfix span16">
					<em><strong>Not enough mark to display the chart</strong></em>
				</div>
			</div>
		</c:otherwise>
	</c:choose>


	<!-- 
	
	
	
	Evaluation Form
	
	
	
	 -->

	<a id="evaluate" href="#">Evaluate</a>
	<div id="modal" class="modal hide fade span6">
		<div class="modal-header">
			<a href="#" class="close">×</a>
		</div>
		<div class="modal-body">
			<form id="evaluate_form" class="clearfix"
				action="${requestScope['javax.servlet.forward.context_path'] }/interventions/evaluate"
				method="post">
				<input type="hidden" name="action" value="evaluate" /> <input
					type="hidden" name="intervention_id"
					value="${requestScope.intervention.id }" />
				<div class="clearfix center">
					<label for="idbooster">ID Bosster:</label>
					<div class="input">
						<input type="text" name="idbooster" />
					</div>
				</div>
				<table class="bordered-table">
					<caption>
						<h2>About the Speaker<
					</caption>
					<thead>
						<tr>
							<th></th>
							<th>1</th>
							<th>2</th>
							<th>3</th>
							<th>4</th>
							<th>5</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>His knowledge of the subject:</td>
							<td><input type="radio" name="q1" value="1" /></td>
							<td><input type="radio" name="q1" value="2" /></td>
							<td><input type="radio" name="q1" value="3" /></td>
							<td><input type="radio" name="q1" value="4" /></td>
							<td><input type="radio" name="q1" value="5" /></td>
						</tr>
						<tr>
							<td>His knowledge teaching abilities:</td>
							<td><input type="radio" name="q2" value="1" /></td>
							<td><input type="radio" name="q2" value="2" /></td>
							<td><input type="radio" name="q2" value="3" /></td>
							<td><input type="radio" name="q2" value="4" /></td>
							<td><input type="radio" name="q2" value="5" /></td>
						</tr>
						<tr>
							<td>The quality of answers:</td>
							<td><input type="radio" name="q3" value="1" /></td>
							<td><input type="radio" name="q3" value="2" /></td>
							<td><input type="radio" name="q3" value="3" /></td>
							<td><input type="radio" name="q3" value="4" /></td>
							<td><input type="radio" name="q3" value="5" /></td>
						</tr>
					</tbody>
				</table>
				<table class="bordered-table">
					<caption>
						<h2>About the Slides</h2>
					</caption>
					<thead>
						<tr>
							<th></th>
							<th>1</th>
							<th>2</th>
							<th>3</th>
							<th>4</th>
							<th>5</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>The richness of the content :</td>
							<td><input type="radio" name="q4" value="1" /></td>
							<td><input type="radio" name="q4" value="2" /></td>
							<td><input type="radio" name="q4" value="3" /></td>
							<td><input type="radio" name="q4" value="4" /></td>
							<td><input type="radio" name="q4" value="5" /></td>
						</tr>
						<tr>
							<td>The format / layout:</td>
							<td><input type="radio" name="q5" value="1" /></td>
							<td><input type="radio" name="q5" value="2" /></td>
							<td><input type="radio" name="q5" value="3" /></td>
							<td><input type="radio" name="q5" value="4" /></td>
							<td><input type="radio" name="q5" value="5" /></td>
						</tr>
						<tr>
							<td>The examples:</td>
							<td><input type="radio" name="q6" value="1" /></td>
							<td><input type="radio" name="q6" value="2" /></td>
							<td><input type="radio" name="q6" value="3" /></td>
							<td><input type="radio" name="q6" value="4" /></td>
							<td><input type="radio" name="q6" value="5" /></td>
						</tr>
					</tbody>
				</table>
				<div class="clearfix center">
					<label for="coment">Coment:</label>
					<div class="input">
						<textarea name="coment" rows="4">
					</textarea>
					</div>
				</div>
				<div class="actions">
					<input type="submit" class="btn primary" value="Mark">&nbsp;
				</div>
			</form>
		</div>
	</div>
</body>
</html>