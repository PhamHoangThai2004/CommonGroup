
package javamodel;

import java.sql.Date;

public class ModelNhaCungCap {
    private int MaNCC ;
    private String tenNCC ;
    private String diaChi ;
    private String sdt;
    private Date thoiGianHopTac; 

    public ModelNhaCungCap() {
    }

    public ModelNhaCungCap(int MaNCC, String tenNCC, String diaChi, String sdt, Date thoiGianHopTac) {
        this.MaNCC = MaNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.thoiGianHopTac = thoiGianHopTac;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getThoiGianHopTac() {
        return thoiGianHopTac;
    }

    public void setThoiGianHopTac(Date thoiGianHopTac) {
        this.thoiGianHopTac = thoiGianHopTac;
    }

    @Override
    public String toString() {
        return "ModelNhaCungCap{" + "MaNCC=" + MaNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", sdt=" + sdt + ", thoiGianHopTac=" + thoiGianHopTac + '}';
    }

    
}
