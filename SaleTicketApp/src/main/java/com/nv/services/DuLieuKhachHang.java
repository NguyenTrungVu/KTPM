/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;
import com.nv.pojo.ChuyenXe;
import com.nv.pojo.KhachHang;
import com.nv.saleticketapp.FXMLQuanLyChuyenDiController;
import com.nv.utils.JdbcUtils;
import com.nv.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author NguyenTrungVu
 */
public class DuLieuKhachHang {
    public List<KhachHang> getKhachHang() throws SQLException{
        List<KhachHang> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from khachhang");
            
            while(rs.next()){
                KhachHang k = new KhachHang(rs.getInt("maKh"), rs.getString("tenKh")
                        ,rs.getString("gioiTinh") , rs.getString("diaChi"), rs.getString("soDienThoai"));
                results.add(k);
        }
    }
        return results;
    }
    
    public void addKhachHang(String hoTen, String soDienThoai){
    
        try {

                Connection conn = JdbcUtils.getConn();
                PreparedStatement stm = conn.prepareStatement("INSERT INTO khachhang(tenKh, soDienThoai) VALUES(?, ?)");
                stm.setString(1, hoTen);
                stm.setString(2, soDienThoai);

                stm.executeUpdate();
                Utils.getBox("Da them khach hang moi", Alert.AlertType.CONFIRMATION).show();
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public int getMaKhachHangBySoDienThoai(String soDienThoai) throws SQLException{
        
        List<KhachHang> kh = getKhachHang();
        for(KhachHang k : kh){
            if(k.getSoDienThoai().compareTo(soDienThoai) == 0)
                return k.getMaKh();
        }

        return 0;
    }
}