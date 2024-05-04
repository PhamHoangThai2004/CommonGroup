/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiA.Controller.Service;

import BiA.Controller.Connection.DatabaseConnection;
import BiA.javamodel.ModelBan;
import BiA.javamodel.ModelChart;
import BiA.javamodel.ModelHoaDon;
import BiA.javamodel.ModelKhachHang;
import BiA.javamodel.ModelSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Nguyen Quoc Trung
 */
public class _SercviceAdmin {
    private final Connection connection ;

    public _SercviceAdmin() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }
    
// lấy dang sách hoán dơn theo ngay 
    public ArrayList<ModelHoaDon> getListHDIn(String txt) throws SQLException {
        ArrayList<ModelHoaDon> list = new ArrayList();
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon";
        if (txt.equals("Tất cả")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon";
        } else if (txt.equals("Hôm nay")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon "
                    + "WHERE TO_DATE(NgayHD,'dd-mm-YYYY')=TO_DATE(CURRENT_DATE,'dd-mm-YYYY')";
        } else if (txt.equals("Tháng này")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon "
                    + "WHERE EXTRACT(MONTH FROM NgayHD)=EXTRACT(MONTH FROM CURRENT_DATE) AND EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE)";
        } else if (txt.equals("Năm này")) {
            sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-YYYY') as Ngay,Tienmonan,Tiengiam,Tongtien FROM HoaDon "
                    + "WHERE EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE) ";
        }
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int MaHD = r.getInt(1);
            Date NgayLapHD = r.getDate(4);
            String Code_Voucher = r.getString(6);
            boolean trangThai = r.getBoolean(5);
            int MaKH = r.getInt(2);
            int SoBan = r.getInt(3);
            ModelHoaDon data = new ModelHoaDon(MaHD, NgayLapHD, Code_Voucher, trangThai, MaKH, SoBan);
            list.add(data);
        }
        p.close();
        r.close();
        return list;
    }
    //Lấy tổng doanh thu Hóa Đơn trong ngày/tháng/năm
    public int getRevenueHD(String filter) throws SQLException {
        int revenue = 0;
        
        String sql = "SELECT SUM(Tongtien) FROM HoaDon WHERE TO_DATE(NgayHD,'dd-mm-YYYY')=TO_DATE(CURRENT_DATE,'dd-mm-YYYY')";
        if(filter.equals("Hôm nay")){
            sql = "SELECT SUM(Tongtien) FROM HoaDon WHERE TO_DATE(NgayHD,'dd-mm-YYYY')=TO_DATE(CURRENT_DATE,'dd-mm-YYYY')";
        }else if(filter.equals("Tháng này")){
            sql = "SELECT SUM(Tongtien) FROM HoaDon WHERE EXTRACT(MONTH FROM NgayHD)=EXTRACT(MONTH FROM CURRENT_DATE) "
                    + "AND EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE)";
        }else if((filter.equals("Năm này"))){
            sql = "SELECT SUM(Tongtien) FROM HoaDon WHERE EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE)";
        }
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            revenue = r.getInt(1);
        }
        p.close();
        r.close();
        return revenue;
    }
    //Lấy tổng doanh thu Hóa Đơn của tháng trước
    public int getPreMonthRevenueHD() throws SQLException {
        int Pre_revenue = 0;  
        String sql =  "SELECT SUM(Tongtien) FROM HoaDon WHERE EXTRACT(MONTH FROM NgayHD)=(EXTRACT(MONTH FROM CURRENT_DATE)-1) "
                    + "AND EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE)";
        
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            Pre_revenue = r.getInt(1);
        }
        p.close();
        r.close();
        return Pre_revenue;
    } 
    //Lấy toàn bộ doanh thu, chi phí, lợi nhuận của từng tháng trong năm
    public ArrayList<ModelChart> getRevenueCostProfit_byMonth() throws SQLException{
        ArrayList<ModelChart> list=new ArrayList<>();
        String sql_Revenue="SELECT EXTRACT(MONTH FROM NgayHD) as Thang, SUM(TONGTIEN) FROM HoaDon WHERE EXTRACT(YEAR FROM NgayHD)=EXTRACT(YEAR FROM CURRENT_DATE) "
                + "GROUP BY EXTRACT(MONTH FROM NgayHD) ORDER BY Thang";
        String sql_Cost="SELECT EXTRACT(MONTH FROM NgayNK) as Thang, SUM(TONGTIEN) FROM PhieuNK WHERE EXTRACT(YEAR FROM NgayNK)=EXTRACT(YEAR FROM CURRENT_DATE) "
                + "GROUP BY EXTRACT(MONTH FROM NgayNK) ORDER BY Thang";
        PreparedStatement p_R = connection.prepareStatement(sql_Revenue);
        PreparedStatement p_C = connection.prepareStatement(sql_Cost);
        ResultSet r_R=p_R.executeQuery();
        ResultSet r_C=p_C.executeQuery();
        while(r_R.next() && r_C.next()){
            int revenue=r_R.getInt(2);
            int expenses=r_C.getInt(2);
            int profit=revenue-expenses;
            ModelChart data=new ModelChart("Tháng "+r_R.getInt(1), new double[]{revenue,expenses,profit});
            list.add(data);
        }
        return list;
    }
    //Lấy toàn bộ danh sách Món ăn theo loại Món Ăn
    public ArrayList<ModelSanPham> getMenuFood() throws SQLException {
        ArrayList<ModelSanPham> list = new ArrayList<>();
        String sql = "SELECT ID_MonAn,TenMon,DonGia,Loai,TrangThai FROM MonAn";
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt("ID_MonAn");
            String name = r.getString("TenMon");
            int value = r.getInt("DonGia");
            String type = r.getString("Loai");
            String state =r.getString("TrangThai");
            ModelSanPham data;
            if (id < 90) {
                data = new ModelSanPham(new ImageIcon(getClass().getResource("/Icons/Food/" + type + "/" + id + ".jpg")), id, name, value, type,state);
            } else {
                data = new ModelSanPham(new ImageIcon(getClass().getResource("/Icons/Food/Unknown/unknown.jpg")), id, name, value, type,state);
            }
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }
    //Lấy số lượng món ăn đang kinh doanh
    public int getNumberFood_inBusiness() throws SQLException{
        int number=0;
        String sql="SELECT COUNT(*) FROM MonAn WHERE TrangThai='Dang kinh doanh'";
        PreparedStatement p=connection.prepareStatement(sql);
        ResultSet r=p.executeQuery();
        if(r.next()){
            number=r.getInt(1);
        }
        return number;
    }
    //Lấy Mã Món Ăn tiếp theo được thêm
    public int getNextID_MA() throws SQLException {
        int id = 0;
        String sql = "SELECT MIN(ID_MonAn) +1 FROM MonAn WHERE ID_MonAn + 1 NOT IN (SELECT ID_MonAn FROM MonAn)";
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            id = r.getInt(1);
        }
        return id;
    }
    //Thêm mới một Món Ăn
    public void insertMA(ModelSanPham data) throws SQLException {
        String sql = "insert into MonAn(ID_MonAn,TenMon,Dongia,Loai,TrangThai) values(?,?, ?,?,'Dang kinh doanh')";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, data.getId());
        p.setString(2, data.getTitle());
        p.setInt(3, data.getValue());
        p.setString(4, data.getType());
        p.execute();
        p.close();
    }
    //Ngưng kinh doanh một món ăn (Cập nhật TrangThai='Ngung kinh doanh')
    public void StopSell(int idMA) throws SQLException {
        String sql = "UPDATE MonAn SET TrangThai = 'Ngung kinh doanh' WHERE ID_MonAn=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, idMA);
        p.execute();
        p.close();
    }
    //Kinh doanh trở lại một món ăn (Cập nhật TrangThai='Dang kinh doanh')
    public void BackSell(int idMA) throws SQLException {
        String sql = "UPDATE MonAn SET TrangThai = 'Dang kinh doanh' WHERE ID_MonAn=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, idMA);
        p.execute();
        p.close();
    }
    //Cập nhật thông tin của một Món ăn
    public void UpdateSP(ModelSanPham data) throws SQLException {
        String sql = "UPDATE MonAn SET TenMon=?,Dongia=?,Loai=? WHERE ID_MonAn=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, data.getTitle());
        p.setInt(2, data.getValue());
        p.setString(3, data.getType());
        p.setInt(4, data.getId());
        p.execute();
        p.close();
    }
    
    //Lấy toàn bộ danh sách Khách Hàng
    public ArrayList<ModelKhachHang> MenuKH() throws SQLException {
        ArrayList<ModelKhachHang> list = new ArrayList<>();
        String sql = "SELECT ID_KH, TenKH, to_char(Ngaythamgia,'dd-mm-yyyy') AS Ngay, Doanhso, Diemtichluy FROM KhachHang";
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int ID_KH = r.getInt(1);
            String name = r.getString(2);
            String dateJoin = r.getString(3);
            int sales = r.getInt(4);
            int points = r.getInt(5);
            ModelKhachHang data = new ModelKhachHang(ID_KH, name, dateJoin, sales, points);
            list.add(data);
        }
        r.close();
        p.close();
        return list;
    }

    //Điều chỉnh trạng thái bàn thành Đã đặt trước sau khi nhân viên xác nhận
    public void setTableReserve(int idBan) throws SQLException {
        String sql = "UPDATE BAN SET TrangThai = 'Da dat truoc' WHERE ID_Ban=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, idBan);
        p.execute();
        p.close();
    }

    //Hủy trạng thái bàn đã Đặt trước trước thành Còn trống
    public void CancelTableReserve(int idBan) throws SQLException {
        String sql = "UPDATE BAN SET TrangThai = 'Con trong' WHERE ID_Ban=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, idBan);
        p.execute();
        p.close();
    }

    //Tìm hóa đơn có trạng thái Chưa thanh toán  dựa vào trạng mã Bàn
    public ModelHoaDon FindHoaDonbyID_Ban(ModelBan table) throws SQLException {
        ModelHoaDon hoadon = null;
        String sql = "SELECT ID_HoaDon,ID_KH,ID_Ban,to_char(NgayHD,'dd-mm-yyyy') AS Ngay,TienMonAn,Code_Voucher,TienGiam,Tongtien,Trangthai FROM HoaDon "
                + "WHERE ID_Ban=? AND Trangthai='Chua thanh toan'";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, table.getID());
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int idHoaDon = r.getInt(1);
            int idKH = r.getInt(2);
            int idBan = r.getInt(3);
            String ngayHD = r.getString(4);
            int tienMonAn = r.getInt(5);
            String code_voucher = r.getString(6);
            int tienGiam = r.getInt(7);
            int tongtien = r.getInt(8);
            String trangthai = r.getString(9);
            hoadon = new ModelHoaDon(idHoaDon, idKH, idBan, ngayHD, tienMonAn, code_voucher, tienGiam, tongtien, trangthai);
        }
        r.close();
        p.close();
        return hoadon;
    }

    //Cập nhật trạng thái Hóa đơn thành Đã thanh toán khi Nhân viên xác nhận thanh toán
    public void UpdateHoaDonStatus(int idHD) throws SQLException {
        String sql = "UPDATE HoaDon SET TrangThai = 'Da thanh toan' WHERE ID_HoaDon=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, idHD);
        p.execute();
        p.close();
    }

    //Lấy tên khách hàng từ Mã KH
    public String getTenKH(int idKH) throws SQLException {
        String name = "";
        String sql = "SELECT TenKH From KhachHang WHERE ID_KH=?";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setInt(1, idKH);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            name = r.getString(1);
        }
        p.close();
        r.close();
        return name;
    }
}
