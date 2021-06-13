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
public class HANGHOADTO {
   private String MaHang;
   private String MaNCC;
   private String TenHang;
   private String Donvi;
   private String soluong;
   private String Dongia;
   private String Thanhtien;

    public HANGHOADTO() 
    {
        this.MaHang = null;
        this.MaNCC = null;
        this.TenHang = null;
        this.Donvi = null;
        this.soluong = null;
        this.Dongia = null;
        this.Thanhtien = null;
    }

    public HANGHOADTO(String MaHang, String MaNCC, String TenHang, String Donvi, String soluong, String Dongia, String Thanhtien) 
    {
        this.MaHang = MaHang;
        this.MaNCC = MaNCC;
        this.TenHang = TenHang;
        this.Donvi = Donvi;
        this.soluong = soluong;
        this.Dongia = Dongia;
        this.Thanhtien = Thanhtien;
    }

    public String getMaHang() {
        return MaHang;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getTenHang() {
        return TenHang;
    }

    public String getDonvi() {
        return Donvi;
    }

    public String getSoluong() {
        return soluong;
    }

    public String getDongia() {
        return Dongia;
    }

    public String getThanhtien() {
        return Thanhtien;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public void setDonvi(String Donvi) {
        this.Donvi = Donvi;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public void setDongia(String Dongia) {
        this.Dongia = Dongia;
    }

    public void setThanhtien(String Thanhtien) {
        this.Thanhtien = Thanhtien;
    }
   
    
   
    
    
    
    
}
