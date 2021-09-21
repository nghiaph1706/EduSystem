
package GUI.Form;

import GUI.Swing.ScrollBar;

public class QuanLyNhanVien_Form extends javax.swing.JPanel {

    public QuanLyNhanVien_Form() {
        initComponents();
        setOpaque(false);
        scrollTable.setVerticalScrollBar(new ScrollBar());
        //add row
        tblNhanvien.addRowTable(new Object[]{"NoPT","Phạm Thị Nở","123456","Nhân viên"});
        tblNhanvien.addRowTable(new Object[]{"PheoNC","Nguyễn Chí Phèo","123456","Nhân viên"});
        tblNhanvien.addRowTable(new Object[]{"TeoNV","Nguyễn Văn Tèo","123456","Trưởng phòng"});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        tblNhanvien = new GUI.Swing.Table();
        BasicToolPanel = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        SearchBarPanel = new GUI.Swing.PanelBorder();
        lblSearchIcon = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setPreferredSize(new java.awt.Dimension(1026, 785));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Mật khẩu", "Vai trò"
            }
        ));
        tblNhanvien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable.setViewportView(tblNhanvien);

        BasicToolPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setText("Thêm mới");

        btnLuu.setBackground(new java.awt.Color(255, 255, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(102, 102, 102));
        btnLuu.setText("Lưu");

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setText("Xoá");

        javax.swing.GroupLayout BasicToolPanelLayout = new javax.swing.GroupLayout(BasicToolPanel);
        BasicToolPanel.setLayout(BasicToolPanelLayout);
        BasicToolPanelLayout.setHorizontalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(72, 72, 72))
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThem)
                .addComponent(btnLuu)
                .addComponent(btnXoa))
        );

        SearchBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        lblSearchIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFind.setForeground(new java.awt.Color(102, 102, 102));
        txtFind.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFind.setText("Type here..");
        txtFind.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout SearchBarPanelLayout = new javax.swing.GroupLayout(SearchBarPanel);
        SearchBarPanel.setLayout(SearchBarPanelLayout);
        SearchBarPanelLayout.setHorizontalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchBarPanelLayout.createSequentialGroup()
                .addComponent(lblSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        SearchBarPanelLayout.setVerticalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(SearchBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(239, 239, 239))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(SearchBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasicToolPanel;
    private GUI.Swing.PanelBorder SearchBarPanel;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel lblSearchIcon;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private GUI.Swing.Table tblNhanvien;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
