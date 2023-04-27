/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NXB;
import GUI.NXB_View;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HOME
 */
public class DAONXB {

    public Connection conn;
    DefaultTableModel model;
    private ArrayList<NXB> danhSach = new ArrayList<NXB>();
    private ArrayList<NXB> danhSach1 = new ArrayList<NXB>();
    private ArrayList<NXB> danhSach2 = new ArrayList<NXB>();

    public ArrayList<NXB> getDanhSach() {
        return danhSach;
    }

    public DAONXB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");
            loadDataList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void loadDataList() {
        danhSach.clear();
        try {
            String sql = "SELECT * FROM NhaXuatBan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                NXB vl = new NXB(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
                //danhSach.add(vl);

                danhSach.add(vl);

            }

        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadDataListToTable(NXB_View nxb_view) {
        String[] header = {"MaNXB", "Ten", "DiaChi", "SDT", "Email"};

        model = new DefaultTableModel(header, 0);
        nxb_view.getjTable_NXB().setModel(model);
        for (NXB vl : danhSach) {
            if (vl.getTen() != null) {
                model.addRow(new Object[]{vl.getMa(), vl.getTen(), vl.getDiaChi(), vl.getSoDienThoai(), vl.getEmail()});
            }
        }
    }

    public boolean addNXBToSql(NXB nxb) {
        danhSach1.clear();
        try {
            String sql = "SELECT * FROM NhaXuatBan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                NXB vl = new NXB(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
                //danhSach.add(vl);

                danhSach1.add(vl);

            }

        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        for (NXB nxb1 : danhSach1) {
            if (nxb1.getMa().equals(nxb.getMa()) && nxb1.getTen() == null) {
                String sql = "UPDATE NhaXuatBan SET Ten= '" + nxb.getTen() + "' , DiaChi= '" + nxb.getDiaChi() + "' , SDT= '" + nxb.getSoDienThoai() + "' , Email= '" + nxb.getEmail() + "' WHERE MaNXB=?";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, nxb.getMa());
                    return ps.executeUpdate() > 0;
                } catch (Exception e) {
                }

            }
        }
        String sql = "INSERT INTO NhaXuatBan(MaNXB,Ten,DiaChi,SDT,Email) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nxb.getMa());
            ps.setString(2, nxb.getTen());
            ps.setString(3, nxb.getDiaChi());
            ps.setString(4, nxb.getSoDienThoai());
            ps.setString(5, nxb.getEmail());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean deleteNXB(String maNXB) {
        String sql = "UPDATE NhaXuatBan SET Ten=NULL WHERE MaNXB=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNXB);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean deleteAllNXB() {
        loadDataList();
        String sql = "DELETE from NhaXuatBan WHERE MaNXB=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (NXB nxb : danhSach) {

                ps.setString(1, nxb.getMa());
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAONXB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean EditNXB(NXB nxb) {
        for (NXB nxb1 : danhSach) {
            if (nxb1.getMa().equals(nxb.getMa())) {
                if (!nxb.getTen().equals("")) {
                    nxb1.setTen(nxb.getTen());
                }
                if (!nxb.getDiaChi().equals("")) {
                    nxb1.setDiaChi(nxb.getDiaChi());
                }
                if (!nxb.getSoDienThoai().equals("")) {
                    nxb1.setSoDienThoai(nxb.getSoDienThoai());
                }
                if (!nxb.getEmail().equals("")) {
                    nxb1.setEmail(nxb.getEmail());
                }
                String sql = "UPDATE NhaXuatBan SET Ten= '" + nxb1.getTen() + "' , DiaChi= '" + nxb1.getDiaChi() + "' , SDT= '" + nxb1.getSoDienThoai() + "' , Email= '" + nxb1.getEmail() + "' WHERE MaNXB=?";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, nxb1.getMa());
                    return ps.executeUpdate() > 0;
                } catch (Exception e) {
                }

            }
        }

        return false;
    }

    public void searchNXB(NXB_View nxb_view) {
        this.loadDataList();
        this.danhSach1.clear();
        for (NXB nxb : danhSach) {
            if (nxb.getTen() != null) {
                if (nxb.getMa().contains(nxb_view.getTxtFind().getText())) {
                    this.danhSach1.add(nxb);
                } else if (nxb.getTen().contains(nxb_view.getTxtFind().getText())) {
                    this.danhSach1.add(nxb);
                } else if (nxb.getDiaChi().contains(nxb_view.getTxtFind().getText())) {
                    this.danhSach1.add(nxb);
                } else if (nxb.getSoDienThoai().contains(nxb_view.getTxtFind().getText())) {
                    this.danhSach1.add(nxb);
                } else if (nxb.getEmail().contains(nxb_view.getTxtFind().getText())) {
                    this.danhSach1.add(nxb);
                }
            }
        }
        String[] header = {"MaNXB", "Ten", "DiaChi", "SDT", "Email"};

        model = new DefaultTableModel(header, 0);
        nxb_view.getjTable_NXB().setModel(model);
        for (NXB vl : danhSach1) {
            if (vl.getTen() != null) {
                model.addRow(new Object[]{vl.getMa(), vl.getTen(), vl.getDiaChi(), vl.getSoDienThoai(), vl.getEmail()});
            }
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAONXB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readExcel() throws IOException {
        danhSach2.clear();
        int i = 1;
        int d = 1;
        String ma = "";
        String ten = "";
        String diachi = "";
        String sdt = "";
        String email = "";
        String st = "";
        FileInputStream file;
        file = new FileInputStream("NXB.xlsx");
        try (XSSFWorkbook wb = new XSSFWorkbook(file)) {
            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                if (i != 1) {
                    for (Cell cell : row) {
                        st = cell.getStringCellValue();
                        switch (d) {
                            case 1 -> {
                                ma = st;
                                d += 1;
                            }
                            case 2 -> {
                                ten = st;
                                d += 1;
                            }
                            case 3 -> {
                                diachi = st;
                                d += 1;
                            }
                            case 4 -> {
                                sdt = st;
                                d += 1;
                            }
                            case 5 -> {
                                email = st;
                                d = 1;
                            }
                            default -> {
                            }
                        }
                    }
                    NXB nxb = new NXB(ma, ten, diachi, sdt, email);
                    danhSach2.add(nxb);
                } else {
                    i += 1;
                }

            }
            wb.close();
            file.close();
        }
    }

    public boolean Excel_Database() {
        loadDataList();
        int d = 0;

        try {
            this.readExcel();
            for (NXB nxb2 : danhSach2) {
                int i = 0;

                for (NXB nxb : danhSach) {
                    if (nxb2.getMa().equals(nxb.getMa())) {
                        i = i + 1;
                        if (nxb2.getMa().matches("^NXB-[0-9]{1,}") == false) {
                            JOptionPane.showMessageDialog(null, "Cập nhật mã " + nxb2.getMa() + " thất bại, sai định dạng mã, mã có dạng NXB-'số' VD: NXB-1");
                            continue;
                        }
                        if (nxb2.getSoDienThoai().matches("[0]{1}[0-9]{9,10}") == false) {
                            JOptionPane.showMessageDialog(null, "Cập nhật mã " + nxb2.getMa() + " thất bại, số diện thoại phải có 10 số!");
                            continue;
                        }
                        if (nxb2.getEmail().matches("[a-zA-z0-9]{1,}@gmail.com$") == false) {

                            JOptionPane.showMessageDialog(null, "Cập nhật mã " + nxb2.getMa() + " thất bại, sai định dạng Email!");
                            continue;
                        }
                        if (EditNXB(nxb2)) {
                            d = d + 1;
                        }

                    }
                }
                if (i == 0) {
                    if (nxb2.getMa().matches("^NXB-[0-9]{1,}") == false) {
                        JOptionPane.showMessageDialog(null, "Thêm mã " + nxb2.getMa() + " thất bại, sai định dạng mã, mã có dạng NXB-'số' VD: NXB-1");
                        continue;
                    }
                    if (nxb2.getSoDienThoai().matches("[0]{1}[0-9]{9,10}") == false) {
                        JOptionPane.showMessageDialog(null, "Thêm mã " + nxb2.getMa() + " thất bại, số điện thoại phải có 10 số!");
                        continue;
                    }
                    if (nxb2.getEmail().matches("[a-zA-z0-9]{1,}@gmail.com$") == false) {

                        JOptionPane.showMessageDialog(null, "Thêm mã " + nxb2.getMa() + " thất bại, sai định dạng Email!");
                        continue;
                    }
                    if (addNXBToSql(nxb2)) {
                        d = d + 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm mã " + nxb2.getMa() + " thất bại!");
                    }
                }
            }
            if (d != 0) {
                return true;
            }

        } catch (IOException ex) {
            Logger.getLogger(DAONXB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void Database_Excel() throws FileNotFoundException {
        loadDataList();
        FileOutputStream file;

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet Sheet = wb.createSheet("NXB");
        XSSFRow row = null;
        Cell cell = null;
        row = Sheet.createRow(0);
        int i = 0;
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Địa Chỉ");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Số điện thoại");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Email");
        for (NXB nxb : danhSach) {
            if (nxb.getTen() != null) {
                i=i+1;
                //System.out.println(nxb.getMa());
                row = Sheet.createRow(i);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(nxb.getMa());
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(nxb.getTen());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(nxb.getDiaChi());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(nxb.getSoDienThoai());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(nxb.getEmail());

            }
        }
        try {
            file = new FileOutputStream("NXB.xlsx");
            wb.write(file);
            wb.close();
            file.close();
            

        } catch (IOException ex) {
            Logger.getLogger(DAONXB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) throws IOException {
        NXB_View test = new NXB_View();
        new DAONXB().readExcel();

    }
}
