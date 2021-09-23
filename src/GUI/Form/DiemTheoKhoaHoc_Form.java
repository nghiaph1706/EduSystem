
package GUI.Form;

import DAO.KhoaHocDAO;
import DAO.ThongKeDAO;
import GUI.Chart.BarChart.BarChart;
import GUI.Chart.BarChart.ModelChart;
import GUI.Swing.ScrollBar;
import Model.KhoaHoc;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DiemTheoKhoaHoc_Form extends javax.swing.JPanel {

    KhoaHocDAO khdao = new KhoaHocDAO();
    ThongKeDAO tkdao = new ThongKeDAO();
    BarChart barChart = new BarChart();
    
    public DiemTheoKhoaHoc_Form() {
        initComponents();
        intit();
    }
    
    void intit(){
        scrollPane.setVerticalScrollBar(new ScrollBar());
        fillCbxKhoaHoc();
        fillTable();
    }
    
    void fillCbxKhoaHoc(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxKhoaHoc.getModel();
        model.removeAllElements();
        List<KhoaHoc> list = khdao.selectAll();
        for (KhoaHoc khoaHoc : list) {
            model.addElement(khoaHoc);
        }
    }
    
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblBangDiem.getModel();
        model.setRowCount(0);
        barChart = createChart();
        KhoaHoc kh = (KhoaHoc) cbxKhoaHoc.getSelectedItem();
        List<Object[]> list = tkdao.getBangDiem(kh.getMaKH());
        if (list != null) {
            for (Object[] row : list) {
                String masv = (String) row[0];
                double diem = (double) row[2];
                model.addRow(new Object[]{row[0],row[1],diem,getXepLoai(diem)});
                fillDataChart(masv, diem);
            }
        }
    }
    
    String getXepLoai(double diem){
        if (diem < 5) {
            return "Chưa đạt";
        }
        if (diem < 6.5) {
            return "Trung bình";
        }
        if (diem < 7.5) {
            return "Khá";
        }
        if (diem < 9) {
            return "Giỏi";
        }
        return "Xuất xắc";
    }
    
    void tabBDSelected(boolean bln) {
        if (bln) {
            BangDiem.setBackground(new Color(60, 94, 150));
            ThongKe.setBackground(new Color(63, 113, 194));
            TabBangDiemPanel.setVisible(true);
            TabThongKePanel.setVisible(false);
        } else {
            ThongKe.setBackground(new Color(60, 94, 150));
            BangDiem.setBackground(new Color(63, 113, 194));
            TabThongKePanel.setVisible(true);
            TabBangDiemPanel.setVisible(false);
        }
    }
    
    void fillDataChart(String masv , double diem){
        barChart.addData(new ModelChart(masv, new double[]{diem}));
    }
    
    BarChart createChart(){
        BarChart barChart = new BarChart();
        barChart.addLegend("Điểm", Color.yellow);
        chartPanel.removeAll();
        chartPanel.add(barChart);
        chartPanel.repaint();
        chartPanel.revalidate();
        return barChart;
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
        cbxKhoaHoc = new javax.swing.JComboBox<>();
        lblKhoaHoc = new javax.swing.JLabel();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabBangDiemPanel = new GUI.Swing.PanelBorder();
        scrollPane = new javax.swing.JScrollPane();
        tblBangDiem = new GUI.Swing.Table();
        TabThongKePanel = new GUI.Swing.PanelBorder();
        chartPanel = new javax.swing.JPanel();

        TabBarPanel.setBackground(new java.awt.Color(255, 255, 255));

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
            .addComponent(lblBangDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(lblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        cbxKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxKhoaHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKhoaHocActionPerformed(evt);
            }
        });

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblKhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        lblKhoaHoc.setText("KHOÁ HỌC:");

        javax.swing.GroupLayout TabBarPanelLayout = new javax.swing.GroupLayout(TabBarPanel);
        TabBarPanel.setLayout(TabBarPanelLayout);
        TabBarPanelLayout.setHorizontalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabBarPanelLayout.createSequentialGroup()
                        .addComponent(BangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TabBarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblKhoaHoc)
                        .addGap(18, 18, 18)
                        .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarPanelLayout.setVerticalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BangDiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKhoaHoc)
                    .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        TabMainPanel.setLayout(new java.awt.CardLayout());

        TabBangDiemPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người học", "Họ và tên", "Điểm", "Xếp loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tblBangDiem);

        javax.swing.GroupLayout TabBangDiemPanelLayout = new javax.swing.GroupLayout(TabBangDiemPanel);
        TabBangDiemPanel.setLayout(TabBangDiemPanelLayout);
        TabBangDiemPanelLayout.setHorizontalGroup(
            TabBangDiemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBangDiemPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(scrollPane)
                .addGap(56, 56, 56))
        );
        TabBangDiemPanelLayout.setVerticalGroup(
            TabBangDiemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBangDiemPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        TabMainPanel.add(TabBangDiemPanel, "card2");

        TabThongKePanel.setBackground(new java.awt.Color(255, 255, 255));
        TabThongKePanel.setMaximumSize(new java.awt.Dimension(1026, 661));

        chartPanel.setBackground(new java.awt.Color(51, 255, 51));
        chartPanel.setMaximumSize(new java.awt.Dimension(1006, 560));
        chartPanel.setMinimumSize(new java.awt.Dimension(1006, 560));
        chartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout TabThongKePanelLayout = new javax.swing.GroupLayout(TabThongKePanel);
        TabThongKePanel.setLayout(TabThongKePanelLayout);
        TabThongKePanelLayout.setHorizontalGroup(
            TabThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabThongKePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TabThongKePanelLayout.setVerticalGroup(
            TabThongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabThongKePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(TabBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(TabMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tabBDSelected(true);
    }//GEN-LAST:event_BangDiemMouseClicked

    private void ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMouseClicked
        tabBDSelected(false);
    }//GEN-LAST:event_ThongKeMouseClicked

    private void cbxKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxKhoaHocActionPerformed
        fillTable();
    }//GEN-LAST:event_cbxKhoaHocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BangDiem;
    private GUI.Swing.PanelBorder TabBangDiemPanel;
    private javax.swing.JPanel TabBarPanel;
    private GUI.Swing.PanelBorder TabMainPanel;
    private GUI.Swing.PanelBorder TabThongKePanel;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JComboBox<String> cbxKhoaHoc;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel lblBangDiem;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblThongKe;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollPane;
    private GUI.Swing.Table tblBangDiem;
    // End of variables declaration//GEN-END:variables
}
