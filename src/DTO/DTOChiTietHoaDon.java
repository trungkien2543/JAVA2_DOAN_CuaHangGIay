/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class DTOChiTietHoaDon {
    private String  MaSach, TenSach;
    private int MaHoaDon,GiaSach, SLMua;

    public DTOChiTietHoaDon(int MaHoaDon, String MaSach, String TenSach, int GiaSach, int SLMua) {
        this.MaHoaDon = MaHoaDon;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.GiaSach = GiaSach;
        this.SLMua = SLMua;
    }
    
    public DTOChiTietHoaDon(){
        this.MaHoaDon = 0;
        this.MaSach = null;
        this.TenSach = null;
        this.SLMua = 0;
        this.GiaSach = 0;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public int getGiaSach() {
        return GiaSach;
    }

    public int getSLMua() {
        return SLMua;
    }

    

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setGiaSach(int GiaSach) {
        this.GiaSach = GiaSach;
    }

    public void setSLMua(int SLMua) {
        this.SLMua = SLMua;
    }

    
    
    
    
}
