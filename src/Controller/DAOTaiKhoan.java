/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class DAOTaiKhoan {
    public Connection con;
    
    public DAOTaiKhoan(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public boolean addTaiKhoan(TaiKhoan s){
        String sql = "INSERT INTO TaiKhoan(MaNhanVien,MatKhau,Email,TrangThai) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaNhanVien());   
            ps.setString(2, s.getMatKhau());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getTrangThai());
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
     
     public ArrayList<TaiKhoan> getListTK(){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String sql = "select MaNhanVien,MatKhau,Email,TrangThai,CongViec from TaiKhoan,NhanVien where MaNhanVien=MaNV";
        try{
            PreparedStatement ps =  con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TaiKhoan s = new TaiKhoan(rs.getString("MaNhanVien"), rs.getString("MatKhau"), rs.getString("Email"), rs.getString("TrangThai"),rs.getString("CongViec"));
                list.add(s);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
     }
     
     public boolean TrangThai(String tt,String tk){
         String sql = "update TaiKhoan set TrangThai = ? where MaNhanVien = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, tt);
             ps.setString(2, tk);
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     
     public boolean MatKhau(String mk,String tk){
         String sql = "update TaiKhoan set MatKhau = ? where MaNhanVien = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, mk);
             ps.setString(2, tk);
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return false;
     }
     
     public boolean updateTaiKhoan(TaiKhoan tk) {
    PreparedStatement ps1 = null;
                    boolean result = false;
                    try {
                         ps1 = con.prepareStatement("UPDATE TaiKhoan SET  MatKhau = ?, Email = ?,TrangThai  = ? WHERE MaNhanVien = ?");
                       
                        ps1.setString(1, tk.getMatKhau());
                        ps1.setString(2, tk.getEmail());
                        ps1.setString(3, "khóa");
                        ps1.setString(4, tk.getMaNhanVien() );
                        int rowCount = ps1.executeUpdate();
                        if (rowCount > 0) {
                            result = true;
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    } finally {
                        try {
                            if (ps1 != null) {
                                ps1.close();
                            }
                        } catch (SQLException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                    }
                    return result;
     }
     public static void main(String[] args) {
        new DAOTaiKhoan();
    }
}
