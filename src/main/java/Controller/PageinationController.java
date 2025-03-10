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

import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class PageinationController
 */
@WebServlet("/PageinationController")
public class PageinationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageinationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int page = 0;
		String test = request.getParameter("btnPage");
		if(!test.isEmpty()) {
			page = Integer.parseInt(request.getParameter("btnPage"));
			session.setAttribute("page", page);
		}
		
		//danh sách các sách có ma loại và trang 
		String ml = (String)session.getAttribute("ml");
		String searchsach = (String)session.getAttribute("searchsach");
		SachBo sach = new SachBo();
		ArrayList<Sach> temp ;
		if(ml!=null) {
			temp = sach.getSachMaloai(page, ml);
			session.setAttribute("listSearch", temp);
		}
		else {
			if(searchsach!=null){
				temp = sach.getSachSearch(page, searchsach);
				session.setAttribute("listSearch", temp);
			}
			else {
			temp = sach.getSach((int)session.getAttribute("page"));
			session.setAttribute("listSearch", temp);
			}
			}
		//danh sach các sach theo trang
		
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
