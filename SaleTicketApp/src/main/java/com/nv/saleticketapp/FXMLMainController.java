/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nv.saleticketapp;

import com.nv.pojo.NhanVien;
import com.nv.services.DuLieuNhanVien;
import com.nv.utils.Utils;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DangNgocHoaiNam
 */
public class FXMLMainController implements Initializable {
    
    @FXML private TextField txtUserName;
    @FXML private TextField txtPass;
    @FXML private Text userName;
    @FXML private Text pass;
    @FXML private Button btnLogin;
    @FXML private Button btnExit;
    
    private int maLoaiNv = 0;
    private int maNv = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
    public void login(ActionEvent evt) throws SQLException{
    
        String user = this.txtUserName.getText();
        String pass = this.txtPass.getText();
        DuLieuNhanVien nv = new DuLieuNhanVien();
        
        for (NhanVien n : nv.getNhanVien()){
        
            if(n.getUserName().compareTo(user) == 0 && n.getPassWord().compareTo(pass) == 0){
            
                this.setMaNv(n.getMaNv());
                this.setMaLoaiNv(nv.getMaLoaiNhanVienByMa(n.getMaNv()));
                Utils.getBox("Dang nhap thanh cong", Alert.AlertType.INFORMATION).show();
                
                this.txtPass.setVisible(false);
                this.txtUserName.setVisible(false);
                this.userName.setVisible(false);
                this.pass.setVisible(false);
                this.btnLogin.setVisible(false);
                this.btnExit.setVisible(true);
                break;

            }
        }
        
        if(this.getMaNv() == 0)
            Utils.getBox("Ten dang nhap hoac mat khau khong dung", Alert.AlertType.INFORMATION).show();

    }
    
    
    public void exit(ActionEvent evt){
        this.btnExit.setVisible(false);
        this.txtPass.setVisible(true);
        this.txtUserName.setVisible(true);
        this.userName.setVisible(true);
        this.pass.setVisible(true);
        this.btnLogin.setVisible(true);
        this.setMaNv(0);
        this.setMaLoaiNv(0);

    }
    
    
    public void clickDatBanVe(ActionEvent evt) throws IOException, SQLException{
        
        if(this.getMaLoaiNv() == 2){
        
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLDatBanVe.fxml"));
            
            Parent root = fxmlLoader.load();
            FXMLDatBanVeController controller = fxmlLoader.getController();
            controller.setMaNv(maNv);
            controller.loadNhanVien();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Dat ban ve");
            stage.show();
            
        }else{
        
            Utils.getBox("Ban khong co quyen su dung", Alert.AlertType.INFORMATION).show();
        }
        

    }
    
    public void clickDoiHuyVe(ActionEvent evt) throws IOException, SQLException{
        
        if(this.getMaLoaiNv() == 2){
    
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLDoiHuyVe.fxml"));
            
            Parent root = fxmlLoader.load();
            FXMLDoiHuyVeController controller = fxmlLoader.getController();
            controller.setMaNv(maNv);
            controller.loadNhanVien();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Doi huy ve");
            stage.show();
        }else{
        
            Utils.getBox("Ban khong co quyen su dung", Alert.AlertType.INFORMATION).show();
        }
    }
    
    public void clickQuanLiChuyenXe(ActionEvent evt) throws IOException{
        
        if(this.getMaLoaiNv() == 1){
    
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLQuanLyChuyenDi.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Dat ban ve");
            stage.show();
        }else{
        
            Utils.getBox("Ban khong co quyen su dung", Alert.AlertType.INFORMATION).show();
        }
    }

    /**
     * @return the maNv
     */
    public int getMaNv() {
        return maNv;
    }

    /**
     * @param maNv the maNv to set
     */
    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    /**
     * @return the maLoaiNv
     */
    public int getMaLoaiNv() {
        return maLoaiNv;
    }

    /**
     * @param maLoaiNv the maLoaiNv to set
     */
    public void setMaLoaiNv(int maLoaiNv) {
        this.maLoaiNv = maLoaiNv;
    }


}
