/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ChuyenXe;
import com.nv.pojo.ThongTinCacChuyenXe;
import com.nv.pojo.TuyenXe;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuVeXe;
import com.nv.services.DuLieuXe;
import com.nv.utils.Utils;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author inmac
 */
public class FXMLTraCuuChuyenDiController implements Initializable {
    
    @FXML private ComboBox<String> cbNoiDi;
    @FXML private ComboBox<String> cbNoiDen;
    @FXML private DatePicker dpNgayDi;
    @FXML private TableView<ThongTinCacChuyenXe> tbThongTin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        xuLiComboBoxNoiDi();
        xuLiComboBoxNoiDen();
        
        loadTableViewChuyenDi(tbThongTin);
    }    
    
    public void thoat(ActionEvent evt){
    
        System.exit(0);
    }
    
    public void traCuuChuyenDi(ActionEvent evt) throws SQLException, ParseException{
        
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
    
    public static void loadTableViewChuyenDi(TableView tableview){
    
        TableColumn colMaChuyenXe = new TableColumn("Ma Chuyen Xe");
        colMaChuyenXe.setCellValueFactory(new PropertyValueFactory("maChuyenXe"));
        colMaChuyenXe.setPrefWidth(170);

        TableColumn colNoiDi = new TableColumn("Noi di");
        colNoiDi.setCellValueFactory(new PropertyValueFactory("noiDi"));
        colNoiDi.setPrefWidth(100);

        TableColumn colNoiDen = new TableColumn("Noi den");
        colNoiDen.setCellValueFactory(new PropertyValueFactory("noiDen"));
        colNoiDen.setPrefWidth(100);

        TableColumn colNgayDi = new TableColumn("Ngay Di");
        colNgayDi.setCellValueFactory(new PropertyValueFactory("ngayDi"));
        colNgayDi.setPrefWidth(150);

        
        TableColumn colGioKhoiHanh = new TableColumn("Gio di");
        colGioKhoiHanh.setCellValueFactory(new PropertyValueFactory("gioKhoiHanh"));
        colGioKhoiHanh.setPrefWidth(100);

        TableColumn colGia = new TableColumn("Gia tien");
        colGia.setCellValueFactory(new PropertyValueFactory("gia"));
        colGia.setPrefWidth(110);

        
        TableColumn colGheTrong = new TableColumn("Con trong");
        colGheTrong.setCellValueFactory(new PropertyValueFactory("gheConTrong"));
        colGheTrong.setPrefWidth(100);

        
        tableview.getColumns().addAll(colMaChuyenXe, colNoiDi, colNoiDen, colNgayDi, colGioKhoiHanh, colGia, colGheTrong);
        
    }
    
    public static void loadTableData(List<ThongTinCacChuyenXe> list, TableView tableview){
        
        tableview.setItems(FXCollections.observableList(list));
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
