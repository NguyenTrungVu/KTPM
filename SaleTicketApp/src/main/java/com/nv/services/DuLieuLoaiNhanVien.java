/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.LoaiNhanVien;
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
public class DuLieuLoaiNhanVien {
    public List<LoaiNhanVien> getLoaiNhanVien() throws SQLException{
        List<LoaiNhanVien> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from loainhanvien");
            
            while(rs.next()){
                LoaiNhanVien l = new LoaiNhanVien(rs.getInt("maLoaiNv"), rs.getString("tenLoaiNv"));
                results.add(l);
        }
    }
        return results;
    }
}
