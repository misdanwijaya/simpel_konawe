<?php
$id = $_GET['id'];

require_once 'koneksi.php';

$sql = "DELETE FROM konsul_hkm WHERE id = $id;";

if (mysqli_query($con, $sql)) {
    echo 'Data berhasil dihapus';
} else {
    echo 'Data gagal dihapus';
}
mysqli_close($con);
