package GUI.Swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setResizingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jTable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                header.setHorizontalAlignment(JLabel.CENTER);
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellHeaderRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jTable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jTable, o, selected, bln1, i, i1);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                setFont(new Font("Tahoma", Font.BOLD, 14));
                if (selected) {
                    com.setForeground(new Color(15,89,140));
                    com.setBackground(new Color(186,168,251));
                } else {
                    com.setForeground(new Color(102,102,102));
                }
                return com;
            }
        });
    }
    
    
}
