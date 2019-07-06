<?php

//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
$id = $_GET['id'];

//Importing database
require_once 'koneksi.php';

//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
$sql = "SELECT * FROM kegiatan WHERE id=$id";

//Mendapatkan Hasil
$r = mysqli_query($con, $sql);

//Memasukkan Hasil Kedalam Array
$result = array();
$row = mysqli_fetch_array($r);
array_push($result, array(
    "id" => $row['id'],
    "nama_kegiatan" => $row['nama_kegiatan'],
    "detail" => $row['detail'],
    "waktu" => $row['waktu'],
));

//Menampilkan dalam format JSON
echo json_encode(array('result' => $result));

mysqli_close($con);
