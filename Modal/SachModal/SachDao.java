
package SachModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiModal.KetNoi;

public class SachDao {
	ArrayList<Sach> ds = new ArrayList<Sach>();
	
	//Lấy về tất cả các sách
	public ArrayList<Sach> getAllSach(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "Select * from sach";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				Long soLuong =Long.parseLong( rs.getString("soluong"));
				Long gia = Long.parseLong(rs.getString("gia"));
				String maLoai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tacGia = rs.getString("tacgia");
				ds.add(new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get sach" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int updateSach(Sach sach) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update sach set tensach = ?, soluong=?,gia=?,maloai=?,anh=?,tacgia=? where masach=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(7, sach.getMaSach());
			cmd.setString(1, sach.getTenSach());
			cmd.setLong(2, sach.getSoLuong());
			cmd.setLong(3, sach.getGia());
			cmd.setString(4, sach.getMaLoai());
			cmd.setString(5, sach.getAnh());
			cmd.setString(6, sach.getTacGia());
			int kq = cmd.executeUpdate();
			cmd.close();kn.cn.close();
			return kq;
		} catch (Exception e) {
			System.out.println("update sach" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	public void delete(String masach) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql ="delete sach where masach = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.executeUpdate();
			cmd.close();kn.cn.close();
		} catch (Exception e) {
			System.out.println("xoa sach" + e.getMessage());
		}
	}
	public Sach get1Sach(String masach) {
		try {
			Sach sach = new Sach();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from sach where masach = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,masach);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				sach = new Sach(maSach, tensach, tacgia, soluong, gia, anh, maloai);
			}
			rs.close();kn.cn.close();
			return sach;
		} catch (Exception e) {
			System.out.println("get 1 sách" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	//lấy về 6 sách với số thứ tự đầu tiền là page truyền vào đến page+6
	public ArrayList<Sach> getSach(int page){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from sach order by masach offset (6*? -6) rows fetch next 6 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				Long soLuong =Long.parseLong( rs.getString("soluong"));
				Long gia = Long.parseLong(rs.getString("gia"));
				String maLoai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tacGia = rs.getString("tacgia");
				ds.add(new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get sach" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Sach> getSach20Row(int page){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from sach order by masach offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				Long soLuong =Long.parseLong( rs.getString("soluong"));
				Long gia = Long.parseLong(rs.getString("gia"));
				String maLoai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tacGia = rs.getString("tacgia");
				ds.add(new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get sach" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	//Lấy về 6 quyển sách với mã loại truyền vào và số thứ tự là từ page đến page+6
	public ArrayList<Sach> getSachMaloai(int page , String maloai){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from sach where maloai = ? order by masach offset (6*? -6) rows fetch next 6 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setInt(2,page);

			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				Long soLuong =Long.parseLong( rs.getString("soluong"));
				Long gia = Long.parseLong(rs.getString("gia"));
				String maLoai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tacGia = rs.getString("tacgia");
				ds.add(new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get sach" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	//Lấy về 6 quyển sách với search truyền vào và số thứ tự là từ page đến page+6
	public ArrayList<Sach> getSachSearch(int page , String search){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from sach where tensach like ? or tacgia like ?  order by masach offset (6*? -6) rows fetch next 6 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search+"%");
			cmd.setString(2, "%"+search+"%");
			cmd.setInt(3,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				Long soLuong =Long.parseLong( rs.getString("soluong"));
				Long gia = Long.parseLong(rs.getString("gia"));
				String maLoai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tacGia = rs.getString("tacgia");
				ds.add(new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get sach" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Sach> getSachSearch20Row(int page , String search){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from sach where tensach like ? or tacgia like ?  order by masach offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search+"%");
			cmd.setString(2, "%"+search+"%");
			cmd.setInt(3,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				Long soLuong =Long.parseLong( rs.getString("soluong"));
				Long gia = Long.parseLong(rs.getString("gia"));
				String maLoai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String tacGia = rs.getString("tacgia");
				ds.add(new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get sach" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	//lấy về số lượng quyển sách có trong cơ sở dữ liệu
	public int getPageCount() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from sach";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	//update sách
	public int Addsach(Sach sach,String sotap) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into sach(masach,tensach,soluong,gia,maloai,sotap,anh,NgayNhap,tacgia) values(?,?,?,?,?,?,?,GETDATE(),?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, sach.getMaSach());
			cmd.setString(2, sach.getTenSach());
			cmd.setLong(3, sach.getSoLuong());
			cmd.setLong(4, sach.getGia());
			cmd.setString(5, sach.getMaLoai());
			cmd.setString(6, sotap);
			cmd.setString(7, sach.getAnh());
			cmd.setString(8, sach.getTacGia());
			int kq = cmd.executeUpdate();
			cmd.close();kn.cn.close();
			return 1;
		} catch (Exception e) {
			System.out.println("update sách "+e.getMessage());
			e.printStackTrace();
			return 0;
		}

	}
	//lấy về số lượng quyển sách có trong cơ sở dữ liệu trùng với mã loại truyền vào
	public int getPageCountMaloai(String maloai) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from sach where maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	//Lấy về số lượng sách có search truyền vào
	public int getPageCountSearch(String search) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from sach where tensach like ? or tacgia like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search+"%");
			cmd.setString(2, "%"+search+"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
}