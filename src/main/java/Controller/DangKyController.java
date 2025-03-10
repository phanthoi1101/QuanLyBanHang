package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;

/**
 * Servlet implementation class DangKyControllẻ
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setAttribute("checkMk", null);
		request.setAttribute("checkTendn", null);
		if(request.getParameter("btnDangKy")!=null) {
			KhachHangBo khBo = new KhachHangBo();
			String hoten = request.getParameter("dangKyHoTen");
			String diachi = request.getParameter("dangKyDiaChi");
			String Sodt = request.getParameter("dangKySdt");
			String email = request.getParameter("dangKyEmail");
			String tendn = request.getParameter("dangKyTenDn");
			String pass = request.getParameter("dangKyPass");
			String password = khBo.HashMatKhau(pass);
			if(tendn!=null && password!=null) {	
				if(khBo.checkTendn(tendn))
					request.setAttribute("checkTendn", "Tên đăng nhập đã tồn tại");
				if(khBo.checkMk(password))
					request.setAttribute("checkMk", "Mật khẩu đã tồn tại");
				if(request.getAttribute("checkTendn")==null && request.getAttribute("checkMk")==null) {
					KhachHang kh = new KhachHang(0, hoten, diachi, Sodt, email, tendn, password);
					khBo.addKhachHang(kh);
					RequestDispatcher rd = request.getRequestDispatcher("FrmDangNhap.jsp");
					rd.forward(request, response);
				}
				
			}
		}
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
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