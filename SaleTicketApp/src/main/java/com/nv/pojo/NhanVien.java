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
public class NhanVien {
    private int maNv;
    private String tenNv;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private int loaiNv;
    private String userName;
    private String passWord;

    public NhanVien() {
    }

    public NhanVien(int maNv, String tenNv, Date ngaySinh, String gioiTinh, String diaChi, String soDienThoai, int loaiNv, String tenDangNhap, String matKhau) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.loaiNv = loaiNv;
        this.userName = tenDangNhap;
        this.passWord = matKhau;
    }

    
    /**
     * @return the maNv
     */
    public int getMaNv() {
        return maNv;
    }

    /**
     * @param maNv the maNv to set
     */
    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    /**
     * @return the tenNv
     */
    public String getTenNv() {
        return tenNv;
    }

    /**
     * @param tenNv the tenNv to set
     */
    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    /**
     * @return the loaiNv
     */
    public int getLoaiNv() {
        return loaiNv;
    }

    /**
     * @param loaiNv the loaiNv to set
     */
    public void setLoaiNv(int loaiNv) {
        this.loaiNv = loaiNv;
    }

    /**
     * @return the tenDangNhap
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param tenDangNhap the tenDangNhap to set
     */
    public void setUserName(String tenDangNhap) {
        this.userName = tenDangNhap;
    }

    /**
     * @return the matkhau
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param matkhau the matkhau to set
     */
    public void setPassWord(String matkhau) {
        this.passWord = matkhau;
    }
}
