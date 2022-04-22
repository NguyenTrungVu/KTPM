/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.VeXe;
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
 * @author inmac
 */
public class DuLieuVeXe {
     public List<VeXe> getVeXe() throws SQLException{
        List<VeXe> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from vexe");
            
            while(rs.next()){
                VeXe vx = new VeXe( rs.getInt("maVe"), rs.getInt("maNv"), rs.getInt("maKh"), rs.getInt("maChuyenXe"), rs.getBoolean("trangThaiVe"));
                results.add(vx);
        }
    }
        return results;
    }
     
    public int getSoLuongVeDaDat(int maChuyen) throws SQLException{
    
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select count(*) from vexe where maChuyenXe=?");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                return rs.getInt(1);
            }

        }
        return 0;
        
    } 
    
    public List<Integer> getMaVeXe(int maChuyen) throws SQLException{
    
        List<Integer> cacVeXe = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("SELECT maVe FROM vexe where maChuyenXe=?;");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                cacVeXe.add(rs.getInt(1));
            }

        }
        return cacVeXe;
        
    } 
    
    public int getMaVeXeDon(int maChuyen) throws SQLException{
    

        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("SELECT maVe FROM vexe where maChuyenXe=?");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }

        }
        return 0;
        
    } 
    public void addVeXe(VeXe veXe){
    
         try {
                    
            Connection conn = JdbcUtils.getConn();
            PreparedStatement stm = conn.prepareStatement("INSERT INTO vexe(maNv, maKh, maChuyenXe, trangThaiVe) VALUES(?, ?, ?, ?)");
            stm.setInt(1, veXe.getMaNv());
            stm.setInt(2, veXe.getMaKh());
            stm.setInt(3, veXe.getMaChuyenXe());
            stm.setBoolean(4, veXe.getTrangThaiVe());

            stm.executeUpdate();
            Utils.getBox("Them ve xe thanh cong", Alert.AlertType.CONFIRMATION).show();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLQuanLyChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public int getMaVeVuaDat() throws SQLException{
    
        Connection conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select maVe FROM ticketdb.vexe  order by maVe desc Limit 1; ");
        
        while(rs.next()){
        
            return rs.getInt(1);
        }
        return 0;
    }

    
    
     
}
