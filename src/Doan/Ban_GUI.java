/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doan;

import BLL.BanBLL;
import DTO.Ban_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI2
 */
public class Ban_GUI extends javax.swing.JFrame {

    private String Tentk;

    public String getTentk() {
        return Tentk;
    }

    public void setTentk(String Tentk) {
        this.Tentk = Tentk;
    }
    
    
    
    /**
     * Creates new form Ban_GUI
     */
    public Ban_GUI() {
        initComponents();
        setALLTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgnv = new javax.swing.JPanel();
        bg_thoat = new javax.swing.JPanel();
        button_thoat = new javax.swing.JButton();
        text_trangchu7 = new javax.swing.JLabel();
        icon_trangchu7 = new javax.swing.JLabel();
        bg_chuquan = new javax.swing.JPanel();
        bg_cafeomely = new javax.swing.JPanel();
        icon_cafe = new javax.swing.JLabel();
        icon_cafe1 = new javax.swing.JLabel();
        text_cafeomely1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ban = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        bt_them = new javax.swing.JButton();
        bt_tc = new javax.swing.JButton();
        bt_de = new javax.swing.JButton();
        bt_up = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_dy = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cb_soghe = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cb_tt = new javax.swing.JComboBox<>();
        bt_can = new javax.swing.JButton();
        txt_kv = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bgnv.setBackground(new java.awt.Color(255, 255, 255));
        bgnv.setMaximumSize(new java.awt.Dimension(1280, 1000));
        bgnv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg_thoat.setBackground(new java.awt.Color(85, 65, 118));
        bg_thoat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_thoat.setBackground(new java.awt.Color(255, 255, 255));
        button_thoat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        button_thoat.setForeground(new java.awt.Color(204, 51, 0));
        button_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/images/dangnhap/icons8_back_arrow_30px.png"))); // NOI18N
        button_thoat.setText("Thoát");
        button_thoat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        button_thoat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        button_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_thoatActionPerformed(evt);
            }
        });
        bg_thoat.add(button_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 15, 110, -1));

        text_trangchu7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        text_trangchu7.setForeground(new java.awt.Color(255, 255, 255));
        text_trangchu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_trangchu7.setText("Quản lý bàn");
        bg_thoat.add(text_trangchu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 13, 270, 35));

        icon_trangchu7.setBackground(new java.awt.Color(255, 255, 255));
        icon_trangchu7.setForeground(new java.awt.Color(255, 255, 255));
        icon_trangchu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_trangchu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/images/chuquan/icons8_table_26px.png"))); // NOI18N
        icon_trangchu7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        icon_trangchu7.setOpaque(true);
        bg_thoat.add(icon_trangchu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 65, 61));

        bgnv.add(bg_thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 60));

        bg_chuquan.setBackground(new java.awt.Color(54, 33, 89));
        bg_chuquan.setForeground(new java.awt.Color(204, 0, 0));
        bg_chuquan.setToolTipText("");
        bg_chuquan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg_cafeomely.setBackground(new java.awt.Color(85, 65, 118));
        bg_cafeomely.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_cafe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_cafe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/images/chuquan/icons8_address_50px_1.png"))); // NOI18N
        bg_cafeomely.add(icon_cafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 79, 56));

        icon_cafe1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_cafe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/images/dangnhap/icons8_cafe_50px.png"))); // NOI18N
        bg_cafeomely.add(icon_cafe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 79, 56));

        text_cafeomely1.setFont(new java.awt.Font("Brush Script MT", 1, 36)); // NOI18N
        text_cafeomely1.setForeground(new java.awt.Color(255, 255, 255));
        text_cafeomely1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_cafeomely1.setText("OMELY QUÁN");
        bg_cafeomely.add(text_cafeomely1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 275, 56));

        bg_chuquan.add(bg_cafeomely, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 1190, -1));

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã bàn", "Khu vực", "Số ghế", "Trạng thái"
            }
        ));
        tb_ban.setCellSelectionEnabled(true);
        tb_ban.setDragEnabled(true);
        jScrollPane1.setViewportView(tb_ban);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 820, 330));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Thông tin bàn");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 340, 40));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/icons8_refresh_16px.png"))); // NOI18N
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 97, 97), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 40));

        bg_chuquan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 840, 380));

        jPanel4.setBackground(new java.awt.Color(85, 65, 118));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Chức năng");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 21));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 97, 97), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 28, -1, 40));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 97, 97), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 28, -1, 40));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 97, 97), 2));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 28, -1, 40));

        bt_them.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/icons8_add_30px.png"))); // NOI18N
        bt_them.setText("Thêm");
        bt_them.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });
        jPanel4.add(bt_them, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 26, 123, 40));

        bt_tc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_tc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/icons8_google_web_search_50px.png"))); // NOI18N
        bt_tc.setText("Tra cứu");
        bt_tc.setAlignmentY(0.0F);
        bt_tc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255), 2));
        bt_tc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tcActionPerformed(evt);
            }
        });
        jPanel4.add(bt_tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 28, 139, 40));

        bt_de.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_de.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/delete.png"))); // NOI18N
        bt_de.setText("Xóa");
        bt_de.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        bt_de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deActionPerformed(evt);
            }
        });
        jPanel4.add(bt_de, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 28, 123, 40));

        bt_up.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/sửa .png"))); // NOI18N
        bt_up.setText("Cập nhật");
        bt_up.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255), 2));
        bt_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_upActionPerformed(evt);
            }
        });
        jPanel4.add(bt_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 28, 115, 40));

        bg_chuquan.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 650, 80));

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Khu vực ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 21));

        btn_dy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_dy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/dong y.png"))); // NOI18N
        btn_dy.setText("Đồng ý");
        btn_dy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 2));
        btn_dy.setEnabled(false);
        btn_dy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dyActionPerformed(evt);
            }
        });
        jPanel1.add(btn_dy, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Trạng thái");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 89, 21));

        cb_soghe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "4", "6", "8" }));
        jPanel1.add(cb_soghe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 40, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số ghế");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 89, 21));

        cb_tt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cb_tt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "Đã đặt" }));
        cb_tt.setEnabled(false);
        jPanel1.add(cb_tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 100, 30));

        bt_can.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_can.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doan/icon/icons8_cancel_24px.png"))); // NOI18N
        bt_can.setText("Hủy");
        bt_can.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        bt_can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_canActionPerformed(evt);
            }
        });
        jPanel1.add(bt_can, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 90, 30));

        txt_kv.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_kv, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 250, 30));

        bg_chuquan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 330, 230));

        bgnv.add(bg_chuquan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1200, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgnv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_thoatActionPerformed
        // TODO add your handling code here:
        Chu_Quan cq = new Chu_Quan();
        cq.setTaiKhoan(Tentk);
        cq.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_thoatActionPerformed

    private void bt_canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_canActionPerformed
        refresh();
    }//GEN-LAST:event_bt_canActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setALLTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bt_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_upActionPerformed

        int choose = this.tb_ban.getSelectedRow();
        if(choose < 0){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 bàn có trong danh sách để cập nhật thông tin !", "Thông báo", JOptionPane.NO_OPTION);
            return;
        }
        else
        {
            String value = tb_ban.getValueAt(choose, 0).toString();
            
            BanBLL ban = new BanBLL();
            Ban_DTO ban_dto = ban.getBan(value);

            this.txt_kv.setText(ban_dto.getKhuvuc());
            this.cb_soghe.setSelectedItem(ban_dto.getSoghe());
            this.cb_tt.setSelectedItem(ban_dto.getTrangthai());
            this.cb_tt.setEnabled(true);

            this.btn_dy.setEnabled(true);
            return;
        }

    }//GEN-LAST:event_bt_upActionPerformed

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        // TODO add your handling code here:
         if(btn_dy.isEnabled())
        {
            JOptionPane.showMessageDialog(rootPane, "Món này đã có trong danh sách thực đơn !", "Thông báo", JOptionPane.NO_OPTION);
            refresh();
            return;
        }
        BanBLL ban = new BanBLL();
        if(txt_kv.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin của bàn !", "Thông báo", JOptionPane.NO_OPTION);
            return;
        }
        String khuvuc = this.txt_kv.getText();
        String soghe = this.cb_soghe.getSelectedItem().toString();
        String trangthai = this.cb_tt.getSelectedItem().toString();
        boolean rs = ban.addmenu(khuvuc, soghe, trangthai);
        if(rs==true)
        {
            JOptionPane.showMessageDialog(null,"Bạn vừa thêm bàn mới thành công !", "Thông báo",JOptionPane.NO_OPTION);
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Thêm bàn mới thất bại !", "Thông báo",JOptionPane.NO_OPTION);
            return;
        }
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_tcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tcActionPerformed
        // TODO add your handling code here:
        Form_tracuu tc = new Form_tracuu();
        tc.setStr("Tim ban");
        tc.setTentk(Tentk);
        tc.setVisible(true);
        this.dispose();
        return;
    }//GEN-LAST:event_bt_tcActionPerformed

    private void bt_deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deActionPerformed
          int choose = this.tb_ban.getSelectedRow();
        if(choose < 0){
            
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn bàn bạn muốn xóa bỏ !", "Thông báo", JOptionPane.NO_OPTION);
            return;
        }
        else{
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có thực sự muốn xóa bàn này !", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                BanBLL ban = new BanBLL();
                String maban = tb_ban.getModel().getValueAt(choose, 0).toString();
//                System.out.println(manv);
                boolean kq = ban.removeBan(maban);
                if(kq == true)
                {
                    JOptionPane.showMessageDialog(rootPane, "Bàn vừa được xóa bỏ !", "Thông báo", JOptionPane.NO_OPTION);
                    this.setALLTable();
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "Xóa bàn không thành công !", "Thông báo", JOptionPane.NO_OPTION);
                    return;
                }
                
            }
            return;
        }
    }//GEN-LAST:event_bt_deActionPerformed

    private void btn_dyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dyActionPerformed

        int choose = tb_ban.getSelectedRow();
        String Maban = tb_ban.getValueAt(choose, 0).toString();

        String Khuvuc = this.txt_kv.getText();
        String soghe = this.cb_soghe.getSelectedItem().toString();
        String tt = this.cb_tt.getSelectedItem().toString();
        if(txt_kv.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin của bàn !", "Thông báo", JOptionPane.NO_OPTION);
            refresh();
            return;
        }
        
        BanBLL ban = new BanBLL();
        boolean kq = ban.update(Maban, Khuvuc, soghe, tt);
        if(kq)
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn vừa cập nhật thông tin bàn thành công !", "Thông báo", JOptionPane.NO_OPTION);
            setALLTable();
            refresh();
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin bàn thất bại !", "Thông báo", JOptionPane.NO_OPTION);
        refresh();
        return;
    }//GEN-LAST:event_btn_dyActionPerformed

    void refresh()
    {
        this.txt_kv.setText(null);
        this.cb_soghe.setSelectedItem("1");
        this.cb_tt.setSelectedIndex(0);
        this.cb_tt.setEnabled(false);
        
        this.btn_dy.setEnabled(false);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ban_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ban_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ban_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ban_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ban_GUI().setVisible(true);
            }
        });
    }

    void setALLTable()
    {
        BanBLL ban = new BanBLL();
        DefaultTableModel model = new DefaultTableModel();
        String[] title = {"Mã bàn", "Khu vực", "Số ghế", "Trạng thái"};
        model.setColumnIdentifiers(title);
        ArrayList<Ban_DTO> ar = ban.getAllBan();
        for(int i=0;i < ar.size();i++)
        {
            Ban_DTO ban_dto = ar.get(i);
            String Maban = ban_dto.getMaban();
            String kv = ban_dto.getKhuvuc();
            String sg = ban_dto.getSoghe();
            String tt = ban_dto.getTrangthai();
            
            Object[]temp={Maban, kv, sg, tt};
            model.addRow(temp);
        }
        this.tb_ban.setModel(model);
    }
    
    void setTableTracuu(Ban_DTO ban_dto)
    {
        BanBLL ban = new BanBLL();
        DefaultTableModel model = new DefaultTableModel();
        String[] title = {"Mã bàn", "Khu vực", "Số ghế", "Trạng thái"};
        model.setColumnIdentifiers(title);
        String Maban = ban_dto.getMaban();
        String kv = ban_dto.getKhuvuc();
        String sg = ban_dto.getSoghe();
        String tt = ban_dto.getTrangthai();
        Object[] temp = {Maban, kv, sg, tt};
        model.addRow(temp);

        this.tb_ban.setModel(model);
        return;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_cafeomely;
    private javax.swing.JPanel bg_chuquan;
    private javax.swing.JPanel bg_thoat;
    private javax.swing.JPanel bgnv;
    private javax.swing.JButton bt_can;
    private javax.swing.JButton bt_de;
    private javax.swing.JButton bt_tc;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_up;
    private javax.swing.JButton btn_dy;
    private javax.swing.JButton button_thoat;
    private javax.swing.JComboBox<String> cb_soghe;
    private javax.swing.JComboBox<String> cb_tt;
    private javax.swing.JLabel icon_cafe;
    private javax.swing.JLabel icon_cafe1;
    private javax.swing.JLabel icon_trangchu7;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_ban;
    private javax.swing.JLabel text_cafeomely1;
    private javax.swing.JLabel text_trangchu7;
    private javax.swing.JTextField txt_kv;
    // End of variables declaration//GEN-END:variables
}