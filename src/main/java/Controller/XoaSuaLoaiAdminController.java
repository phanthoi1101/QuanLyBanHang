package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class XoaSuaLoaiAdminController
 */
@WebServlet("/XoaSuaLoaiAdminController")
public class XoaSuaLoaiAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaLoaiAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Lấy toàn bộ loại gán vào session
		LoaiBo loaiBo = new LoaiBo();
		SachBo sachBo = new SachBo();
		ArrayList<Loai> ds = loaiBo.getLoai();
		session.setAttribute("dsloai", ds);
		//xoá sách
		if(request.getParameter("btnDelete")!=null) {
			String maloai = request.getParameter("maloai");
			Loai loai = loaiBo.get1Loai(maloai);
			session.setAttribute("loaiDelete", loai);
			RequestDispatcher rd = request.getRequestDispatcher("XoaLoaiAdmin.jsp");
			rd.forward(request, response);	
		}
		if(request.getParameter("LuuDeleteLoai")!=null) {
			String maloai = request.getParameter("maloai");
			sachBo.DeleteSach(maloai);
			response.sendRedirect("TrangChuLoaiAdminController");
			return;
		}
		//Update Loai
		if(request.getParameter("btnEdit")!=null) {
			String maloai = request.getParameter("maloai");
			Loai loai = loaiBo.get1Loai(maloai);
			session.setAttribute("loaiEdit", loai);
			RequestDispatcher rd = request.getRequestDispatcher("EditLoaiAdmin.jsp");
			rd.forward(request, response);		
			
		}
		if(request.getParameter("LuuEditLoai")!=null) {
			if( request.getParameter("maloai")!="" && request.getParameter("tenloai")!="") {
				String maloai = request.getParameter("maloai");
				String tenloai = request.getParameter("tenloai");
				System.out.println(maloai+tenloai);
				Loai loai = new Loai(maloai, tenloai);
				loaiBo.updateLoai(loai);
				session.setAttribute("checkLoaiEdit", 1);
			}
			else{
				session.setAttribute("checkLoaiEdit", 0);
			}
			RequestDispatcher rd = request.getRequestDispatcher("TrangChuLoaiAdmin.jsp");
			rd.forward(request, response);
		}
		if(session.getAttribute("checkThemLoai")==null) {
			session.setAttribute("checkThemLoai",1);
			RequestDispatcher rd = request.getRequestDispatcher("BoSungLoai.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("luuSach")!=null) {
			if( request.getParameter("tenloai")!="" && request.getParameter("maloai")!="") {
				String maloai= request.getParameter("maloai");
				String tenloai = request.getParameter("tenloai");
				Loai loai = new Loai(maloai, tenloai);
				loaiBo.Addloai(loai);
				session.setAttribute("checkThemLoai", 1);
				response.sendRedirect("PagenationLoaiAdminController");
				return;
			}else {
				session.setAttribute("checkThemLoai",0);
				RequestDispatcher rd = request.getRequestDispatcher("BoSungLoai.jsp");
				rd.forward(request, response);
			}	
		}
		
		//Xoá sach
		
		

		RequestDispatcher rd = request.getRequestDispatcher("BoSungLoai.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
