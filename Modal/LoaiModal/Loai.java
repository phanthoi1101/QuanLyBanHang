package LoaiModal;

public class Loai {
	private String MaLoai;
	private String TenLoai;
	
	
	//Khởi tạo
	public Loai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loai(String maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
	
	//geter seter
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	
	
}