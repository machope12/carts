<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
	<div class="container">
		<div class="page-header">
			<h3>ProductDetails</h3>
			<p class="lead">Check out all the products available</p>
			<p>${product.productId}</p>
		</div>
		<div class= "container">
			<div class= "row">
				<c:forEach var="product" items="${productList}"> 
										
					<td><img src="${product.productPicture}" alt="image"></td>
					<td>${product.productName}</td>
					<td>${product.productAge}</td>
										
				</c:forEach>
							
				</div>
			</div>		
		</div>
	
</body>
</html>>