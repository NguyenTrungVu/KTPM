/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DangNgocHoaiNam
 */
public class FXMLMainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void clickDatBanVe(ActionEvent evt) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLDatBanVe.fxml"));
       

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Dat ban ve");
        stage.show();

    }
    
    public void clickDoiHuyVe(ActionEvent evt) throws IOException{
    
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLDoiHuyVe.fxml"));
       

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Doi huy ve");
        stage.show();
    }
    
    public void clickQuanLiChuyenXe(ActionEvent evt) throws IOException{
    
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLQuanLyChuyenDi.fxml"));
       

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Dat ban ve");
        stage.show();
    }
    
}
