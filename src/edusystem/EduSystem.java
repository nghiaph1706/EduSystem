
package edusystem;

import GUI.MainGUI.LoadingFrame;
import GUI.MainGUI.LoginFrame;


public class EduSystem {

    public static void main(String[] args) {
        int i;
        LoadingFrame loadingFrame = new LoadingFrame();
        loadingFrame.setVisible(true);
        
        try {
            for (i = 0; i <= 100; i++) {
                loadingFrame.jProgressBar.setValue(i);
                loadingFrame.loadingNum.setText(String.valueOf(i)+"%");
                Thread.sleep(40);
            }
            loadingFrame.dispose();
            new LoginFrame().setVisible(true);
        } catch (Exception e) {
            
        }
    }
    
}
