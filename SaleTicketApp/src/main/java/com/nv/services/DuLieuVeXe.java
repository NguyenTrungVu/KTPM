/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.VeXe;
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
public class DuLieuVeXe {
     public List<VeXe> getVeXe() throws SQLException{
        List<VeXe> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from quydinh");
            
            while(rs.next()){
                VeXe vx = new VeXe( rs.getInt("maVe"), rs.getInt("maNv"), rs.getInt("maKh"), rs.getInt("maChuyenXe"));
                results.add(vx);
        }
    }
        return results;
    }
}
