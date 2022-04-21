/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.VeXe;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inmac
 */
public class DuLieuVeXe {
     public List<VeXe> getVeXe() throws SQLException{
        List<VeXe> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from vexe");
            
            while(rs.next()){
                VeXe vx = new VeXe( rs.getInt("maVe"), rs.getInt("maNv"), rs.getInt("maKh"), rs.getInt("maChuyenXe"));
                results.add(vx);
        }
    }
        return results;
    }
<<<<<<< HEAD
    public List<VeXe> getMaVe(int maKh) throws SQLException{
        List <VeXe> cacVeXe = new ArrayList<>();
        List <VeXe> data = getVeXe();
        for(VeXe d: data){
            if(d.getMaChuyenXe() == maKh)
                cacVeXe.add(d);
        }
        return cacVeXe;
        
    } 
    public int getMaChuyenXe(int maKh) throws SQLException{
        
        
        try(Connection conn = JdbcUtils.getConn()){
            
            PreparedStatement  stm = conn.prepareStatement("select maChuyenXe from vexe where maKh = ?;");
            stm.setInt(1, maKh);
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
        }
    }
        return 0;
    }
     public int getMaVeXeDon(int maChuyen) throws SQLException{
    

        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("SELECT maVe FROM vexe where maChuyenXe=?");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
=======
     
    public int getSoLuongVeDaDat(int maChuyen) throws SQLException{
    
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("select count(*) from vexe where maChuyenXe=?");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
            
>>>>>>> c34f80dac7e8c653868678e5b609a2fbc533f82a
            while(rs.next()){
                return rs.getInt(1);
            }

        }
        return 0;
        
    } 
    
    public List<Integer> getMaVeXe(int maChuyen) throws SQLException{
    
        List<Integer> cacVeXe = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("SELECT maVe FROM vexe where maChuyenXe=?;");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                cacVeXe.add(rs.getInt(1));
            }

        }
        return cacVeXe;
        
    } 
<<<<<<< HEAD
=======
    
    public int getMaVeXeDon(int maChuyen) throws SQLException{
    

        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("SELECT maVe FROM vexe where maChuyenXe=?");
            stm.setInt(1, maChuyen);

            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }

        }
        return 0;
        
    } 
    
     
>>>>>>> c34f80dac7e8c653868678e5b609a2fbc533f82a
}
