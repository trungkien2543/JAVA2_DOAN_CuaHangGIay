/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.DAONXB;
import Controller.NXBListener;
import Model.NXB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class NXB_View extends javax.swing.JFrame {

    private JLabel jlabelMa;
    private JLabel jlabelTen;
    private JLabel jlabelDiaChi;
    private JLabel jlabelSDT;
    private JLabel jlabelEmail;
    private JTextField JtextfieldMa;
    private JTextField JtextfieldTen;
    private JTextField JtextfieldDiaChi;
    private JTextField JtextfieldSDT;
    private JTextField JtextfieldEmail;
    private JButton jbutton_ok;
    private JLabel jlabelTitle;
    DAONXB dao = new DAONXB();
    private JLabel jlabelEditTitle;
    private JLabel jlabelEditMa;
    private JLabel jlabelEditTen;
    private JLabel jlabelEditDiaChi;
    private JLabel jlabelEditSDT;
    private JLabel jlabelEditEmail;
    private JTextField JtextfieldEditMa;
    private JTextField JtextfieldEditTen;
    private JTextField JtextfieldEditDiaChi;
    private JTextField JtextfieldEditSDT;
    private JTextField JtextfieldEditEmail;
    private JButton jButton_ok2;
   
    private String id;

    public JFrame getjFrameAddNXB() {
        return jFrameAddNXB;
    }

    /**
     * Creates new form NhapHang
     */
    public NXB_View() {

        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);//phat toan man hinh
        dao.loadDataListToTable(this);
        this.setVisible(true);
        initJFrameAdd();
        initFrameEdit();

    }

    public JTable getjTable_NXB() {
        return jTable_NXB;
    }

    public void initJFrameAdd() {
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        jFrameAddNXB.setSize(383, 210);
        jFrameAddNXB.setLocationRelativeTo(null);
        jPanelAddData.setLayout(new GridLayout(5, 2));
        jPanelAddOK.setLayout(new BorderLayout());
        jPanelAddTitle.setLayout(new BorderLayout());
        jlabelTitle = new JLabel("Vui lòng nhập thông tin nhà xuất bản", JLabel.CENTER);
        jlabelTitle.setFont(font);
        jlabelMa = new JLabel("Mã NXB");
        jlabelMa.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelMa.setFont(font);
        jlabelTen = new JLabel("Tên");
        jlabelTen.setFont(font);
        jlabelTen.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelDiaChi = new JLabel("Địa chỉ");
        jlabelDiaChi.setFont(font);
        jlabelDiaChi.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelSDT = new JLabel("Số điện thoại");
        jlabelSDT.setFont(font);
        jlabelSDT.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelEmail = new JLabel("Email");
        jlabelEmail.setFont(font);
        jlabelEmail.setBorder(BorderFactory.createLineBorder(Color.black));
        JtextfieldMa = new JTextField();
        JtextfieldTen = new JTextField();
        JtextfieldDiaChi = new JTextField();
        JtextfieldSDT = new JTextField();
        JtextfieldEmail = new JTextField();
        jbutton_ok = new JButton("OK");
        ActionListener ac = new NXBListener(this, this.dao);
        jbutton_ok.addActionListener(ac);
        jbutton_ok.setFont(font);
        jPanelAddTitle.add(jlabelTitle);
        jPanelAddData.add(jlabelMa);
        jPanelAddData.add(JtextfieldMa);
        jPanelAddData.add(jlabelTen);
        jPanelAddData.add(JtextfieldTen);
        jPanelAddData.add(jlabelDiaChi);
        jPanelAddData.add(JtextfieldDiaChi);
        jPanelAddData.add(jlabelSDT);
        jPanelAddData.add(JtextfieldSDT);
        jPanelAddData.add(jlabelEmail);
        jPanelAddData.add(JtextfieldEmail);
        jPanelAddOK.add(jbutton_ok);

    }

   

    public JButton getJbutton_ok() {
        return jbutton_ok;
    }

    public JButton getjButton_ok2() {
        return jButton_ok2;
    }

    public NXB dataJFrameAdd() {
        String ma = JtextfieldMa.getText();
        String ten = JtextfieldTen.getText();
        String diachi = JtextfieldDiaChi.getText();
        String sdt = JtextfieldSDT.getText();
        String email = JtextfieldEmail.getText();
        NXB nxb1 = null;
        if (ma.matches("^NXB-[0-9]{1,}") == false) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai định dạng mã, mã có dạng NXB-'số' VD: NXB-1");
            return nxb1;
        }
        if (sdt.matches("[0]{1}[0-9]{9,10}") == false) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai số điện thoại!");
            return nxb1;
        }
        if (email.matches("[a-zA-z0-9]{1,}@gmail.com$") == false) {

            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai định dạng Email!");
            return nxb1;
        }
        NXB nxb = new NXB(ma, ten, diachi, sdt, email);
        return nxb;
    }

    

   

    public void initFrameEdit() {
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        jFrameEdit.setSize(383, 220);
        jFrameEdit.setLocationRelativeTo(null);
        jPanelEdit2.setLayout(new GridLayout(5, 2));
        jPanelEdit3.setLayout(new BorderLayout());
        jPanelEdit1.setLayout(new BorderLayout());
        jlabelEditTitle = new JLabel("Vui lòng nhập mã NXB và thông tin cần sửa", JLabel.CENTER);
        jlabelEditTitle.setFont(font);
        jlabelEditMa = new JLabel("Mã NXB");
        jlabelEditMa.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelEditMa.setFont(font);
        jlabelEditTen = new JLabel("Tên");
        jlabelEditTen.setFont(font);
        jlabelEditTen.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelEditDiaChi = new JLabel("Địa chỉ");
        jlabelEditDiaChi.setFont(font);
        jlabelEditDiaChi.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelEditSDT = new JLabel("Số điện thoại");
        jlabelEditSDT.setFont(font);
        jlabelEditSDT.setBorder(BorderFactory.createLineBorder(Color.black));
        jlabelEditEmail = new JLabel("Email");
        jlabelEditEmail.setFont(font);
        jlabelEditEmail.setBorder(BorderFactory.createLineBorder(Color.black));
        JtextfieldEditMa = new JTextField();
        JtextfieldEditTen = new JTextField();
        JtextfieldEditDiaChi = new JTextField();
        JtextfieldEditSDT = new JTextField();
        JtextfieldEditEmail = new JTextField();
        jButton_ok2 = new JButton("OK");
        ActionListener ac = new NXBListener(this, this.dao);
        jButton_ok2.addActionListener(ac);
        jButton_ok2.setFont(font);
        jPanelEdit1.add(jlabelEditTitle);
        jPanelEdit2.add(jlabelEditMa);
        jPanelEdit2.add(JtextfieldEditMa);
        jPanelEdit2.add(jlabelEditTen);
        jPanelEdit2.add(JtextfieldEditTen);
        jPanelEdit2.add(jlabelEditDiaChi);
        jPanelEdit2.add(JtextfieldEditDiaChi);
        jPanelEdit2.add(jlabelEditSDT);
        jPanelEdit2.add(JtextfieldEditSDT);
        jPanelEdit2.add(jlabelEditEmail);
        jPanelEdit2.add(JtextfieldEditEmail);
        jPanelEdit3.add(jButton_ok2);

    }

    public NXB dataJFrameEdit() {
        String ma = JtextfieldEditMa.getText();
        String ten = JtextfieldEditTen.getText();
        String diachi = JtextfieldEditDiaChi.getText();
        String sdt = JtextfieldEditSDT.getText();
        String email = JtextfieldEditEmail.getText();
        NXB nxb1 = null;      
        if ((sdt.matches("[0]{1}[0-9]{9,10}") == false) && !sdt.equals("")) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại, sai định dạng số điện thoại!");
            return nxb1;
        }
        if (email.matches("[a-zA-z0-9]{1,}@gmail.com$") == false && !email.equals("")) {

            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai định dạng Email!");
            return nxb1;
        }
        NXB nxb = new NXB(ma, ten, diachi, sdt, email);
        return nxb;
    }

    public JFrame getjFrameEdit() {
        return jFrameEdit;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameAddNXB = new javax.swing.JFrame();
        jPanelAddData = new javax.swing.JPanel();
        jPanelAddOK = new javax.swing.JPanel();
        jPanelAddTitle = new javax.swing.JPanel();
        jFrameEdit = new javax.swing.JFrame();
        jPanelEdit1 = new javax.swing.JPanel();
        jPanelEdit3 = new javax.swing.JPanel();
        jPanelEdit2 = new javax.swing.JPanel();
        BackGround = new javax.swing.JPanel();
        TieuDe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTabbedPane_NXB = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_NXB = new javax.swing.JTable();
        BangChon = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        ThanhMenu4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbNhanVien4 = new javax.swing.JLabel();
        lbBanSach4 = new javax.swing.JLabel();
        lbNhaCungCap5 = new javax.swing.JLabel();
        lbPhieu10 = new javax.swing.JLabel();
        lbNhapSach4 = new javax.swing.JLabel();
        lbPhieu11 = new javax.swing.JLabel();
        lblBill4 = new javax.swing.JLabel();
        BookStore4 = new javax.swing.JLabel();

        jFrameAddNXB.setTitle("Add_NXB");

        jPanelAddData.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanelAddDataLayout = new javax.swing.GroupLayout(jPanelAddData);
        jPanelAddData.setLayout(jPanelAddDataLayout);
        jPanelAddDataLayout.setHorizontalGroup(
            jPanelAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        jPanelAddDataLayout.setVerticalGroup(
            jPanelAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        jPanelAddOK.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanelAddOKLayout = new javax.swing.GroupLayout(jPanelAddOK);
        jPanelAddOK.setLayout(jPanelAddOKLayout);
        jPanelAddOKLayout.setHorizontalGroup(
            jPanelAddOKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelAddOKLayout.setVerticalGroup(
            jPanelAddOKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanelAddTitle.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanelAddTitleLayout = new javax.swing.GroupLayout(jPanelAddTitle);
        jPanelAddTitle.setLayout(jPanelAddTitleLayout);
        jPanelAddTitleLayout.setHorizontalGroup(
            jPanelAddTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelAddTitleLayout.setVerticalGroup(
            jPanelAddTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrameAddNXBLayout = new javax.swing.GroupLayout(jFrameAddNXB.getContentPane());
        jFrameAddNXB.getContentPane().setLayout(jFrameAddNXBLayout);
        jFrameAddNXBLayout.setHorizontalGroup(
            jFrameAddNXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAddOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelAddTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelAddData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameAddNXBLayout.setVerticalGroup(
            jFrameAddNXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameAddNXBLayout.createSequentialGroup()
                .addComponent(jPanelAddTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAddData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAddOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEdit1.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanelEdit1Layout = new javax.swing.GroupLayout(jPanelEdit1);
        jPanelEdit1.setLayout(jPanelEdit1Layout);
        jPanelEdit1Layout.setHorizontalGroup(
            jPanelEdit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEdit1Layout.setVerticalGroup(
            jPanelEdit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        jPanelEdit3.setBackground(new java.awt.Color(153, 204, 0));

        javax.swing.GroupLayout jPanelEdit3Layout = new javax.swing.GroupLayout(jPanelEdit3);
        jPanelEdit3.setLayout(jPanelEdit3Layout);
        jPanelEdit3Layout.setHorizontalGroup(
            jPanelEdit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEdit3Layout.setVerticalGroup(
            jPanelEdit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        jPanelEdit2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanelEdit2Layout = new javax.swing.GroupLayout(jPanelEdit2);
        jPanelEdit2.setLayout(jPanelEdit2Layout);
        jPanelEdit2Layout.setHorizontalGroup(
            jPanelEdit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );
        jPanelEdit2Layout.setVerticalGroup(
            jPanelEdit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrameEditLayout = new javax.swing.GroupLayout(jFrameEdit.getContentPane());
        jFrameEdit.getContentPane().setLayout(jFrameEditLayout);
        jFrameEditLayout.setHorizontalGroup(
            jFrameEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEdit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelEdit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelEdit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameEditLayout.setVerticalGroup(
            jFrameEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEdit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(204, 204, 204));

        TieuDe.setBackground(new java.awt.Color(153, 102, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        jLabel4.setText("jLabel3");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Book Sales Software");

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
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))))
        );

        jTabbedPane_NXB.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPane_NXB.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable_NXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Địa chỉ", "Số điện thoại", "Ghi chú"
            }
        ));
        jTable_NXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_NXBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_NXB);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        jTabbedPane_NXB.addTab("Thông tin nhà xuất bản", jPanel6);

        BangChon.setBackground(new java.awt.Color(0, 153, 153));

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
        btnAdd.setText("Add");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 204, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButtonEdit.setBackground(new java.awt.Color(0, 204, 153));
        jButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/options-icon.png"))); // NOI18N
        jButtonEdit.setText("Repair");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BangChonLayout = new javax.swing.GroupLayout(BangChon);
        BangChon.setLayout(BangChonLayout);
        BangChonLayout.setHorizontalGroup(
            BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangChonLayout.createSequentialGroup()
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BangChonLayout.setVerticalGroup(
            BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangChonLayout.createSequentialGroup()
                .addGroup(BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BangChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(jButtonEdit))
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFind, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThanhMenu4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon minion.png"))); // NOI18N
        jLabel13.setText("Hi You");

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
        lbNhaCungCap5.setOpaque(true);
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

        javax.swing.GroupLayout ThanhMenu4Layout = new javax.swing.GroupLayout(ThanhMenu4);
        ThanhMenu4.setLayout(ThanhMenu4Layout);
        ThanhMenu4Layout.setHorizontalGroup(
            ThanhMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(ThanhMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane_NXB, javax.swing.GroupLayout.PREFERRED_SIZE, 1352, Short.MAX_VALUE)
                    .addComponent(BangChon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ThanhMenu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackGroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BangChon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane_NXB, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
        this.dao.searchNXB(this);


    }//GEN-LAST:event_txtFindKeyReleased

    public JTextField getTxtFind() {
        return txtFind;
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JtextfieldMa.setText("");
        JtextfieldTen.setText("");
        JtextfieldDiaChi.setText("");
        JtextfieldSDT.setText("");
        JtextfieldEmail.setText("");
        this.jFrameAddNXB.setVisible(true);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (this.dao.deleteNXB(this.id)) {
            this.dao.loadDataList();
            this.dao.loadDataListToTable(this);
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!");
        }
        id="";

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        this.dao.loadDataList();
        for (NXB nxb : this.dao.getDanhSach()) {
            if (id.equals(nxb.getMa())) {
                JtextfieldEditMa.setText(nxb.getMa());
                JtextfieldEditTen.setText(nxb.getTen());
                JtextfieldEditDiaChi.setText(nxb.getDiaChi());
                JtextfieldEditSDT.setText(nxb.getSoDienThoai());
                JtextfieldEditEmail.setText(nxb.getEmail());
            }
        }
        jFrameEdit.setVisible(true);
        id="";
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jTable_NXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_NXBMouseClicked
        int seclectedRow = jTable_NXB.getSelectedRow();
        if (seclectedRow >= 0) {
            id = (String) jTable_NXB.getValueAt(seclectedRow, 0);
        }
    }//GEN-LAST:event_jTable_NXBMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void lbNhanVien4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhanVien4MouseClicked
        // TODO add your handling code here:
        NhanVien_View a = new NhanVien_View();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbNhanVien4MouseClicked

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
            java.util.logging.Logger.getLogger(NXB_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NXB_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NXB_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NXB_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new NXB_View().setVisible(true);
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
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JFrame jFrameAddNXB;
    private javax.swing.JFrame jFrameEdit;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelAddData;
    private javax.swing.JPanel jPanelAddOK;
    private javax.swing.JPanel jPanelAddTitle;
    private javax.swing.JPanel jPanelEdit1;
    private javax.swing.JPanel jPanelEdit2;
    private javax.swing.JPanel jPanelEdit3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane_NXB;
    private javax.swing.JTable jTable_NXB;
    private javax.swing.JLabel lbBanSach4;
    private javax.swing.JLabel lbNhaCungCap5;
    private javax.swing.JLabel lbNhanVien4;
    private javax.swing.JLabel lbNhapSach4;
    private javax.swing.JLabel lbPhieu10;
    private javax.swing.JLabel lbPhieu11;
    private javax.swing.JLabel lblBill4;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

}
