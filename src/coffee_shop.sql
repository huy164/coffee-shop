/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     5/15/2020 3:42:56 PM                         */
/*==============================================================*/
/*==============================================================*/
/* Table: BAN                                                   */
/*==============================================================*/
CREATE SEQUENCE MABAN_SEQ 
INCREMENT BY 1
START WITH 1;

CREATE TABLE BAN (
   MABAN                NUMERIC(2)          DEFAULT MABAN_SEQ.NEXTVAL NOT NULL,
   KHUVUC               NVARCHAR2(50)            NOT NULL,
   SOGHE                INT                      NOT NULL ,
   TRANGTHAI            NVARCHAR2(10)            NOT NULL ,
   CONSTRAINT PK_BAN PRIMARY KEY (MABAN)
);

  /*==============================================================*/
  /* Table: NCC                                                   */
  /*==============================================================*/
CREATE SEQUENCE MANCC_SEQ 
INCREMENT BY 1
START WITH 1;
 
CREATE TABLE NCC (
   MANCC                NUMERIC(6)           DEFAULT MANCC_SEQ.NEXTVAL NOT NULL,
   TENNCC               NVARCHAR2(50)             NOT NULL,
   DIACHI               NVARCHAR2(100)            NOT NULL,
   SDT                  NVARCHAR2(15)          NOT NULL UNIQUE,
   CONSTRAiNT PK_NCC PRIMARY KEY (MANCC)
);


  /*==============================================================*/
  /* Table: HANGHOA                                               */
  /*==============================================================*/
CREATE SEQUENCE MAHANG_SEQ 
INCREMENT BY 1
START WITH 1;
CREATE TABLE HANGHOA (
   MAHANG               NUMERIC(6)           DEFAULT MAHANG_SEQ.NEXTVAL NOT NULL,
   MANCC                NUMERIC(6)           NOT NULL,
   TENHANG              NVARCHAR2(50)        NOT NULL,
   DONVI                NVARCHAR2(10)        NOT NULL,
   SL                   NUMERIC(4)           NOT NULL CHECK (SL > 0),
   DONGIA               NUMBER(9, 2)         NOT NULL,
   THANHTIEN            NUMBER(9, 2)         NOT NULL,
   CONSTRAINT PK_HANGHOA PRIMARY KEY (MAHANG)
);

ALTER TABLE HANGHOA 
ADD CONSTRAINT FK_HANGHOA_NCC FOREIGN KEY (MANCC) REFERENCES NCC (MANCC) ON DELETE CASCADE;

  /*==============================================================*/
  /* Table: KHACHHANG                                             */
  /*==============================================================*/
  
CREATE SEQUENCE MAKH_SEQ 
INCREMENT BY 1
START WITH 1;

CREATE TABLE KHACHHANG (
   MAKH                 NUMERIC(6)           DEFAULT MAKH_SEQ.NEXTVAL NOT NULL,
   TENKH                NVARCHAR2(40)        NOT NULL,
   GIOITINH             NVARCHAR2(3)         NOT NULL ,
   SDT                  NVARCHAR2(15)        NOT NULL UNIQUE,
   DIEMTL               INT                  NOT NULL,
   CONSTRAINT PK_KHACHHANG PRIMARY KEY (MAKH)
);



  /*==============================================================*/
  /* Table: NGUYENLIEU                                            */
  /*==============================================================*/
CREATE SEQUENCE MANL_SEQ 
INCREMENT BY 1
START WITH 1; 

CREATE TABLE NGUYENLIEU (
   MANL                 NUMERIC(3)           DEFAULT MANL_SEQ.NEXTVAL NOT NULL,
   TENNL                NVARCHAR2(50)        NOT NULL,
   HSD                  DATE                 NOT NULL,
   SLCON                FLOAT                NOT NULL,
   CONGDUNG             NVARCHAR2(100)       NOT NULL,
   CONSTRAINT PK_NGUYENLIEU PRIMARY KEY (MANL)
);


  /*==============================================================*/
  /* Table: MON                                                   */
  /*==============================================================*/
CREATE SEQUENCE MAMON_SEQ 
INCREMENT BY 1
START WITH 1;

CREATE TABLE MON (
   MAMON                NUMERIC(4)           DEFAULT MAMON_SEQ.NEXTVAL NOT NULL,
   MANL                 NUMERIC(3)           NOT NULL,
   SOLUONGNL		FLOAT		     NOT NULL,
   TENMON               NVARCHAR2(100)       NOT NULL,
   GIA                  NUMBER(9, 2)         NOT NULL CHECK (GIA > 0),
   CONSTRAINT PK_MON PRIMARY KEY (MAMON)
);

ALTER TABLE MON 
ADD CONSTRAINT FK_MON_NGUYENLIEU FOREIGN KEY (MANL) REFERENCES NGUYENLIEU (MANL) ON DELETE CASCADE;




  /*==============================================================*/
  /* Table: TAIKHOAN                                              */
  /*==============================================================*/
  CREATE TABLE TAIKHOAN (
   TENTK                NVARCHAR2(30)             NOT NULL,
   MK                   NVARCHAR2(20)             NOT NULL,
   ROLE                 NUMBER(1)                 NOT NULL CHECK (ROLE IN (1, 0)), --1: CHU QUAN, 0: NV THU NGAN
   TRANGTHAI            NVARCHAR2(100)            NOT NULL,
   CONSTRAiNT PK_TAIKHOAN PRIMARY KEY (TENTK)
);


  /*==============================================================*/
  /* Table: NHANVIEN                                              */
  /*==============================================================*/
CREATE SEQUENCE MANV_SEQ 
INCREMENT BY 1
START WITH 1; 
CREATE TABLE NHANVIEN (
   MANV                 NUMERIC(8)           DEFAULT MANV_SEQ.NEXTVAL NOT NULL,
   TENTK                NVARCHAR2(30)        NOT NULL,
   HOTEN                NVARCHAR2(40)        NOT NULL,
   CMND                 NVARCHAR2(15)        NOT NULL,
   NGAYSINH             DATE                 NOT NULL,
   DIACHI               NVARCHAR2(50)        NOT NULL,
   GIOITINH             NVARCHAR2(3)         NOT NULL ,
   SDT                  NVARCHAR2(15)        NOT NULL,
   MUCLUONG             NUMBER(12)           NOT NULL,
   NVL                  DATE                 NOT NULL,
   CONSTRAINT PK_NHANVIEN PRIMARY KEY (MANV)
);
ALTER TABLE NHANVIEN 
ADD CONSTRAINT FK_NHANVIEN_TAIKHOAN FOREIGN KEY (TENTK) REFERENCES TAIKHOAN (TENTK) ON DELETE CASCADE;

  /*==============================================================*/
  /* Table: CHI_TIET_NHAP                                           */
  /*==============================================================*/
CREATE SEQUENCE MACTN_SEQ 
INCREMENT BY 1 
START WITH 1;
CREATE TABLE CHI_TIET_NHAP
(
    MACTN   NUMBER(5)  DEFAULT MACTN_SEQ.NEXTVAL NOT NULL, 
    MAHANG   NUMERIC(6) NOT NULL,
    MANV     NUMERIC(8) NOT NULL,
    NGAYNHAP DATE NOT NULL,
    SOLUONGNHAP NUMBER(5),
    CONSTRAINT PK_CHI_TIET_NHAP PRIMARY KEY (MACTN,MAHANG,MANV)
);
ALTER TABLE CHI_TIET_NHAP 
ADD CONSTRAINT FK_CHITIETNHAP_HANGHOA FOREIGN KEY (MAHANG) REFERENCES HANGHOA(MAHANG);
ALTER TABLE CHI_TIET_NHAP 
ADD CONSTRAINT FK_CHITIETNHAP_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN (MANV);

  /*==============================================================*/
  /* Table: HOADON                                                */
  /*==============================================================*/
CREATE SEQUENCE MAHD_SEQ INCREMENT BY 1 START WITH 1;
CREATE TABLE HOADON
(
    MAHD      NUMERIC(6) DEFAULT MAHD_SEQ.nextval NOT NULL,
    MANV      NUMERIC(8) NOT NULL,
    MAKH      NUMERIC(6) NOT NULL,
    NGAYLAP   DATE NOT NULL,
    THANHTIEN NUMBER(12, 3) ,
    GIAMGIA   INT NOT NULL CHECK (GIAMGIA <= 10),
    TRANGTHAI NVARCHAR2(20) ,
    CONSTRAINT PK_HOADON PRIMARY KEY (MAHD)
);

ALTER TABLE HOADON 
ADD CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN (MANV) ON DELETE CASCADE;
ALTER TABLE HOADON 
ADD CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (MAKH) REFERENCES KHACHHANG (MAKH) ON DELETE CASCADE;


  /*==============================================================*/
  /* Table: CTHD                                                  */
  /*==============================================================*/
CREATE TABLE CTHD (
   MAKH                 NUMERIC(6)           NOT NULL,
   MABAN                NUMERIC(2)           NOT NULL,
   MAMON                NUMERIC(4)           NOT NULL,
   MAHD                 NUMERIC(6)           NOT NULL,
   SL                   INT                  NOT NULL,
   CONSTRAINT PK_CTHD PRIMARY KEY (MAKH, MABAN, MAMON, MAHD)
);
ALTER TABLE CTHD 
ADD CONSTRAINT FK_CTHD_KHACHHANG FOREIGN KEY (MAKH) REFERENCES KHACHHANG (MAKH);
ALTER TABLE CTHD 
ADD CONSTRAINT FK_CTHD_BAN FOREIGN KEY (MABAN) REFERENCES BAN (MABAN);
ALTER TABLE CTHD 
ADD CONSTRAINT FK_CTHD_MON FOREIGN KEY (MAMON) REFERENCES MON (MAMON);
ALTER TABLE CTHD 
ADD CONSTRAINT FK_CTHD_HOADON FOREIGN KEY (MAHD) REFERENCES HOADON (MAHD) ON DELETE CASCADE;


  /*==============================================================*/
  /* Table: QUANLY                                                */
  /*==============================================================*/
CREATE TABLE QUANLY (
   MANV                 NUMERIC(8)           NOT NULL,
   MABAN                NUMERIC(2)           NOT NULL,
   MANL                 NUMERIC(3)           NOT NULL,
   MANV_QL              NUMERIC(8)           NOT NULL,
   CONSTRAINT PK_QUANLY PRIMARY KEY (MANV, MABAN, MANL, MANV_QL)
);
ALTER TABLE QUANLY 
ADD CONSTRAINT FK_QUANLY_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN (MANV) ON DELETE CASCADE;
ALTER TABLE QUANLY 
ADD CONSTRAINT FK_QUANLY_BAN FOREIGN KEY (MABAN) REFERENCES BAN (MABAN) ON DELETE CASCADE;
ALTER TABLE QUANLY 
ADD CONSTRAINT FK_QUANLY_NGUYENLIEU FOREIGN KEY (MANL) REFERENCES NGUYENLIEU (MANL) ON DELETE CASCADE;



---INSERT BAN--
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 8, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG TR?T', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 8, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'T?NG 1', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 8, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 8, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 6, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 4, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 2, 'Tr?ng');
INSERT INTO BAN VALUES (MABAN_SEQ.nextval, 'NGOÀI TR?I', 2, 'Tr?ng');

--INSERT NCC---
INSERT INTO NCC VALUES (MANCC_SEQ.nextval, 'CTY CAFE TRUNG NGUYÊN', 'Bình ??nh', '09253626526');
INSERT INTO NCC VALUES (MANCC_SEQ.nextval, 'SON VI?T COFFEE', 'Bình ??nh', '03637476376');
INSERT INTO NCC VALUES (MANCC_SEQ.nextval, 'CTY TNHH TÁM CHÂU', 'Bình ??nh', '09287652655');
INSERT INTO NCC VALUES (MANCC_SEQ.nextval, 'CTY TRÀ PHÚ S?', 'Bình ??nh', '09532536542');
INSERT INTO NCC VALUES (MANCC_SEQ.nextval, 'CÀ PHÊ NGON', 'Bình ??nh', '03323626552');
select*from hanghoa
--INSERT HANGHOA--
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 1,'Cafe Trung Nguyên','Kg', 10, 85000, 850000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 2,'Cafe Espresso', 'Kg', 10, 120000, 1200000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 2,'Cafe Long Black', 'Kg', 5, 75000, 375000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 2,'Cafe Latte', 'Kg', 5, 90000, 450000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 3, 'Doppio', 'Kg', 5, 100000, 500000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 3, 'Coconut', 'Hop', 5, 80000, 400000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 3, 'Chocolate', 'Kg', 5, 250000, 1250000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 3, 'S?a chua', 'Loc', 25, 34000, 850000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 2, 'Cafe Son Vi?t', 'Kg', 3, 125000, 375000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 4, 'Trà Atiso', 'Kg', 3, 120000, 360000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 4, 'Trà Phú s?', 'Kg', 4, 70000, 280000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 2, 'Matcha', 'Kg', 2, 185000, 370000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 5, 'S?a', 'Lon', 15, 18000, 270000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 3, 'Cafe Ngon', 'Kg',7, 210000, 1470000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 4, 'H?ng Trà', 'Kg', 3, 120000, 360000);
INSERT INTO HANGHOA VALUES (MAHANG_SEQ.nextval, 5, 'Cacao', 'Kg', 5, 175000, 875000);



--INSERT KHACHHANG--
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Tu?n', 'Nam', '09857372736', 1);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Nam', 'Nam', '09233673567', 1);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Loan', 'N?', '09636474837', 1);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Ph??ng', 'N?', '03345252555', 1);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Phong', 'Nam', '03685885876', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Chú Toàn', 'Nam', '09835453532', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Cô Út', 'N?', '09534363673', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Cô Bính', 'N?', '09636344882', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Thu?n', 'Nam', '09434637752', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Hi?n', 'N?', '09847846856', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Chung', 'Nam', '09474745883', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Linh', 'N?', '09225326365', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Cô Ngân', 'N?', '09658684873', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C H?nh', 'N?', '09363734743', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Quy?n', 'Nam', '03536774472', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Chú Tu?n', 'Nam', '03674546474', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Cô Th?m', 'N?', '09457886474', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A H?i', 'Nam', '03563746884', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Giang', 'N?', '09235263655', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Chú Thanh', 'Nam', '03364773473', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A H?u', 'Nam', '09626656277', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Tâm', 'N?', '09836673525', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Phúc', 'Nam', '09536364632', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Trang', 'N?', '09253626465', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Minh', 'Nam', '09463635232', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Chú Th?ng', 'Nam', '09324626275', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Chú Trung', 'Nam', '09823253634', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'Cô Hoa', 'N?', '09462472654', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Tám', 'N?', '09547546373', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Tu?n', 'Nam', '09436756373', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Phong', 'Nam', '09857374743', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'A Tr??ng', 'Nam', '09834737336', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Ph??ng', 'N?', '09474858737', 0);
INSERT INTO KHACHHANG VALUES (MAKH_SEQ.nextval, 'C Hòa', 'N?', '03644874677', 0);


--INSERT NGUYENLIEU--
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval,'Cafe Trung Nguyên', TO_DATE('12/03/2021','dd/mm/yyyy'), 10, 'Pha các lo?i cà phê');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Cafe Espresso', TO_DATE('12/04/2021','dd/mm/yyyy'), 5, 'Pha Cafe Espresso');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Cafe Long Black', TO_DATE('02/03/2021','dd/mm/yyyy'), 5, 'Pha Cafe Long Black');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Cafe Latte', TO_DATE('12/04/2021','dd/mm/yyyy'), 5, 'Pha cafe Latte');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Doppio', TO_DATE('11/05/2021','dd/mm/yyyy'), 5, 'Pha Doppio');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Coconut', TO_DATE('12/03/2021','dd/mm/yyyy'), 5, 'Pha Cooconut Coffe');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Chocolate', TO_DATE('05/05/2021','dd/mm/yyyy'), 25, 'Pha Chocolate');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'S?a Chua', TO_DATE('12/03/2021','dd/mm/yyyy'), 3, 'Làm s?a chua ?á');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Cafe Son Vi?t', TO_DATE('12/03/2021','dd/mm/yyyy'), 3, 'Pha các lo?i cà phê');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Trà Atiso', TO_DATE('12/03/2021','dd/mm/yyyy'), 4, 'Pha Trà Trái Cây');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Trà Phú S?', TO_DATE('12/03/2021','dd/mm/yyyy'), 10, 'Pha Trà');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Matcha', TO_DATE('12/03/2021','dd/mm/yyyy'), 2, 'Pha Matcha Late');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'S?a', TO_DATE('02/05/2021','dd/mm/yyyy'), 15, 'Pha Cafe S?a');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Cafe Ngon', TO_DATE('07/04/2021','dd/mm/yyyy'), 7, 'Pha Cafe ?en');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'H?ng Trà', TO_DATE('08/03/2021','dd/mm/yyyy'), 3, 'Pha H?ng Trà');
INSERT INTO NGUYENLIEU VALUES (MANL_SEQ.nextval, 'Cacao', TO_DATE('12/05/2021','dd/mm/yyyy'), 3, 'Pha Cacao');


--INSERT MON--
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '1' ,'0.1','Cafe Espresso', 39000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '2' ,'0.1','Cafe Long Black', 39000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '3' ,'0.1','Cafe Latte', 52000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '4' ,'0.1','Doppio', 59000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '8' ,'0.1','Cappuccino', 49000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '14' ,'0.1','Flat White', 52000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '14' ,'0.1','Mocha Latte', 52000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '8' ,'0.1','Affogato', 52000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '5' ,'0.1','Coconut Cafe', 42000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '12' ,'0.1','Matcha Latte', 42000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '6' ,'0.1','Chocolate', 45000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '11' ,'0.1','Cafe ?en', 25000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '11' ,'0.1','Cafe S?a', 30000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '14' ,'0.1','Cafe Tr?ng', 45000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '11' ,'0.1','B?c X?u', 30000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '16' ,'0.1','Cacao', 30000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '10' ,'0.1','H?ng Trà', 30000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '10' ,'0.1','Trà Hoa Qu?', 25000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '9' ,'0.1','Trà ?ào', 20000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '9' ,'0.1','Trà Táo B?c Hà', 30000);
INSERT INTO MON VALUES (MAMON_SEQ.nextval, '7' ,'0.1','S?a Chua ?á', 25000);
insert into MON values (MAMON_SEQ.nextval,'1','cafe s?a','39000', '0.1')


--INSERT TAIKHOAN--
INSERT INTO TAIKHOAN VALUES ('huy', 'huy', 1,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('employee', 'employee', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('maihong', '56435675', 1,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('hoale', 'wertytr', 1,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('tranhung', 'asdfghjf', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('nhung123', '76543456', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('phatnguyen', '09876545', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('dohang', 'xcvbnmnn', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('cuongdo', '23567876', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('phong2', 'oiuytrr', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('phuong123', 'treerty5', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('lenam', '34566543', 0,'Không ??ng nh?p');
INSERT INTO TAIKHOAN VALUES ('haudo', 'aert4565', 0,'Không ??ng nh?p');
--INSERT NHANVIEN--
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'mailan', 'Nguy?n Mai Lan', '236265767', TO_DATE('08/02/1989','dd/mm/yyyy'),'Bình ??nh', 'N?', '09255654254', 9000000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'letuan', 'Le Van Tuan', '255264344', TO_DATE('05/09/1990','dd/mm/yyyy'),'Bình ??nh', 'Nam', '0922526236', 9500000, TO_DATE('25/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'maihong', 'Mai Thi Hong', '252662726', TO_DATE('18/07/1989','dd/mm/yyyy'),'Bình ??nh', 'N?', '0925267466', 9000000, TO_DATE('12/04/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'hoale', 'Le Thi Hoa', '252623652', TO_DATE('24/06/1988','dd/mm/yyyy'),'Bình ??nh', 'N?', '0933662727', 10000000, TO_DATE('12/02/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'tranhung', 'Tran Van Hung', '256564633', TO_DATE('06/11/1993','dd/mm/yyyy'),'Bình ??nh', 'Nam', '09452662723', 6500000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'nhung123', 'Nguyen Thi Nhung', '235262623', TO_DATE('09/12/1991','dd/mm/yyyy'),'Bình ??nh', 'N?', '09432626627', 6000000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'phatnguyen', 'Nguyen Huu Phat', '232262726', TO_DATE('12/03/1990','dd/mm/yyyy'),'Bình ??nh', 'Nam', '09225626252', 6500000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'dohang', 'Do Minh Hang', '236265767', TO_DATE('14/04/1994','dd/mm/yyyy'),'Bình ??nh', 'N?', '09363767622', 6500000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'cuongdo', 'Do Huu Cuong', '223652656', TO_DATE('01/06/1993','dd/mm/yyyy'),'Bình ??nh', 'Nam', '09226657653', 6000000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'phong2', 'Nguyen Tan Phong', '225336657', TO_DATE('15/05/1998','dd/mm/yyyy'),'Bình ??nh', 'Nam', '09337765733', 7000000, TO_DATE('12/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'phuong123', 'Nguyen Mai Phuong', '265676778', TO_DATE('10/09/1995','dd/mm/yyyy'),'Bình ??nh', 'N?', '09267876551', 6500000, TO_DATE('22/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'lenam', 'Le Van Nam', '225363763', TO_DATE('15/05/1998','dd/mm/yyyy'),'Bình ??nh', 'Nam', '09343537783', 6500000, TO_DATE('15/03/2019','dd/mm/yyyy'));
INSERT INTO NHANVIEN VALUES (MANV_SEQ.nextval, 'haudo', 'Do Van Hau', '263765773', TO_DATE('20/08/1997','dd/mm/yyyy'),'Bình ??nh', 'Nam', '09326327662', 6000000, TO_DATE('12/04/2019','dd/mm/yyyy'));

--INSERT HOADON--
INSERT INTO HOADON VALUES(MAHD_SEQ.nextval, 2, 1, TO_DATE('12/03/2020 06:44','dd/mm/yyyy HH24:MI'), 60000, 0, 'Da thanh toan');
INSERT INTO HOADON VALUES(MAHD_SEQ.nextval, 2, 2, TO_DATE('12/03/2020 10:54','dd/mm/yyyy HH24:MI'), 25000, 0, 'Da thanh toan');
INSERT INTO HOADON VALUES(MAHD_SEQ.nextval, 2, 3, TO_DATE('12/03/2020 13:50','dd/mm/yyyy HH24:MI'), 59000, 0, 'Da thanh toan');
INSERT INTO HOADON VALUES(MAHD_SEQ.nextval, 2, 4, TO_DATE('12/03/2020 13:54','dd/mm/yyyy HH24:MI'), 118000, 0, 'Da thanh toan');
  
--INSERT CTHD--
INSERT INTO CTHD VALUES (1, 2, 15, 1, 2);
INSERT INTO CTHD VALUES (2, 1, 21, 2, 1);
INSERT INTO CTHD VALUES (3, 5, 4, 3, 1);
INSERT INTO CTHD VALUES (4, 11, 4, 4, 2);

--INSERT CHI_TIET_NHAP--
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 1, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 2, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 3, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 4, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 5, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 6, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 7, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 8, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 9, 2, TO_DATE('12/03/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 10, 3, TO_DATE('20/01/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 11, 3, TO_DATE('20/01/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 12, 3, TO_DATE('20/01/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 13, 3, TO_DATE('20/01/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 14, 4, TO_DATE('06/04/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 15, 4, TO_DATE('06/04/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 16, 4, TO_DATE('06/04/2020','dd/mm/yyyy'), 10);
INSERT INTO CHI_TIET_NHAP VALUES (MACTN_SEQ.NEXTVAL, 16, 4, TO_DATE('06/04/2020','dd/mm/yyyy'), 10);

--INSERT QUANLY--

  -- Them Nhan 1 nhan vien --
CREATE OR REPLACE PROCEDURE Them_Nhan_Vien(v_TenNV NHANVIEN.HOTEN%TYPE,
                                           v_CMND NHANVIEN.CMND%TYPE,
                                           v_NgaySinh NVARCHAR2,
                                           v_Diachi NHANVIEN.DIACHI%TYPE,
                                           v_GioiTinh NHANVIEN.GIOITINH%TYPE,
                                           v_SDT NHANVIEN.SDT%TYPE,
                                           v_MucLuong NHANVIEN.MUCLUONG%TYPE,
                                           v_NGVL NVARCHAR2,
                                           v_TenTK TAIKHOAN.TENTK%TYPE,
                                           v_MK TAIKHOAN.MK%TYPE,
                                           v_role TAIKHOAN.ROLE%TYPE)
IS
BEGIN
  COMMIT;
  INSERT INTO TAIKHOAN VALUES(v_TenTK, v_MK, v_role, 'Không ??ng nh?p');
  INSERT INTO NHANVIEN VALUES(MANV_SEQ.NEXTVAL, v_TenTK, v_TenNV, v_CMND, TO_DATE(v_NgaySinh,'dd-MM-yyyy'), v_Diachi, v_GioiTinh, v_SDT, v_MucLuong, TO_DATE(v_NGVL,'dd-MM-yyyy'));
  COMMIT;
END;

CREATE OR REPLACE PROCEDURE Xoa_Nhan_Vien(v_MaNV NHANVIEN.MANV%TYPE,
                                         v_TenTK NHANVIEN.TENTK%TYPE)
IS
BEGIN
  UPDATE HOADON SET MANV = NULL WHERE MANV = v_MaNV;
  DELETE FROM CHI_TIET_NHAP WHERE MANV = v_MaNV;
  DELETE FROM QUANLY WHERE MANV = v_MaNV OR MANV_QL = v_MaNV;
  DELETE FROM NHANVIEN WHERE MANV = v_MaNV AND TENTK = v_TenTK;
  DELETE FROM TAIKHOAN WHERE TENTK = v_TenTK;
  COMMIT;
END;


CREATE OR REPLACE FUNCTION Them_Hoa_Don_Fun(v_MaKH    IN KHACHHANG.MAKH%TYPE,
                                        v_MaNV    IN NHANVIEN.MANV%TYPE,
                                        v_NgayLap IN HOADON.NGAYLAP%TYPE,
                                        v_GiamGia IN HOADON.GIAMGIA%TYPE,
                                        v_MaBan   IN CTHD.MABAN%TYPE,
                                        v_MaMon   IN CTHD.MAMON%TYPE,
                                        v_SL      IN CTHD.SL%TYPE)
RETURN INT
IS
  v_MaHD HOADON.MAHD%TYPE;
BEGIN
  v_MaHD := MAHD_SEQ.NEXTVAL;
  INSERT
  INTO HOADON VALUES(v_MaHD,v_MaNV,v_MaKH,v_NgayLap,NULL,v_GiamGia,'Chua thanh toan');
  INSERT INTO CTHD VALUES(v_MaKH, v_MaBan, v_MaMon, v_MaHD, v_SL);
  COMMIT;
  RETURN v_MaHD;
END;

CREATE OR REPLACE PROCEDURE THANHTOAN(v_MABAN BAN.MABAN%TYPE,
                                      v_MAHD HOADON.MAHD%TYPE,
                                      v_THANHTIEN HOADON.THANHTIEN%TYPE)
IS
BEGIN
    UPDATE HOADON SET THANHTIEN = v_THANHTIEN WHERE MAHD = v_MAHD;
    UPDATE HOADON SET TRANGTHAI = 'Da thanh toan' WHERE   MAHD = v_MAHD;
    UPDATE BAN SET TRANGTHAI = '?ã ??t' WHERE MABAN = v_MABAN;
END;


CREATE OR REPLACE PROCEDURE Xoa_Khach_Hang
    (
      v_MaKH KHACHHANG.MAKH%TYPE,
      v_TenKH KHACHHANG.TENKH%TYPE
    )
  IS
  BEGIN
    DELETE FROM CTHD WHERE MAKH = v_MaKH;
    --      UPDATE HOADON SET MAKH = NULL WHERE MAKH = v_MaKH;
    DELETE
    FROM HOADON
    WHERE MAKH = v_MaKH;
    --      UPDATE CTHD SET MAKH = NULL WHERE MAKH = v_MaKH;
    DELETE
    FROM KHACHHANG
    WHERE TENKH = v_TenKH
    OR MAKH     = v_MaKH;
    COMMIT;
  END;

   
CREATE OR REPLACE PROCEDURE update_nh(v_soLuongNhapCu CHI_TIET_NHAP.SOLUONGNHAP%TYPE,
                                      v_soLuongNhap CHI_TIET_NHAP.SOLUONGNHAP%TYPE,
                                      v_maCTN CHI_TIET_NHAP.MACTN%TYPE)
IS
  v_maHang HANGHOA.MAHANG%TYPE;
BEGIN
  SELECT MAHANG INTO v_maHang
  from CHI_TIET_NHAP
  where MACTN = v_maCTN;
  
  UPDATE HANGHOA
  SET SL = SL - v_soLuongNhapCu + v_soLuongNhap
  WHERE MAHANG = v_maHang;

  UPDATE CHI_TIET_NHAP
  SET SOLUONGNHAP = v_soLuongNhap
  WHERE MACTN = v_mactn;
END;

-----------------------------TRIGGER--------------------------
CREATE OR REPLACE TRIGGER KHOA_HOADON 
BEFORE UPDATE ON HOADON
FOR EACH ROW
BEGIN
    /**
     * Ki?m tra hóa ??n ?ã khóa hay ch?a
     * TRANGTHAI trong hóa ??n = 'Da thanh toan' --> ?ã khóa.
     */

    IF :OLD.TRANGTHAI = 'Da thanh toan' THEN
        RAISE_APPLICATION_ERROR(-20015, 'Hóa ??n ?ã thanh toán không c?p nh?t ???c');
    END IF;
END;


CREATE OR REPLACE TRIGGER KHOA_CTHD BEFORE
    INSERT ON CTHD
    FOR EACH ROW
DECLARE
    v_tt HOADON.TRANGTHAI%TYPE;
BEGIN
    /**
     * Ki?m tra hóa ??n ?ã khóa hay ch?a
     * TRANGTHAI trong hóa ??n = 'Da thanh toan' --> ?ã khóa.
     */
    SELECT
        TRANGTHAI
    INTO v_tt
    FROM
        HOADON
    WHERE
        MAHD = :new.MAHD;

    IF v_tt = 'Da thanh toan'THEN
        RAISE_APPLICATION_ERROR(-20015, 'Hóa ??n ?ã thanh toán không th? thêm CTHD.');
    END IF;
END;

/
CREATE OR REPLACE TRIGGER KHOA_CTHD_DEL BEFORE
    DELETE ON CTHD
    FOR EACH ROW
DECLARE
    v_tt HOADON.TRANGTHAI%TYPE;
BEGIN
    /**
     * Ki?m tra hóa ??n ?ã khóa hay ch?a
     * TRANGTHAI trong hóa ??n = 'Da thanh toan' --> ?ã khóa.
     **/
    SELECT
        TRANGTHAI
    INTO v_tt
    FROM
        HOADON
    WHERE
        MAHD = :old.MAHD;

    IF v_tt = 'Da thanh toan' THEN
        RAISE_APPLICATION_ERROR(-20015, 'Hóa ??n ?ã thanh toán không th? xóa CTHD');
    END IF;
END;

--TRIGGER TANG DIEM TICH LUY KHI THEM HOA DON CHO KHACH HANG--
CREATE OR REPLACE TRIGGER TANG_DTL_KH
BEFORE INSERT ON HOADON
FOR EACH ROW
BEGIN
    UPDATE KHACHHANG 
    SET DIEMTL = DIEMTL+1
    WHERE MAKH = :NEW.MAKH;
END;

--KIEM TRA NGAY VAO LAM CUA NHAN VIEN PHAI LON HON NGAY SINH
CREATE OR REPLACE TRIGGER TRG_UPDATE_NHANVIEN_NGAYVAOLAM 
BEFORE INSERT OR UPDATE ON NHANVIEN
FOR EACH ROW
BEGIN
  IF(:NEW.NVL <= :NEW.NGAYSINH)THEN
    RAISE_APPLICATION_ERROR(-20000, 'NGAY VAO LAM PHAI LON HON NGAY SINH!!');
  END IF;
END;
--NGUYEN LIEU PHAI CON HAN SU DUNG
CREATE OR REPLACE TRIGGER TRG_CK_HSD_NGUYENLIEU
BEFORE INSERT OR UPDATE ON NGUYENLIEU
FOR EACH ROW
BEGIN
  IF(:NEW.HSD <= CURRENT_DATE)THEN
    RAISE_APPLICATION_ERROR(-20000, 'NGUYEN LIEU HET HAN SU DUNG!!');
  END IF;
END;

--MOI HOA DON CO THOI GIAN LAP NHO HON HOAC BANG NGAY HIEN TAI
CREATE OR REPLACE TRIGGER TRG_CK_NGAYLAP_HOADON
BEFORE INSERT OR UPDATE ON HOADON
FOR EACH ROW
BEGIN
  IF(:NEW.NGAYLAP > CURRENT_DATE)THEN
    RAISE_APPLICATION_ERROR(-20000, 'NGAY LAP HOA DON PHAI NHO HON HOAC BANG NGAY HIEN TAI!!');
  END IF;
END;

--TRIGGER CAP NHAT LUONG CUA NHAN VIEN TANG CHU KHONG DUOC GIAM---
CREATE OR REPLACE TRIGGER TRG_CAPNHAT_LUONG
BEFORE INSERT OR UPDATE ON NHANVIEN
FOR EACH ROW
BEGIN
  IF(:NEW.MUCLUONG < :OLD.MUCLUONG)THEN
    RAISE_APPLICATION_ERROR(-20022, 'LUONG CAP NHAT PHAI LON HON LUONG HIEN TAI!!');
  END IF;
END;


SELECT * FROM HOADON;

UPDATE KHACHHANG
SET DIEMTL = 50
WHERE MAKH = 7;
SELECT* FROM KHACHHANG;
INSERT INTO HOADON VALUES(MAHD_SEQ.NEXTVAL, 2, 7, TO_DATE('12-03-2018','dd-MM-yyyy'), 70000,0);
SELECT* FROM KHACHHANG;

CREATE OR REPLACE TRIGGER TANG_SLCON
BEFORE INSERT ON CHI_TIET_NHAP 
FOR EACH ROW
BEGIN
    UPDATE NGUYENLIEU 
    SET SLCON = SLCON + (SELECT SOLUONGNHAP FROM CHI_TIET_NHAP WHERE MACTN = :NEW.MACTN)
    WHERE  MANL =:NEW.MAHANG;
END;
INSERT INTO CHI_TIET_NHAP VALUES (30, 10, 2, TO_DATE('12-03-2018','dd-MM-yyyy'), 11);

--TRIGGER GIAM SLCON CUA NGUYENLIEU KHI THEM CTHD---
CREATE OR REPLACE TRIGGER GIAM_SLCON
AFTER INSERT ON CTHD
FOR EACH ROW
BEGIN
    UPDATE NGUYENLIEU 
    SET SLCON = SLCON - (SELECT SOLUONGNL FROM MON WHERE MAMON = :NEW.MAMON)*:NEW.SL
    WHERE  MANL =(SELECT MANL 
                  FROM MON
                  WHERE MAMON = :NEW.MAMON);
END;    */            
select* from ncc
commit