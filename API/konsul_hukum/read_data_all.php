<?php
require_once 'koneksi.php';

$sql = "SELECT * FROM konsul_hkm";

$r = mysqli_query($con, $sql);

$result = array();

while ($row = mysqli_fetch_array($r)) {
    array_push($result, array(
        "id" => $row['id'],
        "stasiun_radio" => $row['stasiun_radio'],
    ));
}

echo json_encode(array('result' => $result));
mysqli_close($con);
