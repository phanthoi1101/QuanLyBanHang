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
	<%Loai loai = (Loai)session.getAttribute("loaiDelete");%>
    <div class="container mt-4">
    <div class="mt-4 mb-4 text-center"><h3>Xoá Loại</h3></div>
    <form action="xoaSuaAdminController" method="get">
		  <div class="mb-3 mt-3">
                <label class="form-label">Mã Loại</label>
                <p class="form-control"><%=loai.getMaLoai() %></p>
           </div>
			<div class="mb-3 mt-3">
                <label class="form-label">Tên Loại</label>
                <p class="form-control"><%=loai.getTenLoai() %></p>
            </div>
            <div class="form-group text-right">
                <button  type="submit" name="LuuDeleteLoai" class="btn btn-primary">
                    <i class="fa fa-floppy-o"></i>
                    Lưu dữ liệu
                </button>
                <a href="PagenationLoaiAdminController" class="btn btn-default">
                    Quay lại
                </a>
            </div>
	</form>
    </div>
</body>
</html>