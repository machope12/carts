<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<html>
<body>

	<div class="container">
		<div>
			<form:form modelAttribute="productForm"
				action="${pageContext.request.contextPath}/save" method="post">				
					Product Name: <form:input type="text" path="productName" />
				<form:errors path="productName" cssClass="error" />
				<br>
				<br>  
					Product Price: <form:input type="number" path="productPrice" />
				<form:errors path="productPrice" cssClass="error" />
				<br>
				<br>
				<input type="submit" value="submit">
			</form:form>

		</div>
	</div>
</body>
</html>