/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


import java.util.Date;
/**
 *
 * @author DELL
 */
public class DTOHoaDon {
    private String  maNV, maKH,ThongTinUuDai;
    private Date NgayLap;
    private int maHD,TongTien;

    public DTOHoaDon() {
        this.maHD = 0;
        this.maNV = null;
        this.maKH = null;
        this.TongTien = 0;
        this.ThongTinUuDai = null;
        this.NgayLap = null;
    }

    public DTOHoaDon(int maHD, String maNV, String maKH, Date NgayLap, String ThongTinUuDai ,int TongTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ThongTinUuDai = ThongTinUuDai;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public int getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getThongTinUuDai() {
        return ThongTinUuDai;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setThongTinUuDai(String ThongTinUuDai) {
        this.ThongTinUuDai = ThongTinUuDai;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
    
    
}
