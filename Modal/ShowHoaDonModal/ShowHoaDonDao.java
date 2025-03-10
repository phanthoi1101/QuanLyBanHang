package ShowHoaDonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import KetNoiModal.KetNoi;

public class ShowHoaDonDao {
	ArrayList<ShowHoaDon> ds = new ArrayList<ShowHoaDon>();
	public ArrayList<ShowHoaDon> getShowHoaDon(long maKhachHang){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from ShowHoaDon where makh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, maKhachHang);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				long mahoadon = rs.getLong("MaHoaDon");
				String hoten = rs.getString("hoten");
				long tongsoluong = rs.getLong("TongSoLuong");
				long thanhtien = rs.getLong("ThanhTien");
				java.sql.Date NgayMua = rs.getDate("NgayMua");
				Date ngaymua = new Date(NgayMua.getTime());
				long makh = rs.getLong("makh");
				ds.add(new ShowHoaDon(mahoadon, hoten, tongsoluong, thanhtien, NgayMua,makh));	
			}
			rs.close();kn.cn.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get show hoa don"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
