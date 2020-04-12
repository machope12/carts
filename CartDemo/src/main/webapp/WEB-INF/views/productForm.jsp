<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<html>
<body>
	<h2>How to insert image in database using Spring MVC</h2>
	<div class="container">
		<form action="<c:url value = "/save"/>" method="post"
			enctype="multipart/form-data">

			<pre>		
	Name: <input type="text" name="name">				
	Age: <input type="number" name="age">				
	Photo: <input type="file" name="photo">				
	<input type="submit" value="Submit">
</pre>
		</form>

		<form action="/action_page.php">
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pwd">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>