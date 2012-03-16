<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>YouFood | Login</title>
<script type="text/javascript">
	$(function() {

		$("#login")
				.validate(
						{
							validClass : "success",
							errorClass : "error",
							highlight : function(element, errorClass,
									validClass) {
								$(element).addClass(errorClass).removeClass(
										validClass);
								$(element.form).find(
										"label[for=" + element.name + "]")
										.parent("div").parent("div").addClass(errorClass)
										.removeClass(validClass);
							},
							unhighlight : function(element, errorClass,
									validClass) {
								$(element).removeClass(errorClass).addClass(
										validClass);
								$(element.form).find(
										"label[for=" + element.name + "]")
										.parent("div").parent("div").removeClass(errorClass)
										.addClass(validClass);
							},
							errorPlacement : function(error, element) {
								error.addClass("help-inline");
								error.appendTo(element.parent("div"));
							},
							errorClass : "error",
							errorElement : "span",
							messages : {
								username : {
									required : "Please enter your username",
								},
								password : {
									required : "Please Provide a password"
								}
							},
							rules : {
								username : {
									required : true
								},
								password : {
									required : true,
								}
							}
						});
	});
</script>
</head>
<body>
	
	<div class="hero-unit row span6">
		<h1>Restricted Area</h1>
		<p>This application required a user authentication, please fill the login form bellow</p>
		<div class="span6" >
			<form id="login" method="post" 
				action="${ pageContext.request.contextPath }/login">
				<div class="control-group">
					<div class="control-label">
						<label for="username">Username:</label>
						<div class="controls">
							<input class="span6" type="text" name="username" value="" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">
						<label for="password">Password:</label>
						<div class="controls">
							<input class="span6" type="password" name="password" value="" />
						</div>
					</div>
				</div>
				<div class="form-actions">
					<input type="submit" class="btn btn-primary" value="Login">&nbsp;
					<button type="reset" class="btn">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>