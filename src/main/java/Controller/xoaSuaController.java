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
import ChiTietHoaDonModal.ChiTietHoaDonDao;
import HoaDonAndChiTietModal.HoaDonAndChiTiet;
import HoaDonAndChiTietModal.HoaDonAndChiTietBo;
import HoaDonModal.HoaDon;
import HoaDonModal.HoaDonBo;
import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;
import LichSuDatHangModal.LichSuDatHang;
import LichSuDatHangModal.LichSuDatHangBo;
import SachModal.Sach;
import SachModal.SachBo;
import temp.CgioHang;
import temp.Hang;

/**
 * Servlet implementation class xoaSuaController
 */
@WebServlet("/xoaSuaController")
public class xoaSuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaSuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		HoaDonBo hdBo = new HoaDonBo();
		ChiTietHoaDonBo cthdBo = new ChiTietHoaDonBo();
		KhachHangBo khBo = new KhachHangBo();
		//xoa sach
		if(request.getParameter("buttonXoa")!=null){
			String masach = request.getParameter("masach");
			SachBo sach = new SachBo();
			ArrayList<Sach> ds = new ArrayList<Sach>();
			ds = sach.getAllSach();
			for(int i = 0 ; i < ds.size() ; i++){
				if(masach.equals(ds.get(i).getMaSach())){
					CgioHang gh = new CgioHang();
					gh = (CgioHang)session.getAttribute("gh");
					gh.xoa(masach);
					session.setAttribute("gh",gh);
				}
			}
		}
		
		
			//EDIT 1 HÀNG 
				if(request.getParameter("buttonEdit")!=null){
					String msSua = request.getParameter("buttonEdit");
					long slSua =Long.parseLong(request.getParameter(msSua));
					CgioHang cgio = new CgioHang();
					cgio = (CgioHang)session.getAttribute("gh");
					cgio.sua(msSua,slSua);
				}
		
				//Xoa theo từng item
				if(request.getParameter("xoaItem")!=null){
					String[] listItem = request.getParameterValues("checkbox");
					if(listItem!=null) {
						CgioHang cgio = new CgioHang();
						cgio = (CgioHang)session.getAttribute("gh");
						for(String item : listItem){
							cgio.xoa(item);
						}
						session.setAttribute("gh",cgio);
					}					
				}
				
				//Xoá tất cả hàng trong giỏ hàng
				if(request.getParameter("deleteAll")!=null){
					session.setAttribute("gh", null);
				}
				
				//xac nhan dat hang
				CgioHang ghTemp = (CgioHang)session.getAttribute("gh");	
				ArrayList<KhachHang> dsKh =  khBo.getKhachHang();
				long makh = 0;
				for(KhachHang kh : dsKh) {
					if(session.getAttribute("tendn").equals(kh.getTendn())&&session.getAttribute("mk").equals(kh.getPass())) {
						makh = kh.getMakh();
						session.setAttribute("makh", makh);//Lấy ra mã khách hàng hiện tại
					}
				}				
				if(request.getParameter("xacnhan")!=null) {
					long mahoadon = hdBo.addHoaDon(makh);
					for(Hang hang : ghTemp.ds) {
						cthdBo.addChiTietHoaDon(hang.getSach().getMaSach(),hang.getSoLuong(), mahoadon);
					}
					LichSuDatHangBo lsBo = new LichSuDatHangBo();
					ArrayList<LichSuDatHang> dsLsdh = lsBo.getLichSuDatHangMakh(makh);
					session.setAttribute("dsLsdh", dsLsdh);
					session.setAttribute("gh", null);
					response.sendRedirect("trangChuController");
					return;
				}				
				
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
