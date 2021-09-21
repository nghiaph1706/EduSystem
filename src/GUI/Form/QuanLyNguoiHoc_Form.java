
package GUI.Form;

import GUI.Swing.ScrollBar;

public class QuanLyNguoiHoc_Form extends javax.swing.JPanel {

    public QuanLyNguoiHoc_Form() {
        initComponents();
        setOpaque(false);
        scrollTable.setVerticalScrollBar(new ScrollBar());
        //add row
        tblNguoihoc.addRowTable(new Object[]{"PS01638", "LỮ HUY CƯỜNG","NAM", "17/06/2002", "0928768265", "PS01638@fpt.edu.vn", "PheoNC", "20/09/2020"});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBorder1 = new GUI.Swing.PanelBorder();
        BasicToolPanel = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        SearchBarPanel = new GUI.Swing.PanelBorder();
        lblSearchIcon = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        scrollTable = new javax.swing.JScrollPane();
        tblNguoihoc = new GUI.Swing.Table();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new java.awt.GridBagLayout());

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
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 561;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 36, 0);
        panelBorder1.add(BasicToolPanel, gridBagConstraints);

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
                .addContainerGap(21, Short.MAX_VALUE))
        );
        SearchBarPanelLayout.setVerticalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(80, 10, 0, 0);
        panelBorder1.add(SearchBarPanel, gridBagConstraints);

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblNguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NH", "Họ và tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email", "Mã NV", "Ngày ĐK"
            }
        ));
        tblNguoihoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable.setViewportView(tblNguoihoc);
        if (tblNguoihoc.getColumnModel().getColumnCount() > 0) {
            tblNguoihoc.getColumnModel().getColumn(0).setMinWidth(70);
            tblNguoihoc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblNguoihoc.getColumnModel().getColumn(0).setMaxWidth(70);
            tblNguoihoc.getColumnModel().getColumn(2).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(2).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(3).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(3).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(4).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(4).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(6).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(6).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(6).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(7).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(7).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 993;
        gridBagConstraints.ipady = 432;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(37, 10, 0, 0);
        panelBorder1.add(scrollTable, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
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
    private GUI.Swing.Table tblNguoihoc;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

}
