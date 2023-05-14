/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUSChiTietHoaDon;
import BUS.BUSHoaDon;
import BUS.BUSPhieuNhap;
import DTO.DTOThongKeSoTien;
import DTO.DTOThongKeTheoTheLoai;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author ASUS
 */
public class ThongKeView extends javax.swing.JFrame {
    
    static String MaNV, TenNV;
    
    
    ArrayList<DTOThongKeTheoTheLoai> listTL =  new BUSChiTietHoaDon().getListThongKeTheoTL();
    ArrayList<DTOThongKeSoTien> listDT = new BUSHoaDon().getListThongKe();
    ArrayList<DTOThongKeSoTien> listTN = new BUSPhieuNhap().getListThongKe();
            
    public ThongKeView(String MaNV, String TenNV) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);//phat toan man hinh
        setDataToChartTKTheoTL(jpThongKeTheoTheLoai);
        setDataToChartTKTheoDT(jpThongKeTheoDoanhThu);
        setDataToChartTKTheoTN(jpThongKeTheoTienhNhap);
        lblHello.setText("Hi " + this.TenNV);
        
        
    }
    
    
    public void setDataToChartTKTheoTL(JPanel jpnItem) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        if (listTL != null) {
            for (DTOThongKeTheoTheLoai item : listTL) {
                dataset.setValue(item.getTheLoai(), Double.valueOf(item.getSLMua()));
            }
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Biểu đồ thống kê số lượng sách bán theo thể loại".toUpperCase(),
                dataset,  true, true, false);
        /*
            legend: nếu là true, hiển thị chú thích cho biểu đồ.
            tooltips: nếu là true, hiển thị thông tin chi tiết khi di chuột vào từng phần tử của biểu đồ.
            urls: nếu là true, cho phép click vào từng phần tử của biểu đồ để chuyển hướng đến một trang web khác.        
        */

        ChartPanel chartPanel = new ChartPanel(pieChart);
        jpnItem.removeAll();
        jpnItem.setLayout(new BorderLayout());
        jpnItem.add(chartPanel);
    } 
    
    
    public void setDataToChartTKTheoDT(JPanel jpnItem){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listDT != null){
            for(DTOThongKeSoTien s : listDT){
                dataset.addValue(s.getSoTien(), "Tổng tiền", s.getThang()+"/"+s.getNam());
            }
            
            JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ biểu thị doanh thu theo tháng năm".toUpperCase(),"Thời gian", "Số tiền", dataset, PlotOrientation.VERTICAL, false, true, false);
            
            ChartPanel chartPanel = new ChartPanel(barChart);
            
            jpnItem.removeAll();
            jpnItem.setLayout(new BorderLayout());
            jpnItem.add(chartPanel);
        
        }
    }
    
    public void setDataToChartTKTheoTN(JPanel jpnItem){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listTN != null){
            for(DTOThongKeSoTien s : listTN){
                System.out.println(s.getSoTien());
                dataset.addValue(s.getSoTien(), "Tổng tiền", s.getThang()+"/"+s.getNam());
            }
            
            JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ biểu thị tiền nhập theo tháng năm".toUpperCase(),"Thời gian", "Số tiền", dataset, PlotOrientation.VERTICAL, false, true, false);
            
            ChartPanel chartPanel = new ChartPanel(barChart);
            
            jpnItem.removeAll();
            jpnItem.setLayout(new BorderLayout());
            jpnItem.add(chartPanel);
        
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
        TieuDe = new javax.swing.JPanel();
        lblThayDoiTK = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        BookStore5 = new javax.swing.JLabel();
        jpThongKeTheoTienhNhap = new javax.swing.JPanel();
        jpThongKeTheoTheLoai = new javax.swing.JPanel();
        jpThongKeTheoDoanhThu = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(204, 204, 204));

        TieuDe.setBackground(new java.awt.Color(153, 102, 0));

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
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TieuDeLayout = new javax.swing.GroupLayout(TieuDe);
        TieuDe.setLayout(TieuDeLayout);
        TieuDeLayout.setHorizontalGroup(
            TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TieuDeLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1017, Short.MAX_VALUE)
                .addComponent(lblThayDoiTK)
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
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        BookStore4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookStore4MouseClicked(evt);
            }
        });

        BookStore5.setBackground(new java.awt.Color(0, 204, 204));
        BookStore5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BookStore5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BookStore5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trend.png"))); // NOI18N
        BookStore5.setText("Thống kê");
        BookStore5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BookStore5.setOpaque(true);
        BookStore5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookStore5MouseClicked(evt);
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
            .addComponent(lbNhaCungCap5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
            .addComponent(lbPhieu11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPhieu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBill4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BookStore5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BookStore4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(BookStore5)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpThongKeTheoTienhNhapLayout = new javax.swing.GroupLayout(jpThongKeTheoTienhNhap);
        jpThongKeTheoTienhNhap.setLayout(jpThongKeTheoTienhNhapLayout);
        jpThongKeTheoTienhNhapLayout.setHorizontalGroup(
            jpThongKeTheoTienhNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpThongKeTheoTienhNhapLayout.setVerticalGroup(
            jpThongKeTheoTienhNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpThongKeTheoTheLoaiLayout = new javax.swing.GroupLayout(jpThongKeTheoTheLoai);
        jpThongKeTheoTheLoai.setLayout(jpThongKeTheoTheLoaiLayout);
        jpThongKeTheoTheLoaiLayout.setHorizontalGroup(
            jpThongKeTheoTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpThongKeTheoTheLoaiLayout.setVerticalGroup(
            jpThongKeTheoTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpThongKeTheoDoanhThuLayout = new javax.swing.GroupLayout(jpThongKeTheoDoanhThu);
        jpThongKeTheoDoanhThu.setLayout(jpThongKeTheoDoanhThuLayout);
        jpThongKeTheoDoanhThuLayout.setHorizontalGroup(
            jpThongKeTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpThongKeTheoDoanhThuLayout.setVerticalGroup(
            jpThongKeTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(ThanhMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpThongKeTheoTheLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(jpThongKeTheoTienhNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpThongKeTheoDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpThongKeTheoTienhNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpThongKeTheoDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpThongKeTheoTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(ThanhMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThayDoiTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThayDoiTKMouseClicked
        // TODO add your handling code here:
        SuaTaiKhoan a = new SuaTaiKhoan(MaNV,TenNV);
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
        KhoSachView a = new KhoSachView(MaNV, TenNV);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookStore4MouseClicked

    private void BookStore5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookStore5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BookStore5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_jLabel4MouseClicked

   
    
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
                new ThongKeView(MaNV,TenNV).setVisible(true);
                
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JLabel BookStore4;
    private javax.swing.JLabel BookStore5;
    private javax.swing.JPanel ThanhMenu4;
    private javax.swing.JPanel TieuDe;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jpThongKeTheoDoanhThu;
    private javax.swing.JPanel jpThongKeTheoTheLoai;
    private javax.swing.JPanel jpThongKeTheoTienhNhap;
    private javax.swing.JLabel lbBanSach4;
    private javax.swing.JLabel lbNhaCungCap5;
    private javax.swing.JLabel lbNhanVien4;
    private javax.swing.JLabel lbNhapSach4;
    private javax.swing.JLabel lbPhieu10;
    private javax.swing.JLabel lbPhieu11;
    private javax.swing.JLabel lblBill4;
    private javax.swing.JLabel lblHello;
    private javax.swing.JLabel lblThayDoiTK;
    // End of variables declaration//GEN-END:variables
}
