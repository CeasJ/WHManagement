package com.QLK.dao;

import com.QLK.entity.KhachHang;
import com.QLK.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends QLKDAO<KhachHang, String>{

    @Override
    public void insert(KhachHang entity) {
        String sql="INSERT INTO KhachHang (MaKH, TenKH, SDT, MST, Email, DiaChi) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaKH(), 
                entity.getTenKH(), 
                entity.getsDT(), 
                entity.getmST(), 
                entity.getEmail(),
                entity.getDiaChi());
    }

    @Override
    public void update(KhachHang entity) {
        String sql="UPDATE KhachHang SET TenKH=?, SDT=? , MST=? , Email=? , DiaChi=? WHERE MaKH=?";
        XJdbc.update(sql, 
                entity.getTenKH(), 
                entity.getsDT(), 
                entity.getmST(), 
                entity.getEmail(),
                entity.getDiaChi(),
                entity.getMaKH());
    }

    @Override
    public void delete(String MaKH) {
        String sql="DELETE FROM KhachHang WHERE MaKH=?";
        XJdbc.update(sql, MaKH);
    }

    @Override
    public KhachHang selectById(String makh) {
        String sql="SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = selectBySql(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql="SELECT * FROM KhachHang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    KhachHang entity=new KhachHang();
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setTenKH(rs.getString("TenKH"));
                    entity.setsDT(rs.getString("sDT"));
                    entity.setmST(rs.getString("mST"));
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
}
    

