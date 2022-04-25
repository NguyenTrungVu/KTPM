/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author inmac
 */
public class ThemChuyenDiTest {
    private static Connection conn;
    private static ChuyenXe cx; 
    private static DuLieuChuyenXe d = new DuLieuChuyenXe();
    
    @BeforeAll
    public static void beforeAll(){
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(ThemChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @AfterAll
    public static void afterAll(){
        if (conn !=null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThemChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void themThanhCong(){
        Date ngay = null;
        LocalDate currentDate = LocalDate.now();
                ngay = java.sql.Date.valueOf(currentDate.toString());
        cx = new ChuyenXe(0, "BD_KT2", "", ngay, 200000, 1, 1);
        try {
            d.addChuyenXe(cx);
            ChuyenXe d1 = d.getChuyenXeByMa(cx.getMaChuyenXe());
            Assertions.assertEquals(cx.getTenChuyenXe(), d1.getTenChuyenXe());
            Assertions.assertEquals(cx.getMaChuyenXe(), d1.getMaChuyenXe());
        } catch (SQLException ex) {
            Logger.getLogger(ThemChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
}
