package ShowHoaDonModal;

import java.util.ArrayList;

public class ShowHoaDonBo {
	ArrayList<ShowHoaDon> ds;
	ShowHoaDonDao showHdDao = new ShowHoaDonDao();
	public ArrayList<ShowHoaDon> getShowHoaDon(long makh){
		return showHdDao.getShowHoaDon(makh);
	}
}
