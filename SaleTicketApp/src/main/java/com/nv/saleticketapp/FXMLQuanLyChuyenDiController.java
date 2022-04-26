/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ChuyenXe;
import com.nv.pojo.ThongTinCacChuyenXe;
import com.nv.pojo.TuyenXe;
import com.nv.pojo.Xe;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuNhanVien;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuVeXe;
import com.nv.services.DuLieuXe;
import com.nv.utils.JdbcUtils;
import com.nv.utils.Utils;
import static com.nv.utils.Utils.LOCAL_DATE;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author inmac
 */
public class FXMLQuanLyChuyenDiController implements Initializable {

    
    @FXML private TextField txtTenChuyenXe;
    @FXML private TextField txtGioKhoiHanh;
    @FXML private TextField txtGia;
    @FXML private DatePicker dpNgayDi;
    @FXML private ComboBox<Integer> cbMaXe;
    @FXML private ComboBox<String> cbNoiDi;
    @FXML private ComboBox<String> cbNoiDen;
    @FXML private TableView<ThongTinCacChuyenXe> tbThongTin;
    @FXML private Button btnSua;
    @FXML private Button btnXoa;
    private int maNv;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        try {
            // TODO
            
            Utils.xuLiComboBoxNoiDi(this.cbNoiDi);
            Utils.xuLiComboBoxNoiDen(this.cbNoiDen);
            loadDuLieuCbMaXe();
            Utils.loadTableViewChuyenDi(this.tbThongTin);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        DuLieuTuyenXe t = new DuLieuTuyenXe();
        
        tbThongTin.setRowFactory( tv -> {
            TableRow<ThongTinCacChuyenXe> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    btnSua.setDisable(false);
                    btnXoa.setDisable(false);
                    
                    ThongTinCacChuyenXe rowData = row.getItem();
                    try {
                        this.txtTenChuyenXe.setText(c.getTenChuyenXeByMa(rowData.getMaChuyenXe()));
//                        this.cbNoiDi.setValue(t.getNoiDiByMa(c.getMaTuyenByMa(rowData.getMaChuyenXe())));
//                        this.cbNoiDen.setValue(t.getNoiDenByMa(c.getMaTuyenByMa(rowData.getMaChuyenXe())));
                          this.txtGioKhoiHanh.setText(rowData.getGioKhoiHanh());
                          this.txtGia.setText(String.valueOf(rowData.getGia()));
                          this.cbMaXe.setValue(c.getMaXeByMa(rowData.getMaChuyenXe()));
                          this.dpNgayDi.setValue(LOCAL_DATE(rowData.getNgayDi()));

                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            return row ;
        });
    }    

    public void themChuyenDi(ActionEvent evt) throws ParseException{

        DuLieuTuyenXe t = new DuLieuTuyenXe();
        DuLieuChuyenXe chuyen = new DuLieuChuyenXe();
        if(this.cbNoiDi.getValue() == null || this.cbNoiDen.getValue() == null){
        
            Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();
        }
        else{
            int maTuyen = t.getMaTuyenByNoiDiNoiDen(this.cbNoiDi.getValue().toString(), this.cbNoiDen.getValue().toString());
        
        
            Date ngay = null;
            String temp;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            if(this.dpNgayDi.getValue() == null){
                
                LocalDate currentDate = LocalDate.now();
                ngay = Date.valueOf(currentDate.toString());

            }
            else{

                temp = this.dpNgayDi.getValue().toString();
                ngay = Date.valueOf(temp);
            }

            if(this.txtTenChuyenXe.getText().compareTo("") == 0 || this.txtGioKhoiHanh.getText().compareTo("") == 0 ||
                    this.txtGia.getText().compareTo("") == 0 || 
                    this.cbMaXe.getValue() == null){

                Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();

            }
            else{

                if(maTuyen != 0){

                    try {
                    ChuyenXe c = new ChuyenXe(0, this.txtTenChuyenXe.getText(), this.txtGioKhoiHanh.getText(),
                        ngay, Float.parseFloat(txtGia.getText()), maTuyen, cbMaXe.getValue());
                    
                    chuyen.addChuyenXe(c);
                    Utils.getBox("Them thanh cong", Alert.AlertType.CONFIRMATION).show();

                    
//                      ChuyenXe c = new ChuyenXe(0, this.txtTenChuyenXe.getText(), this.txtGioKhoiHanh.getText(),
//                        ngay, Float.parseFloat(txtGia.getText()), maTuyen, cbMaXe.getValue());
//                    Connection conn = JdbcUtils.getConn();
//                    PreparedStatement stm = conn.prepareStatement("INSERT INTO chuyenxe(tenChuyenXe, gioKhoiHanh, ngayDi, gia, maTuyen, maXe) VALUES(?, ?, ?, ?, ?, ?)");
//                    stm.setString(1, c.getTenChuyenXe());
//                    stm.setString(2, c.getGioKhoiHanh());
//                    stm.setDate(3, (Date) c.getNgayDi());
//                    stm.setFloat(4, c.getGia());
//                    stm.setInt(5, c.getMaTuyen());
//                    stm.setInt(6, c.getMaXe());
//
//                    stm.executeUpdate();
//                    Utils.getBox("Them thanh cong", Alert.AlertType.CONFIRMATION).show();
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{

                    Utils.getBox("Hien tai chua co tuyen di cua ban", Alert.AlertType.INFORMATION).show();
                }
            }
        
        }
        
        
        this.cbMaXe.setValue(null);
        this.dpNgayDi.setValue(null);
        this.txtGia.clear();
        this.txtTenChuyenXe.clear();
        this.txtGioKhoiHanh.clear();
        this.cbNoiDi.setValue(null);
        this.cbNoiDen.setValue(null);
        
    }
    
    public void traCuuChuyenDi(ActionEvent evt) throws SQLException{
            
        btnSua.setDisable(true);
        btnXoa.setDisable(true);
        Utils.traCuuChuyenDi(this.cbNoiDi, this.cbNoiDen, this.dpNgayDi, this.tbThongTin);
        
        
    }
    
    public void xoaChuyenXe(ActionEvent evt){
    
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        
        
        
        try {
            
            c.xoaChuyenXe(selected.getMaChuyenXe());
            
            
//            Connection conn = JdbcUtils.getConn();
//            PreparedStatement stm = conn.prepareStatement("DELETE FROM chuyenxe WHERE maChuyenXe = ?");
//            stm.setInt(1, selected.getMaChuyenXe());
//            stm.executeUpdate();
//            
            Utils.getBox("Xoa thanh cong", Alert.AlertType.INFORMATION).show();
            this.tbThongTin.getItems().remove(selected);
        } catch (SQLException ex) {
            Logger.getLogger(DuLieuChuyenXe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void suaChuyenXe(ActionEvent evt){
        
        DuLieuChuyenXe chuyen = new DuLieuChuyenXe();
        DuLieuTuyenXe t = new DuLieuTuyenXe();
        ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
         try {
             
             
             
             ChuyenXe x = new ChuyenXe(selected.getMaChuyenXe(), this.txtTenChuyenXe.getText(), this.txtGioKhoiHanh.getText(), Date.valueOf(this.dpNgayDi.getValue()), Float.parseFloat(this.txtGia.getText()),
                     t.getMaTuyenByNoiDiNoiDen(this.cbNoiDi.getValue(), this.cbNoiDen.getValue()), this.cbMaXe.getValue());
             
             chuyen.suaChuyenXe(x);
             
//            Connection conn = JdbcUtils.getConn();
//            PreparedStatement stm = conn.prepareStatement("UPDATE chuyenxe set tenChuyenXe = ?, gioKhoiHanh = ?, ngayDi = ?, gia = ?, maTuyen = ?, maXe = ? where maChuyenXe=?");
//
//            stm.setString(1, this.txtTenChuyenXe.getText());
//            stm.setString(2, this.txtGioKhoiHanh.getText());
//            stm.setString(3, this.dpNgayDi.getValue().toString());
//            stm.setFloat(4, Float.parseFloat(this.txtGia.getText()));
//            stm.setInt(5, t.getMaTuyenByNoiDiNoiDen(this.cbNoiDi.getValue(), this.cbNoiDen.getValue()));
//            stm.setInt(6, this.cbMaXe.getValue());
//            stm.setInt(7, selected.getMaChuyenXe());
//            stm.executeUpdate();
            
            Utils.getBox("Cap nhat thanh cong", Alert.AlertType.INFORMATION).show();
            
            traCuuChuyenDi(evt);
            
            this.cbMaXe.setValue(null);
            this.dpNgayDi.setValue(null);
            this.txtGia.clear();
            this.txtTenChuyenXe.clear();
            this.txtGioKhoiHanh.clear();
            this.cbNoiDi.setValue(null);
            this.cbNoiDen.setValue(null);
            
        } catch (SQLException ex) {
            Logger.getLogger(DuLieuChuyenXe.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    
    public void loadDuLieuCbMaXe() throws SQLException{
    
        DuLieuXe all = new DuLieuXe();
        List<Integer> list = new ArrayList<>();
        for(Xe x : all.getXe()){
            list.add(x.getMaXe());
        }
        
        this.cbMaXe.setItems(FXCollections.observableList(list));
    }

    /**
     * @return the maNv
     */
    public int getMaNv() {
        return maNv;
    }

    /**
     * @param maNv the maNv to set
     */
    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }
  

    
}
