package LichSuDatHangModal;

import java.util.Date;

public class LichSuDatHang {
	private int soluong;
	private String tensach;
	private long makh;
	private long gia;
	private Date ngaymua;
	private long ThanhTien;
	private boolean damua;
	private int maChiTietHoaDon;
	private int maHoaDon;
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(int maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public LichSuDatHang(String tensach, long makh, long gia, Date ngaymua, long thanhTien, boolean damua,
			int soluong, int maChiTietHoaDon,int maHoaDon) {
		super();
		this.soluong = soluong;
		this.tensach = tensach;
		this.makh = makh;
		this.gia = gia;
		this.ngaymua = ngaymua;
		ThanhTien = thanhTien;
		this.damua = damua;
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHoaDon = maHoaDon;
	}
	public LichSuDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
