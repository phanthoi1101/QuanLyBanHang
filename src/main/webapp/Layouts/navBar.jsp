<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="trangChuController">Trang chủ</a>
			</div>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <%String actions = "LichSuController";
	if(session.getAttribute("checkDn")==null || (boolean)session.getAttribute("checkDn")==false){
		actions = "DangNhapAdminController";
	}%>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">	
					<li class="nav-item"><a class="nav-link" href="HoaDonController">Các hoá đơn</a></li>
					<li class="nav-item"><a class="nav-link" href="datHangController"><span
							class="glyphicon glyphicon-log-in"></span>Giỏ hàng <i class="fas fa-shopping-cart"></i></a></li>
				</ul>
				<ul class="navbar-nav ms-auto">
				<li class="nav-item" type="button" d><a class="nav-link" href="DangKyController"><span
							class="glyphicon glyphicon-user"></span>Đăng ki</a></li>
					<%
					boolean checkDn;
					if(session.getAttribute("checkDn")==null){
						checkDn=false;
					}
					else{
						checkDn =(boolean) session.getAttribute("checkDn");
					}
					String tendn = (String)session.getAttribute("tendn");
					if (checkDn && tendn!=null) {
					%>
					<li class="nav-item"><a class="nav-link" href=""><span class="glyphicon glyphicon-user"></span>
							xin chao <%=tendn%></a></li>
					<%

					} else {
					%>
					<li class="nav-item" type="button"><a class="nav-link" href="DangNhapAdminController"><span
							class="glyphicon glyphicon-user"></span>Đăng nhập</a></li>
					<%
					}
					%>
					<li class="nav-item"><a class="nav-link" href="logoutController"><span
							class="glyphicon glyphicon-log-in"></span>Đăng xuất</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	
