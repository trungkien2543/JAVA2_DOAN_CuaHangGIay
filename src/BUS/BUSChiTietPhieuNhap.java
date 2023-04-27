/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOChiTietPhieuNhap;
import DAO.DAOPhieuNhap;
import DTO.DTOPhieuNhap;
import DTO.DTOChiTietPhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class BUSChiTietPhieuNhap {
    DAOChiTietPhieuNhap ctpn_DAO = new DAOChiTietPhieuNhap();
    ArrayList<DTOChiTietPhieuNhap> list = new ArrayList<>();
    
    public ArrayList<DTOChiTietPhieuNhap> getALLChiTietPhieuNhap(){
        return ctpn_DAO.getListChiTietPhieuNhap();
    }
    
    public ArrayList<DTOChiTietPhieuNhap> getTheoMaPhieuNhap(DTOPhieuNhap pn){
        ArrayList<DTOChiTietPhieuNhap> list1 = new ArrayList<>();
        for(DTOChiTietPhieuNhap s : list){
            if(pn.getMaPhieu()== s.getMaPhieu()){
                list1.add(s);
            }
        }
        return list1;
    }
    
    public String addChiTietPhieuNhap(DTOChiTietPhieuNhap s){
        if(ctpn_DAO.addChiTietPhieuNhap(s)){
            return "Thêm chi tiết phiếu nhập thành công";
        }
        return "Xảy ra lỗi";
    }
    
    public void deleteChiTietPhieuNhap(DTOPhieuNhap s){
        if(ctpn_DAO.deleteChiTietPhieuNhap(s.getMaPhieu())){
            
        }
    }
    
}
