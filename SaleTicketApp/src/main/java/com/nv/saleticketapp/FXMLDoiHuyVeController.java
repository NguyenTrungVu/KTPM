/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ThongTinVeXe;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
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
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.txtNgayIn.setText(java.time.LocalDate.now().toString() + " " + java.time.LocalTime.now().toString());
        loadTableViewVeXe();
    }    
    
    
    
    
    
    private void loadTableViewVeXe() {
        TableColumn colMaVe = new TableColumn("Ma Ve");
        colMaVe.setPrefWidth(100);
        TableColumn colBanSo = new TableColumn("Ban So");
        colBanSo.setPrefWidth(100);
        TableColumn colNoiDi = new TableColumn("Noi Di");
        colNoiDi.setPrefWidth(100);
        TableColumn colNoiDen  = new TableColumn("Noi Den");
        colNoiDen.setPrefWidth(100);
        TableColumn colNgay = new TableColumn("Ngay Di");
        colNgay.setPrefWidth(100);
        TableColumn colGio = new TableColumn("Gio khoi hanh");
        colGio.setPrefWidth(100);
        TableColumn colHoTen  = new TableColumn("Ho Ten");
        colHoTen.setPrefWidth(100);
        TableColumn colSoDienThoai  = new TableColumn("So Dien Thoai");
        colSoDienThoai.setPrefWidth(120);
        TableColumn colViTriGhe = new TableColumn("Vi Tri Ghe");
        colViTriGhe.setPrefWidth(100);
        TableColumn colGia = new TableColumn("Gia");
        colGia.setPrefWidth(100);
        
        colMaVe.setCellFactory(new PropertyValueFactory("maVe"));
        colBanSo.setCellFactory(new PropertyValueFactory("banSo"));
        colNoiDi.setCellValueFactory(new PropertyValueFactory("noiDi"));
        colNoiDen.setCellValueFactory(new PropertyValueFactory("noiDen"));
        colNgay.setCellValueFactory(new PropertyValueFactory("ngayDi"));
        colGio.setCellValueFactory(new PropertyValueFactory("gioKhoiHanh"));
        colHoTen.setCellValueFactory(new PropertyValueFactory("hoTen"));
        colSoDienThoai.setCellValueFactory(new PropertyValueFactory("soDienThoai"));
        colViTriGhe.setCellValueFactory(new PropertyValueFactory("viTriGhe"));
        colGia.setCellFactory(new PropertyValueFactory("gia"));
        
        this.tbThongTin.getColumns().addAll(colMaVe, colBanSo, colNoiDi, colNoiDen, colNgay, colHoTen, colSoDienThoai, colViTriGhe, colGia);
    }
    
    private void loadTableData(List<ThongTinVeXe> list){
        this.tbThongTin.setItems(FXCollections.observableList(list));
    }
    
}
