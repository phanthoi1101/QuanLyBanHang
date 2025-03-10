package ChiTietHoaDonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModal.KetNoi;

public class ChiTietHoaDonDao {
	ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
	public int addChiTietHoaDon(String masach , long slmua , long maHoaDon) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon,damua) values(?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setLong(2, slmua);
			cmd.setLong(3, maHoaDon);
			cmd.setBoolean(4, false);
			int rs= cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			System.out.println("them chi tiết hoa don"+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<ChiTietHoaDon> getCthd(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from ChiTietHoaDon";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				int mact = rs.getInt("MaChiTietHD");
				String masach =rs.getString("MaSach");
				int Sl = rs.getInt("SoLuongMua");
				int mahd = rs.getInt("MaHoaDon");
				boolean damua = rs.getBoolean("damua");
				ds.add(new ChiTietHoaDon(mact, masach, Sl, mahd,damua));
			}
			return ds;
		} catch (Exception e) {
			System.out.println("Lấy danh sách chi tiết hoa don"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public int UpdateDamuaCthd(long macthd) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update ChiTietHoaDon set damua = 1 where MaChiTietHD = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, macthd);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			System.out.println("update chi tiết hoá đơn " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int UpdateSoLuongCthd(long macthd , long soluong) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update ChiTietHoaDon set SoLuongMua = ? where MaChiTietHD = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, soluong);
			cmd.setLong(2,macthd);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			System.out.println("update chi tiết hoá đơn số lượng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public int xoaChiTietHoaDon(long macthd) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete ChiTietHoaDon where MaChiTietHD = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, macthd);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			System.out.println("update chi tiết hoá đơn số lượng" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}
