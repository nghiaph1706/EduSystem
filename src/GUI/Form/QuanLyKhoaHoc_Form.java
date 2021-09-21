
package GUI.Form;

import GUI.Swing.ScrollBar;
import java.awt.Color;

public class QuanLyKhoaHoc_Form extends javax.swing.JPanel {

    public QuanLyKhoaHoc_Form() {
        initComponents();
        scrollTable.setVerticalScrollBar(new ScrollBar());
        //add row
        tblKhoaHoc.addRowTable(new Object[]{"1", "PRO02", "90", "300", "20-09-202","TeoNV", "30-07-2020"});
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
        SearchBarPanel = new GUI.Swing.PanelBorder();
        lblSearchIcon = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        scrollTable = new javax.swing.JScrollPane();
        tblKhoaHoc = new GUI.Swing.Table();
        TabCapNhatPanel = new GUI.Swing.PanelBorder();
        lblCD = new javax.swing.JLabel();
        lblNgayKhaiGiang = new javax.swing.JLabel();
        txtNgayKhaiGiang = new javax.swing.JTextField();
        txtThoiLuong = new javax.swing.JTextField();
        lblThoiLuong = new javax.swing.JLabel();
        lblHocPhi = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextArea();
        BasicToolPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        MovingBtnPanel = new javax.swing.JPanel();
        btnFisrt = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblNguoiTao = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtNguoiTao = new javax.swing.JTextField();
        cbxChuyenDe = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

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
            .addComponent(lblDanhSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
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
            .addComponent(lblCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
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

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Chuyên đề", "Thời lượng", "Học phí", "Ngày khai giảng", "Người tạo", "Ngày tạo"
            }
        ));
        tblKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable.setViewportView(tblKhoaHoc);
        if (tblKhoaHoc.getColumnModel().getColumnCount() > 0) {
            tblKhoaHoc.getColumnModel().getColumn(0).setMinWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(0).setMaxWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(1).setMinWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(1).setMaxWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(2).setMinWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblKhoaHoc.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        javax.swing.GroupLayout TabDanhSachPanelLayout = new javax.swing.GroupLayout(TabDanhSachPanel);
        TabDanhSachPanel.setLayout(TabDanhSachPanelLayout);
        TabDanhSachPanelLayout.setHorizontalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                        .addComponent(SearchBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(516, 516, 516))
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE))
                .addContainerGap())
        );
        TabDanhSachPanelLayout.setVerticalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDanhSachPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SearchBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );

        TabMainPanel.add(TabDanhSachPanel, "card2");

        TabCapNhatPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblCD.setForeground(new java.awt.Color(102, 102, 102));
        lblCD.setText("CHUYÊN ĐỀ:");

        lblNgayKhaiGiang.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNgayKhaiGiang.setForeground(new java.awt.Color(102, 102, 102));
        lblNgayKhaiGiang.setText("NGÀY KHAI GIẢNG:");

        txtNgayKhaiGiang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNgayKhaiGiang.setForeground(new java.awt.Color(102, 102, 102));
        txtNgayKhaiGiang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayKhaiGiang.setText("Type here..");
        txtNgayKhaiGiang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(102, 102, 102));
        lblGhiChu.setText("GHI CHÚ:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BasicToolPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout BasicToolPanel1Layout = new javax.swing.GroupLayout(BasicToolPanel1);
        BasicToolPanel1.setLayout(BasicToolPanel1Layout);
        BasicToolPanel1Layout.setHorizontalGroup(
            BasicToolPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        BasicToolPanel1Layout.setVerticalGroup(
            BasicToolPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(btnFisrt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );
        MovingBtnPanelLayout.setVerticalGroup(
            MovingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFisrt)
            .addComponent(btnPrev)
            .addComponent(btnNext)
            .addComponent(btnLast)
        );

        lblNguoiTao.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNguoiTao.setForeground(new java.awt.Color(102, 102, 102));
        lblNguoiTao.setText("NGƯỜI TẠO:");

        lblNgayTao.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNgayTao.setForeground(new java.awt.Color(102, 102, 102));
        lblNgayTao.setText("NGÀY TẠO:");

        txtNgayTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNgayTao.setForeground(new java.awt.Color(102, 102, 102));
        txtNgayTao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayTao.setText("Type here..");
        txtNgayTao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNguoiTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNguoiTao.setForeground(new java.awt.Color(102, 102, 102));
        txtNguoiTao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNguoiTao.setText("Type here..");
        txtNguoiTao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxChuyenDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxChuyenDe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxChuyenDe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout TabCapNhatPanelLayout = new javax.swing.GroupLayout(TabCapNhatPanel);
        TabCapNhatPanel.setLayout(TabCapNhatPanelLayout);
        TabCapNhatPanelLayout.setHorizontalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblCD, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(267, 267, 267)
                                .addComponent(lblNgayKhaiGiang, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(149, 149, 149))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabCapNhatPanelLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                        .addComponent(lblGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                        .addGap(495, 495, 495))
                                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                        .addComponent(BasicToolPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(35, 35, 35)
                                        .addComponent(MovingBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(txtNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(cbxChuyenDe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(lblNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addGap(228, 228, 228)))
                        .addGap(39, 39, 39)
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiLuong)
                            .addComponent(txtNgayKhaiGiang)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                                .addGap(172, 172, 172)))))
                .addGap(112, 112, 112))
        );
        TabCapNhatPanelLayout.setVerticalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(BasicToolPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MovingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
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
                .addComponent(TabMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JPanel BasicToolPanel1;
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
    private javax.swing.JComboBox<String> cbxChuyenDe;
    private javax.swing.JLabel lblCD;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblDanhSach;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblHocPhi;
    private javax.swing.JLabel lblNgayKhaiGiang;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblNguoiTao;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JLabel lblThoiLuong;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private GUI.Swing.Table tblKhoaHoc;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtNgayKhaiGiang;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
