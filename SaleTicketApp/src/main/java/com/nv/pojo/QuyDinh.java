/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.pojo;

/**
 *
 * @author DangNgocHoaiNam
 */
public class QuyDinh {
    private int maQuyDinh;
    private int thoiGianChamNhatDatVe;
    private int thoiGianChamNhatMuaVe;
    private int thoiGianChamNhatNhanVe;
    private int thoiGianChamDoiHuyVe;
    private int thoiGianVeThuHoi;

    public QuyDinh(int maQuyDinh, int thoiGianChamNhatDatVe, int thoiGianChamNhatMuaVe, int thoiGianChamNhatNhanVe, int thoiGianChamDoiHuyVe, int thoiGianVeThuHoi) {
        this.maQuyDinh = maQuyDinh;
        this.thoiGianChamNhatDatVe = thoiGianChamNhatDatVe;
        this.thoiGianChamNhatMuaVe = thoiGianChamNhatMuaVe;
        this.thoiGianChamNhatNhanVe = thoiGianChamNhatNhanVe;
        this.thoiGianChamDoiHuyVe = thoiGianChamDoiHuyVe;
        this.thoiGianVeThuHoi = thoiGianVeThuHoi;
    }

    public QuyDinh() {
    }

    /**
     * @return the maQuyDinh
     */
    public int getMaQuyDinh() {
        return maQuyDinh;
    }

    /**
     * @param maQuyDinh the maQuyDinh to set
     */
    public void setMaQuyDinh(int maQuyDinh) {
        this.maQuyDinh = maQuyDinh;
    }

    /**
     * @return the thoiGianChamNhatDatVe
     */
    public int getThoiGianChamNhatDatVe() {
        return thoiGianChamNhatDatVe;
    }

    /**
     * @param thoiGianChamNhatDatVe the thoiGianChamNhatDatVe to set
     */
    public void setThoiGianChamNhatDatVe(int thoiGianChamNhatDatVe) {
        this.thoiGianChamNhatDatVe = thoiGianChamNhatDatVe;
    }

    /**
     * @return the thoiGianChamNhatMuaVe
     */
    public int getThoiGianChamNhatMuaVe() {
        return thoiGianChamNhatMuaVe;
    }

    /**
     * @param thoiGianChamNhatMuaVe the thoiGianChamNhatMuaVe to set
     */
    public void setThoiGianChamNhatMuaVe(int thoiGianChamNhatMuaVe) {
        this.thoiGianChamNhatMuaVe = thoiGianChamNhatMuaVe;
    }

    /**
     * @return the thoiGianChamNhatNhanVe
     */
    public int getThoiGianChamNhatNhanVe() {
        return thoiGianChamNhatNhanVe;
    }

    /**
     * @param thoiGianChamNhatNhanVe the thoiGianChamNhatNhanVe to set
     */
    public void setThoiGianChamNhatNhanVe(int thoiGianChamNhatNhanVe) {
        this.thoiGianChamNhatNhanVe = thoiGianChamNhatNhanVe;
    }

    /**
     * @return the thoiGianChamDoiHuyVe
     */
    public int getThoiGianChamDoiHuyVe() {
        return thoiGianChamDoiHuyVe;
    }

    /**
     * @param thoiGianChamDoiHuyVe the thoiGianChamDoiHuyVe to set
     */
    public void setThoiGianChamDoiHuyVe(int thoiGianChamDoiHuyVe) {
        this.thoiGianChamDoiHuyVe = thoiGianChamDoiHuyVe;
    }

    /**
     * @return the thoiGianVeThuHoi
     */
    public int getThoiGianVeThuHoi() {
        return thoiGianVeThuHoi;
    }

    /**
     * @param thoiGianVeThuHoi the thoiGianVeThuHoi to set
     */
    public void setThoiGianVeThuHoi(int thoiGianVeThuHoi) {
        this.thoiGianVeThuHoi = thoiGianVeThuHoi;
    }
}
