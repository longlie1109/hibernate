package Main;

import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.TaiKhoan;
import DTO.ThongKe;

import GUI.DangNhapGUI;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.UnsupportedLookAndFeelException;

import BUS.ThongKeBUS;
import DAO.*;
public class Main {

//    public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//        new MyConnect();
//
//        changLNF("Nimbus");
//        DangNhapGUI login = new DangNhapGUI();
//        login.showWindow();
//       
//    }
//
//    public static void changLNF(String nameLNF) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if (nameLNF.equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//        }
//    }
	public static void main(String[] args) {
		 new MyConnect();
		//SanPhamDAO sanphamdao = new SanPhamDAO();
		 KhachHangDAO khachhangdao = new KhachHangDAO();
		// ArrayList<SanPham> thongke1 = thongkedao.getTopBanChay();
		// System.out.println(thongke1.get(0).getTenSP());
		 KhachHang kh = new KhachHang();
		System.out.println(khachhangdao.getKhachHang(3).getTen());
//		ArrayList<KhachHang> kh= khachhangdao.getListKhachHang();
//		for(KhachHang sp1 : kh) {
//			System.out.println(sp1.getTen());
//		}
//		 for(SanPham sp : thongke) {
////			 System.out.println(sp.getTenSP());
////			 System.out.println(sp.getSoLuong());
//		 }
		//SanPham sanpham = new SanPham(147,"Kem Chong Nhuc loai xin",1,20,"Cai" , "Kem.png",1000);
		
	//	sanphamdao.suaSanPham(sanpham);
	//	System.out.println(sanphamdao.getListSanPham());
	}
}
