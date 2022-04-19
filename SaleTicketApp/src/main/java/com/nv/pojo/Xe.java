/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class Xe {
    private int maXe;
    private String tenXe;
    private String banSo;
    private int soGhe;

    public Xe() {
    }

    public Xe(int maXe, String tenXe, String banSo, int soGhe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.banSo = banSo;
        this.soGhe = soGhe;
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
     * @return the tenXe
     */
    public String getTenXe() {
        return tenXe;
    }

    /**
     * @param tenXe the tenXe to set
     */
    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
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
     * @return the soGhe
     */
    public int getSoGhe() {
        return soGhe;
    }

    /**
     * @param soGhe the soGhe to set
     */
    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
    
}
