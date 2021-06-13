/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BanDAL;
import DTO.Ban_DTO;
import java.util.ArrayList;

/**
 *
 * @author MSI2
 */
public class BanBLL {
    BanDAL tableDAL = new BanDAL();
    public ArrayList<Ban_DTO> getAllBan()
    {
        return tableDAL.getAllBan();
    }
    public boolean addmenu(String KHUVUC, String SOGHE, String TRANGTHAI){
        return tableDAL.addMenu(KHUVUC,SOGHE,TRANGTHAI);
    }
    public boolean removeBan(String MaBan){
        return removeBan(MaBan);
    }
  
    public Ban_DTO getBan(String MaBan){
        return tableDAL.getBan(MaBan);
    }
    public boolean update(String maban, String kv, String soghe, String tt)
    {
        return tableDAL.update(maban, kv, soghe, tt);
    }
}
