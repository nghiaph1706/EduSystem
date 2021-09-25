
package GUI.MainGUI;

import GUI.Event.IEventMenuSelected;
import GUI.Form.*;
import Utilities.Auth;
import Utilities.MsgBox;
import java.awt.Color;
import javax.swing.JComponent;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(this);
        setBackground(new Color(0,0,0,0));
        menu.initMoving(MainFrame.this);
        menu.addEventMenuSelected(new IEventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 1) {
                    setForm(new QuanLyNguoiHoc_Form());
                    lblChucNang.setText("QUẢN LÝ NGƯỜI HỌC");
                } else if (index == 2) {
                    setForm(new QuanLyChuyenDe_Form());
                    lblChucNang.setText("QUẢN LÝ CHUYÊN ĐỀ");
                } else if (index == 3) {
                    setForm(new QuanLyKhoaHoc_Form());
                    lblChucNang.setText("QUẢN LÝ KHOÁ HỌC");
                } else if (index == 4) {
                    if(!Auth.isManager()){
                        MsgBox.alert(panelBorder1, "Bạn không có quyền sử dụng chức năng này.");
                    } else {
                        setForm(new QuanLyNhanVien_Form());
                        lblChucNang.setText("QUẢN LÝ NHÂN VIÊN");
                    }
                    setForm(new QuanLyNhanVien_Form());
                    lblChucNang.setText("QUẢN LÝ NHÂN VIÊN");
                } else if (index == 5) {
                    setForm(new QuanLyHocVien_Form());
                    lblChucNang.setText("QUẢN LÝ HỌC VIÊN");
                } else if (index == 8) {
                    setForm(new NguoiHocTheoNam_Form());
                    lblChucNang.setText("NGƯỜI HỌC THEO NĂM");
                } else if (index == 9) {
                    setForm(new DiemTheoChuyenDe_Form());
                    lblChucNang.setText("BẢNG ĐIỂM THEO CHUYÊN ĐỀ");
                } else if (index == 10) {
                    setForm(new DiemTheoKhoaHoc_Form());
                    lblChucNang.setText("ĐIỂM THEO KHOÁ HỌC");
                } else if (index == 11) {
                    if(!Auth.isManager()){
                        MsgBox.alert(panelBorder1, "Bạn không có quyền sử dụng chức năng này.");
                    } else {
                        setForm(new DoanhThu_Form());
                        lblChucNang.setText("DOANH THU THEO CHUYÊN ĐỀ");
                    }
                } else if (index == 14) {
                    setForm(new TaiKhoan_Form());
                    lblChucNang.setText("QUẢN LÝ TÀI KHOẢN");
                } else if (index == 15) {
                    setForm(new HuongDan_Form());
                    lblChucNang.setText("HƯỚNG DẪN SỬ DỤNG");
                }else if (index == 16) {
                    setForm(new GioiThieu_Form());
                    lblChucNang.setText("GIỚI THIỆU PHẦN MỀM");
                } else if (index == 17) {
                    dangXuat();
                    setForm(new Welcome_Form() );
                    lblChucNang.setText("XIN CHÀO !");
                }
            }
        });
        setForm(new Welcome_Form() );
        lblChucNang.setText("XIN CHÀO !");
    }
    
    private void setForm(JComponent com){
        if (Auth.isLogin()) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập.");
            mainPanel.removeAll();
            mainPanel.add(com);
            mainPanel.repaint();
            mainPanel.revalidate();
            dispose();
            new LoginFrame().setVisible(true);
        }
        
    }
    
    private void dangXuat(){
        Auth.clear();
    }
    
    private void ketThuc(){
        if (MsgBox.confirm(panelBorder1, "Bạn muốn kết thúc làm việc?")) {
            System.exit(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        menu = new GUI.Swing.Menu();
        header1 = new GUI.Swing.Header();
        lblChucNang = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        lblChucNang.setFont(new java.awt.Font("Tahoma", 3, 22)); // NOI18N
        lblChucNang.setForeground(new java.awt.Color(0, 102, 255));
        lblChucNang.setText("CHỨC NĂNG");

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/HeaderIcon/close.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                .addComponent(lblClose)
                .addGap(4, 4, 4))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClose, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lblChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        ketThuc();
    }//GEN-LAST:event_lblCloseMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Swing.Header header1;
    private javax.swing.JLabel lblChucNang;
    private javax.swing.JLabel lblClose;
    private javax.swing.JPanel mainPanel;
    private GUI.Swing.Menu menu;
    private GUI.Swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
