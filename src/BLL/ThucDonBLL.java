/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.ThucDonDAL;
import DTO.ThucDonDTO;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class ThucDonBLL {
    ThucDonDAL menuDAL = new ThucDonDAL();
    public ArrayList<ThucDonDTO> getAllThucDon()
    {
        return menuDAL.getAllThucDon();
    }
    public boolean addmenu(int MANL, String TENMON, int GIA, String slnl){
        return menuDAL.addMenu(MANL, TENMON, GIA, slnl);
    }
    public boolean removeMon(String MAMON){
        return menuDAL.removeMon(MAMON);
    }
    public boolean updateMon(String tenMon, int Gia, int maMon, String slnl){
        return menuDAL.updateMon(tenMon, Gia, maMon, slnl);
    }
    public ThucDonDTO getThucDon(int maMon){
        return menuDAL.getThucDon(maMon);
    }
}
