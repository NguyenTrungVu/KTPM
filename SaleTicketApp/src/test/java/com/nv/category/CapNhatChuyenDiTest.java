/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.category;

import com.nv.pojo.ChuyenXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
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
public class CapNhatChuyenDiTest {
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
    public void capNhatThanhCong(){ 
        try {
            int a = 3;
            ChuyenXe x1 = d.getChuyenXeByMa(a);
            x1.setMaXe(1);
            x1.setTenChuyenXe("SG_BD_PT");
            d.suaChuyenXe(x1);
            ChuyenXe d1 = d.getChuyenXeByMa(x1.getMaChuyenXe());
            Assertions.assertEquals(x1.getTenChuyenXe(), d1.getTenChuyenXe());
            Assertions.assertEquals(x1.getMaXe(), d1.getMaXe());
        } catch (SQLException ex) {
            Logger.getLogger(ThemChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
