package SachModal;

public class Sach {
	private String MaSach;
	private String TenSach;
	private String TacGia;
	private Long SoLuong;
	private Long Gia;
	private String Anh;
	private String MaLoai;
	
	//Khoi tao
	public Sach(String maSach, String tenSach, String tacGia, Long soLuong, Long gia, String anh, String maLoai) {
		super();
		MaSach = maSach;
		TenSach = tenSach;
		TacGia = tacGia;
		SoLuong = soLuong;
		Gia = gia;
		Anh = anh;
		MaLoai = maLoai;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}

	public String getTenSach() {
		return TenSach;
	}

	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}

	public String getTacGia() {
		return TacGia;
	}

	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}

	public Long getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Long soLuong) {
		SoLuong = soLuong;
	}

	public Long getGia() {
		return Gia;
	}

	public void setGia(Long gia) {
		Gia = gia;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}

	public String getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}

	
}
	