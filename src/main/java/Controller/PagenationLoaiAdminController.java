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
 * Servlet implementation class PagenationLoaiAdminController
 */
@WebServlet("/PagenationLoaiAdminController")
public class PagenationLoaiAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagenationLoaiAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int page=1;
		if(request.getParameter("btnPage")!=null) {
			page=Integer.parseInt(request.getParameter("btnPage"));
		}
		session.setAttribute("page", page);
		LoaiBo loaiBo = new LoaiBo();
		String search;
		if(session.getAttribute("Search")==null) {
			search = "";
		}else {
			search = (String)session.getAttribute("Search");
		}
		
		ArrayList<Loai> dsLoai = loaiBo.getLoaiSearch20Row(page,search);
		if(session.getAttribute("dsLoai")==null)
			session.setAttribute("dsLoai",null);
		session.setAttribute("dsLoai", dsLoai);//danh sách sách theo trang
		int pageCount = (int)session.getAttribute("pageCount");
		session.setAttribute("pageCount", pageCount);
		//Hiển thị sách theo tên tìm kiếm
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("TrangChuLoaiAdmin.jsp");
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
