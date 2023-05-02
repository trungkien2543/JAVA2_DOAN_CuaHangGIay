/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class DTOThongKeTheoTheLoai {    
    private String TheLoai;
    private int SLMua;

    public DTOThongKeTheoTheLoai(String TheLoai, int SLMua) {
        this.TheLoai = TheLoai;
        this.SLMua = SLMua;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public int getSLMua() {
        return SLMua;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public void setSLMua(int SLMua) {
        this.SLMua = SLMua;
    }
    
    
    
    
}
