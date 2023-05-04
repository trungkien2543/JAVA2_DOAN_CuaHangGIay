/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTONhaXuatBan;
import GUI.NXB_View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HOME
 */
public class DAONhaXuatBan {

    private NXB_View nxb_view;
    public Connection conn;
    DefaultTableModel model;
    private ArrayList<DTONhaXuatBan> danhSach = new ArrayList<DTONhaXuatBan>();
    private ArrayList<DTONhaXuatBan> danhSach1 = new ArrayList<DTONhaXuatBan>();
    private ArrayList<DTONhaXuatBan> danhSach2 = new ArrayList<DTONhaXuatBan>();

    static String MaNV, TenNV;

    public ArrayList<DTONhaXuatBan> getDanhSach() {
        return danhSach;
    }

    public ArrayList<DTONhaXuatBan> getListNXB() {
        ArrayList<DTONhaXuatBan> list = new ArrayList<>();
        String sql = "select * from NhaXuatBan";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DTONhaXuatBan a = new DTONhaXuatBan();
                a.setMa(rs.getString(1));
                a.setTen(rs.getString(2));
                a.setDiaChi(rs.getString(3));
                a.setSoDienThoai(rs.getString(4));
                a.setEmail(rs.getString(5));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public DAONhaXuatBan() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLCuaHangSach;user=sa;password=123456;" + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2;");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        loadDataList();
    }

    public void loadDataList() {
        danhSach.clear();
        try {
            String sql = "SELECT * FROM NhaXuatBan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                DTONhaXuatBan vl = new DTONhaXuatBan(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
                //danhSach.add(vl);

                danhSach.add(vl);

            }

        } // Handle any errors that may have occurred. // Handle any errors that may have occurred. // Handle any errors that may have occurred. // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadDataListToTable(NXB_View nxb_view) {
        danhSach1.clear();
        String[] header = {"MaNXB", "Ten", "DiaChi", "SDT", "Email"};

        model = new DefaultTableModel(header, 0);
        nxb_view.getjTable_NXB().setModel(model);
        for (DTONhaXuatBan nxb : danhSach) {
            if (nxb.getTen() != null) {
                model.addRow(new Object[]{nxb.getMa(), nxb.getTen(), nxb.getDiaChi(), nxb.getSoDienThoai(), nxb.getEmail()});
                danhSach1.add(nxb);
            }
        }
    }

    public boolean addNXBToSql(DTONhaXuatBan nxb) {
        danhSach1.clear();
        try {
            String sql = "SELECT * FROM NhaXuatBan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                DTONhaXuatBan vl = new DTONhaXuatBan(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
                //danhSach.add(vl);

                danhSach1.add(vl);

            }

        } // Handle any errors that may have occurred. // Handle any errors that may have occurred. // Handle any errors that may have occurred. // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        for (DTONhaXuatBan nxb1 : danhSach1) {
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

    public boolean EditNXB(DTONhaXuatBan nxb) {
        for (DTONhaXuatBan nxb1 : danhSach) {
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
        for (DTONhaXuatBan nxb : danhSach) {
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
        for (DTONhaXuatBan vl : danhSach1) {
            if (vl.getTen() != null) {
                model.addRow(new Object[]{vl.getMa(), vl.getTen(), vl.getDiaChi(), vl.getSoDienThoai(), vl.getEmail()});
            }
        }
    }

    public boolean readExcel() throws IOException {
        danhSach2.clear();
        int i = 1;
        int d = 1;
        String ma = "";
        String ten = "";
        String diachi = "";
        String sdt = "";
        String email = "";
        String st = "";
        JFileChooser filechooser = new JFileChooser();
        filechooser.setMultiSelectionEnabled(false);
        int x = filechooser.showDialog(nxb_view, "Chọn");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = filechooser.getSelectedFile();
            FileInputStream file = new FileInputStream(f);
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
                        DTONhaXuatBan nxb = new DTONhaXuatBan(ma, ten, diachi, sdt, email);
                        danhSach2.add(nxb);
                    } else {
                        i += 1;
                    }

                }
                wb.close();
                file.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn file!");
            return false;
        }
        return true;
    }

    public boolean Excel_Database() {
        loadDataList();
        int d = 0;

        try {
            if (this.readExcel() == true) {
                for (DTONhaXuatBan nxb2 : danhSach2) {
                    int i = 0;
                    for (DTONhaXuatBan nxb : danhSach) {
                        if (nxb2.getMa().equals(nxb.getMa())) {
                            i = i + 1;
                            if (nxb2.getSoDienThoai().matches("[0]{1}[0-9]{9,10}") == false) {
                                JOptionPane.showMessageDialog(null, "Cập nhật mã " + nxb2.getMa() + " thất bại, số diện thoại phải có 10 số!");
                                continue;
                            } else if (nxb2.getEmail().matches("[a-zA-z0-9]{1,}@gmail.com$") == false) {

                                JOptionPane.showMessageDialog(null, "Cập nhật mã " + nxb2.getMa() + " thất bại, sai định dạng Email!");
                                continue;
                            } else if (EditNXB(nxb2)) {
                                d = d + 1;

                            }

                        }
                    }
                    if (i == 0) {
                        if (nxb2.getMa().matches("^NXB-[0-9]{1,}") == false) {
                            JOptionPane.showMessageDialog(null, "Thêm mã " + nxb2.getMa() + " thất bại, sai định dạng mã, mã có dạng NXB-'số' VD: NXB-001");
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
                        }
                    }
                }
            }
            if (d != 0) {
                return true;
            }

        } catch (IOException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int Table_Excel() throws FileNotFoundException {
        int i = 1;
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet Sheet = wb.createSheet("NXB");
        XSSFRow row = null;
        Cell cell = null;
        row = Sheet.createRow(0);
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
        for (DTONhaXuatBan nxb : danhSach1) {
            if (nxb.getTen() != null) {
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
                i = i + 1;

            }
        }
        try {
            JFileChooser filechooser = new JFileChooser();
            filechooser.setMultiSelectionEnabled(false);
            int x = filechooser.showDialog(nxb_view, "Lưu");
            if (x == JFileChooser.APPROVE_OPTION) {
                File f = filechooser.getSelectedFile();
                try (FileOutputStream file = new FileOutputStream(f)) {
                    wb.write(file);
                    wb.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn file!");
                i = 1;
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng đóng file trước khi cập nhật!");
            i = 1;
        }
        return i;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        NXB_View test = new NXB_View(MaNV, TenNV);

    }
}
