/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ChiTietVeXe;
import com.nv.pojo.QuyDinh;
import com.nv.pojo.ThongTinCacChuyenXe;
import com.nv.pojo.VeXe;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuKhachHang;
import com.nv.services.DuLieuQuyDinh;
import com.nv.services.DuLieuVeXe;
import com.nv.services.DuLieuXe;
import com.nv.utils.Utils;
import static com.nv.utils.Utils.LOCAL_DATE;
import java.net.URL;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author DangNgocHoaiNam
 */
public class FXMLDatBanVeController implements Initializable {
    @FXML private DatePicker dpNgayDi;
    @FXML private ComboBox<String> cbNoiDi;
    @FXML private ComboBox<String> cbNoiDen;
    @FXML private TableView<ThongTinCacChuyenXe> tbThongTin;
    @FXML private Button btnDatVe;
    @FXML private Button btnBanVe;
    @FXML private TextField txtHoTen;
    @FXML private TextField txtSoDienThoai;
    @FXML private ComboBox<Integer> cbViTri;
    @FXML private TextField txtTenNhanVien;
    @FXML private TextField txtNgayIn;
    @FXML private TextField txtMaNhanVien;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnBanVe.setDisable(true);
        btnDatVe.setDisable(true);
        Utils.xuLiComboBoxNoiDi(this.cbNoiDi);
        Utils.xuLiComboBoxNoiDen(this.cbNoiDen);
        Utils.loadTableViewChuyenDi(this.tbThongTin);
        this.txtNgayIn.setText(java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuChiTietVeXe chiTietVeXe = new DuLieuChiTietVeXe();
        DuLieuXe x = new DuLieuXe();
        DuLieuChuyenXe chuyenXe = new DuLieuChuyenXe();
        
        tbThongTin.setRowFactory( tv -> {
            TableRow<ThongTinCacChuyenXe> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    btnDatVe.setDisable(false);
                    btnBanVe.setDisable(false);
                    
                    
                    ThongTinCacChuyenXe rowData = row.getItem();
                    int maXe = 0;
                    try {
                        maXe = chuyenXe.getMaXeByMa(rowData.getMaChuyenXe());
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDatBanVeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        Utils.loadViTriGhe2(this.cbViTri, x.getSoLuongGhe(maXe), rowData);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDatBanVeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
   
                }
            });
            return row ;
        });
        
        
    }    
    
    public void traCuuChuyenDi(ActionEvent evt) throws SQLException{
        btnBanVe.setDisable(true);
        btnDatVe.setDisable(true);


        Utils.traCuuChuyenDi(this.cbNoiDi, this.cbNoiDen, this.dpNgayDi, this.tbThongTin);
        
    }
    
    public void banVe(ActionEvent evt) throws SQLException, ParseException{
        DuLieuQuyDinh q = new DuLieuQuyDinh();
        
        ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        
        SimpleDateFormat formatterNgay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterGio = new SimpleDateFormat("HH:mm:ss");
        
        Date ngayDi = formatterNgay.parse(this.dpNgayDi.getValue().toString());
        Date ngayHienTai = formatterNgay.parse(java.time.LocalDate.now().toString());
        String gioKhoiHanh = selected.getGioKhoiHanh();
        String gioHienTai = java.time.LocalTime.now().toString();
         
        if(ngayDi.compareTo(ngayHienTai) > 0){
        
            if (this.txtHoTen.getText().compareTo("") == 0 || this.txtSoDienThoai.getText().compareTo("") == 0
                || this.cbViTri.getValue().toString().compareTo("") == 0
                || this.txtMaNhanVien.getText().compareTo("") == 0 || this.txtTenNhanVien.getText().compareTo("") == 0 
                || this.txtNgayIn.getText().compareTo("") == 0){
        
            Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();
            }
            else{
                DuLieuKhachHang k = new DuLieuKhachHang();
                DuLieuXe xe = new DuLieuXe();
                DuLieuVeXe ve = new DuLieuVeXe();
                DuLieuChiTietVeXe chiTietVe = new DuLieuChiTietVeXe();
                DuLieuChuyenXe c = new DuLieuChuyenXe();
                int maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                int maChuyenXe;
                int maXe;

                if(maKh == 0){

                    k.addKhachHang(this.txtHoTen.getText(), this.txtSoDienThoai.getText());
                    maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                }



//               ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
               maChuyenXe = selected.getMaChuyenXe();
               maXe = c.getMaXeByMa(selected.getMaChuyenXe());


               Utils.loadViTriGhe2(this.cbViTri, xe.getSoLuongGhe(maXe), selected);


               VeXe v = new VeXe(0, Integer.valueOf(this.txtMaNhanVien.getText()), maKh, selected.getMaChuyenXe(), true);

               ve.addVeXe(v);

               int maVe = ve.getMaVeVuaDat();

               ChiTietVeXe chiTiet = new ChiTietVeXe(0, maVe, maXe, "", this.cbViTri.getValue());
               chiTietVe.addChiTietVeXe(chiTiet);


                this.dpNgayDi.setValue(null);
                this.cbNoiDi.setValue(null);
                this.cbNoiDen.setValue(null);
                this.tbThongTin.getItems().clear();
                this.btnDatVe.setDisable(true);
                this.btnBanVe.setDisable(true);
                this.txtHoTen.clear();
                this.txtSoDienThoai.clear();
                this.cbViTri.setValue(null);

            }
            
        }
        else if(ngayDi.compareTo(ngayHienTai) == 0 && Utils.soSanhGio(gioHienTai, gioKhoiHanh) >= q.getThoiChamNhatMuaVe()){
        
            if (this.txtHoTen.getText().compareTo("") == 0 || this.txtSoDienThoai.getText().compareTo("") == 0
                || this.cbViTri.getValue().toString().compareTo("") == 0
                || this.txtMaNhanVien.getText().compareTo("") == 0 || this.txtTenNhanVien.getText().compareTo("") == 0 
                || this.txtNgayIn.getText().compareTo("") == 0){
        
            Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();
            }
            else{
                DuLieuKhachHang k = new DuLieuKhachHang();
                DuLieuXe xe = new DuLieuXe();
                DuLieuVeXe ve = new DuLieuVeXe();
                DuLieuChiTietVeXe chiTietVe = new DuLieuChiTietVeXe();
                DuLieuChuyenXe c = new DuLieuChuyenXe();
                int maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                int maChuyenXe;
                int maXe;

                if(maKh == 0){

                    k.addKhachHang(this.txtHoTen.getText(), this.txtSoDienThoai.getText());
                    maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                }



//               ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
               maChuyenXe = selected.getMaChuyenXe();
               maXe = c.getMaXeByMa(selected.getMaChuyenXe());


               Utils.loadViTriGhe2(this.cbViTri, xe.getSoLuongGhe(maXe), selected);


               VeXe v = new VeXe(0, Integer.valueOf(this.txtMaNhanVien.getText()), maKh, selected.getMaChuyenXe(), true);

               ve.addVeXe(v);

               int maVe = ve.getMaVeVuaDat();

               ChiTietVeXe chiTiet = new ChiTietVeXe(0, maVe, maXe, "", this.cbViTri.getValue());
               chiTietVe.addChiTietVeXe(chiTiet);


                this.dpNgayDi.setValue(null);
                this.cbNoiDi.setValue(null);
                this.cbNoiDen.setValue(null);
                this.tbThongTin.getItems().clear();
                this.btnDatVe.setDisable(true);
                this.btnBanVe.setDisable(true);
                this.txtHoTen.clear();
                this.txtSoDienThoai.clear();
                this.cbViTri.setValue(null);

            }
        }
        
        else{
        
            Utils.getBox("Ban da bo lo chuyen xe nay", Alert.AlertType.INFORMATION).show();
        }
        
        
        
        
    }
    
    public void datVe(ActionEvent evt) throws SQLException, ParseException{
        
        DuLieuQuyDinh q =new DuLieuQuyDinh();
       
        ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        
        SimpleDateFormat formatterNgay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterGio = new SimpleDateFormat("HH:mm:ss");
        
        Date ngayDi = formatterNgay.parse(this.dpNgayDi.getValue().toString());
        Date ngayHienTai = formatterNgay.parse(java.time.LocalDate.now().toString());
        String gioKhoiHanh = selected.getGioKhoiHanh();
        String gioHienTai = java.time.LocalTime.now().toString();
         
        if(ngayDi.compareTo(ngayHienTai) > 0){
        
            if (this.txtHoTen.getText().compareTo("") == 0 || this.txtSoDienThoai.getText().compareTo("") == 0
                || this.cbViTri.getValue().toString().compareTo("") == 0
                || this.txtMaNhanVien.getText().compareTo("") == 0 || this.txtTenNhanVien.getText().compareTo("") == 0 
                || this.txtNgayIn.getText().compareTo("") == 0){
        
            Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();
            }
            else{
                DuLieuKhachHang k = new DuLieuKhachHang();
                DuLieuXe xe = new DuLieuXe();
                DuLieuVeXe ve = new DuLieuVeXe();
                DuLieuChiTietVeXe chiTietVe = new DuLieuChiTietVeXe();
                DuLieuChuyenXe c = new DuLieuChuyenXe();
                int maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                int maChuyenXe;
                int maXe;

                if(maKh == 0){

                    k.addKhachHang(this.txtHoTen.getText(), this.txtSoDienThoai.getText());
                    maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                }



//               ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
               maChuyenXe = selected.getMaChuyenXe();
               maXe = c.getMaXeByMa(selected.getMaChuyenXe());


               Utils.loadViTriGhe2(this.cbViTri, xe.getSoLuongGhe(maXe), selected);


               VeXe v = new VeXe(0, Integer.valueOf(this.txtMaNhanVien.getText()), maKh, selected.getMaChuyenXe(), false);

               ve.addVeXe(v);

               int maVe = ve.getMaVeVuaDat();

               ChiTietVeXe chiTiet = new ChiTietVeXe(0, maVe, maXe, "", this.cbViTri.getValue());
               chiTietVe.addChiTietVeXe(chiTiet);


                this.dpNgayDi.setValue(null);
                this.cbNoiDi.setValue(null);
                this.cbNoiDen.setValue(null);
                this.tbThongTin.getItems().clear();
                this.btnDatVe.setDisable(true);
                this.btnBanVe.setDisable(true);
                this.txtHoTen.clear();
                this.txtSoDienThoai.clear();
                this.cbViTri.setValue(null);

            }
            
        }
        else if(ngayDi.compareTo(ngayHienTai) == 0 && Utils.soSanhGio(gioHienTai, gioKhoiHanh) >= q.getThoiGianChamNhatDatVe()){
        
            if (this.txtHoTen.getText().compareTo("") == 0 || this.txtSoDienThoai.getText().compareTo("") == 0
                || this.cbViTri.getValue().toString().compareTo("") == 0
                || this.txtMaNhanVien.getText().compareTo("") == 0 || this.txtTenNhanVien.getText().compareTo("") == 0 
                || this.txtNgayIn.getText().compareTo("") == 0){
        
            Utils.getBox("Ban can dien day du thong tin", Alert.AlertType.INFORMATION).show();
            }
            else{
                DuLieuKhachHang k = new DuLieuKhachHang();
                DuLieuXe xe = new DuLieuXe();
                DuLieuVeXe ve = new DuLieuVeXe();
                DuLieuChiTietVeXe chiTietVe = new DuLieuChiTietVeXe();
                DuLieuChuyenXe c = new DuLieuChuyenXe();
                int maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                int maChuyenXe;
                int maXe;

                if(maKh == 0){

                    k.addKhachHang(this.txtHoTen.getText(), this.txtSoDienThoai.getText());
                    maKh = k.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
                }



//               ThongTinCacChuyenXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
               maChuyenXe = selected.getMaChuyenXe();
               maXe = c.getMaXeByMa(selected.getMaChuyenXe());


               Utils.loadViTriGhe2(this.cbViTri, xe.getSoLuongGhe(maXe), selected);


               VeXe v = new VeXe(0, Integer.valueOf(this.txtMaNhanVien.getText()), maKh, selected.getMaChuyenXe(), false);

               ve.addVeXe(v);

               int maVe = ve.getMaVeVuaDat();

               ChiTietVeXe chiTiet = new ChiTietVeXe(0, maVe, maXe, "", this.cbViTri.getValue());
               chiTietVe.addChiTietVeXe(chiTiet);


                this.dpNgayDi.setValue(null);
                this.cbNoiDi.setValue(null);
                this.cbNoiDen.setValue(null);
                this.tbThongTin.getItems().clear();
                this.btnDatVe.setDisable(true);
                this.btnBanVe.setDisable(true);
                this.txtHoTen.clear();
                this.txtSoDienThoai.clear();
                this.cbViTri.setValue(null);

            }
        }
        
        else{
        
            Utils.getBox("Ban da bo lo chuyen xe nay", Alert.AlertType.INFORMATION).show();
        }
    }
    
}
