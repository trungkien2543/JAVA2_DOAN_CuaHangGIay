/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class TaiKhoan {
    private String MaNhanVien,MatKhau,Email,TrangThai,ChucVu;

    public TaiKhoan() {
        MaNhanVien=null;
        MatKhau=null;
        Email=null;
        TrangThai=null;
        ChucVu=null;
    }

    public TaiKhoan(String MaNhanVien, String MatKhau, String Email, String TrangThai,String ChucVu) {
        this.MaNhanVien = MaNhanVien;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.TrangThai = TrangThai;
        this.ChucVu = ChucVu;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
    
}
