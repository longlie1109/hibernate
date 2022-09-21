package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
    private int maKH;
    private String ho;
    private String ten;
    private String gioiTinh;
    private int tongChiTieu;

    public KhachHang() {
    }

    public KhachHang(int maKH, String ho, String ten, String gioiTinh, int tongChiTieu) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
    }
<<<<<<< HEAD

    @Id
    @GeneratedValue
    @Column(name="MaKH")
=======
    @Id
    @GeneratedValue
    @Column(name = "MaKH")
>>>>>>> 850a547937ab8d784679ff0ad58904b8fd52cb59
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
<<<<<<< HEAD
    @Column(name="Ho")
=======

    @Column(name = "Ho")
>>>>>>> 850a547937ab8d784679ff0ad58904b8fd52cb59
    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }
<<<<<<< HEAD
    @Column(name="Ten")
=======
    @Column(name = "Ten")
>>>>>>> 850a547937ab8d784679ff0ad58904b8fd52cb59
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
<<<<<<< HEAD
    @Column(name="GioiTinh")
=======
    @Column(name = "GioiTinh")
>>>>>>> 850a547937ab8d784679ff0ad58904b8fd52cb59
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
<<<<<<< HEAD
    @Column(name="TongChiTieu")
=======
    @Column(name = "TongChiTieu")
>>>>>>> 850a547937ab8d784679ff0ad58904b8fd52cb59
    public int getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(int tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }


}
