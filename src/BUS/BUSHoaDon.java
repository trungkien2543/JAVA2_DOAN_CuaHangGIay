/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOHoaDon;
import DTO.DTOHoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BUSHoaDon {
    DAOHoaDon hdDAO = new DAOHoaDon();
    
    public ArrayList<DTOHoaDon> getAllHoaDon(){
        return hdDAO.getListHoaDon();
    }
    
    public String getNewCode(){
        int NewCode = hdDAO.getMaxMaHoaDon()+1;
        return Integer.toString(NewCode);
    }
    
    public String addHoaDon(DTOHoaDon hd){
        if(hdDAO.insertHoaDon(hd)){
            return "Thêm hóa đơn thành công";
        }
        
        return "Thêm thất bại";
    }
    
    public void deleteHoaDon(DTOHoaDon hd){
        if(hdDAO.deleteHoaDon(hd.getMaHD())){
            
        }
    }
    
    public ArrayList<DTOHoaDon> getListTimKiem(String Loai, String From, String To){
        return hdDAO.TimKiem(Loai, From, To);
    }
}
