
package SachModal;

import java.util.ArrayList;

public class SachBo {
	SachDao sachDao = new SachDao();
	ArrayList<Sach> ds;
	public ArrayList<Sach> getSach(int page){
		ds = sachDao.getSach(page);
		return ds;
	}
	public ArrayList<Sach> getAllSach(){
		ds = sachDao.getAllSach();
		return ds;
	}
	public int getPageCount() {
		int x = sachDao.getPageCount();
		return x;
	}
	public int getPageCountMaloai(String maloai) {
		int x = sachDao.getPageCountMaloai(maloai);
		return x;
	}
	public int getPageCountSearch(String search) {
		int x = sachDao.getPageCountSearch(search);
		return x;
	}
	public ArrayList<Sach> getSachMaloai(int page , String maloai){
		ds = sachDao.getSachMaloai(page, maloai);
		return ds;
	}
	public ArrayList<Sach> getSachSearch(int page , String search){
		ds = sachDao.getSachSearch(page, search);
		return ds;
	}
	public ArrayList<Sach> getSach20Row(int page){
		ds = sachDao.getSach20Row(page);
		return ds;
	}
	public ArrayList<Sach> getSachSearch20Row(int page,String search){
		ds = sachDao.getSachSearch20Row(page,search);
		return ds;
	}
	public void addSach(Sach sach, String soTap) {
		sachDao.Addsach(sach, soTap);
	}
	public Sach get1Sach(String masach) {
		return sachDao.get1Sach(masach);
	}
	public void UpdateSach(Sach sach) {
		int x = sachDao.updateSach(sach);
	}
	public void DeleteSach(String masach) {
		sachDao.delete(masach);
	}
	}