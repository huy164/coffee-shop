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

/**
 *
 * @author MSI2
 */
public class DangNhapNVDAL {

    public DangNhapDTO DangNhap(String TenTK, String MK) {
       try {
            PreparedStatement pst;
            DangNhapDTO account = null;
            String sql = "select TENTK, MK, ROLE from TAIKHOAN where ROLE=0 and upper(TENTK) = upper('" + TenTK + "') and MK='" + MK+"'";
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
            java.util.logging.Logger.getLogger(DangNhapChuQuanDAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

}
