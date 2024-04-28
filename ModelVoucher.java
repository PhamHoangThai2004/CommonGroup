/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiA.javamodel;

/**
 *
 * @author Nguyen Quoc Trung
 */
 public class ModelVoucher {
    private  String Code_Voucher; 
    private String Mota;
    private int Phantram ;
    private int Soluong ;
    private int diem ;

    public ModelVoucher() {
    }

    public ModelVoucher(String Code_Voucher, String Mota, int Phantram, int Soluong, int diem) {
        this.Code_Voucher = Code_Voucher;
        this.Mota = Mota;
        this.Phantram = Phantram;
        this.Soluong = Soluong;
        this.diem = diem;
    }

    public String getCode_Voucher() {
        return Code_Voucher;
    }

    public void setCode_Voucher(String Code_Voucher) {
        this.Code_Voucher = Code_Voucher;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getPhantram() {
        return Phantram;
    }

    public void setPhantram(int Phantram) {
        this.Phantram = Phantram;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
    
}
