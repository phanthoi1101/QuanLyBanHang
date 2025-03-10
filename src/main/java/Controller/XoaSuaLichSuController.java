


package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import temp.CgioHang;

/**
 * Servlet implementation class XoaSuaLichSuController
 */
@WebServlet("/XoaSuaLichSuController")
public class XoaSuaLichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaLichSuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		if(request.getParameter("buttonEdit")!=null){
//			String msSua = request.getParameter("buttonEdit");
//			long slSua =Long.parseLong(request.getParameter(msSua));
//			CgioHang cgio = new CgioHang();
//			cgio = (CgioHang)session.getAttribute("gh");
//			cgio.sua(msSua,slSua);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
