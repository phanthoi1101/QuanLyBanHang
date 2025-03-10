<%@page import="java.util.ArrayList"%>
<%@page import="LoaiModal.Loai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bổ Sung Sách</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	 <style>
        #preview {
            margin-top: 10px;
            max-width: 200px; /* Kích thước tối đa của ảnh */
            height: auto;
            border: 1px solid #ccc;
            display: none; /* Ẩn trước khi chọn tệp */
        }
    </style>
</head>
<body>
<%@ include file="Layouts/navBarAdmin.jsp" %>
		
    <div class="container mt-4">
    <div class="mt-4 mb-4 text-center"><h3>Bổ sung sách</h3></div>
    <form action="BoSungSachController" method="post" enctype= "multipart/form-data">
		  <div class="mb-3 mt-3">
		    <label for="" class="form-label">Mã Sách</label>
		    <input type="text" class="form-control"  name="masach">
		  </div>
		  <div class="mb-3 mt-3">
                <label class="form-label">Mã Loại</label>
                <select name="maloai" class="form-control">
                <option value="">-- Mã Loại --</option>
                <%ArrayList<Loai> dsloai = (ArrayList<Loai>)session.getAttribute("dsloai");
                for(Loai loai : dsloai){ %>
                	<option value="<%=loai.getMaLoai()%>"><%=loai.getTenLoai() %></option>
                <%} %>
                </select>
           </div>
			<div class="mb-3 mt-3">
                <label class="form-label">Tên Sách</label>
                <input type="text" class="form-control" name="tensach" />
            </div>
                        <div class="mb-3 mt-3">
                <label class="form-label">Số lượng</label>
                <input type="number" class="form-control" name="soluong" />
            </div>
                        <div class="mt-3 mb-3">
                <label class="form-label">Giá</label>
                <input type="number" class="form-control" name="gia" />
            </div>
            <div class="mt-3 mb-3">
                <label class="form-label">Số tập</label>
                <input type="" class="form-control" name="sotap" />
            </div>
             <div class="mt-3 mb-3">
                <label class="form-label">Ảnh</label>
                <input type="file" class="form-control" name="anh" id="file" accept="image/*"/>
                <img id="preview" alt="Preview ảnh">
            </div>
 			<div class="mt-3 mb-3">
                <label class="form-label">Tác Giả</label>
                <input type="text" class="form-control" name="tacgia" />
            </div>
            <%int test = (int)session.getAttribute("checkThemSach");        
            if(test!=1) {%>
            <div><p>Vui lòng nhập đầy đủ thông tin</p></div>
            <%}%>
            <div class="form-group text-right">
                <button  type="submit" name="luuSach" class="btn btn-primary">
                    <i class="fa fa-floppy-o"></i>
                    Lưu dữ liệu
                </button>
                <a href="PagenationAdminController" class="btn btn-default">
                    Quay lại
                </a>
            </div>
	</form>
    </div>
    <script>
        const fileInput = document.getElementById('file');
        const preview = document.getElementById('preview');

        fileInput.addEventListener('change', function () {
            const file = fileInput.files[0]; // Lấy tệp được chọn
            if (file) {
                const reader = new FileReader();

                // Khi đọc tệp xong, hiển thị ảnh
                reader.onload = function (e) {
                    preview.src = e.target.result; // Đường dẫn ảnh
                    preview.style.display = 'block'; // Hiển thị ảnh
                };

                reader.readAsDataURL(file); // Đọc tệp dưới dạng URL
            } else {
                preview.style.display = 'none'; // Ẩn nếu không chọn tệp
            }
        });
    </script>
</body>
</html>