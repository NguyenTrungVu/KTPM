package com.nv.category;


import com.nv.pojo.ChuyenXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author inmac
 */
public class XoaChuyenXeTest {
    private static Connection conn;
    private static ChuyenXe cx; 
    private static DuLieuChuyenXe d = new DuLieuChuyenXe();
    
    
    @BeforeAll
    public static void beforeAll(){
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(XoaChuyenXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @AfterAll
    public static void afterAll(){
          if (conn != null){
              try {
                  conn.close();
              } catch (SQLException ex) {
                  Logger.getLogger(XoaChuyenXeTest.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
    }
    
    @Test
    public void xoaThanhCong(){
        try {
            d.xoaChuyenXe(22);
            ChuyenXe d1 = d.getChuyenXeByMa(22);
            Assertions.assertNull(d1);
        } catch (SQLException ex) {
            Logger.getLogger(XoaChuyenXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
//    
//    @Test
//    public void xoaThanhCong(){
//        try {
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery("select * from chuyenXe");
//            List <Integer> sl = new ArrayList<>();
//            while(rs.next()){
//                int id = rs.getInt("maChuyenXe");
//                sl.add(id);
//            }
//            
//            int ma = sl.size();
//            d.xoaChuyenXe(ma);
//            ChuyenXe d1 = d.getChuyenXeByMa(ma);
//            Assertions.assertNull(d1);
//        } catch (SQLException ex) {
//            Logger.getLogger(XoaChuyenXeTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//       
//    }
}
