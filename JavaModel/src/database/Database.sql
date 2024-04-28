-- tạo bảng NguoiDung
create table NguoiDung(
    UserID int primary key not null,
    Email varchar(50) not null,
    Matkhau varchar(20) not null,
    Vaitro varchar(20) not null,
    VerifyCode varchar(20) not null
);

-- tạo bảng NhanVien
create table NhanVien(
    MaNV int primary key not null,
    TenNV varchar(50) not null,
    NgayVaoLam DATE ,
    SDT char(10) not null,
    Chucvu varchar(50),
    UserID int      
);

--Them khoa ngoai trong bảng NhanVien
ALTER TABLE NhanVien
    ADD CONSTRAINT NV_ND FOREIGN KEY (UserID) 
        REFERENCES NguoiDung(UserID);

-- Tạo bảng SanPham
create table SanPham(
    MaSP int primary key,
    TenSP varchar(50) not null, 
    Gia float,                
    TrangThai bit(1),
    MaNCC int
);

-- Thêm khóa ngoài trong bảng SanPham
ALter table SanPham
    Add CONSTRAINT SP_NCC FOREIGN KEY (MaNCC)
        REFERENCES NhaCungCap(MaNCC);

-- Tạo bảng KhachHang
create table KhachHang(
    MaKH int primary key ,
    TenKH varchar(50) not null,
    NgayThamGia date  not null,
    DoanhSo int not null,
    DiemTichLuy int not null,
    UserID int not null,
    MaLKH int not null
);

-- thêm khóa ngoài cho bảng KhachHang
ALter table KhachHang
    Add CONSTRAINT KH_ND FOREIGN KEY (UserID)
        REFERENCES NguoiDung(UserID),
    Add CONSTRAINT Kh_LKH FOREIGN KEY (MaLKH)
        REFERENCES LoaiKH(MaLKH);

-- Tạo bảng LoaiKH
create table LoaiKH(
    MaLKH int primary key not null
);


-- tạo bảng NhaCungCap
create table NhaCungCap(
    MaNCC int primary key,
    TenNCC varchar(50) not null,
    DiaChi varchar(50) not null,
    SDT char(10) not null,
    TG_HopTac date not null
);

-- Tạo bảng HoaDon
create table HoaDon(
    MaHD int primary key not null,
    NgayLapHD date not null,
    TrangThai bit(1) not null,
    Code_Voucher varchar(10),
    MaKH int not null,
    SoBan int
);

-- Thêm kháo ngoài bảng HoaDon
ALter table HoaDon
    Add CONSTRAINT HD_V FOREIGN KEY (Code_Voucher)
        REFERENCES Voucher(Code_Voucher),
    Add CONSTRAINT HD_KH FOREIGN KEY (MaKH)
        REFERENCES KhachHang(MaKH),
    Add CONSTRAINT HD_B FOREIGN KEY (SoBan)
        REFERENCES Ban(SoBan);

-- tạo bảng voucher
create table Voucher(
    Code_Voucher varchar(10) primary key not null,
    Mota varchar(50) not null,
    Phantram int,		
    SoLuong int,
    Diem int not null
);

-- Tạo khóa ngoài cho bảng Voucher
ALter table Voucher
    Add constraint V_PhanTram check (Phantram > 0 AND Phantram <= 100);

-- Tạo bảng Ban
create table Ban(
    SoBan int primary key not null,
    ViTri varchar(50) not null,
    TrangThai bit(1) not null
);

-- tạo bảng Đặt bàn
create table DatBan(
    SoBan int not null,
    MaKH int not null,
    GioBD datetime not null,
    GioKT datetime  not null 
);


-- Tạo khóa chính, khóa ngoài cho bảng DatBan
ALter table DatBan
    Add Constraint pk_DB PRIMARY KEY (SoBan, MaKH),
    Add CONSTRAINT DB_B FOREIGN KEY (SoBan)
        REFERENCES Ban(SoBan),
    Add CONSTRAINT DB_KH FOREIGN KEY (MaKH)
        REFERENCES KhachHang(MaKH);

-- Tạo bảng ChiTietHD
create table ChiTietHD(
    MaHD int  not null,
    MaSP int  not null,
    SoLuong int not null		
);

-- Tạo khóa chính, khóa ngoài cho bang CHiTietHD
Alter table ChiTietHD
    Add constraint pk_CTHD PRIMARY KEY (MaHD, MaSP),
    Add CONSTRAINT CTHD_HD FOREIGN KEY (MaHD)
        REFERENCES HoaDon(MaHD),
    Add CONSTRAINT CTHD_SP FOREIGN KEY (MaSP)
        REFERENCES SanPham(MaSP);

-- dữ liệu bảng người dùng
INSERT INTO NguoiDung (UserID, Email, Matkhau, Vaitro, VerifyCode)
VALUES (1,'admin@gmail.com','adminpassword','Admin','123456');
INSERT INTO NguoiDung (UserID, Email, Matkhau, Vaitro, VerifyCode)
VALUES (2,'user1@gmail.com','password1','staff','987654');
INSERT INTO NguoiDung (UserID, Email, Matkhau, Vaitro, VerifyCode)
VALUES (3,'user2@gmail.com','password2','staff','123545');
INSERT INTO NguoiDung (UserID, Email, Matkhau, Vaitro, VerifyCode)
VALUES (4,'user3@gmail.com','password3','Customer','632354');
INSERT INTO NguoiDung (UserID, Email, Matkhau, Vaitro, VerifyCode)
VALUES (5,'user4@gmail.com','password4','Customer','234632');
INSERT INTO NguoiDung (UserID, Email, Matkhau, Vaitro, VerifyCode)
VALUES (6,'user5@gmail.com','password5','Customer','357341');

-- dữ liệu nhân viên
INSERT INTO NhanVien (MaNV, TenNV, NgayVaoLam, SDT, Chucvu, UserID)
VALUES (001,'Nguyen Van A','2021-01-01','0123456789','Manager',1);
INSERT INTO NhanVien (MaNV, TenNV, NgayVaoLam, SDT, Chucvu, UserID)
VALUES (002,'Tran Thi B','2024-02-15','9876543210','Staff',2);
INSERT INTO NhanVien (MaNV, TenNV, NgayVaoLam, SDT, Chucvu, UserID)
VALUES (003,'Le Chi C','2023-05-20','1122334455','staff',3);

-- dữ liệu sản phẩm
INSERT INTO SanPham (MaSP, TenSP, Gia, TrangThai, MaNCC)
VALUES (1001,'pepsi',10000,1,101);
INSERT INTO SanPham (MaSP, TenSP, Gia, TrangThai, MaNCC)
VALUES (1002,'coca',10000,1,102);
INSERT INTO SanPham (MaSP, TenSP, Gia, TrangThai, MaNCC)
VALUES (1003,'com rang dua bo',70000,0,103);
INSERT INTO SanPham (MaSP, TenSP, Gia, TrangThai, MaNCC)
VALUES (1004,'mi tom 2 trung',30000,0,103);
INSERT INTO SanPham (MaSP, TenSP, Gia, TrangThai, MaNCC)
VALUES (1005,'pho bo',30000,0,103);

-- dữ liệu khách hàng
INSERT INTO KhachHang (MaKH, TenKH, NgayThamGia, DoanhSo, DiemTichLuy, UserID, MaLKH)
VALUES (01,'Nguyen Van M','2023-12-01',2000000,300,4,1);
INSERT INTO KhachHang (MaKH, TenKH, NgayThamGia, DoanhSo, DiemTichLuy, UserID, MaLKH)
VALUES (02,'Tran Thi N','2024-03-14',500000,160,5,2);
INSERT INTO KhachHang (MaKH, TenKH, NgayThamGia, DoanhSo, DiemTichLuy, UserID, MaLKH)
VALUES (03,'Le Chi O','2024-02-05',300000,90,6,3);

-- dữ liệu nhà cung cấp
INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SDT, TG_HopTac)
VALUES (101,'pepsi company','123 Main St','0123456789','2022-01-01');
INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SDT, TG_HopTac)
VALUES (102,'coca-cola company','456 Elm St','9876543210','2022-07-15');
INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SDT, TG_HopTac)
VALUES (103,'restaurant','789 Maple Ave','1122334455','2022-02-20');

-- dữ liệu hóa đơn 
INSERT INTO HoaDon (MaHD, NgayLapHD, TrangThai, Code_Voucher, MaKH, SoBan)
VALUES (100001,'2024-03-27',1,'GA3IH4',01,2);
INSERT INTO HoaDon (MaHD, NgayLapHD, TrangThai, Code_Voucher, MaKH, SoBan)
VALUES (100002,'2024-02-9',1,NULL,02,1);
INSERT INTO HoaDon (MaHD, NgayLapHD, TrangThai, Code_Voucher, MaKH, SoBan)
VALUES (100003,'2024-01-26',1,'DEF456',03,2);
INSERT INTO HoaDon (MaHD, NgayLapHD, TrangThai, Code_Voucher, MaKH, SoBan)
VALUES (100005,'2024-01-14',1,NULL,03,1);
INSERT INTO HoaDon (MaHD, NgayLapHD, TrangThai, Code_Voucher, MaKH, SoBan)
VALUES (100004,'2024-01-1',1,'XINCHAO',01,5);

-- nhập dữ liệu voucher
INSERT INTO Voucher (Code_Voucher, Mota, Phantram, SoLuong, Diem)
VALUES ('XINCHAO','giam gia 50%',50,20,20);
INSERT INTO HoaDon (Code_Voucher, Mota, Phantram, SoLuong, Diem)
VALUES ('GA3IH4','giam gia 20%',20,10,50);
INSERT INTO HoaDon (Code_Voucher, Mota, Phantram, SoLuong, Diem)
VALUES ('DEF456','nhan 1 phan qua toi da 200000',NULL,5,50);

-- dữ liệu bàn 
INSERT INTO Ban (SoBan, ViTri, TrangThai)
VALUES (1,'giua phong',0);
INSERT INTO Ban (SoBan, ViTri, TrangThai)
VALUES (2,'cuoi phong',1);
INSERT INTO Ban (SoBan, ViTri, TrangThai)
VALUES (3,'gan cua ra vao',1);

--dữ liệu dặt bàn 
INSERT INTO DatBan (SoBan, MaKH, GioBD, GioKT)
VALUES (2,01,'2024-04-28 18:00:00','2024-04-28 20:00:00'); 
INSERT INTO DatBan (SoBan, MaKH, GioBD, GioKT)
VALUES (3,02,'2024-04-29 12:00:00','2024-04-29 14:00:00');

--dữ liệu chi tiết hóa đơn
INSERT INTO ChiTietHD (MaHD, MaSP, SoLuong)
VALUES (100001,1001,2); 
INSERT INTO ChiTietHD (MaHD, MaSP, SoLuong)
VALUES (100002,1003,1);
INSERT INTO ChiTietHD (MaHD, MaSP, SoLuong)
VALUES (100003,1002,3);

-- dữ liệu loại khách hàng
INSERT INTO LoaiKH (MaLKH)
VALUES (1);









