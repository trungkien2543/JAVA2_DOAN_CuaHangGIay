/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOKhachHang;
import DTO.DTOKhachHang;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BUSKhachHang {
    DAOKhachHang khDAO = new DAOKhachHang();
    
    public ArrayList<DTOKhachHang> getAllKhachHang(){
        return khDAO.getListKH();
    }
    
    public String addKhachHang(DTOKhachHang kh){
        if(khDAO.addKhachHang(kh)){
            return "Thêm khách hàng thành công";
        }
        return "Thêm khách hàng thất bại";
    }
    
    public String updateKhachHang(String SDT,String tenKH,String diaChi,int tichDiem){
        if(khDAO.updateKH(SDT,tenKH, diaChi, tichDiem)){
            return "Update khách hàng thành công";
        }
        return "Update khách hàng thất bại";
    }
}
