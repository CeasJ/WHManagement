package com.QLK.dao;

import com.QLK.entity.TaiKhoan;
import com.QLK.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO extends QLKDAO<TaiKhoan, String> {
	
	public boolean changePassword(String user, String oldPass, String newPass, String confirmPass) {
	    if (oldPass == null || oldPass.trim().isEmpty() || newPass == null || newPass.trim().isEmpty()
	            || confirmPass == null || confirmPass.trim().isEmpty()) {
	        return false; 
	    } else if (!newPass.equals(confirmPass)) {
	        return false;
	    } else {
	        TaiKhoanDAO tdao = new TaiKhoanDAO();
	        TaiKhoan taiKhoan = tdao.selectById(user);
	        if (taiKhoan != null && taiKhoan.getMatKhau().equals(oldPass)) {
	            taiKhoan.setMatKhau(newPass);
	            tdao.update(taiKhoan);
	            return true; 
	        } else {
	            return false;
	        }
	    }
	}


    @Override
    public void insert(TaiKhoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TaiKhoan entity) {
        String sql="UPDATE TaiKhoan SET MatKhau=? WHERE TenDN=?";
        XJdbc.update(sql,  
                entity.getMatKhau(), 
                entity.getTenDN());
 
    }
    
 

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoan selectById(String tendn) {
        String sql="SELECT * FROM TaiKhoan WHERE TenDN=?";
        List<TaiKhoan> list = this.selectBySql(sql, tendn);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<TaiKhoan> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
         List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    TaiKhoan entity=new TaiKhoan();
                    entity.setTenDN(rs.getString("TenDN"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    list.add(entity);
                }
            } 
            finally{
                if(rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public boolean checkLogin(String tenDN, String matKhau) {
        if (tenDN == null || tenDN.trim().isEmpty() || matKhau == null || matKhau.trim().isEmpty()) {
            return false;
        } else {
            String sql = "SELECT * FROM TaiKhoan WHERE TenDN=? AND MatKhau=?";
            List<TaiKhoan> list = this.selectBySql(sql, tenDN, matKhau);
            return !list.isEmpty();
        }
    }

}
    
