/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.DTOHoaDon;
import GUI.HoaDon_View;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class DAOHoaDon {
    
    public Connection conn;
    
    public DAOHoaDon(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public ArrayList<DTOHoaDon> getListHoaDon(){
        ArrayList<DTOHoaDon> list = new ArrayList<>();
        String sql = "select * from HoaDon";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                DTOHoaDon hd = new DTOHoaDon();
            
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setNgayLap(rs.getDate(4));
                hd.setThongTinUuDai(rs.getString(5));
                hd.setTongTien(rs.getInt(6));
                
               
                
               
                
                
                
                list.add(hd);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        return list;
    }
    
    public boolean insertHoaDon(DTOHoaDon s){
        String sql = "insert into HoaDon(MaHoaDon,MaNV,MaKH,NgayLap,ThongTinUuDai,TongTien) values (?,?,?,?,?,?) ";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getMaHD());
            ps.setString(2, s.getMaNV());
            ps.setString(3, s.getMaKH());
            ps.setDate(4, new Date(s.getNgayLap().getTime()));
            ps.setString(5, s.getThongTinUuDai());
            ps.setInt(6, s.getTongTien());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteHoaDon(int mahoadon){
        String sql = "delete from HoaDon where MaHoaDon = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mahoadon);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public int getMaxMaHoaDon(){
        String sql = "select Max(MaHoaDon) from HoaDon";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public ArrayList<DTOHoaDon> TimKiem(String Loai,String From,String To){
        ArrayList<DTOHoaDon> list_find = new ArrayList<>();
        try{
            String sql = "select * from HoaDon where "+Loai+" between ? and ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, From);
            ps.setString(2, To);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTOHoaDon s = new DTOHoaDon(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5), rs.getInt(6));
                list_find.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list_find;
    }
    
    public static void main(String[] args) {
        DAOHoaDon s = new DAOHoaDon();
        
        System.out.println(s.getMaxMaHoaDon());
    }
            
}
