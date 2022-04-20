/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.TuyenXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuTuyenXe;
import com.nv.utils.Utils;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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

/**
 * FXML Controller class
 *
 * @author inmac
 */
public class FXMLTraCuuChuyenDiController implements Initializable {
    
    @FXML private ComboBox<String> cbNoiDi;
    @FXML private ComboBox<String> cbNoiDen;
    @FXML private DatePicker dpNgayDi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        xuLiComboBoxNoiDi();
        xuLiComboBoxNoiDen();

    }    
    
    
    public void traCuuChuyenDi(ActionEvent evt){
        
        DuLieuTuyenXe d = new DuLieuTuyenXe();
        int maTuyen = d.getMaTuyen(this.cbNoiDi.getValue().toString(), this.cbNoiDen.getValue().toString());
        Utils.getBox(String.valueOf(maTuyen), Alert.AlertType.INFORMATION).show();
//        Utils.getBox(this.cbNoiDi.getValue().toString(), Alert.AlertType.INFORMATION).show();

        
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
