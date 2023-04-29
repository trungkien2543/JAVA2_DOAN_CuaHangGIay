/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.DAOKhoSach;
import DAO.DAONhaXuatBan;
import DTO.DTONhaXuatBan;
import DTO.DTOKhoSach;
import BUS.BUSNhaXuatBan;
import BUS.BUSKhoSach;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class KhoSachView extends javax.swing.JFrame {
    DefaultTableModel model;
    ArrayList<DTOKhoSach> list;
    String path;
    Locale localVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localVN);
    static String MaNV, TenNV;
    
    
    public KhoSachView(String MaNV, String TenNV) {
        initComponents();
        String[] header = {"MaSach", "TenSach", "NamXuatBan", "TenTacGia", "NhaXuatBan", "SoLuongTonKho","Gia","TheLoai"};
        model = new DefaultTableModel(header, 0);
        tbKhoSach.setModel(model);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//phat toan man hinh
        
        //Truy van ra arraylist
        list = new BUSKhoSach().getAllsach();
        ShowTable();
        
        //Thuc hien lay ten va ma nhan vien
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        
        lblHello.setText("Hi " + this.TenNV);

    }

    public void ShowTable(){
        model.setRowCount(0);
        list = new BUSKhoSach().getAllsach();
        for (DTOKhoSach s : list) {
            if(s.getTenSach()==null){
                continue;
            }
            model.addRow(new Object[]{
                s.getMaSach(), s.getTenSach(), s.getNam(), s.getTenTacGia(), s.getNhaXuatBan(), s.getSl(), currencyVN.format(s.getGia()),s.getTheLoai()
            });
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        BackGround = new javax.swing.JPanel();
        BangChon = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        TieuDe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblThayDoiTK = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbKhoSach = new javax.swing.JTable();
        ThanhMenu4 = new javax.swing.JPanel();
        lblHello = new javax.swing.JLabel();
        lbNhanVien4 = new javax.swing.JLabel();
        lbBanSach4 = new javax.swing.JLabel();
        lbNhaCungCap5 = new javax.swing.JLabel();
        lbPhieu10 = new javax.swing.JLabel();
        lbNhapSach4 = new javax.swing.JLabel();
        lbPhieu11 = new javax.swing.JLabel();
        lblBill4 = new javax.swing.JLabel();
        BookStore4 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(204, 204, 204));

        BangChon.setBackground(new java.awt.Color(0, 153, 153));

        txtFind.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFindFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFindFocusLost(evt);
            }
        });
        txtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtFindMouseReleased(evt);
            }
        });
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFindKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 204, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-basket.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 204, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 204, 153));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sua.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(0, 204, 153));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BangChonLayout = new javax.swing.GroupLayout(BangChon);
        BangChon.setLayout(BangChonLayout);
        BangChonLayout.setHorizontalGroup(
            BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangChonLayout.createSequentialGroup()
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BangChonLayout.setVerticalGroup(
            BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangChonLayout.createSequentialGroup()
                .addGroup(BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TieuDe.setBackground(new java.awt.Color(153, 102, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification.png"))); // NOI18N

        lblThayDoiTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        lblThayDoiTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThayDoiTKMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Hệ thống quản lý cửa hàng sách");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel4.setText("jLabel3");

        javax.swing.GroupLayout TieuDeLayout = new javax.swing.GroupLayout(TieuDe);
        TieuDe.setLayout(TieuDeLayout);
        TieuDeLayout.setHorizontalGroup(
            TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TieuDeLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThayDoiTK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        TieuDeLayout.setVerticalGroup(
            TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblThayDoiTK, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbKhoSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSach", "TenSach", "NamXuatBan", "TenTacGia", "NhaXuatBan", "SoLuongTonKho", " Gia", "TheLoai"
            }
        ));
        tbKhoSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhoSachMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbKhoSach);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );

        ThanhMenu4.setBackground(new java.awt.Color(0, 153, 153));

        lblHello.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon minion.png"))); // NOI18N
        lblHello.setText("Hi You");
        lblHello.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHello.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lbNhanVien4.setBackground(new java.awt.Color(0, 204, 204));
        lbNhanVien4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNhanVien4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNhanVien4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Employee.png"))); // NOI18N
        lbNhanVien4.setText("  Nhân viên");
        lbNhanVien4.setToolTipText("");
        lbNhanVien4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNhanVien4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNhanVien4MouseClicked(evt);
            }
        });

        lbBanSach4.setBackground(new java.awt.Color(0, 204, 204));
        lbBanSach4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBanSach4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbBanSach4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BookSales.png"))); // NOI18N
        lbBanSach4.setText("  Bán sách");
        lbBanSach4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBanSach4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBanSach4MouseClicked(evt);
            }
        });

        lbNhaCungCap5.setBackground(new java.awt.Color(0, 204, 204));
        lbNhaCungCap5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNhaCungCap5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNhaCungCap5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Suppliers.png"))); // NOI18N
        lbNhaCungCap5.setText("  Nhà xuất bản");
        lbNhaCungCap5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNhaCungCap5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNhaCungCap5MouseClicked(evt);
            }
        });

        lbPhieu10.setBackground(new java.awt.Color(0, 204, 204));
        lbPhieu10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPhieu10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPhieu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Coupons.png"))); // NOI18N
        lbPhieu10.setText("  Phiếu nhập");
        lbPhieu10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPhieu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPhieu10MouseClicked(evt);
            }
        });

        lbNhapSach4.setBackground(new java.awt.Color(0, 204, 204));
        lbNhapSach4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNhapSach4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNhapSach4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ImportBook.png"))); // NOI18N
        lbNhapSach4.setText("  Nhập sách");
        lbNhapSach4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNhapSach4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNhapSach4MouseClicked(evt);
            }
        });

        lbPhieu11.setBackground(new java.awt.Color(0, 204, 204));
        lbPhieu11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPhieu11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPhieu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Customer.png"))); // NOI18N
        lbPhieu11.setText("  Khách hàng");
        lbPhieu11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPhieu11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPhieu11MouseClicked(evt);
            }
        });

        lblBill4.setBackground(new java.awt.Color(0, 204, 204));
        lblBill4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBill4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBill4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Bill.png"))); // NOI18N
        lblBill4.setText("  Hóa đơn");
        lblBill4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBill4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBill4MouseClicked(evt);
            }
        });

        BookStore4.setBackground(new java.awt.Color(0, 204, 204));
        BookStore4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BookStore4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BookStore4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BookStore.png"))); // NOI18N
        BookStore4.setText(" Cửa hàng sách");
        BookStore4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BookStore4.setOpaque(true);
        BookStore4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookStore4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ThanhMenu4Layout = new javax.swing.GroupLayout(ThanhMenu4);
        ThanhMenu4.setLayout(ThanhMenu4Layout);
        ThanhMenu4Layout.setHorizontalGroup(
            ThanhMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbBanSach4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbNhanVien4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbNhapSach4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbNhaCungCap5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPhieu11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPhieu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBill4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ThanhMenu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BookStore4, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        ThanhMenu4Layout.setVerticalGroup(
            ThanhMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThanhMenu4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblHello, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbNhanVien4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNhapSach4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBanSach4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNhaCungCap5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPhieu11)
                .addGap(18, 18, 18)
                .addComponent(lbPhieu10)
                .addGap(18, 18, 18)
                .addComponent(lblBill4)
                .addGap(18, 18, 18)
                .addComponent(BookStore4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(ThanhMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BangChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BangChon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(ThanhMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhoSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhoSachMouseClicked
        // TODO add your handling code here:
        int selectedrow = tbKhoSach.getSelectedRow();

        txtFind.setText((String) tbKhoSach.getValueAt(selectedrow, 0));
    }//GEN-LAST:event_tbKhoSachMouseClicked

    private void txtFindMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFindMouseReleased
        
    }//GEN-LAST:event_txtFindMouseReleased

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindKeyPressed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        // TODO add your handling code here:
        model.setRowCount(0);
        String find = txtFind.getText();
        
   
        
        for(DTOKhoSach s : list){
            if(s.getTenSach()==null){
                continue;
            }
            if(s.getMaSach().contains(find) || s.getTenSach().contains(find) || String.valueOf(s.getNam()).contains(find) || s.getTenTacGia().contains(find) 
            || s.getNhaXuatBan().contains(find) || String.valueOf(s.getSl()).contains(find) || String.valueOf(s.getGia()).contains(find) || s.getTheLoai().contains(find)){
                model.addRow(new Object[]{
                    s.getMaSach(), s.getTenSach(), s.getNam(), s.getTenTacGia(), s.getNhaXuatBan(), s.getSl(), currencyVN.format(s.getGia()),s.getTheLoai()
            });
            }
        }
                
    }//GEN-LAST:event_txtFindKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String str;
        boolean flag = false;
        do{
            flag = false;
            str = JOptionPane.showInputDialog("Nhap ma sach");
            if(str == null){
                txtFind.requestFocus();
                return;
            }
            if (str.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Chua nhap ma sach");
                flag = true;
            }
            
            for(DTOKhoSach s : list){
                if(s.getMaSach().equals(str) &&s.getTenSach()!=null){
                    JOptionPane.showMessageDialog(this, "Ma sach da ton tai");
                    flag = true;
                }
            }
        }
        while (flag);
        NhapThongTinSach a = new NhapThongTinSach(str);
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        a.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                 ShowTable();
            }   
        });
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String str=txtFind.getText();
        int row = tbKhoSach.getSelectedRow();
        if (row == -1 ){
            JOptionPane.showMessageDialog(rootPane, "Hay chon 1 dong roi an nut sua");
            return;
        }
        else{
            SuaThongTinSach a = new SuaThongTinSach(str);
            a.setVisible(true);
            a.setLocationRelativeTo(null);
            a.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                     ShowTable();
                }   
            });
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tbKhoSach.getSelectedRow();
        if (row == -1 ){
            JOptionPane.showMessageDialog(rootPane, "Hay chon 1 dong roi an nut xoa");
            return ;
        }
        else{
            int dk=JOptionPane.showConfirmDialog(this,"Ban co muon xoa" , "Confirm", JOptionPane.YES_NO_OPTION);
            if(dk!=JOptionPane.YES_OPTION){
            return;
            }
            if(new DAOKhoSach().deleteSach((String) tbKhoSach.getValueAt(row, 0))){
                JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong!");
                list = new DAOKhoSach().getListSach();
                txtFind.setText("");
                ShowTable();
                return ;   
            }
     
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void lblThayDoiTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThayDoiTKMouseClicked
        // TODO add your handling code here:
        SuaTaiKhoan a = new SuaTaiKhoan();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        //this.setVisible(true);
    }//GEN-LAST:event_lblThayDoiTKMouseClicked

    private void lbNhanVien4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhanVien4MouseClicked
        // TODO add your handling code here:
        NhanVien_View a = new NhanVien_View(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhanVien4MouseClicked

    private void lbBanSach4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBanSach4MouseClicked
        // TODO add your handling code here:
        BanHang_View a = new BanHang_View(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbBanSach4MouseClicked

    private void lbNhaCungCap5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhaCungCap5MouseClicked
        // TODO add your handling code here:
        NXB_View a = new NXB_View(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhaCungCap5MouseClicked

    private void lbPhieu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPhieu10MouseClicked
        // TODO add your handling code here:
        PhieuNhap a = new PhieuNhap(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbPhieu10MouseClicked

    private void lbNhapSach4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhapSach4MouseClicked
        // TODO add your handling code here:
        NhapHangView a = new NhapHangView(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhapSach4MouseClicked

    private void lbPhieu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPhieu11MouseClicked
        // TODO add your handling code here:
        KhachHang_View a = new KhachHang_View(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbPhieu11MouseClicked

    private void lblBill4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBill4MouseClicked
        // TODO add your handling code here:
        HoaDon_View a = new HoaDon_View(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBill4MouseClicked

    private void BookStore4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookStore4MouseClicked
        // TODO add your handling code here:
        KhoSachView a = new KhoSachView(MaNV,TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookStore4MouseClicked

    private void txtFindFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtFindFocusGained

    private void txtFindFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindFocusLost

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your handling code here:
        path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if(x == JFileChooser.APPROVE_OPTION){
            path=j.getSelectedFile().getPath();
        }
        System.out.println(path);
        BUSKhoSach ks = new BUSKhoSach();
        ks.Database_Excel(path);
    }//GEN-LAST:event_btnExcelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DTO.DTOKhoSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DTO.DTOKhoSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DTO.DTOKhoSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DTO.DTOKhoSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhoSachView(MaNV,TenNV).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel BangChon;
    private javax.swing.JLabel BookStore4;
    private javax.swing.JPanel ThanhMenu4;
    private javax.swing.JPanel TieuDe;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExcel;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbBanSach4;
    private javax.swing.JLabel lbNhaCungCap5;
    private javax.swing.JLabel lbNhanVien4;
    private javax.swing.JLabel lbNhapSach4;
    private javax.swing.JLabel lbPhieu10;
    private javax.swing.JLabel lbPhieu11;
    private javax.swing.JLabel lblBill4;
    private javax.swing.JLabel lblHello;
    private javax.swing.JLabel lblThayDoiTK;
    private javax.swing.JTable tbKhoSach;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
