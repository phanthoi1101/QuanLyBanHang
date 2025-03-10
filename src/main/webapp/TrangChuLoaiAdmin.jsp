<%@page import="LoaiModal.Loai"%>
<%@page import="SachModal.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<%@ include file="Layouts/navBarAdmin.jsp" %>
		
	
	<!-- Hiển thị danh sách sách -->
	<%ArrayList<Loai> dsLoai = (ArrayList<Loai>)session.getAttribute("dsLoai"); %>
		<div class="container pt-4">
	<div class="pb-4">
   <form id="frmSearchInput" action="TrangChuLoaiAdminController" method="get">
   <input type="hidden" name="" value="" />
   <div class="input-group">
        <input type="text" class="form-control" placeholder="Nhập loại tìm kiếm" name="SearchValue" value="" autofocus />
       <div class="input-group-btn" >
           <button class="btn btn-info" name="btnSearchValue" type="submit">
               <i class="fa fa-search"></i>
           </button>
           <a href="XoaSuaLoaiAdminController" class="btn btn-primary" style="margin-left:5px;">
              Thêm Loai
           </a>
       </div>
   </div>
</form>
	</div>
		<%if(dsLoai == null){ %>
			<h3>Loại trống</h3>
		<%}else{ %>
		
    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr class="text-black">
                    <th>Mã Loai</th>
                    <th>Tên Loai</th>
                    <th style="width: 90px"></th>
                </tr>
            </thead>
            <tbody>
           
                    <%for(Loai loai : dsLoai){ %>
                    <tr>
                    
                        <td><%=loai.getMaLoai() %></td>
                        <td><%=loai.getTenLoai() %></td>
                        <td class="text-right">
                         <form action="XoaSuaLoaiAdminController" method="get">
                        <input type="hidden" name="maloai" value="<%=loai.getMaLoai()%>">
                        <button class="btn btn-sm btn-info" name="btnEdit"><i class="fa fa-edit"></i></button>
                        <button class="btn btn-sm btn-danger" name="btnDelete"><i class="fa fa-trash"></i></button>  
                        </form>                            
                        </td>
                    </tr>
                    <%} %>

            </tbody>
        </table>
    </div>

		<%} %>
		<form action="PagenationAdminController" method="get">
			<ul class="pagination pagination-sm justify-content-center">
			<% int numberBook = (int)session.getAttribute("pageCount");
				int pageCount;
				if(numberBook%20==0)
					pageCount=numberBook/20;
				else
					pageCount = numberBook/20+1;
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
</body>
</html>