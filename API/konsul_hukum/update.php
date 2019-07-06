<?php
if ($_SERVER['REQUEST_METHOD'] =='POST') {
    $nama = $_POST['nama'];
    $jabatan = $_POST['jabatan'];
    $alamat = $_POST['alamat'];
    $telepon = $_POST['telepon'];
    $email = $_POST['email'];
    $materi = $_POST['materi'];
    $waktu_pelaksanaan = $_POST['waktu_pelaksanaan'];

    require_once('koneksi.php');

    $sql = "UPDATE to konsul_hkm SET nama = '$nama', jabatan = '$jabatan', alamat = '$alamat', telepon = '$telepon', email = '$email'
    materi = '$materi', waktu_pelaksanan = '$waktu_pelaksanaan' WHERE id = $id;";

    if (msqli_query($con, $sql)) {
        echo 'Data berhasil di Update';
    } else {
        echo 'Data gagal di Update';
    }
    mysqli_close($con);
}
?>