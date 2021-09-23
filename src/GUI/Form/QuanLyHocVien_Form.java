
package GUI.Form;

import DAO.ChuyenDeDAO;
import DAO.HocVienDAO;
import DAO.KhoaHocDAO;
import DAO.NguoiHocDAO;
import GUI.Swing.ScrollBar;
import Model.ChuyenDe;
import Model.HocVien;
import Model.KhoaHoc;
import Model.NguoiHoc;
import Utilities.Auth;
import Utilities.MsgBox;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class QuanLyHocVien_Form extends javax.swing.JPanel {
    
    ChuyenDeDAO cddao = new ChuyenDeDAO();
    KhoaHocDAO khdao = new KhoaHocDAO();
    HocVienDAO hvdao = new HocVienDAO();
    NguoiHocDAO nhdao = new NguoiHocDAO();

    public QuanLyHocVien_Form() {
        initComponents();
        intit();
    }
    
    void intit(){
        scrollTable.setVerticalScrollBar(new ScrollBar());
        scrollTable1.setVerticalScrollBar(new ScrollBar());
        fillCbxChuyenDe();
    }
    
    void fillCbxChuyenDe(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxChuyenDe.getModel();
        model.removeAllElements();
        List<ChuyenDe> list = cddao.selectAll();
        for (ChuyenDe chuyenDe : list) {
            model.addElement(chuyenDe);
        }
        fillCbxKhoaHoc();
    }
    
    void fillCbxKhoaHoc(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxKhoaHoc.getModel();
        model.removeAllElements();
        ChuyenDe cd = (ChuyenDe) cbxChuyenDe.getSelectedItem();
        if (cd != null) {
            List<KhoaHoc> list = khdao.selectByChuyenDe(cd.getMaCD());
            for (KhoaHoc khoaHoc : list) {
                model.addElement(khoaHoc);
            }
        }
        fillTableHocVien();
    }
    
    void fillTableHocVien(){
        DefaultTableModel model = (DefaultTableModel) tblHocVien.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cbxKhoaHoc.getSelectedItem();
        if (kh != null) {
            List<HocVien> list = hvdao.selectByKhoaHoc(kh.getMaKH());
            for (int i = 0; i < list.size(); i++) {
                HocVien hv = list.get(i);
                String hoten = nhdao.selectById(hv.getMaNH()).getHoTen();
                model.addRow(new Object[]{i+1,hv.getMaHV(),hv.getMaNH(),hoten,hv.getDiem()});
            }
            fillTableNguoiHoc();
        }
    }
    
    void fillTableNguoiHoc(){
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cbxKhoaHoc.getSelectedItem();
        String key = txtFindNguoiHoc.getText();
        List<NguoiHoc> list = nhdao.selectNotInCourse(kh.getMaKH(), key);
        for (NguoiHoc nguoiHoc : list) {
            model.addRow(new Object[]{nguoiHoc.getMaNH(),nguoiHoc.getHoTen(),nguoiHoc.getGioiTinh()?"Nam":"Nữ",
            nguoiHoc.getNgaySinh(),nguoiHoc.getDienThoai(),nguoiHoc.getEmail()});
        }
    }
    
    void addHocVien(){
        KhoaHoc kh = (KhoaHoc) cbxKhoaHoc.getSelectedItem();
        for (int row : tblNguoiHoc.getSelectedRows()) {
            HocVien hv = new HocVien();
            hv.setMaKH(kh.getMaKH());
            hv.setDiem(0);
            hv.setMaNH((String) tblNguoiHoc.getValueAt(row, 0));
            hvdao.insert(hv);
        }
        fillTableHocVien();
        tabHVSelected(true);
    }
    
    void removeHocVien(){
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xoá học viên.");
        } else {
            if(MsgBox.confirm(this, "Bạn muốn xoá các học viên được chọn?")){
                for (int row : tblHocVien.getSelectedRows()) {
                    int mahv = (int) tblHocVien.getValueAt(row, 0);
                    hvdao.delete(mahv);
                }
            }
            fillTableHocVien();
        }
    }
    
    void updateDiem(){
        for (int i = 0; i < tblHocVien.getRowCount(); i++) {
            int mahv = (int) tblHocVien.getValueAt(i, 1);
            HocVien hv = hvdao.selectById(mahv);
            hv.setDiem((double) tblHocVien.getValueAt(i, 4));
            hvdao.update(hv);
        }
        MsgBox.alert(this, "Cập nhật điểm thành công.");
    }
    
    void tabHVSelected(boolean bln) {
        if (bln) {
            HocVien.setBackground(new Color(60, 94, 150));
            NguoiHoc.setBackground(new Color(63, 113, 194));
            TabHocVienPanel.setVisible(true);
            TabNguoiHocPanel.setVisible(false);
        } else {
            NguoiHoc.setBackground(new Color(60, 94, 150));
            HocVien.setBackground(new Color(63, 113, 194));
            TabNguoiHocPanel.setVisible(true);
            TabHocVienPanel.setVisible(false);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        TabBarPanel = new javax.swing.JPanel();
        HocVien = new javax.swing.JPanel();
        lblHocVien = new javax.swing.JLabel();
        NguoiHoc = new javax.swing.JPanel();
        lblNguoiHoc = new javax.swing.JLabel();
        TabMainPanel = new GUI.Swing.PanelBorder();
        TabHocVienPanel = new GUI.Swing.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        tblHocVien = new GUI.Swing.Table();
        lblCD = new javax.swing.JLabel();
        cbxChuyenDe = new javax.swing.JComboBox<>();
        lblKhoaHoc = new javax.swing.JLabel();
        cbxKhoaHoc = new javax.swing.JComboBox<>();
        BasicToolPanel = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnCapNhatDiem = new javax.swing.JButton();
        TabNguoiHocPanel = new GUI.Swing.PanelBorder();
        scrollTable1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new GUI.Swing.Table();
        SearchBarPanel1 = new GUI.Swing.PanelBorder();
        lblSearchIconNguoiHoc = new javax.swing.JLabel();
        txtFindNguoiHoc = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        TabBarPanel.setBackground(new java.awt.Color(255, 255, 255));

        HocVien.setBackground(new java.awt.Color(60, 94, 150));
        HocVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HocVienMouseClicked(evt);
            }
        });

        lblHocVien.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblHocVien.setForeground(new java.awt.Color(255, 255, 255));
        lblHocVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHocVien.setText("HỌC VIÊN");
        lblHocVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout HocVienLayout = new javax.swing.GroupLayout(HocVien);
        HocVien.setLayout(HocVienLayout);
        HocVienLayout.setHorizontalGroup(
            HocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHocVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        HocVienLayout.setVerticalGroup(
            HocVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHocVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NguoiHoc.setBackground(new java.awt.Color(63, 113, 194));
        NguoiHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NguoiHocMouseClicked(evt);
            }
        });

        lblNguoiHoc.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblNguoiHoc.setForeground(new java.awt.Color(255, 255, 255));
        lblNguoiHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNguoiHoc.setText("NGƯỜI HỌC");
        lblNguoiHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout NguoiHocLayout = new javax.swing.GroupLayout(NguoiHoc);
        NguoiHoc.setLayout(NguoiHocLayout);
        NguoiHocLayout.setHorizontalGroup(
            NguoiHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        NguoiHocLayout.setVerticalGroup(
            NguoiHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TabBarPanelLayout = new javax.swing.GroupLayout(TabBarPanel);
        TabBarPanel.setLayout(TabBarPanelLayout);
        TabBarPanelLayout.setHorizontalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBarPanelLayout.createSequentialGroup()
                .addComponent(HocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(NguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TabBarPanelLayout.setVerticalGroup(
            TabBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HocVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabMainPanel.setLayout(new java.awt.CardLayout());

        TabHocVienPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã học viên", "Mã người học", "Họ tên", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHocVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable.setViewportView(tblHocVien);

        lblCD.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblCD.setForeground(new java.awt.Color(102, 102, 102));
        lblCD.setText("CHUYÊN ĐỀ:");

        cbxChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxChuyenDe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxChuyenDe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChuyenDeActionPerformed(evt);
            }
        });

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblKhoaHoc.setForeground(new java.awt.Color(102, 102, 102));
        lblKhoaHoc.setText("KHOÁ HỌC:");

        cbxKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxKhoaHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbxKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKhoaHocActionPerformed(evt);
            }
        });

        BasicToolPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setText("Xoá khỏi khoá học");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhatDiem.setBackground(new java.awt.Color(255, 255, 255));
        btnCapNhatDiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhatDiem.setForeground(new java.awt.Color(102, 102, 102));
        btnCapNhatDiem.setText("Cập nhật điểm");
        btnCapNhatDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BasicToolPanelLayout = new javax.swing.GroupLayout(BasicToolPanel);
        BasicToolPanel.setLayout(BasicToolPanelLayout);
        BasicToolPanelLayout.setHorizontalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhatDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(btnCapNhatDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TabHocVienPanelLayout = new javax.swing.GroupLayout(TabHocVienPanel);
        TabHocVienPanel.setLayout(TabHocVienPanelLayout);
        TabHocVienPanelLayout.setHorizontalGroup(
            TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxChuyenDe, 0, 281, Short.MAX_VALUE)
                            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                                .addComponent(lblCD, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(126, 126, 126)))
                        .addGap(70, 70, 70)
                        .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                                .addComponent(lblKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addGap(126, 126, 126))
                            .addComponent(cbxKhoaHoc, 0, 281, Short.MAX_VALUE))
                        .addGap(374, 374, 374))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabHocVienPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(341, 341, 341))
        );
        TabHocVienPanelLayout.setVerticalGroup(
            TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabHocVienPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(TabHocVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        TabMainPanel.add(TabHocVienPanel, "card2");

        TabNguoiHocPanel.setBackground(new java.awt.Color(255, 255, 255));

        scrollTable1.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable1.setBorder(null);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người học", "Họ và tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNguoiHoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        scrollTable1.setViewportView(tblNguoiHoc);
        if (tblNguoiHoc.getColumnModel().getColumnCount() > 0) {
            tblNguoiHoc.getColumnModel().getColumn(0).setMinWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(0).setMaxWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(2).setMinWidth(100);
            tblNguoiHoc.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblNguoiHoc.getColumnModel().getColumn(2).setMaxWidth(100);
            tblNguoiHoc.getColumnModel().getColumn(3).setMinWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(3).setMaxWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(4).setMinWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblNguoiHoc.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        SearchBarPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchIconNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/search.png"))); // NOI18N
        lblSearchIconNguoiHoc.setToolTipText("Tìm người học theo họ tên.");
        lblSearchIconNguoiHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSearchIconNguoiHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchIconNguoiHocMouseClicked(evt);
            }
        });

        txtFindNguoiHoc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtFindNguoiHoc.setForeground(new java.awt.Color(102, 102, 102));
        txtFindNguoiHoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFindNguoiHoc.setToolTipText("Tìm người học theo họ tên.");
        txtFindNguoiHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFindNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindNguoiHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchBarPanel1Layout = new javax.swing.GroupLayout(SearchBarPanel1);
        SearchBarPanel1.setLayout(SearchBarPanel1Layout);
        SearchBarPanel1Layout.setHorizontalGroup(
            SearchBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchBarPanel1Layout.createSequentialGroup()
                .addComponent(lblSearchIconNguoiHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFindNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        SearchBarPanel1Layout.setVerticalGroup(
            SearchBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchBarPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(SearchBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearchIconNguoiHoc)
                    .addComponent(txtFindNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setText("Thêm vào khoá học");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TabNguoiHocPanelLayout = new javax.swing.GroupLayout(TabNguoiHocPanel);
        TabNguoiHocPanel.setLayout(TabNguoiHocPanelLayout);
        TabNguoiHocPanelLayout.setHorizontalGroup(
            TabNguoiHocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabNguoiHocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabNguoiHocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addGroup(TabNguoiHocPanelLayout.createSequentialGroup()
                        .addComponent(SearchBarPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(545, 545, 545)))
                .addContainerGap())
            .addGroup(TabNguoiHocPanelLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(440, 440, 440))
        );
        TabNguoiHocPanelLayout.setVerticalGroup(
            TabNguoiHocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabNguoiHocPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(SearchBarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scrollTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        TabMainPanel.add(TabNguoiHocPanel, "card2");

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

    private void HocVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HocVienMouseClicked
        tabHVSelected(true);
    }//GEN-LAST:event_HocVienMouseClicked

    private void NguoiHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NguoiHocMouseClicked
        tabHVSelected(false);
    }//GEN-LAST:event_NguoiHocMouseClicked

    private void cbxChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChuyenDeActionPerformed
        fillCbxKhoaHoc();
    }//GEN-LAST:event_cbxChuyenDeActionPerformed

    private void cbxKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxKhoaHocActionPerformed
        fillTableHocVien();
    }//GEN-LAST:event_cbxKhoaHocActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        removeHocVien();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDiemActionPerformed
        updateDiem();
    }//GEN-LAST:event_btnCapNhatDiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addHocVien();
    }//GEN-LAST:event_btnThemActionPerformed

    private void lblSearchIconNguoiHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchIconNguoiHocMouseClicked
        fillTableNguoiHoc();
    }//GEN-LAST:event_lblSearchIconNguoiHocMouseClicked

    private void txtFindNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindNguoiHocActionPerformed
        fillTableNguoiHoc();
    }//GEN-LAST:event_txtFindNguoiHocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasicToolPanel;
    private javax.swing.JPanel HocVien;
    private javax.swing.JPanel NguoiHoc;
    private GUI.Swing.PanelBorder SearchBarPanel1;
    private javax.swing.JPanel TabBarPanel;
    private GUI.Swing.PanelBorder TabHocVienPanel;
    private GUI.Swing.PanelBorder TabMainPanel;
    private GUI.Swing.PanelBorder TabNguoiHocPanel;
    private javax.swing.JButton btnCapNhatDiem;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxChuyenDe;
    private javax.swing.JComboBox<String> cbxKhoaHoc;
    private javax.swing.JLabel lblCD;
    private javax.swing.JLabel lblHocVien;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblNguoiHoc;
    private javax.swing.JLabel lblSearchIconNguoiHoc;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JScrollPane scrollTable1;
    private GUI.Swing.Table tblHocVien;
    private GUI.Swing.Table tblNguoiHoc;
    private javax.swing.JTextField txtFindNguoiHoc;
    // End of variables declaration//GEN-END:variables
}
