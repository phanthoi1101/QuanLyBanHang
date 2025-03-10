package HoaDonAndChiTietModal;

import java.sql.Date;

public class HoaDonAndChiTiet {
	private int makh;
	private Date NgayMua;
	private boolean damua;
	private String MaSach ;
	private long SoLuongMua;
	private int MaHoaDon;
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
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public HoaDonAndChiTiet(int makh, Date ngayMua, boolean damua, String maSach, long soLuongMua, int maHoaDon) {
		super();
		this.makh = makh;
		NgayMua = ngayMua;
		this.damua = damua;
		MaSach = maSach;
		SoLuongMua = soLuongMua;
		MaHoaDon = maHoaDon;
	}
	public HoaDonAndChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
