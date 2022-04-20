/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.ChiTietVeXe;
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
public class DuLieuChiTietVeXe {
    public List<ChiTietVeXe> getChiTietVeXe() throws SQLException{
        List<ChiTietVeXe> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from quydinh");
            
            while(rs.next()){
                ChiTietVeXe  x = new ChiTietVeXe(rs.getInt("maChiTietVe"), rs.getInt("maVe"), rs.getInt("maXe"), rs.getString("ghiChu"), rs.getString("viTriGhe"));
                results.add(x);
        }
    }
        return results;
    }
}
