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
public class NCC_DTO {
     private String MaNCC;
    private String TenNCC;
    private String DChi;
    private String SDT;

    public NCC_DTO() 
    {
        MaNCC = null;
        TenNCC = null;
        DChi = null;
        SDT = null;
    }

    public NCC_DTO(String MaNCC, String TenNCC, String DChi, String SDT) 
    {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DChi = DChi;
        this.SDT = SDT;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public String getDChi() {
        return DChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public void setDChi(String DChi) {
        this.DChi = DChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
