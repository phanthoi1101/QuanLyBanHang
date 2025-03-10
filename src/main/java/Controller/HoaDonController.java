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

import ShowHoaDonModal.ShowHoaDon;
import ShowHoaDonModal.ShowHoaDonBo;

/**
 * Servlet implementation class HoaDonController
 */
@WebServlet("/HoaDonController")
public class HoaDonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoaDonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShowHoaDonBo showHdBo = new ShowHoaDonBo();
		ArrayList<ShowHoaDon> dsShowHd;
		if(session.getAttribute("makh")==null) {
			response.sendRedirect("DangNhapAdminController");
			return ;
		}
		long makh= (long)session.getAttribute("makh");
		dsShowHd = showHdBo.getShowHoaDon(makh);
		session.setAttribute("dsShowHd", dsShowHd);	
		RequestDispatcher rd = request.getRequestDispatcher("HoaDon.jsp");
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
