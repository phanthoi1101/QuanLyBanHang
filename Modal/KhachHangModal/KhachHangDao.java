package KhachHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModal.KetNoi;

public class KhachHangDao {
	ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
	public ArrayList<KhachHang> getKhachHang(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("makh");
				String hoten = rs.getString("hoten");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sodt");
				String email = rs.getString("email");
				String tendn = rs.getString("tendn");
				String pass = rs.getString("pass");
				ds.add(new KhachHang(id, hoten, diachi, sdt, email, tendn, pass));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lấy ra danh sách khách hàng" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	public int addKhachHang(KhachHang kh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into KhachHang(hoten,diachi,sodt,email,tendn,pass) values(?,?,?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, kh.getHoten());
			cmd.setString(2, kh.getDiachi());
			cmd.setString(3, kh.getSodt());
			cmd.setString(4, kh.getEmail());
			cmd.setString(5, kh.getTendn());
			cmd.setString(6, kh.getPass());
			int kq = cmd.executeUpdate();
			cmd.close();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("them moi 1 khach hang : "+ e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}
	public String getTendn(String tendn, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang where tendn=? and pass=?";
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
	public long getmakh(String tendn, String pass) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from KhachHang where tendn=? and pass=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			long makh = 0;
			if (rs.next()) {
                makh = rs.getLong("makh");
            }
			rs.close();kn.cn.close();
			return makh;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("get ma khach hàng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
//	public KhachHang get1KhachHang(String tendn, String pass) {
//		try {
//			KetNoi kn = new KetNoi();
//			kn.KetNoi();
//			String sql = "select * from KhachHang where tendn=? and pass=?";
//			PreparedStatement cmd = kn.cn.prepareStatement(sql);
//			cmd.setString(1, tendn);
//			cmd.setString(2, pass);
//			ResultSet rs = cmd.executeQuery();
//			while(rs.next()) {
//				long makh = rs.getLong("makh");
//				
//				
//			}
//			rs.close();kn.cn.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("lấy ra danh sách đăng nhập" + e.getMessage());
//			e.printStackTrace();
//			return null;
//		}
//	}
}