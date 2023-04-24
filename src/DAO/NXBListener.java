/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTONhaXuatBan;
import GUI.NXB_View;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HOME
 */
public class NXBListener implements ActionListener {

    private NXB_View nxb_view;
    private DAONhaXuatBan daoNxb;

    public NXBListener(NXB_View nxb_view, DAONhaXuatBan daoNxb) {
        this.nxb_view = nxb_view;
        this.daoNxb = daoNxb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nxb_view.getJbutton_ok()) {
            if (this.nxb_view.dataJFrameAdd() != null) {
                if (this.daoNxb.addNXBToSql(this.nxb_view.dataJFrameAdd())) {
                    this.daoNxb.loadDataList();
                    this.daoNxb.loadDataListToTable(nxb_view);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    this.nxb_view.getjFrameAddNXB().setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Mã NXB đã tồn tại!");
                }
            }
        }
        
        if (e.getSource() == nxb_view.getjButton_ok2()) {
            if (this.nxb_view.dataJFrameEdit()!= null) {
                if (this.daoNxb.EditNXB(nxb_view.dataJFrameEdit())) {
                    this.daoNxb.loadDataList();
                    this.daoNxb.loadDataListToTable(nxb_view);
                    JOptionPane.showMessageDialog(null, "Sửa thành công!");
                    this.nxb_view.getjFrameEdit().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại!");
                }
            }
        }

    }
}
