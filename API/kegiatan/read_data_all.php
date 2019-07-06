<?php
require_once 'koneksi.php';

$sql = "SELECT * FROM kegiatan";

$r = mysqli_query($con, $sql);

$result = array();

while ($row = mysqli_fetch_array($r)) {
    $newDate = date("d-m-Y H:i",strtotime($row['waktu']));
    array_push($result, array(
        "id" => $row['id'],
        "nama_kegiatan" => $row['nama_kegiatan'],
        "detail" => $row['detail'],
        "waktu" => $newDate,
    ));
}

echo json_encode(array('result' => $result));
mysqli_close($con);
