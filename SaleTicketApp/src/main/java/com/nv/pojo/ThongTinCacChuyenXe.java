/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

import java.util.Date;

/**
 *
 * @author DangNgocHoaiNam
 */
public class ThongTinCacChuyenXe {
    private int maChuyenXe;
    private String noiDi;
    private String noiDen;
    private String ngayDi;
    private String gioKhoiHanh;
    private float gia;
    private int gheConTrong;

    public ThongTinCacChuyenXe() {
    }

    public ThongTinCacChuyenXe(int maChuyenXe, String noiDi, String noiDen, String ngayDi, String gioKhoiHanh, float gia, int gheConTrong) {
        this.maChuyenXe = maChuyenXe;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.ngayDi = ngayDi;
        this.gioKhoiHanh = gioKhoiHanh;
        this.gia = gia;
        this.gheConTrong = gheConTrong;
    }
    
    

    /**
     * @return the maChuyenXe
     */
    public int getMaChuyenXe() {
        return maChuyenXe;
    }

    /**
     * @param maChuyenXe the maChuyenXe to set
     */
    public void setMaChuyenXe(int maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    /**
     * @return the noiDi
     */
    public String getNoiDi() {
        return noiDi;
    }

    /**
     * @param noiDi the noiDi to set
     */
    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    /**
     * @return the noiDen
     */
    public String getNoiDen() {
        return noiDen;
    }

    /**
     * @param noiDen the noiDen to set
     */
    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    /**
     * @return the ngayDi
     */
    public String getNgayDi() {
        return ngayDi;
    }

    /**
     * @param ngayDi the ngayDi to set
     */
    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    /**
     * @return the gioKhoiHanh
     */
    public String getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    /**
     * @param gioKhoiHanh the gioKhoiHanh to set
     */
    public void setGioKhoiHanh(String gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    /**
     * @return the gia
     */
    public float getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(float gia) {
        this.gia = gia;
    }

    /**
     * @return the gheConTrong
     */
    public int getGheConTrong() {
        return gheConTrong;
    }

    /**
     * @param gheConTrong the gheConTrong to set
     */
    public void setGheConTrong(int gheConTrong) {
        this.gheConTrong = gheConTrong;
    }
}
