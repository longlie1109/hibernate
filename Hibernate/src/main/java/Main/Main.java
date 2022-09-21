package Main;

import DTO.HoaDon;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.TaiKhoan;
import DTO.ThongKe;

import GUI.DangNhapGUI;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.UnsupportedLookAndFeelException;

import BUS.ThongKeBUS;
import DAO.*;
public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new MyConnect();

        changLNF("Nimbus");
        DangNhapGUI login = new DangNhapGUI();
        login.showWindow();
       
    }

    public static void changLNF(String nameLNF) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (nameLNF.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        }
    }
//	public static void main(String[] args) {
//		 new MyConnect();
//		//SanPhamDAO sanphamdao = new SanPhamDAO();
////		HoaDonDAO hoadon = new HoaDonDAO();
////		ArrayList<HoaDon> listHD= hoadon.getListHoaDon();
////		for(HoaDon hd : listHD) {
////			System.out.println(hd.getTongTien());
////		}
//		 HoaDonDAO hoadondao = new HoaDonDAO();
//		 HoaDon hoadon = new HoaDon(11,4,new Date(2021-04-15),10000,"Đã Thanh Toán");
//		 System.out.println(hoadondao.addHoaDon(hoadon));
//		// ArrayList<SanPham> thongke1 = thongkedao.getTopBanChay();
//		// System.out.println(thongke1.get(0).getTenSP());
//	//	ArrayList<SanPham> sp= thongkedao.getTopBanChay();
//	// System.out.println(sp);
////		 for(SanPham sp : thongke) {
////			 System.out.println(sp.getTenSP());
////			 System.out.println(sp.getSoLuong());
////		 }
//		//SanPham sanpham = new SanPham(147,"Kem Chong Nhuc loai xin",1,20,"Cai" , "Kem.png",1000);
//		
//	//	sanphamdao.suaSanPham(sanpham);
//	//	System.out.println(sanphamdao.getListSanPham());
//	}
}
