
package BiA.javamodel;


public class ModelNguoiDung {
    private int userID;
    private String email;
    private String password;
    private String vaiTro ;
    private String verifyCode;
    private  String role; //Vai trò : Khách Hàng, Nhân Viên,Nhân viên Kho,Quản lý

    public ModelNguoiDung() {
    }

    public ModelNguoiDung(int userID, String email, String password, String vaiTro, String verifyCode, String role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.vaiTro = vaiTro;
        this.verifyCode = verifyCode;
        this.role = role;
    }
    
    public ModelNguoiDung(int userID, String email, String password,String role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.role=role;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ModelNguoiDung{" + "userID=" + userID + ", email=" + email + ", password=" + password + ", vaiTro=" + vaiTro + ", verifyCode=" + verifyCode + ", role=" + role + '}';
    }
    

    

    
}
