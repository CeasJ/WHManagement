package com.QLK.entity;

public class NhaCungCap {
    private String MaNCC;
    private String tennhacc;
    private String dienThoai;
    private String email;
    private String diaChi;
    
    

    public NhaCungCap() {
		super();
	}

	public NhaCungCap(String maNCC, String tennhacc, String dienThoai, String email, String diaChi) {
		super();
		MaNCC = maNCC;
		this.tennhacc = tennhacc;
		this.dienThoai = dienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}

	@Override
    public String toString() {
        return this.tennhacc ;
    }  

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTennhacc() {
        return tennhacc;
    }

    public void setTennhacc(String tennhacc) {
        this.tennhacc = tennhacc;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
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
