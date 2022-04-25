/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.category;

import com.nv.pojo.ChiTietVeXe;
import com.nv.pojo.ChuyenXe;
import com.nv.pojo.VeXe;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuKhachHang;
import com.nv.services.DuLieuVeXe;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author inmac
 */
public class VeXeTest {
    private static Connection conn;
    private static VeXe ve ;
    private static DuLieuVeXe dv = new DuLieuVeXe();
    private static ChiTietVeXe ct = new ChiTietVeXe();
    private static DuLieuChiTietVeXe dc;
    private static DuLieuKhachHang kh = new DuLieuKhachHang();
    
    @BeforeAll
    public static void beforeAll(){
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @AfterAll
    public static void afterAll(){
        if (conn !=null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test 
    public void getDanhSachMaVeByMaChuyen(){
        List<Integer> ma = new ArrayList<>();
        try {
            ma = dv.getMaVeXe(1);
            Assertions.assertEquals(2,ma.size());
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void getVeXeDonByMa(){
        try {
            int ma = dv.getMaVeXeDon(4);
            Assertions.assertEquals(4, ma);
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void themThanhCong(){
        ve = new VeXe(0, 1, 3, 2, true);
        dv.addVeXe(ve);
        VeXe v1 = dv.getVe(ve.getMaVe());
        Assertions.assertEquals(ve.getMaVe(), v1.getMaVe());
        
        
    }
    @Test
    public void getMaVeVuaDat(){
        try {
            int ma = dv.getMaVeVuaDat();
            Assertions.assertEquals(27, ma);
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    @ParameterizedTest
    @CsvSource({"1,true",  "26, true",})
    public void getTrangThaiVeTonTai(int n){
        try {
            Assertions.assertTrue(dv.getTrangThaiVe(n));
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @ParameterizedTest
    @CsvSource({ "5, false", "30, false"})
    public void getTrangThaiVeKhongTonTai(int n){
        try {
            Assertions.assertFalse(dv.getTrangThaiVe(n));
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void timVe(){
        String sdt = "12345678";
        try {
            int makh = kh.getMaKhachHangBySoDienThoai(sdt);
            Assertions.assertEquals(4, dv.getmaVeByMaKhach(makh).size());
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void suaVe(){
        int m = 2;
        int vt = 5;
        try {
           VeXe v1 = dv.getVe(m);
           v1.setMaChuyenXe(3);
           dv.suaVeXe(v1.getMaChuyenXe(), vt, m);
           VeXe v2 = dv.getVe(v1.getMaVe());
           Assertions.assertEquals(v1.getMaChuyenXe(), v2.getMaChuyenXe());
           
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void xoaVeThanhCong(){
        int ma = 28;
        try {
            dv.xoaVeXe(ma);
            Assertions.assertNull(dv.getVe(ma));
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void nhanVeThanhCong(){
        int ma = 27;
        try {
            VeXe v1 = dv.getVe(ma);
            v1.setTrangThaiVe(true);
            dv.nhanVe(v1.getMaVe());
            Assertions.assertTrue(v1.getTrangThaiVe());
        } catch (SQLException ex) {
            Logger.getLogger(VeXeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
