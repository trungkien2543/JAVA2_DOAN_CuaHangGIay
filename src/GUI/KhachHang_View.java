/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.DAOKhachHang;
import DTO.DTOKhachHang;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class KhachHang_View extends javax.swing.JFrame {

    /**
     * Creates new form DTOKhachHang
     */
    DefaultTableModel tblModel;
    private ArrayList<DTOKhachHang> list  ;
    
    public KhachHang_View() {
        initComponents();
        initData();
        String[] header = {"Mã khách hàng","Tên khách hàng","Địa chỉ","SDT","Tích điểm"};
        tblModel = new DefaultTableModel(header, 0);
        loadData(list);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//phat toan man hinh
        this.setLocationRelativeTo(null);
    }
    
    private void initData(){
        list = new ArrayList<>(new DAOKhachHang().getListKH());
    }
    
    private void loadData(ArrayList<DTOKhachHang> list){
           for (DTO.DTOKhachHang i : list) {
            tblModel.addRow(new Object[]{i.getMaKH(), i.getTenKH(), i.getDiaChi(), i.getSDT(), i.getTichDiem()});
               System.out.println(i.getTichDiem());
            }
            tblKhachHang.setModel(tblModel);
    }
    
    private ArrayList<DTOKhachHang> timKiem(String value, int selected) {
        tblModel.setRowCount(0);
        if (value.isEmpty()) {
            loadData(list);
            return list;
        }
        ArrayList<DTOKhachHang> rs = new ArrayList<>();
        for (DTOKhachHang i : list) {
            switch (selected) {
                case 0:
                    if (Integer.toString(i.getTichDiem()).contains(value)|| 
                         i.getTenKH().contains(value) || i.getMaKH().contains(value)
                            | i.getDiaChi().contains(value)) {
                        rs.add(i);
                    }
                break;
                case 1:
                    if (i.getMaKH().contains(value)) {
                        rs.add(i);
                    }
                    break;
                case 2:
                    if (i.getTenKH().contains(value)) {
                        rs.add(i);
                    }
                    break;
                case 3:
                    try {
                    int input = Integer.parseInt(value);
                    if (i.getTichDiem() == input) {
                        rs.add(i);
                    }

                } catch (Exception e) {
                }
                break;
                case 4:
                    if (i.getDiaChi().contains(value)) {
                        rs.add(i);
                    }
                    break;
            }
        }
        loadData(rs);
        return rs;
    }
    
     private void sapXep(ArrayList<DTOKhachHang> rs, int selected) {
        ArrayList<DTOKhachHang> tmp = new ArrayList<>(rs);
        switch (selected) {
            case 0:
                break;
            case 1:
//                  tang dan
                Collections.sort(tmp,(o1, o2) -> o1.getTichDiem() - o2.getTichDiem());
                break;
            case 2:
//                 giam dan      
                Collections.sort(tmp,(o1, o2) -> o2.getTichDiem()-o1.getTichDiem());
                  break;
        }
        tblModel.setRowCount(0);
        loadData(tmp);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        BangChon = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbDK = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbSX = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        ThanhMenu5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbNhanVien5 = new javax.swing.JLabel();
        lbBanSach4 = new javax.swing.JLabel();
        lbNhaCungCap5 = new javax.swing.JLabel();
        lbPhieu10 = new javax.swing.JLabel();
        lbNhapSach4 = new javax.swing.JLabel();
        lbPhieu11 = new javax.swing.JLabel();
        lblBill4 = new javax.swing.JLabel();
        BookStore4 = new javax.swing.JLabel();
        TieuDe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(204, 204, 204));

        BangChon.setBackground(new java.awt.Color(0, 153, 153));

        txtFind.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tìm kiếm");

        jcbDK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tìm kiếm theo Mã KH", "Tìm kiếm theo tên KH", "Tìm kiếm theo tích điểm", "Tìm kiếm theo địa chỉ" }));
        jcbDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDKActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ĐK Lọc");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sắp xếp");

        jcbSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Sắp xếp theo tích điểm tăng dần", "Sắp xếp theo tích điểm giảm dần" }));
        jcbSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BangChonLayout = new javax.swing.GroupLayout(BangChon);
        BangChon.setLayout(BangChonLayout);
        BangChonLayout.setHorizontalGroup(
            BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangChonLayout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        BangChonLayout.setVerticalGroup(
            BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangChonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind)
                    .addComponent(jLabel1)
                    .addComponent(jcbDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jcbSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Địa chỉ", "SĐT", "Tích điểm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblKhachHang);

        ThanhMenu5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon minion.png"))); // NOI18N
        jLabel13.setText("Hi You");

        lbNhanVien5.setBackground(new java.awt.Color(0, 204, 204));
        lbNhanVien5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNhanVien5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNhanVien5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Employee.png"))); // NOI18N
        lbNhanVien5.setText("  Nhân viên");
        lbNhanVien5.setToolTipText("");
        lbNhanVien5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNhanVien5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNhanVien5MouseClicked(evt);
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
        lbPhieu11.setOpaque(true);
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
        BookStore4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookStore4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ThanhMenu5Layout = new javax.swing.GroupLayout(ThanhMenu5);
        ThanhMenu5.setLayout(ThanhMenu5Layout);
        ThanhMenu5Layout.setHorizontalGroup(
            ThanhMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbBanSach4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbNhanVien5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbNhapSach4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbNhaCungCap5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPhieu11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPhieu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBill4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ThanhMenu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BookStore4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        ThanhMenu5Layout.setVerticalGroup(
            ThanhMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThanhMenu5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbNhanVien5)
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

        TieuDe.setBackground(new java.awt.Color(153, 102, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel4.setText("jLabel3");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Hệ thống quản lý cửa hàng sách");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N

        javax.swing.GroupLayout TieuDeLayout = new javax.swing.GroupLayout(TieuDe);
        TieuDe.setLayout(TieuDeLayout);
        TieuDeLayout.setHorizontalGroup(
            TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        TieuDeLayout.setVerticalGroup(
            TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TieuDeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))))
        );

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(ThanhMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackGroundLayout.createSequentialGroup()
                                .addComponent(BangChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(BangChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
            .addComponent(ThanhMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed

    }//GEN-LAST:event_txtFindActionPerformed

    private void txtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtFindKeyPressed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        // TODO add your handling code here:
         String value = txtFind.getText();
        int selectDK = jcbDK.getSelectedIndex();
        int selectSX = jcbSX.getSelectedIndex();
        ArrayList<DTOKhachHang> rs = timKiem(value, selectDK);
        sapXep(rs, selectSX);
    }//GEN-LAST:event_txtFindKeyReleased

    private void jcbDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDKActionPerformed
        // TODO add your handling code here:
        String value = txtFind.getText();
        int selectDK = jcbDK.getSelectedIndex();
        int selectSX = jcbSX.getSelectedIndex();
        ArrayList<DTOKhachHang> rs = timKiem(value, selectDK);
        sapXep(rs, selectSX);
    }//GEN-LAST:event_jcbDKActionPerformed

    private void jcbSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSXActionPerformed
        // TODO add your handling code here:
         String value = txtFind.getText();
        int selectDK = jcbDK.getSelectedIndex();
        int selectSX = jcbSX.getSelectedIndex();
        ArrayList<DTOKhachHang> rs = timKiem(value, selectDK);
        sapXep(rs, selectSX);
    }//GEN-LAST:event_jcbSXActionPerformed

    private void lbNhanVien5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhanVien5MouseClicked
        // TODO add your handling code here:
        NhanVien_View a = new NhanVien_View();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhanVien5MouseClicked

    private void lbBanSach4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBanSach4MouseClicked
        // TODO add your handling code here:
        BanHang_View a = new BanHang_View();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbBanSach4MouseClicked

    private void lbNhaCungCap5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhaCungCap5MouseClicked
        // TODO add your handling code here:
        NXB_View a = new NXB_View();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhaCungCap5MouseClicked

    private void lbPhieu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPhieu10MouseClicked
        // TODO add your handling code here:
        PhieuNhap a = new PhieuNhap();
        a.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_lbPhieu10MouseClicked

    private void lbNhapSach4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhapSach4MouseClicked
        // TODO add your handling code here:
        NhapHangView a = new NhapHangView();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhapSach4MouseClicked

    private void lbPhieu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPhieu11MouseClicked
        // TODO add your handling code here:
        KhachHang_View a = new KhachHang_View();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbPhieu11MouseClicked

    private void lblBill4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBill4MouseClicked
        // TODO add your handling code here:
        HoaDon_View a = new HoaDon_View();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBill4MouseClicked

    private void BookStore4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookStore4MouseClicked
        // TODO add your handling code here:
        KhoSachView a = new KhoSachView();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookStore4MouseClicked
    
    
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
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel BangChon;
    private javax.swing.JLabel BookStore4;
    private javax.swing.JPanel ThanhMenu5;
    private javax.swing.JPanel TieuDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcbDK;
    private javax.swing.JComboBox<String> jcbSX;
    private javax.swing.JLabel lbBanSach4;
    private javax.swing.JLabel lbNhaCungCap5;
    private javax.swing.JLabel lbNhanVien5;
    private javax.swing.JLabel lbNhapSach4;
    private javax.swing.JLabel lbPhieu10;
    private javax.swing.JLabel lbPhieu11;
    private javax.swing.JLabel lblBill4;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

    private Object DAOKhachHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
