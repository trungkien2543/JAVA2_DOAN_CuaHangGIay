/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOChiTietHoaDon;
import DTO.DTOChiTietHoaDon;
import DTO.DTOHoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BUSChiTietHoaDon {
    DAOChiTietHoaDon cthd_DAO = new DAOChiTietHoaDon();
    
    ArrayList<DTOChiTietHoaDon> list = new ArrayList<>();
    
    public ArrayList<DTOChiTietHoaDon> getALLChiTietHoaDon(){
        list = cthd_DAO.getListChiTietHoaDon();
        return list;
    }
    
    public ArrayList<DTOChiTietHoaDon> getTheoMaDon(DTOHoaDon hd){
        ArrayList<DTOChiTietHoaDon> list1 = new ArrayList<>();
        for(DTOChiTietHoaDon s : list){
            if(hd.getMaHD() == s.getMaHoaDon()){
                list1.add(s);
            }
        }
        return list1;
    }
    
    public String addChiTietHoaDon(DTOChiTietHoaDon s){
        if(cthd_DAO.addChiTietHoaDon(s)){
            return "Thêm thành công";
        }
        return "Xảy ra lỗi";
    }
    
    public void deleteChiTietHoaDon(DTOHoaDon s){
        if(cthd_DAO.deleteChiTietHoaDon(s.getMaHD())){
            
        }
    }
}
