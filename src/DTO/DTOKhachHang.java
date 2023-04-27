/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class DTOKhachHang {
    private String MaKH, TenKH, DiaChi, SDT;
    private int TichDiem;

    public DTOKhachHang() {
        this.MaKH = null;
        this.TenKH = null;
        this.DiaChi = null;
        this.SDT = null;
        this.TichDiem = 0;
    }

    public DTOKhachHang(String MaKH, String TenKH, String DiaChi, String SDT, int TichDiem) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TichDiem = TichDiem;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getTichDiem() {
        return TichDiem;
    }

    public void setTichDiem(int TichDiem) {
        this.TichDiem = TichDiem;
    }
    
    
    
    
}
