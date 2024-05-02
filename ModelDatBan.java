
package BiA.javamodel;

import java.sql.Date;

public class ModelDatBan {
    private int SoBan ;
    private int MaKH ;
    private Date GioBatDau ;
    private Date GioKetThuc ;
    
    
    public ModelDatBan() {
    }

    public ModelDatBan(int SoBan, int MaKH, Date GioBatDau, Date GioKetThuc) {
        this.SoBan = SoBan;
        this.MaKH = MaKH;
        this.GioBatDau = GioBatDau;
        this.GioKetThuc = GioKetThuc;
    }

    public int getSoBan() {
        return SoBan;
    }

    public void setSoBan(int SoBan) {
        this.SoBan = SoBan;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public Date getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(Date GioBatDau) {
        this.GioBatDau = GioBatDau;
    }

    public Date getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(Date GioKetThuc) {
        this.GioKetThuc = GioKetThuc;
    }

    @Override
    public String toString() {
        return "ModelDatBan{" + "SoBan=" + SoBan + ", MaKH=" + MaKH + ", GioBatDau=" + GioBatDau + ", GioKetThuc=" + GioKetThuc + '}';
    }

    
    
    
}
