package DangNhapModal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class DangNhapBo {
	ArrayList<DangNhap> ds = new ArrayList<DangNhap>();
	DangNhapDao dnDao = new DangNhapDao();
	public ArrayList<DangNhap> getDangNhap(){
		return dnDao.getDangNhap();
	}
	
	public String getTendn(String tendn , String pass) {
		return dnDao.getTenDn(tendn, pass);
	}
	public long getMaKh(String tendn , String pass) {
		return dnDao.getMaKh(tendn, pass);
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
}
