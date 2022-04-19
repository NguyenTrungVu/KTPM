/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class KhachHang {
    private int maKh;
    private String tenKh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;

    public KhachHang() {
    }

    public KhachHang(int maKh, String tenKh, String gioiTinh, String diaChi, String soDienThoai) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    
    /**
     * @return the maKh
     */
    public int getMaKh() {
        return maKh;
    }

    /**
     * @param maKh the maKh to set
     */
    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    /**
     * @return the tenKh
     */
    public String getTenKh() {
        return tenKh;
    }

    /**
     * @param tenKh the tenKh to set
     */
    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the soDienThoai
     */
    public String getSoDienThoai() {
        return soDienThoai;
    }

    /**
     * @param soDienThoai the soDienThoai to set
     */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
}
