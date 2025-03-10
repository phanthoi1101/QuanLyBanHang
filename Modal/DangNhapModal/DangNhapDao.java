package DangNhapModal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModal.KetNoi;

public class DangNhapDao {
	ArrayList<DangNhap> ds = new ArrayList<DangNhap>();
	public ArrayList<DangNhap> getDangNhap(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from DangNhap";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String TenDn = rs.getString("TenDangNhap");
				String Mk = rs.getString("MatKhau");
				boolean quyen = rs.getBoolean("Quyen");
				ds.add(new DangNhap(TenDn, Mk, quyen));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	public String getTenDn(String tendn , String pass){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from DangNhap where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			String kt = null;
			if(rs.next()) {
				kt=tendn;
			}
			rs.close();kn.cn.close();
			return kt;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	public long getMaKh(String tendn , String pass){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from DangNhap where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			long makh=0;
			while(rs.next()) {
				makh=rs.getLong("MaKhachHang");
			}
			rs.close();kn.cn.close();
			return makh;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}

}
