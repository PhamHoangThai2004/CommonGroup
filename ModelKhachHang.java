
package BiA.javamodel;

import java.sql.Date;
        
public class ModelKhachHang {
      private int MaKH ;
      private String tenKH ;
      private Date ngayThamGia ;
      private int doanhSo ;
      private int diemTichLuy;
      private int userID ;
      private int loaiKhachHang ;

    public ModelKhachHang() {
    }

    
    
    public ModelKhachHang(int MaKH, String tenKH, Date ngayThamGia, int doanhSo, int diemTichLuy, int userID, int loaiKhachHang) {
        this.MaKH = MaKH;
        this.tenKH = tenKH;
        this.ngayThamGia = ngayThamGia;
        this.doanhSo = doanhSo;
        this.diemTichLuy = diemTichLuy;
        this.userID = userID;
        this.loaiKhachHang = loaiKhachHang;
    }

    public ModelKhachHang(int MaKH, String tenKH, Date ngayThamGia, int doanhSo, int diemTichLuy, int userID) {
        this.MaKH = MaKH;
        this.tenKH = tenKH;
        this.ngayThamGia = ngayThamGia;
        this.doanhSo = doanhSo;
        this.diemTichLuy = diemTichLuy;
        this.userID = userID;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    public int getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(int doanhSo) {
        this.doanhSo = doanhSo;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(int loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    @Override
    public String toString() {
        return "ModelKhachHang{" + "MaKH=" + MaKH + ", tenKH=" + tenKH + ", ngayThamGia=" + ngayThamGia + ", doanhSo=" + doanhSo + ", diemTichLuy=" + diemTichLuy + ", userID=" + userID + ", loaiKhachHang=" + loaiKhachHang + '}';
    }

    
    
}
