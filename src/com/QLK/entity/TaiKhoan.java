package com.QLK.entity;


public class TaiKhoan {
    private String TenDN;
    private String MatKhau;
    
    public TaiKhoan(){
        
    }

    public TaiKhoan(String TenDN, String MatKhau) {
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
    }

    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    
    
}
