
package javamodel;

import java.sql.Date;

public class ModelNhanVien {
    private int MaNV;
    private String tenNV;
    private Date ngayVaoLam;
    private String SDT;
    private String chucVu;
    private int userID ;

    public ModelNhanVien() {
    }

    public ModelNhanVien(int MaNV, String tenNV, Date ngayVaoLam, String SDT, String chucVu, int userID) {
        this.MaNV = MaNV;
        this.tenNV = tenNV;
        this.ngayVaoLam = ngayVaoLam;
        this.SDT = SDT;
        this.chucVu = chucVu;
        this.userID = userID;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "ModelNhanVien{" + "MaNV=" + MaNV + ", tenNV=" + tenNV + ", ngayVaoLam=" + ngayVaoLam + ", SDT=" + SDT + ", chucVu=" + chucVu + ", userID=" + userID + '}';
    }
    
    
}
