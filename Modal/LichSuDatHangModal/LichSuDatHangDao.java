package LichSuDatHangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoiModal.KetNoi;


public class LichSuDatHangDao {
	ArrayList<LichSuDatHang> ds = new ArrayList<LichSuDatHang>();
	public ArrayList<LichSuDatHang> getLichSuDatHang(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * From dbo.LichSuDonHang order by MaHoaDon desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long makh = rs.getLong("makh");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("thanhtien");
				Date ngaymua = rs.getDate("NgayMua");
				boolean damua = rs.getBoolean("damua");
				String tensach = rs.getString("tensach");
				int soluong = rs.getInt("SoLuongMua");
				int macthd = rs.getInt("MaChiTietHD");
				int mahd = rs.getInt("MaHoaDon");
				ds.add(new LichSuDatHang(tensach,makh, gia, ngaymua, thanhtien, damua,soluong,macthd,mahd));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get danh sach lich su dat hang"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
}
