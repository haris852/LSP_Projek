<?php
include 'connection.php';

$username = null;
$nama = null;
$alamat = null;
$tempat_lahir = null;
$tgl_lahir = null;
$no_telp = null;
$email = null;
$password = null;




if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $username = $_POST['username'];
    $nama = $_POST['nama'];
    $alamat = $_POST['alamat'];
    $tempat_lahir = $_POST['tempat_lahir'];
    $tgl_lahir = $_POST['tgl_lahir'];
    $no_telp = $_POST['no_telp'];

    $email = $_POST['email'];
    $password = $_POST['password'];
}

if ($_SERVER['REQUEST_METHOD'] == 'GET') {



    $username = $_GET['username'];
    $nama = $_GET['nama'];
    $alamat = $_GET['alamat'];
    $tempat_lahir = $_GET['tempat_lahir'];
    $tgl_lahir = $_GET['tgl_lahir'];
    $no_telp = $_GET['no_telp'];

    $email = $_GET['email'];
    $password = $_GET['password'];
}



$sql = "INSERT INTO `tb_user`( `username`, `nama`, `alamat` , `tempat_lahir`, `tgl_lahir`, `no_telp`, `email`, `password`) VALUES (
		'$username', 
        '$nama',
        '$alamat',
        '$tempat_lahir',
        '$tgl_lahir',
        '$no_telp', 
        '$email', 
        '$password'
)";


$result = mysqli_query($conn, $sql);

if ($result) {

    $response = array("response" => "success");
    echo json_encode($response);
} else {
    $response = array("response" => "failure");
    echo json_encode($response);
}
