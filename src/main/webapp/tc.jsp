	<%@page import="Controller.DangNhapController"%>
<%@page import="temp.CgioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SachModal.Sach"%>
<%@page import="SachModal.SachBo"%>
<%@page import="LoaiModal.Loai"%>
<%@page import="LoaiModal.LoaiBo"%>
<%@page import="javax.swing.UIManager.LookAndFeelInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang chủ</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

	<!--  HEADER -->
	<%@ include file="Layouts/navBar.jsp" %>
	<!-- CONTAINER -->
	<div class="container">	
	<!-- Trả sách về 1 session -->
	
	<!--TRẢ VỀ DANH SÁCH CÁC SÁCH KHI TÌM KIẾM -->
	<%
	ArrayList<Sach> listSearch = new ArrayList<Sach>();
	listSearch = (ArrayList<Sach>)session.getAttribute("listSearch");
// HIỂN THỊ TẤT CẢ CÁC CART DANH SÁCH %>
		<div class="row">
			<!--HIỂN THỊ LOẠI SÁCH  -->
			<%@ include file="Layouts/SelectLoaiSach.jsp" %>
			<!-- CHỌN MÃ LOẠI HIỂN THỊ SÁCH -->
			<div class="col-sm-8">
				<h3 class="text-center">Danh sách các Sách</h3>
				<hr>
				<%
				int n = 0;
				if(listSearch!=null)
					n=listSearch.size();
				for (int i = 0; i < n; i++) {
				%>
				<div class="row">
					<div class="col-sm-4">
						<div class="card mb-4" style="height: 500px">
						<img class="card-img-top"src="<%=listSearch.get(i).getAnh()%>">
						<div class="card-body">
						<h5 class="card-title text-center"><%=listSearch.get(i).getTenSach()%></h5>
						<p class="card-text text-center">Giá bán :<%=listSearch.get(i).getGia()%> đồng</p>
						</div>
						<%String action ="datHangController";
						if(session.getAttribute("checkDn")==null || (boolean)session.getAttribute("checkDn")==false){
							action = "DangNhapAdminController";
						}%>
						<form action="<%=action %>" method="get">
						<div class="d-flex justify-content-center pb-4">
							<button type="submit" name="datmua" value="<%=listSearch.get(i).getMaSach()%>">
						<img src="https://minhkhai.com.vn/store/images/buynow.jpg"></button>
						</div>
						</form>
			</div>
					</div>
					<%
					i++;
					if (i < n) {
					%>
					<div class="col-sm-4">
						<div class="card mb-4" style="height: 500px">
						<img class="card-img-top"src="<%=listSearch.get(i).getAnh()%>">
						<div class="card-body">
						<h5 class="card-title text-center"><%=listSearch.get(i).getTenSach()%></h5>
						<p class="card-text text-center">Giá bán :<%=listSearch.get(i).getGia()%> đồng</p>
						</div>
						<form action="<%=action %>" method="get">
						<div class="d-flex justify-content-center pb-4">
							<button type="submit" name="datmua" value="<%=listSearch.get(i).getMaSach()%>">
						<img src="https://minhkhai.com.vn/store/images/buynow.jpg"></button>
						</div>
						</form>
			</div>
					</div>
					<%
					}
					%>
					<%
					i++;
					if (i < n) {
					%>
					<div class="col-sm-4">
						<div class="card mb-4" style="height: 500px">
						<img class="card-img-top"src="<%=listSearch.get(i).getAnh()%>">
						<div class="card-body">
						<h5 class="card-title text-center"><%=listSearch.get(i).getTenSach()%></h5>
						<p class="card-text text-center">Giá bán :<%=listSearch.get(i).getGia()%> đồng</p>
						</div>
						<form action="<%=action %>" method="get">
						<div class="d-flex justify-content-center pb-4">
							<button type="submit" name="datmua" value="<%=listSearch.get(i).getMaSach()%>">
						<img src="https://minhkhai.com.vn/store/images/buynow.jpg"></button>
						</div>
						</form>
			</div>
					</div>
					<%
					}
					%>
				</div>
				<%
				}
				%>
			</div>
			<!-- TÌM KIẾM SÁCH -->
			<%@ include file="Layouts/Search.jsp" %>
		</div>
		<form action="PageinationController" method="get">
			<ul class="pagination pagination-sm justify-content-center">
			<% int numberBook = (int)session.getAttribute("pageCount");
				int pageCount;
				if(numberBook%6==0)
					pageCount=numberBook/6;
				else
					pageCount = numberBook/6+1;
				int page1 = (int)session.getAttribute("page");
				for(int i = 1 ; i <= pageCount ; i ++){
					if(page1==i){%>
						<li class="page-item"><button class="page-link active" name="btnPage" value="<%=i%>"><%=i %></button></li>
					<%}else{%>
						<li class="page-item"><button class="page-link" name="btnPage" value="<%=i%>"><%=i %></button></li>
				<%	}
				%>
				<%}
			%>
			</ul>
		</form>
</div>

	<!--MODAL FORM ĐĂNG NHẬP  -->
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>