/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author User
 */
public class ThucDonDTO {
    int maMon;
    int maNL;
    String tenMon;
    int gia;
    String soluongNL;

    public ThucDonDTO(int maNL, String tenMon, int gia) {
        this.maNL = maNL;
        this.tenMon = tenMon;
        this.gia = gia;
    }

    public ThucDonDTO(int maMon, int maNL, String tenMon, int gia, String soluongNL) {
        this.maMon = maMon;
        this.maNL = maNL;
        this.tenMon = tenMon;
        this.gia = gia;
        this. soluongNL = soluongNL;
    }

    public String getSoluongNL() {
        return soluongNL;
    }

    public void setSoluongNL(String soluongNL) {
        this.soluongNL = soluongNL;
    }

    public ThucDonDTO() {
        maMon = 0;
        maNL = 0;
        tenMon = null;
        gia = 0;
        soluongNL = null;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public int getMaNL() {
        return maNL;
    }

    public void setMaNL(int maNL) {
        this.maNL = maNL;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}
