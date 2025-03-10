package ShowHoaDonModal;

import java.util.Date;

public class ShowHoaDon {
	private long MaHoaDon;
	private String HoTen;
	private long TongSoLuong;
	private long ThanhTien;
	private Date NgayMua;
	private long MaKhachHang;
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public long getTongSoLuong() {
		return TongSoLuong;
	}
	public void setTongSoLuong(long tongSoLuong) {
		TongSoLuong = tongSoLuong;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

	public ShowHoaDon(long maHoaDon, String hoTen, long tongSoLuong, long thanhTien, Date ngayMua, long maKhachHang) {
		super();
		MaHoaDon = maHoaDon;
		HoTen = hoTen;
		TongSoLuong = tongSoLuong;
		ThanhTien = thanhTien;
		NgayMua = ngayMua;
		MaKhachHang = maKhachHang;
	}
	public ShowHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	
	
}
