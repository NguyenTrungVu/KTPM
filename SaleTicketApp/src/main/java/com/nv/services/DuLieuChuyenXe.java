/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.ChuyenXe;
import com.nv.saleticketapp.FXMLQuanLyChuyenDiController;
import com.nv.utils.JdbcUtils;
import com.nv.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author DangNgocHoaiNam
 */
public class DuLieuChuyenXe {
    public List<ChuyenXe> getChuyenXe() throws SQLException{
    
        List<ChuyenXe> results = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from chuyenxe");
            
            while(rs.next()){
            
                ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"), rs.getString("tenChuyenXe"), rs.getString("gioKhoiHanh"), rs.getDate("ngayDi"), rs.getFloat("gia"), rs.getInt("maTuyen"), rs.getInt("maXe"));
                results.add(c);
            }
        }
        return results;
    }
    
    public List<ChuyenXe> timKiemChuyenXe(int maTuyen, String ngayKhoiHanh) throws SQLException{
        
        List<ChuyenXe> results = new ArrayList<>();
        
        List<ChuyenXe> data = getChuyenXe();
        
        for (ChuyenXe d: data){
            if(d.getMaTuyen() == maTuyen && d.getNgayDi().toString().compareTo(ngayKhoiHanh) == 0){
                
                results.add(d);
            }
        }
        return results;
        
        
    }
    
    
    public void addChuyenXe(ChuyenXe c) throws SQLException{
    
            
        Connection conn = JdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement("INSERT INTO chuyenxe(tenChuyenXe, gioKhoiHanh, ngayDi, gia, maTuyen, maXe) VALUES(?, ?, ?, ?, ?, ?)");
        stm.setString(1, c.getTenChuyenXe());
        stm.setString(2, c.getGioKhoiHanh());
        stm.setDate(3, (java.sql.Date) c.getNgayDi());
        stm.setFloat(4, c.getGia());
        stm.setInt(5, c.getMaTuyen());
        stm.setInt(6, c.getMaXe());

        stm.executeUpdate();
                    
                

    }
    
    
    public void suaChuyenXe(ChuyenXe c) throws SQLException{
        Connection conn = JdbcUtils.getConn();
            PreparedStatement stm = conn.prepareStatement("UPDATE chuyenxe set tenChuyenXe = ?, gioKhoiHanh = ?, ngayDi = ?, gia = ?, maTuyen = ?, maXe = ? where maChuyenXe=?");

            stm.setString(1, c.getTenChuyenXe());
            stm.setString(2, c.getGioKhoiHanh());
            stm.setString(3, c.getNgayDi().toString());
            stm.setFloat(4, c.getGia());
            stm.setInt(5, c.getMaTuyen());
            stm.setInt(6, c.getMaXe());
            stm.setInt(7, c.getMaChuyenXe());
            stm.executeUpdate();
        
    }
    
    public void xoaChuyenXe(int maChuyen) throws SQLException{
    Connection conn = JdbcUtils.getConn();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM chuyenxe WHERE maChuyenXe = ?");
            stm.setInt(1, maChuyen);
            stm.executeUpdate();
            
        
    }
    
    public String getTenChuyenXeByMa(int maChuyenXe) throws SQLException{
    
        List<ChuyenXe> data = getChuyenXe();
        
        for (ChuyenXe d: data){
            if(d.getMaChuyenXe() == maChuyenXe){
                return d.getTenChuyenXe();
            }
        }
        return null;
    }
    
    public ChuyenXe getChuyenXeByMa(int maChuyenXe) throws SQLException{
        List<ChuyenXe> data = getChuyenXe();
        for(ChuyenXe d: data){
            if(d.getMaChuyenXe() == maChuyenXe){
                return d;
            }
        }
        return null;
    }

    
    public int getMaTuyenByMa(int maChuyenXe) throws SQLException{
    
        List<ChuyenXe> data = getChuyenXe();
        
        for (ChuyenXe d: data){
            if(d.getMaChuyenXe()== maChuyenXe){
                return d.getMaTuyen();
            }
        }
        return 0;
    }
    
    public int getMaXeByMa(int maChuyenXe) throws SQLException{
    
        List<ChuyenXe> data = getChuyenXe();
        
        for (ChuyenXe d: data){
            if(d.getMaChuyenXe()== maChuyenXe){
                return d.getMaXe();
            }
        }
        return 0;
    }
    
    
    public float getGiaXeByMa(int maChuyenXe) throws SQLException{
    
        List<ChuyenXe> data = getChuyenXe();
        
        for (ChuyenXe d: data){
            if(d.getMaChuyenXe()== maChuyenXe){
                return d.getGia();
            }
        }
        return 0;
    }
    
    public Date getNgayKhoiHanhByMa(int maChuyenXe) throws SQLException{
    

        try (Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select ngayDi from chuyenxe where maChuyenXe = ?");
            stm.setInt(1, maChuyenXe);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                return rs.getDate(1);
            }
        }
        return new Date(0);
    }
    
    public Date getNgayKhoiHanh2ByMa(int maChuyenXe) throws SQLException{
    

        try (Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select ngayDi from chuyenxe where maChuyenXe = ?");
            stm.setInt(1, maChuyenXe);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                return rs.getTimestamp(1);
            }
        }
        return new Date(0);
    }
    
    public String getGioKhoiHanhByMa(int maChuyenXe) throws SQLException{
    

        try (Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select gioKhoiHanh from chuyenxe where maChuyenXe = ?");
            stm.setInt(1, maChuyenXe);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                return rs.getString(1);
            }
        }
        return null;
    }
}
