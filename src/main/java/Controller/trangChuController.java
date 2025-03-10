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
import javax.websocket.Session;

import KhachHangModal.KhachHangBo;
import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import SachModal.Sach;
import SachModal.SachBo;
import SachModal.SachDao;

/**
 * Servlet implementation class trangChuController
 */
@WebServlet("/trangChuController")
public class trangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangChuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SachBo sach =new SachBo();
		KhachHangBo kh = new KhachHangBo();
		//tra ve cac tat ca loai
		HttpSession session = request.getSession();
		ArrayList<Loai> dsl = new ArrayList<Loai>();
		LoaiBo lbo = new LoaiBo();
		dsl=lbo.getLoai();
		session.setAttribute("dsl", dsl);
		//Pagination 
		String ml = (String)request.getParameter("ml");
		String searchsach = request.getParameter("search-sach");
		int pageCount = sach.getPageCount();
		if(ml!=null)
			pageCount = sach.getPageCountMaloai(ml);
		if(searchsach!=null)
			pageCount = sach.getPageCountSearch(searchsach);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("page",1);
		// TRA VE DANH SACH HIEN THI	
		session.setAttribute("ml", ml);
		session.setAttribute("searchsach", searchsach);
		ArrayList<Sach> listSearch = new ArrayList<Sach>();
		if(searchsach!=null){
			int x = (int)session.getAttribute("page");
			listSearch = sach.getSachSearch(x, searchsach);
		}
		if(ml!=null){
			int x = (int)session.getAttribute("page");
			listSearch = sach.getSachMaloai(x,ml);
		}
		if(ml==null && searchsach == null ){
			listSearch = sach.getSach((int)session.getAttribute("page"));
		}
		session.setAttribute("listSearch", listSearch);		
		
		RequestDispatcher rd = request.getRequestDispatcher("tc.jsp");
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
