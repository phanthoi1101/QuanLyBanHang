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

import KhachHangModal.KhachHangBo;
import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class TrangChuAdminController
 */
@WebServlet("/TrangChuAdminController")
public class TrangChuAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SachBo sach =new SachBo();
		//Pagination 
		String searchsach = request.getParameter("SearchValue");
		int pageCount = sach.getPageCount();
		if(searchsach!=null)
			pageCount = sach.getPageCountSearch(searchsach);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("page",1);
		// TRA VE DANH SACH HIEN THI	
		session.setAttribute("Search", searchsach);
		ArrayList<Sach> listSearch = new ArrayList<Sach>();
		if(searchsach!=null){
			int x = (int)session.getAttribute("page");
			listSearch = sach.getSachSearch20Row(x, searchsach);
		}
		if(searchsach == null ){
			listSearch = sach.getSach20Row((int)session.getAttribute("page"));
		}
		session.setAttribute("dsSach", listSearch);
		RequestDispatcher rd = request.getRequestDispatcher("TrangChuAdmin.jsp");
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
