<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<html>
<body>
<h2>How to insert image in database using Spring MVC</h2>

<form action="<c:url value = "/save"/>" method="post" enctype="multipart/form-data">

<pre>		
	Name: <input type="text" name="name">				
	Age: <input type="number" name="age">				
	Photo: <input type="file" name="photo">				
	<input type="submit" value="Submit">
</pre>
</form>
</body>
</html>