/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.Xe;
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
public class DuLieuXe {
    public List<Xe> getXe() throws SQLException{
        List<Xe> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from xe");
            
            while(rs.next()){
                Xe x = new Xe(rs.getInt("maXe"), rs.getString("tenXe"), rs.getString("banSo"), rs.getInt("soGhe"));
                results.add(x);
        }
    }
        return results;
    }
}