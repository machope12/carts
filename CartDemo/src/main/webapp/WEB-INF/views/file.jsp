<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>
			<p class="lead">Check out all the products available</p>
		</div>
		<c:forEach var="product" items="${productList}">
		<div class="card mb-4" style="max-width: 400px;">
  <div class="row no-gutters">
    <div class="col-md-6">
      <img width="200" height="200" src="getStudentPhoto/<c:out value='${product.productId}'/>">
    </div>
    <div class="col-md-6">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
</div>
	</c:forEach>
		

	</div>
</div>


</body>
