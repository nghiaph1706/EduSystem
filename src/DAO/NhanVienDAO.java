
package DAO;

import Model.NhanVien;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends EduSystemDAO<NhanVien, String>{
    
    String  INSERT_SQL = "INSERT INTO NhanVien(MaNV , MatKhau , HoTen , VaiTro ,Email, Hinh) VALUES (?,?,?,?,?,?)";
    String  UPDATE_SQL = "UPDATE NhanVien SET MatKhau=?,HoTen=?,VaiTro=?,Email=?,Hinh=? WHERE MaNV=?";
    String  DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String  SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String  SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";
    
    @Override
    public void insert(NhanVien enity) {
        JdbcHelper.update(INSERT_SQL, enity.getMaNV(),enity.getMatKhau(),enity.getHoTen(),enity.getVaiTro(),enity.getEmail(),enity.getHinh());
    }

    @Override
    public void update(NhanVien enity) {
        JdbcHelper.update(UPDATE_SQL, enity.getMatKhau(),enity.getHoTen(),enity.getVaiTro(),enity.getEmail(),enity.getHinh(),enity.getMaNV());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object...args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setEmail(rs.getString("Email"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
