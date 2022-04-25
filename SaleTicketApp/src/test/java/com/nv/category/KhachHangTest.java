/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.category;

import com.nv.pojo.KhachHang;
import com.nv.services.DuLieuKhachHang;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author inmac
 */
public class KhachHangTest {
    private static Connection conn;
    private static DuLieuKhachHang k = new DuLieuKhachHang();
    private static KhachHang kh;
    
     @BeforeAll
    public static void beforeAll(){
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @AfterAll
    public static void afterAll(){
        if (conn !=null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @ParameterizedTest
    @CsvSource({"382890580,1", "12345678,2"})
    public void getMaKhachHangBySoDtDung(String n, int expected){
        try {
            Assertions.assertEquals(k.getMaKhachHangBySoDienThoai(n), expected);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @ParameterizedTest
    @CsvSource({"382890580424324,0"})
    public void getMaKhachHangBySoDtSai(String n, int expected){
        try {
            Assertions.assertEquals(k.getMaKhachHangBySoDienThoai(n), expected);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void addKhachHangTest(){
        String ten = "TienAnh";
        String sdt = "0394394394";
        k.addKhachHang(ten, sdt);
        try {
            KhachHang k1 = k.getKhachHangBySoDienThoai(sdt);
            Assertions.assertEquals(ten, k1.getTenKh());
            Assertions.assertEquals(sdt, k1.getSoDienThoai());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
