<%@page import="java.util.ArrayList"%>
<%@page import="LoaiModal.Loai"%>
<%@page import="LoaiModal.LoaiBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-sm-2">
				<h3 class="text-center">Loại sách</h3>
				<hr>
				<div class="list-group">
					<%
					ArrayList<Loai> dsl;
					dsl = (ArrayList<Loai>)session.getAttribute("dsl");
						for (Loai l : dsl) {
					%>
					<a class="list-group-item" href="trangChuController?ml=<%=l.getMaLoai()%>"><%=l.getTenLoai()%>
					</a>
					<%
						}
					%>
				</div>
</div>