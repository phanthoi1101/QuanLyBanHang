<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng xuất</title>
</head>
<body>
	<%
	session.setAttribute("checkDn", null);
	response.sendRedirect("trangChuController");

	%>
</body>
</html>