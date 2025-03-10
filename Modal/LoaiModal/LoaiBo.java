package LoaiModal;

import java.util.ArrayList;

public class LoaiBo {
	LoaiDao lDao= new LoaiDao();
	public ArrayList<Loai> getLoai(){
		return lDao.getLoai();
	}
	public int getPageCount() {
		return lDao.getpagecount();
	}
	public int getPageCountSearch(String search) {
		return lDao.getPageCountSearch(search);
	}
	public ArrayList<Loai> getLoaiSearch20Row(int page, String search){
		return lDao.getLoaiSearch20Row(page, search);
	}
	public ArrayList<Loai> getLoai20Row(int page){
		return lDao.getLoai20Row(page);
	}
	public void Addloai(Loai loai) {
		lDao.Addloai(loai);
	}
	public Loai get1Loai(String maloai) {
		return lDao.get1Loai(maloai);
	}
	public void updateLoai(Loai loai) {
		 lDao.updateLoai(loai);
	}
}