/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.category;

import com.nv.pojo.ChuyenXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuXe;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author inmac
 */
public class TraCuuChuyenDiTest {
     private static DuLieuChuyenXe d = new DuLieuChuyenXe();
     private static DuLieuXe x = new DuLieuXe();
     private static DuLieuTuyenXe tx = new DuLieuTuyenXe();

    
    @Test
    public void getTenChuyenByMaSai(){
        String m;
         try {
             m = d.getTenChuyenXeByMa(10);
              Assertions.assertEquals(m, null);
         } catch (SQLException ex) {
             Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @ParameterizedTest
    @CsvSource({"2,SaiGon-KonTom", "3,SG-BD_PT", "5,"})
    public void getTenChuyenByMaDung(int n, String expected){
         try {
             Assertions.assertEquals(d.getTenChuyenXeByMa(n), expected);
         } catch (SQLException ex) {
             Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
     @Test
    public void getSlGheByMa(){
        try { 
            int sl = x.getSoLuongGhe(2);
            Assertions.assertEquals(sl, 5);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void getSlGheByMaSai(){
        try {
            int sl = x.getSoLuongGhe(6);
            Assertions.assertEquals(sl, 0);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void getNoiDiByMaSai(){
        String t;
        t = tx.getNoiDenByMa(5);
        Assertions.assertNull(t);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1,3})
    public void getNoiDiByMaDung(int n) throws SQLException{
        String a = tx.getNoiDiByMa(n);
        Assertions.assertEquals(a, "SaiGon");
    }
    
    
    @Test

    public void getNoiDenByMaSai(){
        String t;
        t = tx.getNoiDenByMa(5);
        Assertions.assertNull(t);
    }
    @Test
    public void getNoiDenByMaDung() throws SQLException{
        String a = tx.getNoiDenByMa(3);
        Assertions.assertEquals(a, "KomTom");
    }
    
    
    @Test
    public void getNgayKhoiHanhByMaSai(){
            Date t = new Date(0);
            Date m;
        try {
            m = d.getNgayKhoiHanhByMa(10);
            Assertions.assertEquals(m, t);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    @ParameterizedTest
    @CsvSource({"2,2022-04-22 00:00:00.0", "3,2022-04-23 00:00:00.0", })
    public void getNgayKhoiHanhByMaDung(int n, Timestamp expected){
        try { 
            Assertions.assertEquals(d.getNgayKhoiHanhByMa(n), expected);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void getMaXeByMaSai(){
        try {
            int m = d.getMaXeByMa(10);
            Assertions.assertEquals(m, 0);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @ParameterizedTest
    @CsvSource({"2,2", "3,1", "5,0"})
    public void getMaXeByMaDung(int n, int expected){
        try {
            Assertions.assertEquals(d.getMaXeByMa(n), expected);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @Test
    public void getMaTuyenByTenSai(){
        int t = tx.getMaTuyenByTenTuyen("abc");
        Assertions.assertEquals(t, 0);
    }

    @Test
    public void getNoiDiByMaDung() throws SQLException{
        int a = tx.getMaTuyenByTenTuyen("SG-BD");
        Assertions.assertEquals(a, 1);
    }
    
    @Test
    public void getMaTuyenByNoiSai(){
        int t = tx.getMaTuyenByNoiDiNoiDen("SaiGon", "NhaTrang");
        Assertions.assertEquals(t, 0);
    }
    
    
    @Test

    public void getMaTuyenByNoiDung(){
        int a = tx.getMaTuyenByNoiDiNoiDen("SaiGon", "KomTom");
        Assertions.assertEquals(a, 3);
    }
    
    
    @Test
    public void getMaTuyenByMaSai(){
        try {
            int m = d.getMaTuyenByMa(10);
            Assertions.assertEquals(m, 0);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @ParameterizedTest
    @CsvSource({"2,3", "3,1", "5,0"})
    public void getMaTuyenByMaDung(int n, int expected){
        try {
            Assertions.assertEquals(d.getMaTuyenByMa(n), expected);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void getDanhSachByMaSai(){
        int maTuyen = 0;
        String ngay = "2022-05-20";
         try {
             List<ChuyenXe> c = d.timKiemChuyenXe(maTuyen, ngay);           
             Assertions.assertEquals(c.size(), 0);
         } catch (SQLException ex) {
             Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    @ParameterizedTest
    @CsvSource({"3,2022-04-20"})
    public void getDanhSachByMaDung(int n, String expected){
        try { 
            List <ChuyenXe> c = d.timKiemChuyenXe(n, expected);
            Assertions.assertEquals(c.size(), 0);
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuChuyenDiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
