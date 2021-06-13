/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Database;
import DAL.NhapHangDAL;
import DTO.HANGHOADTO;
import DTO.NCC_DTO;
import DTO.NhapHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class NhapHangBLL {
    NhapHangDAL dal = new NhapHangDAL();
    
    public ArrayList<String> LoadNCC()
    {
        return dal.FillComboBox_NCC();
    }
    
    public ArrayList<String> LoadHH(String Mancc)
    {
        return dal.FillComboBox_HANGHOA(Mancc);
    }
    
    public NCC_DTO getNCC(String mancc) throws SQLException
    {
        return dal.getNCC(mancc);
    }
    
    public HANGHOADTO getHangHoa(String mahh)
    {
        return dal.getHangHoa(mahh);
    }
    
    public ArrayList<NhapHangDTO> getALLCTN()
    {
        return dal.getAllNhapHang();
    }
    
    public boolean nhapMotDonHang(String maNV, String maHang, String time, String soLuongNhap)
    {
        return dal.nhapMotDonHang(maNV, maHang, time, soLuongNhap);
    } 
    
    public boolean removeDonHang(String mactn)
    {
        return dal.removeDonHang(mactn);
    }
    
    public NhapHangDTO getDonHang(String mactn)
    {
        return dal.getDonHang(mactn);
    }
    
    public Object[] getDonHangCapNhat(String mahang)
    {
        return dal.getDonHangCapNhat(mahang);
    }
    
    public boolean Update(String mactn, String slcu, String slmoi)
    {
        return dal.Update(mactn, slcu, slmoi);
    }
            
}
