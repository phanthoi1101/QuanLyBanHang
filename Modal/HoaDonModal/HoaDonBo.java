package HoaDonModal;

public class HoaDonBo {
	HoaDonDao hdDao = new HoaDonDao();
	public long addHoaDon(long makh) {
		return hdDao.addHoaDon(makh);
	}
	public void updateHoaDon(long maHoaDon) {
		hdDao.UpdateDamuaHoaDon(maHoaDon);
	}
}
