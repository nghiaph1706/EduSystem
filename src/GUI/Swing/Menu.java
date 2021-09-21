
package GUI.Swing;

import GUI.Event.IEventMenuSelected;
import GUI.Model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;


public class Menu extends javax.swing.JPanel {
    
    private IEventMenuSelected event;
    
    public void addEventMenuSelected(IEventMenuSelected event){
        this.event=event;
        list_Menu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        list_Menu1.setOpaque(false);
        init();
    }
    
    private void init(){
        list_Menu1.addItem(new Model_Menu("","Quản lý",Model_Menu.MenuType.TITLE));
        list_Menu1.addItem(new Model_Menu("13","Quản lý người học.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("2","Quản lý chuyên đề.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("3","Quản lý khoá học.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("4","Quản lý nhân viên.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("1","Quản lý học viên.",Model_Menu.MenuType.MENU));
        
        list_Menu1.addItem(new Model_Menu("","",Model_Menu.MenuType.EMPTY));
        list_Menu1.addItem(new Model_Menu("","Thống kê",Model_Menu.MenuType.TITLE));
        list_Menu1.addItem(new Model_Menu("5","Người học theo năm.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("6","Điểm theo chuyên đề.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("7","Điểm theo khoá học.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("8","Doanh thu.",Model_Menu.MenuType.MENU));
        
        list_Menu1.addItem(new Model_Menu("","",Model_Menu.MenuType.EMPTY));
        list_Menu1.addItem(new Model_Menu("","Hệ thống",Model_Menu.MenuType.TITLE));
        list_Menu1.addItem(new Model_Menu("9","Tài khoản.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("11","Hướng dẫn sử dụng.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("12","Giới thiệu sản phẩm.",Model_Menu.MenuType.MENU));
        list_Menu1.addItem(new Model_Menu("10","Đăng xuất.",Model_Menu.MenuType.MENU));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        list_Menu1 = new GUI.Model.List_Menu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/logoEduSystem.png"))); // NOI18N
        jLabel1.setText("EduSystem");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(list_Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(list_Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0,0,Color.decode("#4286f4"),0,getHeight(),Color.decode("#373B44"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    
    private int x;
    private int y;
    
    public void initMoving(JFrame jFrame){
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me){
                x = me.getX();
                y = me.getY();
            }
        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me){
                jFrame.setLocation(me.getXOnScreen()-x, me.getYOnScreen()-y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private GUI.Model.List_Menu<String> list_Menu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
