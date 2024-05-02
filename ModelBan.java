
package BiA.javamodel;

public class ModelBan {
    private int SoBan ;
    private String ViTri ;
    private boolean trangThai ;

   

    public ModelBan(int SoBan, String ViTri, boolean trangThai) {
        this.SoBan = SoBan;
        this.ViTri = ViTri;
        this.trangThai = trangThai;
    }

    public int getSoBan() {
        return SoBan;
    }

    public void setSoBan(int SoBan) {
        this.SoBan = SoBan;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ModelBan{" + "SoBan=" + SoBan + ", ViTri=" + ViTri + ", trangThai=" + trangThai + '}';
    }   
}
