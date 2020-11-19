<?php
$host   = "localhost";
$user   = "root";
$psw    = "";
$db_name = "madang";
$koneksi = mysqli_connect($host, $user, $psw, $db_name);
if ($koneksi->connect_errno) {
    echo "Failed to connect to MySQL: " . $koneksi->connect_error;
    exit();
}
