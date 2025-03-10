<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
	<form action="DangNhapAdminController">
	  <div class="mb-3 mt-3">
	    <label for="email" class="form-label">Tên đăng nhập:</label>
	    <input type="text" class="form-control" id="email" placeholder="Enter tên đăng nhập" name="txtTenDn">
	  </div>
	  <div class="mb-3">
	    <label for="pwd" class="form-label">Password:</label>
	    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="txtMk">
	  </div>
	  <div class="form-check mb-3">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox" name="remember"> Remember me
	    </label>
	  </div>
	  <%if(request.getAttribute("CheckDn")!=null){ %>
	  <div class="text-center">
	  	    <span class="text-danger"><%=request.getAttribute("CheckDn") %></span></div>
	 <div class="text-center my-4">
	  <%} %>
	  <button type="submit" class="btn btn-primary">Đăng nhập</button></div>
	<%if(session.getAttribute("dem")!=null &&(int)session.getAttribute("dem")>=3){ %>
		<center>
		<img src="simpleCaptcha.jpg" />
		<input type="text" name="answer" /><br>
		<input type="submit" value="Submit"></form>
		</center>
	<%} %>
	</form>
</body>
</html>