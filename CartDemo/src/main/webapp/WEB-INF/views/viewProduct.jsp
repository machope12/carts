<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>


	<div class="container">
		<div class="page-header">
			<h3>ProductDetails</h3>
			<p class="lead">Check out all the products available</p>
			<p>${productId}</p>
		</div>
		<div class= "container">
			<div class= "row">
				<div class= "col-md-5">
					<img src="#" alt="image" style="width:100% height:300px"/>				
				</div>
				<div class= "col-md-5" style = "font-size:15px">
					<h5>${product.productName}</h5>
					<p>${product.productDescription}</p>
					<p>Manufacturer
						<strong> ${product.productManufactor}</strong>					
					</p>
					<p>Category
					<strong> ${product.productCategory}</strong>						
					</p>
					<p>Condition
						<strong> ${product.productCondition}</strong>						
					</p>
					<p>Price
						<strong> ${product.productPrice}</strong>					
					</p>						
				</div>
			</div>		
		</div>
	</div>

</body>
</html>>