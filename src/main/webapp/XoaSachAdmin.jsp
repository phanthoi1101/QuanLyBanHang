<%@page import="SachModal.Sach"%>
<%@page import="LoaiModal.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Sách</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<%@ include file="Layouts/navBarAdmin.jsp" %>
		<!-- Lấy ra 1 sách để hiển thị -->
		<%Sach sach = (Sach)session.getAttribute("sachDelete");%>
    <div class="container mt-4">
    <div class="mt-4 mb-4 text-center"><h3>Bổ sung sách</h3></div>
    <form action="xoaSuaAdminController" method="get">
		    <input type="hidden" class="form-control"  name="masach" value="<%=sach.getMaSach()%>">
		  <div class="mb-3 mt-3">
                <label class="form-label">Mã Loại</label>
                <p class="form-control"><%=sach.getMaLoai() %></p>
           </div>
			<div class="mb-3 mt-3">
                <label class="form-label">Tên Sách</label>
                <p class="form-control"><%=sach.getTenSach() %></p>
            </div>
                        <div class="mb-3 mt-3">
                <label class="form-label">Số lượng</label>
                <p class="form-control"><%=sach.getSoLuong() %></p>
            </div>
                        <div class="mt-3 mb-3">
                <label class="form-label">Giá</label>
                <p class="form-control"><%=sach.getGia() %></p>
            </div>
             <div class="mt-3 mb-3">
                <label class="form-label">Ảnh</label>
                <p class="form-control"><%=sach.getAnh()%></p>
            </div>
 			<div class="mt-3 mb-3">
                <label class="form-label">Tác Giả</label>
                <p class="form-control"><%=sach.getTacGia() %></p>
            </div>
            <div class="form-group text-right">
                <button  type="submit" name="LuuDeleteSach" class="btn btn-primary">
                    <i class="fa fa-floppy-o"></i>
                    Lưu dữ liệu
                </button>
                <a href="PagenationAdminController" class="btn btn-default">
                    Quay lại
                </a>
            </div>
	</form>
    </div>
</body>
</html>