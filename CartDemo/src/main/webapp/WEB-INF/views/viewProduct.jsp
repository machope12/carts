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
				<div class= "col-md-5">
					<img src="#" alt="image" style="width:100% height:300px"/>				
				</div>
				<div class= "col-md-5" style = "font-size:15px">
					<h5>${product.productName}</h5>
					
					<p>Category
					<strong> ${product.productCategory}</strong>						
					</p>
							
				</div>
			</div>		
		</div>
	</div>
</body>
</html>>