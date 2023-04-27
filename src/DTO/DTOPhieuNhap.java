/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DTOPhieuNhap {
    private String MaNV,MaNXB;
    private Date NgayNhap;
    private int MaPhieu,TongTien;
    
    public DTOPhieuNhap(){
        this.MaPhieu=0;
        this.MaNV=null;
        this.MaNXB=null;
        this.NgayNhap=null;
        this.TongTien=0;
    }

    public DTOPhieuNhap(int MaPhieu, String MaNV, String MaNXB, Date NgayNhap, int TongTien) {
        this.MaPhieu = MaPhieu;
        this.MaNV = MaNV;
        this.MaNXB = MaNXB;
        this.NgayNhap = NgayNhap;
        this.TongTien = TongTien;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
}
