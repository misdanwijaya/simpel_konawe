<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    //Mendapatkan nilai variable
    $nama_instansi = $_POST['nama_instansi'];
    $nama_kepala_instansi = $_POST['nama_kepala_instansi'];
    $jabatan = "Pelapor";
    $alamat = $_POST['alamat'];
    $telepon = $_POST['telepon'];
    $email = $_POST['email'];
    $kegiatan_diminta_didampingi = $_POST['kegiatan_diminta_didampingi'];
    $nilai_kegiatan = $_POST['nilai_kegiatan'];
    $status = "belum";

    $waktu_pelaksanaan = '01-01-2019 00:00:00';
    $newDate1 = date("Y-m-d H:i:s", strtotime($waktu_pelaksanaan));

    //pembuatan syntax sql
    $sql = "INSERT INTO tp4d (nama, nama_kepala, jabatan,alamat, telepon, email, kegiatan,waktu,status_laporan)
    VALUES ('$nama_instansi', '$nama_kepala_instansi','$jabatan','$alamat', '$telepon', '$email', '$kegiatan_diminta_didampingi', '$newDate1','$status')";

    //import file koneksi database
    require_once 'koneksi.php';

    //eksekusi query database
    if (mysqli_query($con, $sql)) {
        echo 'Data berhasil ditambahkan';
    } else {
        echo 'Data gagal ditambahkan';
    }
    mysqli_close($con);
}
