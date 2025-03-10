package LoaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import KetNoiModal.KetNoi;
import SachModal.Sach;

public class LoaiDao {
	ArrayList<Loai> ds = new ArrayList<Loai>();
	public ArrayList<Loai> getLoai(){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maLoai = rs.getString("maloai");
				String tenLoai = rs.getString("tenloai");
				ds.add(new Loai(maLoai, tenLoai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get loai" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int getpagecount() {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount loại" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getPageCountSearch(String search) {
		try {
			int pageCount = 0;
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select COUNT(*) as total from loai where tenloai like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search+"%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				pageCount = rs.getInt("total");
			}
			rs.close();
			return pageCount;
		} catch (Exception e) {
			System.out.println("get PageCount loại" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Loai> getLoaiSearch20Row(int page , String search){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from loai where tenloai like ? order by maloai offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%"+search+"%");
			cmd.setInt(2,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new Loai(maloai, tenloai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get loại" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public int Addloai(Loai loai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "insert into loai(maloai,tenloai) values(?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, loai.getMaLoai());
			cmd.setString(2, loai.getTenLoai());
			int kq = cmd.executeUpdate();
			cmd.close();kn.cn.close();
			return 1;
		} catch (Exception e) {
			System.out.println("add loại "+e.getMessage());
			e.printStackTrace();
			return 0;
		}

	}
	
	public ArrayList<Loai> getLoai20Row(int page){
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from loai order by maloai offset (20*? -20) rows fetch next 20 rows only";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1,page);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new Loai(maloai, tenloai));
			}
			rs.close();
			return ds;
		} catch (Exception e) {
			System.out.println("get loai" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateLoai(Loai loai) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update loai set tenloai = ? where maloai=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, loai.getTenLoai());
			cmd.setString(2, loai.getMaLoai());
			int kq = cmd.executeUpdate();
			cmd.close();kn.cn.close();
			return kq;
		} catch (Exception e) {
			System.out.println("update loại" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	public Loai get1Loai(String maloai) {
		try {
			Loai loai = new Loai();
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from loai where maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,maloai);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maLoai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				loai = new Loai(maloai, tenloai);
			}
			rs.close();kn.cn.close();
			return loai;
		} catch (Exception e) {
			System.out.println("get 1 loại" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}