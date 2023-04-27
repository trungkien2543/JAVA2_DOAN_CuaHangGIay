/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTOPhieuNhap;
import DTO.DTOChiTietPhieuNhap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class DAOChiTietPhieuNhap {
    public Connection conn;
    
    public DAOChiTietPhieuNhap(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<DTOChiTietPhieuNhap> getListChiTietPhieuNhap(){
        ArrayList<DTOChiTietPhieuNhap> list = new ArrayList<>();
        String sql ="Select * from ChiTietPhieuNhap";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTOChiTietPhieuNhap pn = new DTOChiTietPhieuNhap();
                pn.setMaPhieu(rs.getInt(1));
                pn.setMaSach(rs.getString(2));
                pn.setTenSach(rs.getString(3));
                pn.setGiaSach(rs.getInt(4));
                pn.setSLNhap(rs.getInt(5));
                list.add(pn);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addChiTietPhieuNhap(DTOChiTietPhieuNhap s){
        String sql = "insert into ChiTietPhieuNhap(MaPhieu,MaSach,TenSach,GiaSach,SLNhap) values (?,?,?,?,?) ";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getMaPhieu());
            ps.setString(2, s.getMaSach());
            ps.setString(3, s.getTenSach());
            ps.setInt(4, s.getGiaSach());
            ps.setInt(5, s.getSLNhap());
            return ps.executeUpdate() > 0;    
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteChiTietPhieuNhap(int maphieunhap){
        String sql = "delete from ChiTietPhieuNhap where MaPhieu = ? ";
        try{
            PreparedStatement ps =  conn.prepareStatement(sql);
            ps.setInt(1, maphieunhap);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}
