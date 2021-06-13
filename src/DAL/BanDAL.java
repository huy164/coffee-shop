/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.Ban_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI2
 */
public class BanDAL {
     private Database db;
    
    public BanDAL(){
        db = new Database();
    }   
    public ArrayList<Ban_DTO> getAllBan(){
        ArrayList<Ban_DTO> listTable = new ArrayList<Ban_DTO>();
        String sql = "select * from BAN";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        
        try {
            while (rs.next()){
                Ban_DTO ban = new Ban_DTO();
                ban.setMaban(rs.getString("MABAN"));
                ban.setKhuvuc(rs.getString("KHUVUC"));
                ban.setSoghe(rs.getString("SOGHE"));
                ban.setTrangthai(rs.getString("TRANGTHAI"));
                listTable.add(ban);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }
    
    //Add Menu 
    
    public boolean addMenu( String KHUVUC, String SOGHE, String TRANGTHAI){
        String sql = "insert into BAN values (MABAN_SEQ.nextval,'"+KHUVUC+"','"+SOGHE+"','"+TRANGTHAI+"')";
        int n = 0 ;
        try {
            Statement statement = conectionJDBC().createStatement();
            n = statement.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(n>0)
            return true;
        return false;
    }
   
    
    //XÃ³a bÃ n 
    public boolean removeBan(String MaBan){
        String sql = "delete from BAN where MABAN = '"+MaBan+"'";
        Statement statement;
        int n = 0;
        try {
            statement = conectionJDBC().createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0)
            return true;
        return false;

    }
    
    // Look up 
    
    public Ban_DTO getBan(String MaBan){

        String sql = "select * from BAN where MABAN = '"+MaBan+"'";
        ResultSet rs = Database.getData(conectionJDBC (),sql);
        Ban_DTO ban = new Ban_DTO();
        try {
            while (rs.next()){
                ban.setMaban(rs.getString("MABAN"));
                ban.setKhuvuc(rs.getString("KHUVUC"));
                ban.setSoghe(rs.getString("SOGHE"));
                ban.setTrangthai(rs.getString("TRANGTHAI"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }
    
    public boolean update(String Maban, String kv, String soghe, String trangthai)
    {
        String sql = "update BAN set KHUVUC = '"+ kv +"', SOGHE = "+soghe+", TRANGTHAI = '"+trangthai+"' where MABAN = "+Maban;
        Statement stmt;
        int n = 0;
        try {
            stmt = db.conectionJDBC().createStatement();
            n = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(n>0)
            return true;
        return false;
    }
    
}
