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
 * Servlet implementation class TrangChuLoaiAdminController
 */
@WebServlet("/TrangChuLoaiAdminController")
public class TrangChuLoaiAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangChuLoaiAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoaiBo loaiBo =new LoaiBo();
		//Pagination 
		String searchloai = request.getParameter("SearchValue");
		System.out.println(searchloai);
		int pageCount = loaiBo.getPageCount();
		if(searchloai!=null)
		pageCount = loaiBo.getPageCountSearch(searchloai);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("page",1);
		// TRA VE DANH SACH HIEN THI	
		session.setAttribute("Search", searchloai);
		ArrayList<Loai> listSearch = new ArrayList<Loai>();
		if(searchloai!=null){
			int x = (int)session.getAttribute("page");
			listSearch = loaiBo.getLoaiSearch20Row(x, searchloai);
		}
		if(searchloai == null ){
			listSearch = loaiBo.getLoai20Row((int)session.getAttribute("page"));
		}
		session.setAttribute("dsLoai", listSearch);
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
