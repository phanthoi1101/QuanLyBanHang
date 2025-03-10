<%@page import="java.util.ArrayList"%>
<%@page import="LichSuDatHangModal.LichSuDatHang"%>
<%@page import="HoaDonAndChiTietModal.HoaDonAndChiTiet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<% ArrayList<LichSuDatHang> ds = (ArrayList<LichSuDatHang>)session.getAttribute("dsLsdh"); 
	int n = ds.size();
%>
	<%@ include file="Layouts/navBarAdmin.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 text-center">
				<h3>Lich Su Mua Hang</h3>
				<hr>
	
		<table class="table table-bordered">
		    <thead>
		      <tr>
		        <th>Tên sách</th>
		        <th>Số lượng</th>
		        <th>Giá</th>
		        <th>Ngày mua</th>
		        <th>Thành Tiền</th>
		        <th>Đã mua</th>
		        <th></th>
		        <th></th>
		      </tr>
		    </thead>
		     	<%for(int i = 0 ; i < n ; i++){%>		     		
			     	<tr>
			     	<form action="LichSuController" method="get">
						<input type="hidden" name="mahd" value="<%=ds.get(i).getMaHoaDon()%>">
						<input type="hidden" name="macthd" value="<%=ds.get(i).getMaChiTietHoaDon()%>">
				        <td><%=ds.get(i).getTensach() %></td>
				        <td><input class="form-control-sm" type="number" value="<%=ds.get(i).getSoluong()%>" name="soluong"></td>
				        <td><%=ds.get(i).getGia() %></td>
				        <td><%=ds.get(i).getNgaymua() %></td>
				        <td><%=ds.get(i).getThanhTien() %></td>
				        <td><%=ds.get(i).isDamua() %></td>
				        <%if(!ds.get(i).isDamua()){ %>
				        <td>
				        <button type="submit" class="btn btn-sm btn-primary me-2" name="buttonThanhToan" value="<%=ds.get(i).getMaChiTietHoaDon()%>">
						Thanh Toán</button></td>
				        <%}else{%>
				        <td></td>
				        <%}%>
				        <td>
				        <%if(!ds.get(i).isDamua()){ %>
				        <div class="d-flex justify-content-center">
				        <button type="submit" class="btn btn-sm btn-primary me-2" name="buttonEdit">
							 	<i class="fa fa-edit "></i>
							 	</button>
							 	<button type="submit" class="btn btn-sm btn-danger" name="buttonXoa">
							 	<i class="fa fa-trash"></i>
						</button></div></td>
						<%}else{%>
						<td></td>
				        <%}%>
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