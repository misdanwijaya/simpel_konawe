<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    
    //Mendapatkan nilai variable
    $nama_kantor ='Pelapor';
    $nama_pemohon = $_POST['nama_pemohon'];
    $jabatan ='Pemohon';
    $alamat = $_POST['alamat'];
    $telepon = $_POST['telepon'];
    $email = $_POST['email'];
    $permintaan_penyuluhan_hukum = $_POST['permintaan_penyuluhan_hukum'];

    $waktu_pelaksanaan = '01-01-2019 00:00:00';
    date_default_timezone_set('Asia/Jakarta');
    $newDate1 = date("Y-m-d H:i:s",time());

    $status = "belum";

    //pembuatan syntax sql
    $sql = "INSERT INTO penyuluhan_hkm (nama_kantor,nama_pelapor,jabatan, alamat, telepon, email, kegiatan, waktu,status_laporan)
    VALUES ('$nama_kantor','$nama_pemohon','$jabatan','$alamat', '$telepon', '$email', '$permintaan_penyuluhan_hukum','$newDate1','$status')";

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
