<?php

include "connection.php";

$username = null;
$nama = null;
$alamat = null;
$tempat_lahir = null;
$tgl_lahir = null;
$no_telp = null;
$email = null;
$password = null;
$user_id = null;


if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];
}


if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    $username = $_GET['username'];
    $password = $_GET['password'];
}



$sql_select = "SELECT * FROM `tb_user` WHERE `username`='$username' && `password`= '$password' LIMIT 1";
$result_select = mysqli_query($conn, $sql_select);

$result_count = mysqli_num_rows($result_select);

if ($result_count > 0) {
    while ($row = mysqli_fetch_array($result_select)) {
        $username = $row['username'];
        $nama = $row['nama'];
        $alamat = $row['alamat'];
        $tempat_lahir = $row['tempat_lahir'];
        $tgl_lahir = $row['tgl_lahir'];
        $no_telp = $row['no_telp'];
        $email = $row['email'];
        $password = $row['password'];
        $user_id = $row['user_id'];


        // $name = $first_name." ".$last_name;

        $UserDetails = array(
            "user_id" => $user_id,
            "username" => $username,
            "nama" => $nama,
            "alamat" => $alamat,
            "tempat_lahir" => $tempat_lahir,
            "tgl_lahir" => $tgl_lahir,
            "no_telp" => $no_telp,
            "email" => $email

        );
    }
}

if ($result_count) {
    $response = array("response" => $UserDetails);
    echo json_encode($response);
} else {
    $response = array("response" => "failure");
    echo json_encode($response);
}
