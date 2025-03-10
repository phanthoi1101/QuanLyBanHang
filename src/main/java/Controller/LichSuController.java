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

import ChiTietHoaDonModal.ChiTietHoaDon;
import ChiTietHoaDonModal.ChiTietHoaDonBo;
import HoaDonModal.HoaDonBo;
import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;
import LichSuDatHangModal.LichSuDatHang;
import LichSuDatHangModal.LichSuDatHangBo;
import temp.CgioHang;

/**
 * Servlet implementation class LichSuController
 */
@WebServlet("/LichSuController")
public class LichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				ChiTietHoaDonBo ctBo = new ChiTietHoaDonBo();
				HoaDonBo hdBo = new HoaDonBo();
				HttpSession session = request.getSession();
				ArrayList<LichSuDatHang> ls;
				LichSuDatHangBo lsBo= new LichSuDatHangBo(); 
				if(request.getParameter("buttonEdit")!=null){
					long slSua =Long.parseLong(request.getParameter("soluong"));//soluong
					long macthd = Long.parseLong(request.getParameter("macthd"));
					ctBo.UpdateSoLuongCthd(slSua, macthd);			
				}
				if(request.getParameter("buttonXoa")!=null){
					long macthd = Long.parseLong(request.getParameter("macthd"));
					ctBo = new ChiTietHoaDonBo();
					ctBo.xoaChiTietHoaDon(macthd);		
				}
				//Xác nhận thanh toán 
				//lấy về 1 mã hoá đơn và mã chi tiết hoá đơn 
				//Mã chi tiết hoá đơn để update chi tiết hoá đơn 
				//Mã hoá đơn để kiểm tra xem hoá đơn đó ở chi tiết hoá đơn đã thanh toán hết chưa. Nếu rồi sẽ tiến hanhd update đã mua của Hoá đơn là true
				if(request.getParameter("buttonThanhToan")!=null) {
					int check = 1;
					long mahd = Long.parseLong(request.getParameter("mahd"));
					long macthd = Long.parseLong(request.getParameter("macthd"));
					ctBo.updatedamua(macthd);	
					for(ChiTietHoaDon cthd : ctBo.getCthd()) {					
						if(cthd.getMaHoaDon()== mahd) {
							if(cthd.isDamua()== false) {
							check = 0;break;
							}
						}
					}
					if(check == 1) {
						//update hoá đơn
						hdBo.updateHoaDon(mahd);
					}	
					response.sendRedirect("LichSuController");
					return;
				}
				ls= lsBo.getLichSuDatHang();
				session.setAttribute("dsLsdh", ls);
				RequestDispatcher rd = request.getRequestDispatcher("LichSuMuaHang.jsp");
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
