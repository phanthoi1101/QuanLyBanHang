
package temp;

import SachModal.Sach;

public class Hang {
	private Sach sach;
	private long soLuong;
	private long thanhTien;
	
	public Hang(Sach sach, long soLuong,long thanhTien) {
		this.soLuong = soLuong;
		this.sach = sach;
		this.thanhTien=thanhTien;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
}