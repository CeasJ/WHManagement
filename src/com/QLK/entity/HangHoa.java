package com.QLK.entity;

public class HangHoa {
    private String maHH;
    private String tenHH;
    private String DVT;
    private int donGia;
    private int giaNhap;
    private String moTa;
    private String tenNCC;

    public HangHoa(){
        
    }

    public HangHoa(String maHH, String tenHH, String DVT, int donGia, int giaNhap, String moTa, String tenNCC) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.DVT = DVT;
        this.donGia = donGia;
        this.giaNhap = giaNhap;
        this.moTa = moTa;
        this.tenNCC = tenNCC;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
    
    @Override
    public String toString() {
        return this.tenNCC;
    }

    @Override
    public boolean equals(Object obj) {
        HangHoa other = (HangHoa) obj;
        return other.getTenNCC().equals(this.getTenNCC());
    }
}
