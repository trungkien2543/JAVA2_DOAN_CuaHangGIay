/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTOKhoSach;
import DTO.DTONhaXuatBan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DAONhaXuatBan {
    public Connection conn;
    
    public DAONhaXuatBan(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<DTONhaXuatBan> getListNXB(){
        ArrayList<DTONhaXuatBan> list = new ArrayList<>();
        String sql = "select * from NhaXuatBan";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTONhaXuatBan a  = new DTONhaXuatBan();
                a.setMa(rs.getString(1));
                a.setTen(rs.getString(2));
                a.setDiachi(rs.getString(3));
                a.setSdt(rs.getString(4));
                a.setEmail(rs.getString(5));
                list.add(a);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    public static void main(String[] args) {
        new DAOKhoSach();
        
        ArrayList<DTONhaXuatBan> list =new ArrayList<>();
        list = new DAONhaXuatBan().getListNXB();
        
        for (DTONhaXuatBan s : list){
            System.out.println(s.getTen());
        }
    }
}
