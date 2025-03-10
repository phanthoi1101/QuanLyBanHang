package LichSuDatHangModal;

import java.util.ArrayList;

public class LichSuDatHangBo {
	ArrayList<LichSuDatHang> ds;
	LichSuDatHangDao lsDao = new LichSuDatHangDao();
	public ArrayList<LichSuDatHang> getLichSuDatHang(){
		return lsDao.getLichSuDatHang();
	}
	public ArrayList<LichSuDatHang> getLichSuDatHangMakh(long makh){
		ArrayList<LichSuDatHang> temp = new ArrayList<LichSuDatHang>();
		ds = lsDao.getLichSuDatHang();
		for(LichSuDatHang ls : ds) {
			if(makh==ls.getMakh())
				temp.add(ls);
		}
		return temp;
	}
}
