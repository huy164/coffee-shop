/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BanHangDAL;
import DTO.CTHD_DTO;
import DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI2
 */
public class QuanLyBH_BLL 
{
    BanHangDAL ql = new BanHangDAL();
    public ResultSet Check(String str)
    {
        if(str.equals("MaKH"))
            return ql.FillComboBox_KH();
        else 
        {
                if(str.equals("MaBan"))
                    return ql.FillComboBox_MABAN();
                else return ql.FillComboBox_TenMon();
        }
 
    }
    
    public String LoadDonGia(String tenmon)
    {
        return ql.LoadDonGia(tenmon);
    }
    
    public String getGiamGia(String str)
    {
        return ql.getGiamGia(str);
    }
    
    public String getMaMon(String TenMon)
    {
        return ql.getMaMon(TenMon);
    }

    
    public String ThemHD(HoaDonDTO hd, CTHD_DTO cthd)
    {
        return ql.ThemHD(hd,cthd);
    }
    
    public boolean ThemCTHD(CTHD_DTO cthd)
    {
        return ql.ThemCTHD(cthd);
    }
    
    public boolean ThanhToan(String Maban, String MaHD, String Thanhtoan)
    {
        return ql.ThanhToan(Maban, MaHD, Thanhtoan);
    }
    
    public boolean Xoa_CTHD(String Mahd)
    {
        return ql.Xoa_CTHD(Mahd);
    }
    
    public ArrayList<HoaDonDTO> getAllHD()
    {
        return ql.getAllHD();
    }
    
    public HoaDonDTO getHD(String MaHD)
    {
        return ql.getHD(MaHD);
    }
    
}
