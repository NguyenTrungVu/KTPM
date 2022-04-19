/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class LoaiNhanVien {
    private int maLoaiNv;
    private String tenLoaiNv;

    public LoaiNhanVien() {
    }

    public LoaiNhanVien(int maLoaiNv, String tenLoaiNv) {
        this.maLoaiNv = maLoaiNv;
        this.tenLoaiNv = tenLoaiNv;
    }
    
    

    /**
     * @return the maLoaiNv
     */
    public int getMaLoaiNv() {
        return maLoaiNv;
    }

    /**
     * @param maLoaiNv the maLoaiNv to set
     */
    public void setMaLoaiNv(int maLoaiNv) {
        this.maLoaiNv = maLoaiNv;
    }

    /**
     * @return the tenLoaiNv
     */
    public String getTenLoaiNv() {
        return tenLoaiNv;
    }

    /**
     * @param tenLoaiNv the tenLoaiNv to set
     */
    public void setTenLoaiNv(String tenLoaiNv) {
        this.tenLoaiNv = tenLoaiNv;
    }
}
