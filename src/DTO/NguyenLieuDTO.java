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
public class NguyenLieuDTO {
    String maNL;
    String tenNL;
    String HSD;
    String slCon;
    String congDung;

    public NguyenLieuDTO(String maNL, String tenNL, String HSD, String slCon, String congDung) 
    {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.HSD = HSD;
        this.slCon = slCon;
        this.congDung = congDung;
    }

    public NguyenLieuDTO() 
    {
        this.maNL = null;
        this.tenNL = null;
        this.HSD = null;
        this.slCon = null;
        this.congDung = null;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public void setSlCon(String slCon) {
        this.slCon = slCon;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }
    
    

    public String getMaNL() {
        return maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getHSD() {
        return HSD;
    }

    public String getSlCon() {
        return slCon;
    }

    public String getCongDung() {
        return congDung;
    }
    
    
    
}
