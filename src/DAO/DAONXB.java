/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTONXB;
import GUI.NXB_View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class DAONXB {

    public Connection conn;
    DefaultTableModel model;
    private ArrayList<DTONXB> danhSach = new ArrayList<DTONXB>();
    private ArrayList<DTONXB> danhSach1 = new ArrayList<DTONXB>();

    public ArrayList<DTONXB> getDanhSach() {
        return danhSach;
    }

    public DAONXB() {
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
                DTONXB vl = new DTONXB(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
                //danhSach.add(vl);

                danhSach.add(vl);

            }

        } // Handle any errors that may have occurred. // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadDataListToTable(NXB_View nxb_view) {
        String[] header = {"MaNXB", "Ten", "DiaChi", "SDT", "Email"};

        model = new DefaultTableModel(header, 0);
        nxb_view.getjTable_NXB().setModel(model);
        for (DTONXB vl : danhSach) {
            if (vl.getTen() != null) {
                model.addRow(new Object[]{vl.getMa(), vl.getTen(), vl.getDiaChi(), vl.getSoDienThoai(), vl.getEmail()});
            }
        }
    }

    public boolean addNXBToSql(DTONXB nxb) {
        danhSach1.clear();
        try {
            String sql = "SELECT * FROM NhaXuatBan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                DTONXB vl = new DTONXB(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
                //danhSach.add(vl);

                danhSach1.add(vl);

            }

        } // Handle any errors that may have occurred. // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        for (DTONXB nxb1 : danhSach1) {
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

    public boolean EditNXB(DTONXB nxb) {
        for (DTONXB nxb1 : danhSach) {
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

//    public void searchNXB(NXB_View nxb_view) {
//        danhSach.clear();
//        String sql = "SELECT * FROM NhaXuatBan WHERE MaNXB like '%" + nxb_view.getTxtFind().getText() + "%'" + " or Ten like '%" + nxb_view.getTxtFind().getText() + "%'"
//                + " or SDT like '%" + nxb_view.getTxtFind().getText() + "%'" + " or DiaChi like '%" + nxb_view.getTxtFind().getText() + "%'" + " or Email like '%" + nxb_view.getTxtFind().getText() + "%'";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                DTONXB vl = new DTONXB(rs.getString("MaNXB"), rs.getString("Ten"), rs.getString("DiaChi"), rs.getString("SDT"), rs.getString("Email"));
//                //danhSach.add(vl);
//
//                danhSach.add(vl);
//
//            }
//            this.loadDataListToTable(nxb_view);
//        } catch (Exception e) {
//        }
//    }
    public void searchNXB(NXB_View nxb_view) {
        this.loadDataList();
        this.danhSach1.clear();
        for (DTONXB nxb : danhSach) {
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
        for (DTONXB vl : danhSach1) {
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

    public static void main(String args[]) {
        NXB_View test = new NXB_View();

    }
}
