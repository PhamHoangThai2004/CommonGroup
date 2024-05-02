
package BiA.javamodel;

import java.sql.Date;

public class ModelHoaDon {
    private int MaHD ;
    private Date NgayLapHD ;
    private String Code_Voucher;
    private boolean trangThai;
    private int MaKH ;
    private int SoBan;

    public ModelHoaDon() {
    }

    public ModelHoaDon(int MaHD, Date NgayLapHD, String Code_Voucher, boolean trangThai, int MaKH, int SoBan) {
        this.MaHD = MaHD;
        this.NgayLapHD = NgayLapHD;
        this.Code_Voucher = Code_Voucher;
        this.trangThai = trangThai;
        this.MaKH = MaKH;
        this.SoBan = SoBan;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(Date NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }

    public String getCode_Voucher() {
        return Code_Voucher;
    }

    public void setCode_Voucher(String Code_Voucher) {
        this.Code_Voucher = Code_Voucher;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getSoBan() {
        return SoBan;
    }

    public void setSoBan(int SoBan) {
        this.SoBan = SoBan;
    }

    @Override
    public String toString() {
        return "ModelHoaDon{" + "MaHD=" + MaHD + ", NgayLapHD=" + NgayLapHD + ", Code_Voucher=" + Code_Voucher + ", trangThai=" + trangThai + ", MaKH=" + MaKH + ", SoBan=" + SoBan + '}';
    }
    
}
