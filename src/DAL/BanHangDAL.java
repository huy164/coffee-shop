/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.CTHD_DTO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI2
 */
public class BanHangDAL 
{
    public ResultSet FillComboBox_KH()
    {
        String sql = "select MAKH from KHACHHANG";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        return rs;
    }
    
    public ResultSet FillComboBox_TenMon()
    {
        String sql = "select TENMON from MON";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        return rs;
    }
    
    public ResultSet FillComboBox_MABAN()
    {
        String sql = "select MABAN from BAN";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        return rs;
    }
    
    public String LoadDonGia(String str)
    {
        String sql = "select GIA from MON where TENMON = '"+str+"'";
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next())
            {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    public String getGiamGia(String str)
    {
        String sql = "select DIEMTL from KHACHHANG where MAKH = "+ str;
        int kq = 0;
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next())
            {
                kq = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        if(kq <= 10)
            return "0";
        else
            if(kq >= 11 && kq <= 30 )
                return "5";
            else return "10";
    }
    
    public String ThemHD(HoaDonDTO hd, CTHD_DTO cthd)
    {
        String call = "{?=call Them_Hoa_Don_Fun('"+hd.getMaKH()+"','"+hd.getMaNV()+"',"
                + "TO_DATE('"+ hd.getNgayLap() +"','dd-mm-yyyy HH24:MI'),'"+hd.getGiamGia()+"','"+cthd.getMaBan()
                +"','"+cthd.getMaMon()+"','"+cthd.getSL()+"')}";
        CallableStatement pr;
        String mahd = null;
        try {
            pr = conectionJDBC().prepareCall(call);
            pr.registerOutParameter(1, Types.INTEGER);
            pr.executeUpdate();
            mahd = pr.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        String kq = String.valueOf(mahd);
        return kq;
    }
    
    public String getMaMon(String TenMon) 
    {
        String sql = "select MAMON from MON where TENMON = '"+TenMon+"'";
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next())
            {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    public boolean ThemCTHD(CTHD_DTO cthd)
    {
        String sql = "insert into CTHD values ('" + cthd.getMaKH() + "', '"+ cthd.getMaBan()+ "', '"+ cthd.getMaMon()+ "', '"+ cthd.getMaHD()+ "', '"+ cthd.getSL()+ "')";
        int n = 0;
        try {
            Statement stmt = Database.conectionJDBC().createStatement();
            n = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(n==0)
            return false;
        return true; 
    }
    
    public boolean ThanhToan(String Maban, String MaHD, String Thanhtoan)
    {
        String call = "{call THANHTOAN('"+ Maban +"','"+ MaHD +"','"+ Thanhtoan +"')}";
        int n = 0;
        CallableStatement pr;
        try {
            pr = conectionJDBC().prepareCall(call);
            n = pr.executeUpdate(call);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(n);
        if(n>0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean Xoa_CTHD(String MaHD)
    {
        String sql = "delete from CTHD where MAHD = "+ MaHD;
        int n = 0;
        Statement stmt;
        try {
            stmt = conectionJDBC().createStatement();
            n = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(n>0)
            return true;
        return false;
    }
    
    public ArrayList<HoaDonDTO> getAllHD()
    {
        ArrayList<HoaDonDTO> AL = new ArrayList<HoaDonDTO>();
        String sql = "select MAHD, MAKH, THANHTIEN, TO_CHAR(NGAYLAP, 'dd-MM-yyyy HH24:MI') NGAYLAP, MANV, GIAMGIA, TRANGTHAI from HOADON order by MAHD";
        ResultSet rs = Database.getData(conectionJDBC(),sql);
        try {
            while(rs.next())
            {
                HoaDonDTO hd_dto = new HoaDonDTO();
                hd_dto.setMaHD(rs.getString(1));
                hd_dto.setMaKH(rs.getString(2));
                hd_dto.setThanhTien(rs.getString(3));
                hd_dto.setNgayLap(rs.getString(4));
                hd_dto.setMaNV(rs.getString(5));
                hd_dto.setGiamGia(rs.getString(6));
                hd_dto.setTrangthai(rs.getString(7));
                AL.add(hd_dto);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AL;
    }
    
    public HoaDonDTO getHD(String MaHD)
    {
        HoaDonDTO hd = new HoaDonDTO();
        String sql = "select MAHD, MAKH, THANHTIEN, TO_CHAR(NGAYLAP, 'dd-MM-yyyy HH24:MI') NGAYLAP, MANV, GIAMGIA, TRANGTHAI from HOADON where MAHD = " + MaHD;
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while(rs.next())
            {
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setThanhTien(rs.getString(3));
                hd.setNgayLap(rs.getString(4));
                hd.setMaNV(rs.getString(5));
                hd.setGiamGia(rs.getString(6));
                hd.setTrangthai(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hd;
    }
}

