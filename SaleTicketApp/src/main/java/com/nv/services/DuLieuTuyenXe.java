/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.TuyenXe;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DangNgocHoaiNam
 */
public class DuLieuTuyenXe {
     public List<TuyenXe> getTuyenXe() throws SQLException{
    
        List<TuyenXe> results = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from tuyenxe");
            
            while(rs.next()){
            
                TuyenXe t = new TuyenXe(rs.getInt("maTuyen"), rs.getString("tenTuyen"), rs.getString("noiDi"), rs.getString("noiDen"));
                results.add(t);
            }
        }
        return results;
    }
     
     
     public int getMaTuyen(String noiDi, String noiDen){
     
         List<TuyenXe> rs = new ArrayList<>();
         
         try {
             rs = getTuyenXe();
         } catch (SQLException ex) {
             Logger.getLogger(DuLieuTuyenXe.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         for(TuyenXe t : rs){
         
             if(t.getNoiDi().compareTo(noiDi) == 0 && t.getNoiDen().compareTo(noiDen) == 0)
                 return t.getMaTuyen();
         }   
         
         return 0;
     }
}
