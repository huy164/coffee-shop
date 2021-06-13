/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI2
 */
public class Database {
    
    static private String hostname = "localhost";
    static private String SID = "orcl";
    static private String username = "coffee_shop";
    static private String password = "1";
    
    public static Connection conectionJDBC() //Ket noi oracle
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + hostname + ":1521:" + SID, username, password);
            return con; //ket noi thanh cong
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kết nối thất bại");
        }
        return null; //ket noi khong thanh cong
    }
    
    public static ResultSet getData(Connection con, String sql) //lay du lieu load len
    {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lấy dữ liệu thất bại");
        }
        return rs;
    }
    
}
