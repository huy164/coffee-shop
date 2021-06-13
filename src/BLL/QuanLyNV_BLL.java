/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author MSI2
 */
public class QuanLyNV_BLL {
    NhanVienDAL nv_DAL = new NhanVienDAL();
    public ArrayList<NhanVienDTO> getAllNhanVien()
    {
        return nv_DAL.getALLNhanVien();
    }
    
    public NhanVienDTO getNhanVien(String TT_NV)
    {
        return nv_DAL.getNhanVien(TT_NV);
    }
    
     public String getNhanVienBangTaiKhoan(String TenTK)
    {
        return nv_DAL.getNhanVienBangTaiKhoan(TenTK);
    }
    
    public NhanVienDTO getNhanVien_TK(String TenTK)
    {
        return nv_DAL.getNhanVien_TK(TenTK);
    }
    
    public TaiKhoanDTO getTaiKhoan(String TenTK)
    {
        return nv_DAL.getTaiKhoan(TenTK);
    }
    
    public String getRole(String TenTK)
    {
        return nv_DAL.getRole(TenTK);
    }
    
    public boolean ThemNV(NhanVienDTO nv, TaiKhoanDTO TK)
    {
        return nv_DAL.ThemNV(nv,TK);
    }
    
    public boolean XoaNV(String manv, String tentk)
    {
        return nv_DAL.XoaNV(manv, tentk);
    }
    public boolean CapNhatNV(NhanVienDTO nv, TaiKhoanDTO TK)
    {
        return nv_DAL.CapNhatNV(nv, TK);
    }
}
