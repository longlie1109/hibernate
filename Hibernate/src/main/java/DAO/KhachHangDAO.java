/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HibernateUtils;
import DTO.KhachHang;
import DTO.SanPham;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * @author User
 */
public class KhachHangDAO {
//	public ArrayList<KhachHang> getListKhachHang() {
//        try {
//            String sql = "SELECT * FROM khachhang WHERE TinhTrang=1";
//            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
//            ResultSet rs = pre.executeQuery();
//            ArrayList<KhachHang> dskh = new ArrayList<>();
//            while (rs.next()) {
//                KhachHang kh = new KhachHang();
//                kh.setMaKH(rs.getInt(1));
//                kh.setHo(rs.getString(2));
//                kh.setTen(rs.getString(3));
//                kh.setGioiTinh(rs.getString(4));
//                kh.setTongChiTieu(rs.getInt(5));
//                dskh.add(kh);
//            }
//            return dskh;
//        } catch (SQLException ex) {
//        }
//        return null;
//    }
    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();

        try {
        	SessionFactory factory = HibernateUtils.getSessionFactory();
    		Session session = factory.getCurrentSession();
    		session.getTransaction().begin();
    		String sql = "Select e from " + KhachHang.class.getName() + " e where TinhTrang = 1";
//            String sql = "SELECT * FROM khachhang WHERE TinhTrang=1";
            session.createQuery(sql);
            Query<KhachHang> query = session.createQuery(sql);
			List<KhachHang> danhsachkhachhang = query.getResultList();
            
            for (int i = 0; i <= danhsachkhachhang.size(); i++) {
            	KhachHang kh = new KhachHang();
            	kh.setMaKH(danhsachkhachhang.get(i).getMaKH());
            	kh.setHo(danhsachkhachhang.get(i).getHo());
            	kh.setTen(danhsachkhachhang.get(i).getTen());
            	kh.setGioiTinh(danhsachkhachhang.get(i).getGioiTinh());
            	kh.setTongChiTieu(danhsachkhachhang.get(i).getTongChiTieu());
				dskh.add(kh);
	        }
            return dskh;
        } catch (Exception ex) {
//        	ex.printStackTrace();
//        	return 
        }
        return dskh;
    }

    public KhachHang getKhachHang(int maKH) {
        KhachHang kh = null;
        try {
            String sql = "SELECT * FROM khachhang WHERE MaKH=? AND TinhTrang=1";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, maKH);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setTongChiTieu(rs.getInt(5));
            }
        } catch (SQLException ex) {
            return null;
        }
        return kh;
    }

    public boolean addKhachHang(KhachHang kh) {
        boolean result = false;
        try {
            String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?,1)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, kh.getMaKH());
            prep.setString(2, kh.getHo());
            prep.setString(3, kh.getTen());
            prep.setString(4, kh.getGioiTinh());
            prep.setInt(5, kh.getTongChiTieu());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean deleteKhachHang(int maKH) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TinhTrang=0 WHERE MaKH=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateKhachHang(int maKH, KhachHang kh) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET Ho=?, Ten=?, GioiTinh=? WHERE MaKH=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setString(1, kh.getHo());
            prep.setString(2, kh.getTen());
            prep.setString(3, kh.getGioiTinh());
            prep.setInt(4, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateTongChiTieu(int maKH, int tongChiTieu) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TongChiTieu=" + tongChiTieu + " WHERE MaKH=" + maKH;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
}
