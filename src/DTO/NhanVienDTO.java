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
public class NhanVienDTO {
    private String MaNV;
    private String TenTK;
    private String HoTen;
    private String CMND;
    private String Ngaysinh;
    private String DiaChi;
    private String GioiTinh;
    private String SDT;
    private String MucLuong;
    private String NVL;

    public NhanVienDTO(String TenTK, String HoTen, String CMND, String Ngaysinh, String DiaChi, String GioiTinh, String SDT, String MucLuong, String NVL) {
        this.TenTK = TenTK;
        this.HoTen = HoTen;
        this.CMND = CMND;
        this.Ngaysinh = Ngaysinh;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.MucLuong = MucLuong;
        this.NVL = NVL;
    }

    

    public NhanVienDTO() {}

    public String getMaNV() {
        return MaNV;
    }

    public String getTenTK() {
        return TenTK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getCMND() {
        return CMND;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getMucLuong() {
        return MucLuong;
    }

    public String getNVL() {
        return NVL;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setMucLuong(String MucLuong) {
        this.MucLuong = MucLuong;
    }

    public void setNVL(String NVL) {
        this.NVL = NVL;
    }
    
    

    
}
