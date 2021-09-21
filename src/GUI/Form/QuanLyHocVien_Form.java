
package GUI.Form;

import GUI.Swing.ScrollBar;
import java.awt.Color;

public class QuanLyHocVien_Form extends javax.swing.JPanel {

    public QuanLyHocVien_Form() {
        initComponents();
        scrollTable.setVerticalScrollBar(new ScrollBar());
        //add row
        tblHocVien.addRowTable(new Object[]{"1025","PS01638","Lữ Huy Cường","5.0"});
        tblNguoiHoc.addRowTable(new Object[]{"PS01638", "LỮ HUY CƯỜNG","NAM", "17/06/2002", "0928768265", "PS01638@fpt.edu.vn"});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        TabBarPanel = new javax.swing.JPanel();
        HocVien = new javax.swing.JPanel();
        lblHocVien = new javax.swing.JLabel();
        NguoiHoc = new javax.swing.JPanel();
        lblNguoiHoc = new javax.swing.JLabel();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabHocVienPanel = new GUI.Swing.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        tblHocVien = new GUI.Swing.Table();
        lblCD = new javax.swing.JLabel();
        cbxChuyenDe = new javax.swing.JComboBox<>();
        lblKhoaHoc = new javax.swing.JLabel();
        cbxKhoaHoc = new javax.swing.JComboBox<>();
        txtFind = new javax.swing.JTextField();
        lblFind = new javax.swing.JLabel();
        BasicToolPanel = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        TabNguoiHocPanel = new GUI.Swing.PanelBorder();
        scrollTable1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new GUI.Swing.Table();
        SearchBarPanel1 = new GUI.Swing.PanelBorder();
        lblSearchIcon1 = new javax.swing.JLabel();
        txtFind1 = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        TabBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        HocVien.setBackground(new java.awt.Color(60, 94, 150));
        HocVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HocVienMouseClicked(evt);
            }
        });

        lblHocVien.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblHocVien.setForeground(new java.awt.Color(255, 255, 255));
        lblHocVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHocVien.setText("HỌC VIÊN");
        lblHocVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout HocVienLayout = new javax.swing.GroupLayout(HocVien);
        HocVien.setLayout(HocVienLayout);
        HocVienLayout.setHorizontalGroup(
            HocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHocVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        HocVienLayout.setVerticalGroup(
            HocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHocVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NguoiHoc.setBackground(new java.awt.Color(63, 113, 194));
        NguoiHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NguoiHocMouseClicked(evt);
            }
        });

        lblNguoiHoc.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblNguoiHoc.setForeground(new java.awt.Color(255, 255, 255));
        lblNguoiHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNguoiHoc.setText("NGƯỜI HỌC");
        lblNguoiHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout NguoiHocLayout = new javax.swing.GroupLayout(NguoiHoc);
        NguoiHoc.setLayout(NguoiHocLayout);
        NguoiHocLayout.setHorizontalGroup(
            NguoiHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        NguoiHocLayout.setVerticalGroup(
            NguoiHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TabBarPanelLayout = new javax.swing.GroupLayout(TabBarPanel);
        TabBarPanel.setLayout(TabBarPanelLayout);
        TabBarPanelLayout.setHorizontalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addComponent(HocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(NguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarPanelLayout.setVerticalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HocVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabMainPanel.setLayout(new java.awt.CardLayout());

        TabHocVienPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã học viên", "Mã người học", "Họ tên", "Điểm"
            }
        ));
        tblHocVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable.setViewportView(tblHocVien);

        lblCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblCD.setForeground(new java.awt.Color(102, 102, 102));
        lblCD.setText("CHUYÊN ĐỀ:");

        cbxChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxChuyenDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxChuyenDe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxChuyenDe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblKhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        lblKhoaHoc.setText("KHOÁ HỌC:");

        cbxKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxKhoaHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFind.setForeground(new java.awt.Color(102, 102, 102));
        txtFind.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFind.setText("Type here..");
        txtFind.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFind.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblFind.setForeground(new java.awt.Color(102, 102, 102));
        lblFind.setText("TÌM KIẾM:");

        BasicToolPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setText("Xoá khỏi khoá học");

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(102, 102, 102));
        btnCapNhat.setText("Cập nhật điểm");

        javax.swing.GroupLayout BasicToolPanelLayout = new javax.swing.GroupLayout(BasicToolPanel);
        BasicToolPanel.setLayout(BasicToolPanelLayout);
        BasicToolPanelLayout.setHorizontalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TabHocVienPanelLayout = new javax.swing.GroupLayout(TabHocVienPanel);
        TabHocVienPanel.setLayout(TabHocVienPanelLayout);
        TabHocVienPanelLayout.setHorizontalGroup(
            TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxChuyenDe, 0, 281, Short.MAX_VALUE)
                            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                                .addComponent(lblCD, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(126, 126, 126)))
                        .addGap(70, 70, 70)
                        .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                                .addComponent(lblKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(126, 126, 126))
                            .addComponent(cbxKhoaHoc, 0, 281, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                                .addComponent(lblFind, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(151, 151, 151))
                            .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabHocVienPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(341, 341, 341))
        );
        TabHocVienPanelLayout.setVerticalGroup(
            TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFind, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        TabMainPanel.add(TabHocVienPanel, "card2");

        TabNguoiHocPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollTable1.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable1.setBorder(null);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người học", "Họ và tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email"
            }
        ));
        tblNguoiHoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable1.setViewportView(tblNguoiHoc);
        if (tblNguoiHoc.getColumnModel().getColumnCount() > 0) {
            tblNguoiHoc.getColumnModel().getColumn(0).setMinWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(0).setMaxWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(2).setMinWidth(100);
            tblNguoiHoc.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblNguoiHoc.getColumnModel().getColumn(2).setMaxWidth(100);
            tblNguoiHoc.getColumnModel().getColumn(3).setMinWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(3).setMaxWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(4).setMinWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        SearchBarPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        lblSearchIcon1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFind1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFind1.setForeground(new java.awt.Color(102, 102, 102));
        txtFind1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFind1.setText("Type here..");
        txtFind1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout SearchBarPanel1Layout = new javax.swing.GroupLayout(SearchBarPanel1);
        SearchBarPanel1.setLayout(SearchBarPanel1Layout);
        SearchBarPanel1Layout.setHorizontalGroup(
            SearchBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchBarPanel1Layout.createSequentialGroup()
                .addComponent(lblSearchIcon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        SearchBarPanel1Layout.setVerticalGroup(
            SearchBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchBarPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SearchBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchIcon1)
                    .addComponent(txtFind1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setText("Thêm vào khoá học");

        javax.swing.GroupLayout TabNguoiHocPanelLayout = new javax.swing.GroupLayout(TabNguoiHocPanel);
        TabNguoiHocPanel.setLayout(TabNguoiHocPanelLayout);
        TabNguoiHocPanelLayout.setHorizontalGroup(
            TabNguoiHocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabNguoiHocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabNguoiHocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addGroup(TabNguoiHocPanelLayout.createSequentialGroup()
                        .addComponent(SearchBarPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(545, 545, 545)))
                .addContainerGap())
            .addGroup(TabNguoiHocPanelLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(440, 440, 440))
        );
        TabNguoiHocPanelLayout.setVerticalGroup(
            TabNguoiHocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabNguoiHocPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(SearchBarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scrollTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        TabMainPanel.add(TabNguoiHocPanel, "card2");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(TabBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TabMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void HocVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HocVienMouseClicked
        HocVien.setBackground(new Color(60,94,150));
        NguoiHoc.setBackground(new Color(63,113,194));
        TabHocVienPanel.setVisible(true);
        TabNguoiHocPanel.setVisible(false);
    }//GEN-LAST:event_HocVienMouseClicked

    private void NguoiHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NguoiHocMouseClicked
        NguoiHoc.setBackground(new Color(60,94,150));
        HocVien.setBackground(new Color(63,113,194));
        TabNguoiHocPanel.setVisible(true);
        TabHocVienPanel.setVisible(false);
    }//GEN-LAST:event_NguoiHocMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasicToolPanel;
    private javax.swing.JPanel HocVien;
    private javax.swing.JPanel NguoiHoc;
    private GUI.Swing.PanelBorder SearchBarPanel1;
    private javax.swing.JPanel TabBarPanel;
    private GUI.Swing.PanelBorder TabHocVienPanel;
    private GUI.Swing.PanelBorder TabMainPanel;
    private GUI.Swing.PanelBorder TabNguoiHocPanel;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxChuyenDe;
    private javax.swing.JComboBox<String> cbxKhoaHoc;
    private javax.swing.JLabel lblCD;
    private javax.swing.JLabel lblFind;
    private javax.swing.JLabel lblHocVien;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblNguoiHoc;
    private javax.swing.JLabel lblSearchIcon1;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JScrollPane scrollTable1;
    private GUI.Swing.Table tblHocVien;
    private GUI.Swing.Table tblNguoiHoc;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFind1;
    // End of variables declaration//GEN-END:variables
}
