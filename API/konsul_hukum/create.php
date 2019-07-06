<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    //Mendapatkan nilai variable
    $stasiun_radio = $_POST['stasiun_radio'];
    $nama = $_POST['nama'];
    $jabatan = $_POST['jabatan'];
    $alamat = $_POST['alamat'];
    $telepon = $_POST['telepon'];
    $email = $_POST['email'];
    $materi = $_POST['materi'];
    $waktu_pelaksanaan = $_POST['waktu_pelaksanaan'];

    //Convert Tanggal
    $newdate = date("Y-m-d H:i:s", strtotime($waktu_pelaksanaan));

    $status = "belum";

    //pembuatan syntax sql
    $sql = "INSERT INTO konsul_hkm (stasiun_radio, nama_lengkap, jabatan, alamat, telepon, email, materi, waktu,status_laporan)
    VALUES ('$stasiun_radio', '$nama','$jabatan', '$alamat', '$telepon', '$email', '$materi', '$newdate', '$status')";

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
