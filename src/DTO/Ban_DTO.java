/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MSI2
 */
public class Ban_DTO {
    private String Maban;
    private String Khuvuc;
    private String soghe;
    private String trangthai;

    public Ban_DTO() 
    {
        this.Maban = null;
        this.Khuvuc = null;
        this.soghe = null;
        this.trangthai = null;
    }

    public Ban_DTO(String Maban, String Khuvuc, String soghe, String trangthai) 
    {
        this.Maban = Maban;
        this.Khuvuc = Khuvuc;
        this.soghe = soghe;
        this.trangthai = trangthai;
    }

    public String getMaban() {
        return Maban;
    }

    public String getKhuvuc() {
        return Khuvuc;
    }

    public String getSoghe() {
        return soghe;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setMaban(String Maban) {
        this.Maban = Maban;
    }

    public void setKhuvuc(String Khuvuc) {
        this.Khuvuc = Khuvuc;
    }

    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    
    
}
