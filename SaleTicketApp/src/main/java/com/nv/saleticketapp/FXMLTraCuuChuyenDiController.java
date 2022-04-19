/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.ChuyenXe;
import com.nv.services.DuLieuChuyenXe;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author inmac
 */
public class FXMLTraCuuChuyenDiController implements Initializable {
    
    @FXML private ComboBox<String> cbNoiDi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        DuLieuChuyenXe d = new DuLieuChuyenXe();
        
        List<String> name = new ArrayList<>();
        
        try {
            for(int i = 0; i < d.getChuyenXe().size(); i++){
                
                name.add(d.getChuyenXe().get(i).getTenChuyenXe());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTraCuuChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        this.cbNoiDi.setItems(FXCollections.observableList(name));
    }    
    
}
