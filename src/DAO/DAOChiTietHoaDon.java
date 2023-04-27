/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTOChiTietHoaDon;
import DTO.DTOHoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOChiTietHoaDon {
    public Connection conn;
    
    public DAOChiTietHoaDon(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<DTOChiTietHoaDon> getListChiTietHoaDon(){
        ArrayList<DTOChiTietHoaDon> list = new ArrayList<>();
        String sql = "select * from ChiTietHoaDon";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DTOChiTietHoaDon s = new DTOChiTietHoaDon();
                s.setMaHoaDon(rs.getInt(1));
                s.setMaSach(rs.getString(2));
                s.setTenSach(rs.getString(3));
                s.setGiaSach(rs.getInt(4));
                s.setSLMua(rs.getInt(5));
                
                list.add(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public boolean addChiTietHoaDon(DTOChiTietHoaDon s){
        String sql = "insert into ChiTietHoaDon(MaHoaDon,MaSach,TenSach,GiaSach,SLMua) values (?,?,?,?,?) ";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getMaHoaDon());
            ps.setString(2, s.getMaSach());
            ps.setString(3, s.getTenSach());
            ps.setInt(4, s.getGiaSach());
            ps.setInt(5, s.getSLMua());
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        return false;
    }
    
    public boolean deleteChiTietHoaDon(int mahoadon){
        String sql = "delete from ChiTietHoaDon where MaHoaDon = ? ";
        try{
            PreparedStatement ps =  conn.prepareStatement(sql);
            ps.setInt(1, mahoadon);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}
