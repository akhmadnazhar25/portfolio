<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="css/artikel.css">

  <title>Madang - Artikel</title>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <div class="container">

      <a class="navbar-brand" href="#">Madang</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="artikel.php">Artikel</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="quiz.html">Quiz</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Tentang Kami</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Kontak</a>
          </li>
        </ul>
        <button class="btn btn-outline-success" data-toggle="modal" data-target="#loginModal">Login</button>
      </div>
    </div>
  </nav>

  <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="container">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">LOGIN</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" id="username" class="form-control">
              </div>
              <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" id="password" class="form-control">
              </div>
            </form>
          </div>
          <div class="modal-footer d-flex flex-column">
            <div class="row">
              <p class="mb-0">Belum memiliki akun? <a href="register.php">daftar</a></p>
            </div>
            <div class="row w-100">
              <button type="button" class="btn btn-danger ml-auto" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary ml-2">Login</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <section class="artikel">
    <h1>ARTIKEL</h1>
  </section>

  <section class="konten">
    <div class="container">
      <div class="row mb-3">
        <div class="col-12 col-md-7">
          <div class="nav-konten">
            <ul>
              <li onclick="location.href='artikel.php';">All</li>
              <li onclick="location.href='artikel.php?kategori=news';">News</li>
              <li onclick="location.href='artikel.php?kategori=resep';">Resep</li>
            </ul>
          </div>
        </div>
        <div class="col-12 col-md-5">
          <form method="POST" action="artikel.php">
            <div class="input-group ml-auto">
              <input type="text" class="form-control" placeholder="Judul Konten" name="judul" aria-label="Recipient's username" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-outline-primary" type="submit">Cari</button>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="row mt-2">
        <?php
        if (!isset($_GET['page'])) {
          $_GET['page'] = 1;
        }
        if ($_GET['page'] == 1) {
          $i = 0;
        } else {
          $i = ($_GET['page'] - 1) * 6;
        }

        function tampil_data($kategori = "", $i)
        {
          $batas = 0;
          include "koneksi.php";
          $artikel = mysqli_query($koneksi, "SELECT * FROM artikel $kategori ");
          $jumlah_artikel = mysqli_num_rows($artikel);
          global $jumlah_halaman;
          $jumlah_halaman = ceil(mysqli_num_rows($artikel) / 6);
          while ($brs = mysqli_fetch_assoc($artikel)) {
            $temp[] = $brs;
          }
          for ($x = 0; $x < 6; $x++) {
            if ($i < $jumlah_artikel) {
              $brs = $temp[$i];
              $i++;
              echo '
              <div class="col-12 col-md-4 d-flex align-items-center justify-content-center mt-2">
                <div class="card">
                  <img class="card-img-top" src="' . $brs['img_thumbnail'] . '" alt="Card image cap">
                  <div class="card-body">
                    <p class="card-text">' . $brs['judul'] . '</p>
                  </div>
                </div>
              </div>
              ';
            } else {
            }
            $batas++;
            if ($batas == 3 && $i != $jumlah_artikel) {
              echo '
              </div>
              <div class="row mt-3">
              ';
              $batas = 0;
            }
          }
        }
        if (isset($_POST['judul'])) {
          tampil_data("WHERE judul LIKE '%" . $_POST['judul'] . "%'", $i);
        } elseif (isset($_GET['kategori'])) {
          tampil_data("WHERE kategori='" . $_GET['kategori'] . "'", $i);
        } else {
          tampil_data("", $i);
        }
        echo '
        </div>
        <nav class="mt-3" aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item ' . ($_GET['page'] == 1 ? "disabled" : "") . '">
              <a class="page-link" href="artikel.php?' . (isset($_GET['kategori']) ? "kategori=" . $_GET['kategori'] . "&amp;" : "") . 'page=' . ($_GET['page'] - 1) . '" tabindex="-1">Previous</a>
            </li>
            ' . ($jumlah_halaman >= 1 ? '
              <li class="page-item ' . ($_GET['page'] == 1 ? "active" : "") . '"><a class="page-link" href=' . ($_GET['page'] == 1 ? "artikel.php?" . (isset($_GET['kategori']) ? "kategori=" . $_GET['kategori'] . "&amp;" : "") . "page=1" : "artikel.php?" . (isset($_GET['kategori']) ? "kategori=" . $_GET['kategori'] . "&amp;" : "") . "page=" . ($_GET['page'] - 1) . "") . '>' . ($_GET['page'] == 1 ? "1" : $_GET['page'] - 1) . '</a></li>
              ' . ($_GET['page'] <= $jumlah_halaman && $jumlah_halaman >= 2 ? '
                <li class=" page-item ' . ($_GET['page'] > 1 ? "active" : "") . '"><a class="page-link" href="artikel.php?' . (isset($_GET['kategori']) ? "kategori=" . $_GET['kategori'] . "&amp;" : "") . 'page=' . ($_GET['page'] == 1 ? "2" : $_GET['page']) . '">' . ($_GET['page'] == 1 ? "2" : $_GET['page']) . '</a></li>
                ' . ($_GET['page'] != $jumlah_halaman && $jumlah_halaman >= 3 ? '
                  <li class="page-item"><a class="page-link" href="artikel.php?' . (isset($_GET['kategori']) ? "kategori=" . $_GET['kategori'] . "&amp;" : "") . 'page=' . ($_GET['page'] == 1 ? "3" : $_GET['page'] + 1) . '">' . ($_GET['page'] == 1 ? "3" : $_GET['page'] + 1) . '</a></li>
                ' : "") . '
              ' : "") . '
            ' : "Tidak Ada Artikel") . '
            <li class="page-item ' . ($_GET['page'] == $jumlah_halaman ? "disabled" : "") . '">
              <a class="page-link" href="artikel.php?' . (isset($_GET['kategori']) ? "kategori=" . $_GET['kategori'] . "&amp;" : "") . 'page=' . ($_GET['page'] + 1) . '">Next</a>
            </li>
          </ul>
        </nav>
        ';
        ?>

      </div>
  </section>

  <footer class="bg-dark">
    <p><span>Madang</span></p>
    <p>&copy;2020 Madang. Kelompok 2</p>
  </footer>

  <!-- Custom JavaScript -->
  <script>
    $("#daftarModal").on('show.bs.modal', function(e) {
      $("#loginModal").modal("hide");
    });
  </script>
  <!-- Bootstrap JavaScript -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>

</html>