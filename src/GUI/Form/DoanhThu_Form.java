
package GUI.Form;

import DAO.KhoaHocDAO;
import DAO.ThongKeDAO;
import GUI.Chart.BarChart.BarChart;
import GUI.Chart.BarChart.ModelChart;
import GUI.Swing.ScrollBar;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DoanhThu_Form extends javax.swing.JPanel {
    
    KhoaHocDAO khdao = new KhoaHocDAO();
    ThongKeDAO tkdao = new ThongKeDAO();
    BarChart barChart = new BarChart();

    public DoanhThu_Form() {
        initComponents();
        fillCbxNam();
    }
    
    void intit(){
        scrollPane.setVerticalScrollBar(new ScrollBar());
        fillCbxNam();
        fillTable();
    }
    void fillCbxNam(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxNam.getModel();
        model.removeAllElements();
        List<Integer> list = khdao.selectYears();
        for (Integer year : list) {
            model.addElement(year);
        }
    }
    
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        barChart = createChart();
        int nam = (int) cbxNam.getSelectedItem();
        List<Object[]> list = tkdao.getDoanhThu(nam);
        for (Object[] row : list) {
            String tenCD = (String) row[0];
            int slhv = (int) row[2];
            double dt = (double) row[3];
            double hptb = (double) row[6];
            model.addRow(row);
            fillDataChart(tenCD, slhv, dt, hptb);
        }
    }
    
    void fillDataChart(String tenCD, double slhv, double dt, double hptb){
        barChart.addData(new ModelChart(tenCD, new double[]{slhv,dt,hptb}));
    }
    
    BarChart createChart(){
        BarChart barChart = new BarChart();
        barChart.addLegend("Số lượng học viên", Color.yellow);
        barChart.addLegend("Doanh thu", Color.pink);
        barChart.addLegend("Học phí trung bình", Color.blue);
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
        lblNam = new javax.swing.JLabel();
        cbxNam = new javax.swing.JComboBox<>();
        scrollPane = new javax.swing.JScrollPane();
        tblDoanhThu = new GUI.Swing.Table();
        chartPanel = new javax.swing.JPanel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        lblNam.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNam.setForeground(new java.awt.Color(102, 102, 102));
        lblNam.setText("CHUYÊN ĐỀ:");

        cbxNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxNam.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxNam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNamActionPerformed(evt);
            }
        });

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chuyên đề", "SL KH", "SL HV", "Doanh thu", "HP TN", "HP CN", "HP TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tblDoanhThu);
        if (tblDoanhThu.getColumnModel().getColumnCount() > 0) {
            tblDoanhThu.getColumnModel().getColumn(0).setMinWidth(300);
            tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        chartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblNam, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxNam, 0, 264, Short.MAX_VALUE)
                .addGap(575, 575, 575))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(scrollPane)
                    .addGap(25, 25, 25)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGap(363, 363, 363)))
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

    private void cbxNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNamActionPerformed
        fillTable();
    }//GEN-LAST:event_cbxNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxNam;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel lblNam;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollPane;
    private GUI.Swing.Table tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
