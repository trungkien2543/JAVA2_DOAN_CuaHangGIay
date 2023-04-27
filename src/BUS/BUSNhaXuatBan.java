/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAONhaXuatBan;
import DTO.DTONhaXuatBan;
import GUI.NXB_View;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class BUSNhaXuatBan {

    private NXB_View nxb_view;
    private DAONhaXuatBan daoNxb;

    public BUSNhaXuatBan(NXB_View nxb_view, DAONhaXuatBan daoNxb) {
        this.nxb_view = nxb_view;
        this.daoNxb = daoNxb;
    }
    
    public BUSNhaXuatBan(){
        
    }
    DAONhaXuatBan nxbDAO = new DAONhaXuatBan();

    public ArrayList<DTONhaXuatBan> getAllNXB() {
        return nxbDAO.getListNXB();
    }

    public DTONhaXuatBan dataJFrameAdd() {
        String ma = nxb_view.getJtextfieldMa().getText();
        String ten = nxb_view.getJtextfieldTen().getText();
        String diachi = nxb_view.getJtextfieldDiaChi().getText();
        String sdt = nxb_view.getJtextfieldSDT().getText();
        String email = nxb_view.getJtextfieldEmail().getText();
        DTONhaXuatBan nxb1 = null;
        if (ma.matches("^NXB-[0-9]{1,}") == false) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai định dạng mã, mã có dạng NXB-'số' VD: NXB-1");
            return nxb1;
        }
        if (sdt.matches("[0]{1}[0-9]{9,10}") == false) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại, số diện thoại phải có 10 số!");
            return nxb1;
        }
        if (email.matches("[a-zA-z0-9]{1,}@gmail.com$") == false) {

            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai định dạng Email!");
            return nxb1;
        }
        DTONhaXuatBan nxb = new DTONhaXuatBan(ma, ten, diachi, sdt, email);
        return nxb;
    }

    public DTONhaXuatBan dataJFrameEdit() {
        String ma = nxb_view.getJtextfieldEditMa().getText();
        String ten = nxb_view.getJtextfieldEditTen().getText();
        String diachi = nxb_view.getJtextfieldEditDiaChi().getText();
        String sdt = nxb_view.getJtextfieldEditSDT().getText();
        String email = nxb_view.getJtextfieldEditEmail().getText();
        DTONhaXuatBan nxb1 = null;
        if ((sdt.matches("[0]{1}[0-9]{9,10}") == false) && !sdt.equals("")) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại, số điện thoại phải có 10 số!");
            return nxb1;
        }
        if (email.matches("[a-zA-z0-9]{1,}@gmail.com$") == false && !email.equals("")) {

            JOptionPane.showMessageDialog(null, "Thêm thất bại, sai định dạng Email!");
            return nxb1;
        }
        DTONhaXuatBan nxb = new DTONhaXuatBan(ma, ten, diachi, sdt, email);
        return nxb;
    }

    public void AddNXB() {
        if (this.dataJFrameAdd() != null) {
            if (this.daoNxb.addNXBToSql(this.dataJFrameAdd())) {
                this.daoNxb.loadDataList();
                this.daoNxb.loadDataListToTable(nxb_view);
                JOptionPane.showMessageDialog(null, "Thêm thành công!");
                this.nxb_view.getjFrameAddNXB().setVisible(false);
                this.nxb_view.getTxtFind().setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Mã NXB đã tồn tại!");
            }
        }
    }

    public void EditNXB() {
        if (this.dataJFrameEdit() != null) {
            if (this.daoNxb.EditNXB(this.dataJFrameEdit())) {
                this.daoNxb.loadDataList();
                this.daoNxb.loadDataListToTable(nxb_view);
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                nxb_view.setId(null);
                this.nxb_view.getjFrameEdit().setVisible(false);
                this.nxb_view.getTxtFind().setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại, mã NXB không tồn tại!");

            }
        }
    }

    public void DeleteNXB() {
        if (this.daoNxb.deleteNXB(nxb_view.getId())) {
            this.daoNxb.loadDataList();
            this.daoNxb.loadDataListToTable(nxb_view);
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            nxb_view.setId(null);
            this.nxb_view.getjDialogDelete().setVisible(false);
            this.nxb_view.getTxtFind().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!");
            nxb_view.setId(null);
            this.nxb_view.getjDialogDelete().setVisible(false);
            this.nxb_view.getTxtFind().setText("");
        }
    }

    public void Excel_Database() {
        if (this.daoNxb.Excel_Database() == true) {
            this.daoNxb.loadDataList();
            this.daoNxb.loadDataListToTable(nxb_view);
            JOptionPane.showMessageDialog(null, "Hoàn thành cập nhật!");
            nxb_view.getjDialogUpdate().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
            nxb_view.getjDialogUpdate().setVisible(false);
        }
    }

    public void Database_Excel() {
        try {
            this.daoNxb.Database_Excel();
            JOptionPane.showMessageDialog(null, "Hoàn thành cập nhật!");
            nxb_view.getjDialogUpdate().setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BUSNhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
