package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class xoaSuaAdminController
 */
@WebServlet("/xoaSuaAdminController")
public class xoaSuaAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaSuaAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//upload file
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		// Lấy toàn bộ loại gán vào session
		LoaiBo loaiBo = new LoaiBo();
		SachBo sachBo = new SachBo();
		ArrayList<Loai> ds = loaiBo.getLoai();
		session.setAttribute("dsloai", ds);
		//xoá sách
		if(request.getParameter("btnDelete")!=null) {
			String masach = request.getParameter("masach");
			Sach sach = sachBo.get1Sach(masach);
			session.setAttribute("sachDelete", sach);
			RequestDispatcher rd = request.getRequestDispatcher("XoaSachAdmin.jsp");
			rd.forward(request, response);	
		}
		if(request.getParameter("LuuDeleteSach")!=null) {
			String masach = request.getParameter("masach");
			sachBo.DeleteSach(masach);
			response.sendRedirect("TrangChuAdminController");
			return;
		}
		//Update Sách
		if(request.getParameter("btnEdit")!=null) {
			String masach = request.getParameter("masach");
			Sach sach = sachBo.get1Sach(masach);
			session.setAttribute("sachEdit", sach);
			RequestDispatcher rd = request.getRequestDispatcher("EditSachAdmin.jsp");
			rd.forward(request, response);		
			
		}
		
		if(session.getAttribute("checkThemSach")==null) {
			session.setAttribute("checkThemSach",1);
			RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
			rd.forward(request, response);
		}
		//bổ xung sách
		if(request.getParameter("luuSach")!=null){	
		}
		
		//Xoá sach

		RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
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
