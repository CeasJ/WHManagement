package com.QLK.entity;

import java.util.Date;
import com.QLK.entity.DonVi;

public class TonKho {
    private String barcode;
    private String tenDV;
    private String maHH;
    private String tenHH;
    private String dVT;
    private int sLNhap;
    private int sLXuat;
    private int tonKho;
    private int donGia;
    private int thanhTien;
    private Date ngayCapNhat = new Date();
    
    public TonKho(){
        
    }

    public TonKho(String barcode, String tenDV, String maHH, String tenHH, String dVT, int sLNhap, int sLXuat, int tonKho, int donGia, int thanhTien) {
        this.barcode = barcode;
        this.tenDV = tenDV;
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.dVT = dVT;
        this.sLNhap = sLNhap;
        this.sLXuat = sLXuat;
        this.tonKho = tonKho;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
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

    public String getdVT() {
        return dVT;
    }

    public void setdVT(String dVT) {
        this.dVT = dVT;
    }

    public int getsLNhap() {
        return sLNhap;
    }

    public void setsLNhap(int sLNhap) {
        this.sLNhap = sLNhap;
    }

    public int getsLXuat() {
        return sLXuat;
    }

    public void setsLXuat(int sLXuat) {
        this.sLXuat = sLXuat;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Override
    public String toString() {
        return this.tenDV;
    }
   
}
