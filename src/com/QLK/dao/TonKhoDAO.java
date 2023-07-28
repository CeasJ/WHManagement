package com.QLK.dao;

import com.QLK.entity.TonKho;
import com.QLK.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TonKhoDAO extends QLKDAO<TonKho, String>{
	
	

    @Override
    public void insert(TonKho entity) {
        String sql="INSERT INTO TonKho (barcode,MaHH,TenHH, DVT, SLNhap, SLXuat, DonGia, TonKho, ThanhTien, NgayCapNhat,TenDV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getBarcode(), 
                entity.getMaHH(), 
                entity.getTenHH(), 
                entity.getdVT(),
                entity.getsLNhap(),
                entity.getsLXuat(),
                entity.getDonGia(),
                entity.getTonKho(),
                entity.getThanhTien(),
                entity.getNgayCapNhat(),
                entity.getTenDV());
    }

    @Override
    public void update(TonKho entity) {
        String sql="UPDATE TonKho SET MaHH=?, TenHH=?, DVT=?, SLNhap=?, SLXuat=?, DonGia=?, TonKho=?, NgayCapNhat=?, TenDV=? WHERE barcode=?";
        XJdbc.update(sql,  
                entity.getMaHH(), 
                entity.getTenHH(), 
                entity.getdVT(),
                entity.getsLNhap(),
                entity.getsLXuat(),
                entity.getDonGia(),
                entity.getTonKho(),
                entity.getNgayCapNhat(),
                entity.getTenDV(), 
                entity.getBarcode());
    }

    @Override
    public void delete(String barcode) {
        String sql="DELETE FROM TonKho WHERE barcode=?";
        XJdbc.update(sql, barcode);
    }

    @Override
    public TonKho selectById(String barcode) {
        String sql="SELECT * FROM TonKho WHERE barcode=?";
        List<TonKho> list = selectBySql(sql, barcode);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<TonKho> selectAll() {
        String sql="SELECT * FROM TonKho";
        return selectBySql(sql);
    }

    @Override
    protected List<TonKho> selectBySql(String sql, Object... args) {
        List<TonKho> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    TonKho entity=new TonKho();
                    entity.setBarcode(rs.getString("Barcode"));          
                    entity.setMaHH(rs.getString("MaHH"));
                    entity.setTenHH(rs.getString("TenHH"));
                    entity.setdVT(rs.getString("DVT"));
                    entity.setsLNhap(rs.getInt("SLNhap"));
                    entity.setsLXuat(rs.getInt("SLXuat"));
                    entity.setTonKho(rs.getInt("TonKho"));
                    entity.setDonGia(rs.getInt("DonGia"));
                    entity.setThanhTien(rs.getInt("ThanhTien"));
                    entity.setNgayCapNhat(rs.getDate("NgayCapNhat"));
                    entity.setTenDV(rs.getString("TenDV"));
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
    
    public List<TonKho> selectByDonVi(String tendv){
        String sql="SELECT * FROM TonKho WHERE TenDV=?";
        return this.selectBySql(sql, tendv);
    }
    
}
