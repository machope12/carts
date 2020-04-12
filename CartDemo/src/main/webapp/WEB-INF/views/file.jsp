<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<body>

	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>All Products</h1>
				<p class="lead">Check out all the products available</p>
			</div>
			<div class="row">
				<c:forEach var="product" items="${productList}">
					<c:url value="/viewProduct" var="myURL">
						<c:param name="productId" value="${product.productId}" />
					</c:url>

					<div class="column">

						<div class="card border-primary mb-3"
							style="max-width: 15rem; margin-left: 40px;">

							<div class="card-header">
							<a href="${myURL}">	<img width="200" height="200"src="getStudentPhoto/<c:out value='${product.productId}'/>"></a>
							</div>
							<div class="card-body text-primary">
								<h5 class="card-title">Primary card title</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
							</div>
						</div>

					</div>
				</c:forEach>
			</div>

		</div>
	</div>




</body>
