package HoaDonModal;

import java.sql.Date;

public class HoaDon {
	private int MaHoaDon;
	private int makh;
	private Date NgayMua;
	private boolean damua;
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public HoaDon(int maHoaDon, int makh, Date ngayMua, boolean damua) {
		super();
		MaHoaDon = maHoaDon;
		this.makh = makh;
		NgayMua = ngayMua;
		this.damua = damua;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
