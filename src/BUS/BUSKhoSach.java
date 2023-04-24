/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DAOKhoSach;
import DTO.DTOKhoSach;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class BUSKhoSach {
    DAOKhoSach ksDAO = new DAOKhoSach();
    public ArrayList<DTOKhoSach> getAllsach(){
        return ksDAO.getListSach();
    }
    public String addSach(DTOKhoSach ks,String kiemtra){
        if(ks.getGia()<=0){
            return "Giá không được bé hơn 0";
        }
        if(ks.getNam()<0){
            return "Năm xuất bản phải lớn hơn 0";
        }
        if(kiemtra.equals("add")){
            if(ksDAO.addSach(ks)){
                return "Thêm thành công";
            }
        }
        else{
            if(ksDAO.editSach(ks)){
                return "Thêm thành công";
            }
        }
        return "Thêm thất bại";
    }
    public String editSach(DTOKhoSach ks){
        if(ks.getGia()<=0){
            return "Giá không được bé hơn 0";
        }
        if(ks.getNam()<0){
            return "Năm xuất bản phải lớn hơn 0";
        }
        if(ksDAO.editSach(ks)){
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }
}
