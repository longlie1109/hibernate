package DAO;

import DTO.HibernateUtils;
import DTO.HoaDon;
import DTO.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HoaDonDAO {
    public ArrayList<HoaDon> getListHoaDon() {
       
        SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		 ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
        	session.getTransaction().begin();
            String sql = "SELECT e FROM " +HoaDon.class.getName() + " e";
            Query<HoaDon> query = session.createQuery(sql);
			List<HoaDon> danhsachhoadon = query.getResultList();
			for(HoaDon hd :danhsachhoadon) {
				HoaDon hoadon = new HoaDon();
				hoadon.setMaHD(hd.getMaHD());
				hoadon.setMaKH(hd.getMaKH());
				hoadon.setMaNV(hd.getMaNV());
				hoadon.setTongTien(hd.getTongTien());
				hoadon.setNgayLap(hd.getNgayLap());
				hoadon.setGhiChu(hd.getGhiChu());
				dshd.add(hoadon);
			}
			session.getTransaction().commit();
			return dshd;
			
        } catch (Exception ex) {
            return null;
        }
        
    }

    public boolean addHoaDon(HoaDon hd) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
        try {
        	session.getTransaction().begin();
            String sql1 = "UPDATE KhachHang SET TongChiTieu=TongChiTieu+" + hd.getTongTien() + " WHERE MaKH = :makh";
            Query query = session.createNativeQuery(sql1);
            query.setParameter("makh", hd.getMaKH());
            int count = query.executeUpdate();
           session.flush();
            String sql = "INSERT INTO hoadon (MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES(:makh, :manv, :ngaylap, :tongtien, :ghichu)";
          Query query1 = session.createNativeQuery(sql);
            query1.setParameter("makh", hd.getMaKH());
            query1.setParameter("manv", hd.getMaNV());
            query1.setParameter("ngaylap", hd.getNgayLap());
            query1.setParameter("tongtien", hd.getTongTien());
            query1.setParameter("ghichu", hd.getGhiChu());
            int count1 = query.executeUpdate();
            if (count > 0 && count1 > 0) {
				session.getTransaction().commit();
				return true;
			} else {
				session.clear();
				session.close();
				return false;
			}
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int getMaHoaDonMoiNhat() {
        try {
            String sql = "SELECT MAX(maHD) FROM hoadon";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<HoaDon> getListHoaDon(Date dateMin, Date dateMax) {
        try {
            String sql = "SELECT * FROM hoadon WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            ResultSet rs = pre.executeQuery();

            ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();

            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setNgayLap(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setGhiChu(rs.getString(6));
                dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
