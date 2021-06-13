    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import static DAL.Database.conectionJDBC;
import DTO.HANGHOADTO;
import DTO.NCC_DTO;
import DTO.NhapHangDTO;
import java.sql.CallableStatement;
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
public class NhapHangDAL {
    public ArrayList<NhapHangDTO> getAllNhapHang(){
        ArrayList<NhapHangDTO> listNH = new ArrayList<NhapHangDTO>();
        String sql = "select MACTN, hh.MAHANG, MANCC, MANV, TO_CHAR(NGAYNHAP, 'dd-MM-yyyy HH24:MI') NGAYNHAP, SOLUONGNHAP from HANGHOA hh, CHI_TIET_NHAP ctn where hh.MAHANG = ctn.MAHANG order by MACTN";
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while (rs.next()){
                NhapHangDTO nhDTO = new NhapHangDTO();
                nhDTO.setMaCTN(rs.getString(1));
                nhDTO.setMaHANG(rs.getString(2));
                nhDTO.setMaNCC(rs.getString(3));
                nhDTO.setMaNV(rs.getString(4));
                nhDTO.setNgayNhap(rs.getString(5));
                nhDTO.setSLNhap(rs.getString(6));
                listNH.add(nhDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNH;
    }

    public ArrayList<String> FillComboBox_NCC()
    {
        String sql = "select MANCC from NCC";
        ArrayList<String> ar = new ArrayList<String>();
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try {
            while(rs.next())
            {
                String mancc = rs.getString(1);
                ar.add(mancc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    
    public ArrayList<String> FillComboBox_HANGHOA(String MaNcc)
    {
        String sql = "select MAHANG from HANGHOA where MANCC = " + MaNcc;
        ArrayList<String> ar = new ArrayList<String>();
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try {
            while(rs.next())
            {
                String mancc = rs.getString(1);
                ar.add(mancc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }
    
    public boolean nhapMotDonHang(String maNV, String maHang,String time, String soLuongNhap){
        String sql = "insert into CHI_TIET_NHAP values (MACTN_SEQ.nextval, '" + maHang + "', '"+ maNV +"', to_date('"+time+"','dd - MM - yyyy HH24:MI'), '"+soLuongNhap+"')";
        int n = 0;
        try {
            Statement statement = conectionJDBC().createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(n>0)
            return true;       
        return false;
    }
    public NCC_DTO getNCC(String mancc) throws SQLException
    {
        NCC_DTO ncc = new NCC_DTO();
        String sql = "select MANCC, TENNCC, DIACHI, SDT from NCC where MANCC = " + mancc;
        Statement stmt = Database.conectionJDBC().createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
            ncc.setMaNCC(rs.getString(1));
            ncc.setTenNCC(rs.getString(2));
            ncc.setDChi(rs.getString(3));
            ncc.setSDT(rs.getString(4));
        }
        return ncc;
    }
    
    public HANGHOADTO getHangHoa(String mahh)
    {
        HANGHOADTO hh = new HANGHOADTO();
        try {
            String sql = "select MAHANG, TENHANG, DONGIA, DONVI from HANGHOA where MAHANG = " + mahh;
            Statement stmt = Database.conectionJDBC().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                hh.setMaHang(rs.getString(1));
                hh.setTenHang(rs.getString(2));
                hh.setDongia(rs.getString(3));
                hh.setDonvi(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hh;
    }
    
    public boolean removeDonHang(String mactn)
    {
        String sql = "delete from CHI_TIET_NHAP where MACTN = "+ mactn;
        Statement stmt;
        int n = 0;
        try {
            stmt = Database.conectionJDBC().createStatement();
            n = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0)
            return true;
        return false;
    }
    
    public NhapHangDTO getDonHang(String mactn)
    {
        String sql = "select MACTN, hh.MAHANG, MANCC, MANV, TO_CHAR(NGAYNHAP, 'dd-MM-yyyy HH24:MI') NGAYNHAP, SOLUONGNHAP from HANGHOA hh, CHI_TIET_NHAP ctn where hh.MAHANG = ctn.MAHANG and MACTN = "+ mactn;
        Statement stmt;
        NhapHangDTO nh_dto = new NhapHangDTO();
        try {
            stmt = Database.conectionJDBC().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                nh_dto.setMaCTN(rs.getString(1));
                nh_dto.setMaHANG(rs.getString(2));
                nh_dto.setMaNCC(rs.getString(3));
                nh_dto.setMaNV(rs.getString(4));
                nh_dto.setNgayNhap(rs.getString(5));
                nh_dto.setSLNhap(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nh_dto;
    }
    
    public Object[] getDonHangCapNhat(String mahang)
    {
        String sql = "select ctn.MAHANG, MANCC, SOLUONGNHAP from HANGHOA hh, CHI_TIET_NHAP ctn where hh.MAHANG = ctn.MAHANG and ctn.MAHANG = " + mahang;
        Statement stmt;
        String mh = null, mancc = null,sl = null;
        try {
            stmt = Database.conectionJDBC().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                mh = rs.getString(1);
                mancc = rs.getString(2);
                sl = rs.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[] temp = {mh, mancc, sl};
        return temp;
    }
    
    public boolean Update(String mactn, String slcu, String slmoi)
    {
        String call = "{call update_nh('"+ slcu +"','"+ slmoi +"','"+ mactn +"')}";
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
    
}
    
   