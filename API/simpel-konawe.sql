-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Jun 2019 pada 05.49
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simpel-konawe`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `nama`, `foto`) VALUES
(1, 'auwfar', 'f0a047143d1da15b630c73f0256d5db0', 'Achmad Chadil Auwfar', 'Koala.jpg'),
(2, 'ozil', 'f4e404c7f815fc68e7ce8e3c2e61e347', 'Mesut ', 'profil2.jpg'),
(3, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Admin ', 'profil1.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kegiatan`
--

CREATE TABLE `kegiatan` (
  `id` int(11) NOT NULL,
  `nama_kegiatan` varchar(100) NOT NULL,
  `detail` varchar(100) NOT NULL,
  `waktu` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kegiatan`
--

INSERT INTO `kegiatan` (`id`, `nama_kegiatan`, `detail`, `waktu`) VALUES
(17, 'Matoa', 'kjkjkjkjl', '2019-06-26 20:30:48');

-- --------------------------------------------------------

--
-- Struktur dari tabel `konsul_hkm`
--

CREATE TABLE `konsul_hkm` (
  `id` int(11) NOT NULL,
  `stasiun_radio` varchar(100) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telepon` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `materi` varchar(100) NOT NULL,
  `waktu` datetime NOT NULL,
  `status_laporan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `konsul_hkm`
--

INSERT INTO `konsul_hkm` (`id`, `stasiun_radio`, `nama_lengkap`, `jabatan`, `alamat`, `telepon`, `email`, `materi`, `waktu`, `status_laporan`) VALUES
(10, 'Ardan', 'Misdan', 'IT', 'Jakarta', '089608980946', 'misdan.wijaya07@gmail.com', 'Ada deh', '2019-06-15 14:00:00', 'belum'),
(14, '90.9ners', 'Dimasta', 'IT', 'Katapang', '9999999', 'iT@gmail.com', 'Keliling bandung', '2019-07-31 14:30:30', 'sedang'),
(16, 'Kejari', 'Revina', 'IT', 'Kediri', '1234', 'kokicilik@gmail.com', 'Nangkap belut', '2019-07-04 15:10:19', 'belum'),
(17, 'Paramuda', 'Masud', 'Ituh', 'Jakarta', '+6289608980946', 'misdan.wijaya07@gmail.com', 'aaa', '2019-06-28 23:50:39', 'selesai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penyuluhan_hkm`
--

CREATE TABLE `penyuluhan_hkm` (
  `id` int(11) NOT NULL,
  `nama_kantor` varchar(100) NOT NULL,
  `nama_pelapor` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telepon` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `kegiatan` varchar(100) NOT NULL,
  `waktu` datetime NOT NULL,
  `status_laporan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penyuluhan_hkm`
--

INSERT INTO `penyuluhan_hkm` (`id`, `nama_kantor`, `nama_pelapor`, `jabatan`, `alamat`, `telepon`, `email`, `kegiatan`, `waktu`, `status_laporan`) VALUES
(14, 'Misdan Wijaya', 'Misdan', 'IT', 'Katapang', '123', 'misdan.wijaya07@gmail.com', 'adadaf', '2019-06-13 06:30:00', 'selesai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tp4d`
--

CREATE TABLE `tp4d` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nama_kepala` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telepon` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `kegiatan` varchar(100) NOT NULL,
  `waktu` datetime NOT NULL,
  `status_laporan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tp4d`
--

INSERT INTO `tp4d` (`id`, `nama`, `nama_kepala`, `jabatan`, `alamat`, `telepon`, `email`, `kegiatan`, `waktu`, `status_laporan`) VALUES
(8, 'Matoa', 'Misdan Wijaya', 'hhhh', 'Propelat Barat V', '0000', 'misdan.wijaya07@gmail.com', 'Melakukan penyuluhan kepada masyarakat desa', '2019-07-21 15:55:45', 'sedang');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `kegiatan`
--
ALTER TABLE `kegiatan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `konsul_hkm`
--
ALTER TABLE `konsul_hkm`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `penyuluhan_hkm`
--
ALTER TABLE `penyuluhan_hkm`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tp4d`
--
ALTER TABLE `tp4d`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `kegiatan`
--
ALTER TABLE `kegiatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT untuk tabel `konsul_hkm`
--
ALTER TABLE `konsul_hkm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT untuk tabel `penyuluhan_hkm`
--
ALTER TABLE `penyuluhan_hkm`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `tp4d`
--
ALTER TABLE `tp4d`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
