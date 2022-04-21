/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ChuyenXe;
import com.nv.pojo.TuyenXe;
import com.nv.pojo.Xe;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuXe;
import com.nv.utils.JdbcUtils;
import com.nv.utils.Utils;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author inmac
 */
public class FXMLQuanLyChuyenDiController implements Initializable {

    
    @FXML private ComboBox<String> cbTenTuyenDi;
    @FXML private TextField txtTenChuyenXe;
    @FXML private TextField txtGioKhoiHanh;
    @FXML private TextField txtGia;
    @FXML private DatePicker dpNgayDi;
    @FXML private ComboBox<Integer> cbMaXe;
    @FXML private ComboBox<String> cbNoiDi;
    @FXML private ComboBox<String> cbNoiDen;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            xuLiComboBoxNoiDi();
            xuLiComboBoxNoiDen();
            loadDuLieuCbMaXe();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void themChuyenDi(ActionEvent evt) throws ParseException{
        
        DuLieuTuyenXe t = new DuLieuTuyenXe();
        if(this.cbNoiDi.getValue() == null || this.cbNoiDen.getValue() == null){
        
            Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();
        }
        else{
            int maTuyen = t.getMaTuyenByNoiDiNoiDen(this.cbNoiDi.getValue().toString(), this.cbNoiDen.getValue().toString());
        
        
            String ngay;
            if(this.dpNgayDi.getValue() == null){

                ngay = java.time.LocalDate.now().toString(); 
            }
            else{

                ngay = this.dpNgayDi.getValue().toString();
            }



            if(this.txtTenChuyenXe.getText().compareTo("") == 0 || this.txtGioKhoiHanh.getText().compareTo("") == 0 ||
                    this.txtGia.getText().compareTo("") == 0 || 
                    this.cbMaXe.getValue() == null){

                Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();

            }

            if(maTuyen != 0){

                try {
                ChuyenXe c = new ChuyenXe(0, this.txtTenChuyenXe.getText(), this.txtGioKhoiHanh.getText(),
                    ngay, Float.parseFloat(txtGia.getText()), maTuyen, cbMaXe.getValue());

                Connection conn = JdbcUtils.getConn();
                PreparedStatement stm = conn.prepareStatement("INSERT INTO chuyenxe(tenChuyenXe, gioKhoiHanh, ngayDi, gia, maTuyen, maXe) VALUES(?, ?, ?, ?, ?, ?)");
                stm.setString(1, c.getTenChuyenXe());
                stm.setString(2, c.getGioKhoiHanh());
                stm.setString(3, c.getNgayDi());
                stm.setFloat(4, c.getGia());
                stm.setInt(5, c.getMaTuyen());
                stm.setInt(6, c.getMaXe());

                stm.executeUpdate();
                Utils.getBox("Them thanh cong", Alert.AlertType.CONFIRMATION).show();
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

                Utils.getBox("Hien tai chua co tuyen di cua ban", Alert.AlertType.INFORMATION).show();
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
    
    
    public void loadDuLieuCbMaXe() throws SQLException{
    
        DuLieuXe all = new DuLieuXe();
        List<Integer> list = new ArrayList<>();
        for(Xe x : all.getXe()){
            list.add(x.getMaXe());
        }
        
        this.cbMaXe.setItems(FXCollections.observableList(list));
    }
    
     public void xuLiComboBoxNoiDi(){
    
        DuLieuTuyenXe d = new DuLieuTuyenXe();
        
        List<String> name = new ArrayList<>();
        
        try {
            for(int i = 0; i < d.getTuyenXe().size(); i++){
                
                name.add(d.getTuyenXe().get(i).getNoiDi());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTraCuuChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<String> list = new ArrayList<>();
        
        list = xoaPhanTuTrung(name);
                
        this.cbNoiDi.setItems(FXCollections.observableList(list));
        
    }
    
     public void xuLiComboBoxNoiDen(){
    
        DuLieuTuyenXe d = new DuLieuTuyenXe();
        
        List<String> name = new ArrayList<>();
        
        try {
            for(int i = 0; i < d.getTuyenXe().size(); i++){
                
                name.add(d.getTuyenXe().get(i).getNoiDen());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTraCuuChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<String> list = new ArrayList<>();
        
        list = xoaPhanTuTrung(name);
                
        this.cbNoiDen.setItems(FXCollections.observableList(list));
        
    }
    
    
    
    public List<String> xoaPhanTuTrung(List<String> list){
    
         // tạo 1 ArrayList arrTemp
        ArrayList<String> arrTemp = new ArrayList<>();

        // thêm các phần tử của arrListNumber vào arrTemp
        // nếu trong arrTemp đã tồn tại phần tử giống trong arrListNumber
        // thì không thêm vào, ngược lại thêm bình thường
        for (int i = 0; i < list.size(); i++) {
            if (!arrTemp.contains(list.get(i))) {
                arrTemp.add(list.get(i));
            }
        }

        list.clear();

        list.addAll(arrTemp);
        
        return list;
    }
    
}
