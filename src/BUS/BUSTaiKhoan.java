/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOTaiKhoan;
import DTO.DTOTaiKhoan;
import java.util.ArrayList;

public class BUSTaiKhoan {
        DAOTaiKhoan tkDAO = new DAOTaiKhoan();
        
        public ArrayList<DTOTaiKhoan> getAllTaiKhoan(){
            return tkDAO.getListTK();
        }
        
        public String addTaiKhoan(DTOTaiKhoan tk){
            if(tkDAO.addTaiKhoan(tk)){
                return "Thêm tài khoản thành công";
            }
             return "Thêm tài khoản thất bại";
        }
        
        public String doiMatKhau(String mk, String maNV){
            if(tkDAO.MatKhau(mk, maNV)){
                return "Thay đổi thành công!";
            }
            return "Thay đổi thất bại!";
        }
        
        
        public String doiMatKhau(String mk,String mkMoi, String mkXN, String maNV){
            if(mk.isEmpty() || mkMoi.isEmpty() || mkXN.isEmpty()){
                return "Không được để trống thống tin";
            }
            if(tkDAO.checkMK(maNV, mk) == false){
                return "Mật khẩu hiện tại không đúng";
            }
            if(!mkMoi.equals(mkXN)){
                return "Mật khẩu mới và mật khẩu xác nhận không khớp";
            }
            if(tkDAO.MatKhau(mkMoi, maNV)){
                return "Thay đổi thành công!";
            }
            return "Thay đổi thất bại!";
        }
        
        public String suaEmail(String nd,String MaNV){
            if(nd.contains("@gmail.com")==false){
                return "Email phải chứ chuỗi @gmail.com";
            }
            if (tkDAO.editEmail(MaNV, nd)){
                return "Sửa thành công";
            }
            return "Sửa thất bại";
        }
        
        public ArrayList<DTOTaiKhoan> getallTaiKhoan(){
             return tkDAO.getListTK();
            }
        public String themTaiKhoan(DTOTaiKhoan taikhoan){
       
        if(tkDAO.addTaiKhoan(taikhoan))
            return "add tài khoản thành công";
        return "add tài khoản thất bại";
    }
        
        public String xoatTaiKhoan(DTOTaiKhoan taiKhoan){
       if(tkDAO.deletedTaiKhoan(taiKhoan))
           return "xóa thành công";
       return "xóa thất bại";
    }
         public String khoaTaiKhoan(DTOTaiKhoan taiKhoan){
        if(tkDAO.khoaTaiKhoan(taiKhoan))
            return "khóa thành công";
        return "khóa thất bại";
    }
    
    public String moTaiKhoan(DTOTaiKhoan taiKhoan){
        if(tkDAO.moTaiKhoan(taiKhoan))
            return "mở khóa thành công";
        return "mở khóa thất bại";
    }
   public String updateTaiKhoan(String Manv,String matkhau,String email,String trangthai){
        if(tkDAO.updateTK(Manv, matkhau, email,trangthai)){
            return "Update tài khoản thành công";
        }
        return "Update tài khoản thất bại";
    }
}
