/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class TuyenXe {
    private int maTuyen;
    private String tenTuyen;
    private String noiDi;
    private String noiDen;

    public TuyenXe(int maTuyen, String tenTuyen, String noiDi, String noiDen) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
    }

    public TuyenXe() {
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

    /**
     * @return the tenTuyen
     */
    public String getTenTuyen() {
        return tenTuyen;
    }

    /**
     * @param tenTuyen the tenTuyen to set
     */
    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
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
}
