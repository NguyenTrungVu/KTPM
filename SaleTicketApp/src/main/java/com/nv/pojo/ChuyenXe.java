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
public class ChuyenXe {
    private int maChuyenXe;
    private String tenChuyenXe;
    private String gioKhoiHanh;
    private Date ngayDi;
    private float gia;
    private int maTuyen;

    public ChuyenXe() {
    }

    public ChuyenXe(int maChuyenXe, String tenChuyenXe, String gioKhoiHanh, Date ngayDi, float gia, int maTuyen) {
        this.maChuyenXe = maChuyenXe;
        this.tenChuyenXe = tenChuyenXe;
        this.gioKhoiHanh = gioKhoiHanh;
        this.ngayDi = ngayDi;
        this.gia = gia;
        this.maTuyen = maTuyen;
    }

//    @Override
//    public String toString() {
//        return this.tenChuyenXe; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//    }
    
    

    
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
     * @return the tenChuyenXe
     */
    public String getTenChuyenXe() {
        return tenChuyenXe;
    }

    /**
     * @param tenChuyenXe the tenChuyenXe to set
     */
    public void setTenChuyenXe(String tenChuyenXe) {
        this.tenChuyenXe = tenChuyenXe;
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
     * @return the ngayDi
     */
    public Date getNgayDi() {
        return ngayDi;
    }

    /**
     * @param ngayDi the ngayDi to set
     */
    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
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
     * @return the maTuyen
     */
    public int getMaTuyen() {
        return maTuyen;
    }

    /**
     * @param maTuyen the maTuyen to set
     */
    public void setMaTuyen(int maTuyen) {
        this.maTuyen = maTuyen;
    }
}
