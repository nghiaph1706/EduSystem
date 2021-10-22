
package GUI.MainGUI;

import DAO.NhanVienDAO;
import Model.NhanVien;
import Utilities.Auth;
import Utilities.MsgBox;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;


public class LoginFrame extends javax.swing.JFrame {
    
    NhanVienDAO dao = new NhanVienDAO();
    
    public LoginFrame() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        intit();
    }
    
    void intit(){
        setLocationRelativeTo(this);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/GUI/Icon/logoFPT.png"));
        Image img = ii.getImage().getScaledInstance(lblLogoFPT.getWidth(), lblLogoFPT.getHeight(), Image.SCALE_SMOOTH);
        ii = new ImageIcon(img);
        lblLogoFPT.setIcon(ii);
    }
    
    void dangNhap(String manv, String matkhau){
        NhanVien nhanVien = dao.selectById(manv);
        if (nhanVien == null) {
            MsgBox.alert(this, "Sai tên đăng nhập.");
        } else if (!matkhau.equals(nhanVien.getMatKhau())) {
            MsgBox.alert(this, "Sai mật khẩu.");
        } else {
            Auth.user = nhanVien;
            new MainFrame().setVisible(true);
            this.dispose();
        }
    }
    
    void quenMatKhau(){
        new ForgotPasswordFrame().setVisible(true);
        dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKhoaHoc = new javax.swing.JLabel();
        panelBorder1 = new GUI.Swing.PanelBorder();
        lblLogoFPT = new javax.swing.JLabel();
        panelBorderGradient2 = new GUI.Swing.PanelBorderGradient();
        lblClose = new javax.swing.JLabel();
        lblIconUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblIconPass = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pwdPass = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        lblQuenMK = new javax.swing.JLabel();

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 3, 30)); // NOI18N
        lblKhoaHoc.setForeground(new java.awt.Color(210, 210, 210));
        lblKhoaHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhoaHoc.setText("ĐĂNG NHẬP");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/HeaderIcon/close.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_user_40px_1.png"))); // NOI18N

        txtUser.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        txtUser.setForeground(new java.awt.Color(102, 102, 102));
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setText("Username");
        txtUser.setBorder(null);
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        lblIconPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_lock_40px.png"))); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        pwdPass.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdPass.setForeground(new java.awt.Color(102, 102, 102));
        pwdPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdPass.setText("123456");
        pwdPass.setBorder(null);
        pwdPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdPassMouseClicked(evt);
            }
        });

        btnDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(102, 102, 102));
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_enter_20px.png"))); // NOI18N
        btnDangNhap.setText(" ĐĂNG NHẬP");
        btnDangNhap.setActionCommand("");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        lblQuenMK.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblQuenMK.setForeground(new java.awt.Color(153, 153, 153));
        lblQuenMK.setText("Quên mật khẩu ?");
        lblQuenMK.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseMoved(evt);
            }
        });
        lblQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelBorderGradient2Layout = new javax.swing.GroupLayout(panelBorderGradient2);
        panelBorderGradient2.setLayout(panelBorderGradient2Layout);
        panelBorderGradient2Layout.setHorizontalGroup(
            panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                        .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdPass)
                            .addComponent(jSeparator1)
                            .addComponent(txtUser)
                            .addComponent(jSeparator2))
                        .addGap(26, 26, 26))
                    .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                        .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(lblQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btnDangNhap)))
                        .addContainerGap(105, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose)
                .addContainerGap())
        );
        panelBorderGradient2Layout.setVerticalGroup(
            panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                .addComponent(lblClose)
                .addGap(119, 119, 119)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblQuenMK)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblLogoFPT, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(panelBorderGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(lblLogoFPT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelBorderGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void pwdPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdPassMouseClicked
        pwdPass.setText("");
    }//GEN-LAST:event_pwdPassMouseClicked

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        txtUser.setText("");
    }//GEN-LAST:event_txtUserMouseClicked

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap(txtUser.getText(), pwdPass.getText());
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblQuenMKMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseMoved
        lblQuenMK.setForeground(Color.white);
    }//GEN-LAST:event_lblQuenMKMouseMoved

    private void lblQuenMKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseExited
        lblQuenMK.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_lblQuenMKMouseExited

    private void lblQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseClicked
        quenMatKhau();
    }//GEN-LAST:event_lblQuenMKMouseClicked

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIconPass;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblLogoFPT;
    private javax.swing.JLabel lblQuenMK;
    private GUI.Swing.PanelBorder panelBorder1;
    private GUI.Swing.PanelBorderGradient panelBorderGradient2;
    private javax.swing.JPasswordField pwdPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
