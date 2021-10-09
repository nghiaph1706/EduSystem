package GUI.MainGUI;

import DAO.NhanVienDAO;
import Model.NhanVien;
import Utilities.Auth;
import Utilities.MsgBox;
import java.awt.Color;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class ForgotPasswordFrame extends javax.swing.JFrame {

    String code = "";
    NhanVienDAO nvdao = new NhanVienDAO();

    public ForgotPasswordFrame() {
        initComponents();
        intit();
    }

    void intit() {
        setBackground(new Color(0, 0, 0, 0));
        setLocationRelativeTo(this);
        btnDoiMK.setEnabled(false);
        txtCode.setEnabled(false);
        pwdMatKhau.setEnabled(false);
        pwdXacNhan.setEnabled(false);
    }

    void sendCode() {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "trang76244@st.vimaru.edu.vn";
            String accountPassword = "Gx1.61803";
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPassword);
                }
            });
            String from = "trang76244@st.vimaru.edu.vn";
            String to = txtEmail.getText().trim();
            String subject = "Xác nhận đổi mật khẩu";

            for (int i = 0; i < 6; i++) {
                code += String.valueOf(new Random().nextInt(10));
            }
            System.out.println(code);

            String body = "Mã xác nhận của bạn là: " + code;

            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);
            JOptionPane.showMessageDialog(this, "Nhập code đã gửi vào Email.");
        } catch (MessagingException ex) {
            MsgBox.alert(this, "Không thể gửi Code. Vui lòng kiểm tra lại Email.");
            throw new RuntimeException(ex);
        }
    }

    void checkUser(String manv, String email) {
        boolean check = false;
        List<NhanVien> list = nvdao.selectAll();

        for (NhanVien nv : list) {
            if (manv.equalsIgnoreCase(nv.getMaNV()) || email.equalsIgnoreCase(nv.getEmail())) {
                check = true;
                Auth.user = nv;
            }
        }

        if (check) {
            sendCode();
            btnSendCode.setEnabled(false);
            txtMaNV.setEnabled(false);
            txtEmail.setEnabled(false);
            btnDoiMK.setEnabled(true);
            txtCode.setEnabled(true);
            pwdMatKhau.setEnabled(true);
            pwdXacNhan.setEnabled(true);
        } else {
            MsgBox.alert(this, "Mã nhân viên nhập không khớp với Email.");
        }
    }

    void checkCode(String codeType) {
        if (codeType.equalsIgnoreCase(code)) {
            doiMatKhau(pwdMatKhau.getText(), pwdXacNhan.getText());
        } else {
            MsgBox.alert(this, "Code đã nhập không chính xác. Vui lòng kiểm tra lại email.");
            txtCode.setText("");
        }
    }

    void doiMatKhau(String matKhauMoi, String xacNhan) {
        if (!matKhauMoi.equalsIgnoreCase(xacNhan)) {
            MsgBox.alert(this, "Xác nhận mật khẩu không đúng.");
        } else {
            Auth.user.setMatKhau(xacNhan);
            nvdao.update(Auth.user);
            MsgBox.alert(this, "Đổi mật khẩu thành công.");
            Auth.clear();
            dispose();
            new LoginFrame().setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        pwdMatKhau = new javax.swing.JPasswordField();
        lblXacNhan = new javax.swing.JLabel();
        pwdXacNhan = new javax.swing.JPasswordField();
        btnSendCode = new javax.swing.JButton();
        btnDoiMK = new javax.swing.JButton();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/logoEduSystem.png"))); // NOI18N
        jLabel1.setText("  EduSystem");

        lblMaNV.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(102, 102, 102));
        lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaNV.setText("Mã nhân viên:");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(102, 102, 102));
        txtMaNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblEmail.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(102, 102, 102));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCode.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblCode.setForeground(new java.awt.Color(102, 102, 102));
        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCode.setText("Mã xác nhận:");

        txtCode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtCode.setForeground(new java.awt.Color(102, 102, 102));
        txtCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCode.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        lblMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMatKhau.setText("Mật khẩu:");

        pwdMatKhau.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        pwdMatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdMatKhau.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblXacNhan.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblXacNhan.setForeground(new java.awt.Color(102, 102, 102));
        lblXacNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblXacNhan.setText("Xác nhận:");

        pwdXacNhan.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdXacNhan.setForeground(new java.awt.Color(102, 102, 102));
        pwdXacNhan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdXacNhan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSendCode.setBackground(new java.awt.Color(255, 255, 255));
        btnSendCode.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnSendCode.setForeground(new java.awt.Color(102, 102, 102));
        btnSendCode.setText("GỬI MÃ");
        btnSendCode.setActionCommand("");
        btnSendCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCodeActionPerformed(evt);
            }
        });

        btnDoiMK.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiMK.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnDoiMK.setForeground(new java.awt.Color(102, 102, 102));
        btnDoiMK.setText("ĐỔI MẬT KHẨU");
        btnDoiMK.setActionCommand("");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/HeaderIcon/close.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatKhau)
                                    .addComponent(lblXacNhan))
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(btnSendCode, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pwdXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pwdMatKhau))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(lblClose))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addComponent(lblClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau)
                    .addComponent(pwdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblXacNhan)
                    .addComponent(pwdXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendCode, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCodeActionPerformed
        checkUser(txtMaNV.getText().trim(), txtEmail.getText().trim());
    }//GEN-LAST:event_btnSendCodeActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        checkCode(txtCode.getText().trim());
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

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
            java.util.logging.Logger.getLogger(ForgotPasswordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPasswordFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnSendCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblXacNhan;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JPasswordField pwdMatKhau;
    private javax.swing.JPasswordField pwdXacNhan;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    // End of variables declaration//GEN-END:variables
}
