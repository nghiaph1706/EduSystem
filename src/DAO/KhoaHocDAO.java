
package DAO;

import Model.KhoaHoc;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO extends EduSystemDAO<KhoaHoc, Integer>{
    
    String  INSERT_SQL = "INSERT INTO KhoaHoc( MaCD , HocPhi , ThoiLuong , NgayKG, GhiChu, MaNV, NgayTao) VALUES (?,?,?,?,?,?,?)";
    String  UPDATE_SQL = "UPDATE KhoaHoc SET MaCD=?,HocPhi=?,ThoiLuong=?,NgayKG=?,GhiChu=?,MaNV=?,NgayTao=? WHERE MaKH=?";
    String  DELETE_SQL = "DELETE FROM KhoaHoc WHERE MaKH=?";
    String  SELECT_ALL_SQL = "SELECT * FROM KhoaHoc";
    String  SELECT_BY_ID_SQL = "SELECT * FROM KhoaHoc WHERE MaKH=?";
    
    @Override
    public void insert(KhoaHoc enity) {
        JdbcHelper.update(INSERT_SQL,enity.getMaCD(),enity.getHocPhi(),enity.getThoiLuong(),enity.getNgayKG(),enity.getGhiChu(),enity.getMaNV(),enity.getNgayTao());
    }

    @Override
    public void update(KhoaHoc enity) {
        JdbcHelper.update(UPDATE_SQL, enity.getMaCD(),enity.getHocPhi(),enity.getThoiLuong(),enity.getNgayKG(),enity.getGhiChu(),enity.getMaNV(),enity.getNgayTao(),enity.getMaKH());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhoaHoc selectById(Integer key) {
        List<KhoaHoc> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaCD(rs.getString("MaCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setNgayKG(rs.getDate("NgayKG"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhoaHoc> selectByChuyenDe(String macd){
        String sql = "SELECT *FROM KhoaHoc WHERE MaCD = ?";
        return selectBySql(sql, macd);
    }
    
    public List<KhoaHoc> selectByKeyword(String keyword){
        String sql = "SELECT *FROM KhoaHoc WHERE MaCD LIKE ?";
        return selectBySql(sql, "%"+keyword+"%");
    }
    
    public List<Integer> selectYears(){
        String sql = "SELECT DISTINCT year(NgayKG) as Year FROM KhoaHoc ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
