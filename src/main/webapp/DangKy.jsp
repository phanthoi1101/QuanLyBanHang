<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<!-- MODAL DĂNG KÍ -->	
<div  class="text-center my-4" >
<h3>Form Đăng Ký</h3>
</div>
<form class="container border py-4 border-info" action="DangKyController" method="get">
	<div class="mb-3">
	    <label for="pwd" class="form-label">Họ tên:</label>
	    <input type="text" class="form-control" placeholder="Enter họ tên" name="dangKyHoTen">
	 </div>
	 <div class="mb-3">
	    <label for="pwd" class="form-label">Địa chỉ:</label>
	    <input type="text" class="form-control" id="pwd" placeholder="Enter địa chỉ" name="dangKyDiaChi">
	  </div>
	  <div class="mb-3">
	    <label for="pwd" class="form-label">Số điện thoại:</label>
	    <input type="text" class="form-control" id="pwd" placeholder="Enter số điện thoại" name="dangKySdt">
	  </div>
	  <div class="mb-3">
	    <label for="pwd" class="form-label">Email:</label>
	    <input type="text" class="form-control" id="pwd" placeholder="Enter email" name="dangKyEmail">
	  </div>
	  <div class="mb-3">
	    <label for="pwd" class="form-label">Tên đăng nhập:</label>
	    <input type="text" class="form-control" id="pwd" placeholder="Enter tên đăng nhập" name="dangKyTenDn">
	    <%if(request.getAttribute("checkTendn")!=null){ %>
	    <span class="color-danger"><%=request.getAttribute("checkTendn") %></span>
	    <%} %>
	  </div>
	  <div class="mb-3">
	    <label for="pwd" class="form-label">Password:</label>
	    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="dangKyPass">
	    <%if(request.getAttribute("checkMk")!=null){ %>
	    <span class="color-danger"><%=request.getAttribute("checkMk") %></span>
	    <%}%>
	  </div>	
	  <div class="text-center">
	    <button type="submit" class="btn btn-primary" name="btnDangKy">Xác nhận</button>
	  </div>	
</form>