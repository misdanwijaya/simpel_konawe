<?php

//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
$id = $_GET['id'];

//Importing database
require_once 'koneksi.php';

//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
$sql = "SELECT * FROM konsul_hkm WHERE id=$id";

//Mendapatkan Hasil
$r = mysqli_query($con, $sql);

//Memasukkan Hasil Kedalam Array
$result = array();
$row = mysqli_fetch_array($r);
$newDate = date("d-m-Y H:i",strtotime($row['waktu']));
array_push($result, array(
    "id" => $row['id'],
    "stasiun_radio" => $row['stasiun_radio'],
    "nama" => $row['nama_lengkap'],
    "jabatan" => $row['jabatan'],
    "alamat" => $row['alamat'],
    "telepon" => $row['telepon'],
    "email" => $row['email'],
    "materi" => $row['materi'],
    "waktu_pelaksanaan" => $newDate,
));

//Menampilkan dalam format JSON
echo json_encode(array('result' => $result));

mysqli_close($con);
