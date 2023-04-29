/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTOKhoSach;
import GUI.KhoSachView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

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
    
    public boolean addSach(DTOKhoSach s){
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
    
     public boolean editSach(DTOKhoSach s){
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
     
    public ArrayList<DTOKhoSach> getListSach(){
        ArrayList<DTOKhoSach> list = new ArrayList<>();
        String sql = "select * from KhoSach";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DTOKhoSach a  = new DTOKhoSach();
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
    
    
    public boolean CongSLBanHang(String masach, int SLTonKho, int SLNhap){
        String sql = "update KhoSach set SoLuongTonKho = ? where MaSach = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, SLTonKho + SLNhap);
            ps.setString(2, masach);
            return ps.executeUpdate() > 0;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public void Database_Excel() throws FileNotFoundException {
        ArrayList<DTOKhoSach> list = new ArrayList<>();
        list = getListSach();
        FileOutputStream file;

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet Sheet = wb.createSheet("KhoSach");
        XSSFRow row = null;
        Cell cell = null;
        row = Sheet.createRow(0);
        int i = 0;
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã sách");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên sách");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Năm xuất bản");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Tên tác giả");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Nhà xuất bản");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Số lượng tồn kho");
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Giá ");
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Thể loại");
        for (DTOKhoSach ks : list) {
            if (ks.getTenSach()!= null) {
                i = i + 1;
                //System.out.println(nxb.getMa());
                row = Sheet.createRow(i);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(ks.getMaSach());
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ks.getTenSach());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ks.getNam());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(ks.getTenTacGia());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(ks.getNhaXuatBan());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(ks.getSl());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(ks.getGia());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(ks.getTheLoai());

            }
        }
        try {
            
            file = new FileOutputStream("KhoSach.xlsx");
            wb.write(file);
            wb.close();
            file.close();

        } catch (IOException ex) {
            Logger.getLogger(DAOKhoSach.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args) {
        new DAOKhoSach();
    }
}
