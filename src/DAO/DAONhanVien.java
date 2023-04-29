/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.DTONhanVien;
import static groovy.sql.Sql.NULL;

/**
 *
 * @author triet
 */
public class DAONhanVien {
    public java.sql.Connection con;
    
    
    public DAONhanVien(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
        }
        catch(ClassNotFoundException | SQLException e){
        }
    }
    
    public boolean addNhanvien(DTONhanVien s){
        String sql = "INSERT INTO NhanVien(MaNv,TenNV,QueQuan,SoNgayLam,CongViec) VALUES(?,?,?,0,?)";
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaNV());
            ps.setString(2, s.getTenNV());
            ps.setString(3, s.getQueQuan());
            ps.setString(4, s.getCongViec());
            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
        }
        return false;
    }
    
    public ArrayList<DTONhanVien> getNhanVien(){
        ArrayList<DTONhanVien> list = new ArrayList<>();
        String sql = "select * from NhanVien";
        try{
            PreparedStatement ps =  con.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTONhanVien a  = new DTONhanVien();
                a.setMaNV(rs.getString("MaNV"));
                a.setTenNV(rs.getString("TenNV"));
                a.setQueQuan(rs.getString("QueQuan"));
                a.setSoNgayLam(rs.getInt("SoNgayLam"));
                a.setCongViec(rs.getString("CongViec"));
              if(a.getTenNV() != null) {
                list.add(a);
            }
            }
        }
        catch(SQLException e){
        }
        return list;
    }
     public boolean deletedNhanvien(DTONhanVien nv) {
    PreparedStatement ps1 = null;
                    boolean result = false;
                    try {
                        ps1 = con.prepareStatement("UPDATE nhanvien SET tenNV = ?, queQuan = ?, soNgayLam = ?, congViec = ? WHERE maNV = ?");
                        ps1.setString(1,null );
                        ps1.setString(2, null);
                        ps1.setInt(3, 0);
                        ps1.setString(4, null);
                        ps1.setString(5, nv.getMaNV());
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
        new DAONhanVien();
    }

  
}
