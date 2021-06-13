/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import java.sql.ResultSet;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MSI2
 */
public class NhanVienDAL {
    public ArrayList<NhanVienDTO> getALLNhanVien()//Hiển thị tất cả nhân viên có trong quán lên table
    {
        ArrayList<NhanVienDTO> AL = new ArrayList<NhanVienDTO>();
        String sql = "select MANV, TENTK, HOTEN, CMND, TO_CHAR(NGAYSINH, 'dd-MM-yyyy') NGAYSINH, DIACHI, GIOITINH, SDT, MUCLUONG, TO_CHAR(NVL,'dd-MM-yyyy') NVL from NHANVIEN order by MANV";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                NhanVienDTO nv_DTO = new NhanVienDTO();
                nv_DTO.setMaNV(rs.getString(1));
                nv_DTO.setTenTK(rs.getString(2));
                nv_DTO.setHoTen(rs.getString(3));
                nv_DTO.setCMND(rs.getString(4));
                nv_DTO.setDiaChi(rs.getString(5));
                nv_DTO.setNgaysinh(rs.getString(6));
                nv_DTO.setGioiTinh(rs.getString(7));
                nv_DTO.setSDT(rs.getString(8));
                nv_DTO.setMucLuong(rs.getString(9));
                nv_DTO.setNVL(rs.getString(10));
                AL.add(nv_DTO);
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AL;
    }
    
    public NhanVienDTO getNhanVien(String MaNV)//Chọn những Nhân viên có manv hay hoten là MaNV
    {
        NhanVienDTO nv_DTO = new NhanVienDTO();
        String sql = "select MANV, TENTK, HOTEN, CMND, TO_CHAR(NGAYSINH, 'dd-MM-yyyy') NGAYSINH, DIACHI, GIOITINH, SDT, MUCLUONG, TO_CHAR(NVL,'dd-MM-yyyy') NVL from NHANVIEN where MANV = "+ MaNV+" or TENTK = '"+ MaNV +"'";
        ResultSet rs =Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                nv_DTO.setMaNV(rs.getString(1));
                nv_DTO.setTenTK(rs.getString(2));
                nv_DTO.setHoTen(rs.getString(3));
                nv_DTO.setCMND(rs.getString(4));
                nv_DTO.setNgaysinh(rs.getString(5));
                nv_DTO.setDiaChi(rs.getString(6));
                nv_DTO.setGioiTinh(rs.getString(7));
                nv_DTO.setSDT(rs.getString(8));
                nv_DTO.setMucLuong(rs.getString(9));
                nv_DTO.setNVL(rs.getString(10));
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv_DTO;
    }
    
    public String getNhanVienBangTaiKhoan(String TenTK)//Chọn những Nhân viên có manv hay hoten là MaNV
    {
        String sql = "select MANV from NHANVIEN where TENTK = '"+ TenTK +"'";
        ResultSet rs =Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                return rs.getString(1);
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    public NhanVienDTO getNhanVien_TK(String TenTK)//Chọn những Nhân viên có manv hay hoten là MaNV
    {
        NhanVienDTO nv_DTO = new NhanVienDTO();
        String sql = "select MANV, TENTK, HOTEN, CMND, TO_CHAR(NGAYSINH, 'dd-MM-yyyy') NGAYSINH, DIACHI, GIOITINH, SDT, MUCLUONG, TO_CHAR(NVL,'dd-MM-yyyy') NVL from NHANVIEN where TENTK = '"+ TenTK +"'";
        ResultSet rs =Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                nv_DTO.setMaNV(rs.getString(1));
                nv_DTO.setTenTK(rs.getString(2));
                nv_DTO.setHoTen(rs.getString(3));
                nv_DTO.setCMND(rs.getString(4));
                nv_DTO.setNgaysinh(rs.getString(5));
                nv_DTO.setDiaChi(rs.getString(6));
                nv_DTO.setGioiTinh(rs.getString(7));
                nv_DTO.setSDT(rs.getString(8));
                nv_DTO.setMucLuong(rs.getString(9));
                nv_DTO.setNVL(rs.getString(10));
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv_DTO;
    }
    
    
    public TaiKhoanDTO getTaiKhoan(String TenTK)//Lay thong tin tai khoan tu TenTK
    {
        TaiKhoanDTO taikhoan = new TaiKhoanDTO();
        String sql = "select TenTK, MK,ROLE from TAIKHOAN where TenTK = '"+ TenTK +"'";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                taikhoan.setTenTK(rs.getString(1));
                taikhoan.setMK(rs.getString(2));
                taikhoan.setRole(rs.getString(3));
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taikhoan;
    }
    
    
    public boolean ThemNV(NhanVienDTO nv, TaiKhoanDTO tk){
        String call = "{call Them_Nhan_Vien(?,?,?,?,?,?,?,?,?,?,?)}";
        int n = 0;
        CallableStatement pr;
        try {
            pr = conectionJDBC().prepareCall(call);
            pr.setString(1, nv.getHoTen());
            pr.setString(2, nv.getCMND());
            pr.setString(3, nv.getNgaysinh());
            pr.setString(4, nv.getDiaChi());
            pr.setString(5, nv.getGioiTinh());
            pr.setString(6, nv.getSDT());
            pr.setString(7, nv.getMucLuong());
            pr.setString(8, nv.getNVL());
            pr.setString(9, tk.getTenTK());
            pr.setString(10,tk.getMK());
            pr.setString(11,tk.getRole());
            n = pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
     
    public boolean XoaNV(String manv, String tentk){
        String sql = "{call Xoa_Nhan_Vien(?,?)}";
        int n = 0;
        try {
            CallableStatement pr=conectionJDBC ().prepareCall(sql);
            pr.setString(1, manv);
            pr.setString(2, tentk);
            n = pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0){
            System.out.println("Xóa thành công");
            return true;
        }else{
            System.out.println("Xóa không thành công");
            return false;
        }
    }
    
    public boolean CapNhatNV(NhanVienDTO nv, TaiKhoanDTO tk)
    {
        
        String update_nv = "update NHANVIEN set HOTEN=?, CMND=?, NGAYSINH= TO_DATE(?,'dd-MM-yyyy'), DIACHI=?, SDT=?, MUCLUONG=?, NVL= TO_DATE(?,'dd-MM-yyyy') where TenTK = '"+ tk.getTenTK()+"'";
        String update_tk = "update TAIKHOAN set MK=? where TenTK = '"+ tk.getTenTK()+"'";
        PreparedStatement pr_nv,pr_tk;
        int n=0, m =0;
        try {
            pr_nv = conectionJDBC ().prepareStatement(update_nv);
            pr_tk = conectionJDBC ().prepareStatement(update_tk);
            
            pr_nv.setString(1, nv.getHoTen());
            pr_nv.setString(2, nv.getCMND());
            pr_nv.setString(3, nv.getNgaysinh());
            pr_nv.setString(4, nv.getDiaChi());
            pr_nv.setString(5, nv.getSDT());
            pr_nv.setString(6, nv.getMucLuong());
            pr_nv.setString(7, nv.getNVL());
            
            pr_tk.setString(1, tk.getMK());

            n = pr_nv.executeUpdate();
            m = pr_tk.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0 && m>0)
            return true;
        else
            return false;
        
    }
    
    public String getRole(String TenTK)
    {
        String sql = "select ROLE from NHANVIEN where TENTK = '"+TenTK+"'";
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next())
                return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
}
