﻿CREATE DATABASE EduSystem
GO

USE EduSystem
GO

CREATE TABLE NhanVien(
	MaNV nvarchar(50) NOT NULL,
	MatKhau nvarchar(50) NOT NULL,
	HoTen nvarchar(50) NOT NULL,
	VaiTro bit NOT NULL DEFAULT 0,
	Email varchar(50) NOT NULL,
	Hinh nvarchar(50),
	PRIMARY KEY(MaNV)
)
GO

CREATE TABLE ChuyenDe(
	MaCD nvarchar(50) NOT NULL,
	TenCD nvarchar(50) NOT NULL,
	HocPhi float NOT NULL DEFAULT 0,
	ThoiLuong int NOT NULL DEFAULT 30,
	Hinh nvarchar(50),
	MoTa nvarchar(255) NOT NULL,
	PRIMARY KEY(MaCD),
	UNIQUE(TenCD),
	CHECK(HocPhi >= 0 AND ThoiLuong > 0)
)
GO

CREATE TABLE NguoiHoc(
	MaNH nvarchar(50) NOT NULL,
	HoTen nvarchar(50) NOT NULL,
	NgaySinh date NOT NULL,
	GioiTinh bit NOT NULL DEFAULT 0,
	DienThoai nvarchar(50) NOT NULL,
	Email nvarchar(50) NOT NULL,
	GhiChu nvarchar(max) NULL,
	MaNV nvarchar(50) NOT NULL,
	NgayDK date NOT NULL DEFAULT getdate(),
	PRIMARY KEY(MaNH),
	FOREIGN KEY(MaNV) REFERENCES NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO

CREATE TABLE KhoaHoc(
	MaKH int IDENTITY(1,1) NOT NULL,
	MaCD nvarchar(50) NOT NULL,
	HocPhi float NOT NULL DEFAULT 0,
	ThoiLuong int NOT NULL DEFAULT 0,
	NgayKG date NOT NULL,
	GhiChu nvarchar(50) NULL,
	MaNV nvarchar(50) NOT NULL,
	NgayTao date NOT NULL DEFAULT getdate(),
	PRIMARY KEY(MaKH),
	CHECK(HocPhi >= 0 AND ThoiLuong > 0),
	FOREIGN KEY (MaCD) REFERENCES ChuyenDe(MaCD) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
GO

CREATE TABLE HocVien(
	MaHV int IDENTITY(1,1) NOT NULL,
	MaKH int NOT NULL,
	MaNH nvarchar(50) NOT NULL,
	Diem float NOT NULL,
	PRIMARY KEY(MaHV),
	UNIQUE(MaKH, MaNH),
	FOREIGN KEY (MaKH) REFERENCES KhoaHoc(MaKH) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (MaNH) REFERENCES NguoiHoc(MaNH) ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO

CREATE PROC sp_ThongKeNguoiHoc
	AS BEGIN
		SELECT
		YEAR(NgayDK) Nam,
		COUNT(*) SoLuong,
		MIN(NgayDK) DauTien,
		MAX(NgayDK) CuoiCung
		FROM NguoiHoc
		GROUP BY YEAR(NgayDK)
	END
GO

CREATE PROC sp_ThongKeDoanhThu(@Year INT)
	AS BEGIN
		SELECT
		kh.MaCD ChuyenDe,
		COUNT(DISTINCT kh.MaKH) SoKH,
		COUNT(hv.MaHV) SoHV,
		SUM(kh.HocPhi) DoanhThu,
		MIN(kh.HocPhi) ThapNhat,
		MAX(kh.HocPhi) CaoNhat,
		CONVERT(DECIMAL(10,2),AVG(kh.HocPhi)) TrungBinh
		FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKH=hv.MaKH
		JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
		WHERE YEAR(NgayKG) = @Year
		GROUP BY kh.MaCD
	END
GO

CREATE PROC sp_ThongKeDiem
	AS BEGIN
		SELECT
		cd.MaCD ChuyenDe,
		COUNT(MaHV) SoHV,
		MIN(Diem) ThapNhat,
		MAX(Diem) CaoNhat,
		CONVERT(DECIMAL(10,2),AVG(Diem)) TrungBinh
		FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKH=hv.MaKH
		JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD
		GROUP BY cd.MaCD
	END
GO

CREATE PROC sp_BangDiem(@MaKH INT)
	AS BEGIN
		SELECT
		nh.MaNH,
		nh.HoTen,
		hv.Diem
		FROM HocVien hv
		JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH
		WHERE hv.MaKH = @MaKH
		ORDER BY hv.Diem DESC
	END
GO




INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email],[Hinh]) VALUES (N'NoPT', N'123456', N'Phạm Thị Nở', 0,'nghiapls17855@fpt.edu.vn','nopt.png')
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email],[Hinh]) VALUES (N'PheoNC', N'123456', N'Nguyễn Chí Phèo', 0,'nghiapls17855@fpt.edu.vn','pheonc.jpg')
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro], [Email],[Hinh]) VALUES (N'TeoNV', N'123456', N'Nguyễn Văn Tèo', 1,'nghiapls17855@fpt.edu.vn','teonv.png')



INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV01', N'Lập trình Java cơ bản', 300, 90, N'JAV01.png', N'JAV01 - Lập trình Java cơ bản')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV02', N'Lập trình Java nâng cao', 300, 90, N'JAV02.png', N'JAV02 - Lập trình Java nâng cao')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'JAV03', N'Lập trình mạng với Java', 200, 70, N'JAV03.png', N'JAV03 - Lập trình mạng với Java')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'PRO01', N'Dự án với công nghệ MS.NET MVC', 300, 90, N'PRO01.png', N'PRO01 - Dự án với công nghệ MS.NET MVC')
INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]) VALUES (N'PRO02', N'Dự án với công nghệ Spring MVC', 300, 90, N'PRO02.png', N'PRO02 - Dự án với công nghệ Spring MVC')



INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV01', 250, 80, '1-10-2018', N'', N'TeoNV', '3-20-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV01', 100, 50, '2-17-2018', N'', N'TeoNV', '6-17-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV01', 300, 90, '4-28-2018', N'', N'TeoNV', '12-16-2018')

INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV02', 300, 90, '1-10-2018', N'', N'TeoNV', '3-20-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES ( N'JAV02', 300, 90, '2-17-2018', N'', N'TeoNV', '6-17-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV02', 100, 50, '4-28-2018', N'', N'TeoNV', '12-16-2018')

INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV03', 250, 80, '1-10-2018', N'', N'TeoNV', '3-20-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES ( N'JAV03', 300, 90, '2-17-2018', N'', N'TeoNV', '6-17-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'JAV03', 100, 50, '4-28-2018', N'', N'TeoNV', '12-16-2018')

INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'PRO01', 250, 80, '1-10-2018', N'', N'TeoNV', '3-20-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'PRO01', 100, 50, '2-17-2018', N'', N'TeoNV', '6-17-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'PRO01', 100, 50, '4-28-2018', N'', N'TeoNV', '12-16-2018')

INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'PRO02', 250, 80,'1-10-2018', N'', N'TeoNV', '3-20-2018')
INSERT [dbo].[KhoaHoc] ([MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (N'PRO02', 100, 50, '2-17-2018', N'', N'TeoNV', '6-17-2018')



INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS01638', N'LỮ HUY CƯỜNG', CAST(0xAF170B00 AS Date), 1, N'0928768265', N'PS01638@fpt.edu.vn', N'0928768265 - LỮ HUY CƯỜNG', N'PheoNC', CAST(0xAF170B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02037', N'ĐỖ VĂN MINH', CAST(0xC6190B00 AS Date), 1, N'0968095685', N'PS02037@fpt.edu.vn', N'0968095685 - ĐỖ VĂN MINH', N'PheoNC', CAST(0xC6190B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02771', N'NGUYỄN TẤN HIẾU', CAST(0x2E220B00 AS Date), 1, N'0927594734', N'PS02771@fpt.edu.vn', N'0927594734 - NGUYỄN TẤN HIẾU', N'PheoNC', CAST(0x2E220B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02867', N'NGUYỄN HỮU TRÍ', CAST(0xEB200B00 AS Date), 1, N'0946984711', N'PS02867@fpt.edu.vn', N'0946984711 - NGUYỄN HỮU TRÍ', N'TeoNV', CAST(0xEB200B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02930', N'TRẦN VĂN NAM', CAST(0xA1240B00 AS Date), 1, N'0924774498', N'PS02930@fpt.edu.vn', N'0924774498 - TRẦN VĂN NAM', N'TeoNV', CAST(0xA1240B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02979', N'ĐOÀN TRẦN NHẬT VŨ', CAST(0x671C0B00 AS Date), 1, N'0912374818', N'PS02979@fpt.edu.vn', N'0912374818 - ĐOÀN TRẦN NHẬT VŨ', N'TeoNV', CAST(0x671C0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02983', N'NGUYỄN HOÀNG THIÊN PHƯỚC', CAST(0x681A0B00 AS Date), 1, N'0912499836', N'PS02983@fpt.edu.vn', N'0912499836 - NGUYỄN HOÀNG THIÊN PHƯỚC', N'PheoNC', CAST(0x681A0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS02988', N'HỒ HỮU HẬU', CAST(0x311A0B00 AS Date), 1, N'0924984876', N'PS02988@fpt.edu.vn', N'0924984876 - HỒ HỮU HẬU', N'PheoNC', CAST(0x311A0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03031', N'PHAN TẤN VIỆT', CAST(0x21160B00 AS Date), 1, N'0924832716', N'PS03031@fpt.edu.vn', N'0924832716 - PHAN TẤN VIỆT', N'PheoNC', CAST(0x21160B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03046', N'NGUYỄN CAO PHƯỚC', CAST(0xDE150B00 AS Date), 1, N'0977117727', N'PS03046@fpt.edu.vn', N'0977117727 - NGUYỄN CAO PHƯỚC', N'PheoNC', CAST(0xDE150B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03080', N'HUỲNH THANH HUY', CAST(0x701C0B00 AS Date), 1, N'0916436052', N'PS03080@fpt.edu.vn', N'0916436052 - HUỲNH THANH HUY', N'PheoNC', CAST(0x701C0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03088', N'NGUYỄN HOÀNG TRUNG', CAST(0x24180B00 AS Date), 1, N'0938101529', N'PS03088@fpt.edu.vn', N'0938101529 - NGUYỄN HOÀNG TRUNG', N'PheoNC', CAST(0x24180B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03096', N'ĐOÀN HỮU KHANG', CAST(0xAB1B0B00 AS Date), 1, N'0945196719', N'PS03096@fpt.edu.vn', N'0945196719 - ĐOÀN HỮU KHANG', N'PheoNC', CAST(0xAB1B0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03104', N'LÊ THÀNH PHƯƠNG', CAST(0x3E1A0B00 AS Date), 1, N'0922948096', N'PS03104@fpt.edu.vn', N'0922948096 - LÊ THÀNH PHƯƠNG', N'PheoNC', CAST(0x3E1A0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03120', N'PHẠM NGỌC NHẬT TRƯỜNG', CAST(0x48230B00 AS Date), 1, N'0994296169', N'PS03120@fpt.edu.vn', N'0994296169 - PHẠM NGỌC NHẬT TRƯỜNG', N'PheoNC', CAST(0x48230B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03130', N'ĐẶNG BẢO VIỆT', CAST(0xEF150B00 AS Date), 1, N'0917749344', N'PS03130@fpt.edu.vn', N'0917749344 - ĐẶNG BẢO VIỆT', N'PheoNC', CAST(0xEF150B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03134', N'LÊ DUY BẢO', CAST(0x2E1F0B00 AS Date), 1, N'0926714368', N'PS03134@fpt.edu.vn', N'0926714368 - LÊ DUY BẢO', N'PheoNC', CAST(0x2E1F0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03172', N'NGUYỄN ANH TUẤN', CAST(0xCA180B00 AS Date), 1, N'0920020472', N'PS03172@fpt.edu.vn', N'0920020472 - NGUYỄN ANH TUẤN', N'PheoNC', CAST(0xCA180B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03202', N'PHAN QUỐC QUI', CAST(0x741E0B00 AS Date), 1, N'0930649274', N'PS03202@fpt.edu.vn', N'0930649274 - PHAN QUỐC QUI', N'PheoNC', CAST(0x741E0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03203', N'ĐẶNG LÊ QUANG VINH', CAST(0xC4150B00 AS Date), 1, N'0920197355', N'PS03203@fpt.edu.vn', N'0920197355 - ĐẶNG LÊ QUANG VINH', N'PheoNC', CAST(0xC4150B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03205', N'NGUYỄN MINH SANG', CAST(0x5E1D0B00 AS Date), 1, N'0967006218', N'PS03205@fpt.edu.vn', N'0967006218 - NGUYỄN MINH SANG', N'PheoNC', CAST(0x5E1D0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03222', N'TRẦM MINH MẪN', CAST(0xE71F0B00 AS Date), 1, N'0911183649', N'PS03222@fpt.edu.vn', N'0911183649 - TRẦM MINH MẪN', N'PheoNC', CAST(0xE71F0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03230', N'NGUYỄN PHẠM MINH HÂN', CAST(0x26250B00 AS Date), 1, N'0983469892', N'PS03230@fpt.edu.vn', N'0983469892 - NGUYỄN PHẠM MINH HÂN', N'PheoNC', CAST(0x26250B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03233', N'LƯU KIM HOÀNG DUY', CAST(0x0B1F0B00 AS Date), 1, N'0938357735', N'PS03233@fpt.edu.vn', N'0938357735 - LƯU KIM HOÀNG DUY', N'PheoNC', CAST(0x0B1F0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03251', N'TRẦN QUANG VŨ', CAST(0x4C240B00 AS Date), 1, N'0914531913', N'PS03251@fpt.edu.vn', N'0914531913 - TRẦN QUANG VŨ', N'PheoNC', CAST(0x4C240B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03304', N'BÙI NGỌC THUẬN', CAST(0xFE1C0B00 AS Date), 1, N'0999794115', N'PS03304@fpt.edu.vn', N'0999794115 - BÙI NGỌC THUẬN', N'PheoNC', CAST(0xFE1C0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03306', N'HỒ VĂN HÀNH', CAST(0x06190B00 AS Date), 1, N'0912277868', N'PS03306@fpt.edu.vn', N'0912277868 - HỒ VĂN HÀNH', N'PheoNC', CAST(0x06190B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03308', N'TRẦN VIẾT HÙNG', CAST(0xD0220B00 AS Date), 1, N'0916050164', N'PS03308@fpt.edu.vn', N'0916050164 - TRẦN VIẾT HÙNG', N'PheoNC', CAST(0xD0220B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03325', N'NGUYỄN HOÀNG MINH ĐỨC', CAST(0xAB1F0B00 AS Date), 1, N'0912234437', N'PS03325@fpt.edu.vn', N'0912234437 - NGUYỄN HOÀNG MINH ĐỨC', N'PheoNC', CAST(0xAB1F0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03346', N'PHAN THANH PHONG', CAST(0xD7150B00 AS Date), 1, N'0937891282', N'PS03346@fpt.edu.vn', N'0937891282 - PHAN THANH PHONG', N'PheoNC', CAST(0xD7150B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03383', N'TRẦN VŨ LUÂN', CAST(0x8E210B00 AS Date), 1, N'0962030316', N'PS03383@fpt.edu.vn', N'0962030316 - TRẦN VŨ LUÂN', N'PheoNC', CAST(0x8E210B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03389', N'VŨ ĐỨC TUẤN', CAST(0x411A0B00 AS Date), 1, N'0911637415', N'PS03389@fpt.edu.vn', N'0911637415 - VŨ ĐỨC TUẤN', N'PheoNC', CAST(0x411A0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03410', N'TRẦN  NHẠT', CAST(0x3C190B00 AS Date), 1, N'0946219377', N'PS03410@fpt.edu.vn', N'0946219377 - TRẦN  NHẠT', N'PheoNC', CAST(0x3C190B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03411', N'TRƯƠNG THÀNH ĐẠT', CAST(0x3F1B0B00 AS Date), 1, N'0991509408', N'PS03411@fpt.edu.vn', N'0991509408 - TRƯƠNG THÀNH ĐẠT', N'PheoNC', CAST(0x3F1B0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03425', N'TÔ VĂN NĂNG', CAST(0x6E190B00 AS Date), 1, N'0915134551', N'PS03425@fpt.edu.vn', N'0915134551 - TÔ VĂN NĂNG', N'PheoNC', CAST(0x6E190B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03454', N'NGUYỄN NHẬT VĨNH', CAST(0x57230B00 AS Date), 1, N'0917886371', N'PS03454@fpt.edu.vn', N'0917886371 - NGUYỄN NHẬT VĨNH', N'PheoNC', CAST(0x57230B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03472', N'NGUYỄN VĂN HUY', CAST(0xD8150B00 AS Date), 1, N'0960620997', N'PS03472@fpt.edu.vn', N'0960620997 - NGUYỄN VĂN HUY', N'PheoNC', CAST(0xD8150B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03488', N'NGUYỄN NHƯ NGỌC', CAST(0x651D0B00 AS Date), 0, N'0912880267', N'PS03488@fpt.edu.vn', N'0912880267 - NGUYỄN NHƯ NGỌC', N'PheoNC', CAST(0x651D0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03530', N'PHẠM THÀNH TÂM', CAST(0x4D240B00 AS Date), 1, N'0918161783', N'PS03530@fpt.edu.vn', N'0918161783 - PHẠM THÀNH TÂM', N'PheoNC', CAST(0x4D240B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03553', N'ĐINH TẤN CÔNG', CAST(0xEA240B00 AS Date), 1, N'0918182551', N'PS03553@fpt.edu.vn', N'0918182551 - ĐINH TẤN CÔNG', N'PheoNC', CAST(0xEA240B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03561', N'LÊ MINH ĐIỀN', CAST(0xE91C0B00 AS Date), 1, N'0948199564', N'PS03561@fpt.edu.vn', N'0948199564 - LÊ MINH ĐIỀN', N'PheoNC', CAST(0xE91C0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03596', N'NGUYỄN THANH HIỀN', CAST(0xED170B00 AS Date), 1, N'0910545901', N'PS03596@fpt.edu.vn', N'0910545901 - NGUYỄN THANH HIỀN', N'PheoNC', CAST(0xED170B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03603', N'LÊ PHẠM KIM THANH', CAST(0x501C0B00 AS Date), 0, N'0924696779', N'PS03603@fpt.edu.vn', N'0924696779 - LÊ PHẠM KIM THANH', N'PheoNC', CAST(0x501C0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03610', N'TRẦN ĐÌNH TRƯỜNG', CAST(0xF41C0B00 AS Date), 1, N'0941528106', N'PS03610@fpt.edu.vn', N'0941528106 - TRẦN ĐÌNH TRƯỜNG', N'PheoNC', CAST(0xF41C0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03614', N'NGUYỄN VĂN SÁU', CAST(0x37160B00 AS Date), 1, N'0940711328', N'PS03614@fpt.edu.vn', N'0940711328 - NGUYỄN VĂN SÁU', N'PheoNC', CAST(0x37160B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03618', N'PHÍ ĐÌNH VIỆT HÙNG', CAST(0xA91F0B00 AS Date), 1, N'0939020097', N'PS03618@fpt.edu.vn', N'0939020097 - PHÍ ĐÌNH VIỆT HÙNG', N'PheoNC', CAST(0xA91F0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03638', N'PHẠM NHẬT MINH', CAST(0x86200B00 AS Date), 1, N'0927771672', N'PS03638@fpt.edu.vn', N'0927771672 - PHẠM NHẬT MINH', N'PheoNC', CAST(0x86200B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03640', N'LƯU THANH NGỌC', CAST(0x591B0B00 AS Date), 0, N'0918358164', N'PS03640@fpt.edu.vn', N'0918358164 - LƯU THANH NGỌC', N'PheoNC', CAST(0x591B0B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03662', N'NGUYỄN CAO NGỌC LỢI', CAST(0x34160B00 AS Date), 1, N'0930260679', N'PS03662@fpt.edu.vn', N'0930260679 - NGUYỄN CAO NGỌC LỢI', N'PheoNC', CAST(0x34160B00 AS Date))
INSERT [dbo].[NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (N'PS03674', N'TRẦN TUẤN ANH', CAST(0xF41E0B00 AS Date), 1, N'0914082094', N'PS03674@fpt.edu.vn', N'0914082094 - TRẦN TUẤN ANH', N'PheoNC', CAST(0xF41E0B00 AS Date))



INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS01638', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS02037', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS02771', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS02930', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS02988', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS03674', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS03662', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS03640', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS02867', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (1, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02930', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS01638', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02037', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02867', 3)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS03411', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02771', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02979', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS02988', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS03031', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (2, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03046', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03080', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03088', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03096', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03104', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03120', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03130', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03134', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03172', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03202', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (3, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS01638', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS02037', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS02771', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS02930', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS02988', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS03674', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS03662', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS03640', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS02867', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (4, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02930', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS01638', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02037', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02867', 3)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS03411', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02771', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02979', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS02988', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS03031', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (5, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03046', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03080', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03088', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03096', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03104', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03120', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03130', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03134', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03172', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03202', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (6, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS01638', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS02037', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS02771', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS02930', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS02988', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS03674', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS03662', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS03640', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS02867', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (7, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02930', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS01638', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02037', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02867', 3)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS03411', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02771', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02979', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS02988', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS03031', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (8, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03046', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03080', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03088', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03096', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03104', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03120', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03130', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03134', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03172', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03202', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (9, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS01638', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS02037', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS02771', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS02930', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS02988', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS03674', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS03662', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS03640', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS02867', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (10, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02930', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS01638', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02037', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02867', 3)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS03411', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02771', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02979', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS02988', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS03031', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (11, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03046', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03080', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03088', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03096', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03104', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03120', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03130', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03134', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03172', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03202', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (12, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS01638', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS02037', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS02771', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS02930', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS02988', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS03674', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS03662', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS03640', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS02867', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (13, N'PS03603', 10)

INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02930', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS01638', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02037', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02867', 3)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS03411', 7)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02771', 8)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02979', 4)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02983', 6)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS02988', 9)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS03031', 10)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS03530', 5)
INSERT [dbo].[HocVien] ([MaKH], [MaNH], [Diem]) VALUES (14, N'PS03603', 10)


Select *from NhanVien;
Select *from ChuyenDe;
Select *from NguoiHoc;
Select *from KhoaHoc;
Select *from HocVien;