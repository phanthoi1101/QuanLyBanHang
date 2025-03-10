package ChiTietHoaDonModal;

import java.util.ArrayList;

public class ChiTietHoaDonBo {
	ChiTietHoaDonDao cthdDao = new ChiTietHoaDonDao();
	public void addChiTietHoaDon(String masach , long slmua , long maHoaDon) {
		int temp = cthdDao.addChiTietHoaDon(masach, slmua, maHoaDon);
	}
	public ArrayList<ChiTietHoaDon> getCthd(){
		return cthdDao.getCthd();
	}
	public void updatedamua (long macthd) {
		cthdDao.UpdateDamuaCthd(macthd);
	}
	public int UpdateSoLuongCthd(long soluong,long cthd) {
		return cthdDao.UpdateSoLuongCthd(cthd, soluong);
	}
	public int xoaChiTietHoaDon(long macthd) {
		return cthdDao.xoaChiTietHoaDon(macthd);
	}
}
