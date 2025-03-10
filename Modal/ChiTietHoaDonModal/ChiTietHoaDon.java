package ChiTietHoaDonModal;

public class ChiTietHoaDon {
	private int MaChiTietHoaDon;
	private String MaSach;
	private long SoLuongMua;
	private int MaHoaDon;
	private boolean damua;
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getMaChiTietHoaDon() {
		return MaChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(int maChiTietHoaDon) {
		MaChiTietHoaDon = maChiTietHoaDon;
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
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public ChiTietHoaDon(int maChiTietHoaDon, String maSach, long soLuongMua, int maHoaDon,boolean damua) {
		super();
		MaChiTietHoaDon = maChiTietHoaDon;
		MaSach = maSach;
		SoLuongMua = soLuongMua;
		MaHoaDon = maHoaDon;
		this.damua=damua;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
