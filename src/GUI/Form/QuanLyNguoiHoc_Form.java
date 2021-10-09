package GUI.Form;

import DAO.NguoiHocDAO;
import GUI.Swing.ScrollBar;
import Model.NguoiHoc;
import Utilities.Auth;
import Utilities.MsgBox;
import Utilities.XDate;
import Utilities.XRegex;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class QuanLyNguoiHoc_Form extends javax.swing.JPanel {

    NguoiHocDAO dao = new NguoiHocDAO();
    int row = -1;

    public QuanLyNguoiHoc_Form() {
        initComponents();
        intit();
    }

    void intit() {
        setOpaque(false);
        scrollTable.setVerticalScrollBar(new ScrollBar());
        fillTable();
        row = -1;
        updateStatus();
        clearForm();
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblNguoihoc.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtFind.getText();
            List<NguoiHoc> list = dao.selectByKeyword(keyword);
            for (NguoiHoc nh : list) {
                Object[] row = {nh.getMaNH(), nh.getHoTen(), nh.getGioiTinh() ? "Nam" : "Nữ", nh.getNgaySinh(), nh.getDienThoai(), nh.getEmail(), nh.getMaNV(), nh.getNgayDK()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu.");
        }
    }

    void edit() {
        String maNH = (String) tblNguoihoc.getValueAt(row, 0);
        NguoiHoc nh = dao.selectById(maNH);
        this.setForm(nh);
        this.updateStatus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        btnXoa.setEnabled(edit);
        btnCapNhat.setEnabled(edit);
        btnLuu.setEnabled(!edit);
        txtMaNH.setEnabled(false);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNguoihoc.getRowCount() - 1);
        btnFisrt.setEnabled(!first);
        btnPrev.setEnabled(!first);
        btnLast.setEnabled(!last);
        btnNext.setEnabled(!last);
    }

    NguoiHoc getForm() {
        NguoiHoc nh = new NguoiHoc();
        nh.setMaNH(txtMaNH.getText());
        nh.setHoTen(txtTenNH.getText());
        nh.setGioiTinh(rdoNam.isSelected());
        nh.setNgaySinh(jDateChooser1.getDate());
        nh.setDienThoai(txtDienThoai.getText());
        nh.setEmail(txtEmail.getText());
        nh.setMaNV(Auth.user.getMaNV());
        nh.setNgayDK(XDate.now());
        return nh;
    }

    void setForm(NguoiHoc nh) {
        txtMaNH.setText(nh.getMaNH());
        txtTenNH.setText(nh.getHoTen());
        rdoNam.setSelected(nh.getGioiTinh());
        rdoNu.setSelected(!nh.getGioiTinh());
        jDateChooser1.setDate(nh.getNgaySinh());
        txtDienThoai.setText(nh.getDienThoai());
        txtEmail.setText(nh.getEmail());
        txtGhiChu.setText(nh.getGhiChu());
    }

    void clearForm() {
        NguoiHoc nh = new NguoiHoc();
        nh.setMaNV(Auth.user.getMaNV());
        nh.setNgayDK(XDate.now());
        nh.setNgaySinh(XDate.now());
        this.setForm(nh);
        this.row = -1;
        this.updateStatus();
        txtMaNH.setEnabled(true);
    }

    void insert() {
        NguoiHoc nh = getForm();
        if (XRegex.checkNull(txtMaNH.getText(), txtTenNH.getText(), jDateChooser1.getDateFormatString(), txtDienThoai.getText(), txtEmail.getText())) {
            if (XRegex.checkMail(txtEmail.getText())) {
                if (XRegex.checkPhoneNumber(txtDienThoai.getText())) {
                    try {
                        dao.insert(nh);
                        fillTable();
                        setForm(nh);
                        MsgBox.alert(this, "Thêm mới thành công.");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Thêm mới thất bại.");
                    }
                } else {
                    MsgBox.alert(this, "Số điện thoại không đúng định dạng.");
                }
            } else {
                MsgBox.alert(this, "Email không đúng định dạng.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    void update() {
        NguoiHoc nh = getForm();
        if (XRegex.checkNull(txtMaNH.getText(), txtTenNH.getText(), jDateChooser1.getDateFormatString(), txtDienThoai.getText(), txtEmail.getText())) {
            if (XRegex.checkMail(txtEmail.getText())) {
                if (XRegex.checkPhoneNumber(txtDienThoai.getText())) {
                    try {
                        dao.update(nh);
                        fillTable();
                        setForm(nh);
                        MsgBox.alert(this, "Cập nhật thành công.");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Cập nhật thất bại.");
                    }
                } else {
                    MsgBox.alert(this, "Số điện thoại không đúng định dạng.");
                }
            } else {
                MsgBox.alert(this, "Email không đúng định dạng.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    void delete() {
        String maNH = txtMaNH.getText();
        try {
            dao.delete(maNH);
            fillTable();
            clearForm();
            MsgBox.alert(this, "Xoá thành công.");
        } catch (Exception e) {
            MsgBox.alert(this, "Xoá thất bại.");
        }
    }

    void first() {
        row = 0;
        edit();
    }

    void next() {
        if (row < tblNguoihoc.getRowCount() - 1) {
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
        row = tblNguoihoc.getRowCount() - 1;
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

    void timKiem() {
        fillTable();
        clearForm();
        row = -1;
        updateStatus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder2 = new GUI.Swing.PanelBorder();
        TabBarPanel = new javax.swing.JPanel();
        DanhSach = new javax.swing.JPanel();
        lblDanhSach = new javax.swing.JLabel();
        CapNhat = new javax.swing.JPanel();
        lblCapNhat = new javax.swing.JLabel();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabDanhSachPanel = new GUI.Swing.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        tblNguoihoc = new GUI.Swing.Table();
        SearchBarPanel = new GUI.Swing.PanelBorder();
        lblSearchIcon = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        TabCapNhatPanel = new GUI.Swing.PanelBorder();
        lblMaNH = new javax.swing.JLabel();
        txtMaNH = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        txtTenNH = new javax.swing.JTextField();
        lblGioiTinh = new javax.swing.JLabel();
        lblDienThoai = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextArea();
        BasicToolPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        MovingBtnPanel = new javax.swing.JPanel();
        btnFisrt = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblNgaySinh = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

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

        tblNguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NH", "Họ và tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email", "Mã NV", "Ngày ĐK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNguoihoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblNguoihoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNguoihocMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(tblNguoihoc);
        if (tblNguoihoc.getColumnModel().getColumnCount() > 0) {
            tblNguoihoc.getColumnModel().getColumn(0).setMinWidth(70);
            tblNguoihoc.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblNguoihoc.getColumnModel().getColumn(0).setMaxWidth(70);
            tblNguoihoc.getColumnModel().getColumn(2).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(2).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(3).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(3).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(4).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(4).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(6).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(6).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(6).setMaxWidth(120);
            tblNguoihoc.getColumnModel().getColumn(7).setMinWidth(120);
            tblNguoihoc.getColumnModel().getColumn(7).setPreferredWidth(120);
            tblNguoihoc.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        SearchBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        lblSearchIcon.setToolTipText("Tìm theo họ tên.");
        lblSearchIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSearchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchIconMouseClicked(evt);
            }
        });

        txtFind.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtFind.setForeground(new java.awt.Color(102, 102, 102));
        txtFind.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFind.setToolTipText("Tìm theo họ tên.");
        txtFind.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout SearchBarPanelLayout = new javax.swing.GroupLayout(SearchBarPanel);
        SearchBarPanel.setLayout(SearchBarPanelLayout);
        SearchBarPanelLayout.setHorizontalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchBarPanelLayout.createSequentialGroup()
                .addComponent(lblSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        SearchBarPanelLayout.setVerticalGroup(
            SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SearchBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout TabDanhSachPanelLayout = new javax.swing.GroupLayout(TabDanhSachPanel);
        TabDanhSachPanel.setLayout(TabDanhSachPanelLayout);
        TabDanhSachPanelLayout.setHorizontalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable)
                    .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                        .addComponent(SearchBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 610, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TabDanhSachPanelLayout.setVerticalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDanhSachPanelLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(SearchBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        TabMainPanel.add(TabDanhSachPanel, "card2");

        TabCapNhatPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblMaNH.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblMaNH.setForeground(new java.awt.Color(102, 102, 102));
        lblMaNH.setText("MÃ NGƯỜI HỌC:");

        txtMaNH.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtMaNH.setForeground(new java.awt.Color(102, 102, 102));
        txtMaNH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaNH.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHoTen.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(102, 102, 102));
        lblHoTen.setText("HỌ VÀ TÊN:");

        txtTenNH.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTenNH.setForeground(new java.awt.Color(102, 102, 102));
        txtTenNH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenNH.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(102, 102, 102));
        lblGioiTinh.setText("GIỚI TÍNH:");

        lblDienThoai.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblDienThoai.setForeground(new java.awt.Color(102, 102, 102));
        lblDienThoai.setText("ĐIỆN THOẠI");

        txtDienThoai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtDienThoai.setForeground(new java.awt.Color(102, 102, 102));
        txtDienThoai.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDienThoai.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(102, 102, 102));
        lblGhiChu.setText("GHI CHÚ:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtGhiChu.setMaximumSize(new java.awt.Dimension(244, 89));

        BasicToolPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_plus_math_20px.png"))); // NOI18N
        btnThem.setText(" Thêm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(255, 255, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(102, 102, 102));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_save_20px_1.png"))); // NOI18N
        btnLuu.setText("  Lưu");
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
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BasicToolPanel1Layout.setVerticalGroup(
            BasicToolPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(102, 102, 102));
        lblNgaySinh.setText("NGÀY SINH:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(102, 102, 102));
        lblEmail.setText("EMAIL:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(102, 102, 102));
        rdoNam.setText("NAM");

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(102, 102, 102));
        rdoNu.setText("NỮ");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setForeground(new java.awt.Color(102, 102, 102));
        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout TabCapNhatPanelLayout = new javax.swing.GroupLayout(TabCapNhatPanel);
        TabCapNhatPanel.setLayout(TabCapNhatPanelLayout);
        TabCapNhatPanelLayout.setHorizontalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabCapNhatPanelLayout.createSequentialGroup()
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addComponent(BasicToolPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MovingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNH, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(txtDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(lblDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(114, 114, 114))
        );
        TabCapNhatPanelLayout.setVerticalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenNH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66)
                .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MovingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BasicToolPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        TabMainPanel.add(TabCapNhatPanel, "card3");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TabMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
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
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tblNguoihocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNguoihocMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblNguoihoc.getSelectedRow();
            this.edit();
            tabDSSelected(false);
            txtMaNH.setEnabled(false);
        }
    }//GEN-LAST:event_tblNguoihocMouseClicked

    private void lblSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchIconMouseClicked
        timKiem();
    }//GEN-LAST:event_lblSearchIconMouseClicked


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
    private javax.swing.JButton btnFisrt;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblDanhSach;
    private javax.swing.JLabel lblDienThoai;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaNH;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSearchIcon;
    private GUI.Swing.PanelBorder panelBorder2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JScrollPane scrollTable;
    private GUI.Swing.Table tblNguoihoc;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaNH;
    private javax.swing.JTextField txtTenNH;
    // End of variables declaration//GEN-END:variables

}
