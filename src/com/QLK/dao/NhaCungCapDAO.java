package com.QLK.dao;

import com.QLK.entity.NhaCungCap;
import com.QLK.utils.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO extends QLKDAO<NhaCungCap, String>{

    @Override
    public void insert(NhaCungCap entity) {
        String sql="INSERT INTO NhaCungCap (MaNCC, TenNCC, DienThoai, Email, DiaChi) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaNCC(), 
                entity.getTennhacc(), 
                entity.getDienThoai(), 
                entity.getEmail(),
                entity.getDiaChi());
    }

    @Override
    public void update(NhaCungCap entity) {
        String sql="UPDATE NhaCungCap SET TenNCC=?, DienThoai=?, Email=?, DiaChi=? WHERE MaNCC=?";
        XJdbc.update(sql, 
                
                entity.getTennhacc(), 
                entity.getDienThoai(), 
                entity.getEmail(),
                entity.getDiaChi(),
                entity.getMaNCC());
    }

    @Override
    public void delete(String MaNCC) {
        String sql="DELETE FROM NhaCungCap WHERE MaNCC=?";
        XJdbc.update(sql, MaNCC);
    }

    @Override
    public NhaCungCap selectById(String mancc) {
        String sql="SELECT * FROM NhaCungCap WHERE MaNCC=?";
        List<NhaCungCap> list = selectBySql(sql, mancc);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String sql="SELECT * FROM NhaCungCap";
        return selectBySql(sql);
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhaCungCap entity=new NhaCungCap();
                    entity.setMaNCC(rs.getString("MaNCC"));
                    entity.setTennhacc(rs.getString("TenNCC"));
                    entity.setDienThoai(rs.getString("DienThoai"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    list.add(entity);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public boolean checkInserted(NhaCungCap nhaCungCap) {
        String sql = "SELECT COUNT(*) AS count FROM NhaCungCap WHERE MaNCC=? OR TenNCC=? OR DienThoai=? OR Email=? OR DiaChi=?";
        try {
            ResultSet rs = null;
            try {
                // Kiểm tra riêng trường hợp TenNCC là chuỗi rỗng
                if (nhaCungCap.getTennhacc().isEmpty()) {
                    return false;
                }
                rs = XJdbc.query(sql, nhaCungCap.getMaNCC(), nhaCungCap.getTennhacc(), nhaCungCap.getDienThoai(), nhaCungCap.getEmail(), nhaCungCap.getDiaChi());
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count > 0;
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }


}
