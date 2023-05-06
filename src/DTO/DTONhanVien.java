/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author triet
 */
public class DTONhanVien {
       private String Manv,TenNV,QueQuan,CongViec;
       
      public DTONhanVien (){
        this.Manv = null;
        this.TenNV = null;
        this.QueQuan = null;
        this.CongViec = null;
       
      };
      
      public DTONhanVien (String manv ,String ten,String que,String cvc){
          this.Manv=manv;
          this.TenNV=ten;
          this.QueQuan=que;
          this.CongViec=cvc;
      }

    public String getMaNV() {
        return Manv;
    }

    public void setMaNV(String MaNV) {
        this.Manv = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getCongViec() {
        return CongViec;
    }

    public void setCongViec(String CongViec) {
        this.CongViec = CongViec;
    }
                    
}
