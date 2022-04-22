/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class ChiTietVeXe {
    private int maChiTietVe;
    private int maVe;
    private int maXe;
    private String ghiChu;
    private int viTriGhe;

    public ChiTietVeXe() {
    }

    public ChiTietVeXe(int maChiTietVe, int maVe, int maXe, String ghiChu, int viTriGhe) {
        this.maChiTietVe = maChiTietVe;
        this.maVe = maVe;
        this.maXe = maXe;
        this.ghiChu = ghiChu;
        this.viTriGhe = viTriGhe;
    }
    
    
    

    /**
     * @return the maChiTietVe
     */
    public int getMaChiTietVe() {
        return maChiTietVe;
    }

    /**
     * @param maChiTietVe the maChiTietVe to set
     */
    public void setMaChiTietVe(int maChiTietVe) {
        this.maChiTietVe = maChiTietVe;
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
     * @return the maXe
     */
    public int getMaXe() {
        return maXe;
    }

    /**
     * @param maXe the maXe to set
     */
    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * @return the viTriGhe
     */
    public int getViTriGhe() {
        return viTriGhe;
    }

    /**
     * @param viTriGhe the viTriGhe to set
     */
    public void setViTriGhe(int viTriGhe) {
        this.viTriGhe = viTriGhe;
    }
}
