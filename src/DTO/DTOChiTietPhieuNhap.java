/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DTOChiTietPhieuNhap {
    private String MaSach,TenSach;
    private int MaPhieu,GiaSach,SLNhap;

    public DTOChiTietPhieuNhap() {
        this.MaPhieu = 0;
        this.MaSach = null;
        this.TenSach = null;
        this.GiaSach = 0;
        this.SLNhap = 0;
    }

    public DTOChiTietPhieuNhap(int MaPhieu, String MaSach, String TenSach, int GiaSach, int SLNhap) {
        this.MaPhieu = MaPhieu;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.GiaSach = GiaSach;
        this.SLNhap = SLNhap;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(int GiaSach) {
        this.GiaSach = GiaSach;
    }

    public int getSLNhap() {
        return SLNhap;
    }

    public void setSLNhap(int SLNhap) {
        this.SLNhap = SLNhap;
    }
    
    
}
