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
        
        Utils.xuLiComboBoxNoiDi(this.cbNoiDi);
        Utils.xuLiComboBoxNoiDen(this.cbNoiDen);
        
        Utils.loadTableViewChuyenDi(tbThongTin);
    }    
    
    public void thoat(ActionEvent evt){
    
        System.exit(0);
    }
    
    public void traCuuChuyenDi(ActionEvent evt) throws SQLException, ParseException{
        
         Utils.traCuuChuyenDi(this.cbNoiDi, this.cbNoiDen, this.dpNgayDi, this.tbThongTin);

    }
    
    
    
}
