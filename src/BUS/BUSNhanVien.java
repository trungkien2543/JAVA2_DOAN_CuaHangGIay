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
    
    
    public BUSNhanVien (){
       daonhanvien = new DAONhanVien();
       
    }
  public BUSNhanVien (DAONhanVien daonhanvien,DAOTaiKhoan daotaikhoan){
      this.daonhanvien=daonhanvien;
     
  }

   
    public ArrayList<DTONhanVien> getAllNhanVien(){
        return daonhanvien.getNhanVien();
    }
    public String themNhanVien (DTONhanVien nhanvien){
        if(daonhanvien.addNhanvien(nhanvien))
            return "add thành công";
        return"add thất bại";
    }
   
    
    
    public String xoaNhanVien(DTONhanVien Nhanvien){
        if(daonhanvien.deletedNhanvien(Nhanvien))
            return "xóa thành công ";
       return "xóa thất bại";
    }
    
   
    
}

