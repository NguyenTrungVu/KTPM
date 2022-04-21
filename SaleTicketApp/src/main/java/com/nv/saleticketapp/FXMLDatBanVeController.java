/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ThongTinCacVeXe;
import com.nv.pojo.VeXe;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuKhachHang;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuVeXe;
import com.nv.services.DuLieuXe;
import com.nv.utils.Utils;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DangNgocHoaiNam
 */
public class FXMLDatBanVeController implements Initializable {
    
    @FXML private TextField txtNoiDi;
    @FXML private TextField txtNoiDen;
    @FXML private DatePicker dpNgayDi;
    @FXML private TextField txtHoTen;
    @FXML private TextField txtSoDienThoai;
    @FXML private ComboBox<String> txtViTriGhe;
    @FXML private TableView<ThongTinCacVeXe> tbview;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        loadTableView();
    }    
    
    
    
     
    public void timVeXe (ActionEvent evt) throws SQLException{ 
     
        DuLieuXe x = new DuLieuXe();
        DuLieuVeXe ve = new DuLieuVeXe();
        DuLieuTuyenXe tx = new DuLieuTuyenXe();
        DuLieuChuyenXe cx = new DuLieuChuyenXe();
        DuLieuKhachHang k = new DuLieuKhachHang();
        DuLieuChiTietVeXe chitiet = new DuLieuChiTietVeXe();
        
        
//        this.txtNoiDi.setText(hoTen);
        int maKh = k.getMaKh(this.txtSoDienThoai.getText());
        List<VeXe> ma = ve.getMaVe(maKh);
        int mc = ve.getMaChuyenXe(maKh);
        List<ThongTinCacVeXe> list = new ArrayList<>();
        
        for (VeXe v : ma){
            int maVe = v.getMaVe();
            String hoTen = k.getHoTen( this.txtSoDienThoai.getText());
            int mt = cx.getTuyenXe(maKh);
            String noiDen = tx.getNoiDen(mt);
            String noiDi = tx.getNoiDi(mt);
            Date ngayDi = cx.getNgayDi(maKh);
            String banSo = x.getBanSo(chitiet.getMaXe(v.getMaVe()));
            String viTriGhe = chitiet.getViTri(v.getMaVe());
            Float gia = cx.getGia(maKh);
            
            ThongTinCacVeXe info = ThongTinCacVeXe(maVe, banSo, noiDi, noiDen, ngayDi, 
                    hoTen, this.txtSoDienThoai.getText(), viTriGhe, gia);
            
            list.add(info);
        }
        
        
    
    }
     
    
    private void loadTableView() {
        TableColumn colMaVe = new TableColumn("Ma Ve");
        colMaVe.setPrefWidth(10);
        TableColumn colBanSo = new TableColumn("Ban So");
        colBanSo.setPrefWidth(10);
        TableColumn colNoiDi = new TableColumn("Noi Di");
        colNoiDi.setPrefWidth(100);
        TableColumn colNoiDen  = new TableColumn("Noi Den");
        colNoiDen.setPrefWidth(100);
        TableColumn colNgay = new TableColumn("Ngay Di");
        colNgay.setPrefWidth(100);
        TableColumn colHoTen  = new TableColumn("Ho Ten");
        colHoTen.setPrefWidth(200);
        TableColumn colSoDienThoai  = new TableColumn("So Dien Thoai");
        colSoDienThoai.setPrefWidth(200);
        TableColumn colViTriGhe = new TableColumn("Vi Tri Ghe");
        colViTriGhe.setPrefWidth(50);
        TableColumn colGia = new TableColumn("Gia");
        colGia.setPrefWidth(10);
        
        colMaVe.setCellFactory(new PropertyValueFactory("maVe"));
        colBanSo.setCellFactory(new PropertyValueFactory("banSo"));
        colNoiDi.setCellValueFactory(new PropertyValueFactory("noiDi"));
        colNoiDen.setCellValueFactory(new PropertyValueFactory("noiDen"));
        colNgay.setCellValueFactory(new PropertyValueFactory("ngayDi"));
        colHoTen.setCellValueFactory(new PropertyValueFactory("hoTen"));
        colSoDienThoai.setCellValueFactory(new PropertyValueFactory("soDienThoai"));
        colViTriGhe.setCellValueFactory(new PropertyValueFactory("viTriGhe"));
        colGia.setCellFactory(new PropertyValueFactory("gia"));
        
        this.tbview.getColumns().addAll(colNoiDi, colNoiDen, colNgay, colHoTen, colSoDienThoai, colViTriGhe);
    }
    
    private void loadTableData(List<ThongTinCacVeXe> list){
        this.tbview.setItems(FXCollections.observableList(list));
    }

    private ThongTinCacVeXe ThongTinCacVeXe(int maVe, String banSo, String noiDi, String noiDen, Date ngayDi, String hoTen, String text, String viTriGhe, Float gia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
                
}
