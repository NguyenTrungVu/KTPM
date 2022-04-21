/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;
import com.nv.pojo.KhachHang;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public String getHoTen(String soDienThoai) throws SQLException{
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement  stm = conn.prepareStatement("select tenKh from khachhang where soDienThoai=?;");
            stm.setString(1, soDienThoai);
            
            ResultSet rs = stm.executeQuery();
            
            
            while(rs.next()){
                return rs.getString(1);
        }
    }
        return null;
    }
    public int getMaKh(String soDienThoai) throws SQLException{
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement  stm = conn.prepareStatement("select maKh from khachhang where  soDienThoai=?;");
            stm.setString(1, soDienThoai);
            
            ResultSet rs = stm.executeQuery();
            
            
            while(rs.next()){
                return rs.getInt(1);
        }
    }
        return 0;
    
    }
}
