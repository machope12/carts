<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>
			<p class="lead">Check out all the products available</p>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
				
					<td>Product Image</td>
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Age</td>
					
				</tr>
			</thead>
			<c:forEach var="product" items="${productList}">
				<tr>
					<c:url value="/delete" var="myURL">
						<c:param name="productId" value="${product.productId}" />
					</c:url>
					
					<c:url value="/editForm" var="myURL1">
						<c:param name="productId" value="${product.productId}" />
					</c:url>
					
					<td><img width="75" height="75" src="getStudentPhoto/<c:out value='${product.productId}'/>"></td>				
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productAge}</td>
					
					<td><a href="${myURL}"><i class="fa fa-times"></i></a>
					<a href="${myURL1}"><i class="fa fa-pencil"></i></a>
					
					</td>	
			</tr>
			</c:forEach>
			
		</table>
		<a class="btn btn-primary" role="button" href="<c:url value = "/productForm"/>">Add Product</a>
	</div>
</div>


</body>
</html>