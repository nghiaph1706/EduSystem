
package GUI.Form;

import GUI.Swing.ScrollBar;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class QuanLyChuyenDe_Form extends JPanel {

    public QuanLyChuyenDe_Form() {
        initComponents();
        scrollTable.setVerticalScrollBar(new ScrollBar());
        //add row
        tblChuyenDe.addRowTable(new Object[]{"JAV01", "Lập trình Java cơ bản", "300", "90"});
        System.out.println(lblImage.getPreferredSize().width+" "+lblImage.getPreferredSize().height);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/GUI/Icon/MenuItemIcon/1.png"));
        Image img = ii.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
        ii = new ImageIcon(img);
        lblImage.setIcon(ii);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        TabBarPanel = new javax.swing.JPanel();
        DanhSach = new javax.swing.JPanel();
        lblDanhSach = new javax.swing.JLabel();
        CapNhat = new javax.swing.JPanel();
        lblCapNhat = new javax.swing.JLabel();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabDanhSachPanel = new GUI.Swing.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        tblChuyenDe = new GUI.Swing.Table();
        SearchBarPanel = new GUI.Swing.PanelBorder();
        lblSearchIcon = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        TabCapNhatPanel = new GUI.Swing.PanelBorder();
        lblMaCD = new javax.swing.JLabel();
        txtMaCD = new javax.swing.JTextField();
        lblTenCD = new javax.swing.JLabel();
        txtTenCD = new javax.swing.JTextField();
        txtThoiLuong = new javax.swing.JTextField();
        lblThoiLuong = new javax.swing.JLabel();
        lblHocPhi = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        lblMota = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextArea();
        BasicToolPanel = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        MovingBtnPanel = new javax.swing.JPanel();
        btnFisrt = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setPreferredSize(new java.awt.Dimension(1026, 785));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        TabBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        DanhSach.setBackground(new java.awt.Color(60, 94, 150));
        DanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DanhSachMouseClicked(evt);
            }
        });

        lblDanhSach.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblDanhSach.setForeground(new java.awt.Color(255, 255, 255));
        lblDanhSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDanhSach.setText("DANH SÁCH");
        lblDanhSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblDanhSach.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout DanhSachLayout = new javax.swing.GroupLayout(DanhSach);
        DanhSach.setLayout(DanhSachLayout);
        DanhSachLayout.setHorizontalGroup(
            DanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDanhSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        DanhSachLayout.setVerticalGroup(
            DanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDanhSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CapNhat.setBackground(new java.awt.Color(63, 113, 194));
        CapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CapNhatMouseClicked(evt);
            }
        });

        lblCapNhat.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        lblCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapNhat.setText("CẬP NHẬT");
        lblCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout CapNhatLayout = new javax.swing.GroupLayout(CapNhat);
        CapNhat.setLayout(CapNhatLayout);
        CapNhatLayout.setHorizontalGroup(
            CapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        CapNhatLayout.setVerticalGroup(
            CapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TabBarPanelLayout = new javax.swing.GroupLayout(TabBarPanel);
        TabBarPanel.setLayout(TabBarPanelLayout);
        TabBarPanelLayout.setHorizontalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addComponent(DanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarPanelLayout.setVerticalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabMainPanel.setLayout(new java.awt.CardLayout());

        TabDanhSachPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chuyên đề", "Tên chuyên đề", "Học phí", "Thời lượng"
            }
        ));
        tblChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable.setViewportView(tblChuyenDe);

        SearchBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        lblSearchIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFind.setForeground(new java.awt.Color(102, 102, 102));
        txtFind.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFind.setText("Type here..");
        txtFind.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout SearchBarPanelLayout = new javax.swing.GroupLayout(SearchBarPanel);
        SearchBarPanel.setLayout(SearchBarPanelLayout);
        SearchBarPanelLayout.setHorizontalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchBarPanelLayout.createSequentialGroup()
                .addComponent(lblSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );
        SearchBarPanelLayout.setVerticalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchIcon)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout TabDanhSachPanelLayout = new javax.swing.GroupLayout(TabDanhSachPanel);
        TabDanhSachPanel.setLayout(TabDanhSachPanelLayout);
        TabDanhSachPanelLayout.setHorizontalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                        .addComponent(SearchBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(517, 517, 517))
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        TabDanhSachPanelLayout.setVerticalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SearchBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addGap(89, 89, 89))
        );

        TabMainPanel.add(TabDanhSachPanel, "card2");

        TabCapNhatPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblMaCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblMaCD.setForeground(new java.awt.Color(102, 102, 102));
        lblMaCD.setText("MÃ CHUYÊN ĐỀ:");

        txtMaCD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaCD.setForeground(new java.awt.Color(102, 102, 102));
        txtMaCD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaCD.setText("Type here..");
        txtMaCD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTenCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTenCD.setForeground(new java.awt.Color(102, 102, 102));
        lblTenCD.setText("TÊN CHUYÊN ĐỀ:");

        txtTenCD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenCD.setForeground(new java.awt.Color(102, 102, 102));
        txtTenCD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenCD.setText("Type here..");
        txtTenCD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtThoiLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThoiLuong.setForeground(new java.awt.Color(102, 102, 102));
        txtThoiLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtThoiLuong.setText("Type here..");
        txtThoiLuong.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblThoiLuong.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblThoiLuong.setForeground(new java.awt.Color(102, 102, 102));
        lblThoiLuong.setText("THỜI LƯỢNG (giờ):");

        lblHocPhi.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblHocPhi.setForeground(new java.awt.Color(102, 102, 102));
        lblHocPhi.setText("HỌC PHÍ:");

        txtHocPhi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHocPhi.setForeground(new java.awt.Color(102, 102, 102));
        txtHocPhi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHocPhi.setText("Type here..");
        txtHocPhi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMota.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblMota.setForeground(new java.awt.Color(102, 102, 102));
        lblMota.setText("MÔ TẢ CHUYÊN ĐỀ:");

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMoTa.setMaximumSize(new java.awt.Dimension(244, 89));

        BasicToolPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setText("Thêm mới");

        btnLuu.setBackground(new java.awt.Color(255, 255, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(102, 102, 102));
        btnLuu.setText("Lưu");

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setText("Xoá");

        javax.swing.GroupLayout BasicToolPanelLayout = new javax.swing.GroupLayout(BasicToolPanel);
        BasicToolPanel.setLayout(BasicToolPanelLayout);
        BasicToolPanelLayout.setHorizontalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MovingBtnPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnFisrt.setBackground(new java.awt.Color(255, 255, 255));
        btnFisrt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFisrt.setForeground(new java.awt.Color(102, 102, 102));
        btnFisrt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/first.png"))); // NOI18N

        btnPrev.setBackground(new java.awt.Color(255, 255, 255));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(102, 102, 102));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/prev.png"))); // NOI18N

        btnNext.setBackground(new java.awt.Color(255, 255, 255));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(102, 102, 102));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/next.png"))); // NOI18N

        btnLast.setBackground(new java.awt.Color(255, 255, 255));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLast.setForeground(new java.awt.Color(102, 102, 102));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/last.png"))); // NOI18N

        javax.swing.GroupLayout MovingBtnPanelLayout = new javax.swing.GroupLayout(MovingBtnPanel);
        MovingBtnPanel.setLayout(MovingBtnPanelLayout);
        MovingBtnPanelLayout.setHorizontalGroup(
            MovingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovingBtnPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFisrt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast))
        );
        MovingBtnPanelLayout.setVerticalGroup(
            MovingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFisrt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblImage.setMaximumSize(new java.awt.Dimension(329, 352));
        lblImage.setMinimumSize(new java.awt.Dimension(24, 14));
        lblImage.setPreferredSize(new java.awt.Dimension(329, 352));

        javax.swing.GroupLayout TabCapNhatPanelLayout = new javax.swing.GroupLayout(TabCapNhatPanel);
        TabCapNhatPanel.setLayout(TabCapNhatPanelLayout);
        TabCapNhatPanelLayout.setHorizontalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblMaCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblTenCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(59, 59, 59))
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(76, 76, 76)))
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabCapNhatPanelLayout.createSequentialGroup()
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaCD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenCD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiLuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHocPhi))
                        .addGap(149, 149, 149))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabCapNhatPanelLayout.createSequentialGroup()
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(BasicToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(88, 88, 88)
                        .addComponent(MovingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TabCapNhatPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblMota, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addGap(570, 570, 570))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TabCapNhatPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(149, 149, 149))
        );
        TabCapNhatPanelLayout.setVerticalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(lblMota, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MovingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        TabMainPanel.add(TabCapNhatPanel, "card3");

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
                .addComponent(TabBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TabMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
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

    private void DanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DanhSachMouseClicked
        DanhSach.setBackground(new Color(60,94,150));
        CapNhat.setBackground(new Color(63,113,194));
        TabDanhSachPanel.setVisible(true);
        TabCapNhatPanel.setVisible(false);
    }//GEN-LAST:event_DanhSachMouseClicked

    private void CapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CapNhatMouseClicked
        CapNhat.setBackground(new Color(60,94,150));
        DanhSach.setBackground(new Color(63,113,194));
        TabCapNhatPanel.setVisible(true);
        TabDanhSachPanel.setVisible(false);
    }//GEN-LAST:event_CapNhatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasicToolPanel;
    private javax.swing.JPanel CapNhat;
    private javax.swing.JPanel DanhSach;
    private javax.swing.JPanel MovingBtnPanel;
    private GUI.Swing.PanelBorder SearchBarPanel;
    private javax.swing.JPanel TabBarPanel;
    private GUI.Swing.PanelBorder TabCapNhatPanel;
    private GUI.Swing.PanelBorder TabDanhSachPanel;
    private GUI.Swing.PanelBorder TabMainPanel;
    private javax.swing.JButton btnFisrt;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblDanhSach;
    private javax.swing.JLabel lblHocPhi;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMaCD;
    private javax.swing.JLabel lblMota;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JLabel lblTenCD;
    private javax.swing.JLabel lblThoiLuong;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private GUI.Swing.Table tblChuyenDe;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMaCD;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenCD;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
