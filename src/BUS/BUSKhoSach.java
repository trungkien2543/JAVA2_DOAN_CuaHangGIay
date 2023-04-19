/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAOKhoSach;
import DTO.DTOKhoSach;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class BUSKhoSach {
    DAOKhoSach ksDAO = new DAOKhoSach();
    
    public ArrayList<DTOKhoSach> getALLSach(){
        return ksDAO.getListSach();
    }
}
