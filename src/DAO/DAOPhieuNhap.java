/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTOHoaDon;
import DTO.DTOPhieuNhap;
import DTO.DTOThongKeSoTien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Statement;


/**
 *
 * @author ASUS
 */
public class DAOPhieuNhap {
    public Connection conn;
    
    public DAOPhieuNhap(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<DTOPhieuNhap> getListPhieuNhap(){
        ArrayList<DTOPhieuNhap> list = new ArrayList<>();
        String sql = "Select * from PhieuNhap";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTOPhieuNhap pn = new DTOPhieuNhap();
                pn.setMaPhieu(rs.getInt(1));
                pn.setMaNV(rs.getString(2));
                pn.setMaNXB(rs.getString(3));
                pn.setNgayNhap(rs.getDate(4));
                pn.setTongTien(rs.getInt(5));
                
                list.add(pn);
            }    
        }
        catch(Exception e){
            e.printStackTrace();   
        }
        return list;
    }
    
    public boolean insertPhieuNhap(DTOPhieuNhap s){
        String sql = "insert into PhieuNhap(MaPhieu,MaNV,MaNXB,NgayNhap,TongTien) values(?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getMaPhieu());
            ps.setString(2,s.getMaNV());
            ps.setString(3,s.getMaNXB());
            ps.setDate(4, new Date(s.getNgayNhap().getTime()));
            ps.setInt(5, s.getTongTien());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deletePhieuNhap(int maphieunhap){
        String sql = "delete from PhieuNhap where MaPhieu = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maphieunhap);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public int getMaxMaPhieuNhap(){
        String sql = "select Max(MaPhieu) from PhieuNhap";
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
    
    public ArrayList<DTOPhieuNhap> TimKiem(String Loai,String From,String To){
        ArrayList<DTOPhieuNhap> list_find = new ArrayList<>();
        try{
            String sql = "select * from PhieuNhap where "+Loai+" between ? and ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, From);
            ps.setString(2, To);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTOPhieuNhap s = new DTOPhieuNhap(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDate(4), rs.getInt(5));
                list_find.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list_find;
    }
    
    public ArrayList<DTOThongKeSoTien> getListThongKe(){
        ArrayList<DTOThongKeSoTien> list = new ArrayList<>();
        String sql = "select MONTH(NgayNhap), YEAR(NgayNhap), SUM(TongTien) from PhieuNhap group by MONTH(NgayNhap), YEAR(NgayNhap)";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                DTOThongKeSoTien s = new DTOThongKeSoTien(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
