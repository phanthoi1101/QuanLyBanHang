package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DangNhapModal.DangNhapBo;
import KhachHangModal.KhachHangBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapAdminController
 */
@WebServlet("/DangNhapAdminController")
public class DangNhapAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("numberLogin", (int)0);
		if(session.getAttribute("dem")==null) {
			session.setAttribute("dem", (int)0);
		}
//		DangNhapBo dnBo = new DangNhapBo();
		String tendn = request.getParameter("txtTenDn");
		String mk = request.getParameter("txtMk");
//		String pass = dnBo.HashMatKhau(mk);
		if(tendn!=null && mk!=null) {
			DangNhapBo dnBo = new DangNhapBo();
			String pass = dnBo.HashMatKhau(mk);
			System.out.println(pass);
			String kh = dnBo.getTendn(tendn, pass);
			if(kh!=null) {
				if((int)session.getAttribute("dem")>=3) {
					Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
					request.setCharacterEncoding("UTF-8");
					String answer = request.getParameter("answer");
					if(captcha.isCorrect(answer)) {
						session.setAttribute("checkDn", (boolean)true);
						session.setAttribute("tendn", kh);
						session.setAttribute("dnadmin",kh);
						response.sendRedirect("TrangChuAdminController");
						if((int)session.getAttribute("dem")!=0) {
							session.removeAttribute("dem");
						}
						return;
					}
				}
				else {
				session.setAttribute("checkDn", (boolean)true);
				session.setAttribute("tendn", kh);
				session.setAttribute("dnadmin",kh);
				if((int)session.getAttribute("dem")!=0||session.getAttribute("dem")==null) {
					session.removeAttribute("dem");
				}
				response.sendRedirect("TrangChuAdminController");
				return;
				}
			}else {
				KhachHangBo khbo = new KhachHangBo();
				kh = khbo.getTendn(tendn, pass);
				long makh = khbo.getmakh(tendn, pass);
				if(kh!=null) {
					if((int)session.getAttribute("dem")>=3) {
						Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
						request.setCharacterEncoding("UTF-8");
						String answer = request.getParameter("answer");
						if(captcha.isCorrect(answer)) {
							session.setAttribute("makh", makh);
							System.out.println(makh);
							session.setAttribute("checkDn", (boolean)true);
							session.setAttribute("tendn", kh);
							session.setAttribute("mk", pass);
							session.setAttribute("dnadmin",kh);
							response.sendRedirect("trangChuController");
							if((int)session.getAttribute("dem")!=0) {
								session.removeAttribute("dem");
							}
							return;
						}
					}
					else {
					session.setAttribute("makh", makh);
					session.setAttribute("checkDn", (boolean)true);
					session.setAttribute("tendn", kh);
					session.setAttribute("mk", pass);
					session.setAttribute("dnadmin",kh);
					if((int)session.getAttribute("dem")!=0||session.getAttribute("dem")==null) {
						session.removeAttribute("dem");
					}
					response.sendRedirect("trangChuController");
					return;
					}
				}else {
					int d =(int) session.getAttribute("dem");	
					d++;session.setAttribute("dem", d);
					session.setAttribute("tb", "Đăng nhập sai");
				}
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
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
