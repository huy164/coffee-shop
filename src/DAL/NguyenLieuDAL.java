/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.NguyenLieuDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class NguyenLieuDAL {
    public ArrayList<NguyenLieuDTO> getAllNguyenLieu(){
        ArrayList<NguyenLieuDTO> listNL = new ArrayList<NguyenLieuDTO>();
        String sql = "select MANL, TENNL, TO_CHAR(HSD, 'dd-MM-yyyy') HSD, SLCON, CONGDUNG from NGUYENLIEU";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try {
            while (rs.next()){
                NguyenLieuDTO ngLieu_DTO = new NguyenLieuDTO();
                ngLieu_DTO.setMaNL(rs.getString(1));
                ngLieu_DTO.setTenNL(rs.getString(2));
                ngLieu_DTO.setHSD(rs.getString(3));
                ngLieu_DTO.setSlCon(rs.getString(4));
                ngLieu_DTO.setCongDung(rs.getString(5));
                listNL.add(ngLieu_DTO);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNL;
    }
    public ArrayList<NguyenLieuDTO> getTonKho(){
        ArrayList<NguyenLieuDTO> listTonKho = new ArrayList<NguyenLieuDTO>();
        String sql = "select MANL, TENNL, SLCON from NGUYENLIEU where SLCON > 0";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try {
            while (rs.next()){
                NguyenLieuDTO ngLieu_DTO = new NguyenLieuDTO();
                ngLieu_DTO.setMaNL(rs.getString("MANL"));
                ngLieu_DTO.setTenNL(rs.getString("TENNL"));
                //ngLieu_DTO.setHSD(rs.getString("HSD"));
                ngLieu_DTO.setSlCon(rs.getString("SLCON"));
                //ngLieu_DTO.setCongDung(rs.getString("CONGDUNG"));
                listTonKho.add(ngLieu_DTO);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTonKho;
    }
    public boolean addNguyenLieu(String tenNL, String HSD, String slCon, String congDung){
        String sql = "insert into NGUYENLIEU values (MANL_SEQ.nextval,'"+tenNL+"',TO_DATE('"+HSD+"','dd/mm/yyyy'),'"+slCon+"','"+congDung+"')";
        try {
            Statement statement = conectionJDBC().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
        }
    
    public boolean removeNL(String maNL){
        String sql = "delete from NGUYENLIEU where MANL = '"+maNL+"'";
        Statement statement;
        try {
            statement = conectionJDBC().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    public NguyenLieuDTO getNguyenLieu(String maNL){

        String sql = "select MANL, TENNL, TO_CHAR(HSD, 'dd-MM-yyyy') HSD, SLCON, CONGDUNG from NGUYENLIEU where MANL = '"+maNL+"'";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        NguyenLieuDTO ngLieu_DTO = new NguyenLieuDTO();
        try {
            while (rs.next()){
                ngLieu_DTO.setMaNL(rs.getString(1));
                ngLieu_DTO.setTenNL(rs.getString(2));
                ngLieu_DTO.setHSD(rs.getString(3));
                ngLieu_DTO.setSlCon(rs.getString(4));
                ngLieu_DTO.setCongDung(rs.getString(5));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ngLieu_DTO;
}
    public boolean updateNguyenLieu(String maNL, String tenNL, String hsd, String slCon, String congDung ){
        String sql = "update NGUYENLIEU set TENNL = '"+tenNL+"', HSD = TO_DATE ('"+hsd+"','dd/mm/yyyy'), SLCON = '"+slCon+"', congDung = '"+congDung+"'where MANL = '"+maNL+"'";
        Statement statement;
        try {
            statement = conectionJDBC().createStatement();
            statement.executeUpdate(sql);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
}
