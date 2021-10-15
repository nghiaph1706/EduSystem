package GUI.Form;

import DAO.NhanVienDAO;
import GUI.Swing.ScrollBar;
import Model.NhanVien;
import Utilities.Auth;
import Utilities.MsgBox;
import Utilities.XExcel;
import Utilities.XImage;
import Utilities.XRegex;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVien_Form extends javax.swing.JPanel {

    NhanVienDAO dao = new NhanVienDAO();
    int row = -1;

    public QuanLyNhanVien_Form() {
        initComponents();
        intit();
    }

    void intit() {
        setOpaque(false);
        scrollTable.setVerticalScrollBar(new ScrollBar());
        tblNhanvien.setToolTipText("Nhân viên.");
        fillTable();
        row = -1;
        updateStatus();
        clearForm();
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanvien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = dao.selectAll();
            for (NhanVien nv : list) {
                Object[] row = {nv.getMaNV(), nv.getHoTen(), nv.getEmail(), stringToPass(nv.getMatKhau()), nv.getVaiTro() ? "Trưởng phòng" : "Nhân viên"};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu.");
        }
    }

    void edit() {
        String maNV = (String) tblNhanvien.getValueAt(row, 0);
        NhanVien nv = dao.selectById(maNV);
        this.setForm(nv);
        this.updateStatus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        btnXoa.setEnabled(edit);
        btnCapNhat.setEnabled(edit);
        btnLuu.setEnabled(!edit);
        txtMaNV.setEnabled(false);
    }

    NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setMatKhau(pwdMatKhau.getText());
        nv.setVaiTro(rdoTruongPhong.isSelected());
        nv.setEmail(txtEmail.getText());
        nv.setHinh(lblImage.getToolTipText());
        return nv;
    }

    void setForm(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        txtEmail.setText(nv.getEmail());
        pwdMatKhau.setText(nv.getMatKhau());
        pwdXacNhan.setText(nv.getMatKhau());
        rdoNhanVien.setSelected(!nv.getVaiTro());
        rdoTruongPhong.setSelected(nv.getVaiTro());
        if (nv.getHinh() != null) {
            lblImage.setToolTipText(nv.getHinh());
            ImageIcon icon = XImage.readImageNhanVien(nv.getHinh());
            Image img = icon.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            lblImage.setIcon(icon);
        }
    }

    void clearForm() {
        NhanVien nv = new NhanVien();
        nv.setHinh("no-image.png");
        this.setForm(nv);
        this.row = -1;
        this.updateStatus();
        txtMaNV.setEnabled(true);
    }

    void insert() {
        NhanVien nv = getForm();
        if (XRegex.checkNull(txtMaNV.getText(), txtHoTen.getText(), pwdMatKhau.getText(), pwdXacNhan.getText(), txtEmail.getText())) {
            if (XRegex.checkMail(txtEmail.getText())) {
                if (!pwdXacNhan.getText().equals(nv.getMatKhau())) {
                    MsgBox.alert(this, "Xác nhận mật khẩu không đúng.");
                } else {
                    try {
                        dao.insert(nv);
                        fillTable();
                        clearForm();
                        MsgBox.alert(this, "Thêm mới thành công.");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Thêm mới thất bại.");
                    }
                }
            } else {
                MsgBox.alert(this, "Email không đúng định dạng.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    void update() {
        NhanVien nv = getForm();
        if (XRegex.checkNull(txtMaNV.getText(), txtHoTen.getText(), pwdMatKhau.getText(), pwdXacNhan.getText(), txtEmail.getText())) {
            if (XRegex.checkMail(txtEmail.getText())) {
                if (!pwdXacNhan.getText().equals(nv.getMatKhau())) {
                    MsgBox.alert(this, "Xác nhận mật khẩu không đúng.");
                } else {
                    try {
                        dao.update(nv);
                        fillTable();
                        setForm(nv);
                        MsgBox.alert(this, "Cập nhật thành công.");
                    } catch (Exception e) {
                        MsgBox.alert(this, "Cập nhật thất bại.");
                    }
                }
            } else {
                MsgBox.alert(this, "Email không đúng định dạng.");
            }
        } else {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
        }

    }

    void delete() {
        String maNV = txtMaNV.getText();
        if (maNV.equals(Auth.user.getMaNV())) {
            MsgBox.alert(this, "Không thể xoá chính bạn.");
        } else if (MsgBox.confirm(this, "Bạn thực sự muốn xoá nhân viên này.")) {
            try {
                dao.delete(maNV);
                fillTable();
                clearForm();
                MsgBox.alert(this, "Xoá thành công.");
            } catch (Exception e) {
                MsgBox.alert(this, "Xoá thất bại.");
            }
        }
    }

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.saveImageNhanVien(file);
            ImageIcon icon = XImage.readImageNhanVien(file.getName());
            Image img = icon.getImage().getScaledInstance(lblImage.getPreferredSize().width, lblImage.getPreferredSize().height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            lblImage.setIcon(icon);
            lblImage.setToolTipText(file.getName());
        }
    }

    String stringToPass(String str) {
        String pass = "*";
        for (int i = 0; i < str.length(); i++) {
            pass += "*";
        }
        return pass;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder1 = new GUI.Swing.PanelBorder();
        lblImage = new javax.swing.JLabel();
        scrollTable = new javax.swing.JScrollPane();
        tblNhanvien = new GUI.Swing.Table();
        BasicToolPanel = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        lblMaNV = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblVaitro = new javax.swing.JLabel();
        rdoTruongPhong = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        txtMaNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        pwdMatKhau = new javax.swing.JPasswordField();
        lblXacNhan = new javax.swing.JLabel();
        pwdXacNhan = new javax.swing.JPasswordField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnExportTable = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setPreferredSize(new java.awt.Dimension(1026, 785));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblImage.setMaximumSize(new java.awt.Dimension(215, 239));
        lblImage.setMinimumSize(new java.awt.Dimension(215, 239));
        lblImage.setPreferredSize(new java.awt.Dimension(215, 239));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        scrollTable.setBorder(null);

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Email", "Mật khẩu", "Vai trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanvien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanvienMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(tblNhanvien);

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
        btnLuu.setText("   Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Icon/icons8_trash_can_20px.png"))); // NOI18N
        btnXoa.setText("  Xoá");
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
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BasicToolPanelLayout.setVerticalGroup(
            BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BasicToolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThem)
                .addComponent(btnLuu)
                .addComponent(btnXoa)
                .addComponent(btnCapNhat))
        );

        lblMaNV.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(102, 102, 102));
        lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaNV.setText("Mã nhân viên:");

        lblHoTen.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(102, 102, 102));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoTen.setText("Họ và tên:");

        lblVaitro.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblVaitro.setForeground(new java.awt.Color(102, 102, 102));
        lblVaitro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVaitro.setText("Vai trò:");

        rdoTruongPhong.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoTruongPhong);
        rdoTruongPhong.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rdoTruongPhong.setForeground(new java.awt.Color(102, 102, 102));
        rdoTruongPhong.setText("Trưởng phòng");

        rdoNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rdoNhanVien.setForeground(new java.awt.Color(102, 102, 102));
        rdoNhanVien.setText("Nhân viên");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(102, 102, 102));
        txtMaNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtHoTen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(102, 102, 102));
        txtHoTen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoTen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        lblMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMatKhau.setText("Mật khẩu:");

        pwdMatKhau.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        pwdMatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdMatKhau.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblXacNhan.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblXacNhan.setForeground(new java.awt.Color(102, 102, 102));
        lblXacNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblXacNhan.setText("Xác nhận:");

        pwdXacNhan.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        pwdXacNhan.setForeground(new java.awt.Color(102, 102, 102));
        pwdXacNhan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdXacNhan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblEmail.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(102, 102, 102));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoTen)
                            .addComponent(lblVaitro)
                            .addComponent(lblMatKhau)
                            .addComponent(lblXacNhan)
                            .addComponent(lblEmail))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaNV)
                        .addGap(18, 18, 18)))
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(pwdXacNhan)
                        .addGap(172, 172, 172))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(rdoTruongPhong)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNhanVien)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pwdMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNV)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(171, 171, 171))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(btnExportTable)
                        .addGap(407, 407, 407))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNV))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen))
                        .addGap(13, 13, 13)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVaitro)
                            .addComponent(rdoTruongPhong)
                            .addComponent(rdoNhanVien))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMatKhau)
                            .addComponent(pwdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblXacNhan)
                            .addComponent(pwdXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 48, Short.MAX_VALUE)
                .addComponent(BasicToolPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnExportTable)
                .addContainerGap())
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

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblNhanvien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        clearForm();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        insert();
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblImageMouseClicked

    private void btnExportTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportTableActionPerformed
        XExcel.exportTable(tblNhanvien);
    }//GEN-LAST:event_btnExportTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasicToolPanel;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExportTable;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblVaitro;
    private javax.swing.JLabel lblXacNhan;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JPasswordField pwdMatKhau;
    private javax.swing.JPasswordField pwdXacNhan;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoTruongPhong;
    private javax.swing.JScrollPane scrollTable;
    private GUI.Swing.Table tblNhanvien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    // End of variables declaration//GEN-END:variables
}
