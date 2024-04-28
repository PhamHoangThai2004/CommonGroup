
package BiA.javamodel;


public class ModelSanPham {
    private int MaSP ;
    private String tenSP ;
    private double Gia ; 
    private int MaNCC ;
    private boolean trangThai ;

    public ModelSanPham(int id, String name, int value, boolean par) {
    }

    public ModelSanPham(int MaSP, String tenSP, double Gia, boolean trangThai) {
        this.MaSP = MaSP;
        this.tenSP = tenSP;
        this.Gia = Gia;
        this.trangThai = trangThai;
    }

    public ModelSanPham(int MaSP, String tenSP, double Gia, int MaNCC, boolean trangThai) {
        this.MaSP = MaSP;
        this.tenSP = tenSP;
        this.Gia = Gia;
        this.MaNCC = MaNCC;
        this.trangThai = trangThai;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ModelSanPham{" + "MaSP=" + MaSP + ", tenSP=" + tenSP + ", Gia=" + Gia + ", MaNCC=" + MaNCC + ", trangThai=" + trangThai + '}';
    }
    
    
}
