package GUI.Form;

import DAO.ChuyenDeDAO;
import GUI.Swing.ScrollBar;
import Model.ChuyenDe;
import Utilities.MsgBox;
import Utilities.XExcel;
import Utilities.XImage;
import Utilities.XRegex;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyChuyenDe_Form extends JPanel {

    ChuyenDeDAO dao = new ChuyenDeDAO();
    int row = -1;

    public QuanLyChuyenDe_Form() {
        initComponents();
        intit();
    }

    void intit() {
        scrollTable.setVerticalScrollBar(new ScrollBar());
        tblChuyenDe.setToolTipText("Chuyên đề.");
        fillTable();
        row = -1;
        updateStatus();
        clearForm();
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblChuyenDe.getModel();
        model.setRowCount(0);
        try {
            String key = txtFind.getText();
            List<ChuyenDe> list = dao.selectByKeyword(key);
            for (ChuyenDe cd : list) {
                Object[] row = {cd.getMaCD(), cd.getTenCD(), cd.getHocPhi(), cd.getThoiLuong()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu.");
        }
    }

    void edit() {
        String maCD = (String) tblChuyenDe.getValueAt(row, 0);
        ChuyenDe cd = dao.selectById(maCD);
        this.setForm(cd);
        this.updateStatus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        btnXoa.setEnabled(edit);
        btnCapNhat.setEnabled(edit);
        btnLuu.setEnabled(!edit);
        txtMaCD.setEnabled(false);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblChuyenDe.getRowCount() - 1);
        btnFisrt.setEnabled(!first);
        btnPrev.setEnabled(!first);
        btnLast.setEnabled(!last);
        btnNext.setEnabled(!last);
    }

    ChuyenDe getForm() {
        ChuyenDe cd = new ChuyenDe();
        cd.setMaCD(txtMaCD.getText());
        cd.setTenCD(txtTenCD.getText());
        cd.setHocPhi(Double.valueOf(txtHocPhi.getText()));
        cd.setThoiLuong(Integer.parseInt(txtThoiLuong.getText()));
        cd.setMoTa(txtMoTa.getText());
        cd.setHinh(lblImage.getToolTipText());
        return cd;
    }

    void setForm(ChuyenDe cd) {
        txtMaCD.setText(cd.getMaCD());
        txtTenCD.setText(cd.getTenCD());
        txtHocPhi.setText(String.valueOf(cd.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(cd.getThoiLuong()));
        txtMoTa.setText(cd.getMaCD());
        if (cd.getHinh() != null) {
            lblImage.setToolTipText(cd.getHinh());
            ImageIcon icon = XImage.readImageChuyenDe(cd.getHinh());
            Image img = icon.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            lblImage.setIcon(icon);
        }
    }

    void clearForm() {
        ChuyenDe cd = new ChuyenDe();
        cd.setHinh("no-image.png");
        this.setForm(cd);
        this.row = -1;
        this.updateStatus();
        txtMaCD.setEnabled(true);
    }

    void insert() {
        ChuyenDe cd = getForm();
        if (XRegex.checkNull(txtMaCD.getText(), txtTenCD.getText(), txtHocPhi.getText(), txtThoiLuong.getText())) {
            try {
                dao.insert(cd);
                fillTable();
                clearForm();
                MsgBox.alert(this, "Thêm mới thành công.");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    void update() {
        ChuyenDe cd = getForm();
        if (XRegex.checkNull(txtMaCD.getText(), txtTenCD.getText(), txtHocPhi.getText(), txtThoiLuong.getText())) {
            try {
                dao.update(cd);
                fillTable();
                setForm(cd);
                MsgBox.alert(this, "Cập nhật thành công.");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xoá nhân viên này.")) {
            String maCD = txtMaCD.getText();
            try {
                dao.delete(maCD);
                fillTable();
                clearForm();
                MsgBox.alert(this, "Xoá thành công.");
            } catch (Exception e) {
                MsgBox.alert(this, "Xoá thất bại.");
            }
        }
    }

    void first() {
        row = 0;
        edit();

    }

    void next() {
        if (row < tblChuyenDe.getRowCount() - 1) {
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
        row = tblChuyenDe.getRowCount() - 1;
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

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.saveImageChuyenDe(file);
            ImageIcon icon = XImage.readImageChuyenDe(file.getName());
            Image img = icon.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            lblImage.setIcon(icon);
            lblImage.setToolTipText(file.getName());
        }
    }
    
    void timKiem(String keyWord) {
        DefaultTableModel model = (DefaultTableModel) tblChuyenDe.getModel();
        try {
            TableRowSorter tb = new TableRowSorter(model);
            tblChuyenDe.setRowSorter(tb);
            tb.setRowFilter(RowFilter.regexFilter(keyWord, 1));
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
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
        btnExportTable = new javax.swing.JButton();
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
        btnCapNhat = new javax.swing.JButton();
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuyenDeMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(tblChuyenDe);

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
                .addComponent(txtFind)
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
                .addGap(10, 10, 10)
                .addGroup(TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                        .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                        .addComponent(SearchBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(526, 526, 526))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabDanhSachPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExportTable, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );
        TabDanhSachPanelLayout.setVerticalGroup(
            TabDanhSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabDanhSachPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(SearchBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExportTable)
                .addGap(42, 42, 42))
        );

        TabMainPanel.add(TabDanhSachPanel, "card2");

        TabCapNhatPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblMaCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblMaCD.setForeground(new java.awt.Color(102, 102, 102));
        lblMaCD.setText("MÃ CHUYÊN ĐỀ:");

        txtMaCD.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtMaCD.setForeground(new java.awt.Color(102, 102, 102));
        txtMaCD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaCD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTenCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTenCD.setForeground(new java.awt.Color(102, 102, 102));
        lblTenCD.setText("TÊN CHUYÊN ĐỀ:");

        txtTenCD.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtTenCD.setForeground(new java.awt.Color(102, 102, 102));
        txtTenCD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenCD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lblMota.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblMota.setForeground(new java.awt.Color(102, 102, 102));
        lblMota.setText("MÔ TẢ CHUYÊN ĐỀ:");

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMoTa.setMaximumSize(new java.awt.Dimension(244, 89));

        BasicToolPanel.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout BasicToolPanelLayout = new javax.swing.GroupLayout(BasicToolPanel);
        BasicToolPanel.setLayout(BasicToolPanelLayout);
        BasicToolPanelLayout.setHorizontalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createSequentialGroup()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu)
                .addGap(14, 14, 14)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(23, Short.MAX_VALUE)
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
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TabCapNhatPanelLayout = new javax.swing.GroupLayout(TabCapNhatPanel);
        TabCapNhatPanel.setLayout(TabCapNhatPanelLayout);
        TabCapNhatPanelLayout.setHorizontalGroup(
            TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MovingBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblMota, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 600, Short.MAX_VALUE))
                    .addGroup(TabCapNhatPanelLayout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
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
                                .addGap(149, 149, 149))))))
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
                .addGap(1, 1, 1)
                .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TabCapNhatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MovingBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BasicToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        TabMainPanel.add(TabCapNhatPanel, "card3");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(TabMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tblChuyenDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblChuyenDe.getSelectedRow();
            this.edit();
            tabDSSelected(false);
        }
    }//GEN-LAST:event_tblChuyenDeMouseClicked

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

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        if (evt.getClickCount() == 2) {
            chonAnh();
        }
    }//GEN-LAST:event_lblImageMouseClicked

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

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        timKiem(txtFind.getText().trim());
    }//GEN-LAST:event_txtFindKeyReleased

    private void lblSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchIconMouseClicked
        timKiem(txtFind.getText().trim());
    }//GEN-LAST:event_lblSearchIconMouseClicked

    private void btnExportTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportTableActionPerformed
        XExcel.exportTable(tblChuyenDe);
    }//GEN-LAST:event_btnExportTableActionPerformed


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
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExportTable;
    private javax.swing.JButton btnFisrt;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JFileChooser fileChooser;
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
