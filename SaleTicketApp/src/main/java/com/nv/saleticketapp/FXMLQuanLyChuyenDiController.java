/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ChuyenXe;
import com.nv.pojo.ThongTinCacChuyenXe;
import com.nv.pojo.TuyenXe;
import com.nv.pojo.Xe;
import static com.nv.saleticketapp.FXMLTraCuuChuyenDiController.loadTableData;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
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
            FXMLTraCuuChuyenDiController.loadTableViewChuyenDi(this.tbThongTin);
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
            else{

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

        DuLieuTuyenXe d = new DuLieuTuyenXe();
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        DuLieuChiTietVeXe chitiet = new DuLieuChiTietVeXe();
        DuLieuXe x = new DuLieuXe();
        
        String ngay;
        
        if (this.cbNoiDi.getValue() == null || this.cbNoiDen.getValue() == null){
            Utils.getBox("Noi di va noi den khong duoc bo trong", Alert.AlertType.INFORMATION).show();
            
        }
        
        if(this.dpNgayDi.getValue() == null){
        
            ngay = java.time.LocalDate.now().toString(); 
        }
        else{
        
            ngay = this.dpNgayDi.getValue().toString();
        }

        
        int maTuyen = d.getMaTuyen(this.cbNoiDi.getValue().toString(), this.cbNoiDen.getValue().toString());
        
        List<ChuyenXe> cacChuyenXe = c.timKiemChuyenXe(maTuyen, ngay);
        
        if(maTuyen == 0 || cacChuyenXe.size() == 0){
        
            for ( int i = 0; i<this.tbThongTin.getItems().size(); i++) {
                tbThongTin.getItems().clear();
            }
            Utils.getBox("Hien tai chua co chuyen di cua ban", Alert.AlertType.INFORMATION).show();
            
        }
        else{
        
        List<ThongTinCacChuyenXe> list = new ArrayList<>();
        
        
        for (ChuyenXe a : cacChuyenXe){

            int soGheTrong = x.getSoLuongGhe(a.getMaXe()) - v.getMaVeXe(a.getMaChuyenXe()).size();

            ThongTinCacChuyenXe info = new ThongTinCacChuyenXe(a.getMaChuyenXe(), this.cbNoiDi.getValue().toString(), this.cbNoiDen.getValue().toString(), ngay, a.getGioKhoiHanh(), a.getGia(), soGheTrong);
            list.add(info);
        }
        
        loadTableData(list, this.tbThongTin);
        }
        
    }
    
    public void xoaChuyenXe(ActionEvent evt){
    
        ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        
        
        
        try {
            Connection conn = JdbcUtils.getConn();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM chuyenxe WHERE maChuyenXe = ?");
            stm.setInt(1, selected.getMaChuyenXe());
            stm.executeUpdate();
            
            Utils.getBox("Xoa thanh cong", Alert.AlertType.INFORMATION).show();
            this.tbThongTin.getItems().remove(selected);
        } catch (SQLException ex) {
            Logger.getLogger(DuLieuChuyenXe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void suaChuyenXe(ActionEvent evt){

        DuLieuTuyenXe t = new DuLieuTuyenXe();
        ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
         try {
            Connection conn = JdbcUtils.getConn();
            PreparedStatement stm = conn.prepareStatement("UPDATE chuyenxe set tenChuyenXe = ?, gioKhoiHanh = ?, ngayDi = ?, gia = ?, maTuyen = ?, maXe = ? where maChuyenXe=?");

            stm.setString(1, this.txtTenChuyenXe.getText());
            stm.setString(2, this.txtGioKhoiHanh.getText());
            stm.setString(3, this.dpNgayDi.getValue().toString());
            stm.setFloat(4, Float.parseFloat(this.txtGia.getText()));
            stm.setInt(5, t.getMaTuyenByNoiDiNoiDen(this.cbNoiDi.getValue(), this.cbNoiDen.getValue()));
            stm.setInt(6, this.cbMaXe.getValue());
            stm.setInt(7, selected.getMaChuyenXe());
            stm.executeUpdate();
            
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
