package HoaDonAndChiTietModal;

import java.util.ArrayList;

public class HoaDonAndChiTietBo {
	ArrayList<HoaDonAndChiTiet> ds = new ArrayList<HoaDonAndChiTiet>();
	HoaDonAndChiTietDao HdAndCthdDao = new HoaDonAndChiTietDao();
	public ArrayList<HoaDonAndChiTiet> getHoaDonAndChiTiet(){
		return HdAndCthdDao.getHoaDonAndChiTiet();
	}
}
