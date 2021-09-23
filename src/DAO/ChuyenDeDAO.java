
package DAO;

import Model.ChuyenDe;
import Utilities.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChuyenDeDAO extends EduSystemDAO<ChuyenDe, String>{
    
    String  INSERT_SQL = "INSERT INTO ChuyenDe(MaCD , TenCD , HocPhi , ThoiLuong , Hinh, MoTa) VALUES (?,?,?,?,?,?)";
    String  UPDATE_SQL = "UPDATE ChuyenDe SET TenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=? WHERE MaCD=?";
    String  DELETE_SQL = "DELETE FROM ChuyenDe WHERE MaCD=?";
    String  SELECT_ALL_SQL = "SELECT * FROM ChuyenDe";
    String  SELECT_BY_ID_SQL = "SELECT * FROM ChuyenDe WHERE MaCD=?";
    
    @Override
    public void insert(ChuyenDe enity) {
        JdbcHelper.update(INSERT_SQL, enity.getMaCD(),enity.getTenCD(),enity.getHocPhi(),enity.getThoiLuong(),enity.getHinh(),enity.getMoTa());
    }

    @Override
    public void update(ChuyenDe enity) {
        JdbcHelper.update(UPDATE_SQL, enity.getTenCD(),enity.getHocPhi(),enity.getThoiLuong(),enity.getHinh(),enity.getMoTa(),enity.getMaCD());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenDe selectById(String key) {
        List<ChuyenDe> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("MaCD"));
                entity.setTenCD(rs.getString("TenCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ChuyenDe> selectByKeyword(String keyword){
        String sql = "SELECT *FROM ChuyenDe WHERE MaCD LIKE ?";
        return selectBySql(sql, "%"+keyword+"%");
    }
}
