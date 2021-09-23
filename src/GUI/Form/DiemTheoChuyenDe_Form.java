
package GUI.Form;

import DAO.ThongKeDAO;
import GUI.Chart.BarChart.BarChart;
import GUI.Chart.BarChart.ModelChart;
import GUI.Swing.ScrollBar;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DiemTheoChuyenDe_Form extends javax.swing.JPanel {
    
    ThongKeDAO tkdao = new ThongKeDAO();
    BarChart barChart = new BarChart();

    public DiemTheoChuyenDe_Form() {
        initComponents();
        intit();
    }
    
    void intit(){
        scrollPane.setVerticalScrollBar(new ScrollBar());
        fillTable();
    }
    
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblTKDiemChuyenDe.getModel();
        model.setRowCount(0);
        barChart = createChart();
        List<Object[]> list = tkdao.getDiemChuyenDe();
        for (Object[] row : list) {
            String tenCD = (String) row[0];
            int slhv = (int) row[1];
            double dcn = (double) row[2];
            double dtn = (double) row[3];
            double dtb = (double) row[4];
            model.addRow(row);
            fillDataChart(tenCD, slhv, dcn, dtn, dtb);
        }
    }
    
    void fillDataChart(String masv, double slhv, double dcn, double dtn, double dtb ){
        barChart.addData(new ModelChart(masv, new double[]{slhv,dcn,dtn,dtb}));
    }
    
    BarChart createChart(){
        BarChart barChart = new BarChart();
        barChart.addLegend("Số lượng học viên", Color.yellow);
        barChart.addLegend("Điểm thấp nhất", Color.pink);
        barChart.addLegend("Điểm cao nhất", Color.blue);
        barChart.addLegend("Điểm trung bình", Color.red);
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
        scrollPane = new javax.swing.JScrollPane();
        tblTKDiemChuyenDe = new GUI.Swing.Table();
        chartPanel = new javax.swing.JPanel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tblTKDiemChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chuyên đề", "Số lượng học viên", "Điểm thấp nhất", "Điểm cao nhất", "Điểm trung bình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tblTKDiemChuyenDe);

        chartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    private javax.swing.JPanel chartPanel;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollPane;
    private GUI.Swing.Table tblTKDiemChuyenDe;
    // End of variables declaration//GEN-END:variables
}
