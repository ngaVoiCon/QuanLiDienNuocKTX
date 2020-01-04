DROP DATABASE QL_DienNuocKiTucXa;
CREATE DATABASE QL_DienNuocKiTucXa;
USE QL_DienNuocKiTucXa;

CREATE TABLE CHU (
    USER_NAME VARCHAR(50) NOT NULL UNIQUE,
    PASSWORD VARCHAR(50) NOT NULL,
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TEN VARCHAR(30),
    GIOI_TINH VARCHAR(5),
    NGAY_SINH DATE,
    DIA_CHI VARCHAR(50),
    SO_DIEN_THOAI VARCHAR(15)
);
   
INSERT INTO CHU VALUE
("a.nguyen", "@ckt@", 1, "NGUYEN VAN A", "Nam", "1952-02-29", "Da Nang", "0123456789"),
("b.nguyen", "@ckt@", 2, "NGUYEN THUY B", "Nu", "1959-02-2", "Da Nang", "01224289"),
("c.tran", "@ckt@", 3, "TRAN TU C", "Nam", "1955-02-9", "Ha Noi", "0123565489"),
("d.hoang", "@ckt@", 4, "HOANG DINH D", "Nam", "1952-03-25", "Quang Nam", "0123453534"),
("e.dinh", "@ckt@", 5, "DINH THI THUY E", "Nu", "1956-02-23", "Binh Dinh", "012345464");

CREATE TABLE PHONG (
PHONG INT NOT NULL PRIMARY KEY
);

INSERT INTO PHONG VALUES
(112),
(206),
(207),
(208),
(209),
(210),
(211),
(212),
(306),
(307),
(308),
(309),
(310),
(406),
(407),
(408),
(409);



CREATE TABLE TRUONG_PHONG (
    USER_NAME VARCHAR(50) NOT NULL UNIQUE,
    PASSWORD VARCHAR(50) NOT NULL,
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PHONG INT NOT NULL,
    TEN VARCHAR(30),
    SO_DIEN_THOAI VARCHAR(15),
    GIOI_TINH VARCHAR(5),
    FOREIGN KEY (PHONG)
        REFERENCES PHONG (PHONG)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO TRUONG_PHONG VALUES
("thao.nguyen", "@tp@", 1, 112, "Nguyen Ngoc Thao", "0741852963", "Nam"),
("nguyet.nguyen", "@tp@", 2, 206, "Nguyen Thi Nguyet", "0852963741","Nu"),
("phuong.nguyen", "@tp@", 3, 207, "Nguyen Thi Bich Phuong", "0963741852", "Nu"),
("van.mai","@tp@", 4, 208, "Mai Thi My Van", "0987654321", "Nu"),
("phu.tran", "@tp@", 5, 209, "Tran Minh Phu", "09633545562", "Nam"),
("thuy.nguyen", "@tp@", 6, 210, "Nguyen Phuong Thuy", "096385732", "Nu"),
("lan.nguyen", "@tp@", 7, 211, "Nguyen Huong Lan", "0963757533", "Nu"),
("dung.tran", "@tp@", 8, 212, "Tran Cong Dung", "096354743", "Nam"),
("anh.dinh", "@tp@", 9, 306, " Dinh Cong Anh", "02465657", "Nam"),
("hieu.nguyen", "@tp@", 10, 307, "Nguyen My Hieu", "0963567682", "Nu"),
("sim.ho", "@tp@", 11,308, "Ho Thi Sim", "0945645", "Nu"),
("hoang.dinh", "@tp@", 12, 309, "Dinh Tien Hoang", "0924354645", "Nam"),
("thi.ho", "@tp@", 13, 310, "Ho Dinh Thi", "0934645652", "Nam"),
("hoa.tran", "@tp@", 14, 406, "Tran Thuy Hoa", "099873432", "Nu"),
("chau.truong", "@tp@", 15, 407, "Truong Ngoc Bao Chau", "0356575672", "Nu"),
("chau.tran", "@tp@", 16, 408, "Tran Ngoc Bao Chau", "0356575672", "Nu"),
("thu.hoang", "@tp@", 17, 409, "Hoang Anh Thu", "0966546572", "Nu");


CREATE TABLE NHAN_VIEN (
    USER_NAME VARCHAR(50) NOT NULL UNIQUE,
    PASSWORD VARCHAR(50) NOT NULL,
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TEN VARCHAR(30),
    GIOI_TINH VARCHAR(5),
    NGAY_SINH DATE,
    DIA_CHI VARCHAR(50),
    SO_DIEN_THOAI VARCHAR(15)
);

INSERT INTO NHAN_VIEN (USER_NAME, TEN, PASSWORD, NGAY_SINH, SO_DIEN_THOAI, DIA_CHI, GIOI_TINH) VALUES
("tien.ho", "Ho Minh Tien", "@nv@", "2000-04-17", "0147258369", "Quang Binh", "Nam"),
("tien.nguyen", "Nguyen Thi Tien", "@nv@", "2000-10-09", "0258369147", "Da Nang", "Nu"),
("nga.nguyen", "Nguyen Thi Nga", "@nv@", "2000-10-01", "0369147258", "Quang Binh", "Nu"),
("dat.phan", "Phan Tien Dat", "@nv@", "1990-01-09", "025833457", "Binh Dinh", "Nam"),
("phuong.dang", "Dang Nhu Phuong", "@nv@", "2000-12-09", "025834347", "Quang Nam", "Nu");


CREATE TABLE LUONG_NHAN_VIEN (
ID_NHAN_VIEN INT NOT NULL,
NAM INT(5),
THANG INT check(Thang > 0 and Thang < 13),
LUONG INT,
primary key (id_nhan_vien, nam, thang),
foreign key(id_NHAN_VIEN) REFERENCES NHAN_VIEN(ID)  ON delete cascade on update cascade
);

INSERT INTO LUONG_NHAN_VIEN VALUES
(1, 2019, 1, 5000000),
(2, 2019, 1, 5000000),
(3, 2019, 1, 5500000),
(4,2019,1,5500000),
(5,2019,1,6000000),
(1, 2019, 2, 5500000),
(2, 2019, 2, 5500000),
(3, 2019, 2, 5500000),
(4,2019,2,5500000),
(5,2019,2,6000000);



   
CREATE TABLE DUNG_DIEN (
    PHONG INT NOT NULL,
    NAM INT(5),
    THANG INT,
    SO_DAU INT,
    SO_CUOI INT,
    PRIMARY KEY (PHONG , NAM , THANG),
    FOREIGN KEY (PHONG)
        REFERENCES PHONG (PHONG)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO DUNG_DIEN (PHONG, NAM, THANG, SO_DAU, SO_CUOI) VALUES
(112, 2019, 3, 8455, 8486),
(206, 2019, 3, 2381, 2435),
(207, 2019, 3, 1141, 1193),
(208, 2019, 3, 7222, 7294),
(209, 2019, 3, 1231, 1690),
(210, 2019, 3, 1345, 1534),
(211, 2019, 3, 1239, 1409),
(212, 2019, 3, 1221, 1409),
(306, 2019, 3, 1101, 1393),
(307, 2019, 3, 1245, 1353),
(308, 2019, 3, 1546, 1845),
(309, 2019, 3, 1234, 1325),
(310, 2019, 3, 1000, 1321),
(406, 2019, 3, 1241, 1593),
(407, 2019, 3, 2311, 2493),
(408, 2019, 3, 1321, 1593),
(409, 2019, 3, 1500, 1550);


 
CREATE TABLE DUNG_NUOC (
    PHONG INT NOT NULL,
    NAM INT(5),
    THANG INT,
    SO_DAU INT,
    SO_CUOI INT,
    PRIMARY KEY (PHONG , NAM , THANG),
    FOREIGN KEY (PHONG)
        REFERENCES PHONG (PHONG)
        ON DELETE CASCADE ON UPDATE CASCADE
);
 
INSERT INTO DUNG_NUOC (PHONG, NAM, THANG, SO_DAU, SO_CUOI) VALUES
(112, 2019, 3, 1028, 1141),
(206, 2019, 3, 1488, 1503),
(207, 2019, 3, 1867, 1982),
(208, 2019, 3, 1544, 1662),
(209, 2019, 3, 1631, 1890),
(210, 2019, 3, 1645, 1834),
(211, 2019, 3, 1339, 1532),
(212, 2019, 3, 1221, 1409),
(306, 2019, 3, 1209, 1399),
(307, 2019, 3, 1245, 1353),
(308, 2019, 3, 1546, 1705),
(309, 2019, 3, 1234, 1395),
(310, 2019, 3, 1023, 1201),
(406, 2019, 3, 1241, 1538),
(407, 2019, 3, 2311, 2498),
(408, 2019, 3, 1112, 1233),
(409, 2019, 3, 1603, 1690);



                    /*NHUNG CAU LENH TRUY VAN*/
SELECT*FROM CHU;

SELECT * FROM NHAN_VIEN;

SELECT * FROM LUONG_NHAN_VIEN;

SELECT * FROM PHONG;

SELECT * FROM TRUONG_PHONG;

SELECT * FROM DUNG_DIEN;

SELECT*FROM DUNG_NUOC;

SELECT * FROM DUNG_DIEN WHERE NAM = (SELECT MAX(NAM) FROM DUNG_DIEN) AND THANG = (SELECT MAX(THANG) FROM DUNG_DIEN) AND PHONG = 406;

SELECT * FROM DUNG_DIEN WHERE SO_CUOI = 4000 AND PHONG = 406