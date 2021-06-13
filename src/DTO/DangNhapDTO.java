/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.io.Serializable;

/**
 *
 * @author MSI2
 */
public class DangNhapDTO implements Serializable
{
    private String Role;
    private String TenTK;
    private String MK;
    private String TrangThai = "Khong dang nhap";

    public DangNhapDTO(String Role, String TenTk, String MK, String TrangThai) 
    {
        this.Role = Role;
        this.TenTK = TenTk;
        this.MK = MK;
        this.TrangThai = TrangThai;
    }

    public DangNhapDTO() 
    {
        
    }

    public String getRole() {
        return Role;
    }

    public String getTenTK() {
        return TenTK;
    }

    public String getMK() {
        return MK;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
