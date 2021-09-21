
package GUI.Form;

import GUI.Chart.BarChart.ModelChart;
import GUI.Swing.ScrollBar;
import java.awt.Color;

public class DiemTheoKhoaHoc_Form extends javax.swing.JPanel {

    public DiemTheoKhoaHoc_Form() {
        initComponents();
        scrollPane.setVerticalScrollBar(new ScrollBar());
        //add row
        tblBangDiem.addRowTable(new Object[]{"PS02983", "Nguyễn Hoàng Thiên Phước", "9.0", "Xuất sắc"});
        //createchart
        barChart.addLegend("Diem", Color.yellow);
        barChart.addData(new ModelChart("Nghĩa", new double[]{8}));
        barChart.addData(new ModelChart("Nguyên", new double[]{6}));
        barChart.addData(new ModelChart("Dương", new double[]{10}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        TabBarPanel = new javax.swing.JPanel();
        BangDiem = new javax.swing.JPanel();
        lblBangDiem = new javax.swing.JLabel();
        ThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabBangDiemPanel = new GUI.Swing.PanelBorder();
        lblKhoaHoc = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tblBangDiem = new GUI.Swing.Table();
        cbxKhoaHoc = new javax.swing.JComboBox<>();
        TabThongKePanel = new GUI.Swing.PanelBorder();
        cbxKhoaHoc1 = new javax.swing.JComboBox<>();
        lblKhoaHoc1 = new javax.swing.JLabel();
        barChart = new GUI.Chart.BarChart.BarChart();

        BangDiem.setBackground(new java.awt.Color(60, 94, 150));
        BangDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangDiemMouseClicked(evt);
            }
        });

        lblBangDiem.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblBangDiem.setForeground(new java.awt.Color(255, 255, 255));
        lblBangDiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBangDiem.setText("BẢNG ĐIỂM");
        lblBangDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblBangDiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout BangDiemLayout = new javax.swing.GroupLayout(BangDiem);
        BangDiem.setLayout(BangDiemLayout);
        BangDiemLayout.setHorizontalGroup(
            BangDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBangDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        BangDiemLayout.setVerticalGroup(
            BangDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBangDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ThongKe.setBackground(new java.awt.Color(63, 113, 194));
        ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeMouseClicked(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongKe.setText("THỐNG KÊ");
        lblThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TabBarPanelLayout = new javax.swing.GroupLayout(TabBarPanel);
        TabBarPanel.setLayout(TabBarPanelLayout);
        TabBarPanelLayout.setHorizontalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addComponent(BangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarPanelLayout.setVerticalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BangDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabMainPanel.setLayout(new java.awt.CardLayout());

        TabBangDiemPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblKhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        lblKhoaHoc.setText("KHOÁ HỌC:");

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người học", "Họ và tên", "Điểm", "Xếp loại"
            }
        ));
        scrollPane.setViewportView(tblBangDiem);

        cbxKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxKhoaHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout TabBangDiemPanelLayout = new javax.swing.GroupLayout(TabBangDiemPanel);
        TabBangDiemPanel.setLayout(TabBangDiemPanelLayout);
        TabBangDiemPanelLayout.setHorizontalGroup(
            TabBangDiemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBangDiemPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(TabBangDiemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabBangDiemPanelLayout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addGap(57, 57, 57))
                    .addGroup(TabBangDiemPanelLayout.createSequentialGroup()
                        .addGroup(TabBangDiemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabBangDiemPanelLayout.createSequentialGroup()
                                .addComponent(lblKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(228, 228, 228))
                            .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(595, 595, 595))))
        );
        TabBangDiemPanelLayout.setVerticalGroup(
            TabBangDiemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBangDiemPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabMainPanel.add(TabBangDiemPanel, "card2");

        TabThongKePanel.setBackground(new java.awt.Color(255, 255, 255));

        cbxKhoaHoc1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxKhoaHoc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxKhoaHoc1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxKhoaHoc1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblKhoaHoc1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblKhoaHoc1.setForeground(new java.awt.Color(102, 102, 102));
        lblKhoaHoc1.setText("KHOÁ HỌC:");

        javax.swing.GroupLayout TabThongKePanelLayout = new javax.swing.GroupLayout(TabThongKePanel);
        TabThongKePanel.setLayout(TabThongKePanelLayout);
        TabThongKePanelLayout.setHorizontalGroup(
            TabThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabThongKePanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(TabThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabThongKePanelLayout.createSequentialGroup()
                        .addComponent(barChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))
                    .addGroup(TabThongKePanelLayout.createSequentialGroup()
                        .addGroup(TabThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabThongKePanelLayout.createSequentialGroup()
                                .addComponent(lblKhoaHoc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(228, 228, 228))
                            .addComponent(cbxKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(598, 598, 598))))
        );
        TabThongKePanelLayout.setVerticalGroup(
            TabThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabThongKePanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(barChart, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(82, 82, 82))
        );

        TabMainPanel.add(TabThongKePanel, "card3");

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

    private void BangDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangDiemMouseClicked
        BangDiem.setBackground(new Color(60,94,150));
        ThongKe.setBackground(new Color(63,113,194));
        TabBangDiemPanel.setVisible(true);
        TabThongKePanel.setVisible(false);
    }//GEN-LAST:event_BangDiemMouseClicked

    private void ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMouseClicked
        ThongKe.setBackground(new Color(60,94,150));
        BangDiem.setBackground(new Color(63,113,194));
        TabThongKePanel.setVisible(true);
        TabBangDiemPanel.setVisible(false);
    }//GEN-LAST:event_ThongKeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BangDiem;
    private GUI.Swing.PanelBorder TabBangDiemPanel;
    private javax.swing.JPanel TabBarPanel;
    private GUI.Swing.PanelBorder TabMainPanel;
    private GUI.Swing.PanelBorder TabThongKePanel;
    private javax.swing.JPanel ThongKe;
    private GUI.Chart.BarChart.BarChart barChart;
    private javax.swing.JComboBox<String> cbxKhoaHoc;
    private javax.swing.JComboBox<String> cbxKhoaHoc1;
    private javax.swing.JLabel lblBangDiem;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblKhoaHoc1;
    private javax.swing.JLabel lblThongKe;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollPane;
    private GUI.Swing.Table tblBangDiem;
    // End of variables declaration//GEN-END:variables
}
