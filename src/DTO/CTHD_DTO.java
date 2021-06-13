/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MSI2
 */
public class CTHD_DTO {
    private String MaKH;
    private String MaBan;
    private String MaMon;
    private String MaHD;
    private String SL;

    public CTHD_DTO(String MaKH, String MaBan, String MaMon, String MaHD, String SL) 
    {
        this.MaKH = MaKH;
        this.MaBan = MaBan;
        this.MaMon = MaMon;
        this.MaHD = MaHD;
        this.SL = SL;
    }

    public CTHD_DTO() 
    {
        this.MaKH = "0";
        this.MaBan = "0";
        this.MaMon = "0";
        this.MaHD = "0";
        this.SL = "0";
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaBan() {
        return MaBan;
    }

    public String getMaMon() {
        return MaMon;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getSL() {
        return SL;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setSL(String SL) {
        this.SL = SL;
    }
    
    
    
    
    
    
}
