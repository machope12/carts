<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

	
	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">			
				<h1>All Products</h1>	
				<p class= "lead"> Check out all the products available</p>	
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr class = "bg-success">
						<td>Photo Thumb</td>
						<td>Product Name</td>
						<td>Category</td>
						<td>Condition</td>
						<td>Price</td>
						<td></td>						
					</tr>			
				</thead>
				<tr>
					<c:forEach var="product" items="${productList}">  
						<c:url value="/viewProduct" var="myURL">
						<c:param name="producId" value="${product.productId}"/>						
						</c:url>
						<td> <img src="#" alt="image"> </td>
						<td>${product.productName}</td>
						<td>${product.productCategory}</td>
						<td>${product.productCondition}</td>
						<td>${product.productPrice}</td>					
						<td><a href="${myURL}"><i class="fa fa-car"></i></a></td>
					</c:forEach>  
				</tr>				
			</table>
			
		</div>
	</div>
	
	
</body>
</html>