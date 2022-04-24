/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.Xe;
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
    
     public int getSoLuongGhe(int maXe) throws SQLException{
    
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select soGhe from xe where maXe=?");
            stm.setInt(1, maXe);

            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){

                return rs.getInt(1);
            }

        }
        return 0;
        
    } 
     
     public String getBanSo(int maXe) throws SQLException{
    
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select banSo from xe where maXe=?");
            stm.setInt(1, maXe);

            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){

                return rs.getString(1);
            }

        }
        return null;
        
    }
     
     
}
