/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.KhoSach;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAOKhoSach {
    public Connection conn;
    
    public DAOKhoSach(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean addSach(KhoSach s){
        String sql = "INSERT INTO KhoSach(MaSach,TenSach,NamXuatBan,TenTacGia,NhaXuatBan,SoLuongTonKho,Gia,TheLoai) VALUES(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setInt(3, s.getNam());
            ps.setString(4, s.getTenTacGia());
            ps.setString(5, s.getNhaXuatBan());
            ps.setInt(6,s.getSl());
            ps.setFloat(7, s.getGia());
            ps.setString(8, s.getTheLoai());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean deleteSach(String masach){
        String sql = "update  KhoSach set TenSach=NULL,NamXuatBan=NULL,TenTacGia=NULL,NhaXuatBan=NULl,SoLuongTonKho=NULL,Gia=NULL,TheLoai=NULL"+" where MaSach=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, masach);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean editSach(KhoSach s){
        String sql = "update  KhoSach set TenSach = ?,NamXuatBan=?,TenTacGia=?,NhaXuatBan=?,SoLuongTonKho = 0,Gia=?,TheLoai=? where MaSach=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getTenSach());
            ps.setInt(2, s.getNam());
            ps.setString(3, s.getTenTacGia());
            ps.setString(4, s.getNhaXuatBan());
            ps.setInt(5, s.getGia());
            ps.setString(6, s.getTheLoai());
            ps.setString(7, s.getMaSach());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
     }
     
    public ArrayList<KhoSach> getListSach(){
        ArrayList<KhoSach> list = new ArrayList<>();
        String sql = "select * from KhoSach";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhoSach a  = new KhoSach();
                a.setMaSach(rs.getString("MaSach"));
                a.setTenSach(rs.getString("TenSach"));
                a.setNam(rs.getInt("NamXuatBan"));
                a.setTenTacGia(rs.getString("TenTacGia"));
                a.setNhaXuatBan(rs.getString("NhaXuatBan"));
                a.setSl(rs.getInt("SoLuongTonKho"));
                a.setGia(rs.getInt("Gia"));
                a.setTheLoai(rs.getString("TheLoai"));
                
                list.add(a);
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public boolean TruSLBanHang(String masach, int SLTonKho, int SLMua){
        String sql = "update KhoSach set SoLuongTonKho = ? where MaSach = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, SLTonKho - SLMua);
            ps.setString(2, masach);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public static void main(String[] args) {
        new DAOKhoSach();
    }
}
