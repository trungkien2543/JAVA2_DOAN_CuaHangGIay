/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class NhaXuatBan {
    private String ma,ten,diachi,sdt,email;
    public NhaXuatBan(){
        this.ma = null;
        this.ten = null;
        this.diachi = null;
        this.sdt = null;
        this.email = null;
    }

    public NhaXuatBan(String ma, String ten, String diachi, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
