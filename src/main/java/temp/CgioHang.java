package temp;
import java.lang.reflect.Array;
import java.util.ArrayList;

import SachModal.Sach;
public class CgioHang {
	public ArrayList<Hang> ds = new ArrayList<Hang>();	
	public void themHang(Sach sach , long sl) {
		int n = ds.size();
		for( int i = 0 ; i < n ; i ++) {
			if((ds.get(i).getSach().getTenSach().toLowerCase().trim()).equals(sach.getTenSach().toLowerCase().trim())) {
				long slt = ds.get(i).getSoLuong()+sl;
				ds.get(i).setSoLuong(slt);
				long giatemp = ds.get(i).getSach().getGia();
				long tt = giatemp*slt;
				ds.get(i).setThanhTien(tt);
				return;
			}
		}
		long tt = sach.getGia()*sl;
		Hang h = new Hang(sach,sl,tt);
		ds.add(h);
	}
	public void sua(String masach , long sl) {
		int n = ds.size();
		for(int i = 0 ; i < n ; i++) {
			if(masach.equals(ds.get(i).getSach().getMaSach())) {
				ds.get(i).setSoLuong(sl);
				long thanhtien = sl*(ds.get(i).getSach().getGia());
				ds.get(i).setThanhTien(thanhtien);
				return;
			}
		}
	}
	public void xoa(String th) {
		int n = ds.size();
		for(int i = 0 ; i<n ; i ++) {
			if(th.equals(ds.get(i).getSach().getMaSach())) {
				ds.remove(i);
				return;
			}
		}
	}
	public long tongTien() {
		int n = ds.size();
		long tong=0;
		for(int i = 0 ; i < n ; i++) {
			tong += ds.get(i).getThanhTien();
		}	
		return tong;
	}
}