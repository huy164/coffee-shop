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
public class NhapHangDTO {
    private String MaCTN;
    private String MaHANG;
    private String MaNCC;
    private String MaNV;
    private String NgayNhap;
    private String SLNhap;

    public NhapHangDTO() 
    {
        this.MaCTN = null;
        this.MaHANG = null;
        this.MaNCC = null;
        this.MaNV = null;
        this.NgayNhap = null;
        this.SLNhap = null;
    }

    public NhapHangDTO(String MaCTN, String MaHANG, String MaNCC, String MaNV, String NgayNhap, String SLNhap) 
    {
        this.MaCTN = MaCTN;
        this.MaHANG = MaHANG;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.SLNhap = SLNhap;
    }

    public String getMaCTN() {
        return MaCTN;
    }

    public String getMaHANG() {
        return MaHANG;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public String getSLNhap() {
        return SLNhap;
    }

    public void setMaCTN(String MaCTN) {
        this.MaCTN = MaCTN;
    }

    public void setMaHANG(String MaHANG) {
        this.MaHANG = MaHANG;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setSLNhap(String SLNhap) {
        this.SLNhap = SLNhap;
    }
    
    
    
}
