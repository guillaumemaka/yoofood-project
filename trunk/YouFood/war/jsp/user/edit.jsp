<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>	
<head>
<title>YouFood | Create User</title>
<script type="text/javascript">
	$(function(){
		
		$("#user_creation").validate({
			validClass:"success",
			errorClass:"error",
			highlight: function(element, errorClass, validClass) {
			     $(element).addClass(errorClass).removeClass(validClass);
			     $(element.form).find("label[for=" + element.name + "]")
			     				.parent("div")
			     				.removeClass(validClass)
			                    .addClass(errorClass);
			  },
			  unhighlight: function(element, errorClass, validClass) {
			     $(element).removeClass(errorClass).addClass(validClass);
			     $(element.form).find("label[for=" + element.name + "]")
			     				.parent("div")
			                    .removeClass(errorClass)
			                    .addClass(validClass);
			  },
			errorPlacement: function(error, element) {
				error.addClass("help-inline");
				error.appendTo(element.parent("div"));
			},
			errorElement:"span",
			messages: { 
	            firstname: "Enter your firstname", 
	            lastname: "Enter your lastname", 	             
	            password: { 
	                required: "Provide a password" 	                 
	            }, 
	            password_confirm: { 
	                required: "Repeat your password", 	              
	                equalTo: "Enter the same password as above" 
	            }, 
	            username: { 
	                required: "Please enter a valid email address", 	                 	           
	            } 
	        },
			rules : { 
		            firstname: "required", 
		            lastname: "required", 		             
		            password: { 
		                required: true,  
		            }, 
		            password_confirm: { 
		                required: true,		                
		                equalTo: "#password" 
		            }, 
		            username: { 
		                required: true		                 		              
		            } 
		        }
		});
		
	});
</script>
</head>
<body>
	<h1>Edit User</h1>
	<form id="user_creation" class="clearfix" action="${ pageContext.request.contextPath }/user/update" method="post">
		<input type="hidden" name="id" value="${ requestScope.user.id }" />
		<div class="control-group">
			<div class="control-label">
				<label for="firstname">Firstname</label>
				<div class="controls">
					<input type="text" name="firstname" value="" />
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="control-label">
				<label for="lastname">Lastname</label>
				<div class="controls">
					<input type="text" name="lastname" value="" />
				</div>
			</div>
		</div>
		<div class="control-group">
			<div class="control-label">
				<label for="username">Username</label>
				<div class="controls">
					<input type="text" name="username" value="" />
				</div>
			</div>
		</div>
		<div class="actions">
            <input type="submit" class="btn primary" value="Save">&nbsp;<button type="reset" class="btn">Cancel</button>
        </div>
	</form>
</body>
</html>