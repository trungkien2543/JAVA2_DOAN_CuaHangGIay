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

/**
 *
 * @author triet
 */
public class BUSNhanVien extends NhanVien_View {
    private DAONhanVien daonhanvien;
    private DAOTaiKhoan daotaikhoan;
    
    public BUSNhanVien (){
       daonhanvien = new DAONhanVien();
       daotaikhoan = new DAOTaiKhoan();
    }
    
    public ArrayList<DTONhanVien> getList(){
        return daonhanvien.getNhanVien();
    }
    public DefaultTableModel timKiem(DefaultTableModel model, List<DTONhanVien> listnv, String selectedItem, String txtTimKiem) {
        switch (selectedItem) {
            case "tìm kiếm theo tên":
                model.setRowCount(0);
                for (DTONhanVien nv : listnv) {
                    if (nv.getTenNV().contains(txtTimKiem)) {
                        Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getQueQuan(), nv.getSoNgayLam(), nv.getCongViec()};
                        model.addRow(rowData);
                    }
                }
                break;

            case "tìm kiếm theo quê quán":
                model.setRowCount(0);
                for (DTONhanVien nv : listnv) {
                    if (nv.getQueQuan().contains(txtTimKiem)) {
                        Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getQueQuan(), nv.getSoNgayLam(), nv.getCongViec()};
                        model.addRow(rowData);
                    }
                }
                break;
            case "tìm kiếm theo công việc":
                model.setRowCount(0);
                for (DTONhanVien nv : listnv) {
                    if (nv.getCongViec().contains(txtTimKiem)) {
                        Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getQueQuan(), nv.getSoNgayLam(), nv.getCongViec()};
                        model.addRow(rowData);
                    }
                }
                break;
            case "tìm kiếm theo mã nhân viên":
                model.setRowCount(0);
                for (DTONhanVien nv : listnv) {
                    if (nv.getMaNV().contains(txtTimKiem)) {
                        Object[] rowData = {nv.getMaNV(), nv.getTenNV(), nv.getQueQuan(), nv.getSoNgayLam(), nv.getCongViec()};
                        model.addRow(rowData);
                    }
                }
                break;
        }
        return model;
    }

    public boolean xoaNhanVien(String maNV, DefaultTableModel model, DefaultTableModel model1, List<DTONhanVien> listnv, List<DTOTaiKhoan> listtk) {
        DTONhanVien nv = null;
        DTOTaiKhoan tk = null;
        for (DTONhanVien nhanVien : listnv) {
            if (nhanVien.getMaNV().equals(maNV)) { // Tìm đối tượng DTONhanVien có mã nhân viên tương ứng trong ArrayList
                nv = nhanVien;
                break;
            }
        }
        for (DTOTaiKhoan taikhoan : listtk) {
            if (taikhoan.getMaNhanVien().equals(maNV)) { // Tìm đối tượng DTONhanVien có mã nhân viên tương ứng trong ArrayList
                tk = taikhoan;
                break;
            }
        }
        if (nv != null) { // Nếu tìm thấy đối tượng DTONhanVien
            if (new DAONhanVien().updateNhanvien(nv) && new DAOTaiKhoan().deletedTaiKhoan(tk)) { // Update dữ liệu trong CSDL SQL
                JOptionPane.showMessageDialog(null, "Xóa thành công.");
                int index = listnv.indexOf(nv); // Tìm vị trí của đối tượng DTONhanVien trong ArrayList
                listnv.remove(index); // Xóa đối tượng DTONhanVien khỏi ArrayList
                model.removeRow(index); // Xóa dòng tương ứng trong table 
                int index1 = listtk.indexOf(tk); // Tìm vị trí của đối tượng taikhoan trong ArrayList
                listtk.remove(index1); // Xóa đối tượng taikhoan khỏi ArrayList
                model1.removeRow(index1); // Xóa dòng tương ứng trong table 
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại.");
            }
        }
        return false;
    }

   
     public boolean blocknhanvien (List <DTOTaiKhoan> listtk, String manv){
          DTOTaiKhoan tk = null;
           for (DTOTaiKhoan taikhoan : listtk) {
               if (taikhoan.getTrangThai().equalsIgnoreCase("mo") && taikhoan.getMaNhanVien().equals(manv)) {
                   tk = taikhoan;
                   break;
               } else if (taikhoan.getTrangThai().equalsIgnoreCase("khóa")) {
                   JOptionPane.showMessageDialog(rootPane, "tài khoản này đã khóa!");
                  return false;
               }
           }
           if (tk != null) { // Nếu tìm thấy đối tượng DTONhanVien

               if (new DAOTaiKhoan().khoaTaiKhoan(tk)) { // Update dữ liệu trong CSDL SQL
                   JOptionPane.showMessageDialog(rootPane, "Khóa thành công");
                 return true;

               } else {
                   JOptionPane.showMessageDialog(rootPane, "Khóa thất bại.");
                   return false;
               }
           }
           return false;
     }
     public boolean unblocknhanvien (List <DTOTaiKhoan> listtk, String manv){
          DTOTaiKhoan tk = null;
           for (DTOTaiKhoan taikhoan : listtk) {
               if (taikhoan.getTrangThai().equalsIgnoreCase("khóa") && taikhoan.getMaNhanVien().equals(manv)) {
                   tk = taikhoan;
                   break;
               } else if (taikhoan.getTrangThai().equalsIgnoreCase("mo")) {
                   JOptionPane.showMessageDialog(rootPane, "tài khoản này đang mở!");
                  return false;
               }
           }
           if (tk != null) { // Nếu tìm thấy đối tượng DTONhanVien

               if (new DAOTaiKhoan().moTaiKhoan(tk)) { // Update dữ liệu trong CSDL SQL
                   JOptionPane.showMessageDialog(rootPane, "mở Khóa thành công");
                 return true;

               } else {
                   JOptionPane.showMessageDialog(rootPane, "mở Khóa thất bại.");
                   return false;
               }
           }
           return false;
     }
}

