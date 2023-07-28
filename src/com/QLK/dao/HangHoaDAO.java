package com.QLK.dao;

import com.QLK.entity.HangHoa;
import com.QLK.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangHoaDAO extends QLKDAO<HangHoa, String>{

    @Override
    public void insert(HangHoa entity) {
        String sql="INSERT INTO HangHoa (MaHH, TenHH, DVT, DonGia, GiaNhap, MoTa, TenNCC) VALUES (?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                entity.getMaHH(), 
                entity.getTenHH(), 
                entity.getDVT(), 
                entity.getDonGia(), 
                entity.getGiaNhap(),
                entity.getMoTa(),
                entity.getTenNCC());
    }

    @Override
    public void update(HangHoa entity) {
        String sql="UPDATE HangHoa SET TenHH=?, DVT=?, DonGia=?, GiaNhap=?, MoTa=?, TenNCC=? WHERE MaHH=?";
        XJdbc.update(sql,  
                entity.getTenHH(), 
                entity.getDVT(), 
                entity.getDonGia(), 
                entity.getGiaNhap(),
                entity.getMoTa(),
                entity.getTenNCC(),
                entity.getMaHH());
        
    }

    @Override
    public void delete(String MaHH) {
        String sql="DELETE FROM HangHoa WHERE MaHH=?";
        XJdbc.update(sql, MaHH);
    }

    @Override
    public HangHoa selectById(String mahh) {
       String sql="SELECT * FROM HangHoa WHERE MaHH=?";
        List<HangHoa> list = selectBySql(sql, mahh);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HangHoa> selectAll() {
        String sql="SELECT * FROM HangHoa";
        return selectBySql(sql);
    }

    @Override
    protected List<HangHoa> selectBySql(String sql, Object... args) {
        List<HangHoa> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    HangHoa entity=new HangHoa();
                    entity.setMaHH(rs.getString("MaHH"));
                    entity.setTenHH(rs.getString("TenHH"));
                    entity.setDVT(rs.getString("DVT"));
                    entity.setDonGia(rs.getInt("DonGia"));
                    entity.setGiaNhap(rs.getInt("GiaNhap"));
                    entity.setMoTa(rs.getString("MoTa"));
                    entity.setTenNCC(rs.getString("TenNCC"));
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
    
    public List<HangHoa> selectByTenNCC(String tenncc){
        String sql ="SELECT * from HangHoa WHERE TenNCC = ?";
        return this.selectBySql(sql, tenncc);
    }
}
    
