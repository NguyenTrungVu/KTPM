/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.NhanVien;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
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
                        ,rs.getString("gioiTinh"), rs.getString("diaChi"), rs.getString("soDienThoai"), rs.getInt("loaiNv"));
                results.add(nv);
        }
    }
        return results;
    }
}
