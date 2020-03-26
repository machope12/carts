<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<body>

	<div class="container">
		<form action="<c:url value="/insert"/>">
			<div class="form-group">
				<label>Product Name:</label> <input type="text" class="form-control"
					placeholder="Enter Product Name" name="productName">
			</div>
			<div class="form-group">
				<label>Product Category:</label> <input type="text"
					class="form-control" placeholder="Enter Product Category"
					name="productCategory">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


		<h1>File Upload Example - JavaTpoint</h1>

		
		<form:form method="post" action="savefile"
			enctype="multipart/form-data">
			<p>
				<label for="image">Choose Image</label>
			</p>
			<p>
				<input name="file" id="fileToUpload" type="file" />
			</p>
			<p>
				<input type="submit" value="Upload">
			</p>
		</form:form>


	</div>
</body>
</html>
