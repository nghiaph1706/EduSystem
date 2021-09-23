
package DAO;

import Model.HocVien;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HocVienDAO extends EduSystemDAO<HocVien, Integer>{
    
    String  INSERT_SQL = "INSERT INTO HocVien(MaKH , MaNH , Diem) VALUES (?,?,?)";
    String  UPDATE_SQL = "UPDATE HocVien SET MaKH=?,MaNH=?,Diem=? WHERE MaHV=?";
    String  DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String  SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String  SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV=?";
    
    @Override
    public void insert(HocVien enity) {
        JdbcHelper.update(INSERT_SQL,enity.getMaKH(),enity.getMaNH(),enity.getDiem());
    }

    @Override
    public void update(HocVien enity) {
        JdbcHelper.update(UPDATE_SQL, enity.getMaKH(),enity.getMaNH(),enity.getDiem(),enity.getMaHV());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectById(Integer key) {
        List<HocVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaHV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNH(rs.getString("MaNH"));
                entity.setDiem(rs.getDouble("Diem"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<HocVien> selectByKhoaHoc(int makh){
        String sql = "SELECT * FROM HocVien WHERE MaKH=?";
        return selectBySql(sql, makh);
    }
}
