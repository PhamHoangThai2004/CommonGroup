
package BiA.javamodel;


public class ModelLoaiKhachHang {
    private int MaLKH ; 

    public ModelLoaiKhachHang() {
    }

    public ModelLoaiKhachHang(int MaLKH) {
        this.MaLKH = MaLKH;
    }

    public int getMaLKH() {
        return MaLKH;
    }

    public void setMaLKH(int MaLKH) {
        this.MaLKH = MaLKH;
    }

    @Override
    public String toString() {
        return "ModelLoaiKhachHang{" + "MaLKH=" + MaLKH + '}';
    }
    
    
}
