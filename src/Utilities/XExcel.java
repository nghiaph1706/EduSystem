
package Utilities;

import GUI.Swing.Table;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XExcel {
    public static XSSFWorkbook workbook;
    
    public static void exportTable(Table table){
        
        List<List> data_List = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            List<String> data_Row = new ArrayList<>();
            for (int j = 0; j < model.getColumnCount(); j++) {
                String row_data = "";
                try {
                    row_data = (String) table.getValueAt(i, j);
                } catch (Exception e) {
                    row_data = String.valueOf(table.getValueAt(i, j));
                }
                data_Row.add(row_data.trim());
            }
            data_List.add(data_Row);
        }
        
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;
        chooser.setFileFilter(f);
        
        int excel = chooser.showSaveDialog(null);
        
        if (excel == JFileChooser.APPROVE_OPTION) {
            
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet(table.getToolTipText());
                
                XSSFRow rows = null;
                Cell cells = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                
                rows = spreadsheet.createRow((short) 3);
                rows.setHeight((short) 700);
                
                for (int i = 0; i < model.getColumnCount(); i++) {
                    cells = rows.createCell(i, CellType.STRING);
                    cells.setCellValue(model.getColumnName(i));
                    cells.setCellStyle(cs);
                }
                
                
                for (int i = 0; i < data_List.size(); i++) {
                    List<String> data_Row = data_List.get(i);
                    rows = spreadsheet.createRow((short) 4 + i);
                    rows.setHeight((short) 500);
                    
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        cells = rows.createCell(j);
                        cells.setCellValue(data_Row.get(j));
                        cells.setCellStyle(csc);
                    }
                }

                for (int i = 0; i < data_List.size(); i++) {
                    spreadsheet.autoSizeColumn(i);
                }

                out = new FileOutputStream(chooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "Export file excel thành công");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            MsgBox.alert(chooser, "Vui lòng chọn ổ đĩa.");
        }
    }
    
    public static CellStyle headerCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THICK);

        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 350);
        cellStyle.setFont(font);
        return cellStyle;
    }

    public static CellStyle coCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THIN);

        Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);
        return cellStyle;
    }
}
