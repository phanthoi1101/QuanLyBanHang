package KhachHangModal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class KhachHangBo {
	ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
	KhachHangDao khDao = new KhachHangDao();
	public ArrayList<KhachHang> getKhachHang(){
		ds = khDao.getKhachHang();
		return ds;
	}
	
	public boolean CheckDangNhap(String tendn , String pass) {
		pass = HashMatKhau(pass);
		boolean check = false;
		for(KhachHang kh : khDao.getKhachHang()) {
			if(tendn.equals(kh.getTendn())&&pass.equals(kh.getPass())) {
				check = true;
				return check;
			}
		}
		return check;
	}
	public int addKhachHang(KhachHang kh) {
		int kq = khDao.addKhachHang(kh);
		return kq;
	}
	public long getmakh(String tendn , String pass) {
		return khDao.getmakh(tendn, pass);
	}
	public String HashMatKhau(String pass) {
		try {
			if(pass==null) {
				pass="";
			}
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] hashedBytes = digest.digest(pass.getBytes());			
			BigInteger bigInt = new BigInteger(1, hashedBytes);
			return bigInt.toString(16);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ma hoa mat khau" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
		public boolean checkTendn(String tendn) {
			for(KhachHang kh : khDao.getKhachHang()) {
				if(tendn.equals(kh.getTendn()))
					return true;
			}
			return false;
		}
		public boolean checkMk(String pass) {
			for(KhachHang kh : khDao.getKhachHang()) {
				if(pass.equals(kh.getPass()))
					return true;
			}
			return false;
		}
	public String getTendn(String tendn , String pass) {
		return khDao.getTendn(tendn, pass);
	}
}