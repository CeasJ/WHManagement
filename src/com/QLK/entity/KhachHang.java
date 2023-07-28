package com.QLK.entity;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String sDT;
    private String mST;
    private String email;
    private String diaChi;
    
    public KhachHang(){
        
    }

    public KhachHang(String maKH, String tenKH, String sDT, String mST, String email, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sDT = sDT;
        this.mST = mST;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getmST() {
        return mST;
    }

    public void setmST(String mST) {
        this.mST = mST;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
