<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h3>ProductDetails</h3>
		<p class="lead">Check out all the products available</p>
		<p>${product.productId}</p>
	</div>
	<div class="container">
		<c:forEach var="product" items="${productList}">
			<div class="row">
				<c:url value="/cart" var="myURL">
					<c:param name="productId" value="${product.productId}" />
				</c:url>
				<div class="col-md-6">
					<img width="400" height="400"
						src="getStudentPhoto/<c:out value='${product.productId}'/>">
				</div>
				<div class="col-md-6">
					<h3>${product.productName}</h3>
					<h3>${product.productAge}</h3>					
					<a href="${myURL}" class="btn btn-info" role="button">Add to Cart</a>
				</div>
			</div>
		</c:forEach>

	</div>

</div>


</body>
</html>

