/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.NhanVien;
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
 * @author inmac
 */
public class DuLieuNhanVien {
    public List<NhanVien> getNhanVien() throws SQLException{
        List<NhanVien> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from nhanvien");
            
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt("maNv"), rs.getString("tenNv"), rs.getDate("ngaySinh")
                        ,rs.getString("gioiTinh"), rs.getString("diaChi"), rs.getString("soDienThoai"), rs.getInt("loaiNv"), rs.getString("userName"), rs.getString("passWord"));
                results.add(nv);
        }
    }
        return results;
    }
    
    public int getMaLoaiNhanVienByMa(int maNv) throws SQLException{
    
        try(Connection conn = JdbcUtils.getConn()){
                  PreparedStatement stm = conn.prepareStatement("select loaiNv from nhanvien where maNv=?");
                  stm.setInt(1, maNv);

                  ResultSet rs = stm.executeQuery();

                  while(rs.next()){
                      return rs.getInt(1);
                  }

        }
        return 0;
        

        
    }
    
    
    public String getTenNhanVienByMa(int maNv) throws SQLException{
    
        try(Connection conn = JdbcUtils.getConn()){
                  PreparedStatement stm = conn.prepareStatement("select tenNv from nhanvien where maNv=?");
                  stm.setInt(1, maNv);

                  ResultSet rs = stm.executeQuery();

                  while(rs.next()){
                      return rs.getString(1);
                  }

        }
        return null;
    }
}
