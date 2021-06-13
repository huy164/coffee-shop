/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Database.conectionJDBC;
import DTO.DangNhapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI2
 */
public class DangNhapChuQuanDAL {

    public DangNhapDTO DangNhap(String TenTK, String MK) {

        try {
            PreparedStatement pst;
            DangNhapDTO account = null;
            String sql = "select TENTK, MK, ROLE from TAIKHOAN where ROLE=1 and upper(TENTK)=upper('" + TenTK + "') and MK='" + MK+"'";
            ResultSet rs = conectionJDBC().createStatement().executeQuery(sql);
            if (rs.next()) {
                account = new DangNhapDTO();
                account.setTenTK(rs.getString(1));
                account.setMK(rs.getString(2));
                account.setRole(rs.getString(3));
                account.setTrangThai("Dang dang nhap");
            }
            return account;
        } catch (SQLException ex) {
            Logger.getLogger(DangNhapChuQuanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
