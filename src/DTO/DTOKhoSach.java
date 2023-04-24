/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
/**
 *
 * @author DELL
 */
public class DTOKhoSach {
    private String MaSach, TenSach, TenTacGia, NhaXuatBan, TheLoai;
    private int nam, sl;
    private int gia;
    
    public DTOKhoSach(){
        this.MaSach = null;
        this.TenSach = null;
        this.TenTacGia = null;
        this.NhaXuatBan = null;
        this.TheLoai = null;
        this.nam = 0;
        this.gia = 0;
        this.sl = 0;
    }

    public DTOKhoSach(String MaSach, String TenSach, String TenTacGia, String NhaXuatBan, String TheLoai, int nam, int gia) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTacGia = TenTacGia;
        this.NhaXuatBan = NhaXuatBan;
        this.TheLoai = TheLoai;
        this.nam = nam;
        this.sl = 0;
        this.gia = gia;
    }

    
    public int getSl() {
        return sl;
    }

    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public int getNam() {
        return nam;
    }

    public int getGia() {
        return gia;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public double thanhtien(int sl_mua){
        return sl_mua*this.getGia();
    }
}
