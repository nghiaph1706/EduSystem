package GUI.Form;

import DAO.ChuyenDeDAO;
import DAO.KhoaHocDAO;
import GUI.Swing.ScrollBar;
import Model.ChuyenDe;
import Model.KhoaHoc;
import Utilities.Auth;
import Utilities.MsgBox;
import Utilities.XDate;
import Utilities.XExcel;
import Utilities.XRegex;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyKhoaHoc_Form extends javax.swing.JPanel {

    ChuyenDeDAO cddao = new ChuyenDeDAO();
    KhoaHocDAO dao = new KhoaHocDAO();
    int row = -1;

    public QuanLyKhoaHoc_Form() {
        initComponents();
        intit();
    }

    void intit() {
        scrollTable.setVerticalScrollBar(new ScrollBar());
        tblKhoaHoc.setToolTipText("Khoá học.");
        fillTable();
        fillcbxChuyenDe();
        clearForm();
        updateStatus();
        row = -1;
        tabDSSelected(true);
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblKhoaHoc.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtFind.getText();
            List<KhoaHoc> list = dao.selectByKeyword(keyword);
            for (KhoaHoc kh : list) {
                Object[] row = {kh.getMaKH(), kh.getMaCD(), kh.getThoiLuong(), kh.getHocPhi(), kh.getNgayKG(), kh.getMaNV(), kh.getNgayTao()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu.");
            System.err.println(e);
        }
    }

    void edit() {
        try {
            Integer makh = (Integer) tblKhoaHoc.getValueAt(this.row, 0);
            KhoaHoc kh = dao.selectById(makh);
            if (kh != null) {
                this.setForm(kh);
                updateStatus();
            }
        } catch (Exception e) {
        }
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        btnXoa.setEnabled(edit);
        btnCapNhat.setEnabled(edit);
        btnLuu.setEnabled(!edit);
        txtChuyenDe.setEnabled(false);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblKhoaHoc.getRowCount() - 1);
        btnFisrt.setEnabled(!first);
        btnPrev.setEnabled(!first);
        btnLast.setEnabled(!last);
        btnNext.setEnabled(!last);
    }

    KhoaHoc getForm() {
        KhoaHoc kh = new KhoaHoc();
        ChuyenDe chuyenDe = (ChuyenDe) cbxChuyenDe.getSelectedItem();
        kh.setMaCD(chuyenDe.getMaCD());
        kh.setNgayKG(jDateChooser.getDate());
        kh.setHocPhi(Double.valueOf(txtHocPhi.getText()));
        kh.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
        kh.setGhiChu(txtGhiChu.getText());
        kh.setMaNV(Auth.user.getMaNV());
        kh.setNgayTao(XDate.toDate(txtNgayTao.getText()));
        kh.setMaKH(Integer.valueOf(cbxChuyenDe.getToolTipText()));
        return kh;
    }

    void setForm(KhoaHoc kh) {
        cbxChuyenDe.setToolTipText(String.valueOf(kh.getMaKH()));
        cbxChuyenDe.getModel().setSelectedItem(cddao.selectById(kh.getMaCD()));
        jDateChooser.setDate(kh.getNgayKG());
        txtHocPhi.setText(String.valueOf(kh.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(kh.getThoiLuong()));
        txtNguoiTao.setText(kh.getMaNV());
        txtNgayTao.setText(XDate.toString(kh.getNgayTao()));
        txtGhiChu.setText(kh.getGhiChu());
    }

    void clearForm() {
        KhoaHoc kh = new KhoaHoc();
        ChuyenDe chuyenDe = (ChuyenDe) cbxChuyenDe.getSelectedItem();
        kh.setMaCD(chuyenDe.getMaCD());
        kh.setMaNV(Auth.user.getMaNV());
        kh.setNgayKG(XDate.add(30));
        kh.setNgayTao(XDate.now());
        this.setForm(kh);
        this.row = -1;
    }

    void insert() {
        KhoaHoc kh = getForm();
        kh.setNgayTao(XDate.now());
        if (XRegex.checkNull(jDateChooser.getDateFormatString(), txtHocPhi.getText(), txtThoiLuong.getText())) {
            try {
                dao.insert(kh);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }

    }

    void update() {
        KhoaHoc kh = getForm();
        if (XRegex.checkNull(jDateChooser.getDateFormatString(), txtHocPhi.getText(), txtThoiLuong.getText())) {
            try {
                dao.update(kh);
                this.fillTable();
                this.setForm(kh);
                MsgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại!");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khóa học này?")) {
            Integer makh = Integer.valueOf(cbxChuyenDe.getToolTipText());
            try {
                dao.delete(makh);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
                throw  new RuntimeException(e);
            }
        }
    }

    void first() {
        row = 0;
        edit();
    }

    void next() {
        if (row < tblKhoaHoc.getRowCount() - 1) {
            row++;
            edit();
        }
    }

    void prev() {
        if (row > 0) {
            row--;
            edit();
        }
    }

    void last() {
        row = tblKhoaHoc.getRowCount() - 1;
        edit();
    }

    void tabDSSelected(boolean bln) {
        if (bln) {
            DanhSach.setBackground(new Color(60, 94, 150));
            CapNhat.setBackground(new Color(63, 113, 194));
            TabDanhSachPanel.setVisible(true);
            TabCapNhatPanel.setVisible(false);
        } else {
            CapNhat.setBackground(new Color(60, 94, 150));
            DanhSach.setBackground(new Color(63, 113, 194));
            TabCapNhatPanel.setVisible(true);
            TabDanhSachPanel.setVisible(false);
        }
    }

    void fillcbxChuyenDe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxChuyenDe.getModel();
        model.removeAllElements();
        try {
            List<ChuyenDe> list = cddao.selectAll();
            for (ChuyenDe cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void chonChuyenDe() {
        ChuyenDe cd = (ChuyenDe) cbxChuyenDe.getSelectedItem();
        txtThoiLuong.setText(String.valueOf(cd.getThoiLuong()));
        txtHocPhi.setText(String.valueOf(cd.getHocPhi()));
        txtChuyenDe.setText(cd.getTenCD());
        txtGhiChu.setText(cd.getTenCD());
        txtChuyenDe.setEnabled(false);
        fillTable();
        updateStatus();
        tabDSSelected(false);
    }

    void timKiem(String keyWord) {
        DefaultTableModel model = (DefaultTableModel) tblKhoaHoc.getModel();
        try {
            TableRowSorter tb = new TableRowSorter(model);
            tblKhoaHoc.setRowSorter(tb);
            tb.setRowFilter(RowFilter.regexFilter(keyWord, 1));
        } catch (Exception e) {
        }
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
        lblcbxCD = new javax.swing.JLabel();
        cbxChuyenDe = new javax.swing.JComboBox<>();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabDanhSachPanel = new GUI.Swing.PanelBorder();
        SearchBarPanel = new GUI.Swing.PanelBorder();
        lblSearchIcon = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        scrollTable = new javax.swing.JScrollPane();
        tblKhoaHoc = new GUI.Swing.Table();
        btnExportTable = new javax.swing.JButton();
        TabCapNhatPanel = new GUI.Swing.PanelBorder();
        lblCD = new javax.swing.JLabel();
        lblNgayKhaiGiang = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        lblThoiLuong = new javax.swing.JLabel();
        lblHocPhi = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextArea();
        MovingBtnPanel = new javax.swing.JPanel();
        btnFisrt = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblNguoiTao = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtNguoiTao = new javax.swing.JTextField();
        txtChuyenDe = new javax.swing.JTextField();
        BasicToolPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();

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
            .addComponent(lblCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        lblcbxCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblcbxCD.setForeground(new java.awt.Color(102, 102, 102));
        lblcbxCD.setText("CHUYÊN ĐỀ:");

        cbxChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxChuyenDe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxChuyenDe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TabBarPanelLayout = new javax.swing.GroupLayout(TabBarPanel);
        TabBarPanel.setLayout(TabBarPanelLayout);
        TabBarPanelLayout.setHorizontalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TabBarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblcbxCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(DanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarPanelLayout.setVerticalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabBarPanelLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcbxCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DanhSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        TabMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabMainPanel.setLayout(new java.awt.CardLayout());

        TabDanhSachPanel.setBackground(new java.awt.Color(255, 255, 255));

        SearchBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        lblSearchIcon.setToolTipText("Tìm theo mã chuyên đề.");
        lblSearchIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSearchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchIconMouseClicked(evt);
            }
        });

        txtFind.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtFind.setForeground(new java.awt.Color(102, 102, 102));
        txtFind.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFind.setToolTipText("Tìm theo mã chuyên đề.");
        txtFind.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout SearchBarPanelLayout = new javax.swing.GroupLayout(SearchBarPanel);
        SearchBarPanel.setLayout(SearchBarPanelLayout);
        SearchBarPanelLayout.setHorizontalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchBarPanelLayout.createSequentialGroup()
                .addComponent(lblSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoaHocMouseClicked(evt);
            }
        });
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

        btnExportTable.setBackground(new java.awt.Color(255, 255, 255));
        btnExportTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExportTable.setForeground(new java.awt.Color(102, 102, 102));
        btnExportTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_enter_20px.png"))); // NOI18N
        btnExportTable.setText(" Export Table");
        btnExportTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportTableActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDanhSachPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportTable, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(450, 450, 450))
        );
        TabDanhSachPanelLayout.setVerticalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDanhSachPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SearchBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExportTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        TabMainPanel.add(TabDanhSachPanel, "card2");

        TabCapNhatPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblCD.setForeground(new java.awt.Color(102, 102, 102));
        lblCD.setText("CHUYÊN ĐỀ:");

        lblNgayKhaiGiang.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNgayKhaiGiang.setForeground(new java.awt.Color(102, 102, 102));
        lblNgayKhaiGiang.setText("NGÀY KHAI GIẢNG:");

        txtThoiLuong.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtThoiLuong.setForeground(new java.awt.Color(102, 102, 102));
        txtThoiLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtThoiLuong.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblThoiLuong.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblThoiLuong.setForeground(new java.awt.Color(102, 102, 102));
        lblThoiLuong.setText("THỜI LƯỢNG (giờ):");

        lblHocPhi.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblHocPhi.setForeground(new java.awt.Color(102, 102, 102));
        lblHocPhi.setText("HỌC PHÍ:");

        txtHocPhi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtHocPhi.setForeground(new java.awt.Color(102, 102, 102));
        txtHocPhi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHocPhi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(102, 102, 102));
        lblGhiChu.setText("GHI CHÚ:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MovingBtnPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnFisrt.setBackground(new java.awt.Color(255, 255, 255));
        btnFisrt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFisrt.setForeground(new java.awt.Color(102, 102, 102));
        btnFisrt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/first.png"))); // NOI18N
        btnFisrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFisrtActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(255, 255, 255));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(102, 102, 102));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/prev.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(255, 255, 255));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(102, 102, 102));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(255, 255, 255));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLast.setForeground(new java.awt.Color(102, 102, 102));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MovingBtnPanelLayout = new javax.swing.GroupLayout(MovingBtnPanel);
        MovingBtnPanel.setLayout(MovingBtnPanelLayout);
        MovingBtnPanelLayout.setHorizontalGroup(
            MovingBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovingBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFisrt, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
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

        txtNgayTao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtNgayTao.setForeground(new java.awt.Color(102, 102, 102));
        txtNgayTao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayTao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNguoiTao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtNguoiTao.setForeground(new java.awt.Color(102, 102, 102));
        txtNguoiTao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNguoiTao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtChuyenDe.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtChuyenDe.setForeground(new java.awt.Color(102, 102, 102));
        txtChuyenDe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChuyenDe.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BasicToolPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_plus_math_20px.png"))); // NOI18N
        btnThem.setText("Thêm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(255, 255, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(102, 102, 102));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_save_20px_1.png"))); // NOI18N
        btnLuu.setText(" Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_trash_can_20px.png"))); // NOI18N
        btnXoa.setText(" Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(102, 102, 102));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_update_left_rotation_20px.png"))); // NOI18N
        btnCapNhat.setText(" Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BasicToolPanel1Layout = new javax.swing.GroupLayout(BasicToolPanel1);
        BasicToolPanel1.setLayout(BasicToolPanel1Layout);
        BasicToolPanel1Layout.setHorizontalGroup(
            BasicToolPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanel1Layout.createSequentialGroup()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu)
                .addGap(14, 14, 14)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BasicToolPanel1Layout.setVerticalGroup(
            BasicToolPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser.setForeground(new java.awt.Color(102, 102, 102));
        jDateChooser.setDateFormatString("dd/MM/yyyy");
        jDateChooser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout TabCapNhatPanelLayout = new javax.swing.GroupLayout(TabCapNhatPanel);
        TabCapNhatPanel.setLayout(TabCapNhatPanelLayout);
        TabCapNhatPanelLayout.setHorizontalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                                .addGap(495, 495, 495))
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(BasicToolPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(MovingBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabCapNhatPanelLayout.createSequentialGroup()
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(lblCD, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addGap(267, 267, 267)
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                        .addComponent(lblNgayKhaiGiang, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                        .addGap(37, 37, 37))
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblHocPhi, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                            .addComponent(lblNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                        .addGap(228, 228, 228))
                                    .addComponent(txtChuyenDe))
                                .addGap(39, 39, 39)
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtThoiLuong)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                                        .addGap(172, 172, 172)))))
                        .addGap(112, 112, 112))))
        );
        TabCapNhatPanelLayout.setVerticalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtChuyenDe, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MovingBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BasicToolPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addComponent(TabBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tabDSSelected(true);
    }//GEN-LAST:event_DanhSachMouseClicked

    private void CapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CapNhatMouseClicked
        tabDSSelected(false);
    }//GEN-LAST:event_CapNhatMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        clearForm();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        insert();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void tblKhoaHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoaHocMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblKhoaHoc.getSelectedRow();
            this.edit();
            tabDSSelected(false);
        }
    }//GEN-LAST:event_tblKhoaHocMouseClicked

    private void btnFisrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFisrtActionPerformed
        first();
    }//GEN-LAST:event_btnFisrtActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void cbxChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChuyenDeActionPerformed
        chonChuyenDe();
    }//GEN-LAST:event_cbxChuyenDeActionPerformed

    private void lblSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchIconMouseClicked
        timKiem(txtFind.getText().trim());
    }//GEN-LAST:event_lblSearchIconMouseClicked

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        timKiem(txtFind.getText().trim());
    }//GEN-LAST:event_txtFindKeyReleased

    private void btnExportTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportTableActionPerformed
        XExcel.exportTable(tblKhoaHoc);
    }//GEN-LAST:event_btnExportTableActionPerformed


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
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExportTable;
    private javax.swing.JButton btnFisrt;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxChuyenDe;
    private com.toedter.calendar.JDateChooser jDateChooser;
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
    private javax.swing.JLabel lblcbxCD;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private GUI.Swing.Table tblKhoaHoc;
    private javax.swing.JTextField txtChuyenDe;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
