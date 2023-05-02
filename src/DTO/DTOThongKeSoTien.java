/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class DTOThongKeSoTien {
    private int SoTien;
    private String Thang,Nam;

    public DTOThongKeSoTien(String Thang, String Nam, int SoTien) {
        this.Thang = Thang;
        this.Nam = Nam;
        this.SoTien = SoTien;
    }

    public String getThang() {
        return Thang;
    }

    public String getNam() {
        return Nam;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public void setNam(String Nam) {
        this.Nam = Nam;
    }

    public void setSoTien(int SoTien) {
        this.SoTien = SoTien;
    }
    
    
    
}
