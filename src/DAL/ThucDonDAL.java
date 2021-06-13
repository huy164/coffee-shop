/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.NhanVienDTO;
import DTO.ThucDonDTO;
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
public class ThucDonDAL {
    private Database db;
    public ThucDonDAL(){
        db = new Database();
    }   
    public ArrayList<ThucDonDTO> getAllThucDon(){
        ArrayList<ThucDonDTO> listMenu = new ArrayList<ThucDonDTO>();
        String sql = "select * from MON order by MAMON";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        try {
            while (rs.next()){
                ThucDonDTO menu_DTO = new ThucDonDTO();
                menu_DTO.setMaMon(rs.getInt("MAMON"));
                menu_DTO.setMaNL(rs.getInt("MANL"));
                menu_DTO.setTenMon(rs.getString("TENMON"));
                menu_DTO.setGia(rs.getInt("GIA"));
                menu_DTO.setSoluongNL(rs.getString("SOLUONGNL"));
                listMenu.add(menu_DTO);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMenu;
}
    public boolean addMenu(int MANL, String TENMON, int GIA, String slnl){
                String sql = "insert into MON values (MAMON_SEQ.nextval,'"+MANL+"','"+slnl+"','"+TENMON+"',"+GIA+")";
        try {
            Statement statement = conectionJDBC().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
        }
    public ArrayList<String> loadDataToCombobox(){
        ArrayList<String> list = new ArrayList<String>();
        String sql = "Select MANL from NGUYENLIEU";
        ResultSet rs = Database.getData(conectionJDBC(), sql);
        try {
            while (rs.next()){
                list.add(rs.getString("MANL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public boolean removeMon(String maMon){
        String sql = "delete from MON where MAMON = '"+maMon+"'";
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
    
   
    public boolean updateMon(String tenMon, int Gia, int maMon, String slnl){
        String sql = "update MON set TENMON = '"+tenMon+"',GIA = '"+Gia+"', SOLUONGNL = '"+slnl+"' where MAMON = '"+maMon+"'" ;
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
    public ThucDonDTO getThucDon(int maMon){

        String sql = "select * from MON where MAMON = '"+maMon+"'";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        ThucDonDTO menu_DTO = new ThucDonDTO();
        try {
            while (rs.next()){
                menu_DTO.setMaMon(rs.getInt("MAMON"));
                menu_DTO.setMaNL(rs.getInt("MANL"));
                menu_DTO.setTenMon(rs.getString("TENMON"));
                menu_DTO.setGia(rs.getInt("GIA"));
                menu_DTO.setSoluongNL(rs.getString("SOLUONGNL"));
                //listMenu.add(menu_DTO);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menu_DTO;
}
 }

