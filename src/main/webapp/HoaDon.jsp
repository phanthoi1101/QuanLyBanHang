<%@page import="ShowHoaDonModal.ShowHoaDon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Hoá Đơn</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<%ArrayList<ShowHoaDon> ds = (ArrayList<ShowHoaDon>)session.getAttribute("dsShowHd"); 
	int n = ds.size();
%>
	<%@ include file="Layouts/navBar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-center">
				<h3>Danh Sách Hoá Đơn</h3>
				<hr>
	
		<table class="table table-bordered">
		    <thead>
		      <tr>
		        <th>Mã hoá đơn</th>
		        <th>Họ tên</th>
		        <th>Tổng số lượng</th>
		        <th>Thành tiền</th>
		        <th>Ngày mua</th>
		      </tr>
		    </thead>
		     	<%for(int i = 0 ; i < n ; i++){%>		     		
			     	<tr>
			     	<form action="LichSuController" method="get">
				        <td><%=ds.get(i).getMaHoaDon() %></td>
				        <td><%=ds.get(i).getHoTen() %></td>
				        <td><%=ds.get(i).getTongSoLuong() %></td>
				        <td><%=ds.get(i).getThanhTien() %></td>
				        <td><%=ds.get(i).getNgayMua() %></td>
			</form>	
			      </tr>
		     		<%} %>
		  </table>

			</div>	
		<div class="col-sm-2"></div>		
		</div>
	</div>	
</body>
</html>