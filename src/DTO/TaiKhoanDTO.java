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
public class TaiKhoanDTO {
    private String TenTK;
    private String MK;
    private String Role;
    private String TrangThai;

    public TaiKhoanDTO(String TenTK, String MK, String Role) 
    {
        this.TenTK = TenTK;
        this.MK = MK;
        this.Role = Role;
    }
    
    public TaiKhoanDTO() 
    {
        
    }

    public String getTenTK() {
        return TenTK;
    }

    public String getMK() {
        return MK;
    }

    public String getRole() {
        return Role;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
