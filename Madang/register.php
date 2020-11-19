<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/register.css">

    <title>Madang - Daftar</title>
</head>

<body>

    <section class="register">
        <div class="card border-dark">
            <div class="row">
                <div class="col-5">
                    <div class="card-body left">
                        <div class="container d-flex flex-column">
                            <h1 class="card-title text-center">Selamat datang!</h1>
                            <p class="card-text text-center">Untuk mendaftar akun baru <br>Silahkan masukkan data diri anda.</p>
                            <img class="align-self-center" src="img/bg_card_register.jpg" alt="">
                            <p class="card-text text-center">Sudah memiliki akun? <a href="artikel.php">login</a></p>
                        </div>
                    </div>
                </div>
                <div class="col-7">
                    <div class="card-body">
                        <form method="POST" id="daftarForm">
                            <div class="form-group">
                                <label>Nama Depan</label>
                                <input type="text" name="firstName" id="firstName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nama Belakang</label>
                                <input type="text" name="lastName" id="lastName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" name="email" id="email" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Tanggal Lahir</label>
                                <input type="date" name="tanggalLahir" id="tanggalLahir" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Jenis Kelamin</label>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="jenisKelamin" id="jenisKelamin1" value=1 checked>
                                    <label class="form-check-label" for="jenisKelamin1">
                                        Laki-laki
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="jenisKelamin" id="jenisKelamin2" value=0>
                                    <label class="form-check-label" for="jenisKelamin2">
                                        Perempuan
                                    </label>
                                </div>
                            </div>
                            <button name="daftar" type="submit" class="col-12 btn btn-primary" form="daftarForm">Daftar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <?php
    if (isset($_POST['daftar'])) {
        var_dump($_POST['username']);
        include "koneksi.php";
        $kueri = "INSERT INTO user (username, password, namaLengkap, tanggalLahir, jenisKelamin, email) VALUES ('" . $_POST['username'] . "', '" . $_POST['password'] . "', '" . $_POST['firstName'] . " " . $_POST['lastName'] . "', '" . $_POST['tanggalLahir'] . "', '" . $_POST['jenisKelamin'] . "', '" . $_POST['email'] . "')";
        mysqli_query($koneksi, $kueri);
    }
    ?>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
</body>

</html>