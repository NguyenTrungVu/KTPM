/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class VeXe {
    private int maVe;
    private int maNv;
    private int maKh;
    private int maChuyenXe;

    public VeXe() {
    }

    public VeXe(int maVe, int maNv, int maKh, int maChuyenXe) {
        this.maVe = maVe;
        this.maNv = maNv;
        this.maKh = maKh;
        this.maChuyenXe = maChuyenXe;
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
}
