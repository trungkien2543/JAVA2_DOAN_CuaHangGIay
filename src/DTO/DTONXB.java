/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author HOME
 */
public class DTONXB {
     @Override
    public String toString() {
        return "nxb{" + "ma=" + ma + ", ten=" + ten + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", ghiChu=" + email + '}';
    }
    private String ma;
    private String ten;
    private String diaChi;
    private String soDienThoai;
    private String email;
    
    public DTONXB() {
    }

    public DTONXB(String ma, String ten, String diaChi, String soDienThoai, String email) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
