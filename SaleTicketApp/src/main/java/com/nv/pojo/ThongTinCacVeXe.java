/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

import java.util.Date;

/**
 *
 * @author inmac
 */
public class ThongTinCacVeXe {
    private int maVe;
    private String banSo;
    private String noiDi;
    private String noiDen;
    private Date ngayDi;
    private String hoTen;
    private String soDienThoai;
    private String viTriGhe;
    private Float gia;

    public ThongTinCacVeXe() {
    }

    public ThongTinCacVeXe(int maVe, String banSo, String noiDi, String noiDen, 
            Date ngayDi, String hoTen, String soDienThoai, String viTriGhe, Float gia) {
        this.maVe = maVe;
        this.banSo = banSo;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.ngayDi = ngayDi;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.viTriGhe = viTriGhe;
        this.gia = gia;
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
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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
     * @return the viTriGhe
     */
    public String getViTriGhe() {
        return viTriGhe;
    }

    /**
     * @param viTriGhe the viTriGhe to set
     */
    public void setViTriGhe(String viTriGhe) {
        this.viTriGhe = viTriGhe;
    }

    /**
     * @return the maVe
     */
    public int getMaVe() {
        return maVe;
    }

    /**
     * @param maVe the maVe to set
     */
    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    /**
     * @return the banSo
     */
    public String getBanSo() {
        return banSo;
    }

    /**
     * @param banSo the banSo to set
     */
    public void setBanSo(String banSo) {
        this.banSo = banSo;
    }

    /**
     * @return the gia
     */
    public Float getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(Float gia) {
        this.gia = gia;
    }
    
    
    
}
