/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAONhaXuatBan;
import DTO.DTONhaXuatBan;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class BUSNhaXuatBan {
    DAONhaXuatBan nxbDAO = new DAONhaXuatBan();
    public ArrayList<DTONhaXuatBan> getAllNXB(){
        return nxbDAO.getListNXB();
    }

}
