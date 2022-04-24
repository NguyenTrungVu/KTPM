/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ThongTinVeXe;
import com.nv.pojo.VeXe;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuKhachHang;
import com.nv.services.DuLieuQuyDinh;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuVeXe;
import com.nv.services.DuLieuXe;
import com.nv.utils.Utils;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DangNgocHoaiNam
 */
public class FXMLDoiHuyVeController implements Initializable {

    @FXML private TextField txtSoDienThoai;
    @FXML private TextField txtTenNhanVien;
    @FXML private TextField txtNgayIn;
    @FXML private ComboBox<Integer> cbViTri;
    @FXML private TableView<ThongTinVeXe> tbThongTin;
    @FXML private Button btnDoiVe;
    @FXML private Button btnHuyVe;
    @FXML private ComboBox<Integer> cbMaChuyen;
    @FXML private Button btnNhanVe;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.btnDoiVe.setDisable(true);
        this.btnHuyVe.setDisable(true);
        this.btnNhanVe.setDisable(true);
        this.cbMaChuyen.setDisable(true);
        this.cbViTri.setDisable(true);
        
        this.txtNgayIn.setText(java.time.LocalDate.now() + " " + java.time.LocalTime.now());
        Utils.loadTableViewVeXe(tbThongTin);
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        DuLieuVeXe ve = new DuLieuVeXe();
        DuLieuXe x = new DuLieuXe();
        try {
            loadMaChuyen(this.cbMaChuyen);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDoiHuyVeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tbThongTin.setRowFactory( tv -> {
            TableRow<ThongTinVeXe> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    try {
                        btnDoiVe.setDisable(false);
                        btnHuyVe.setDisable(false);
                        this.btnNhanVe.setDisable(false);
                         this.cbMaChuyen.setDisable(false);
                         this.cbViTri.setDisable(false);
                         
                        ThongTinVeXe rowData = row.getItem();
                        
                        int maVe = rowData.getMaVe();
                        int maChuyen = ve.getMaChuyenByMa(maVe);
                        int soLuongGhe = x.getSoLuongGhe(c.getMaXeByMa(maChuyen));
                        
                        Utils.loadViTriGhe3(this.cbViTri, soLuongGhe, maChuyen);
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLDoiHuyVeController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    
   
                }
            });
            return row ;
        });
        
        
        
    }    
    
    
    
    
    public void timVe(ActionEvent evt) throws SQLException{

        if(this.txtSoDienThoai.getText().compareTo("") == 0){
        
            Utils.getBox("Moi ban nhap so dien thoai da dat ve", Alert.AlertType.INFORMATION).show();
        }
        else{
            DuLieuChiTietVeXe chiTiet = new DuLieuChiTietVeXe();
            DuLieuVeXe ve = new DuLieuVeXe();
            DuLieuKhachHang kh = new DuLieuKhachHang();
            DuLieuChuyenXe c = new DuLieuChuyenXe();
            DuLieuTuyenXe tuyen = new DuLieuTuyenXe();
            DuLieuXe xe = new DuLieuXe();
            
            int maKh = kh.getMaKhachHangBySoDienThoai(this.txtSoDienThoai.getText());
            List<Integer> maCacVeDaDat = new ArrayList<>();
            List<Integer> maCacChuyen = new ArrayList<>();
            for(VeXe v : ve.getVeXe()){

                    if(v.getMaKh() == maKh){

                        maCacVeDaDat.add(v.getMaVe());

                    }

                }
            if(maCacVeDaDat.size() > 0){
                List<ThongTinVeXe> results = new ArrayList<>();
                
                String tenKh = kh.getTenByMa(maKh);
                String soDienThoai = kh.getSoDienThoaiByMa(maKh);
                
                for(int i = 0; i < maCacVeDaDat.size(); i++){
                    int maChuyen = ve.getMaChuyenByMa(maCacVeDaDat.get(i));

                    int maTuyen = c.getMaTuyenByMa(maChuyen);

                    String noiDi = tuyen.getNoiDiByMa(maTuyen);
                    String noiDen = tuyen.getNoiDenByMa(maTuyen);
                    int maXe = c.getMaXeByMa(maChuyen);
                    String banSo = xe.getBanSo(maXe);
                    
                    String ngayDi = c.getNgayKhoiHanhByMa(maChuyen).toString();
                    String gioKhoiHanh = c.getGioKhoiHanhByMa(maChuyen);
                    int viTriGhe = chiTiet.getViTriGhe(maCacVeDaDat.get(i));
                    float gia = c.getGiaXeByMa(maChuyen);
                    
                    ThongTinVeXe info = new ThongTinVeXe(maCacVeDaDat.get(i), banSo, 
                            noiDi, noiDen, ngayDi, gioKhoiHanh, tenKh, soDienThoai,
                            viTriGhe, gia);
                    
                    results.add(info);
                }
                Utils.loadTableDataVeXe(results, tbThongTin);

                
            }else{
            
                Utils.getBox("Hien tai khach hanh chua dat ve xe nao", Alert.AlertType.INFORMATION).show();
            }
        }
    }
    
    public void doiVe(ActionEvent evt) throws SQLException, ParseException{
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuQuyDinh q = new DuLieuQuyDinh();
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        ThongTinVeXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        boolean trangThaiVe = v.getTrangThaiVe(selected.getMaVe());
        
        SimpleDateFormat formatterNgay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterGio = new SimpleDateFormat("HH:mm:ss");
        
        Date ngayKhoiHanh = c.getNgayKhoiHanh2ByMa(v.getMaChuyenByMa(selected.getMaVe()));
        Date ngayDi = formatterNgay.parse(ngayKhoiHanh.toString());
        Date ngayHienTai = formatterNgay.parse(java.time.LocalDate.now().toString());
        String gioKhoiHanh = selected.getGioKhoiHanh();
        String gioHienTai = java.time.LocalTime.now().toString();
        
        if(trangThaiVe == false){
        
            if(ngayDi.compareTo(ngayHienTai) > 0){
                
                if(this.cbViTri.getValue().toString().compareTo("") == 0){
                
                    Utils.getBox("Ban vui long chon ghe muon doi", Alert.AlertType.INFORMATION).show();
                }
                else{
                    int viTriGhe = this.cbViTri.getValue();
                    int maChuyen = 0;
                    if(this.cbMaChuyen.getValue() != null){
                    
                          maChuyen = this.cbMaChuyen.getValue();

                    }
                    
                    v.suaVeXe(maChuyen, viTriGhe, selected.getMaVe());
                    Utils.getBox("Cap nhat thanh cong", Alert.AlertType.INFORMATION).show();
                    
                }
                
                
            
            }else if(ngayDi.compareTo(ngayHienTai) == 0 && Utils.soSanhGio(gioHienTai, gioKhoiHanh) >= q.getThoiGianChamNhatDoiHuyVe()){
            
                if(this.cbViTri.getValue().toString().compareTo("") == 0){
                
                    Utils.getBox("Ban vui long chon ghe muon doi", Alert.AlertType.INFORMATION).show();
                }
                else{
                    int viTriGhe = this.cbViTri.getValue();
                    int maChuyen = 0;
                    if(this.cbMaChuyen.getValue() != null){
                    
                          maChuyen = this.cbMaChuyen.getValue();

                    }
                    
                    v.suaVeXe(maChuyen, viTriGhe, selected.getMaVe());
                    Utils.getBox("Cap nhat thanh cong", Alert.AlertType.INFORMATION).show();
                    
                }
                
            }else{

                Utils.getBox("Ve ban khong the doi do qua thoi gian quy dinh", Alert.AlertType.INFORMATION).show();
            }
            
        }else{
        
            Utils.getBox("Ve cua ban khong the doi", Alert.AlertType.INFORMATION).show();
        }
    
        
        
        
    }
    
    public void huyVe(ActionEvent evt) throws SQLException, ParseException{
    
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuQuyDinh q = new DuLieuQuyDinh();
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        ThongTinVeXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        boolean trangThaiVe = v.getTrangThaiVe(selected.getMaVe());
        
        SimpleDateFormat formatterNgay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterGio = new SimpleDateFormat("HH:mm:ss");
        
        Date ngayKhoiHanh = c.getNgayKhoiHanh2ByMa(v.getMaChuyenByMa(selected.getMaVe()));
        
        Date ngayDi = formatterNgay.parse(ngayKhoiHanh.toString());
        Date ngayHienTai = formatterNgay.parse(java.time.LocalDate.now().toString());
//                        System.out.println(ngayDi + "----" + ngayHienTai);
//
//                System.out.println(ngayDi.compareTo(ngayHienTai));


        String gioKhoiHanh = selected.getGioKhoiHanh();
        String gioHienTai = java.time.LocalTime.now().toString();
        
        if(trangThaiVe == false){
            if(ngayDi.compareTo(ngayHienTai) > 0){
                v.xoaVeXe(selected.getMaVe());
                Utils.getBox("Huy thanh cong", Alert.AlertType.INFORMATION).show();
                this.tbThongTin.getItems().remove(selected);
                
            }else if(ngayDi.compareTo(ngayHienTai) == 0 && Utils.soSanhGio(gioHienTai, gioKhoiHanh) >= q.getThoiGianChamNhatNhanVe()){
            
                v.xoaVeXe(selected.getMaVe());
                Utils.getBox("Huy thanh cong", Alert.AlertType.INFORMATION).show();
                this.tbThongTin.getItems().remove(selected);
            }else{
            
                Utils.getBox("Ve cua ban khong the hoan tra do qua thoi gian quy dinh", Alert.AlertType.INFORMATION).show();
            }
        
            
        }else{
        
            Utils.getBox("Ve cua ban khong the hoan tra", Alert.AlertType.INFORMATION).show();
        }
        
        
    }
    
    public void nhanVe(ActionEvent evt) throws SQLException, ParseException{
    
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuQuyDinh q = new DuLieuQuyDinh();
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        ThongTinVeXe selected = this.tbThongTin.getSelectionModel().getSelectedItem();
        boolean trangThaiVe = v.getTrangThaiVe(selected.getMaVe());     
        SimpleDateFormat formatterNgay = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterGio = new SimpleDateFormat("HH:mm:ss");   
        Date ngayKhoiHanh = c.getNgayKhoiHanh2ByMa(v.getMaChuyenByMa(selected.getMaVe())); 
        Date ngayDi = formatterNgay.parse(ngayKhoiHanh.toString());
        Date ngayHienTai = formatterNgay.parse(java.time.LocalDate.now().toString());
        String gioKhoiHanh = selected.getGioKhoiHanh();
        String gioHienTai = java.time.LocalTime.now().toString();
        
        if(trangThaiVe == false){
            int maVe = selected.getMaVe();
            if(ngayDi.compareTo(ngayHienTai) > 0){
            
                v.nhanVe(maVe);
                Utils.getBox("Nhan ve thanh cong", Alert.AlertType.INFORMATION).show();
                
            }else if((ngayDi.compareTo(ngayHienTai) == 0 && Utils.soSanhGio(gioHienTai, gioKhoiHanh) >= q.getThoiGianChamNhatNhanVe())){
            
                
                v.nhanVe(maVe);
                Utils.getBox("Nhan ve thanh cong", Alert.AlertType.INFORMATION).show();
            }else{
            
                v.xoaVeXe(maVe);
                this.tbThongTin.getItems().remove(selected);
                Utils.getBox("Ve da duoc huy do qua thoi gian nhan ve", Alert.AlertType.INFORMATION).show();
            }
        }else{
        
            Utils.getBox("Ve cua ban da duoc nhan", Alert.AlertType.INFORMATION).show();
        }
    }
    
    
    
    public void loadViTriByChuyen(ActionEvent evt) throws SQLException{
        
        DuLieuXe xe = new DuLieuXe();
        DuLieuChuyenXe c = new DuLieuChuyenXe();
    
        int maChuyen = this.cbMaChuyen.getValue();
        int soLuongGhe = xe.getSoLuongGhe(c.getMaXeByMa(maChuyen));
        Utils.loadViTriGhe3(this.cbViTri, soLuongGhe, maChuyen);
        
    }
    
    private void loadMaChuyen(ComboBox<Integer> cbMaChuyen) throws SQLException{
    
        DuLieuChuyenXe c = new DuLieuChuyenXe();
    
        
        List<Integer> ma = new ArrayList<>();
        
 
        for(int i = 0; i < c.getChuyenXe().size(); i++){

            ma.add(c.getChuyenXe().get(i).getMaChuyenXe());
        }
      

                
        cbMaChuyen.setItems(FXCollections.observableList(ma));
        
    
    }
    
    
   
    
}
