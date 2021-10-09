package GUI.Form;

import DAO.NhanVienDAO;
import Utilities.Auth;
import Utilities.MsgBox;
import Utilities.XImage;
import Utilities.XRegex;
import java.awt.Image;
import javax.swing.ImageIcon;

public class TaiKhoan_Form extends javax.swing.JPanel {

    NhanVienDAO dao = new NhanVienDAO();

    public TaiKhoan_Form() {
        initComponents();
        intit();
    }

    void intit() {
        lblHoTen.setText(Auth.user.getHoTen());
        lblManv.setText(Auth.user.getMaNV());
        if (Auth.user.getHinh() != null) {
            lblImage.setToolTipText(Auth.user.getHinh());
            ImageIcon icon = XImage.readImageNhanVien(Auth.user.getHinh());
            Image img = icon.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            lblImage.setIcon(icon);
        }
    }

    void doiMatKhau(String matKhauCu, String matKhauMoi, String xacNhan) {
        if (XRegex.checkNull(matKhauCu, matKhauMoi, xacNhan)) {
            if (!matKhauCu.equalsIgnoreCase(Auth.user.getMatKhau())) {
                MsgBox.alert(this, "Sai mật khẩu.");
            } else if (!matKhauMoi.equalsIgnoreCase(xacNhan)) {
                MsgBox.alert(this, "Xác nhận mật khẩu không đúng.");
            } else {
                Auth.user.setMatKhau(xacNhan);
                dao.update(Auth.user);
                MsgBox.alert(this, "Đổi mật khẩu thành công.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        lblImage = new javax.swing.JLabel();
        lblManv = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblKhoaHoc = new javax.swing.JLabel();
        lblMKCu = new javax.swing.JLabel();
        lblMKMoi = new javax.swing.JLabel();
        lblXacNhan = new javax.swing.JLabel();
        btnDoiMK = new javax.swing.JButton();
        pwdMKCu = new javax.swing.JPasswordField();
        pwdMKMoi = new javax.swing.JPasswordField();
        pwdXacNhan = new javax.swing.JPasswordField();
        btnHuy = new javax.swing.JButton();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImage.setMaximumSize(new java.awt.Dimension(246, 254));
        lblImage.setMinimumSize(new java.awt.Dimension(246, 254));
        lblImage.setPreferredSize(new java.awt.Dimension(246, 254));

        lblManv.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblManv.setForeground(new java.awt.Color(102, 102, 102));
        lblManv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManv.setText("USERNAME");

        lblHoTen.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(102, 102, 102));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoTen.setText("NAME");

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblKhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        lblKhoaHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhoaHoc.setText("ĐỔI MẬT KHẨU");

        lblMKCu.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblMKCu.setForeground(new java.awt.Color(102, 102, 102));
        lblMKCu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMKCu.setText("MẬT KHẨU CŨ:");

        lblMKMoi.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblMKMoi.setForeground(new java.awt.Color(102, 102, 102));
        lblMKMoi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMKMoi.setText("MẬT KHẨU MỚI:");

        lblXacNhan.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblXacNhan.setForeground(new java.awt.Color(102, 102, 102));
        lblXacNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblXacNhan.setText("XÁC NHẬN MẬT KHẨU MỚI:");

        btnDoiMK.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiMK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDoiMK.setForeground(new java.awt.Color(102, 102, 102));
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.setActionCommand("");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        pwdMKCu.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdMKCu.setForeground(new java.awt.Color(102, 102, 102));
        pwdMKCu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdMKCu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pwdMKMoi.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdMKMoi.setForeground(new java.awt.Color(102, 102, 102));
        pwdMKMoi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdMKMoi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pwdXacNhan.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdXacNhan.setForeground(new java.awt.Color(102, 102, 102));
        pwdXacNhan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdXacNhan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnHuy.setBackground(new java.awt.Color(255, 255, 255));
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(102, 102, 102));
        btnHuy.setText("Huỷ");
        btnHuy.setActionCommand("");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManv, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pwdMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMKCu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMKMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXacNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdMKMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(155, 155, 155))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(lblKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwdMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwdMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pwdXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblManv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoiMK)
                    .addComponent(btnHuy))
                .addContainerGap(278, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        doiMatKhau(pwdMKCu.getText(), pwdMKMoi.getText(), pwdXacNhan.getText());
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        pwdMKCu.setText("");
        pwdMKMoi.setText("");
        pwdXacNhan.setText("");
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnHuy;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblMKCu;
    private javax.swing.JLabel lblMKMoi;
    private javax.swing.JLabel lblManv;
    private javax.swing.JLabel lblXacNhan;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JPasswordField pwdMKCu;
    private javax.swing.JPasswordField pwdMKMoi;
    private javax.swing.JPasswordField pwdXacNhan;
    // End of variables declaration//GEN-END:variables
}
