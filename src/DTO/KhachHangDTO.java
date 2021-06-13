/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class KhachHangDTO {
     private String MaKH;
     private String TenKH;
     private String GioiTinhKH;
     private String SDT;
     private int DTL;

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getGioiTinhKH() {
        return GioiTinhKH;
    }

    public void setGioiTinhKH(String GioiTinhKH) {
        this.GioiTinhKH = GioiTinhKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getDTL() {
        return DTL;
    }

    public void setDTL(int DTL) {
        this.DTL = DTL;
    }

    public KhachHangDTO() {
    }

    public KhachHangDTO(String TenKH, String GioiTinhKH, String SDT, int DTL) {
        this.TenKH = TenKH;
        this.GioiTinhKH = GioiTinhKH;
        this.SDT = SDT;
        this.DTL = DTL;
    }
     
}

