<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<html>
<body>
	<h2>How to insert image in database using Spring MVC</h2>
	<div class="container">
			<c:forEach var="product" items="${productList}">
		
			</c:forEach>
		<form action="<c:url value = "/editProduct"/>" method="post"
			enctype="multipart/form-data">

			<pre>
			<c:forEach var="product" items="${productList}">
			Name: <input type="text" name="name" value="${product.productName}">				
			Age: <input type="number" name="age" value="${product.productAge}">				
			Photo: <input type="file" name="photo">	
			<input type="hidden" name="id" value="${product.productId}">					
			<input type="submit" value="Submit">			
			</c:forEach>
			</pre>

		</form>

		<form action="<c:url value = "/editProduct"/>" method="post"
			enctype="multipart/form-data">
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