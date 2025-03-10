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

import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class PagenationAdminController
 */
@WebServlet("/PagenationAdminController")
public class PagenationAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagenationAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int page=1;
		if(request.getParameter("btnPage")!=null) {
			page=Integer.parseInt(request.getParameter("btnPage"));
		}
		session.setAttribute("page", page);
		SachBo sachBo = new SachBo();
		String search;
		if(session.getAttribute("Search")==null) {
			search = "";
		}else {
			search = (String)session.getAttribute("Search");
		}
		
		ArrayList<Sach> dsSach = sachBo.getSachSearch20Row(page,search);
		if(session.getAttribute("dsSach")==null)
			session.setAttribute("dsSach",null);
		session.setAttribute("dsSach", dsSach);//danh sách sách theo trang
		int pageCount = (int)session.getAttribute("pageCount");
		session.setAttribute("pageCount", pageCount);
		//Hiển thị sách theo tên tìm kiếm
		
		
		
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
