/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.ChuyenXe;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            
                ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"), rs.getString("tenChuyenXe"), rs.getString("gioKhoiHanh"), rs.getString("ngayDi"), rs.getFloat("gia"), rs.getInt("maTuyen"), rs.getInt("maXe"));
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
}
