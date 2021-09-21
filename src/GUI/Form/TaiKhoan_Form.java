
package GUI.Form;

import java.awt.Image;
import javax.swing.ImageIcon;

public class TaiKhoan_Form extends javax.swing.JPanel {

    public TaiKhoan_Form() {
        initComponents();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/GUI/Icon/MenuItemIcon/1.png"));
        Image img = ii.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
        ii = new ImageIcon(img);
        lblImage.setIcon(ii);
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

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImage.setMaximumSize(new java.awt.Dimension(180, 214));
        lblImage.setMinimumSize(new java.awt.Dimension(180, 214));
        lblImage.setPreferredSize(new java.awt.Dimension(180, 214));

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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblManv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(pwdXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(pwdMKCu))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMKCu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMKMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblXacNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(btnDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(pwdMKMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))))
                .addGap(165, 165, 165))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblManv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHoTen)
                        .addGap(317, 317, 317))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(lblKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblMKCu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwdMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblMKMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(pwdMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pwdXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
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
