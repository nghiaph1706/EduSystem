
package Utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MsgBox {
    
    public static void alert(Component cmpnt,String mess){
        JOptionPane.showMessageDialog(cmpnt, mess,"EduSystem",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component cmpnt,String mess){
        int result = JOptionPane.showConfirmDialog(cmpnt, mess,"EduSystem",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component cmpnt,String mess){
        return JOptionPane.showInputDialog(cmpnt, mess,"EduSystem",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
