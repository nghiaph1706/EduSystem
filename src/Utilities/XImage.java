
package Utilities;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class XImage {
    
    public static Image getAppIcon(){
        URL url = XImage.class.getResource("/com/edusys/icon/1.png");
        return new ImageIcon(url).getImage();
    }
    
    public static void saveImageChuyenDe(File src){
        File dst = new File("src/Hinh/ChuyenDe",src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from,to,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void saveImageNhanVien(File src){
        File dst = new File("src/Hinh/NhanVien", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from,to,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ImageIcon readImageChuyenDe(String fileName){
        File path = new File("src/Hinh/ChuyenDe",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static ImageIcon readImageNhanVien(String fileName){
        File path = new File("src/Hinh/NhanVien",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
