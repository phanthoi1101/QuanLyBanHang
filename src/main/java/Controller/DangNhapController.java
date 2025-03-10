package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import KhachHangModal.KhachHangBo;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHangBo kh = new KhachHangBo();
		//dang nhap
		request.setAttribute("CheckDn", null);
				String tendn = request.getParameter("txtTenDn");
				String mk = request.getParameter("txtMk");
				request.setAttribute("CheckDn",null);
				if(tendn==null) {
					tendn = "";
				}
				if(mk==null) {
					mk = "";
				}
				boolean checkDn = false;
				 checkDn = kh.CheckDangNhap(tendn, mk);
				if(!checkDn) {
					request.setAttribute("CheckDn", "tên đăng nhập hoặc mật khẩu không chính xác");
					RequestDispatcher rd = request.getRequestDispatcher("FrmDangNhap.jsp");
					rd.forward(request, response);
					return;
				}
				session.setAttribute("checkDn", checkDn);
				session.setAttribute("tendn", tendn);
				session.setAttribute("mk", mk);
				response.sendRedirect("TrangChuAdminController");
				return;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
