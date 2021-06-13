/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Database;
import static DAL.Database.conectionJDBC;
import DAL.NhanVienDAL;
import java.sql.ResultSet;
import DTO.KhachHangDTO;

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
public class QuanLyKH_BLL {
    
     public ArrayList<KhachHangDTO> getALLKhachHang()//Hiển thị tất cả nhân viên có trong quán lên table
    {
        ArrayList<KhachHangDTO> AL = new ArrayList<KhachHangDTO>();
        String sql = "select MAKH, TENKH, GIOITINH, SDT, DIEMTL from KHACHHANG order by MAKH";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                KhachHangDTO kh_DTO = new KhachHangDTO();
                kh_DTO.setMaKH(rs.getString(1));
                kh_DTO.setTenKH(rs.getString(2));
                kh_DTO.setGioiTinhKH(rs.getString(3));
                kh_DTO.setSDT(rs.getString(4));
                kh_DTO.setDTL(Integer.parseInt(rs.getString(5)));
                AL.add(kh_DTO);
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AL;
    }
    
    public KhachHangDTO getKhachHang(String MaKH)//Chọn những Nhân viên có manv hay hoten là MaNV
    {
        KhachHangDTO kh_DTO = new KhachHangDTO();
        String sql = "select MAKH, TENKH, GIOITINH, SDT, DIEMTL from KHACHHANG where MAKH = "+ MaKH;
        ResultSet rs =Database.getData(conectionJDBC (),sql);
        try 
        {
            while(rs.next())
            {
                kh_DTO.setMaKH(rs.getString(1));
                kh_DTO.setTenKH(rs.getString(2));
                kh_DTO.setGioiTinhKH(rs.getString(3));
                kh_DTO.setSDT(rs.getString(4));
                kh_DTO.setDTL(Integer.parseInt(rs.getString(5)));
            }
            rs.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh_DTO;
    }

    
    public boolean ThemKH(KhachHangDTO kh){
        String sql = "insert into KHACHHANG values(MAKH_SEQ.NEXTVAL,?, ?, ?, ?)";
        int n = 0;
        try {
            PreparedStatement pr = Database.conectionJDBC().prepareStatement(sql);
            pr.setString(1, kh.getTenKH());
            pr.setString(2, kh.getGioiTinhKH());
            pr.setString(3, kh.getSDT());
            pr.setString(4, String.valueOf(kh.getDTL()));
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
     
    public boolean XoaKH(String makh, String tenkh){
        String sql = "{call Xoa_Khach_Hang(?,?)}";
        int n = 0;
        try {
            CallableStatement pr=conectionJDBC ().prepareCall(sql);
            pr.setString(1, makh);
            pr.setString(2, tenkh);
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
    
    public boolean CapNhatKH(KhachHangDTO kh)
    {
        
        String update_kh = "update KHACHHANG set TENKH=?, GIOITINH=?, SDT= ?, DIEMTL=? where MAKH = '"+ kh.getMaKH()+"'";
        PreparedStatement pr_kh;
        int n=0;
        try {
            pr_kh= conectionJDBC ().prepareStatement(update_kh);
            pr_kh.setString(1, kh.getTenKH());
            pr_kh.setString(2, kh.getGioiTinhKH());
            pr_kh.setString(3, kh.getSDT());
            pr_kh.setString(4, String.valueOf(kh.getDTL()));
            n = pr_kh.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n>0;
        
    }
    
}
