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

					<c:url value="/viewProduct" var="myURL">
						<c:param name="productId" value="${product.productId}" />
					</c:url>
					<td><img width="75" height="75" src="getStudentPhoto/<c:out value='${product.productId}'/>"></td>				
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productAge}</td>
					
					<td><a href="${myURL}"><i class="fa fa-car"></i></a></td>
					<td><a href="${myURL}"><i class="icon-remove"></i></a></td>		
			</tr>
			</c:forEach>
		</table>

	</div>
</div>


</body>
</html>