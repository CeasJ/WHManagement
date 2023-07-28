package com.QLK.dao;

import com.QLK.entity.DonVi;
import com.QLK.entity.TonKho;
import com.QLK.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonViDAO extends QLKDAO<DonVi, String>{
	
	public List<String> getComboBoxValues(List<DonVi> donViList) {
	    List<String> comboBoxValues = new ArrayList<>();
	    for (DonVi donVi : donViList) {
	        comboBoxValues.add(donVi.getTenDV());
	    }
	    return comboBoxValues;
	}


    @Override
    public void insert(DonVi entity) {
        String sql="INSERT INTO DVQuanLy (MaDV, TenDV, dienThoai, Email, DiaChi) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaDV(), 
                entity.getTenDV(), 
                entity.getDienThoai(), 
                entity.getEmail(), 
                entity.getDiaChi());
    }

    @Override
    public void update(DonVi entity) {
        String sql="UPDATE DVQuanLy SET TenDV=?, dienThoai=?, Email=?, DiaChi=? WHERE MaDV=?";
        XJdbc.update(sql, 
                entity.getTenDV(), 
                entity.getDienThoai(), 
                entity.getEmail(), 
                entity.getDiaChi(),
                entity.getMaDV());
    }

    @Override
    public void delete(String MaDV) {
        String sql="DELETE FROM DVQuanLy WHERE MaDV=?";
        XJdbc.update(sql, MaDV);
    }

    @Override
    public DonVi selectById(String madv) {
        String sql="SELECT * FROM DVQuanLy WHERE MaDV=?";
        List<DonVi> list = selectBySql(sql, madv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DonVi> selectAll() {
        String sql="SELECT * FROM DVQuanLy";
        return selectBySql(sql);    
    }

    @Override
    protected List<DonVi> selectBySql(String sql, Object... args) {
        List<DonVi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    DonVi entity=new DonVi();
                    entity.setMaDV(rs.getString("MaDV"));
                    entity.setTenDV(rs.getString("TenDV"));
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
}
    
