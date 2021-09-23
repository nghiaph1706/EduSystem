
package Model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author taoda
 */
public class TableModelCtrl extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return 0;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col==0) {
            return false;
        }
        return true;
    }

    
    
}
