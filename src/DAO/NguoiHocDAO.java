
package DAO;

import Model.NguoiHoc;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NguoiHocDAO extends EduSystemDAO<NguoiHoc, String>{
    
    String  INSERT_SQL = "INSERT INTO NguoiHoc(MaNH , HoTen , NgaySinh , GioiTinh , DienThoai, Email,GhiChu,MaNV,NgayDK) VALUES (?,?,?,?,?,?,?,?,?)";
    String  UPDATE_SQL = "UPDATE NguoiHoc SET HoTen=?,NgaySinh=?,GioiTinh=?,DienThoai=?,Email=?,GhiChu=?,MaNV=?,NgayDK=? WHERE MaNH=?";
    String  DELETE_SQL = "DELETE FROM NguoiHoc WHERE MaNH=?";
    String  SELECT_ALL_SQL = "SELECT * FROM NguoiHoc";
    String  SELECT_BY_ID_SQL = "SELECT * FROM NguoiHoc WHERE MaNH=?";
    
    @Override
    public void insert(NguoiHoc enity) {
        JdbcHelper.update(INSERT_SQL, enity.getMaNH(),enity.getHoTen(),enity.getNgaySinh(),enity.getGioiTinh(),enity.getDienThoai(),enity.getEmail(),enity.getGhiChu(),enity.getMaNV(),enity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc enity) {
        JdbcHelper.update(UPDATE_SQL, enity.getHoTen(),enity.getNgaySinh(),enity.getGioiTinh(),enity.getDienThoai(),enity.getEmail(),enity.getGhiChu(),enity.getMaNV(),enity.getNgayDK(),enity.getMaNH());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectById(String key) {
        List<NguoiHoc> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayDK(rs.getDate("NgayDK"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<NguoiHoc> selectByKeyword(String keyword){
        String sql = "SELECT *FROM NguoiHoc WHERE HoTen LIKE ?";
        return selectBySql(sql, "%"+keyword+"%");
    }
    
    public List<NguoiHoc> selectNotInCourse(int makh, String key){
        String sql = "SELECT *FROM NguoiHoc WHERE HoTen LIKE ? AND "
                + "MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
        return selectBySql(sql, "%"+key+"%", makh);
    }
}
