/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOTaiKhoan;
import DTO.DTOTaiKhoan;
import GUI.NhanVien_View;
import DAO.DAONhanVien;
import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DTO.DTONhanVien;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author triet
 */
public class BUSNhanVien {
    private DAONhanVien daonhanvien;
    private DAOTaiKhoan daotaikhoan;
    
    public BUSNhanVien (){
       daonhanvien = new DAONhanVien();
       daotaikhoan = new DAOTaiKhoan();
    }
  public BUSNhanVien (DAONhanVien daonhanvien,DAOTaiKhoan daotaikhoan){
      this.daonhanvien=daonhanvien;
      this.daotaikhoan=daotaikhoan;
  }

    public ArrayList<DTOTaiKhoan> getAllTaiKhoan(){
        return daotaikhoan.getListTK();
    }
    public ArrayList<DTONhanVien> getAllNhanVien(){
        return daonhanvien.getNhanVien();
    }
    public String themNhanVien (DTONhanVien nhanvien){
        if(daonhanvien.addNhanvien(nhanvien))
            return "add thành công";
        return"add thất bại";
    }
    public String themTaiKhoan(DTOTaiKhoan taikhoan){
       
        if(daotaikhoan.addTaiKhoan(taikhoan))
            return "add tài khoản thành công";
        return "add tài khoản thất bại";
    }
    public String xoatTaiKhoan(DTOTaiKhoan taiKhoan){
       if(daotaikhoan.deletedTaiKhoan(taiKhoan))
           return "xóa thành công";
       return "xóa thất bại";
    }
    
    public String xoaNhanVien(DTONhanVien Nhanvien){
        if(daonhanvien.deletedNhanvien(Nhanvien))
            return "xóa thành công ";
       return "xóa thất bại";
    }
    
    public String khoaTaiKhoan(DTOTaiKhoan taiKhoan){
        if(daotaikhoan.khoaTaiKhoan(taiKhoan))
            return "khóa thành công";
        return "khóa thất bại";
    }
    
    public String moTaiKhoan(DTOTaiKhoan taiKhoan){
        if(daotaikhoan.moTaiKhoan(taiKhoan))
            return "mở khóa thành công";
        return "mở khóa thất bại";
    }
   
    
}

