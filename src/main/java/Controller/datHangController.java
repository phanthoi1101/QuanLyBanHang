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
import temp.CgioHang;

/**
 * Servlet implementation class datHangController
 */
@WebServlet("/datHangController")
public class datHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String datmua = request.getParameter("datmua");//đặt mua là 1 cái mã sách
		session.setAttribute("datmua",null );	
		//trả về 1 sách
		if(datmua!=null){
			SachBo sbo = new SachBo();
			ArrayList<Sach> ds = sbo.getAllSach();//ds là tất cả các sách
			int n = ds.size();
			for(int i = 0 ; i < n ; i++){
				if(datmua.equals(ds.get(i).getMaSach())) {
					CgioHang gh = new CgioHang();
					Sach sach = new Sach(ds.get(i).getMaSach(),ds.get(i).getTenSach(),ds.get(i).getTacGia(),ds.get(i).getSoLuong(),ds.get(i).getGia(),ds.get(i).getAnh(),ds.get(i).getMaLoai());
					gh.themHang(sach,1);
					session.setAttribute("datmua", gh);
				}
			}
		}
		
		
		
		//hiển thị giỏ hàng 
		CgioHang gh = new CgioHang();
		CgioHang cgio = new CgioHang();
		if(session.getAttribute("datmua")!=null){ //đặt mua một cgiohang
			gh = (CgioHang) session.getAttribute("datmua");//gio hang dat mua
			//đặt mua lần đầu
			if(session.getAttribute("gh")== null){
				session.setAttribute("gh", gh);
				cgio = (CgioHang)session.getAttribute("gh");
			}
			//đã đặt mua những lần sau
			else{
				cgio =(CgioHang) session.getAttribute("gh");
				cgio.themHang(gh.ds.getFirst().getSach(),gh.ds.getFirst().getSoLuong()); //add hàng của lần mua tiếp theo vào giỏ
				session.setAttribute("gh",cgio); 
			}	
		}
		else{
			cgio = (CgioHang)session.getAttribute("gh");
		}
		session.setAttribute("gh", cgio);
		
		//xoa 1 hang
		RequestDispatcher rd = request.getRequestDispatcher("DatHang.jsp");
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
