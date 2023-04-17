/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.KhoSach;
import Model.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**

/**
 *
 * @author DELL
 */
public class DAOKhachHang {
    public Connection con;
    
    
    public DAOKhachHang(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean addKhachHang(KhachHang s){
        String sql = "INSERT INTO KhachHang(MaKH,TenKH,DiaChi,SDT,TichDiem) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaKH());
            ps.setString(2, s.getTenKH());
            ps.setString(3, s.getDiaChi());
            ps.setString(4, s.getSDT());
            ps.setInt(5, s.getTichDiem());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<KhachHang> getListKH(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang";
        try{
            PreparedStatement ps =  con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                KhachHang s = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getInt("TichDiem"));
                list.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean TichDiem(int a, String MaKH){
        String sql = "update KhachHang set TichDiem = ? where MaKH=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setString(2, MaKH);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        new DAOKhachHang();
    }
}
