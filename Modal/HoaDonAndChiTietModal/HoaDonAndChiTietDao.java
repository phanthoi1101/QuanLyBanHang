package HoaDonAndChiTietModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModal.KetNoi;

public class HoaDonAndChiTietDao {
	ArrayList<HoaDonAndChiTiet> ds = new ArrayList<HoaDonAndChiTiet>();
	public ArrayList<HoaDonAndChiTiet> getHoaDonAndChiTiet(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from hoadon inner join ChiTietHoaDon on hoadon.MaHoaDon = ChiTietHoaDon.MaHoaDon";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
			int makh = rs.getInt("makh");
			Date NgayMua = rs.getDate("NgayMua");
			boolean damua = rs.getBoolean("damua");
			String MaSach = rs.getString("MaSach") ;
			long SoLuongMua = rs.getLong("SoLuongMua");
			int MaHoaDon = rs.getInt("MaHoaDon");
			ds.add(new HoaDonAndChiTiet(makh, NgayMua, damua, MaSach, SoLuongMua, MaHoaDon));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Get danh sach chi tiết hoa đơn và  hoa don" +e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
