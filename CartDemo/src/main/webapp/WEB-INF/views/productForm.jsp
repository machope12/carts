<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap 4 Height Sizing of Form Controls</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
    .bs-example{
        margin: 20px;        
    }
</style>
</head>
<body>
<div class="bs-example">
    <form action="<%=request.getContextPath() %>/insert" method= POST >  
        <div class="form-group row">
            <label class="col-sm-2 col-form-label col-form-label-lg">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control form-control-lg" placeholder="Large input">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" placeholder="Default input">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control form-control-sm" placeholder="Small input">
            </div>
        </div>
        <hr>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label col-form-label-lg">State</label>
            <div class="col-sm-10">
                <select class="form-control form-control-lg">
                    <option>Large select</option>
                </select>
            </div>
        </div>    
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">State</label>
            <div class="col-sm-10">
                <select class="form-control">
                    <option>Default select</option>
                </select>
            </div>
        </div>    
        <div class="form-group row">
            <label class="col-sm-2 col-form-label col-form-label-sm">State</label>
            <div class="col-sm-10">
                <select class="form-control form-control-sm">
                    <option>Small select</option>
                </select>
            </div>
        </div>
    </form>
</div>
</body>
</html>                            